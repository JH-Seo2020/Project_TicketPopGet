package com.kh.payment.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import static com.kh.common.JDBCTemplate.*;

import com.kh.exhibition.model.vo.Exhibition;
import com.kh.payment.model.vo.ConcertPayment;
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
	
	public int insertConcertPayment(Connection conn, ConcertPayment cp) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertConcertPayment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setDate(1, cp.getConcertDate());
			pstmt.setInt(2, cp.getTicketNum());
			pstmt.setString(3, cp.getContentType());
			pstmt.setInt(4, cp.getUserNo());
			pstmt.setInt(5, cp.getContentNo());
			pstmt.setDate(6, cp.getPaymentDate());
			pstmt.setString(7, cp.getPaymentType());
			pstmt.setString(8, cp.getPaymentTotal());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
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

}
