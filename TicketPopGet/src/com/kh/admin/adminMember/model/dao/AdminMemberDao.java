package com.kh.admin.adminMember.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.user.model.vo.Member;
import static com.kh.common.JDBCTemplate.*;

public class AdminMemberDao {
	
	private Properties prop;
	
	public AdminMemberDao() {
		String fileName = AdminMemberDao.class.getResource("/sql/admin/adminMember_mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Member> selectMemberList(Connection conn){
		// select문 => 여러행
		ArrayList<Member> list = new ArrayList<>();
		Statement stmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectMemberList");
		
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			while(rset.next()) {
				list.add(new Member(rset.getInt("user_no"),
						            rset.getString("user_id"),
						            rset.getString("user_pwd"),
						            rset.getString("user_name"),
						            rset.getString("email"),
						            rset.getString("phone"),
						            rset.getDate("birthdate"),
						            rset.getString("gender"),
						            rset.getDate("delete_date"),
						            rset.getString("delete_status"),
						            rset.getString("blacklist_status"),
						            rset.getInt("report_count"),
						            rset.getString("delete_reason")
									));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
			
		return list;
	}
	
	public int selectMemberListCount(Connection conn) {
		// select문 => 한 행
		int result = 0;
		Statement stmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectMemberListCount");
		
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return result;
		
	}
	
}
