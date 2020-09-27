package com.kh.community.adBoard.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.community.adBoard.model.dao.AdBoardDao;
import com.kh.community.adBoard.model.vo.AdBoard;
import com.kh.concert.model.vo.PageInfo;

import static com.kh.common.JDBCTemplate.*;

public class AdBoardService {

	/**
	 * 1. 홍보게시글 개수조회
	 * @return
	 * @author sjhie
	 */
	public int adBoardListCount() {
		Connection conn = getConnection();
		int result = new AdBoardDao().adBoardListCount(conn);
		close(conn);
		return result;
	}

	/**
	 * 2. 홍보게시글 전체리스트조회
	 * @param pi
	 * @return
	 * @author sjhie
	 */
	public ArrayList<AdBoard> selectList(PageInfo pi) {
		Connection conn = getConnection();
		ArrayList<AdBoard> list = new AdBoardDao().selectList(conn,pi);
		close(conn);
		return list;
	}

}
