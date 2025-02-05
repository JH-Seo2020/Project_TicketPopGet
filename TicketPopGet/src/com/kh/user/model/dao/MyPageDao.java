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
import com.kh.user.model.vo.Reservation;
import com.kh.user.model.vo.WishList;

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
	 * 메인 최근예매내역
	 * @param conn
	 * @param userNo
	 * @return
	 */
	public ArrayList<Reservation> mainReservation(Connection conn, int userNo){
		ArrayList<Reservation> re = new ArrayList<>();
		
		PreparedStatement pstmt = null; 
		ResultSet rset = null;
		
		String sql = prop.getProperty("mainReservation");
		
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				re.add(new Reservation(rset.getInt("TICKET_NO"),
									   rset.getInt("USER_NO"),
									   rset.getInt("CONTENT_NO"),
									   rset.getDate("RESERVATION_DATE"),
								   	   rset.getString("CONTENT_TITLE"),
								   	   rset.getInt("TICKET_NUM"),
								       rset.getDate("VIEW_DATE"),
								       rset.getString("PAYMENT_TYPE"),
								       rset.getString("PAYMENT_STATUS"),
								       rset.getString("PAYMENT_CANCEL")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return re;
	}
	
	/**
	 * 메인 찜리스트
	 * @param conn
	 * @param userNo
	 * @return
	 */
	public ArrayList<WishList> mainWishList(Connection conn, int userNo){
		ArrayList<WishList> wishlist = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("mainWishList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				wishlist.add(new WishList(rset.getInt("WISH_NO"),
										  rset.getInt("CONTENT_NO"),
										  rset.getInt("USER_NO"),
										  rset.getInt("TICKET_NO"),
										  rset.getString("CONTENT_TYPE"),
										  rset.getString("CONTENT_TITLE"),
										  rset.getString("CONTENT_CHIMG"),
										  rset.getString("CONTENT_IMGPATH"),
										  rset.getString("CONTENT_STATUS"),
										  rset.getDate("WISHLIST_DATE")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return wishlist;
	}
	
	/**
	 * 메인 찜리스트삭제
	 * @param conn
	 * @param wno
	 * @param userNo
	 * @return
	 */
	public int deletemainWishList(Connection conn, int wno, int userNo) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deletemainWishList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, wno);
			pstmt.setInt(2, userNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	/**
	 * 메인 관람공연/전시
	 * @param conn
	 * @param userNo
	 * @return
	 */
	public ArrayList<MyPage> mainShowList(Connection conn, int userNo){
		ArrayList<MyPage> mps = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("mainShowList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);

			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				mps.add(new MyPage(rset.getInt("TICKET_NO"),
								   rset.getString("CONTENT_TITLE"),
								   rset.getInt("USER_NO"),
								   rset.getString("CONTENT_CHIMG"),
								   rset.getString("CONTENT_IMGPATH"),
								   rset.getDate("VIEW_DATE")));
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
	 * 예매내역 개수
	 * @param conn
	 * @param userNo
	 * @return
	 */
	public int selectReservationListCount(Connection conn, int userNo) {
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectReservationListCount");
		
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
	 * 예매 리스트
	 * @param conn
	 * @param userNo
	 * @return
	 */
	public ArrayList<Reservation> selectReservationList(Connection conn, int userNo, PageInfo pi){
		ArrayList<Reservation> re = new ArrayList<>();
		
		PreparedStatement pstmt = null; 
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectReservationList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage()-1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				re.add(new Reservation(rset.getInt("TICKET_NO"),
									   rset.getInt("USER_NO"),
									   rset.getInt("CONTENT_NO"),
									   rset.getDate("RESERVATION_DATE"),
								   	   rset.getString("CONTENT_TITLE"),
								   	   rset.getInt("TICKET_NUM"),
								       rset.getDate("VIEW_DATE"),
								       rset.getString("PAYMENT_TYPE"),
								       rset.getString("PAYMENT_STATUS"),
								       rset.getString("PAYMENT_CANCEL")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return re;
	}
	
	/**
	 * 예매내역 컨텐츠 조회 개수
	 * @param conn
	 * @param content
	 * @param userNo
	 * @return
	 */
	public int selectReservationContnetCount(Connection conn, String content, int userNo) {
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectReservationContnetCount");
		
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
	 * 예매매수 컨텐츠 리스트
	 * @param conn
	 * @param userNo
	 * @param content
	 * @param pi
	 * @return
	 */
	public ArrayList<Reservation> selectReservationContnetList(Connection conn, int userNo, String content, PageInfo pi){
		ArrayList<Reservation> re = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectReservationContnetList");
		
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
				re.add(new Reservation(rset.getInt("TICKET_NO"),
									   rset.getInt("USER_NO"),
									   rset.getInt("CONTENT_NO"),
									   rset.getDate("RESERVATION_DATE"),
								   	   rset.getString("CONTENT_TITLE"),
								   	   rset.getInt("TICKET_NUM"),
								       rset.getDate("VIEW_DATE"),
								       rset.getString("PAYMENT_TYPE"),
								       rset.getString("PAYMENT_STATUS"),
								       rset.getString("PAYMENT_CANCEL")));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return re;
	}
	
	/**
	 * 예매내역상세
	 * @param conn
	 * @param userNo
	 * @param tno
	 * @return
	 */
	public Reservation selectReservationDetail(Connection conn, int userNo, int tno) {
		
		Reservation re = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectReservationDetail");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tno);
			pstmt.setInt(2, userNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				re = new Reservation(rset.getInt("TICKET_NO"),
									 rset.getString("CONTENT_TITLE"),
									 rset.getDate("VIEW_DATE"),
									 rset.getDate("VIEW_DATE_CANCEL"),
									 rset.getString("PLACE"),
									 rset.getString("USER_NAME"),
									 rset.getDate("PAYMENT_DATE"),
									 rset.getDate("RESERVATION_DATE"),
									 rset.getString("PAYMENT_TYPE"),
									 rset.getString("PAYMENT_TOTAL"),
									 rset.getInt("TICKET_NUM"),
									 rset.getString("PAYMENT_CANCEL"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return re;
	}
	
	/**
	 * 예매취소
	 * @param conn
	 * @param userNo
	 * @param tno
	 * @return
	 */
	public int deleteReservation(Connection conn, int userNo, int tno) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteReservation");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, tno);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	/**
	 * 예매취소확인
	 * @param conn
	 * @param userNo
	 * @param tno
	 * @return
	 */
	public Reservation deleteReservationList(Connection conn, int userNo, int tno) {
		Reservation re = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("deleteReservationList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, tno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				re = new Reservation(rset.getInt("TICKET_NO"),
									 rset.getString("CONTENT_TYPE"),
									 rset.getString("CONTENT_TITLE"),
									 rset.getString("PLACE"),
									 rset.getString("CONTENT_CHIMG"),
									 rset.getString("CONTENT_IMGPATH"),
									 rset.getString("USER_NAME"),
									 rset.getDate("RESERVATION_DATE"),
									 rset.getDate("VIEW_DATE"),
									 rset.getString("PAYMENT_TYPE"),
									 rset.getString("PAYMENT_TOTAL"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return re;
	}
	
	/**
	 * 찜리스트 개수
	 * @param conn
	 * @param userNo
	 * @return
	 */
	public int selectWishListCount(Connection conn, int userNo) {
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectWishListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount =rset.getInt("LISTVIEW");
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
	 * 찜리스트 리스트
	 * @param conn
	 * @param userNo
	 * @param pi
	 * @return
	 */
	public ArrayList<WishList> selectWishList(Connection conn, int userNo, PageInfo pi){
		ArrayList<WishList> wishlist = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectWishList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage()-1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				wishlist.add(new WishList(rset.getInt("WISH_NO"),
										  rset.getInt("CONTENT_NO"),
										  rset.getInt("USER_NO"),
										  rset.getInt("TICKET_NO"),
										  rset.getString("CONTENT_TYPE"),
										  rset.getString("CONTENT_TITLE"),
										  rset.getString("CONTENT_CHIMG"),
										  rset.getString("CONTENT_IMGPATH"),
										  rset.getString("CONTENT_STATUS"),
										  rset.getDate("WISHLIST_DATE")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return wishlist;
	}

	/**
	 * 찜리스트 컨텐츠 개수
	 * @param conn
	 * @param userNo
	 * @param content
	 * @return
	 */
	public int selectWishContentCount(Connection conn, int userNo, String content) {
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectWishContentCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			pstmt.setString(2, content);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount =rset.getInt("LISTVIEW");
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
	 * 찜리스트 컨텐츠 리스트
	 * @param conn
	 * @param userNo
	 * @param pi
	 * @param content
	 * @return
	 */
	public ArrayList<WishList> selectWishContentList(Connection conn, int userNo, PageInfo pi, String content){
		ArrayList<WishList> wishlist = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectWishContentList");
		
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
				wishlist.add(new WishList(rset.getInt("WISH_NO"),
						                  rset.getInt("CONTENT_NO"),
						                  rset.getInt("USER_NO"),
						                  rset.getInt("TICKET_NO"),
					                 	  rset.getString("CONTENT_TYPE"),
					                      rset.getString("CONTENT_TITLE"),
						                  rset.getString("CONTENT_CHIMG"),
						                  rset.getString("CONTENT_IMGPATH"),
						                  rset.getString("CONTENT_STATUS"),
						                  rset.getDate("WISHLIST_DATE")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return wishlist;
	}
	
	/**
	 * 찜리스트 해제
	 * @param conn
	 * @param wno
	 * @param userNo
	 * @return
	 */
	public int deleteWishlist(Connection conn, int wno, int userNo) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteWishlist");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, wno);
			pstmt.setInt(2, userNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
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
								   rset.getString("CONTENT_TITLE"),
								   rset.getInt("USER_NO"),
								   rset.getInt("CONTENT_NO"),
								   rset.getString("RP_REVIEW_STATUS")));
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
				mps.add(new MyPage(rset.getInt("TICKET_NO"),
								   rset.getString("CONTENT_TYPE"),
								   rset.getDate("VIEW_DATE"),
								   rset.getString("CONTENT_TITLE"),
								   rset.getInt("USER_NO"),
								   rset.getInt("CONTENT_NO"),
								   rset.getString("RP_REVIEW_STATUS")));
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
	public MyPage selectReviewWrite(Connection conn, int tno, int userNo, int cno) {
		MyPage mp = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectReviewWrite");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, tno);
			pstmt.setInt(2, userNo);
			pstmt.setInt(3, cno);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				mp = new MyPage(rset.getString("CONTENT_TYPE"),
						        rset.getString("CONTENT_TITLE"),
						        rset.getDate("VIEW_DATE"),
						        rset.getInt("TICKET_NO"),
						        rset.getInt("CONTENT_NO"),
						        rset.getInt("USER_NO"));
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
	 * 후기작성
	 * @param conn
	 * @param mp
	 * @param content
	 * @return
	 */
	public int reviewInsert(Connection conn, MyPage mp, String content) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("reviewInsert");
		
		try {
			pstmt = conn.prepareStatement(sql);
			Clob clob = conn.createClob();
			clob.setString(1, content);
			
	
			pstmt.setInt(1, mp.getReviewPoint());
			pstmt.setString(2, mp.getReviewTitle());
			pstmt.setClob(3, clob);
			pstmt.setInt(4, mp.getUserNo());
			pstmt.setInt(5, mp.getContentNo());
			pstmt.setInt(6, mp.getTicketNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
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
				mps.add(new MyPage(rset.getInt("USER_NO"),
								   rset.getInt("REVIEW_NO"),
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
				mps.add(new MyPage(rset.getInt("USER_NO"),
								   rset.getInt("REVIEW_NO"),
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
	 * 나의 후기 상세조회[글작성뺴고]
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
				mp = new MyPage(rset.getInt("USER_NO"),
								rset.getInt("REVIEW_NO"),
								rset.getString("CONTENT_TYPE"),
								rset.getString("CONTENT_TITLE"),
								rset.getDate("VIEW_DATE"),
								rset.getDate("REVIEW_DATE"),
								rset.getInt("REVIEW_POINT"),
								rset.getString("REVIEW_TITLE"));
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
	 * 나의 후기 상세 [글부분]
	 * @param conn
	 * @param rno
	 * @param uno
	 * @return
	 */
	public String selectReviewContent(Connection conn, int rno) {
		
		String content = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectReviewDetail");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rno);

			rset=pstmt.executeQuery();
			
			while(rset.next()) {
				Clob recontent = rset.getClob("REVIEW_CONTENT");
				if(recontent!=null) {
					content = recontent.getSubString(1, (int)recontent.length());
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
	
	/**
	 * 후기 수정
	 * @param conn
	 * @param rno
	 * @param uno
	 * @return
	 */
	public int reviewUpdate(Connection conn, MyPage mp, String content) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("reviewUpdate");
		
		
		System.out.println(mp);
		try {
			pstmt = conn.prepareStatement(sql);
			Clob clob = conn.createClob();
			clob.setString(1, content);
			
			pstmt.setInt(1, mp.getReviewPoint());
			pstmt.setString(2, mp.getReviewTitle());
			pstmt.setClob(3, clob);
			pstmt.setInt(4, mp.getReviewNo());
			pstmt.setInt(5, mp.getUserNo());
			
			
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	/**
	 * 후기삭제
	 * @param conn
	 * @param rno
	 * @param userNo
	 * @return
	 */
	public int deleteReview(Connection conn, int rno, int userNo) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteReview");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rno);
			pstmt.setInt(2, userNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
		
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
	 * 홍보게시판상세조회[글작성빼고]
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
				ad = new AdBoard(rset.getInt("USER_NO"),
								 rset.getInt("BOARD_NO"),
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
	
	
	/**
	 * 홍보게시판상세조회[글작성만]
	 * @param conn
	 * @param ano
	 * @return
	 */
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
	
	/**
	 * 홍보수정
	 * @param conn
	 * @param ad
	 * @param content
	 * @return
	 */
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

	/**
	 * 홍보삭제
	 * @param conn
	 * @param rno
	 * @param userNo
	 * @return
	 */
	public int deleteAdboard(Connection conn, int ano, int userNo) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteAdboard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ano);
			pstmt.setInt(2, userNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
		
	}


}
