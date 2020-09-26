package com.kh.play.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import com.kh.concert.model.vo.PageInfo;
import com.kh.play.model.vo.Play;

import static com.kh.common.JDBCTemplate.*;

public class PlayDao {
	
	private Properties prop = new Properties();
	
	public PlayDao() {
		String fileName = PlayDao.class.getResource("/sql/play/play-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
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
				result = rset.getInt("playListCount");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(stmt);
			close(rset);
		}
		
		return result;
	}

	public ArrayList<Play> selectList(Connection conn, PageInfo pi) {
		
		ArrayList<Play> list = new ArrayList<>();
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
				list.add(new Play(rset.getInt("CONTENT_NO"),
									rset.getString("CONTENT_TITLE"),
									rset.getString("CONTENT_KEYWORD"),
									rset.getString("REGION"),
									rset.getString("CONTENT_CHIMG"),
									rset.getString("CONTENT_IMGPATH"),
									rset.getDate("PLAY_START"),
									rset.getDate("PLAY_END")
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

	public Play playDetailView(Connection conn, int contentNo) {
		
		Play playObject = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("playDetailView");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, contentNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				playObject = new Play(rset.getInt("CONTENT_NO"),
										rset.getString("CONTENT_TYPE"),
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
										rset.getDate("PLAY_START"),
										rset.getDate("PLAY_END"),
										rset.getString("PLAY_RUNTIME")
										);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return playObject;
	}

}
