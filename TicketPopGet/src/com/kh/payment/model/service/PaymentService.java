package com.kh.payment.model.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;

import com.kh.payment.model.dao.PaymentDao;
import com.kh.payment.model.vo.ConcertPayment;

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
	

}
