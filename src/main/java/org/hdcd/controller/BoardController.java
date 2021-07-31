package org.hdcd.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jdk.internal.org.jline.utils.Log;
import lombok.extern.slf4j.Slf4j;
@Controller
@Slf4j
//클래스 레벨 요청경로지정
@RequestMapping("/board")
public class BoardController {
	
	//private static final Logger logger=LoggerFactory.getLogger(BoardController.class);
	
	
	//value속성에 요청경로를 설정한다
	//@RequestMapping("/register")
	//@GetMapping("/register")
	@GetMapping(value="/get",params="register")
	public String registerForm() {
		log.info("registerForm");
		return "board/register";
	}
	@PostMapping(value="/post", params="register")
	public String register() {
		log.info("register");
		return "board/modify";
	}
	
	//@RequestMapping("/modify")
	//@PostMapping("/modify")
	@GetMapping(value="/get",params="modify")
	public String modifyForm() {
		log.info("modifyForm");
		return "board/modify";
	}
	@PostMapping(value="/post",params="modify")
	public String modify() {
		log.info("modify");
		return "board/list";
	}
	@GetMapping("/list")
	public void listForm() {
		log.info("listForm");
		
		
	}
	//경로 패턴 지정
	@GetMapping("/read/{boardNo}")
	public String read(@PathVariable int boardNo) {
		log.info("readBoardNo: "+boardNo);
		//경로가 변하므로 뷰 이름 지정
		return "board/read";
	}
	
	
	
	

}
