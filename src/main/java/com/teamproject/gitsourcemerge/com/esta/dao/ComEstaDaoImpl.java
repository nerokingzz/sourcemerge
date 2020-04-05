package com.teamproject.gitsourcemerge.com.esta.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.teamproject.gitsourcemerge.com.esta.vo.ComInfoVO;

@Repository
public class ComEstaDaoImpl implements ComEstaDao {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void comEstaRequest(ComInfoVO comInfoVo) {
		sqlSession.insert("com_esta.com_esta_insert", comInfoVo);
		
	}

	@Override
	public List<Map<String, Object>> comEstaRequestList(Map<String, String> user_info) {
		
		//관리자 구분
		System.out.println("user_id는" + user_info.get("user_id"));
		System.out.println("user_position는" + user_info.get("user_position"));
//		if (user_info.get("user_position").equals("admin")) {
//			user_id=null;
//		}
		
		List<Map<String, Object>> requestList=sqlSession.selectList("com_esta.com_esta_request_list", user_info);
		return requestList;
	}
}
