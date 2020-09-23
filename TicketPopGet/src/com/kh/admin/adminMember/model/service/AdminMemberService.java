package com.kh.admin.adminMember.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.admin.adminMember.model.dao.AdminMemberDao;
import com.kh.user.model.vo.Member;

public class AdminMemberService {
	
	/**
	 * 1. 회원 조회용 서비스
	 * @return 조회된 모든회원객체를 보관한 ArrayList<Member>
	 */
	public ArrayList<Member> selectMemberList(){
		
		Connection conn = getConnection();
		
		ArrayList<Member> list = new AdminMemberDao().selectMemberList(conn);
		
		close(conn);
		
		return list;
	}
	
	/**
	 * 2. 전체 회원수를 조회용 서비스
	 * @return 전체회원수
	 */
	public int selectMemberListCount() {
		
		Connection conn = getConnection();
		
		int result = new AdminMemberDao().selectMemberListCount(conn);
		
		close(conn);
		
		return result;	
	}
	
}
