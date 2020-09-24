package com.kh.user.model.service;

import java.sql.Connection;

import static com.kh.common.JDBCTemplate.*;
import com.kh.user.model.vo.Member;

public class MemberService {

	/**
	 * @author 김현선
	 * @param userId		사용자가 입력한 아이디
	 * @param userPwd		사용자가 입력한 비밀번호
	 * @return				아이디,비밀번호 일치 시 조회되는 회원 객체
	 */
	public Member loginMember(String userId, String userPwd) {
		Connection conn = getConnection();
		
	}
	

}
