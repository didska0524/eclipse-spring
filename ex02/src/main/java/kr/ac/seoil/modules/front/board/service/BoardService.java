package kr.ac.seoil.modules.front.board.service;

import java.util.List;

import kr.ac.seoil.modules.front.board.vo.BoardVO;

public interface BoardService {
	public List<BoardVO> getList() throws Exception;
	public BoardVO getInfo(BoardVO boardVO) throws Exception;
	public void create(BoardVO boardVO) throws Exception;
	public void createSelectKey(BoardVO boardVO) throws Exception;
	public int remove(BoardVO boardVO) throws Exception;
	public int modify(BoardVO boardVO) throws Exception;
}
