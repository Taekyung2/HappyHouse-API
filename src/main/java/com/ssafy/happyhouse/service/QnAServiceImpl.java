package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.QnADAO;
import com.ssafy.happyhouse.dto.QnA;

@Service
public class QnAServiceImpl implements QnAService {

	@Autowired
	private QnADAO dao;
	
	@Override
	public List<QnA> retrieveQnA() {
		return dao.selectQnA();
	}

	@Override
	public QnA detailQnA(int no) {
		return dao.selectQnAByNo(no);
	}

	@Override
	public int writeQnA(QnA qna) {
		return dao.insertQnA(qna);
	}

	@Override
	public int removeQnA(int no) {
		return dao.deleteQnA(no);
	}

	@Override
	public int renewQnA(QnA qna) {
		return dao.updateQnA(qna);
	}

	@Override
	public int renewReply(QnA qna) {
		return dao.updateReply(qna);
	}

	@Override
	public int deleteReply(int no) {
		return dao.deleteReply(no);
	}

}
