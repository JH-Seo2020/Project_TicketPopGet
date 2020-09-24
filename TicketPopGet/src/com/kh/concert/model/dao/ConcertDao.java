package com.kh.concert.model.dao;

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

import com.kh.concert.model.vo.Concert;
import com.kh.concert.model.vo.PageInfo;

import static com.kh.common.JDBCTemplate.*;

public class ConcertDao {
	
	private Properties prop = new Properties();
		
	public ConcertDao() {
		
		String fileName = ConcertDao.class.getResource("/sql/concert/concert-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	
	
	public int selectListCount(Connection conn) {
		
		int result = 0;
		Statement stmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListCount");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				result = rset.getInt("concertListCount");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		
		return result;
	}



	public ArrayList<Concert> selectList(Connection conn, PageInfo pi) {
		//여러행조회, 반환 list
		
		ArrayList<Concert> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Concert(
									rset.getInt("CONTENT_NO"),
									rset.getString("CONTENT_TITLE"),
									rset.getString("CONTENT_KEYWORD"),
									rset.getString("REGION"),
									rset.getString("CONTENT_CHIMG"),
									rset.getString("CONTENT_IMGPATH"),
									rset.getDate("CONCERT_DATE")
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



	public Concert concertDetailView(Connection conn, int concertNo) {
		// 한 행 select
		
		Concert concertObject = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("concertDetailView");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, concertNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				concertObject = new Concert(rset.getString("CONTENT_TYPE"),
											rset.getString("CONTENT_TITLE"),
											rset.getString("CONTENT_SUBJECT"),
											rset.getString("PLACE"),
											rset.getString("LIMIT"),
											rset.getString("PRICE"),
											rset.getString("CONTENT_KEYWORD"),
											rset.getInt("LATITUDE"),
											rset.getInt("LONGITUDE"),
											rset.getString("REGION"),
											rset.getString("CONTENT_CHIMG"),
											rset.getString("CONTENT_IMGPATH"),
											rset.getDate("CONCERT_DATE"),
											rset.getString("CONCERT_RUNTIME"),
											rset.getInt("CONCERT_MAX"),
											rset.getInt("CONCERT_SEATS")
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return concertObject;
	}



	public String concertInfo(Connection conn, int concertNo) {

		String concertInfo = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("concertInfo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, concertNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Clob information = rset.getClob("INFO");
				if(information != null) {
					concertInfo = information.getSubString(1, (int)information.length());
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return concertInfo;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
