package com.kh.common.model.service;

import java.sql.Connection;

import com.kh.common.model.dao.MainDao;
import com.kh.common.model.vo.MainContent;
import static com.kh.common.JDBCTemplate.*;

public class MainService {

	/**
	 * 1. 투데이베스트 콘서트정보 가져오기
	 * @return
	 */
	public MainContent selectTbConcert() {
		
		Connection conn = getConnection();
		MainContent tbConcert = new MainDao().selectTbConcert(conn);
		close(conn);
		return tbConcert;
	}

	/**
	 * 2. 투데이베스트 연극정보 가져오기
	 * @return
	 */
	public MainContent selectTbPlay() {
		Connection conn = getConnection();
		MainContent tbPlay = new MainDao().selectTbPlay(conn);
		close(conn);
		return tbPlay;
	}

	/**
	 * 3. 투데이베스트 전시정보 가져오기
	 * @return
	 */
	public MainContent selectTbEx() {
		Connection conn = getConnection();
		MainContent tbEx = new MainDao().selectTbEx(conn);
		close(conn);
		return tbEx;
	}

}
