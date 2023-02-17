package com.example.springbootaspect.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootaspect.adapter.MemberAdapter;
import com.example.springbootaspect.service.MemberService;

@Service("MemberService")
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberAdapter memberAdapter;
	
	@Override
	public String[] retrieveMemberList() {
		
		return memberAdapter.getMemberList();
	}

}
