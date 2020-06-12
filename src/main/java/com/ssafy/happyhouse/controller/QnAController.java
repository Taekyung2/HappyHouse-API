package com.ssafy.happyhouse.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.QnA;
import com.ssafy.happyhouse.service.QnAService;

import io.swagger.annotations.ApiOperation;

//http://localhost:9999/happyhouse/swagger-ui.html
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/qna")
public class QnAController {

	private static final Logger logger = LoggerFactory.getLogger(QnAController.class);

	@Autowired
	private QnAService qnaService;

    @ApiOperation(value = "모든 질문게시판 정보를 반환한다.", response = List.class)
	@GetMapping
	public ResponseEntity<List<QnA>> retrieveQnA() throws Exception {
		logger.debug("retrieveQnA- 호출");
		return new ResponseEntity<List<QnA>>(qnaService.retrieveQnA(), HttpStatus.OK);
	}

    @ApiOperation(value = "해당 질문의  자세한 정보를 반환한다.")
    @GetMapping("{no}")
    public ResponseEntity<QnA> detailQnA(@PathVariable("no")int no) throws Exception {
    	logger.debug("detailQnA- 호출");
    	return new ResponseEntity<QnA>(qnaService.detailQnA(no), HttpStatus.OK);
    }
    
    
    @ApiOperation(value = "질문 작성.")
    @PostMapping
    public int writeQnA(@RequestBody QnA qna) throws Exception {
    	logger.debug("writelQnA- 호출");
    	return qnaService.writeQnA(qna);
    }
    
    @ApiOperation(value = "질문 삭제.")
    @DeleteMapping("{no}")
    public int removeQnA(@PathVariable("no")int no) throws Exception {
    	logger.debug("removeQnA- 호출");
    	return qnaService.removeQnA(no);
    }
    
    @ApiOperation(value = "질문 수정.")
    @PutMapping
    public int renewQnA(@RequestBody QnA qna) throws Exception {
    	logger.debug("renewQnA- 호출");
    	return qnaService.renewQnA(qna);
    }
    
    @ApiOperation(value = "답변 작성 및 수정.")
    @PutMapping("reply")
    public int renewReply(@RequestBody QnA qna) throws Exception {
    	logger.debug("renewReply- 호출");
    	qna.setReplyUserid("admin");
    	return qnaService.renewReply(qna);
    }
    
    @ApiOperation(value = "답변 삭제.")
    @DeleteMapping("reply/{no}")
    public int removeReply(@PathVariable("no")int no) throws Exception {
    	System.out.println("no="+no);
    	logger.debug("removeReply- 호출");
    	return qnaService.deleteReply(no);
    }
    
    
    
    
    
    
    
    
}