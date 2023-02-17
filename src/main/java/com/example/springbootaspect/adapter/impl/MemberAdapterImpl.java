package com.example.springbootaspect.adapter.impl;

import org.springframework.stereotype.Service;

import com.example.springbootaspect.adapter.MemberAdapter;
//import com.example.springbootaspect.annotation.LogExecutionTime;
import com.github.javafaker.Faker;

@Service("MemberAdapter")
public class MemberAdapterImpl implements MemberAdapter{

//	@LogExecutionTime
	public String[] getMemberList() {
		
		
		Faker faker = new Faker();
		
		String name1 = faker.funnyName().name();
		String name2 = faker.funnyName().name();
		String name3 = faker.funnyName().name();
		
		String[] memberList = new String[]{name1,name2,name3};
		
		return memberList;
	}

}
