package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.DongDAO;
import com.ssafy.happyhouse.dto.Dong;

@Service
public class DongServiceImpl implements DongService {
	
	@Autowired
	private DongDAO dao;

	@Override
	public List<Dong> retrieveDong(String gugun, String dong) {
		return dao.selectDong(gugun, dong);
	}

}
