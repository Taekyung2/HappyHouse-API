package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.Dong;

public interface DongService {
	public List<Dong> retrieveDong(String gugun, String dong);

}
