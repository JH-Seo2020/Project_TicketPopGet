package com.kh.admin.adminNotice.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.ArrayList;

import com.kh.admin.adminMember.model.vo.Page;
import com.kh.admin.adminNotice.model.vo.Notice;

import static com.kh.common.JDBCTemplate.*;

public class AdminNoticeDao {

	private Properties prop = new Properties();
	
	public AdminNoticeDao() {
		
		String fileName = AdminNoticeDao.class.getResource("/sql/admin/adminNotice_mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public int selectNoticeListCount(Connection conn) {
		
		int result = 0;
		Statement stmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectNoticeListCount");
		
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(stmt);
		}
		return result;
	}
	
	public ArrayList<Notice> selectNoticeList(Connection conn, Page p){
		
		ArrayList<Notice> list = new ArrayList<Notice>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectNoticeList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (p.getCurrentPage() - 1) * p.getPageLimit() + 1;
			int endRow = startRow + p.getPageLimit() - 1;
					
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Notice(rset.getInt("notice_no"),
									rset.getString("notice_type"),
									rset.getString("notice_title"),
									rset.getString("notice_content"),
									rset.getDate("notice_date"),
									rset.getString("notice_status"),
									rset.getString("admin_name")
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
	
	public int searchNoticeListCount(Connection conn, String key) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("searchNoticeListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%" + key +"%");
			
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
	
	public int searchNoticeListKeyTypeCount(Connection conn, String key, String type) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("searchNoticeListKeyTypeCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%" + key +"%");
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
	
	public int searchNoticeListTypeCount(Connection conn, String type) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("searchNoticeListTypeCount");
		
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
	
	public ArrayList<Notice> searchNoticeList(Connection conn, String key, Page p, String type){
		
		ArrayList<Notice> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "";
		
		int startRow = (p.getCurrentPage()-1) * p.getPageLimit() + 1;
		int endRow = startRow + p.getPageLimit() - 1;
		
		if(type.equals("전체")) {
			if(key.equals("")) {
				sql=prop.getProperty("selectNoticeList");
				
				try {
					pstmt = conn.prepareStatement(sql);
							
					pstmt.setInt(1, startRow);
					pstmt.setInt(2, endRow);
					
					rset = pstmt.executeQuery();
					
					while(rset.next()) {
						list.add(new Notice(rset.getInt("notice_no"),
											rset.getString("notice_type"),
											rset.getString("notice_title"),
											rset.getString("notice_content"),
											rset.getDate("notice_date"),
											rset.getString("notice_status"),
											rset.getString("admin_name")
											));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					close(rset);
					close(pstmt);
				}
			}else {
				sql=prop.getProperty("searchNoticeList");
				
				try {
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(1, "%"+key+"%");
					pstmt.setInt(2, startRow);
					pstmt.setInt(3, endRow);
					
					rset = pstmt.executeQuery();
					
					while(rset.next()) {
						list.add(new Notice(rset.getInt("notice_no"),
											rset.getString("notice_type"),
											rset.getString("notice_title"),
											rset.getString("notice_content"),
											rset.getDate("notice_date"),
											rset.getString("notice_status"),
											rset.getString("admin_name")
											));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					close(rset);
					close(pstmt);
				}
				
			}
		}else {
			
			if(key.equals("")) {
				sql = prop.getProperty("searchNoticeListType");
				
				try {
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(1, type);
					pstmt.setInt(2, startRow);
					pstmt.setInt(3, endRow);
					
					rset = pstmt.executeQuery();
					
					while(rset.next()) {
						list.add(new Notice(rset.getInt("notice_no"),
								rset.getString("notice_type"),
								rset.getString("notice_title"),
								rset.getString("notice_content"),
								rset.getDate("notice_date"),
								rset.getString("notice_status"),
								rset.getString("admin_name")
								));
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					close(rset);
					close(pstmt);
				}
			}else {
				sql = prop.getProperty("searchNoticeListKeyType");
				
				try {
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(1,"%"+key+"%");
					pstmt.setString(2, type);
					pstmt.setInt(3, startRow);
					pstmt.setInt(4, endRow);
					
					rset = pstmt.executeQuery();
					
					while(rset.next()) {
						list.add(new Notice(rset.getInt("notice_no"),
								rset.getString("notice_type"),
								rset.getString("notice_title"),
								rset.getString("notice_content"),
								rset.getDate("notice_date"),
								rset.getString("notice_status"),
								rset.getString("admin_name")
								));
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					close(rset);
					close(pstmt);
				}
			}
		}
	return list;
	}
	
	public int insertNotice(Connection conn, Notice n) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, n.getNoticeType());
			pstmt.setString(2, n.getNoticeTitle());
			pstmt.setString(3, n.getNoticeContent());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public Notice selectUpdateNotice(Connection conn, int noticeNo) {
		
		Notice n = null;
		PreparedStatement pstmt= null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectUpdateNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, noticeNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				n = new Notice(rset.getInt("notice_no"),
								rset.getString("notice_type"),
								rset.getString("notice_title"),
								rset.getString("notice_content"),
								rset.getDate("notice_date"),
								rset.getString("notice_status"),
								rset.getString("admin_name")
								);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return n;
	}
	
	public int updateNotice(Connection conn, Notice n) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, n.getNoticeType());
			pstmt.setString(2, n.getNoticeTitle());
			pstmt.setString(3, n.getNoticeContent());
			pstmt.setInt(4, n.getNoticeNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int deleteNotice(Connection conn, int noticeNo) {
		
		int result= 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, noticeNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
}
