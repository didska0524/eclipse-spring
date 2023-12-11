package kr.ac.seoil.modules.front.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.seoil.modules.common.pages.vo.Criteria;
import kr.ac.seoil.modules.front.board.mapper.BoardMapper;
import kr.ac.seoil.modules.front.board.service.BoardService;
import kr.ac.seoil.modules.front.board.vo.BoardVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardServiceImpl implements BoardService{
	
	//@Autowired
	private final BoardMapper boardMapper;

	@Override
	public List<BoardVO> getList() throws Exception {
		return boardMapper.selectList();
	}
	
	@Override
	public int getTotalCount(Criteria cri) throws Exception {
		return boardMapper.selectTotalCount(cri);
	}
	
	@Override
	public List<BoardVO> getListWithPaging(Criteria cri) throws Exception {
		return boardMapper.selectListWithPaging(cri);			
	}

	@Override
	public BoardVO getInfo(BoardVO boardVO) throws Exception {
		return boardMapper.selectInfo(boardVO);
	}

	@Override
	public void create(BoardVO boardVO) throws Exception {
		boardMapper.insert(boardVO);
	}

	@Override
	public void createSelectKey(BoardVO boardVO) throws Exception {
		boardMapper.insertSelectKey(boardVO);
	}

	@Override
	public int remove(BoardVO boardVO) throws Exception {
		return boardMapper.delete(boardVO);
	}

	@Override
	public int modify(BoardVO boardVO) throws Exception {
		return boardMapper.update(boardVO);
	}

}
