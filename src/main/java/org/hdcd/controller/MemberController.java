package org.hdcd.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hdcd.domain.Card;
import org.hdcd.domain.CodeLabelValue;
import org.hdcd.domain.FileMember;
import org.hdcd.domain.Member;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javassist.compiler.MemberCodeGen;
import lombok.extern.slf4j.Slf4j;



@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {
	
		public MemberController() {
			log.info("member");
		}
	
//	@GetMapping("/registerForm")
//		public void registerForm() {
//			log.info("registerForm");
//			//return "sucess";
//		}
//	@GetMapping("/register")
//	public String registerByParameter(String userId,String password) {
//		log.info("registerByParameter");
//		log.info("userId"+userId);
//		log.info("password="+password);
//		return "sucess";
//	}
//	@GetMapping("/register/{userId}/{coin}")
//	public String registerByPath(@PathVariable("userId")String id,
//			@PathVariable("coin")int coin) {
//		//PathVariable 경로 변수 값 가져오기
//		log.info("ByPath");
//		log.info("userId "+id);
//		
//		log.info("coin"+coin);
//		return "sucess";
//	}
//	@PostMapping("/register01")
//	public String register01(String userId,String password, int coin){
//		//폼 필드명이랑 일치하지 않으면 null 값뜸
//		log.info("register01");
//		log.info(userId);
//		log.info(password);
//		log.info("coin="+coin);
//		return "sucess";
//	}
//	@PostMapping("/register02")
//	public String register02(@RequestParam("userId")String id,String password, int coin){
//		
//		
//		log.info(id);
//		log.info(password);
//		log.info("coin="+coin);
//		return "sucess";
//	}
//	
//	@PostMapping("/register03")
//	public String register03(int uId,Member member){
//		
//		log.info("register03");
//		log.info("uid"+uId);
//		log.info("userId= " +member.getUserId());
//		log.info("pwd" + member.getPassword());
//		log.info("coin=" +member.getCoin());
//		return "sucess";
//	}
////	@GetMapping("/registerByGet01")
////	public String registerByGet01(String userId,@DateTimeFormat(pattern="yyyyMMdd")LocalDate dateOfBirth) {
////		log.info(userId);
////		log.info("DAte"+dateOfBirth);
////		return "sucess";
////	}
//	@GetMapping("/registerByGet01")
//	public String registerByGet01(Member m) {
//		log.info(m.getUserId());
//		log.info("date" +m.getDateOfBirth());
//		return "sucess";
//	}
//	@PostMapping("/register04")
//	public String register04(String[] carArray) {
//		if(carArray!=null) {
//			log.info("carArray.length"+carArray.length);
//			for(int i=0; i<carArray.length;i++) {
//				log.info("carArray["+i+"]"+carArray[i]);
//			}
//		
//		}
//		else
//			log.info(null);
//		return "sucess";
//	}
//	@PostMapping("/register05")
//	public String register05(Member m) {
//		//if(developer=="Y") {
//	
////			log.info(developer);
////		}
////		else if(developer=="N") {
////			log.info("N");
////		}
////		else {
////			log.info("null");
////		}
////		
//		return "sucess";
//	}
//	
//	@PostMapping("/register06")
//	public String register06(Member m) {
//		List<Card> cardList = m.getCardList();
//		if(cardList!=null) {
//			for(int i=0; i<cardList.size(); i++) {
//				Card card = cardList.get(i);
//				log.info(card.getNo());
//				log.info("validd"+card.getValidMonth());
//			}
//		}
//		else {
//			log.info("null");
//		}
//		return "sucess";
//	}
//	//파일 업로드 폼 방식 요청처리
//	@PostMapping("/registerFile01")
//	public String registerFile01(MultipartFile picture) {
//		//스프링 mvc가 지원하는 multipartFile 매개변수로 처리한다
//		if(picture!=null) {
//		log.info(picture.getOriginalFilename());
//		log.info("size"+picture.getSize());
//		log.info("contentType" + picture.getContentType());
//		}
//		else {
//			log.info(null);
//		}
//		return "sucess";
//		
//	}
//	@PostMapping("/registerFile02")
//	public String registerFile02(FileMember fileMember) {
//		log.info(fileMember.getUserId());
//		MultipartFile picture = fileMember.getPicture(); 
//		return "sucess";
//	}
//	@PostMapping("/registerFile03")
//	public String registerFile03(FileMember fileMember) {
//		List<MultipartFile> pictureList = fileMember.getPictureList();
//		for(MultipartFile picture: pictureList) {
//			log.info(picture.getOriginalFilename());
//			
//		}
//		
//		return"sucess";
//		
//	}
//	@PostMapping("/registerFile04")
//	public String registerFile03(MultipartFile[] pictureList) {
//	
//		for(MultipartFile picture: pictureList) {
//		log.info(picture.getOriginalFilename());
//			
//		}
//		
//		return"sucess";
//		
//	}
//	
//	@GetMapping("/read01")
//	public String read01(Model model) {
//		//model 객체를 통해서 다양한 데이터를 뷰에 전달할수있다
//		log.info("read01");
//		Member member = new Member();
//		member.setUserId("hong");
//		member.setPassword("1234");
//		LocalDate dateOfBirth = LocalDate.of(2020, 3, 2);
//		member.setDateOfBirth(dateOfBirth);
//		model.addAttribute(member);
//		model.addAttribute("user",member); // user이름으로 보냄
//		return "member/read01";
//	}
//	@GetMapping("/read02")
//	public String read02(Model model) {
//		log.info("read02");
//		String[] carArray= {"saab","audi"};
//		List<String> carList = new ArrayList<String>();
//		carList.add("bentz");
//		carList.add("audi");
//		model.addAttribute("carArray",carArray);
//	//	model.addAttribute(carList);
//		return "member/read02";
//	}
//	
//	@GetMapping("/read03")
//	public String read03(Model model) {
//		Member member= new Member();
//		
//		String[] carArray= {"hyundae","s5"};
//		member.setCarArray(carArray);
//		
//		List<String> carList = new ArrayList<>();
//		carList.add("ssdsd");
//		carList.add("sdasdasd");
//		member.setCarList(carList);
//		
//		model.addAttribute(member);
//		return "member/read03";
//	}
//	
//	@PostMapping("/registerModel")
//	public String registerModel(Member member) {
//		log.info("registerModel");
//		log.info(member.getUserId());
//		return "result01";
//		
//	}
	
	@GetMapping("/registerForm1")
	public String registerForm1(Model model) {
		
		log.info("registerForm1");
		Member member= new Member();
		model.addAttribute(member); // 데이터 전달
	return "registerForm";
	}
	
	
	
	@GetMapping("/registerForm2")
	public String registerForm2(Member member) {
		
		log.info("registerForm2");

		
		
	return "registerForm";
	}
	
	@GetMapping("/registerForm3")
	public String registerForm3(@ModelAttribute("member")Member member) {
		
		log.info("registerForm3");
	//	Member member= new Member();
	//	model.addAttribute(member);
		
		member.setUserId("hong");
		member.setUserName("홍길동");
		
		
	return "registerForm";
	}
	
	
	
//	@PostMapping("/register")
//	public String register(Member member) {
//		log.info("register");
//		log.info(member.getUserId());
//		return "sucess";
//		
//	}
//	
	@GetMapping("/registerForm4")
	public String registerForm4(Model model){
		Map<String,String> carMap = new HashMap<>();
		carMap.put("01","aoudi");
		carMap.put("02", "bents");
		
		model.addAllAttributes(carMap);
		model.addAttribute("member",new Member());
		
		return "registerForm";
		
	}
//	RedirectAttributes은 일회성으로 데이터를 전달하는 용도
	
	@GetMapping("/registerForm5")
	public String registerForm5(Model model) {
		List<CodeLabelValue> carList=new ArrayList<>();
		carList.add(new CodeLabelValue("01","Sport"));
		carList.add(new CodeLabelValue("02","Audi"));
		
		model.addAllAttributes(carList);
		model.addAttribute("member",new Member());
		
		return "registerForm";
	}
	
	
	//---------------------------------------------------------------
	@GetMapping("/registerForm6")
	public String registerForm6(Model model) {
		
		Map<String,String> genderMap = new HashMap<>();
		genderMap.put("01", "Male");
		genderMap.put("02", "Female");
		Member member = new Member();
		model.addAttribute("genderMap",genderMap);
		model.addAttribute(member);
		return "registerForm";
	}
	
	
//	@PostMapping("/register")
//	public String register(Member member,Model model) {
//		log.info("register");
//		log.info(member.getGender());
//		model.addAttribute("gender",member.getGender());
//		//log.info(member.getUserId());
//		return "sucess";
//		
//	}
	//입력값 검증을 할 도메인 클래스에 @validated지정
//	---------------------------------------------------------
	@PostMapping("/register")
	public String register(@Validated Member member,BindingResult result) {
		//에러정보 확인을 위한 BindingResult메소드
		
		if(result.hasErrors()) {//에러가 발생한 경우 true반환한다.
			//입력값 검증후 bindingResult가 제공하는 메서드를 이용하여 검사결과를 확인
			
			List<ObjectError> allError =result.getAllErrors();
			List<ObjectError> globalError = result.getGlobalErrors();
	
			List<FieldError> fieldError=result.getFieldErrors();
			for(int i=0; i<allError.size();i++) {
				ObjectError error=allError.get(i);
				log.info("allError="+error);
			}
			for(int i=0; i<globalError.size();i++) {
				ObjectError error=globalError.get(i);
				log.info("globalError="+error);
			}
			
			for(int i=0; i<fieldError.size();i++) {
				ObjectError error=fieldError.get(i);
				log.info("fieldError="+error);
			}
		
			
			return "member/registerForm1";
		}
		log.info("member.getUserId",member.getUserId());
		log.info("member,getGender",member.getUserName());
		return "sucess";
	}
	@GetMapping("registerForm7")
	public String registerForm7(Model model) {
		model.addAttribute("member",new Member());
		return "member/registerForm1";
	}
	
	
}


