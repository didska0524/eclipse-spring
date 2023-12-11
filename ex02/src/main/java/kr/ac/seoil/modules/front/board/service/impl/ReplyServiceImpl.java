package kr.ac.seoil.modules.front.board.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.ac.seoil.modules.common.pages.vo.Criteria;
import kr.ac.seoil.modules.front.board.mapper.ReplyMapper;
import kr.ac.seoil.modules.front.board.service.ReplyService;
import kr.ac.seoil.modules.front.board.vo.ReplyVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@RequiredArgsConstructor	// AutoWired 를 써도 된다. 
							// 이건 생성자 자동주입을 통해서 의존주입을 한다.
public class ReplyServiceImpl implements ReplyService{
	
	private final ReplyMapper replyMapper;

	@Override
	public int create(ReplyVO vo) throws Exception {	
		return replyMapper.insert(vo);
	}

	@Override
	public int modify(ReplyVO vo) throws Exception {
		return replyMapper.update(vo);
	}

	@Override
	public int remove(Long rno) throws Exception {
		return replyMapper.delete(rno);
	}

	@Override
	public List<ReplyVO> getList(Criteria cri, Long bno) throws Exception {
		return replyMapper.selectList(cri, bno);
	}

	@Override
	public ReplyVO get(Long rno) throws Exception {
		return replyMapper.select(rno);
	}

}
