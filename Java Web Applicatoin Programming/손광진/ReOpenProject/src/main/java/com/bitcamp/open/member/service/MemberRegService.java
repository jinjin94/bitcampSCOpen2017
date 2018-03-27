package com.bitcamp.open.member.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.open.member.dao.MemberDao;
import com.bitcamp.open.member.model.Member;

public class MemberRegService {
	
	@Autowired
	MemberDao dao;
	
	public int memberReg(Member member, HttpServletRequest request) throws IllegalStateException, IOException {
		
		
		
		String uploadURI = "/uploadfile/memberphoto";
		String dir = request.getSession().getServletContext().getRealPath(uploadURI);
		System.out.println(dir);
		
		if ( !member.getPhotofile().isEmpty() ) {
			System.out.println("rara");
			// 새로운 파일 이름 생성 -> 파일 저장 -> DB에 저장할 파일이름 set
			String fileName = member.getMember_id()+"_"+member.getPhotofile().getOriginalFilename();
			member.getPhotofile().transferTo(new File(dir, fileName));
			member.setPhoto(fileName);
		}
		int resultCnt = dao.insertMember(member);
		System.out.println(member);
		return resultCnt;
		
	}
	
}