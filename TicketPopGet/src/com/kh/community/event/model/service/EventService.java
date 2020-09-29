package com.kh.community.event.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.community.adBoard.model.dao.AdBoardDao;
import com.kh.community.adBoard.model.vo.AdBoard;
import com.kh.community.event.model.dao.EventDao;
import com.kh.community.event.model.vo.Event;
import com.kh.concert.model.vo.PageInfo;

import static com.kh.common.JDBCTemplate.*;

public class EventService {

	/**
	 * 1. 이벤트 게시글 개수 조회 
	 * @return
	 */
	public int eventCount() {
		Connection conn = getConnection();
		int result = new EventDao().eventCount(conn);
		close(conn);
		return result;
	}

	/**
	 * 2. 이벤트 게시글 리스트 조회
	 * @param pi
	 * @return
	 */
	public ArrayList<Event> selectList(PageInfo pi) {
		Connection conn = getConnection();
		ArrayList<Event> list = new EventDao().selectList(conn,pi);
		close(conn);
		return list;
	}

	/**
	 * 3. 이벤트 게시글 조회수 올리기
	 * @param eventNo
	 * @return
	 */
	public int plusCount(int eventNo) {
		
		Connection conn = getConnection();
		int result = new EventDao().plusCount(conn,eventNo);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	/**
	 * 4. 이벤트 게시글 상세조회 (내용물 제외)
	 * @param eventNo
	 * @return
	 */
	public Event selectDetail(int eventNo) {
		
		Connection conn = getConnection();
		Event evObject = new EventDao().selectDetail(conn, eventNo);
		close(conn);
		return evObject;
	}

	/**
	 * 5. 이벤트 내용 조회
	 * @param eventNo
	 * @return
	 */
	public String selectEventContent(int eventNo) {
		
		Connection conn = getConnection();
		String eventContent = new EventDao().selectEventContent(conn, eventNo);
		close(conn);
		return eventContent;
	}

	/**
	 * 6. 장르별 이벤트 게시글 개수 조회
	 * @param genre
	 * @return
	 */
	public int eventCountByGenre(String genre) {
		Connection conn = getConnection();
		int result = new EventDao().eventCountByGenre(conn, genre);
		close(conn);
		return result;
	}

	/**
	 * 7. 장르별 이벤트게시글 리스트 조회
	 * @param pi
	 * @param genre
	 * @return
	 */
	public ArrayList<Event> selectListByGenre(PageInfo pi, String genre) {
		Connection conn = getConnection();
		ArrayList<Event> list = new EventDao().selectListByGenre(conn,pi,genre);
		close(conn);
		return list;
	}

}
