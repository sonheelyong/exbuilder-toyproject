package com.example.demo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.vo.ClassVo;
import com.example.demo.vo.RegiVo;
import com.example.demo.vo.ClassDTO;

@Repository("classDao")
public class ClassDao {
     @Autowired
     SqlSession sqlSession;

	public List<ClassDTO> getCs(String user_id) {
		List<ClassDTO> vo = sqlSession.selectList("class.getclass",user_id);
		return vo;
	}

	public List<ClassDTO> searchList(String name, String user_id) {
		HashMap map = new HashMap();
		map.put("name", name);
		map.put("user_id", user_id);
		List<ClassDTO> vo = sqlSession.selectList("class.serchclass",map);
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

	public void updateclass(ClassVo vo) {
        sqlSession.update("class.updateclass",vo);
	}

	public int checkCode(int code) {
		int check = sqlSession.selectOne("class.checkCode",code);
		return check;
	}

	public void addclass(ClassVo vo) {
		sqlSession.insert("class.addclass",vo);
		
	}

	public void deleteclass(int code) {
		sqlSession.delete("class.deleteclass",code);
		
	}

	public List<RegiVo> getcoderegi(int code) {
		List<RegiVo> regi = sqlSession.selectList("class.getcoderegi", code);
		return regi;
	}

	public ClassVo getcodeclass(int code) {
		ClassVo classVo = sqlSession.selectOne("class.getcodeclass", code);
		return classVo;
	}

	public void deleteregi_no(int regi_no) {
		sqlSession.delete("class.deleteregi_no",regi_no);
		
	}

	public List<ClassDTO> getRegiList(String user_id) {
		List<ClassDTO> list = sqlSession.selectList("class.getRegiList", user_id);
		return list;
	}
}
