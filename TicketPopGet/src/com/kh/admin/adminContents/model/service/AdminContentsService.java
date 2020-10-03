package com.kh.admin.adminContents.model.service;

import static com.kh.common.JDBCTemplate.*;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.admin.adminContents.model.dao.AdminContentsDao;
import com.kh.admin.adminContents.model.vo.Contents;
import com.kh.admin.adminMember.model.vo.Page;

public class AdminContentsService {
	
	/**
	 * 컨텐츠수 조회용 서비스
	 * @return 조회된 수
	 */
	public int contentsListCount() {
		Connection conn = getConnection();
		
		int result = new AdminContentsDao().contentsListCount(conn);
		
		close(conn);
		return result;
	}
	
	/**
	 * 컨텐츠 조회용 서비스
	 * @param p 페이징처리르 위한 페이지객체
	 * @return 조회된 컨텐츠리스트
	 */
	public ArrayList<Contents> contentsList(Page p) {
		Connection conn = getConnection();
		
		ArrayList<Contents> list = new AdminContentsDao().contentsList(conn, p);
		
		close(conn);
		
		return list;
	}
	
	/**
	 * 연극 등록용 서비스
	 * @param c 등록할 컨텐츠 객체
	 * @return 처리된 행 수
	 */
	public int insertPlay(Contents c) {
		Connection conn = getConnection();
		
		int result = new AdminContentsDao().insertPlay(conn, c);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}
	
}
