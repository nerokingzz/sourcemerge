package com.teamproject.gitsourcemerge.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.teamproject.gitsourcemerge.chat.service.LibraryService;
import com.teamproject.gitsourcemerge.chat.vo.MemberVO;


@RestController("libraryController")
@ResponseBody
@RequestMapping(value = "/library/*", method = {RequestMethod.GET,RequestMethod.POST} )
public class LibraryControllerImpl implements LibraryController{
	@Autowired
	LibraryService service;
	
	@Autowired
	MemberVO member;
	
	@RequestMapping(value = "/searchMember",
					method = RequestMethod.GET,
					consumes = "application/json",
					produces = {MediaType.TEXT_PLAIN_VALUE}
					)
	public ResponseEntity<MemberVO> searchMember(@RequestParam("p_id") String p_id) throws Exception{
		
		MemberVO searchMember = service.searchMember(p_id);
		
		return new ResponseEntity<MemberVO>(searchMember, HttpStatus.OK);
	}

}
