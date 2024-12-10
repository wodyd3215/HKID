package com.kh.hkid.diary.service;

import java.util.ArrayList;

import com.kh.hkid.common.vo.PageInfo;
import com.kh.hkid.diary.model.vo.Diary;
import com.kh.hkid.diet.model.vo.Diet;

public interface DiaryService {
	int selectDiaryCount(int memberNo);
	
	ArrayList<Diary> selectMyDiaryList(PageInfo pi, int memberNo);
	
	int insertDiary(Diary d);
	
	Diary detailDiary(Diary d);
	
	Diet selectMyDiet(int foodNo);
	
	int deleteDiary(Diary d);
	
	int updateDiary(Diary d);
}
