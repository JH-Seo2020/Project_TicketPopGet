package com.kh.contents.model.service;

import static com.kh.common.JDBCTemplate.*;
import java.sql.Connection;
import java.util.ArrayList;

import com.kh.contents.model.dao.ContentsDao;
import com.kh.contents.model.vo.Contents;
import com.kh.contents.model.vo.PageInfo;

public class ContentsService {
	
	/**
	 * 1. 콘서트 컨텐츠 개수 조회용 서비스
	 * @return 			콘서트 컨텐츠의 총 개수
	 * @author 			서지혜
	 */
	public int selectListCount() {
		
		Connection conn = getConnection();
		int result = new ContentsDao().selectListCount(conn);
		
		close(conn);
		
		return result;
	}

	/**
	 * 2. 요청한 페이지에 해당하는 컨텐츠 정보 리스트 조회용 서비스(재사용가능)
	 * @param pi 		페이징처리용 7개 변수 
	 * @return 			해당 페이지에 들어갈 컨텐츠 정보 리스트
	 * @author 			서지혜
	 */
	public ArrayList<Contents> selectList(PageInfo pi) {
		
		Connection conn = getConnection();
		
		ArrayList<Contents> list = new ContentsDao().selectList(conn, pi);
		
		close(conn);
		
		return list;
	}

}
