package com.ssafy.happyhouse.controller;

import java.util.List;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.Dong;
import com.ssafy.happyhouse.service.DongService;

//http://localhost:9999/happyhouse/swagger-ui.html
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/dong")
public class DongController {

	private static final Logger logger = LoggerFactory.getLogger(DongController.class);

	@Autowired
	private DongService dongService;

	@GetMapping("/{path}")
    public ResponseEntity<List<Dong>> detailQnA(@PathVariable("path")String path) throws Exception {
		System.out.println("진입");
		System.out.println("path="+path);
		StringTokenizer st = new StringTokenizer(path,"-");
		String gugun = st.nextToken();
		String dong = st.nextToken();
		System.out.println("gugun="+gugun);
		System.out.println("dong="+dong);
		System.out.println(dongService.retrieveDong(gugun, dong));
    	return new ResponseEntity<List<Dong>>(dongService.retrieveDong(gugun, dong), HttpStatus.OK);
    }
    
    
    
    
    
    
    
    
}