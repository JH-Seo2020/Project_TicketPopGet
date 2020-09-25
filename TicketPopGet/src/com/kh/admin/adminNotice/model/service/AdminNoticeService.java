package com.kh.admin.adminNotice.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.admin.adminMember.model.vo.Page;
import com.kh.admin.adminNotice.model.dao.AdminNoticeDao;
import com.kh.admin.adminNotice.model.vo.Notice;

public class AdminNoticeService {
	

	/**
	 *  공지사항수 조회용 서비스
	 * @return 게시중인 공지사항 수
	 */
	public int selectNoticeListCount() {
		
		Connection conn = getConnection();
		
		int result = new AdminNoticeDao().selectNoticeListCount(conn);
		
		close(conn);
		
		return result;
		
	}
	
	/**
	 *  공지사항 조회용 서비스
	 * @return 게시중인 전체 공지사항
	 */
	public ArrayList<Notice> selectNoticeList(Page p) {
		
		Connection conn = getConnection();
		
		ArrayList<Notice> list = new AdminNoticeDao().selectNoticeList(conn, p);
		
		close(conn);
		
		return list;
	}
	
	/**
	 * 공지사항 검색수 조회용 서비스
	 * @param key 검색어
	 * @return 검색된 공지사항수
	 */
	public int searchNoticeListCount(String key) {
		
		Connection conn = getConnection();
		
		int result = new AdminNoticeDao().searchNoticeListCount(conn, key);
		
		close(conn);
		
		return result;
	}
	
	/**
	 * 공지사항 검색용 서비스
	 * @param key 검색어
	 * @return 검색결과에 해당하는 공지사항리스트
	 */
	public ArrayList<Notice> searchNoticeList(Page p, String key){
		
		Connection conn = getConnection();
		
		ArrayList<Notice> list = new AdminNoticeDao().searchNoticeList(conn, key, p);
		
		close(conn);
		
		return list;
	}
	
}
