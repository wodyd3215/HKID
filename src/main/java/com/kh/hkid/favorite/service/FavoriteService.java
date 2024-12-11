package com.kh.hkid.favorite.service;

import java.util.ArrayList;

import com.kh.hkid.common.vo.PageInfo;
import com.kh.hkid.favorite.model.vo.Favorite;

public interface FavoriteService {

	// 찜 목록 리스트 가져오기
	int selectListCount(int memberNo);

	// 찜목록 조회
	ArrayList<Favorite> selectList(int memberNo, PageInfo pi);	



}
