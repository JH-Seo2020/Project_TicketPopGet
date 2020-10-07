package com.kh.admin.adminReservation.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.admin.adminMember.model.vo.Page;
import com.kh.admin.adminReservation.model.vo.Reservation;
public class AdminReservationDao {
	
	private Properties prop = new Properties();
	
	public AdminReservationDao() {
		
		String fileName = AdminReservationDao.class.getResource("/sql/admin/adminReservation_mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public int reservationListCount(Connection conn) {
		
		int result = 0;
		Statement stmt=null;
		ResultSet rset = null;
		String sql = prop.getProperty("reservationListCount");
		
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(stmt);
		}
		return result;
	}
	
	public int paymentListCount(Connection conn,int contentNo,String contentType, int round) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "";
		
		if(contentType.equals("연극")) {
			sql = prop.getProperty("paymentPlayCount");
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, contentNo);
				pstmt.setInt(2, round);
				rset = pstmt.executeQuery();
				if(rset.next()) {
					result = rset.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
		}else if(contentType.equals("전시")) {
			sql = prop.getProperty("paymentExhibitionCount");
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, contentNo);
				rset = pstmt.executeQuery();
				if(rset.next()) {
					result = rset.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
		}else if(contentType.equals("콘서트")) {
			sql = prop.getProperty("paymentConcertCount");
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, contentNo);
				rset = pstmt.executeQuery();
				if(rset.next()) {
					result = rset.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
		}
		return result;
	}
	
	public ArrayList<Reservation> reservationList(Connection conn, Page p,int contentNo, String contentType, int round){
		
		ArrayList<Reservation> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "";
		
		if(contentType.equals("연극")) {
			sql = prop.getProperty("reservationListPlay");
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				int startRow = (p.getCurrentPage()-1)*p.getBoardLimit()+1;
				int endRow = startRow + p.getBoardLimit() - 1;
				
				pstmt.setInt(1, contentNo);
				pstmt.setInt(2, round);
				pstmt.setInt(3, startRow);
				pstmt.setInt(4, endRow);
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					Reservation r = new Reservation();
					r.setTicketNo(rset.getInt("ticket_no"));
					r.setUser(rset.getString("user_id"));
					r.setReservationDate(rset.getDate("reservation_date"));
					r.setPaymentDate(rset.getDate("payment_date"));
					r.setPaymentType(rset.getString("payment_type"));
					r.setPaymentStatus(rset.getString("payment_status"));
					r.setPaymentTotal(rset.getString("payment_total"));
					r.setContentTitle(rset.getString("content_title"));
					r.setContentDate(rset.getDate("round_date"));
					r.setMax(rset.getInt("round_max"));
					r.setSeats(rset.getInt("round_seats"));
					r.setRound(rset.getString("round_count"));
					r.setContentNo(rset.getInt("content_no"));
					r.setContentType(contentType);
					
					list.add(r);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}else if(contentType.equals("전시")) {
			sql = prop.getProperty("reservationListExhibition");
			
			try {
				pstmt = conn.prepareStatement(sql);
				int startRow = (p.getCurrentPage()-1)*p.getBoardLimit()+1;
				int endRow = startRow + p.getBoardLimit() - 1;
				
				pstmt.setInt(1, contentNo);
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					Reservation r = new Reservation();
					r.setTicketNo(rset.getInt("ticket_no"));
					r.setUser(rset.getString("user_id"));
					r.setReservationDate(rset.getDate("reservation_date"));
					r.setPaymentDate(rset.getDate("payment_date"));
					r.setPaymentType(rset.getString("payment_type"));
					r.setPaymentStatus(rset.getString("payment_status"));
					r.setPaymentTotal(rset.getString("payment_total"));
					r.setContentTitle(rset.getString("content_title"));
					r.setContentNo(rset.getInt("content_no"));
					r.setContentType(contentType);
					
					list.add(r);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}else if(contentType.equals("콘서트")) {
			sql = prop.getProperty("reservationListConcert");
			
			try {
				pstmt = conn.prepareStatement(sql);
				int startRow = (p.getCurrentPage()-1)*p.getBoardLimit()+1;
				int endRow = startRow + p.getBoardLimit() - 1;
				
				pstmt.setInt(1, contentNo);
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					Reservation r = new Reservation();
					r.setTicketNo(rset.getInt("ticket_no"));
					r.setUser(rset.getString("user_id"));
					r.setReservationDate(rset.getDate("reservation_date"));
					r.setPaymentDate(rset.getDate("payment_date"));
					r.setPaymentType(rset.getString("payment_type"));
					r.setPaymentStatus(rset.getString("payment_status"));
					r.setPaymentTotal(rset.getString("payment_total"));
					r.setContentTitle(rset.getString("content_title"));
					r.setContentDate(rset.getDate("concert_date"));
					r.setMax(rset.getInt("concert_max"));
					r.setSeats(rset.getInt("concert_seats"));
					r.setContentNo(rset.getInt("content_no"));
					r.setContentType(contentType);
					
					list.add(r);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return list;
	}
	
	public int reservationCancel(Connection conn, int ticketNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("reservationPaymentCancel");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, ticketNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
}
