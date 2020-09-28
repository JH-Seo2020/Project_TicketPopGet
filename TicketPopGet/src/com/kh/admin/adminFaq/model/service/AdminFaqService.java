package com.kh.admin.adminFaq.model.service;

import static com.kh.common.JDBCTemplate.*;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.admin.adminFaq.model.dao.AdminFaqDao;
import com.kh.admin.adminFaq.model.vo.Faq;
import com.kh.admin.adminMember.model.vo.Page;

public class AdminFaqService {
	
	/**
	 * FAQ 게시물수 조회용 서비스
	 * @return 게시뭃수
	 */
	public int faqListCount() {
		
		Connection conn = getConnection();
		
		int result = new AdminFaqDao().faqListCount(conn);
		
		close(conn);
		
		return result;
	}
	
	/**
	 * FAQ 게시글 조회용 서비스
	 * @param p 페이징 처리를 위한 페이지 객체
	 * @return 조회된 게시글들
	 */
	public ArrayList<Faq> selectFaqList(Page p){
		
		Connection conn = getConnection();
		
		ArrayList<Faq> list = new AdminFaqDao().selectFaqList(conn, p);
		
		close(conn);
		
		return list;
	}
	
	/**
	 * FAQ 작성용 서비스
	 * @param f 작성할 FAQ 제목 타입 내용이 들어있는 객체
	 * @return 처리된 행 수
	 */
	public int insertFaq(Faq f) {
		
		Connection conn = getConnection();
		
		int result = new AdminFaqDao().insertFaq(conn, f);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	/**
	 * FAQ 조회/수정용 서비스
	 * @param faqNo 내용을 찾아올 FAQ 번호
	 * @return 조회된FAQ 객체
	 */
	public Faq selectUpdate(int faqNo) {
		
		Connection conn = getConnection();
		
		Faq f = new AdminFaqDao().selectUpdate(conn, faqNo);
		
		close(conn);
		
		return f;
	}
	
	/**
	 * FAQ 수정용 서비스
	 * @param f 수정하고자하는 내용이들어있는
	 * @return
	 */
	public int updateFaq(Faq f) {
		
		Connection conn = getConnection();
		
		int result = new AdminFaqDao().updateFaq(conn, f);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
	/**
	 * FAQ 검색어만 가지고 검색할경우 게시물수 조회 서비스
	 * @param key 검색어
	 * @return 검색된 게시글 수
	 */
	public int searchKeyListCount(String key) {
		
		Connection conn = getConnection();
		
		int result = new AdminFaqDao().searchKeyListCount(conn, key);
		
		close(conn);
		
		return result;
	}
	
	/**
	 * FAQ 타입만 가지고 검색할경우 게시글 수 조회 서비스
	 * @param type		검색타입
	 * @return			검색된 게시글 수
	 */
	public int searchTypeListCount(String type) {
		
		Connection conn = getConnection();
		
		int result = new AdminFaqDao().searchTypeListCount(conn, type);
		
		close(conn);
		
		return result;
	}
	
	/**
	 * FAQ 타입과 같이 검색할 경우 게시글 수 조회 서비스
	 * @param key		검색어
	 * @param faqType	검색타입
	 * @return			검색된 게시글 수
	 */
	public int searchKeyTypeListCount(String key, String faqType) {
		
		Connection conn = getConnection();
		
		int result = new AdminFaqDao().searchKeyTypeListCount(conn, key, faqType);
		
		close(conn);
		
		return result;
	}
	
	
	/**
	 * 검색어만 사용해서 검색할 경우 FAQ리스트 조회용 서비스
	 * @param key	검색어
	 * @param p		페이징처리를 위한 객체
	 * @return		검색된 리스트
	 */
	public ArrayList<Faq> searchKey(String key, Page p){
		
		Connection conn = getConnection();
		
		ArrayList<Faq> list = new AdminFaqDao().searchKey(conn, key, p); 
		
		close(conn);
		
		return list;
	}
	
	/**
	 * 타입과 검색어를 사용해서 검색할 경우 FAQ리스트 조회용 서비스
	 * @param key		검색어
	 * @param type		검색타입
	 * @param p			페이징처리를 위한 객체
	 * @return			검색된 리스트
	 */
	public ArrayList<Faq> searchKeyType(String key, String type, Page p){
		
		Connection conn = getConnection();
		
		ArrayList<Faq> list = new AdminFaqDao().searchKeyType(conn, key, type, p);
		
		close(conn);
		
		return list;
	}
	
	/**
	 * 타입만으로 검색시 FAQ리스트 조회용 서비스
	 * @param type		검색타입
	 * @param p			페이징처리를 위한 페이지객체
	 * @return			검색된 리스트
	 */
	public ArrayList<Faq> searchType(String type, Page p){
		
		Connection conn = getConnection();
		
		ArrayList<Faq> list = new AdminFaqDao().searchType(conn, type, p);
		
		close(conn);
		
		return list;
	}
	
	/**
	 * FAQ 삭제용 서비스
	 * @param faqNo		삭제할 FAQ번호
	 * @return			처리된 행 수
	 */
	public int deleteFaq(int faqNo) {
		
		Connection conn = getConnection();
		
		int result = new AdminFaqDao().deleteFaq(conn, faqNo);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
}
