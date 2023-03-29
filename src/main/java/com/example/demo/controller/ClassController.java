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

@Controller
public class ClassController {
	
  @Autowired
  ClassService classService;
  
  // 전체 강의 조회
  @PostMapping("/getclass")
  public View getClass( DataRequest dataRequest) {
	  List<ClassDTO> vo = classService.getCs();
	  dataRequest.setResponse("class", vo);
	  
	  return new JSONDataView();
  }
  
  // 검색 강의 조회
  @PostMapping("/searchclass")
  public View searchClass(DataRequest dataRequest) {
	  ParameterGroup param = dataRequest.getParameterGroup("searchname");
	  String name = param.getValue("class_name");
	  List<ClassVo> vo = classService.searchList(name);
	  dataRequest.setResponse("class", vo);
	 
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
		  
		  System.out.println("체크"+check);
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
  
  
  
  
  
  
  
  
}
