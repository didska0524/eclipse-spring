package kr.ac.seoil.testMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.ac.seoil.modules.front.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
@RequiredArgsConstructor
public class BoardServiceTests {
	
	private final BoardService boardService;
	
	@Test
	public void testGetList() throws Exception {
		boardService.getList().forEach(board -> log.info(board));
	}

}
