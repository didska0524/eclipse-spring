package kr.ac.seoil.modules.front.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.ac.seoil.modules.common.pages.vo.Criteria;
import kr.ac.seoil.modules.common.pages.vo.PageVO;
import kr.ac.seoil.modules.front.board.service.BoardService;
import kr.ac.seoil.modules.front.board.vo.BoardVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
	private final BoardService boardService;
	
	@GetMapping("/getList.do")
	public String list(Model model) throws Exception { 
		List<BoardVO> list = boardService.getList();
		log.info(list);
		model.addAttribute("list", list);
		return "board/list";
	}
	
	@GetMapping("/list.do")
	public void list(Model model, Criteria cri) throws Exception {
		List<BoardVO> list = boardService.getListWithPaging(cri);
		model.addAttribute("list", list);
		PageVO pageVO = new PageVO(cri, boardService.getTotalCount(cri));
		model.addAttribute("pageMaker", pageVO);
	}
	
	@GetMapping({"/view.do", "/edit.do"})
	public void view(Model model,@ModelAttribute("cri") Criteria cri, BoardVO argVO, HttpServletRequest request) throws Exception {
		BoardVO vo = boardService.getInfo(argVO);
		if(request.getRequestURI().indexOf("/view.do") > -1) {
			vo.setContent(
				vo.getContent().replaceAll(System.getProperty("line.separator"), "<br/>")
			);
		}
		model.addAttribute("board", vo);
//		model.addAttribute("cri", cri);
	}
	
//	@GetMapping("/{bno}/view.do")
//	public String view(Model model, BoardVO argVO) throws Exception {
//		BoardVO vo = boardService.getInfo(argVO);
//		model.addAttribute("board", vo);
//		return "/board/view";
//	}
	
	@GetMapping("/write.do")
	public void write() throws Exception {
	}
	
//	@GetMapping("/edit.do")
//	public void edit(Model model, BoardVO argVO) throws Exception {
//		BoardVO vo = boardService.getInfo(argVO);
//		model.addAttribute("board", vo);
//	}
	
	@PostMapping("/create.do")
	public String create(BoardVO vo, RedirectAttributes rttr) throws Exception {
		boardService.createSelectKey(vo);
		log.info(vo);
		log.info(vo.getBno());
		rttr.addFlashAttribute("result", vo.getBno());
		return "redirect:list.do";
	}
	
//	@PostMapping("/create.do")
//	public String create(BoardVO vo, RedirectAttributes rttr) throws Exception {
//		boardService.create(vo);
//		log.info(vo);
//		rttr.addFlashAttribute("result", 1);
//		return "redirect:list.do";
//	}
	
	@PostMapping("/modify.do")
	public String modify(BoardVO vo, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) throws Exception {
		int ret=boardService.modify(vo);
		if (ret>0) {
			rttr.addFlashAttribute("result", "success");
		}
		boardService.modify(vo);
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		return "redirect:list.do" + cri.getListLink();
	}
	
	@PostMapping("/remove.do")
	public String remove(BoardVO vo, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) throws Exception {
		int ret=boardService.remove(vo);
		if (ret>0) {
			rttr.addFlashAttribute("result", "success");
		}
		
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		return "redirect:list.do" + cri.getListLink();
	}
}
