package com.kh.user.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.concert.model.vo.PageInfo;
import com.kh.user.model.dao.MyPageDao;
import com.kh.user.model.vo.MyPageShow;

public class MyPageService {
	
	public int selectShowListCount(String userId) {
		
		Connection conn = getConnection();
		
		int listCount = new MyPageDao().selectShowListCount(conn, userId);
		
		close(conn);
		return listCount;
		
	}
	
	public ArrayList<MyPageShow> selectShowList(PageInfo pi){
		
		Connection conn = getConnection();
		
		ArrayList<MyPageShow> list = new MyPageDao().selectShowList(conn, pi);
		
		close(conn);
		
		return list;
		
	}

}
