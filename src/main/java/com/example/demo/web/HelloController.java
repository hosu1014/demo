package com.example.demo.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.Member;
import com.example.demo.service.MemberService;

@Controller
public class HelloController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	Environment environment;
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping("/hello.do")
	public String hello(Model model) {
		
		logger.debug("testtest");
		logger.debug("debug Test");
		logger.debug("github edit first.. then commit test");
		
		for(String profile : getActiveProfiles()) {
			logger.info(profile);
		}
		
		//insertMember();
		
		model.addAttribute("serverTime", System.currentTimeMillis());
		return "hello";
	}
	
	public String[] getActiveProfiles() {
		return environment.getActiveProfiles();
	}
	
	public void insertMember() {
		Member member = new Member();
		member.setId("2");
		member.setName("Choung");
		member.setAge(41);
		
		memberService.insertMember(member);
		
	}
}
