package com.kh.user.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.community.adBoard.model.vo.AdBoard;
import com.kh.user.model.dao.MyPageDao;
import com.kh.user.model.vo.MyPage;
import com.kh.user.model.vo.PageInfo;

public class MyPageService {
	
	/**
	 * 나의관람공연 개수 조회
	 * @return
	 * @author 이금이
	 */
	public int selectListCount(int userNo) {
		
		Connection conn = getConnection();
		
		int listCount = new MyPageDao().selectListCount(conn, userNo);
		
		close(conn);
		return listCount;
		
	}
	
	
	/**
	 * 나의관람공연 리스트 조회
	 * @param pi
	 * @return
	 * @author 이금이
	 */
	public ArrayList<MyPage> selectShowList(int userNo, PageInfo pi){
		
		Connection conn = getConnection();
		
		ArrayList<MyPage> mps = new MyPageDao().selectShowList(conn, userNo, pi);
		
		close(conn);
		
		return mps;
		
	}
	
	/**
	 * 나의관람 컨텐츠분류 개수 조회
	 * @param content
	 * @param userId
	 * @return
	 */
	public int selectShowContnetCount(String content, int userNo) {
		
		Connection conn = getConnection();
		
		int listCount = new MyPageDao().selectShowContnetCount(conn, content, userNo);
		close(conn);
		return listCount;
		
	}
	
	/**
	 * 나의 관람 컨텐츠분류 리스트
	 * @param userId
	 * @param pi
	 * @param content
	 * @return
	 */
	public ArrayList<MyPage> selectShowContnetList(int userNo, PageInfo pi, String content){
		
		Connection conn = getConnection();
		
		ArrayList<MyPage> mp = new MyPageDao().selectShowContnetList(conn, userNo, content, pi);
		
		close(conn);
		
		return mp;
	}
	
	/**
	 * 후기작성시 가져올 값 [컨텐츠분류, 공연명, 관람일]
	 * @param tno
	 * @return
	 */
	public MyPage selectReviewWrite(int tno) {
		Connection conn = getConnection();
		
		MyPage mp = new MyPageDao().selectReviewWrite(conn, tno);
		
		close(conn);
		
		return mp;
	}
	
	/**
	 * 후기 개수조회
	 * @param userId
	 * @return
	 */
	public int selectReviewListCount(int userNo) {
		
		Connection conn = getConnection();
		
		int listCount = new MyPageDao().selectReviewListCount(conn, userNo);
		
		close(conn);
		return listCount;
		
	}
	
	/**
	 * 후기리스트조회
	 * @param userId
	 * @param pi
	 * @return
	 */
	public ArrayList<MyPage> selectReviewList(int userNo, PageInfo pi){
		
		Connection conn = getConnection();
		
		ArrayList<MyPage> mps = new MyPageDao().selectReviewList(conn, userNo, pi);
		
		close(conn);
		
		return mps;
		
	}
	
	/**
	 * 나의후기 컨텐츠분류 개수 조회
	 * @param content
	 * @param userId
	 * @return
	 */
	public int selectReviewContnetCount(String content, int userNo) {
		
		Connection conn = getConnection();
		
		int listCount = new MyPageDao().selectReviewContnetCount(conn, content, userNo);
		close(conn);
		return listCount;
		
	}
	
	/**
	 * 나의 후기 컨텐츠분류 리스트
	 * @param userId
	 * @param pi
	 * @param content
	 * @return
	 */
	public ArrayList<MyPage> selectReviewContnetList(int userNo, PageInfo pi, String content){
		
		Connection conn = getConnection();
		
		ArrayList<MyPage> mp = new MyPageDao().selectReviewContnetList(conn, userNo, content, pi);
		
		close(conn);
		
		return mp;
	}
	
	/**
	 * 나의 후기 상세확인[작성글빼고]
	 * @param rno
	 * @return
	 */
	public MyPage selectReviewDetail(int rno, int uno) {
		
		Connection conn = getConnection();
		
		MyPage mp = new MyPageDao().selectReviewDetail(conn, rno, uno);
		
		close(conn);
		
		return mp;
	}
	
	/**
	 * 나의 후기 세부사항[작성글]
	 * @param rno
	 * @param uno
	 * @return
	 */
	public String selectReviewContent(int rno, int uno) {
		Connection conn = getConnection();
		String content = new MyPageDao().selectReviewContent(conn,rno,uno);
		
		close(conn);
		return content;
		
	}
	
	/**
	 * 나의 후기 수정
	 * @param mp
	 * @param content
	 * @return
	 */
	public int reviewUpdate(MyPage mp, String content) {
		Connection conn = getConnection();
		int result = new MyPageDao().reviewUpdate(conn, mp, content);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}
	
	
	
		
	/**
	 * 나의홍보글 개수조회
	 * @param userId
	 * @return
	 */
	public int selectAdboardListCount(int userNo) {
		
		Connection conn = getConnection();
		
		int listCount = new MyPageDao().selectAdboardListCount(conn, userNo);
		
		close(conn);
		return listCount;
		
	}
	
	/**
	 * 나의홍보글 리스트조회
	 * @param userId
	 * @param pi
	 * @return
	 */
	public ArrayList<AdBoard> selectAdboardList(int userNo, PageInfo pi){
		
		Connection conn = getConnection();
		
		ArrayList<AdBoard> ad = new MyPageDao().selectAdboardList(conn, userNo, pi);
		
		close(conn);
		
		return ad;
		
	}
	
	/**
	 * 나의 홍보글 컨텐츠분류 개수 조회
	 * @param content
	 * @param userId
	 * @return
	 */
	public int selectAdboardContnetCount(String content, int userNo) {
		
		Connection conn = getConnection();
		
		int listCount = new MyPageDao().selectAdboardContnetCount(conn, content, userNo);
		close(conn);
		return listCount;
		
	}
	
	/**
	 * 나의 홍보글 컨텐츠분류 리스트
	 * @param userId
	 * @param pi
	 * @param content
	 * @return
	 */
	public ArrayList<AdBoard> selectAdboardContentList(int userNo, PageInfo pi, String content){
		
		Connection conn = getConnection();
		
		ArrayList<AdBoard> ad = new MyPageDao().selectAdboardContentList(conn, userNo, content, pi);
		
		close(conn);
		
		return ad;
	}
	
	/**
	 * 나의 홍보 세부사항 [작성글 뺴고]
	 * @param ano
	 * @return
	 */
	public AdBoard selectAdboardDetail(int ano, int uno) {
		
		Connection conn = getConnection();
		
		AdBoard ad = new MyPageDao().selectAdboardDetail(conn,ano,uno);
				
		close(conn);
		
		return ad;
	}
	
	/**
	 * 나의 홍보 세부사항[작성글]
	 * @return
	 */
	public String selectAdboardContent(int ano, int uno) {
		Connection conn = getConnection();	
		String content = new MyPageDao().selectAdboardContent(conn, ano,uno);
		
		close(conn);
		return content;
	}
	
	/**
	 * 나의 홍보 수정
	 * @param ad
	 * @param content
	 * @return
	 */
	public int adBoardUpdate(AdBoard ad, String content) {
		
		Connection conn = getConnection();
		int result = new MyPageDao().adBoardUpdate(conn, ad, content);
		
		if (result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}
	



}
