package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.View;

import com.cleopatra.protocol.data.DataRequest;
import com.cleopatra.protocol.data.ParameterGroup;
import com.cleopatra.spring.JSONDataView;
import com.example.demo.service.ClassService;
import com.example.demo.vo.ClassVo;
import com.example.demo.vo.UserVo;
import com.example.demo.vo.ClassDTO;
import com.example.demo.vo.RegiVo;

@Controller
public class ClassController {
	
  @Autowired
  ClassService classService;
  
  // 전체 강의 조회
  @PostMapping("/getclass")
  public View getClass(@SessionAttribute(name = "logInUser", required = false)UserVo user, DataRequest dataRequest) {
	  String user_id = user.getUser_id();
	  
	  List<ClassDTO> vo = classService.getCs(user_id);
	  dataRequest.setResponse("class", vo);
	
	  return new JSONDataView();
  }
  
  // 검색 강의 조회
  @PostMapping("/searchclass")
  public View searchClass(@SessionAttribute(name = "logInUser", required = false)UserVo user, DataRequest dataRequest) {
	  String user_id = user.getUser_id();
	  
	  ParameterGroup param = dataRequest.getParameterGroup("searchname");
	  String name = param.getValue("class_name");
	  List<ClassDTO> vo = classService.searchList(name,user_id);
	  dataRequest.setResponse("class", vo);
	  
	  return new JSONDataView();
  }
  
  // 코드로 강의 조회
  @PostMapping("/getcodeclass")
  public View getcodeclass(DataRequest dataRequest) {
	  
	  ParameterGroup param = dataRequest.getParameterGroup("code");
	  int code = Integer.parseInt(param.getValue("code"));
	 
	  List<RegiVo> regi = classService.getcoderegi(code); 
	  dataRequest.setResponse("regi_user", regi);
	  
	  ClassVo classVo = classService.getcodeclass(code); 
	  String class_name = classVo.getClass_name();
	  String teacher = classVo.getTeacher();
	  String s_date = classVo.getS_date();
	  String e_date = classVo.getE_date();
	  
	  Map<String, Object> map = new HashMap<>();
	  map.put("class_name", class_name);
	  map.put("teacher", teacher);
	  map.put("s_date", s_date);
	  map.put("e_date", e_date);
	  dataRequest.setResponse("regiclass", map);
	  
	  return new JSONDataView();
  }
  
  // 수강 신청
  @PostMapping("/regi")
  public View regiClass(@SessionAttribute(name = "logInUser", required = false)UserVo user, DataRequest dataRequest) {
	  ParameterGroup param = dataRequest.getParameterGroup("selectcode");
	  int code = Integer.parseInt(param.getValue("code"));
	  String user_id = user.getUser_id();
	  
	  classService.regiClass(code,user_id);
	  
	  return new JSONDataView();
  }
  
  // 중복 신청 체크
   @PostMapping("/regicheck")
   public View regiCheck(@SessionAttribute(name = "logInUser", required = false)UserVo user, DataRequest dataRequest) {
	   ParameterGroup param = dataRequest.getParameterGroup("selectcode");
		  int code = Integer.parseInt(param.getValue("code"));
		  String user_id = user.getUser_id();
		  
		  int check = classService.checkClass(code,user_id);
		  Map<String, Object> map = new HashMap<>();
		  map.put("check", check);
		  dataRequest.setResponse("regicheck", map);
		  
	   return new JSONDataView();
   }
  
   // 수강 신청 취소
   @PostMapping("/cancle")
   public View cancleClass(@SessionAttribute(name = "logInUser", required = false)UserVo user, DataRequest dataRequest) {
	   ParameterGroup param = dataRequest.getParameterGroup("selectcode");
		  int code = Integer.parseInt(param.getValue("code"));
		  String user_id = user.getUser_id();
		  
		  classService.cancleClass(code,user_id);
	   
	   return new JSONDataView();
   }
   
   // 강의 추가, 수정 전 중복 체크
   @PostMapping("/codecheck")
   public View codecheck( DataRequest dataRequest ) {
	   
	   ParameterGroup param = dataRequest.getParameterGroup("selectcode");
	   int code = Integer.parseInt(param.getValue("code"));
	   int check = classService.chceckCode(code);
	   
	   Map<String, Object> map = new HashMap<>();
	   map.put("cknum", check);
	   dataRequest.setResponse("codecheck", map);
	   
	   return new JSONDataView();
   }
   
   // 강의 추가 (관리자용)
   @PostMapping("/addclass")
   public View addclass( DataRequest dataRequest ) {
	   ParameterGroup param = dataRequest.getParameterGroup("addclass");
	   ClassVo vo = new ClassVo();
	   
	   vo.setClass_name(param.getValue("class_name"));
	   vo.setTeacher(param.getValue("teacher"));
	   vo.setS_date(param.getValue("s_date"));
	   vo.setE_date(param.getValue("e_date"));
	   
	   classService.addclass(vo);
	   
	   return new JSONDataView();
   }
   
   
   // 강의 수정 (관리자용)
   @PostMapping("/update")
   public View update( DataRequest dataRequest ) {
	   
	   ParameterGroup param = dataRequest.getParameterGroup("changeclass");
	   ClassVo vo = new ClassVo();
	   vo.setCode(Integer.parseInt(param.getValue("code")));
	   vo.setClass_name(param.getValue("class_name"));
	   vo.setTeacher(param.getValue("teacher"));
	   vo.setS_date(param.getValue("s_date"));
	   vo.setE_date(param.getValue("e_date"));
	   
	   classService.updateclass(vo);
	   
	   return new JSONDataView();
   }
  
  // 강의 삭제 (관리자용)
   @PostMapping("/deleteclass")
   public View deleteclass( DataRequest dataRequest ) {
	   ParameterGroup param = dataRequest.getParameterGroup("selectcode");
	   int code = Integer.parseInt(param.getValue("code"));
	   
	   classService.deleteclass(code);
	   
	   return new JSONDataView();
   }
  
  // regi_no로 수강취소 (관리자용)
   @PostMapping("/deleteregi_no")
   public View deleteregi_no(DataRequest dataRequest) {
	   ParameterGroup param = dataRequest.getParameterGroup("regi_no");
	   int regi_no = Integer.parseInt(param.getValue("regi_no"));
	   classService.deleteregi_no(regi_no);
	   
	   return new JSONDataView();
   }
   
  // 나의 수강신청 목록
   @PostMapping("/getRegiList")
   public View getRegiList(@SessionAttribute(name = "logInUser", required = false)UserVo user, DataRequest dataRequest) {
	   String user_id = user.getUser_id();
	   List<ClassDTO> list = classService.getRegiList(user_id);
	   
	   dataRequest.setResponse("regiList", list);
	   System.out.println(list);
	   
	   return new JSONDataView();
   }
}
