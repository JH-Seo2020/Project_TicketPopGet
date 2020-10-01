package com.kh.community.event.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.community.adBoard.model.dao.AdBoardDao;
import com.kh.community.adBoard.model.vo.AdBoard;
import com.kh.community.event.model.dao.EventDao;
import com.kh.community.event.model.vo.Comment;
import com.kh.community.event.model.vo.Event;
import com.kh.community.review.model.vo.Review;
import com.kh.concert.model.dao.ConcertDao;
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

	/**
	 * 8. 이벤트 게시글에 달린 댓글 총 개수 조회 
	 * @param eventNo
	 * @return
	 */
	public int selectCommentCount(int eventNo) {
		Connection conn = getConnection();
		int result = new EventDao().eventCommentCount(conn, eventNo);
		close(conn);
		return result;
	}

	/**
	 * 9. 이벤트 게시글 댓글 조회 
	 * @param pi
	 * @param eventNo
	 * @return
	 */
	public ArrayList<Comment> selectComment(PageInfo pi, int eventNo) {
		Connection conn = getConnection();
		ArrayList<Comment> list = new EventDao().selectComment(conn,pi,eventNo);
		close(conn);
		return list;
	}

	/**
	 * 10. 이벤트게시글 댓글등록
	 * @param comm
	 * @return
	 */
	public int insertComment(Comment comm) {
		Connection conn = getConnection();
		int result = new EventDao().insertComment(conn, comm);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	/**
	 * 11. 이벤트게시글 삭제
	 * @param comm
	 * @return
	 */
	public int deleteComment(Comment comm) {
		Connection conn = getConnection();
		int result = new EventDao().deleteComment(conn, comm);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	/**
	 * 12. 수정을 위한 이벤트댓글 내용 재호출
	 * @param commentNo
	 * @return
	 */
	public Comment recallForUpdate(int commentNo) {
		
		Connection conn = getConnection();
		Comment eComment = new EventDao().recallForUpdate(conn, commentNo);
		close(conn);
		return eComment;
	}

}
