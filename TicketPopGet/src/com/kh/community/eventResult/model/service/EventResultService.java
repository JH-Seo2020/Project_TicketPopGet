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

	/**
	 * 3. 이벤트 결과 게시물 조회수 올리기
	 * @param raffleNo
	 * @return
	 */
	public int plusCount(int raffleNo) {
		
		Connection conn = getConnection();
		int result = new EventResultDao().plusCount(conn, raffleNo);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	/**
	 * 4. 이벤트 내용 조회
	 * @param raffleNo		결과게시물번호
	 * @return				내용
	 * @author				서지혜
	 */
	public EventRaffle raffleDetail(int raffleNo) {
		Connection conn = getConnection();
		EventRaffle raffle = new EventResultDao().raffleDetail(conn,raffleNo);
		close(conn);
		return raffle;
	}

	/**
	 * 5. 장르별 이벤트결과 게시글 개수 조회
	 * @param genre			장르
	 * @return				게시글 개수
	 */
	public int eventResultCountByGenre(String genre) {
		Connection conn = getConnection();
		int result = new EventResultDao().eventResultCountByGenre(conn,genre);
		close(conn);
		return result;
	}

	/**
	 * 6. 장르별 이벤트결과 리스트조회
	 * @param pi			페이지네이션정보
	 * @return				리스트
	 */
	public ArrayList<EventRaffle> selectListByGenre(PageInfo pi, String genre) {
		Connection conn = getConnection();
		ArrayList<EventRaffle> list = new EventResultDao().selectListByGenre(conn,pi,genre);
		close(conn);
		return list;
	}


}
