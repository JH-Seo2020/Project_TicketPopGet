package com.kh.payment.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static com.kh.common.JDBCTemplate.*;

import com.kh.payment.model.vo.ConcertPayment;

public class PaymentDao {
	
	String fileName = PaymentDao.class.getResource("/sql/payment/payment-papper.xml").getPath();
	
	private Properties prop = new Properties();
	
	public PaymentDao() {
		
		try {
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

}
