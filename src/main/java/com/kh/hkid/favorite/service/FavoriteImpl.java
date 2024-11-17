package com.kh.hkid.favorite.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.kh.hkid.favorite.model.vo.Favorite;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FavoriteImpl implements FavoriteService{

	@Override
	public ArrayList<Favorite> selectList() {
		return null;
	}

}
