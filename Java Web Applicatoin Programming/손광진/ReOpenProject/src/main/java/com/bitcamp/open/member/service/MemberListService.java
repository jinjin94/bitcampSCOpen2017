package com.bitcamp.open.member.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.bitcamp.open.member.dao.LoginDao;
import com.bitcamp.open.member.model.Member;

public class MemberListService {
	
	private SqlSessionTemplate sqlSessionTemplate;
	
	private LoginDao dao;
	
	public List<Member> getMemberList(){
		
		dao = sqlSessionTemplate.getMapper(LoginDao.class);
		
		List<Member> list = dao.selectList();
		
		return list;
	}
}
