package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ClassDao;
import com.example.demo.vo.ClassVo;

@Service
public class ClassService {
     @Autowired
     ClassDao classDao;

	public List<ClassVo> getCs() {
		List<ClassVo> vo = classDao.getCs();
		return vo;
	}

	public List<ClassVo> searchList(String name) {
		List<ClassVo> vo = classDao.searchList(name);
		return vo;
	}
}
