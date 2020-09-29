package com.kh.community.event.model.service;

import java.sql.Connection;
import java.util.ArrayList;

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

}
