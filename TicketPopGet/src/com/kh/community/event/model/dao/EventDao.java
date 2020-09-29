package com.kh.community.event.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.community.event.model.vo.Event;
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
	
	
	

}
