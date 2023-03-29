package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.vo.UserVo;

@Service
public class UserService {

	@Autowired
	UserDao userDao;

	public void signup(UserVo vo) {
		userDao.signup(vo);
	}

	public int idcheck(String user_id) {
		int check = userDao.idcheck(user_id);
		return check;
	}

	public UserVo getuser(String id, String pw) {
         UserVo user = userDao.getuser(id,pw);

		return user;
	}
}
