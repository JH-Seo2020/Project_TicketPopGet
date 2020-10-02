package com.kh.user.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.community.adBoard.model.vo.AdBoard;
import com.kh.user.model.vo.MyPage;
import com.kh.user.model.vo.PageInfo;

public class MyPageDao {
	
	private Properties prop = new Properties();
	
	public MyPageDao() {
	      
	      String fileName = MemberDao.class.getResource("/sql/user/mypage-mapper.xml").getPath();
	      
	      try {
	         prop.loadFromXML(new FileInputStream(fileName));
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	   }
	
	/**
	 * 나의관람공연개수
	 * @param conn
	 * @param userId
	 * @return
	 */
	public int selectListCount(Connection conn, int userNo) {
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectShowListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("LISTVIEW");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
	}
	
	/**
	 * 나의 관람공연리스트
	 * @param conn
	 * @param userId
	 * @param pi
	 * @return
	 */
	public ArrayList<MyPage> selectShowList(Connection conn, int userNo, PageInfo pi) {
		ArrayList<MyPage> mps = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectShowList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage()-1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				mps.add(new MyPage(rset.getInt("TICKET_NO"),
								   rset.getString("CONTENT_TYPE"),
								   rset.getDate("VIEW_DATE"),
								   rset.getString("CONTENT_TITLE")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return mps;
		
	}
	
	 /** 나의 관람컨텐츠 개수
	 * @param conn
	 * @param userId
	 * @param content
	 * @return
	 */
	public int selectShowContnetCount(Connection conn, String content, int userNo) {
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectShowContnetCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			pstmt.setString(2, content);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("LISTVIEW");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
	}
	
	/**
	 * 나의 관람컨텐츠 리스트
	 * @param conn
	 * @param userId
	 * @param content
	 * @param pi
	 * @return
	 */
	public ArrayList<MyPage> selectShowContnetList(Connection conn, int userNo, String content, PageInfo pi){
		ArrayList<MyPage> mps = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectShowContnetList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage()-1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, userNo);
			pstmt.setString(2, content);
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				mps.add(new MyPage( rset.getInt("TICKET_NO"),
								    rset.getString("CONTENT_TYPE"),
								    rset.getDate("VIEW_DATE"),
								    rset.getString("CONTENT_TITLE")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return mps;
		
	}
	
	/**
	 * 후기작성시 가져올 값 [컨텐츠분류, 공연명, 관람일]
	 * @param conn
	 * @param tno
	 * @return
	 */
	public MyPage selectReviewWrite(Connection conn, int tno) {
		MyPage mp = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectReviewWrite");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, tno);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				mp = new MyPage(rset.getString("CONTENT_TYPE"),
						        rset.getString("CONTENT_TITLE"),
						        rset.getDate("VIEW_DATE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return mp;
	}
	
	/**
	 * 나의 후기개수
	 * @param conn
	 * @param userId
	 * @return
	 */
	public int selectReviewListCount(Connection conn, int userNo) {
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectReviewListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("LISTVIEW");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
	}
	
	/**
	 * 나의 후기리스트
	 * @param conn
	 * @param userId
	 * @param pi
	 * @return
	 */
	public ArrayList<MyPage> selectReviewList(Connection conn, int userNo, PageInfo pi) {
		ArrayList<MyPage> mps = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectReviewList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage()-1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				mps.add(new MyPage(rset.getInt("REVIEW_NO"),
						           rset.getString("CONTENT_TITLE"),
						           rset.getString("REVIEW_TITLE"),
						           rset.getDate("REVIEW_DATE")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return mps;
		
	}
	
	/** 나의 후기컨텐츠 개수
	 * @param conn
	 * @param userId
	 * @param content
	 * @return
	 */
	public int selectReviewContnetCount(Connection conn, String content, int userNo) {
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectReviewContnetCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			pstmt.setString(2, content);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("LISTVIEW");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
	}
	
	/**
	 * 나의 후기컨텐츠 리스트
	 * @param conn
	 * @param userId
	 * @param content
	 * @param pi
	 * @return
	 */
	public ArrayList<MyPage> selectReviewContnetList(Connection conn, int userNo, String content, PageInfo pi){
		ArrayList<MyPage> mps = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectReviewContnetList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage()-1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, userNo);
			pstmt.setString(2, content);
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				mps.add(new MyPage(rset.getInt("REVIEW_NO"),
						           rset.getString("CONTENT_TITLE"),
						           rset.getString("REVIEW_TITLE"),
						           rset.getDate("REVIEW_DATE")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return mps;
		
	}

	/**
	 * 나의 후기 상세조회
	 * @param conn
	 * @param rno
	 * @return
	 */
	public MyPage selectReviewDetail(Connection conn, int rno) {
		
		MyPage mp = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectReviewDetail");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, rno);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				mp = new MyPage(rset.getString("USER_ID"),
								rset.getInt("REVIEW_NO"),
								rset.getString("CONTENT_TYPE"),
								rset.getString("CONTENT_TITLE"),
								rset.getDate("VIEW_DATE"),
								rset.getDate("REVIEW_DATE"),
								rset.getInt("REVIEW_POINT"),
								rset.getString("REVIEW_TITLE"),
								rset.getString("REVIEW_CONTENT"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return mp;
	}
	
	/**
	 * 나의홍보개수
	 * @param conn
	 * @param userId
	 * @return
	 */
	public int selectAdboardListCount(Connection conn, int userNo) {
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectAdboardListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("LISTVIEW");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
	}
	
	/**
	 * 나의홍보리스트
	 * @param conn
	 * @param userId
	 * @param pi
	 * @return
	 */
	public ArrayList<AdBoard> selectAdboardList(Connection conn, int userNo, PageInfo pi) {
		ArrayList<AdBoard> ad = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectAdboardList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage()-1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ad.add(new AdBoard(rset.getInt("BOARD_NO"),
								   rset.getString("BOARD_TITLE"),
								   rset.getString("BOARD_TYPE"),
								   rset.getDate("BOARD_DATE")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return ad;
		
	}
	
	/**
	 * 나의 홍보리스트 컨텐츠 개수
	 * @param conn
	 * @param userId
	 * @param content
	 * @return
	 */
	public int selectAdboardContnetCount(Connection conn, String content, int userNo) {
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectAdboardContnetCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			pstmt.setString(2, content);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("LISTVIEW");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
	}

	/**
	 * 나의 홍보리스트 컨텐츠 리스트
	 * @param conn
	 * @param userId
	 * @param content
	 * @param pi
	 * @return
	 */
	public ArrayList<AdBoard> selectAdboardContentList(Connection conn, int userNo, String content, PageInfo pi){
		ArrayList<AdBoard> ad = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectAdboardContentList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage()-1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, userNo);
			pstmt.setString(2, content);
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ad.add(new AdBoard( rset.getInt("BOARD_NO"),
								    rset.getString("BOARD_TITLE"),
								    rset.getString("BOARD_TYPE"),
								    rset.getDate("BOARD_DATE")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return ad;
		
	}
	
	/**
	 * 홍보게시판상세조회
	 * @param conn
	 * @param ano
	 * @return
	 */
	public AdBoard selectAdboardDetail(Connection conn, int ano) {
		
		AdBoard ad = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectAdboardDetail");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, ano);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				ad = new AdBoard(rset.getInt("BOARD_NO"),
						         rset.getString("BOARD_TYPE"),
						         rset.getString("LOCATION"),
						         rset.getDate("BOARD_DATE"),
						         rset.getString("BOARD_TITLE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return ad;
	}
	
	public String selectAdboardContent(Connection conn, int ano) {
		String content = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectAdboardDetail");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ano);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Clob adcontent = rset.getClob("BOARD_CONTNET");
				if(adcontent != null) {
					content = adcontent.getSubString(1, (int)adcontent.length());
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(conn);
		}
		
		return content;
	}
	
	public int adBoardUpdate(Connection conn, AdBoard ad, String content) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("adBoardUpdate");
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			Clob clob = conn.createClob();
			clob.setString(1, content);
			
			pstmt.setString(1, ad.getBoardType());
			pstmt.setString(2, ad.getBoardLocation());
			pstmt.setString(3, ad.getBoardTitle());
			//pstmt.setDate(4, ad.getBoardDate());
			pstmt.setClob(4,clob);
			pstmt.setInt(5, ad.getBoardNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}



}
