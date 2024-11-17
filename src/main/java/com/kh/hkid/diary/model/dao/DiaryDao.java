package com.kh.hkid.diary.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.hkid.common.vo.PageInfo;
import com.kh.hkid.diary.model.vo.Diary;

@Repository
public class DiaryDao {
	
	public int selectDiaryCount(SqlSessionTemplate sqlSession, int memberNo) {
		return sqlSession.selectOne("diaryMapper.selectDiaryCount", memberNo);
	}
	
	public ArrayList<Diary> selectMyDiaryList(SqlSessionTemplate sqlSession, PageInfo pi, int memberNo) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		
		return (ArrayList)sqlSession.selectList("diaryMapper.selectMyDiaryList", memberNo, rowBounds);
	}
	
	public int insertDiary(SqlSessionTemplate sqlSession, Diary d) {
		return sqlSession.insert("diaryMapper.insertDiary" , d);
	}
	
	public Diary detailDiary(SqlSessionTemplate sqlSession, Diary d) {
		return sqlSession.selectOne("diaryMapper.detailDiary", d);
	}
	
	public int deleteDiary(SqlSessionTemplate sqlSession, Diary d) {
		return sqlSession.delete("diaryMapper.deleteDiary", d);
	}
	
	public int updateDiary(SqlSessionTemplate sqlSession, Diary d) {
		return sqlSession.update("diaryMapper.updateDiary", d);
	}
}
