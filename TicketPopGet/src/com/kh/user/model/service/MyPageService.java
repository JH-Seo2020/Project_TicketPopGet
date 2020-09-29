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
	 * 게시글 개수 조회
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
	 * 후기 개수조회
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
	 * 후기리스트조회
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


}
