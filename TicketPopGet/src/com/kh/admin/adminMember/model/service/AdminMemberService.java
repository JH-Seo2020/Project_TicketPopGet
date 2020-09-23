package com.kh.admin.adminMember.model.service;

import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.admin.adminMember.model.dao.AdminMemberDao;
import com.kh.user.model.vo.Member;

public class AdminMemberService {
	
	public ArrayList<Member> selectMemberList(){
		
		Connection conn = getConnection();
		
		ArrayList<Member> list = new AdminMemberDao().selectMemberList(conn);
		
		return list;
	}
	
}
