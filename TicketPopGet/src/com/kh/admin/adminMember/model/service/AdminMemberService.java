package com.kh.admin.adminMember.model.service;

import static com.kh.common.JDBCTemplate.*;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.admin.adminMember.model.dao.AdminMemberDao;
import com.kh.admin.adminMember.model.vo.Page;
import com.kh.admin.adminMember.model.vo.Report;
import com.kh.user.model.vo.Member;

public class AdminMemberService {
	
	/**
	 * 1. 전체 회원수를 조회용 서비스
	 * @return 전체회원수
	 */
	public int selectMemberListCount() {
		
		Connection conn = getConnection();
		
		int result = new AdminMemberDao().selectMemberListCount(conn);
		
		close(conn);
		
		return result;	
	}
	
	/**
	 * 2. 검색된 회원수 조회용 서비스
	 * @param selectUser		검색창에 입력된 검색어
	 * @param selectUserType	검색조건
	 * @return	검색된 회원수
	 */
	public int selectMemberCount(String selectUser, String selectUserType) {
		
		Connection conn = getConnection();
		
		int result = new AdminMemberDao().selectMemberCount(conn, selectUser, selectUserType);
		
		close(conn);
		
		return result;	
	}
	 
	/**
	 * 3. 회원 조회용 서비스
	 * @return 조회된 모든회원객체를 보관한 ArrayList<Member>
	 */
	public ArrayList<Member> selectMemberList(Page p){
		
		Connection conn = getConnection();
		
		ArrayList<Member> list = new AdminMemberDao().selectMemberList(conn, p);
		
		close(conn);
		
		return list;
	}
	
	/**
	 * 4. 회원 전체조회 검색용 서비스
	 * @param selectUser		검색창에 입력한 검색어
	 * @param selectUserType	검색창 옆에 조건 아이디/회원명/연락처
	 * @return					검색 완료된 회원객체배열
	 */
	public ArrayList<Member> selectMember(Page p, String selectUser, String selectUserType) {
		
		Connection conn = getConnection();
		
		ArrayList<Member> list = new AdminMemberDao().selectMember(conn, p, selectUser, selectUserType);
		
		close(conn);
		
		return list;
	}
	
	/**
	 * 5. 회원 상세조회용 서비스
	 * @param userNo	상세조회할 회원 번호
	 * @return			상세조회된 회원객체
	 */
	public Member selectMemberDetail(int userNo) {
		
		Connection conn = getConnection();
		
		Member m = new AdminMemberDao().selectMemberDetail(conn, userNo);
		
		close(conn);
		
		return m;
	}
	
	/**
	 * 6. 블랙리스트 인원수 조회용 서비스
	 * @return 블랙리스트 인원수
	 */
	public int selectBlacklistListCount(){
		
		Connection conn = getConnection();
		
		int result = new AdminMemberDao().selectBlacklistListCount(conn);
		
		close(conn);
		
		return result;
		
	}
	
	/**
	 * 7. 블랙리스트 조회용 서비스
	 * @return 조회된 블랙리스트 객체배열
	 */
	public ArrayList<Member> selectBlacklistList(Page p){
		
		Connection conn = getConnection();
		
		ArrayList<Member> list = new AdminMemberDao().selectBlacklistList(conn, p);
		
		for(Member m : list) {
			m.setReportCounter(new AdminMemberDao().searchReportCount(conn, m.getUserNo()));
		}
		
		close(conn);
		
		return list;
	}
	
	/**
	 * 8. 블랙리스트 신고내역확인용 서비스
	 * @param userNo	신고내역확을하고자 하는 유저번호
	 * @return			해당 유저의 신고내역들 객체배열
	 */
	public ArrayList<Report> selectReportList(int userNo){
		
		Connection conn = getConnection();
		
		ArrayList<Report> list = new AdminMemberDao().selectReportList(conn, userNo);
		
		close(conn);
		
		return list;
		
	}
	
	/**
	 * 블랙리스트 해제용 서비스
	 * @param userNo	블랙리스트 해제할 회원 번호
	 * @return
	 */
	public int blacklistUnlock(int userNo) {
		
		Connection conn = getConnection();
		
		int result = new AdminMemberDao().blacklistUnlock(conn, userNo);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}
	
	/**
	 * 누적신고수 조회용 서비스
	 * @param userNo	조회할 회원
	 * @return
	 */
	public int searchReportCount(int userNo) {
		Connection conn = getConnection();
		
		int result = new AdminMemberDao().searchReportCount(conn, userNo);
		
		close(conn);
		
		return result;
	}
	
}
