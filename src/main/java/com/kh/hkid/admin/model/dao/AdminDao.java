package com.kh.hkid.admin.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.hkid.admin.model.vo.AccRecovery;
import com.kh.hkid.admin.model.vo.Notice;
import com.kh.hkid.admin.model.vo.Report;
import com.kh.hkid.admin.model.vo.SuspensionMember;
import com.kh.hkid.challenge.model.vo.Challenge;
import com.kh.hkid.common.vo.PageInfo;
import com.kh.hkid.community.model.dto.BoardInfo;
import com.kh.hkid.community.model.vo.Board;
import com.kh.hkid.product.model.vo.Product;

@Repository
public class AdminDao {
	public int noticeCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("adminMapper.noticeCount");
	}
	
	public ArrayList<Notice> selectNoticeList(SqlSessionTemplate sqlSession, PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("adminMapper.selectNoticeList", null, rowBounds);
	}
	
	public int insertNotice(SqlSessionTemplate sqlSession, Notice n) {
		return sqlSession.insert("adminMapper.insertNotice", n);
	}
	
	public int deleteNotice(SqlSessionTemplate sqlSession, int noticeNo) {
		return sqlSession.delete("adminMapper.deleteNotice", noticeNo);
	}
	
	public Notice selectNotice(SqlSessionTemplate sqlSession, int noticeNo) {
		return sqlSession.selectOne("adminMapper.selectNotice", noticeNo);
	}
	
	public int updateNotice(SqlSessionTemplate sqlSession, Notice n) {
		return sqlSession.update("adminMapper.updateNotice", n);
	}
	
	public int reportCount(SqlSessionTemplate sqlSession, String category) {
		return sqlSession.selectOne("adminMapper.reportCount", category);
	}
	
	public ArrayList<Report> selectReportList(SqlSessionTemplate sqlSession, PageInfo pi, String categoty) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("adminMapper.selectReportList", categoty, rowBounds);
	}
		
	public int deleteReportTarget(SqlSessionTemplate sqlSession, Report r) {
		return sqlSession.delete("adminMapper.deleteReportTarget", r);
	}
	
	public int insertsuspension(SqlSessionTemplate sqlSession, SuspensionMember sm) {
		return sqlSession.insert("adminMapper.insertsuspension", sm);
	}
	
	public int updateStatus(SqlSessionTemplate sqlSession, SuspensionMember sm) {
		return sqlSession.update("adminMapper.updateSuspension", sm);
	}
	
	public int deleteReport(SqlSessionTemplate sqlSession, int reportNo) {
		return sqlSession.delete("adminMapper.deleteReport", reportNo);
	}
	
	public int recoveryCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("adminMapper.recoveryCount");
	}
	
	public ArrayList<AccRecovery> selectRecoveryList(SqlSessionTemplate sqlSession, PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("adminMapper.selectRecoveryList", null, rowBounds);
	}
	
	public int recoveryAccount(SqlSessionTemplate sqlSession, int memberNo) {
		return sqlSession.update("adminMapper.recoveryAccount", memberNo);
	}
	
	public int deleteRecovery(SqlSessionTemplate sqlSession, int memberNo) {
		return sqlSession.delete("adminMapper.deleteRecovery", memberNo);
	}
	
	public int insertProduct(SqlSessionTemplate sqlSession, Product p) {
		return sqlSession.insert("productMapper.insertProduct", p);
	}
	
	public int insertAttachment(SqlSessionTemplate sqlSession, String files) {
		return sqlSession.insert("productMapper.insertAttachment", files);
	}
	
	public Product editProduct(SqlSessionTemplate sqlSession, int productNo) {
		return sqlSession.selectOne("productMapper.selectEditProduct", productNo);
	}
	
	public int deactivateProduct(SqlSessionTemplate sqlSession, int productNo) {
		return sqlSession.update("productMapper.deactivateProduct", productNo);
	}
	
	public int activateProduct(SqlSessionTemplate sqlSession, int productNo) {
		return sqlSession.update("productMapper.activateProduct", productNo);
	}
	
	public int updateAttachment(SqlSessionTemplate sqlSession, HashMap<String, Object> aMap) {
		return sqlSession.update("productMapper.updateAttachment", aMap);
	}
	
	public int updateProduct(SqlSessionTemplate sqlSession, Product p) {
		return sqlSession.update("productMapper.updateProduct", p); 
	}
	
	public int challengeCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("challengeMapper.boardCount");
	}
	
	public ArrayList<Challenge> selectChallengeList(SqlSessionTemplate sqlSession, PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("challengeMapper.selectList", null, rowBounds);
	}
	
	public int insertChallenge(SqlSessionTemplate sqlSession, Challenge ch) {
		return sqlSession.insert("challengeMapper.insertChallenge", ch);
	}
	
	public Board loadBoardAjax(SqlSessionTemplate sqlSession, int boardNo) {
		return sqlSession.selectOne("boardMapper.selectBoard", boardNo);
	}
	
	public int pCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("productMapper.pCount");
	}
	
	public ArrayList<Product> selecProductList(SqlSessionTemplate sqlSession, PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("productMapper.selectProductList", null, rowBounds);
	}
}
