package com.example.demo.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.vo.UserVo;

@Repository("userDao")
public class UserDao {
	
	@Autowired
	SqlSession sqlSession;

	public void signup(UserVo vo) {
		sqlSession.insert("user.signup",vo);
	}

	public int idcheck(String user_id) {
		int check = sqlSession.selectOne("user.idcheck",user_id);
		return check;
	}

	public UserVo getuser(String id, String pw) {
		HashMap map = new HashMap();
		map.put("id", id);
		map.put("pw", pw);
		UserVo user = sqlSession.selectOne("user.getuser",map);
		return user;
	}


	
}
