package com.kh.admin.adminMember.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.admin.adminMember.model.vo.Page;
import com.kh.admin.adminMember.model.vo.Report;
import com.kh.user.model.vo.Member;

public class AdminMemberDao {
	
	private Properties prop = new Properties();
	
	public AdminMemberDao() {
		String fileName = AdminMemberDao.class.getResource("/sql/admin/adminMember_mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
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
	
	public int selectMemberCount(Connection conn, String selectUser, String selectUserType) {
		// select문 => 한 행
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "";
		if(selectUserType.equals("USER_ID")) {
			sql=prop.getProperty("selectMemberCount");
		}else if(selectUserType.equals("USER_NAME")) {
			sql=prop.getProperty("selectMemberNameCount");
		}else if(selectUserType.equals("PHONE")){
			sql=prop.getProperty("selectMemberPhoneCount");
		}

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%"+selectUser+"%");
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
		
	}
	
	public ArrayList<Member> selectMemberList(Connection conn, Page p){
		// select문 => 여러행
		ArrayList<Member> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMemberList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (p.getCurrentPage() - 1) * p.getBoardLimit() + 1;
			int endRow = startRow + p.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
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
			close(pstmt);
		}
			
		return list;
	}
	
	public ArrayList<Member> selectMember(Connection conn,Page p, String selectUser, String selectUserType){
		// select문 => 여러행?단행?
		ArrayList<Member> list = new ArrayList<Member>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "";
		
		if(selectUserType.equals("USER_ID")) {
			sql = prop.getProperty("selectMemberUserId");
		}else if(selectUserType.equals("USER_NAME")) {
			sql = prop.getProperty("selectMemberUserName");
		}else if(selectUserType.equals("PHONE")) {
			sql = prop.getProperty("selectMemberPhone");
		}	

		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (p.getCurrentPage() - 1) * p.getBoardLimit() + 1;
			int endRow = startRow + p.getBoardLimit() - 1;
			
			pstmt.setString(1, "%"+selectUser+"%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
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
		} finally {
		  close(rset);
		  close(pstmt);
		}
		return list;
	}
	
	public Member selectMemberDetail(Connection conn, int userNo) {
		// select문 => 한행
		Member m = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년MM월dd일");
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectMemberDetail");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				m = new Member(rset.getInt("user_no"),
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
			            rset.getString("delete_reason"));
				m.setBdate(sdf.format(rset.getDate("birthdate")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return m;
	}
	
	public int selectBlacklistListCount(Connection conn) {
		// select문 => 한행
		int result = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectBlacklistListCount");
		
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(sql);
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public ArrayList<Member> selectBlacklistList(Connection conn, Page p){
		
		ArrayList<Member> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectBlacklistList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (p.getCurrentPage() -1) * p.getPageLimit() + 1; 
			int endRow = startRow + p.getPageLimit() -1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
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
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	public ArrayList<Report> selectReportList(Connection conn, int userNo){
		// select => 여러행
		ArrayList<Report> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectReportList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Report r = new Report();
				r.setReportNo(rset.getInt("report_no"));
				r.setReportDate(rset.getDate("report_date"));
				r.setReporter(rset.getString("user_name"));
				r.setReportType(rset.getString("report_type"));
				r.setReportCate(rset.getString("report_content"));
				list.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public int blacklistUnlock(Connection conn, int userNo) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("blacklistUnlock");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int searchReportCount(Connection conn, int userNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("searchReportCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}
	
}
