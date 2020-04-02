package com.teamproject.gitsourcemerge.chat.service;

import com.teamproject.gitsourcemerge.chat.vo.BookVO;
import com.teamproject.gitsourcemerge.chat.vo.MemberVO;

public interface LibraryService {
	public MemberVO searchMember(String id);
	public BookVO borrow(MemberVO vo);
}
