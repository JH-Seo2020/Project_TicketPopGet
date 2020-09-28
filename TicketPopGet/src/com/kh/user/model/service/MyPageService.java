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
	 * 나의관람공연 리스트 조회
	 * @param pi
	 * @return
	 * @author 이금이
	 */
	public MyPageShow selectShowList(String userId){
		
		Connection conn = getConnection();
		
		MyPageShow mps = new MyPageDao().selectShowList(conn, userId);
		
		close(conn);
		
		return mps;
		
	}

}
