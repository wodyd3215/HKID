package com.kh.hkid.community.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Transactional
	@Override
	public int insertBoard(Board b) {
	    int result = boardDao.insertBoard(sqlSession, b);
	    if (result > 0) {
	        result = boardDao.insertBoardFile(sqlSession, b); 
	    } else {
	        throw new RuntimeException("게시글 삽입 실패");
	    }
	    return result;
	}


	@Transactional
	@Override
	public int updateBoard(Board b) {
	    int result = boardDao.updateBoard(sqlSession, b); // 게시글 수정
	    if (result > 0) {
	        result = boardDao.updateBoardFile(sqlSession, b); // 첨부 파일 수정
	    } else {
	        throw new RuntimeException("게시글 수정 실패");
	    }
	    return result;
	}

	
	//좋아요를 누른 적이 있는지
	@Override
	public int checkGood(HashMap<String, Integer> map) {
		return boardDao.checkGood(sqlSession, map);
	}

	//좋아요 수정
	@Override
	public int updateGood(HashMap<String, Object> map) {
		//좋아요 상태변경
		int result = boardDao.updateGood(sqlSession, map);
		int boardNo = (int) map.get("boardNo");
		
		if(result > 0) {
			return boardDao.countGood(sqlSession, boardNo);
		}else {
			return 0;
		}
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