package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.vo.Board;

// @Component의 특화버전 : @Controller, @Service, @Repository
@Controller
public class BoardController {
	// /board/list, /board/read, /board/write, /board/update, /board/delete
	//                                                                                 
	// GET	/board/list                                                                        
	// GET	/board/read?bno=111								  		글번호                 
	// GET	/board/write			글 작성화면을 보여준다                                    
	// POST	/board/write			글 작성 후 /board/read로 이동		Board             
	// POST /board/update			글 변경 후 /board/read로 이동		Board, 비밀번호      
	// POST	/board/delete			글 삭제 후 /board/list로 이동		글번호, 비밀번호       
	
	@GetMapping({"/","/board/list"})
	public ModelAndView list() {
		return new ModelAndView("board/list");
	}
	
	// 스프링 컨트롤러 메소드의 파라미터는 요술 상자 --> 필요한 객체 적으면 스프링이 넣어준다
	@GetMapping("/board/read")
	public ModelAndView read(@RequestParam (required=true, defaultValue="1") Integer bno) {
		return new ModelAndView("board/read").addObject("bno",bno);
	}
	
	// 컨트롤러 메소드의 리턴이 void면 들어온 경로가 html이름이 된다
	@GetMapping("/board/write")
	public void write() {
		// 화면에 출력할 내용이 없다 -> ModelAndView에서 View만 있는 경우
		// return new ModelAndView("board/write");로 처리해도 된다
	}
	
	// redirect해야 한다 -> void로 처리 못한다
	@PostMapping("/board/write")
	public String write(@ModelAttribute Board board) {
		return "redirect:/board/read";
	}
	
	// id:spring, age:20 → 사용자가 입력한 값을 가지고 id는 spring, age는 20인 객체를 만들어야 한다
	// 사용자가 입력한 값을 담고 있는 객체를 Command 객체 → @ModelAttribute는 스프링에서 커멘드 객체를 생성하는 어노테이션
	@PostMapping("/board/update")
	public String update(@ModelAttribute Board board, @RequestParam String password) {
		return "redirect:/board/read";
	}
	
	@PostMapping("/board/delete")
	public String delete(@RequestParam int bno, @RequestParam String password) {
		return "redirect:/";
	}
}
