package com.kh.admin.adminContents.model.dao;

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

import com.kh.admin.adminContents.model.vo.Contents;
import com.kh.admin.adminMember.model.vo.Page;

public class AdminContentsDao {
	
	private Properties prop = new Properties();
	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	public AdminContentsDao() {
		
		String fileName = AdminContentsDao.class.getResource("/sql/admin/adminContents_mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public int contentsListCount(Connection conn) {
		
		int result = 0;
		Statement stmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("listCount");
		
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
			close(rset);
		}
		return result;
	}
	
	public ArrayList<Contents> contentsList(Connection conn, Page p) {
		
		ArrayList<Contents> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("list");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (p.getCurrentPage()-1)*p.getBoardLimit() +1;
			int endRow = startRow + p.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Contents(rset.getInt("content_no"),
						              rset.getString("content_type"),
						              rset.getString("content_title"),
						              rset.getString("content_subject"),
						              rset.getString("place"),
						              rset.getString("limit"),
						              rset.getString("price"),
						              rset.getString("content_keyword"),
						              rset.getString("info"),
						              rset.getString("content_status"),
						              rset.getInt("latitude"),
						              rset.getInt("longitude"),
						              rset.getString("region"),
						              rset.getString("content_ogimg"),
						              rset.getString("content_chimg"),
						              rset.getString("content_imgpath")
						              ));
			}
			
			for(Contents c : list) {
				if(c.getContentType().equals("연극")) {
					sql = prop.getProperty("listPlay");
					
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setInt(1, c.getContentNo());
					rset = pstmt.executeQuery();
					
					while(rset.next()) {
						c.setContentTerm(format.format((rset.getDate("play_start"))) + " ~ " + format.format(rset.getDate("play_end")));
						c.setContentRuntime(rset.getString("play_runtime"));
					}
				}else if(c.getContentType().equals("전시")) {
					sql = prop.getProperty("listExhibition");
					
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setInt(1, c.getContentNo());
					rset = pstmt.executeQuery();
					
					while(rset.next()) {
						c.setContentTerm(format.format(rset.getDate("exhibition_start")) + " ~ " + format.format(rset.getDate("exhibition_end")));
						c.setContentRuntime("-");
					}
				}else if(c.getContentType().equals("콘서트")) {
					sql = prop.getProperty("listConcert");
					
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setInt(1, c.getContentNo());
					rset = pstmt.executeQuery();
					
					while(rset.next()) {
						c.setContentTerm(format.format(rset.getDate("concert_date")));
						c.setContentRuntime(rset.getString("concert_runtime"));
					}
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
	
	public int insertPlay(Connection conn, Contents c) {
		int result1 = 0;
		int result2 = 0;
		int result3 = 1;
		PreparedStatement pstmt = null;
		String sql = "";
		try {
			sql = prop.getProperty("insertPlayContent");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, c.getContentTitle());
			pstmt.setString(2, c.getContentSubject());
			pstmt.setString(3, c.getPlace());
			pstmt.setString(4, c.getLimit());
			pstmt.setString(5, c.getPrice());
			pstmt.setString(6, c.getContentKeyword());
			pstmt.setString(7, c.getInfo());
			pstmt.setString(8, c.getRegion());
			pstmt.setString(9, c.getContentOgImg());
			pstmt.setString(10, c.getContentChImg());
			pstmt.setString(11, c.getContentImgPath());
			
			result1 = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			sql = prop.getProperty("insertPlay");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getStartDate());
			pstmt.setString(2, c.getEndDate());
			pstmt.setString(3, c.getContentRuntime());
			
			result2 = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			sql = prop.getProperty("insertRound");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getRound());
			pstmt.setString(2, c.getContentDate());
			pstmt.setString(3, c.getStartTime());
			pstmt.setString(4, c.getEndTime());
			pstmt.setInt(5, c.getMax());
			pstmt.setInt(6, c.getMax());
			
			result3 = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result1*result2*result3;
	}
	
}
