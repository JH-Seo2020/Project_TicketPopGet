package com.kh.payment.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import static com.kh.common.JDBCTemplate.*;

import com.kh.concert.model.vo.Concert;
import com.kh.exhibition.model.vo.Exhibition;
import com.kh.payment.model.vo.Payment;
import com.kh.play.model.vo.Play;

public class PaymentDao {
	
	
	private Properties prop = new Properties();
	
	public PaymentDao() {
		
		try {
			String fileName = PaymentDao.class.getResource("/sql/payment/payment-mapper.xml").getPath();
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

	//예매페이지에 보여주기 위한 전시객체 호출용 메소드
	public Exhibition selectExhibitionForPayment(Connection conn, int contentNo) {
		Exhibition exObject = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectExhibitionForPayment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, contentNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				exObject = new Exhibition(rset.getInt("CONTENT_NO"),
										  rset.getString("CONTENT_TYPE"),
										  rset.getString("CONTENT_TITLE"),
										  rset.getString("PLACE"),
										  rset.getString("PRICE"),
										  rset.getString("CONTENT_CHIMG"),
										  rset.getString("CONTENT_IMGPATH"),
										  rset.getDate("EXHIBITION_START"),
										  rset.getDate("EXHIBITION_END"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return exObject;
	}

	public int insertPayment(Connection conn, Payment exPay) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertExPayment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setDate(1, exPay.getViewDate());
			pstmt.setInt(2, exPay.getTicketNum());
			pstmt.setString(3, exPay.getContentType());
			pstmt.setInt(4, exPay.getUserNo());
			pstmt.setInt(5, exPay.getContentNo());
			pstmt.setDate(6, exPay.getPaymentDate());
			pstmt.setString(7, exPay.getPaymentType());
			pstmt.setString(8, exPay.getPaymentTotal());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public Play selectPlayForPayment(Connection conn, int contentNo, String playDay, int round) {
		Play playObject = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectPlayForPayment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, contentNo);
			pstmt.setString(2, playDay);
			pstmt.setInt(3, round);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				playObject = new Play(rset.getInt("CONTENT_NO"),
										  rset.getString("CONTENT_TYPE"),
										  rset.getString("CONTENT_TITLE"),
										  rset.getString("PLACE"),
										  rset.getString("PRICE"),
										  rset.getString("CONTENT_CHIMG"),
										  rset.getString("CONTENT_IMGPATH"),
										  rset.getDate("PLAY_START"),
										  rset.getDate("PLAY_END"),
										  rset.getString("ROUND_Count"),
										  rset.getString("ROUND_START"),
										  rset.getInt("ROUND_MAX"),
										  rset.getInt("ROUNDSEAT")
										  );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return playObject;
	}

	public Concert selectConcertPayment(Connection conn, int contentNo) {
		Concert conObject = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectConcertPayment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, contentNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				conObject = new Concert(rset.getInt("CONTENT_NO"),
										rset.getString("CONTENT_TYPE"),
										rset.getString("CONTENT_TITLE"),
										rset.getString("PLACE"),
										rset.getString("PRICE"),
										rset.getString("CONTENT_CHIMG"),
										rset.getString("CONTENT_IMGPATH"),
										rset.getDate("CONCERT_DATE"),
										rset.getInt("CONCERT_MAX"),
										rset.getInt("CONCERT_SEATS"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return conObject;
	}


	public Payment selectRecentPayment(Connection conn, int userNo) {
		
		Payment selectPay = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectRecentPayment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				selectPay = new Payment(
						rset.getDate("RESERVATION_DATE"),
						rset.getDate("VIEW_DATE"),
						rset.getInt("TICKET_NUM"),
						rset.getInt("ROUND_NO"),
						rset.getString("CONTENT_TYPE"),
						rset.getString("CONTENT_TITLE"),
							rset.getInt("USER_NO"),
							rset.getInt("CONTENT_NO"),
							rset.getDate("PAYMENT_DATE"),
							rset.getString("PAYMENT_TYPE"),
							rset.getString("PAYMENT_TOTAL"),
							rset.getString("USER_ID"),
							rset.getString("USER_NAME"),
							rset.getString("EMAIL"),
							rset.getString("PHONE"),
							rset.getInt("TICKET_NO")
							);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return selectPay;
	}


	public int updatePaymentStatus(Connection conn, int ticketNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updatePaymentStatus");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ticketNo);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

}
