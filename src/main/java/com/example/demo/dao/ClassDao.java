package com.example.demo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.vo.ClassVo;
import com.example.demo.vo.ClassDTO;

@Repository("classDao")
public class ClassDao {
     @Autowired
     SqlSession sqlSession;

	public List<ClassDTO> getCs() {
		List<ClassDTO> vo = sqlSession.selectList("class.getclass");
		return vo;
	}

	public List<ClassVo> searchList(String name) {
		List<ClassVo> vo = sqlSession.selectList("class.serchclass",name);
		return vo;
	}

	public void regiClass(int code, String user_id) {
		HashMap map = new HashMap();
		map.put("code", code);
		map.put("user_id", user_id);
		sqlSession.insert("class.regiClass", map);
		
	}

	public int checkClass(int code, String user_id) {
		HashMap map = new HashMap();
		map.put("code", code);
		map.put("user_id", user_id);
		
		int check = sqlSession.selectOne("class.checkClass", map);

		return check;
	}

	public void cancleClass(int code, String user_id) {
		HashMap map = new HashMap();
		map.put("code", code);
		map.put("user_id", user_id);
		sqlSession.delete("class.cancle", map);
		
	}
}
