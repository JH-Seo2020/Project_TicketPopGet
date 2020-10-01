package com.kh.serviceCenter.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.community.adBoard.model.vo.AdBoard;
import com.kh.serviceCenter.model.vo.Faq;
import com.kh.serviceCenter.model.vo.Notice;
import com.kh.serviceCenter.model.vo.PageInfo;

import static com.kh.common.JDBCTemplate.*;

public class ServiceDao {
	
	private Properties prop = new Properties();
	
	public ServiceDao() {
		String fileName = ServiceDao.class.getResource("/sql/serviceCenter/service-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

	public int noticeSelectListCount(Connection conn) {
		
		int listCount = 0;
		
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("noticeSelectListCount");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				listCount = rset.getInt("NOTICELISTCOUNT");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listCount;
	}

	public ArrayList<Notice> noticeSelectList(Connection conn, PageInfo pi) {

		ArrayList<Notice> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("noticeSelectList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() -1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Notice(rset.getInt("NOTICE_NO"),
									rset.getString("NOTICE_TYPE"),
									rset.getString("NOTICE_TITLE"),
									rset.getDate("NOTICE_DATE")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	public int faqSelectListCount(Connection conn) {
		
		int listCount = 0;
		
		Statement stmt = null;
		ResultSet rset = null; 
		
		String sql = prop.getProperty("faqSelectListCount");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				listCount = rset.getInt("FAQLISTCOUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listCount;
		
	}

	public ArrayList<Faq> faqSelectList(Connection conn, PageInfo pi) {
		
		ArrayList<Faq> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("faqSelectList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() -1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Faq(
								rset.getInt("FAQ_NO"),
								rset.getString("FAQ_TYPE"),
								 rset.getString("FAQ_TITLE"),
								 rset.getString("FAQ_CONTENT")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
		
	}



	public int noticeTypeListCount(Connection conn, String type) {
		
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("noticeTypeListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, type);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("countTypeNotice");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
		
	}


	public ArrayList<Notice> noticeTypeSelectList(Connection conn, PageInfo pi, String type) {
		
		ArrayList<Notice> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("noticeTypeSelectList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setString(1, type);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Notice(rset.getInt("NOTICE_NO"),
						rset.getString("NOTICE_TYPE"),
						rset.getString("NOTICE_TITLE"),
						rset.getDate("NOTICE_DATE")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}



}
