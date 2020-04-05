package com.teamproject.gitsourcemerge.chat.controller;

import org.springframework.http.ResponseEntity;

import com.teamproject.gitsourcemerge.chat.vo.MemberVO;



public interface LibraryController {
	public ResponseEntity<MemberVO> searchMember(String p_id) throws Exception;
}
