package com.kh.hkid.diary.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.kh.hkid.common.vo.PageInfo;
import com.kh.hkid.diary.model.vo.Diary;

public interface DiaryService {
	int selectDiaryCount(int memberNo);
	
	ArrayList<Diary> selectMyDiaryList(PageInfo pi, int memberNo);
	
	int insertDiary(Diary d);
	
	Diary detailDiary(Diary d);
	
	int deleteDiary(Diary d);
}
