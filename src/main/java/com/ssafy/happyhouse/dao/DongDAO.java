package com.ssafy.happyhouse.dao;

import java.util.List;

import com.ssafy.happyhouse.dto.Dong;

public interface DongDAO {
	
	public List<Dong> selectDong(String gugun, String dong);

}
