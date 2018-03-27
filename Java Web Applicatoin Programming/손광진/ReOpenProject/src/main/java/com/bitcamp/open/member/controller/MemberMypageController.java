package com.bitcamp.open.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.open.member.model.Member;
import com.bitcamp.open.member.service.MemberLoginService;

@Controller
public class MemberMypageController {
	
	@Autowired
	MemberLoginService service;	
	
	@RequestMapping("/member/mypage")
	public String mypage(HttpSession session, Model model) {
		
		Member member = (Member) session.getAttribute("loginInfo");
		
		model.addAttribute("member", member);
		
		return "member/mypage";
		
	}
	

}
