package com.bitcamp.open.member.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.open.member.model.Member;
import com.bitcamp.open.member.service.MemberRegService;

@Controller
@RequestMapping("/member/memberReg")
public class MemberRegController {
	
	@Autowired
	private MemberRegService memberRegService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String memberRegForm() {
		return "member/memberRegForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String memberReg(Member member, Model model, HttpServletRequest request)
		throws IllegalStateException, IOException{

		

			int resultCnt = memberRegService.memberReg(member, request);
		
			String msg = "정상적으로 처리되었습니다.";
			
			if(resultCnt == 0)
				msg = "가입 처리가 되지 않았습니다. 담당자에게 문의 해주세요.";
			
			model.addAttribute("msg", msg);
			
			
			return "member/memberReg";
	}
	}


