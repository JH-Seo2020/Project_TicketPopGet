package com.kh.community.eventResult.model.service;
import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.community.eventResult.model.dao.EventResultDao;
import com.kh.community.eventResult.model.vo.EventRaffle;
import com.kh.concert.model.vo.PageInfo;

public class EventResultService {

	/**
	 * 1. 이벤트결과 게시물 개수 조회
	 * @return				게시물 총 개수
	 * @author				서지혜
	 */
	public int eventResultListCount() {
		
		Connection conn = getConnection();
		int result = new EventResultDao().eventResultListCount(conn);
		close(conn);
		
		return result;
	}

	/**
	 * 2. 이벤트 결과 게시물 정보 리스트 조회
	 * @param pi			페이지네이션 정보
	 * @return				게시물 리스트
	 * @author				서지혜
	 */
	public ArrayList<EventRaffle> selectList(PageInfo pi) {
		
		Connection conn = getConnection();
		ArrayList<EventRaffle> list = new EventResultDao().selectList(conn,pi);
		close(conn);
		return list;
	}

}
