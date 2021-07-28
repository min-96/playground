package org.hdcd.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	

}