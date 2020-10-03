package com.kh.serviceCenter.model.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.serviceCenter.model.dao.ServiceDao;
import com.kh.serviceCenter.model.vo.Faq;
import com.kh.serviceCenter.model.vo.Notice;
import com.kh.serviceCenter.model.vo.PageInfo;

public class ServiceService {

	/**
	 * 총 공지사항 갯수 조회용 서비스
	 * @return		총 갯수
	 * @author 김현선
	 */
	public int noticeSelectListCount() {

		Connection conn = getConnection();

		int listCount = new ServiceDao().noticeSelectListCount(conn);
		
		close(conn);
		
		return listCount;
	}

	/** 
	 * 공지사항 리스트 조회용 서비스
	 * @param pi
	 * @return
	 * @author 김현선
	 */
	public ArrayList<Notice> noticeSelectList(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Notice> list = new ServiceDao().noticeSelectList(conn, pi);
		
		close(conn);
		
		return list;
	}
	
	/** 총 faq 갯수 조회용 서비스
	 * @return
	 * @author 김현선
	 */
	public int faqSelectListCount() {
		
		Connection conn = getConnection();
		
		int listCount = new ServiceDao().faqSelectListCount(conn);
		
		close(conn);
		
		return listCount;
		
	}

	/** faq 리스트 조회용 서비스
	 * @param pi
	 * @return
	 * @author 김현선
	 */
	public ArrayList<Faq> faqSelectList(PageInfo pi) {
		Connection conn = getConnection();
		
		
		ArrayList<Faq> list = new ServiceDao().faqSelectList(conn,pi);
		
		close(conn);
		
		return list;
	}
	
	/**
	 * 공지사항 타입별 조회 서비스
	 * @param type
	 * @return
	 */
	public int noticeTypeListCount(String type) {
		
		Connection conn = getConnection();
		
		int listCount = new ServiceDao().noticeTypeListCount(conn, type);
		
		close(conn);
		
		return listCount;		
		
	}
	
	/**
	 * 공지사항 타입별 리스트
	 * @param pi
	 * @param type
	 * @return
	 */
	public ArrayList<Notice> noticeTypeSelectList(PageInfo pi, String type) {
		
		Connection conn = getConnection();
		
		ArrayList<Notice> list = new ServiceDao().noticeTypeSelectList(conn,pi,type);
		
		close(conn);
		
		return list;
	}

	/** faq 타입별 리스트 갯수용 서비스
	 * @param type
	 * @return
	 */
	public int faqTypeListCount(String type) {
		
		Connection conn = getConnection();
		
		int listCount = new ServiceDao().faqTypeListCount(conn, type);
		
		close(conn);
		
		return listCount;	
	}

	/** faq 타입별 리스트 서비스
	 * @param pi
	 * @param type
	 * @return
	 */
	public ArrayList<Faq> faqTypeSelectList(PageInfo pi, String type) {
		
		Connection conn = getConnection();
		
		ArrayList<Faq> list = new ServiceDao().faqTypeSelectList(conn, pi, type);
		
		close(conn);
		
		return list;
	}

	public Notice selectNotice(int nno) {

		Connection conn = getConnection();
		
		Notice n = new ServiceDao().selectNotice(conn, nno);
		
		close(conn);
		
		return n;
	}


}
