package kr.ac.seoil.modules.front.board.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.seoil.modules.common.pages.vo.Criteria;
import kr.ac.seoil.modules.front.board.service.ReplyService;
import kr.ac.seoil.modules.front.board.vo.ReplyVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@Log4j
@AllArgsConstructor
@RequestMapping("/replies/")
public class ReplyController {
	private final ReplyService replyService;
	
	@PostMapping(value = "/new"
			, consumes = "application/json"
			, produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> create(@RequestBody ReplyVO vo) throws Exception {
		int insertCount = replyService.create(vo);
		
		return insertCount == 1
				? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping(value = "/new2"
			, consumes = "application/json"
			, produces = {MediaType.TEXT_PLAIN_VALUE})
	public String create1(@RequestBody ReplyVO vo) throws Exception {
		int insertCount = replyService.create(vo);
		
		return insertCount == 1
				? "success" : "fail";
	}
	
	@GetMapping(value = "/pages/{bno}/{page}"
			, produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<ReplyVO>> getList(
			@PathVariable("page") int page, @PathVariable("bno") Long bno) throws Exception 
	{
		Criteria cri = new Criteria(page, 10);
		
		List<ReplyVO> list = replyService.getList(cri, bno);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping (value = "/{rno}"
			, produces = { MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<ReplyVO> get(@PathVariable("rno") Long rno) throws Exception {
//		ReplyVO ivo = new ReplyVO();
//		ivo.setRno(rno);
		return new ResponseEntity<>(replyService.get(rno), HttpStatus.OK);
	}
	
	@DeleteMapping (value= "/{rno}", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> remove (@PathVariable ("rno") Long rno) throws Exception {
		return replyService.remove(rno) == 1
			? new ResponseEntity<>("success", HttpStatus.OK)
			: new ResponseEntity<>(HttpStatus. INTERNAL_SERVER_ERROR);
	}
	
	@RequestMapping(method= {RequestMethod.PUT, RequestMethod.PATCH}
			, value = "/{rno}"
			, consumes = "application/json"
			, produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> modify(@PathVariable ("rno") Long rno
			, @RequestBody ReplyVO vo) throws Exception {
		vo.setRno(rno);
//		int ret = replyService.modify(vo);
		return replyService.modify(vo) == 1
				? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus. INTERNAL_SERVER_ERROR);
	}
	 
}
