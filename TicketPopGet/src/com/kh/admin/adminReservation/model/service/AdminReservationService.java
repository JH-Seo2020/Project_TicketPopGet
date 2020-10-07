package com.kh.admin.adminReservation.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.admin.adminMember.model.vo.Page;
import com.kh.admin.adminReservation.model.dao.AdminReservationDao;
import com.kh.admin.adminReservation.model.vo.Reservation;

public class AdminReservationService {
	
	/**
	 * 예매 결제현황 리스트 수 조회
	 * @return 조회된 리스트 수
	 */
	public int reservationListCount() {
		
		Connection conn = getConnection();
		
		int result = new AdminReservationDao().reservationListCount(conn);
		
		close(conn);
		
		return result;
	}
	
	/**
	 * 결제현황 조회수 검색용 서비스
	 * @param contentNo		검색할 컨텐츠번호
	 * @param contentType	컨텐츠 타입
	 * @return				조회된 행 수
	 */
	public int paymentListCount(int contentNo,String contentType, int round) {
		Connection conn = getConnection();
		
		int result = new AdminReservationDao().paymentListCount(conn, contentNo, contentType, round);
		
		close(conn);
		
		return result;
	}
	
	/**
	 * 예매 결제현황 리스트 조회용 서비스
	 * @param p  페이징 처리를위한 페이지 객체
	 * @return   조회된 리스트
	 */
	public ArrayList<Reservation> reservationList(Page p, int contentNo, String contentType, int round){
		
		Connection conn = getConnection();
		
		ArrayList<Reservation> list = new AdminReservationDao().reservationList(conn, p, contentNo, contentType, round);
		
		close(conn);
		
		return list;
	}
	
	/**
	 * 예약 취소용 서비스
	 * @param ticketNo	취소할 예매번호
	 * @return			처리된 행 수
	 */
	public int reservationCancel(int ticketNo) {
		
		Connection conn = getConnection();
		
		int result = new AdminReservationDao().reservationCancel(conn, ticketNo);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}
	
}
