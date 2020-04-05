package com.teamproject.gitsourcemerge.chat.dao;

import com.teamproject.gitsourcemerge.chat.vo.BookVO;
import com.teamproject.gitsourcemerge.chat.vo.MemberVO;

public interface LibraryDAO {
	public MemberVO searchMember(String id);
	public BookVO borrow(MemberVO vo);
}
