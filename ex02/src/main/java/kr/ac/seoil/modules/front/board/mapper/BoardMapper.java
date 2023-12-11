package kr.ac.seoil.modules.front.board.mapper;

import java.util.List;

import kr.ac.seoil.modules.common.pages.vo.Criteria;
import kr.ac.seoil.modules.front.board.vo.BoardVO;

public interface BoardMapper {
	
//	@Select
	public List<BoardVO> selectList() throws Exception;
	public int selectTotalCount(Criteria cri) throws Exception;
	public List<BoardVO> selectListWithPaging(Criteria cri) throws Exception;
	public BoardVO selectInfo(BoardVO vo) throws Exception;
	public void insert (BoardVO board) throws Exception;
	public void insertSelectKey (BoardVO board) throws Exception;
	public int delete(BoardVO vo) throws Exception;
	public int update(BoardVO vo) throws Exception;
	
	public int test(BoardVO vo) throws Exception;
	

}
