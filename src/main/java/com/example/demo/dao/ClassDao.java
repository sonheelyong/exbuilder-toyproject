package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.vo.ClassVo;

@Repository("classDao")
public class ClassDao {
     @Autowired
     SqlSession sqlSession;

	public List<ClassVo> getCs() {
		List<ClassVo> vo = sqlSession.selectList("class.getclass");
		return vo;
	}

	public List<ClassVo> searchList(String name) {
		List<ClassVo> vo = sqlSession.selectList("class.serchclass",name);
		return vo;
	}
}
