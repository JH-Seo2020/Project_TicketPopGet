package com.kh.admin.adminMember.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.admin.adminMember.model.dao.AdminMemberDao;
import com.kh.admin.adminMember.model.vo.Page;
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
	 * @return					검색 완료된 회원
	 */
	public ArrayList<Member> selectMember(Page p, String selectUser, String selectUserType) {
		
		Connection conn = getConnection();
		
		ArrayList<Member> list = new AdminMemberDao().selectMember(conn, p, selectUser, selectUserType);
		
		close(conn);
		
		return list;
	}
	
	
}
