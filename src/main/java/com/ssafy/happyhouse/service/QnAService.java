package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.QnA;

public interface QnAService {
	//질문
	public List<QnA> retrieveQnA();
	public QnA detailQnA(int no);
	public int writeQnA(QnA qna);
	public int removeQnA(int no);
	public int renewQnA(QnA qna);
	//댓글
	public int renewReply(QnA qna);
	public int deleteReply(int no);

}
