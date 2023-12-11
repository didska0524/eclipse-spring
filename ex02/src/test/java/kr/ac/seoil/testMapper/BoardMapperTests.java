package kr.ac.seoil.testMapper;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.ac.seoil.modules.common.pages.vo.Criteria;
import kr.ac.seoil.modules.front.board.mapper.BoardMapper;
import kr.ac.seoil.modules.front.board.vo.BoardVO;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
@RequiredArgsConstructor
public class BoardMapperTests {
	
	@Setter(onMethod_ = {@Autowired })
	private BoardMapper boardMapper;
	
	@Test
	public void testGetList() throws Exception {
		List<BoardVO> list = boardMapper.selectList();
		
		boardMapper.selectList().forEach(board->log.info(board));
		for (int i=0; i<list.size(); i++) {
			BoardVO vo = new BoardVO();
			vo = list.get(i);
			log.info(vo);;
		}
		
		/*
		 * for (BoardVO vo : list) { log.info(vo); }
		 * 
		 * list.forEach(vo -> log.info(vo));
		 * 
		 * list.forEach(log::info);
		 */
	}
	
	@Test
	public void testSearch() throws Exception {
		Criteria cri = new Criteria();
		cri.setType("TC");
		cri.setKeyword("검색");
		 
		List<BoardVO> list = boardMapper.selectListWithPaging(cri);
		boardMapper.selectListWithPaging(cri).forEach(board -> log.info(board));
	}
	
	@Test
	public void testInsert() throws Exception {
		BoardVO vo = new BoardVO();
		vo.setTitle("새로 작성하는 글");
		vo.setContent("새로 작성하는 내용");
		vo.setWriter("최석원");
		
		boardMapper.insert(vo);
		log.info(vo);
	}
	
	@Test
	public void testInsertSelectKey() throws Exception {
		BoardVO vo=new BoardVO();
		vo.setTitle("새로 작성하는 글 select key");
		vo.setContent("새로 작성하는 내용 select key");
		vo.setWriter("newbie");
		
		boardMapper.insertSelectKey(vo);
		log.info(vo);
	}
	
	@Test
	public void testSelectInfo() throws Exception{
		BoardVO vo = new BoardVO();
		vo.setBno(5L); // long으로 5L
		
		BoardVO board = boardMapper.selectInfo(vo);
		
		log.info(board);
	}
	
	@Test
	public void testDelete() throws Exception {
		BoardVO vo = new BoardVO();
		vo.setBno(3L);
		log.info("DELETE COUNT : " + boardMapper.delete(vo));
	}
	
	@Test
	public void testUpdate() throws Exception {
		BoardVO vo = new BoardVO();
		vo.setBno(4L);
		vo.setTitle("게시물 수정 테스트");
		vo.setContent("게시물 수정 테스트 내용");
		vo.setWriter("이재용");
		boardMapper.update(vo);
	}
	
	
	@Test
	public void testTrim() throws Exception {
		BoardVO vo = new BoardVO();
		vo.setBno(4L);
		boardMapper.test(vo);
	}
}
