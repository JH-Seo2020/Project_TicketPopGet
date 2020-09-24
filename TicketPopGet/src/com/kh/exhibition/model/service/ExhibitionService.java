package com.kh.exhibition.model.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.concert.model.vo.PageInfo;
import com.kh.exhibition.model.dao.ExhibitionDao;
import com.kh.exhibition.model.vo.Exhibition;
import com.kh.play.model.vo.Play;

public class ExhibitionService {

	/**
	 * 1. 전시컨텐츠 총 개수 조회
	 * @return			전시컨텐츠 총 개수(상태y)
	 * @author 			서지혜
	 */
	public int selectListCount() {
		
		Connection conn = getConnection();
		int result = new ExhibitionDao().selectListCount(conn);
		
		close(conn);
		
		return result;
	}

	/**
	 * 2. 요청 페이지에 들어갈 전시 컨텐츠 리스트 조회
	 * @param pi		페이징처리용 객체
	 * @return			요청페이지에 들어갈 전시정보리스트
	 * @author			서지혜
	 */
	public ArrayList<Exhibition> selectList(PageInfo pi) {
		
		Connection conn = getConnection();
		
		ArrayList<Exhibition> list = new ExhibitionDao().selectList(conn, pi);
		
		close(conn);
		
		return list;
	}

}
