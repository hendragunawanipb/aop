package com.example.springbootaspect.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootaspect.annotation.LogExecutionTime;
import com.example.springbootaspect.service.MemberService;


@RestController
public class WelcomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(WelcomeController.class);
	
	@Autowired
    @Qualifier("MemberService")
    private MemberService memberService;
	
	@GetMapping(value="/indexold")
	public String indexOld() {
		
		logger.debug("start - indexOld");
		
		String welcome = "This is Old Welcome Page";
		
		logger.debug("end - indexOld");
		return welcome;
	}
	
	@LogExecutionTime
	@GetMapping(value="/indexnew")
	public String indexNew() {
		logger.debug("inside");
		String welcome = "This is New Welcome Page";
		return welcome;
	}
	
	@LogExecutionTime
	@GetMapping(value="/throwme")
	public String throwme() throws Exception{
		throw new Exception("hello exception");
	}
	
	
	
	
	
	
	@GetMapping(value="/member")
	public ResponseEntity<?> retrieveMember() {
		logger.debug("start - retrieveMember");
		
		String[] memberList = memberService.retrieveMemberList();
		
		logger.debug("end - retrieveMember");
		return new ResponseEntity<>(memberList, HttpStatus.OK);
		
	}
}