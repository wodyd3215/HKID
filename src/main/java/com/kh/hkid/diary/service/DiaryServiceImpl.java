package com.kh.hkid.diary.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.kh.hkid.common.vo.PageInfo;
import com.kh.hkid.diary.model.dao.DiaryDao;
import com.kh.hkid.diary.model.vo.Diary;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DiaryServiceImpl implements DiaryService{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private DiaryDao diaryDao;
	
	@Transactional
	@Override
	public int selectDiaryCount(int memberNo) {
		return diaryDao.selectDiaryCount(sqlSession, memberNo);
	}
	
	@Transactional
	@Override
	public ArrayList<Diary> selectMyDiaryList(PageInfo pi, int memberNo) {
		return diaryDao.selectMyDiaryList(sqlSession, pi, memberNo);
	}

	@Override
	public int insertDiary(Diary d) {
		return diaryDao.insertDiary(sqlSession, d);
	}

	@Override
	public Diary detailDiary(Diary d) {
		return diaryDao.detailDiary(sqlSession, d);
	}

	@Override
	public int deleteDiary(Diary d) {
		return diaryDao.deleteDiary(sqlSession, d);
	}
}
