package com.kh.common.model.service;

import java.sql.Connection;
import java.util.ArrayList;

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

	/**
	 * 4. 신규오픈정보 가져오기 
	 * @return
	 */
	public ArrayList<MainContent> selectNews() {
		Connection conn = getConnection();
		ArrayList<MainContent> news = new MainDao().selectNews(conn);
		close(conn);
		return news;
	}

	/**
	 * 5. 마감임박정보 가져오기 
	 * @return
	 */
	public ArrayList<MainContent> selectEnds() {
		Connection conn = getConnection();
		ArrayList<MainContent> ends = new MainDao().selectEnds(conn);
		close(conn);
		return ends;
	}

	/**
	 * 6. 랭킹페이지 정보가져오기 
	 * @return
	 */
	public ArrayList<MainContent> selectRank() {
		Connection conn = getConnection();
		ArrayList<MainContent> rank = new MainDao().selectRank(conn);
		close(conn);
		return rank;
	}


}
