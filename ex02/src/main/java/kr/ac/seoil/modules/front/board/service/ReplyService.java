package kr.ac.seoil.modules.front.board.service;

import java.util.List;

import kr.ac.seoil.modules.common.pages.vo.Criteria;
import kr.ac.seoil.modules.front.board.vo.ReplyVO;

public interface ReplyService {
	public int create (ReplyVO vo) throws Exception;
	public int modify (ReplyVO vo) throws Exception;
	public int remove (Long rno) throws Exception;
	public ReplyVO get(Long rno) throws Exception;
	public List<ReplyVO> getList(Criteria cri, Long bno) throws Exception;
}
