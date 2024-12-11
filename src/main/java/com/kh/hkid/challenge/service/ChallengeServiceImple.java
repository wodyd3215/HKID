package com.kh.hkid.challenge.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.hkid.admin.model.vo.Notice;
import com.kh.hkid.challenge.model.dao.ChallengeDao;
import com.kh.hkid.challenge.model.vo.Challenge;
import com.kh.hkid.challenge.model.vo.ChallengeBoard;
import com.kh.hkid.common.vo.PageInfo;
import com.kh.hkid.community.model.vo.Board;
import com.kh.hkid.exercise.model.dao.ExerciseDao;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ChallengeServiceImple implements ChallengeService {

	@Autowired
	private final SqlSessionTemplate sqlSession;
	
	@Autowired
	private final ChallengeDao challengeDao;
	
	@Override
	public int boardCount() {
		return challengeDao.boardCount(sqlSession);
	}

	@Override
	public ArrayList<Challenge> selectList(PageInfo pi) {
		return challengeDao.selectList(sqlSession, pi);
	}

	@Override
	public int challengeBoardCount(int cno) {
		return challengeDao.challengeBoardCount(sqlSession, cno);
	}

	@Override
	public ArrayList<ChallengeBoard> chBoardselectList(int cno, PageInfo pi) {
		return challengeDao.challengeBoardList(sqlSession, cno, pi);
	}

	@Override
	public Challenge selectName(int cno) {
		return challengeDao.selectName(sqlSession, cno);
	}

	
	//검새된 보드 총갯수
	@Override
	public int selectSearchCount(HashMap<String, Object> map) {
	    return challengeDao.selectSearchCount(sqlSession, map);
	}

	//검색된 보드 리스트
	@Override
	public ArrayList<ChallengeBoard> selectSearchList(HashMap<String, Object> map, PageInfo pi) {
	    return challengeDao.selectSearchList(sqlSession, map, pi);
	}

	@Override
	public ChallengeBoard selectBoard(int cbno) {
		ChallengeBoard c = challengeDao.selectBoard(sqlSession, cbno);
		if(c != null) {
			challengeDao.increaseView(sqlSession, cbno);
		}	
		return c; //해당 게시글 가져오기;
	}

	@Override
	public int insertBoard(ChallengeBoard c) {
		int result = challengeDao.insertBoard(sqlSession, c);
	    if (result > 0) {
	        result = challengeDao.insertBoardFile(sqlSession, c); 
	    } else {
	        throw new RuntimeException("게시글 삽입 실패");
	    }
	    return result;
	}

	//공지
	@Override
	public ArrayList<Notice> selectNoticeList(PageInfo pi) {
		return challengeDao.selectNoticeList(sqlSession, pi);
	}

	//게시글 수정
	@Transactional
	@Override
	public int updateBoard(ChallengeBoard c) {
		int result = challengeDao.updateBoard(sqlSession, c); // 게시글 수정
	    if (result > 0) {
	        result = challengeDao.updateBoardFile(sqlSession, c); // 첨부 파일 수정
	    } else {
	        throw new RuntimeException("게시글 수정 실패");
	    }
	    return result;
	}

	//게시글 삭제
	@Transactional
	@Override
	public int deleteboard(int cbno) {
		return challengeDao.deleteboard(sqlSession, cbno);
	}

	@Override
	public ChallengeBoard selectCno(int cbno) {
		return challengeDao.selectCno(sqlSession, cbno);
	}

	

}
