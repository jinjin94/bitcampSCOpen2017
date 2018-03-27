package com.bitcamp.open.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.open.member.model.Member;
import com.bitcamp.open.member.service.MemberLoginService;

//클레스를 컨트롤러 클레스로 사용 가능하다.
@Controller
//메서드가 어떤 HTTP 요청을 처리할 것인가를 작성
@RequestMapping("member/login")
public class MemberLoginController {
	
	//스프링 빈을 자동으로 주입한다.
	@Autowired
	private MemberLoginService memberLoginService;

	
	@RequestMapping(method = RequestMethod.GET)
	public String loginForm() {
		return "member/loginForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String login(@RequestParam(value = "member_id", defaultValue = "0") String id,
			@RequestParam(value = "password", required = false) String pw, HttpSession session){
		//@RequestParam 결과값 가져옴

		System.out.println(id);
		System.out.println(pw);
		
		String view = "redirect:mypage";

		Member member = memberLoginService.loginChk(id, pw);
		
		if (member == null) {
			return "member/loginFail";
		}
		
		member.setPassword("");
		
		session.setAttribute("loginInfo", member);

		System.out.println(session.getAttribute("loginInfo"));
		
		return view;

	}

}