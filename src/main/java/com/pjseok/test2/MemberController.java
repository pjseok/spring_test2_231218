package com.pjseok.test2;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {
	
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/loginOk")
	public String loginOk(HttpServletRequest request, Model model) {
		
		String mid = request.getParameter("memberid");
		String mpw = request.getParameter("memberpw");
			
		model.addAttribute("memberID", mid);
		model.addAttribute("memberPw", mpw);
	
		return "loginSuccess";
	}
	
	@RequestMapping(value = "/loginOk2")
	public String loginOk2(@RequestParam("memberid") String mid, @RequestParam("memberpw") String mpw, Model model) {
		model.addAttribute("memberID", mid);
		model.addAttribute("memberPw", mpw);
		
		return "loginSuccess";
	}
	
	@RequestMapping(value = "/join")
	public String join() {
		return "join";
	}
	
	@RequestMapping(value = "/join2")
	public String join2() {
		return "join2";
	}
	
	@RequestMapping(value = "/joinOk") //get방식
	public String joinOk(JoinMember joinMember) {
		return "joinOk";
	}
	
	@RequestMapping(value = "/joinOk2", method = RequestMethod.POST) //post방식
	public String joinOk2(@ModelAttribute("jmem") JoinMember joinMember) {
		return "joinOk2";
	}
	
	@RequestMapping(value = "/memberNum/{memberNumber}")
	public String memberNum(@PathVariable String memberNumber, Model model) {
		
		model.addAttribute("memberNumber", memberNumber);
		
		return "memberNumOk";
	}

	
	
	
	
}
