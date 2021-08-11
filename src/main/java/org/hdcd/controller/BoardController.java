package org.hdcd.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hdcd.domain.Board;
import org.hdcd.domain.CodeLabelValue;
import org.hdcd.dto.PaginationDTO;
import org.hdcd.service.BoardService;
import org.hdcd.vo.PageRequestVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@RequiredArgsConstructor
//final 선언된 빈에 의존성 주입
@Controller
@Slf4j
//클래스 레벨 요청경로지정
@RequestMapping("/board")
public class BoardController {
	
	//private static final Logger logger=LoggerFactory.getLogger(BoardController.class);
	
	//필드기반 의존성 주입
	//@Autowired
	//private BoardService bservice;
	
	private final BoardService bservice;
	
	
	@GetMapping("/register")
	public String registerForm(Board board,Model model) {
		
		return "board/register";
	
	}
	
	
	@PostMapping("/register")
	public String register(Board board,Model model,RedirectAttributes rttr) throws Exception {
		board.setRegDate(LocalDateTime.now());
		bservice.register(board); // set을 했으니 게시판을 넘김
		
		rttr.addFlashAttribute("msg", "등록이 완료됨");
		//model.addAttribute("msg","등록이 완료되었습니다");
		
		return "redirect:/board/list";
	}
	
	@GetMapping("/list")
	//객체매핑@ModelAttribute 
	public void list(@ModelAttribute("pgrq")PageRequestVO pageRequestVO,Model model) throws Exception {
	//페이징
		Page<Board> page = bservice.Plist(pageRequestVO);
		
		log.info("pageable!!"+page.getPageable());
		log.info("totalPages!!"+page.getTotalPages());
		
		model.addAttribute("pgntn", new PaginationDTO<Board>(page));
	//	model.addAttribute("list",bservice.list());
		
		model.addAttribute("list",bservice.list(pageRequestVO));
		//검색유형의 코드명과 코드값 정의 
		log.info("키워드"+pageRequestVO.getKeyword());
		log.info("타입"+pageRequestVO.getSearchType());
		
		
		
		List<CodeLabelValue> searchTypeCodeValueList=new ArrayList<>();
		
		
		searchTypeCodeValueList.add(new CodeLabelValue("n","---"));
		searchTypeCodeValueList.add(new CodeLabelValue("t", "Title"));
		searchTypeCodeValueList.add(new CodeLabelValue("c", "Content"));
		searchTypeCodeValueList.add(new CodeLabelValue("w", "Writer"));
		searchTypeCodeValueList.add(new CodeLabelValue("tc", "Title OR Content"));
		searchTypeCodeValueList.add(new CodeLabelValue("twc", "Title OR Content OR Writer"));
		
		model.addAttribute("search",searchTypeCodeValueList);
		
		
		
	}
	
	@GetMapping("/read")
	public void read(Model model,Long boardNo,@ModelAttribute("pgrq")PageRequestVO pageRequestVO) throws Exception {
		model.addAttribute(bservice.read(boardNo));
	}
	
	@PostMapping("/remove")
	public String remove(Long boardNo,RedirectAttributes rttr,PageRequestVO pageRequestVO) throws Exception {
		bservice.remove(boardNo);
		rttr.addAttribute("page",pageRequestVO.getPage());
		rttr.addAttribute("sizePerPage",pageRequestVO.getSizePerPage());
		//model.addAttribute("msg", "삭제가 완료되었습니다");
		rttr.addFlashAttribute("msg", "삭제가 완료되었습니다");
		
		return "redirect:/board/list";
		
	}
	@GetMapping("/modify")
	public void modify(Model model,Long boardNo,@ModelAttribute("pgrq")PageRequestVO pageRequestVO) throws Exception {
		model.addAttribute(bservice.read(boardNo));
	}
	
	@PostMapping("/modify")
	public void modify(Board board,Long boardNo,Model model,@ModelAttribute("pgrq")PageRequestVO pageRequestVO) throws Exception {
		//log.info("boardNo"+board.getBoardNo());
		//log.info(board.getWriter());
		
		
		bservice.modify(board);
		//model.addAttribute("msg", "수정이 완려되았습니다");
		//rttr.addAttribute(pageRequestVO);
		//rttr.addAttribute("msg", "수정이 완료되었씁니다");
		
		model.addAttribute(bservice.read(boardNo));
	//	return "redirect:/board/list";
	}
	
	
	
//	-----------------------------------------------------------
	//value속성에 요청경로를 설정한다
	//@RequestMapping("/register")
	//@GetMapping("/register")
//	@GetMapping(value="/get",params="register")
//	public String registerForm() {
//		log.info("registerForm");
//		return "board/register";
//	}
//	@PostMapping(value="/post", params="register")
//	public String register() {
//		log.info("register");
//		return "board/modify";
//	}
//	
//	//@RequestMapping("/modify")
//	//@PostMapping("/modify")
//	@GetMapping(value="/get",params="modify")
//	public String modifyForm() {
//		log.info("modifyForm");
//		return "board/modify";
//	}
//	@PostMapping(value="/post",params="modify")
//	public String modify() {
//		log.info("modify");
//		return "board/list";
//	}
//	@GetMapping("/list")
//	public void listForm() {
//		log.info("listForm");
//		
//		
//	}
//	//경로 패턴 지정
//	@GetMapping("/read/{boardNo}")
//	public String read(@PathVariable int boardNo) {
//		log.info("readBoardNo: "+boardNo);
//		//경로가 변하므로 뷰 이름 지정
//		return "board/read";
//	}
//	
//	
	
	

}
