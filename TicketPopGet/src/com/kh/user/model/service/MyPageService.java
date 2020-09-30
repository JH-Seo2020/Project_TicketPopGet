package com.kh.user.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

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
	public int selectListCount(String userId) {
		
		Connection conn = getConnection();
		
		int listCount = new MyPageDao().selectListCount(conn, userId);
		
		close(conn);
		return listCount;
		
	}
	
	
	/**
	 * 나의관람공연 리스트 조회
	 * @param pi
	 * @return
	 * @author 이금이
	 */
	public ArrayList<MyPage> selectShowList(String userId, PageInfo pi){
		
		Connection conn = getConnection();
		
		ArrayList<MyPage> mps = new MyPageDao().selectShowList(conn, userId, pi);
		
		close(conn);
		
		return mps;
		
	}
	
	/**
	 * 나의관람 컨텐츠분류 개수 조회
	 * @param content
	 * @param userId
	 * @return
	 */
	public int selectShowContnetCount(String content, String userId) {
		
		Connection conn = getConnection();
		
		int listCount = new MyPageDao().selectShowContnetCount(conn, content, userId);
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
	public ArrayList<MyPage> selectShowContnetList(String userId, PageInfo pi, String content){
		
		Connection conn = getConnection();
		
		ArrayList<MyPage> mp = new MyPageDao().selectShowContnetList(conn, userId, content, pi);
		
		close(conn);
		
		return mp;
	}
	
	/**
	 * 후기 개수조회
	 * @param userId
	 * @return
	 */
	public int selectReviewListCount(String userId) {
		
		Connection conn = getConnection();
		
		int listCount = new MyPageDao().selectReviewListCount(conn, userId);
		
		close(conn);
		return listCount;
		
	}
	
	/**
	 * 후기리스트조회
	 * @param userId
	 * @param pi
	 * @return
	 */
	public ArrayList<MyPage> selectReviewList(String userId, PageInfo pi){
		
		Connection conn = getConnection();
		
		ArrayList<MyPage> mps = new MyPageDao().selectReviewList(conn, userId, pi);
		
		close(conn);
		
		return mps;
		
	}
	
	/**
	 * 나의후기 컨텐츠분류 개수 조회
	 * @param content
	 * @param userId
	 * @return
	 */
	public int selectReviewContnetCount(String content, String userId) {
		
		Connection conn = getConnection();
		
		int listCount = new MyPageDao().selectReviewContnetCount(conn, content, userId);
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
	public ArrayList<MyPage> selectReviewContnetList(String userId, PageInfo pi, String content){
		
		Connection conn = getConnection();
		
		ArrayList<MyPage> mp = new MyPageDao().selectReviewContnetList(conn, userId, content, pi);
		
		close(conn);
		
		return mp;
	}
	
	
	
		
	/**
	 * 나의홍보글 개수조회
	 * @param userId
	 * @return
	 */
	public int selectAdboardListCount(String userId) {
		
		Connection conn = getConnection();
		
		int listCount = new MyPageDao().selectAdboardListCount(conn, userId);
		
		close(conn);
		return listCount;
		
	}
	
	/**
	 * 나의홍보글 리스트조회
	 * @param userId
	 * @param pi
	 * @return
	 */
	public ArrayList<AdBoard> selectAdboardList(String userId, PageInfo pi){
		
		Connection conn = getConnection();
		
		ArrayList<AdBoard> ad = new MyPageDao().selectAdboardList(conn, userId, pi);
		
		close(conn);
		
		return ad;
		
	}
	
	/**
	 * 나의 홍보글 컨텐츠분류 개수 조회
	 * @param content
	 * @param userId
	 * @return
	 */
	public int selectAdboardContnetCount(String content, String userId) {
		
		Connection conn = getConnection();
		
		int listCount = new MyPageDao().selectAdboardContnetCount(conn, content, userId);
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
	public ArrayList<AdBoard> selectAdboardContentList(String userId, PageInfo pi, String content){
		
		Connection conn = getConnection();
		
		ArrayList<AdBoard> ad = new MyPageDao().selectAdboardContentList(conn, userId, content, pi);
		
		close(conn);
		
		return ad;
	}
	



}
