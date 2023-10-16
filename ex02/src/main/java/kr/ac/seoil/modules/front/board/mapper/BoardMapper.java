package kr.ac.seoil.modules.front.board.mapper;

import java.util.List;


import kr.ac.seoil.modules.front.board.vo.BoardVO;

public interface BoardMapper {
	
//	@Select
	public List<BoardVO> selectList() throws Exception;
	public BoardVO selectInfo(BoardVO vo) throws Exception;
	
	public void insert (BoardVO board) throws Exception;
	public void insertSelectKey (BoardVO board) throws Exception;
	public int delete(BoardVO vo) throws Exception;
	public int update(BoardVO vo) throws Exception;

}
