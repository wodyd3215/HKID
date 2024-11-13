package com.kh.hkid.diary.service;

import java.util.ArrayList;

import com.kh.hkid.common.vo.PageInfo;
import com.kh.hkid.diary.model.vo.Diary;

public interface DiaryService {
	int selectDiaryCount(int memberNo);
	
	ArrayList<Diary> selectMyDiaryList(PageInfo pi, int memberNo);
}
