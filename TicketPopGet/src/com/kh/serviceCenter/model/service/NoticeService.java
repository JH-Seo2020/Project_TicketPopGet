package com.kh.serviceCenter.model.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.serviceCenter.model.dao.NoticeDao;
import com.kh.serviceCenter.model.vo.Notice;
import com.kh.serviceCenter.model.vo.PageInfo;

public class NoticeService {

	/**
	 * 총 공지사항 갯수 조회용 서비스
	 * @return		총 갯수
	 * @author 김현선
	 */
	public int selectListCount() {

		Connection conn = getConnection();
		
		int listCount = new NoticeDao().selectListCount(conn);
		
		close(conn);
		
		return listCount;
	}

	/** 
	 * 공지사항 리스트 조회용 서비스
	 * @param pi
	 * @return
	 * @author 김현선
	 */
	public ArrayList<Notice> selectList(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Notice> list = new NoticeDao().selectList(conn, pi);
		
		close(conn);
		
		return list;
	}

}
