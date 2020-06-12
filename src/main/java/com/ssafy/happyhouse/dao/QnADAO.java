package com.ssafy.happyhouse.dao;

import java.util.List;

import com.ssafy.happyhouse.dto.QnA;

public interface QnADAO {
	//질문 관리
	public List<QnA> selectQnA();  
	public QnA selectQnAByNo(int no);
	public int insertQnA(QnA qna);
	public int deleteQnA(int no);
	public int updateQnA(QnA qna);
	//댓글 관리
	public int updateReply(QnA qna);
	public int deleteReply(int no);
}
