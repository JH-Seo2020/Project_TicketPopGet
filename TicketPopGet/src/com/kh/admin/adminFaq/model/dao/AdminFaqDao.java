package com.kh.admin.adminFaq.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.admin.adminFaq.model.vo.Faq;
import com.kh.admin.adminMember.model.vo.Page;

public class AdminFaqDao {
	private Properties prop = new Properties();
	
	public AdminFaqDao() {
		
		String fileName = AdminFaqDao.class.getResource("/sql/admin/adminFaq_mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public int faqListCount(Connection conn) {
		
		int result = 0;
		Statement stmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("faqListCount");
		
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		return result;
	}
	
	public ArrayList<Faq> selectFaqList(Connection conn, Page p ) {
		
		ArrayList<Faq> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectFaqList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (p.getCurrentPage() - 1) * p.getPageLimit()+1;
			int endRow = startRow + p.getPageLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Faq(rset.getInt("faq_no"),
								 rset.getString("faq_type"),
								 rset.getString("faq_title"),
								 rset.getString("faq_content"),
								 rset.getString("faq_status"),
								 rset.getString("admin_name")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public int insertFaq(Connection conn, Faq f) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertFaq");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, f.getFaqType());
			pstmt.setString(2, f.getFaqTitle());
			pstmt.setString(3, f.getFaqContent());
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public Faq selectUpdate(Connection conn, int faqNo) {
		
		Faq f = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectUpdate");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, faqNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				f = new Faq();
				f.setFaqNo(rset.getInt("faq_no"));
				f.setFaqType(rset.getString("faq_type"));
				f.setFaqTitle(rset.getString("faq_title"));
				f.setFaqContent(rset.getString("faq_content"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return f;
	}
	
	public int updateFaq(Connection conn, Faq f) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateFaq");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, f.getFaqType());
			pstmt.setString(2, f.getFaqTitle());
			pstmt.setString(3, f.getFaqContent());
			pstmt.setInt(4, f.getFaqNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int searchKeyListCount(Connection conn, String key) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("searchKeyListCount");
				
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%"+key+"%");
			
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
	
	public int searchKeyTypeListCount(Connection conn, String key, String type) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("searchKeyTypeListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%"+key+"%");
			pstmt.setString(2, type);
			
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
	
	public int searchTypeListCount(Connection conn, String type) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("searchTypeListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, type);
			
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
	
	public ArrayList<Faq> searchKey(Connection conn, String key, Page p){
		
		ArrayList<Faq> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("searchKey");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (p.getCurrentPage() - 1) * p.getPageLimit() + 1;
			int endRow = startRow + p.getPageLimit() - 1;
			
			pstmt.setString(1, "%"+key+"%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				while(rset.next()) {
					list.add(new Faq(rset.getInt("faq_no"),
									 rset.getString("faq_type"),
									 rset.getString("faq_title"),
									 rset.getString("faq_content"),
									 rset.getString("faq_status"),
									 rset.getString("admin_name")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public ArrayList<Faq> searchKeyType(Connection conn, String key, String type, Page p){
		
		ArrayList<Faq> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("searchKeyType");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (p.getCurrentPage() - 1) * p.getPageLimit() + 1;
			int endRow = startRow + p.getPageLimit() - 1;
			
			pstmt.setString(1, "%"+key+"%");
			pstmt.setString(2, type);
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				while(rset.next()) {
					list.add(new Faq(rset.getInt("faq_no"),
									 rset.getString("faq_type"),
									 rset.getString("faq_title"),
									 rset.getString("faq_content"),
									 rset.getString("faq_status"),
									 rset.getString("admin_name")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public ArrayList<Faq> searchType(Connection conn, String type, Page p){
		
		ArrayList<Faq> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("searchType");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (p.getCurrentPage() - 1) * p.getPageLimit() + 1;
			int endRow = startRow + p.getPageLimit() - 1;
			
			pstmt.setString(1, type);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				while(rset.next()) {
					list.add(new Faq(rset.getInt("faq_no"),
									 rset.getString("faq_type"),
									 rset.getString("faq_title"),
									 rset.getString("faq_content"),
									 rset.getString("faq_status"),
									 rset.getString("admin_name")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public int deleteFaq(Connection conn, int faqNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteFaq");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, faqNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
}
