package com.kh.payment.model.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;

import com.kh.exhibition.model.vo.Exhibition;
import com.kh.payment.model.dao.PaymentDao;
import com.kh.payment.model.vo.ConcertPayment;
import com.kh.payment.model.vo.Payment;
import com.kh.play.model.vo.Play;

public class PaymentService {


	public int insertConcertPayment(ConcertPayment cp) {
		Connection conn = getConnection();
		
		int result = new PaymentDao().insertConcertPayment(conn, cp);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}

	/**
	 * 2. 선택한 전시 서비스에 관련된 정보를 예매페이지에 뿌려주는 서비스 호출
	 * @param contentNo				//전시 컨텐츠 번호 
	 * @return						//전시 컨텐츠 정보
	 * @author 서지혜
	 */
	public Exhibition selectExhibitionForPayment(int contentNo) {
		
		Connection conn = getConnection();
		Exhibition exObject = new PaymentDao().selectExhibitionForPayment(conn, contentNo);
		close(conn);
		return exObject;
	}

	/**
	 * 3. 예매한 전시내역 DB에 insert하기 
	 * @param exPay
	 * @return
	 * @author 서지혜
	 */
	public int insertPayment(Payment exPay) {
		
		Connection conn = getConnection();
		int result = new PaymentDao().insertPayment(conn, exPay);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	/**
	 * 4. 선택한 연극 서비스에 관련된 정보를 예매페이지에 뿌려주는 서비스 호출
	 * @param contentNo
	 * @param playDay
	 * @param round
	 * @return
	 */
	public Play selectPlayForPayment(int contentNo, String playDay, int round) {
		Connection conn = getConnection();
		Play playObject = new PaymentDao().selectPlayForPayment(conn, contentNo,playDay,round);
		close(conn);
		return playObject;
	}
	

}
