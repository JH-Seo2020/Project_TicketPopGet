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
	 * 3. 홍보게시글 insert 
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

	/**
	 * 4. 홍보게시글 조회수 증가 
	 * @param boardNo
	 * @return
	 * @author sjhie
	 */
	public int plusCount(int boardNo) {
		
		Connection conn = getConnection();
		int result = new AdBoardDao().plusCount(conn, boardNo);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	/**
	 * 5. 홍보게시글 세부조회(내용빼고다)
	 * @param boardNo
	 * @return
	 * @author sjhie
	 */
	public AdBoard boardDetail(int boardNo) {
		Connection conn = getConnection();
		AdBoard board = new AdBoardDao().boardDetail(conn, boardNo);
		close(conn);
		return board;
	}

	/**
	 * 6. 홍보게시글 내용조회(clob to string)
	 * @param boardNo
	 * @return
	 */
	public String boardContent(int boardNo) {
		
		Connection conn = getConnection();
		String boardContent = new AdBoardDao().boardContent(conn,boardNo);
		close(conn);
		return boardContent;
	}

	/**
	 * 7. 콘서트 홍보게시글 총 개수 조회 
	 * @param genre
	 * @return
	 * @author sjhie
	 */
	public int adBoardCountByGenre(String genre) {
		Connection conn = getConnection();
		int result = new AdBoardDao().adBoardCountByGenre(conn, genre);
		close(conn);
		return result;
	}

	/**
	 * 8. 장르별 홍보게시글 리스트 조회
	 * @param pi
	 * @param genre
	 * @return
	 * @author sjhie
	 */
	public ArrayList<AdBoard> selectListByGenre(PageInfo pi, String genre) {
		
		Connection conn = getConnection();
		ArrayList<AdBoard> list = new AdBoardDao().selectListByGenre(conn,pi,genre);
		close(conn);
		return list;
	}

}
