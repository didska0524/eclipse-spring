package kr.ac.seoil.modules.front.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.seoil.modules.front.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
	private final BoardService boardservice;
	
	@GetMapping("/list.do")
	public void list(Model model) { 
		
	}
}