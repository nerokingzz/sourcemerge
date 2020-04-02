package com.teamproject.gitsourcemerge.chat.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.teamproject.gitsourcemerge.chat.vo.BookVO;
import com.teamproject.gitsourcemerge.chat.vo.MemberVO;


@Service("libraryService")
@Transactional(propagation = Propagation.REQUIRED)
public class LibraryServiceImpl implements LibraryService {

	@Override
	public MemberVO searchMember(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookVO borrow(MemberVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
