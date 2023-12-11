package kr.ac.seoil.modules.front.board.service;

import java.util.List;

import kr.ac.seoil.modules.common.pages.vo.Criteria;
import kr.ac.seoil.modules.front.board.vo.BoardVO;

public interface BoardService {
	public List<BoardVO> getList() throws Exception;
	public int getTotalCount(Criteria cri) throws Exception;
	public List<BoardVO> getListWithPaging(Criteria cri) throws Exception; //getList(Criteria cri) 로 해도된다 메소드 오버로딩(파라미터가 다르기때문)
	public BoardVO getInfo(BoardVO boardVO) throws Exception;
	public void create(BoardVO boardVO) throws Exception;
	public void createSelectKey(BoardVO boardVO) throws Exception;
	public int remove(BoardVO boardVO) throws Exception;
	public int modify(BoardVO boardVO) throws Exception;
}
