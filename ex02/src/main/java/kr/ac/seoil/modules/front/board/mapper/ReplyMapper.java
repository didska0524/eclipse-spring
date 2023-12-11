package kr.ac.seoil.modules.front.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.ac.seoil.modules.common.pages.vo.Criteria;
import kr.ac.seoil.modules.front.board.vo.ReplyVO;

public interface ReplyMapper {
	public int insert (ReplyVO vo) throws Exception;
	public int update (ReplyVO vo) throws Exception;
	public int delete (Long rno) throws Exception;
	public ReplyVO select(Long rno) throws Exception;
	
	public List<ReplyVO> selectList(
			@Param("cri") Criteria cri,
			@Param("bno") Long bno) throws Exception;
}
