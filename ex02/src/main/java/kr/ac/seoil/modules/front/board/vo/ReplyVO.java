package kr.ac.seoil.modules.front.board.vo;

import java.util.Date;
import lombok.Data;

@Data
public class ReplyVO {
	private Long rno;
	private Long bno;
	private String replyContent;
	private String replyer;
	private Date regDate;
	private Date modDate;
}