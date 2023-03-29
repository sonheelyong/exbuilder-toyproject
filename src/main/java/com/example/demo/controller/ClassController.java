package com.example.demo.controller;

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

@Controller
public class ClassController {
	
  @Autowired
  ClassService classService;
  
  @PostMapping("/getclass")
  public View getClass( DataRequest dataRequest) {
	  List<ClassVo> vo = classService.getCs();
	  dataRequest.setResponse("class", vo);
	  
	  return new JSONDataView();
  }
  
  @PostMapping("/searchclass")
  public View searchClass(DataRequest dataRequest) {
	  ParameterGroup param = dataRequest.getParameterGroup("searchname");
	  String name = param.getValue("class_name");
	  List<ClassVo> vo = classService.searchList(name);
	  dataRequest.setResponse("class", vo);
	 
	  return new JSONDataView();
  }
  
  @PostMapping("/regi")
  public View regiClass(@SessionAttribute(name = "logInUser", required = false)UserVo user, DataRequest dataRequest) {
	  ParameterGroup param = dataRequest.getParameterGroup("selectcode");
	  int code = Integer.parseInt(param.getValue("class_name"));
	  String user_name = user.getUser_name();
	  
//	  classService.regiClass(code,user_name);
	  
	  return new JSONDataView();
  }
}
