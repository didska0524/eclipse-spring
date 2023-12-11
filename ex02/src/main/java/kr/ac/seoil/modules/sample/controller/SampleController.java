package kr.ac.seoil.modules.sample.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.seoil.modules.common.pages.vo.Criteria;
import kr.ac.seoil.modules.common.pages.vo.PageVO;
import kr.ac.seoil.modules.front.board.service.BoardService;
import kr.ac.seoil.modules.front.board.vo.BoardVO;
import kr.ac.seoil.modules.sample.vo.SampleVO;
import kr.ac.seoil.modules.sample.vo.TicketVO;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;


@RestController
@Log4j
//@RequiredArgsConstructor
@AllArgsConstructor
@RequestMapping("/sample")
public class SampleController {
	
	@Autowired
	private BoardService boardService;

	
	@GetMapping(value="/getText.do", produces = "text/plain; charset=UTF-8")
	public String getText() {
		log.info("MIME TYPE: " + MediaType.TEXT_PLAIN_VALUE);
		
		return "안녕하세요";
	}
	
	@GetMapping(value="/getSample"
			, produces= {MediaType.APPLICATION_JSON_UTF8_VALUE
						, MediaType.APPLICATION_XML_VALUE})
	public SampleVO getSample() {
		return new SampleVO(112, "스타", " 로드");
	}

	@GetMapping(value="/getList")
	public List<SampleVO> getList() {
		return IntStream.range(1, 10)
				.mapToObj(i -> new SampleVO(i, i + "First", i + " Last"))
				.collect(Collectors.toList());
	}
	
	@GetMapping(value="/getList22")
	public List<SampleVO> getList22() throws Exception {
		List<SampleVO> list = new ArrayList<SampleVO>();
		for (int i=1; i<10; i++) {
			SampleVO vo = new SampleVO(i, i + "First", i + " Last");
			list.add(vo);
		}
		return list;
	}
	
	@GetMapping
	public Map<String, Object> getBoardList(Criteria cri) throws Exception {
		List<BoardVO> list = boardService.getListWithPaging(cri);
		PageVO pageVO = new PageVO(cri, boardService.getTotalCount(cri));
		
		Map<String, Object> retMap = new HashMap<String, Object>();
		retMap.put("list", list);
		retMap.put("pageMapker", pageVO);
		
		return retMap;
	}
	
	@GetMapping(value="listOnly")
	public List<BoardVO> getBoardListOnly(Criteria cri) throws Exception {
//		return boardService.getList();
//		PageVO pageVO = new PageVO(cri, boardService.getTotalCount(cri));
		return boardService.getListWithPaging(cri);
	}
	
	@GetMapping(value="totalCount")
	public PageVO getTotalCount(Criteria cri) throws Exception {
		PageVO pageVO = new PageVO(cri, boardService.getTotalCount(cri));
		return pageVO;
	}
	
	
	@GetMapping(value="/check", params= {"height","weight"})
	public ResponseEntity<Map<String, Object>> check(Double height, Double weight) throws Exception {
		Map<String, Object> retMap = new HashMap<String, Object>();
		retMap.put("weight", weight);
		retMap.put("height", height);
		
		ResponseEntity<Map<String, Object>> result = null;
		
		if (height < 150) {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(retMap);
		} else {
			result = ResponseEntity.status(HttpStatus.OK).body(retMap);
		}

		return result;
	}
	
	@GetMapping("/product/{cat}/{pid}")
	public String[] getPath(
			@PathVariable("cat") String cat,
			@PathVariable("pid") Integer pid) throws Exception {
		return new String[] { "category: " + cat, "productid: " + pid};
	}
	
	@PostMapping("/ticket")
	public TicketVO convert(@RequestBody TicketVO ticket) {
		log.info("convert............ticket" + ticket);
		return ticket;
	}
	
	
	
	
//	@GetMapping("/list.do")
//	public void list(Model model, Criteria cri) throws Exception {
//		List<BoardVO> list = boardService.getListWithPaging(cri);
//		model.addAttribute("list", list);
//		PageVO pageVO = new PageVO(cri, boardService.getTotalCount(cri));
//		model.addAttribute("pageMaker", pageVO);
//	}
}
