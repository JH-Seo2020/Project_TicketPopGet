package com.kh.community.review.model.dao;

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
import com.kh.community.adBoard.model.vo.Report;
import com.kh.community.eventResult.model.vo.EventRaffle;
import com.kh.community.review.model.vo.Review;
import com.kh.concert.model.vo.PageInfo;

public class ReviewDao {
	
private Properties prop = new Properties();
	
	public ReviewDao() {
		String fileName = ReviewDao.class.getResource("/sql/community/review/review-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int reviewListCount(Connection conn) {
		int result = 0;
		Statement stmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("reviewListCount");
		
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

	public ArrayList<Review> selectList(Connection conn, PageInfo pi) {
		ArrayList<Review> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectReviewList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new Review(rset.getInt("REVIEW_NO"),
									rset.getInt("USER_NO"),
									rset.getInt("CONTENT_NO"),
									rset.getString("CONTENT_TYPE"),
									rset.getString("REVIEW_TITLE"),
									rset.getInt("REVIEW_POINT"),
									rset.getDate("REVIEW_DATE"),
									rset.getInt("REVIEW_COUNT")
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

	public int reviewCountByGenre(Connection conn, String genre) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("reviewCountByGenre");
		
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

	public ArrayList<Review> selectListByGenre(Connection conn, PageInfo pi, String genre) {
		ArrayList<Review> list = new ArrayList<>();
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
				list.add(new Review(rset.getInt("REVIEW_NO"),
									rset.getInt("USER_NO"),
									rset.getInt("CONTENT_NO"),
									rset.getString("CONTENT_TYPE"),
									rset.getString("REVIEW_TITLE"),
									rset.getInt("REVIEW_POINT"),
									rset.getDate("REVIEW_DATE"),
									rset.getInt("REVIEW_COUNT")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int plusCount(Connection conn, int reviewNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("plusCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reviewNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public Review reviewDetail(Connection conn, int reviewNo) {
		Review r = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("reviewDetail");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reviewNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				r = new Review(rset.getInt("REVIEW_NO"),
								rset.getInt("USER_NO"),
								rset.getInt("CONTENT_NO"),
								rset.getString("CONTENT_TYPE"),
								rset.getString("REVIEW_TITLE"),
								rset.getInt("REVIEW_POINT"),
								rset.getDate("REVIEW_DATE"),
								rset.getInt("REVIEW_COUNT"),
								rset.getString("USER_ID")
									);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return r;
	}

	public String reviewContent(Connection conn, int reviewNo) {
		String reviewContent = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("reviewDetail");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reviewNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Clob information = rset.getClob("REVIEW_CONTENT");
				if(information != null) {
					reviewContent = information.getSubString(1, (int)information.length());
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(conn);
		}
		
		return reviewContent;
	}

	public int deleteReview(Connection conn, int reviewNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteReview");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reviewNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

}
