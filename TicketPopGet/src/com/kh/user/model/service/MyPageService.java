package com.kh.user.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.concert.model.vo.PageInfo;
import com.kh.user.model.dao.MyPageDao;
import com.kh.user.model.vo.MyPageShow;

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
	public ArrayList<MyPageShow> selectShowList(String userId, PageInfo pi){
		
		Connection conn = getConnection();
		
		ArrayList<MyPageShow> mps = new MyPageDao().selectShowList(conn, userId, pi);
		
		close(conn);
		
		return mps;
		
	}

}
