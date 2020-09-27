package com.kh.community.eventResult.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import static com.kh.common.JDBCTemplate.*;

import com.kh.community.eventResult.model.vo.EventRaffle;
import com.kh.concert.model.dao.ConcertDao;
import com.kh.concert.model.vo.PageInfo;

public class EventResultDao {

	private Properties prop = new Properties();
	
	public EventResultDao() {
		String fileName = ConcertDao.class.getResource("/sql/community/eventResult/eventResult-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int eventResultListCount(Connection conn) {
		
		int result = 0;
		Statement stmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("eventResultListCount");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			if(rset.next()) {
				result = rset.getInt("resultCount");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		return result;
	}

	public ArrayList<EventRaffle> selectList(Connection conn, PageInfo pi) {
		
		ArrayList<EventRaffle> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectResultList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new EventRaffle(rset.getInt("RNUM"),
										rset.getInt("RAFFLE_NO"),
										rset.getInt("EVENT_NO"),
										rset.getString("RAFFLE_TITLE"),
										rset.getString("RAFFLE_CONTENT"),
										rset.getDate("RAFFLE_DATE"),
										rset.getInt("RAFFLE_COUNT"),
										rset.getString("RAFFLE_STATUS"),
										rset.getString("ADMIN_ID"),
										rset.getString("EVENT_TYPE")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int plusCount(Connection conn, int raffleNo) {
		
		int result=0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("plusCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, raffleNo);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public EventRaffle raffleDetail(Connection conn, int raffleNo) {
		
		EventRaffle raffle = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("raffleDetail");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, raffleNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				raffle = new EventRaffle(rset.getString("RAFFLE_TITLE"),
										rset.getString("RAFFLE_CONTENT"),
										rset.getDate("RAFFLE_DATE"),
										rset.getInt("RAFFLE_COUNT"),
										rset.getString("EVENT_TYPE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return raffle;
	}

	public int eventResultCountByGenre(Connection conn, String genre) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("eventResultCountByGenre");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, genre);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt("countByGenre");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<EventRaffle> selectListByGenre(Connection conn, PageInfo pi, String genre) {
		
		ArrayList<EventRaffle> list = new ArrayList<>();
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
				list.add(new EventRaffle(rset.getInt("RNUM"),
										rset.getInt("RAFFLE_NO"),
										rset.getInt("EVENT_NO"),
										rset.getString("RAFFLE_TITLE"),
										rset.getString("RAFFLE_CONTENT"),
										rset.getDate("RAFFLE_DATE"),
										rset.getInt("RAFFLE_COUNT"),
										rset.getString("RAFFLE_STATUS"),
										rset.getString("ADMIN_ID"),
										rset.getString("EVENT_TYPE")));
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
