package org.hdcd.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.hdcd.domain.Board;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//자동으로 생기는 log라는 변수를 이용해서 로그를 출력할수있다
@Controller
public class HomeController {
	//private static final Logger logger =LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String home(Locale locale,Model model) {
		//logger.info("Welcom home! The Client locale is {}.",locale);
		log.info("Welcom home! The client locale is" +locale+".");
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG,locale);
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime",formattedDate);
	
		return "home";
	}
//	@ResponseBody // 객체 반환할땐 responseBody //자동으로 JSON으로 변환
//	@GetMapping("/goHome0301")
//	public Board home0301() {
//		log.info("home0301");
//		Board board=new Board();
//		return board;
//	}
	
	//<List>타입
	@ResponseBody
	@GetMapping("/goHome04")
	public List<Board> home04() {
		log.info("home04");
		List<Board> list = new ArrayList<>();
	//	Board board = new Board("어린왕자","파울료코엘료");
	//	list.add(board);
	//	Board board2 = new Board("도비야","생일축하해");
	//	list.add(board2);
		return list;
	}
	//<map>타입
	@ResponseBody
	@GetMapping("/goHome5")
	public Map<String,Board> home05(){
		log.info("home5");
		Map<String,Board> map = new HashMap<>();
	//	Board b = new Board("지금은","새벽5시");
	//	map.put("key1", b);
	//	Board b1 = new Board("2ne1","아파");
	//	map.put("key2", b1);
		return map;
	}

}
