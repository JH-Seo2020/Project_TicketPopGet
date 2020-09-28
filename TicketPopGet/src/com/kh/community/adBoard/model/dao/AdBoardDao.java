package com.kh.community.adBoard.model.dao;

import static com.kh.common.JDBCTemplate.close;

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
import com.kh.community.eventResult.model.vo.EventRaffle;
import com.kh.concert.model.dao.ConcertDao;
import com.kh.concert.model.vo.PageInfo;

public class AdBoardDao {
	
	private Properties prop = new Properties();
	public AdBoardDao() {
		String fileName = ConcertDao.class.getResource("/sql/community/adBoard/adBoard-mapper.xml").getPath();
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int adBoardListCount(Connection conn) {
		
		int result = 0;
		Statement stmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("adBoardListCount");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			if(rset.next()) {
				result = rset.getInt("adCount");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		return result;
	}

	public ArrayList<AdBoard> selectList(Connection conn, PageInfo pi) {
		ArrayList<AdBoard> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectBoardList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new AdBoard(rset.getInt("BOARD_NO"),
										rset.getString("BOARD_TYPE"),
										rset.getString("LOCATION"),
										rset.getString("BOARD_TITLE"),
										rset.getDate("BOARD_DATE"),
										rset.getInt("BOARD_COUNT")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int insertAdBoard(Connection conn, AdBoard board, String content) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertAdBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			Clob clob = conn.createClob();
			clob.setString(1, content);
			
			pstmt.setString(1, board.getBoardType());
			pstmt.setString(2, board.getBoardLocation());
			pstmt.setString(3, board.getBoardTitle());
			pstmt.setClob(4, clob);
			pstmt.setInt(5, board.getUserNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int plusCount(Connection conn, int boardNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("plusCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public AdBoard boardDetail(Connection conn, int boardNo) {
		
		AdBoard board = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("boardDetail");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				board = new AdBoard(rset.getInt("BOARD_NO"),
									rset.getString("BOARD_TYPE"),
									rset.getString("LOCATION"),
									rset.getString("BOARD_TITLE"),
									rset.getDate("BOARD_DATE"),
									rset.getInt("BOARD_COUNT"),
									rset.getInt("USER_NO")
									);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return board;
	}

	public String boardContent(Connection conn, int boardNo) {
		String boardContent = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("boardDetail");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Clob information = rset.getClob("BOARD_CONTNET");
				if(information != null) {
					boardContent = information.getSubString(1, (int)information.length());
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(conn);
		}
		
		return boardContent;
	}

	public int adBoardCountByGenre(Connection conn, String genre) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("adBoardCountByGenre");
		
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

	public ArrayList<AdBoard> selectListByGenre(Connection conn, PageInfo pi, String genre) {
		
		ArrayList<AdBoard> list = new ArrayList<>();
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
				list.add(new AdBoard(rset.getInt("BOARD_NO"),
									rset.getString("BOARD_TYPE"),
									rset.getString("LOCATION"),
									rset.getString("BOARD_TITLE"),
									rset.getDate("BOARD_DATE"),
									rset.getInt("BOARD_COUNT"),
									rset.getInt("USER_NO")));
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

	public int updateBoard(Connection conn, AdBoard board, String editordata) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			Clob clob = conn.createClob();
			clob.setString(1, editordata);
			
			pstmt.setString(1, board.getBoardType());
			pstmt.setString(2, board.getBoardLocation());
			pstmt.setString(3, board.getBoardTitle());
			pstmt.setClob(4, clob);
			pstmt.setInt(5, board.getBoardNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int deleteBoard(Connection conn, int boardNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

}
