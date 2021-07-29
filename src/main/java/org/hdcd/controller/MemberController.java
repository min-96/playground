package org.hdcd.controller;

import java.time.LocalDate;

import org.hdcd.domain.Member;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;



@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {
	
		public MemberController() {
			log.info("member");
		}
	
	@GetMapping("/registerForm")
		public void registerForm() {
			log.info("registerForm");
			//return "sucess";
		}
	@GetMapping("/register")
	public String registerByParameter(String userId,String password) {
		log.info("registerByParameter");
		log.info("userId"+userId);
		log.info("password="+password);
		return "sucess";
	}
	@GetMapping("/register/{userId}/{coin}")
	public String registerByPath(@PathVariable("userId")String id,
			@PathVariable("coin")int coin) {
		//PathVariable 경로 변수 값 가져오기
		log.info("ByPath");
		log.info("userId "+id);
		
		log.info("coin"+coin);
		return "sucess";
	}
	@PostMapping("/register01")
	public String register01(String userId,String password, int coin){
		//폼 필드명이랑 일치하지 않으면 null 값뜸
		log.info("register01");
		log.info(userId);
		log.info(password);
		log.info("coin="+coin);
		return "sucess";
	}
	@PostMapping("/register02")
	public String register02(@RequestParam("userId")String id,String password, int coin){
		
		
		log.info(id);
		log.info(password);
		log.info("coin="+coin);
		return "sucess";
	}
	
	@PostMapping("/register03")
	public String register03(int uId,Member member){
		
		log.info("register03");
		log.info("uid"+uId);
		log.info("userId= " +member.getUserId());
		log.info("pwd" + member.getPassword());
		log.info("coin=" +member.getCoin());
		return "sucess";
	}
//	@GetMapping("/registerByGet01")
//	public String registerByGet01(String userId,@DateTimeFormat(pattern="yyyyMMdd")LocalDate dateOfBirth) {
//		log.info(userId);
//		log.info("DAte"+dateOfBirth);
//		return "sucess";
//	}
	@GetMapping("/registerByGet01")
	public String registerByGet01(Member m) {
		log.info(m.getUserId());
		log.info("date" +m.getDateOfBirth());
		return "sucess";
	}
	@PostMapping("/register04")
	public String register04(String[] carArray) {
		if(carArray!=null) {
			log.info("carArray.length"+carArray.length);
			for(int i=0; i<carArray.length;i++) {
				log.info("carArray["+i+"]"+carArray[i]);
			}
		
		}
		else
			log.info(null);
		return "sucess";
	}
}

