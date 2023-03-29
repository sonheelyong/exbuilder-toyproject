package com.example.demo.controller;

import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.cleopatra.protocol.data.DataRequest;
import com.cleopatra.protocol.data.ParameterGroup;
import com.cleopatra.spring.JSONDataView;
import com.example.demo.service.UserService;
import com.example.demo.vo.UserVo;

import org.springframework.web.servlet.View;
import java.util.ArrayList;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	// 회원가입
	@PostMapping("/signup")
	public void signup(DataRequest dataRequest) {
		ParameterGroup param = dataRequest.getParameterGroup("dm1");
		
		String user_id = param.getValue("user_id");
		String user_name = param.getValue("user_name");
		String user_pw = param.getValue("user_pw");
		
		UserVo vo = new UserVo();
		vo.setUser_id(user_id);
		vo.setUser_name(user_name);
		vo.setUser_pw(user_pw);
	    
		userService.signup(vo);
		
	}
	
	// 아이디 중복확인
	@PostMapping("/idcheck")
	public View idcheck(DataRequest dataRequest) {
		ParameterGroup param = dataRequest.getParameterGroup("dm1");
		
		String user_id = param.getValue("user_id");
		int check = userService.idcheck(user_id);
		
		Map<String, Object> map = new HashMap<>();
		map.put("idcheck", check);
		dataRequest.setResponse("dm2", map);
		
		return new JSONDataView();
	}
     
	// 로그인
	@PostMapping("/login")
	public View login(DataRequest dataRequest, HttpServletRequest request, HttpSession session) {
		
		ParameterGroup param = dataRequest.getParameterGroup("login");
		String id = param.getValue("insert_id");
		String pw = param.getValue("insert_pw");
		
		UserVo user = userService.getuser(id,pw);
		
		if(user == null) {
			System.out.println("로그인 실패");
			
		}else {
		Map<String, Object> map = new HashMap<>();
		map.put("user_id", user.getUser_id());
		map.put("user_name", user.getUser_name());
		map.put("user_role", user.getUser_role());
		
		dataRequest.setResponse("user", map);
		
		session.setAttribute("logInUser", user);
		}
		return new JSONDataView();
	}
	
	// 로그인된 아이디
	@GetMapping("/getusername")
	public View getUserName(@SessionAttribute(name = "logInUser", required = false)UserVo user, DataRequest dataRequest, HttpSession session) {
		String user_name = user.getUser_name();
		String user_id = user.getUser_id();
		
		System.out.println(user_name);
		System.out.println(user_id);
		
		Map<String, Object> map = new HashMap<>();
		map.put("user_id", user_id);
		map.put("user_name", user_name);
		dataRequest.setResponse("loginuser", map);
		
		return new JSONDataView();
	}
	
	// 로그아웃
	@PostMapping("/logout")
	public void logOut(HttpSession session) {
	    session.invalidate();
	}
}
    