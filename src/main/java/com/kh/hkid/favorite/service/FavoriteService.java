package com.kh.hkid.favorite.service;

import java.util.ArrayList;

import com.kh.hkid.favorite.model.vo.Favorite;

public interface FavoriteService {

	// 찜목록 조회
	ArrayList<Favorite> selectList(int memberNo);

}
