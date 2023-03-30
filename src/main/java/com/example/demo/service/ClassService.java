package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ClassDao;
import com.example.demo.vo.ClassVo;
import com.example.demo.vo.ClassDTO;
@Service
public class ClassService {
     @Autowired
     ClassDao classDao;

	public List<ClassDTO> getCs(String user_id) {
		List<ClassDTO> vo = classDao.getCs(user_id);
		return vo;
	}

	public List<ClassDTO> searchList(String name, String user_id) {
		List<ClassDTO> vo = classDao.searchList(name,user_id);
		return vo;
	}

	public void regiClass(int code, String user_id) {
	    classDao.regiClass(code,user_id);
		
	}

	public int checkClass(int code, String user_id) {
		int check = classDao.checkClass(code,user_id);
		return check;
	}

	public void cancleClass(int code, String user_id) {
		classDao.cancleClass(code,user_id);
		
	}

	public void updateclass(ClassVo vo) {
		classDao.updateclass(vo);
		
	}

	public int chceckCode(int code) {
		int check = classDao.checkCode(code);
		return check;
	}

	public void addclass(ClassVo vo) {
        classDao.addclass(vo);
		
	}

	public void deleteclass(int code) {
		classDao.deleteclass(code);
		
	}
}
