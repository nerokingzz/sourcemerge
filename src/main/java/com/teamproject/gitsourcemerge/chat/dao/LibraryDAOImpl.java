package com.teamproject.gitsourcemerge.chat.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.teamproject.gitsourcemerge.chat.vo.BookVO;
import com.teamproject.gitsourcemerge.chat.vo.MemberVO;



@Component("libraryDAO")
public class LibraryDAOImpl implements LibraryDAO{
	//@Resource(name = "sqlSessionFactory")
	@Autowired
	private SqlSession sqlSession;

	@Override
	public MemberVO searchMember(String id) throws DataAccessException{
		
		MemberVO member = sqlSession.selectOne(id);
		
		return member;
	}

	@Override
	public BookVO borrow(MemberVO vo) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
