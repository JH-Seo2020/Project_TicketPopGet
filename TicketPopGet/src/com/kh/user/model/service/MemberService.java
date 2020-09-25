package com.kh.user.model.service;

import java.sql.Connection;

import static com.kh.common.JDBCTemplate.*;

import com.kh.common.JDBCTemplate;
import com.kh.user.model.dao.MemberDao;
import com.kh.user.model.vo.Member;

public class MemberService {

	/**
	 * 로그인 서비스
	 * @param userId		사용자가 입력한 아이디
	 * @param userPwd		사용자가 입력한 비밀번호
	 * @return				아이디,비밀번호 일치 시 조회되는 회원 객체
	 * @author 김현선
	 */
	public Member loginMember(String userId, String userPwd) {
		
		Connection conn = getConnection();
		
		Member loginMember = new MemberDao().loginMember(conn, userId, userPwd);
		
		JDBCTemplate.close(conn);
		
		return loginMember;
	}

	/**
	 * 아이디 중복확인 서비스
	 * @param checkId
	 * @return
	 * @author 김현선
	 */
	public int idCheck(String checkId) {
		Connection conn = getConnection();
		
		int count = new MemberDao().idCheck(conn, checkId);
		
		close(conn);
		
		return count;
	}
	
	/**
	 * 관리자 로그인용 서비스
	 * @param userId
	 * @param userPwd
	 * @return 조회된 값의 수
	 * @author 조우현
	 */
	public int loginAdmin(String userId, String userPwd) {
		
		Connection conn = getConnection();
		
		int result = new MemberDao().loginAdmin(conn, userId, userPwd);
		
		close(conn);
		
		return result;
		
	}
	

}
