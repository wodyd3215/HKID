package com.kh.hkid.admin.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.hkid.common.vo.PageInfo;
import com.kh.hkid.community.model.vo.Board;

@Repository
public class AdminDao {
	public int noticeCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("adminMapper.noticeCount");
	}
	
	public ArrayList<Board> selectNotice(SqlSessionTemplate sqlSession, PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("adminMapper.selectNotice", null, rowBounds);
	}
}
