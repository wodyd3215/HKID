package com.kh.hkid.exercise.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.kh.hkid.common.vo.PageInfo;
import com.kh.hkid.exercise.model.vo.Exercise;

public interface ExerciseService {
	
	//운동 리스트 총 갯수 가져오기
	int selectListCount();
	
	//운동리스트 목록 가져오기
	ArrayList<Exercise> selectList(PageInfo pi);
	
	//운동리스트 필터 검색
	List<Exercise> search(HashMap<String, Object> filterMap, PageInfo pi);

}
