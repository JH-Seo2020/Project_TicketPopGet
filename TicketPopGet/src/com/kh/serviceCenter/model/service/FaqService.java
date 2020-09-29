package com.kh.serviceCenter.model.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.serviceCenter.model.dao.FaqDao;
import com.kh.serviceCenter.model.vo.Faq;
import com.kh.serviceCenter.model.vo.PageInfo;

public class FaqService {

	/** 총 faq 갯수 조회용 서비스
	 * @return
	 * @author 김현선
	 */
	public int selectListCount() {
		
		Connection conn = getConnection();
		
		int listCount = new FaqDao().selectListCount(conn);
		
		close(conn);
		
		return listCount;
		
	}

	/** faq 리스트 조회용 서비스
	 * @param pi
	 * @return
	 * @author 김현선
	 */
	public ArrayList<Faq> selectList(PageInfo pi) {
		Connection conn = getConnection();
		
		
		ArrayList<Faq> list = new FaqDao().selectList(conn,pi);
		
		close(conn);
		
		return list;
	}

}
