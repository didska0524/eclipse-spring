package kr.ac.seoil.modules.front.board.vo;

import java.util.Date;

import lombok.Data;


@Data
public class BoardVO {
	private Long bno;
	private String title;
	private String content;
	private String writer;
	private Date regDate; //등록일자
	private Date modDate; //수정일자?
}
