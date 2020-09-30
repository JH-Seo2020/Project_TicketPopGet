package com.kh.community.event.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.community.adBoard.model.vo.AdBoard;
import com.kh.community.event.model.vo.Comment;
import com.kh.community.event.model.vo.Event;
import com.kh.community.review.model.vo.Review;
import com.kh.concert.model.vo.PageInfo;

import static com.kh.common.JDBCTemplate.*;

public class EventDao {
	
	Properties prop = new Properties();
	public EventDao() {
		String fileName = EventDao.class.getResource("/sql/community/event/event-mapper.xml").getPath();
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public int eventCount(Connection conn) {
		
		int result = 0;
		Statement stmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("eventCount");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			if(rset.next()) {
				result = rset.getInt("eventListCount");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		return result;
	}

	public ArrayList<Event> selectList(Connection conn, PageInfo pi) {

		ArrayList<Event> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectEventList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new Event(rset.getInt("EVENT_NO"),
									rset.getInt("CONTENT_NO"),
									rset.getString("EVENT_TYPE"),
									rset.getString("EVENT_TITLE"),
									rset.getDate("EVENT_DATE"),
									rset.getInt("EVENT_COUNT")
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

	public int plusCount(Connection conn, int eventNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("plusCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, eventNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public Event selectDetail(Connection conn, int eventNo) {
		
		Event evObject = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectDetail");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, eventNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				evObject = new Event(rset.getInt("EVENT_NO"),
										rset.getInt("CONTENT_NO"),
										rset.getString("EVENT_TYPE"),
										rset.getString("EVENT_TITLE"),
										rset.getDate("EVENT_DATE"),
										rset.getInt("EVENT_COUNT"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return evObject;
	}

	public String selectEventContent(Connection conn, int eventNo) {
		
		String eventContent = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectDetail");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, eventNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Clob information = rset.getClob("EVENT_CONTENT");
				if(information != null) {
					eventContent = information.getSubString(1, (int)information.length());
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return eventContent;
	}

	public int eventCountByGenre(Connection conn, String genre) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("eventCountByGenre");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, genre);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt("eventByGenre");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}

	public ArrayList<Event> selectListByGenre(Connection conn, PageInfo pi, String genre) {
		ArrayList<Event> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListByGenre");
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			pstmt.setString(1, genre);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Event(
									rset.getInt("EVENT_NO"),
									rset.getInt("CONTENT_NO"),
									rset.getString("EVENT_TYPE"),
									rset.getString("EVENT_TITLE"),
									rset.getDate("EVENT_DATE"),
									rset.getInt("EVENT_COUNT")
						));
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

	public int eventCommentCount(Connection conn, int eventNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("eventCommentCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, eventNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt("COMMENTCOUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}

	public ArrayList<Comment> selectComment(Connection conn, PageInfo pi, int eventNo) {
		ArrayList<Comment> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectComment");
		
		try {
			pstmt=conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			pstmt.setInt(1, eventNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Comment(rset.getInt("COMMENT_NO"),
									rset.getInt("EVENT_NO"),
									rset.getString("USER_ID"),
									rset.getString("COMMENT_CONTNET"),
									rset.getDate("COMMENT_DATE")
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

	public int insertComment(Connection conn, Comment comm) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertComment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, comm.getEventNo());
			pstmt.setInt(2, Integer.parseInt(comm.getUserNo()));
			pstmt.setString(3, comm.getCommentCont());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	
	

}
