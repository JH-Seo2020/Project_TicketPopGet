package com.kh.community.adBoard.model.service;

import java.sql.Clob;
import java.sql.Connection;
import java.sql.SQLException;
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

	/**
	 * 4. 홍보게시글 insert 
	 * @param board
	 * @return
	 * @author sjhie
	 */
	public int insertAdBoard(AdBoard board, String content) {
		
		Connection conn = getConnection();
		int result = new AdBoardDao().insertAdBoard(conn,board, content);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

}
