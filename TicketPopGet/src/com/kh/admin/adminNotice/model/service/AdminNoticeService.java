package com.kh.admin.adminNotice.model.service;

import static com.kh.common.JDBCTemplate.*;
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
	 * 공지사항 타입설정후 검색시 검색수 조회용 서비스
	 * @param key		검색어
	 * @param type		검색타입
	 * @return			공지사항수
	 */
	public int searchNoticeListKeyTypeCount(String key, String type) {
		
		Connection conn = getConnection();
		
		int result = new AdminNoticeDao().searchNoticeListKeyTypeCount(conn, key, type);
		
		close(conn);
		
		return result;
	}
	
	/**
	 * 공지사항 타입만설정후 검색어 없이 검색시 검색수 조회용 서비스
	 * @param type		검색타입
	 * @return			공지사항수
	 */
	public int searchNoticeListTypeCount(String type) {
		
		Connection conn = getConnection();
		
		int result = new AdminNoticeDao().searchNoticeListTypeCount(conn, type);
		
		close(conn);
		
		return result;
	}
	
	/**
	 * 공지사항 검색용 서비스
	 * @param key 검색어
	 * @return 검색결과에 해당하는 공지사항리스트
	 */
	public ArrayList<Notice> searchNoticeList(Page p, String key, String type){
		
		Connection conn = getConnection();
		
		ArrayList<Notice> list = new AdminNoticeDao().searchNoticeList(conn, key, p, type);
		
		close(conn);
		
		return list;
	}
	
	/**
	 * 공지사항 등록용 서비스
	 * @param n		등록할 공지사항 제목, 내용, 타입 이 담겨있는 공지사항 객체
	 * @return		처리된 행 수
	 */
	public int insertNotice(Notice n) {
		
		Connection conn = getConnection();
		
		int result = new AdminNoticeDao().insertNotice(conn, n);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}
	
	/**
	 * 공지사항 조회/수정 용 서비스
	 * @param noticeNo	조회할 공지사항 번호
	 * @return			조회된 공지사항
	 */
	public Notice selectUpdateNotice(int noticeNo) {
		
		Connection conn = getConnection();
		
		Notice n = new AdminNoticeDao().selectUpdateNotice(conn, noticeNo);
		
		close(conn);
		
		return n;
	}
	
	/**
	 * 공지사항 수정용 서비스
	 * @param n			수정할 제목,내용,타입 이 들어있는 객체
	 * @return			처리된 행 수
	 */
	public int updateNotice(Notice n) {
		
		Connection conn = getConnection();
		
		int result = new AdminNoticeDao().updateNotice(conn, n);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
	}
	
	/**
	 * 공지사항 삭제용 서비스
	 * @param noticeNo 삭제할 공지사항 번호
	 * @return 저리된 행 수
	 */
	public int deleteNotice(int noticeNo) {
	
		Connection conn = getConnection();
		
		int result = new AdminNoticeDao().deleteNotice(conn, noticeNo);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}
	
	
}
