package com.kh.hkid.diary.model.dao;

import java.util.ArrayList;

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
}
