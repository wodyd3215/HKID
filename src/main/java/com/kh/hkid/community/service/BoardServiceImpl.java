package com.kh.hkid.community.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.hkid.common.vo.PageInfo;
import com.kh.hkid.community.model.dao.BoardDao;
import com.kh.hkid.community.model.dto.CommentReply;
import com.kh.hkid.community.model.dto.Community;
import com.kh.hkid.community.model.vo.Board;
import com.kh.hkid.community.model.vo.Reply;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private final SqlSessionTemplate sqlSession;
	
	@Autowired
	private final BoardDao boardDao;
	
	@Override
	public int selectListCount() {
		return boardDao.selectListCount(sqlSession);
	}
	
	@Override
	public ArrayList<Community> selectList(PageInfo pi) {
		return boardDao.selectList(sqlSession, pi);
	}

	@Override
	public int selectCategoryListCount(String category) {
		return boardDao.selectCategoryListCount(sqlSession, category);
	}

	@Override
	public ArrayList<Community> selectCategoryList(PageInfo pi, String category) {
		return boardDao.selectCategoryList(sqlSession, pi, category);
	}

	@Override
	public ArrayList<Community> selectNoticeList() {
		
		return boardDao.selectNoticeList(sqlSession);
	}

	@Override
	public int selectSearchCount(HashMap<String, String> map) {
		return boardDao.selectSearchCount(sqlSession, map);
	}

	@Override
	public ArrayList<Community> selectSearchList(HashMap<String, String> map, PageInfo pi) {
		return boardDao.selectSearchList(sqlSession, map, pi);
	}

	
	@Override
	public Board selectBoard(int bno) {
		Board b = boardDao.selectBoard(sqlSession, bno);
		if(b != null) {
			boardDao.increaseView(sqlSession, bno);
		}
		return b; //해당 게시글 가져오기;
	}

	@Override
	public int deleteboard(int bno) {
		return boardDao.deleteboard(sqlSession, bno);
	}
	
	
	@Override
	public int selectReportedUserNo(int bno) {
		return boardDao.selectReportedUserNo(sqlSession, bno);
	}
	

	@Override
	public int insertReport(HashMap<String, Object> map) {
		return boardDao.insertReport(sqlSession, map);
	}
	
	@Override
	public int insertBoard(Board b) {
		int result = 0;
		if(boardDao.insertBoard(sqlSession, b) > 0) {
			result = boardDao.insertBoardFile(sqlSession, b);
		}
		return result;
	}

	@Override
	public int updateBoard(Board b) {
		int result = 0;
		if(boardDao.updateBoard(sqlSession, b) > 0) {
			result = boardDao.updateBoardFile(sqlSession, b);
		}
		
		return boardDao.updateBoard(sqlSession, b);
	}
	
	@Override
	public int selectExistGood(HashMap<String, Integer> map) {
		return boardDao.checkGood(sqlSession, map); // 공통기능인 checkGood()사용
	}


	//좋아요 생성
	@Override
	public int insertGood(HashMap<String, Integer> map) {
		return boardDao.insertGood(sqlSession, map);
	}

	//좋아요를 누른 적이 있는지
	@Override
	public int checkGood(HashMap<String, Integer> map) {
		int result = 0;
		
		//로그인하지 않았으면 (빈하트)
		if((map.get("memberNo")) == null){
			return 0;
		}
		//좋아요를 클릭했던 적이 있으면 1
		if(boardDao.checkGood(sqlSession, map) > 0) {
			if(boardDao.checkGoodStatus(sqlSession, map) == 'Y') {
				result = 1;
			}
		}
		return result;
	}

	//좋아요 수정
	@Override
	public int updateGood(HashMap<String, Object> map) {
		return boardDao.updateGood(sqlSession, map);
	}

	@Override
	public int countGood(int boardNo) {
		return boardDao.countGood(sqlSession, boardNo);
	}

	@Override
	public ArrayList<CommentReply> selectReplyList(int boardNo) {
		return boardDao.selectReplyList(sqlSession, boardNo);
	}

	@Override
	public int insertReply(Reply r) {
		return boardDao.insertReply(sqlSession, r);
	}

	@Override
	public int deleteReply(HashMap<String, Integer> map) {
		return boardDao.deleteReply(sqlSession, map);
	}

	@Override
	public int updateReply(Reply r) {
		return boardDao.updateReply(sqlSession, r);
	}
	
	

	
}