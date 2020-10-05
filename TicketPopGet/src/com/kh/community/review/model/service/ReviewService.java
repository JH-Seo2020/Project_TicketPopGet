package com.kh.community.review.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.community.adBoard.model.dao.AdBoardDao;
import com.kh.community.adBoard.model.vo.AdBoard;
import com.kh.community.adBoard.model.vo.Report;
import com.kh.community.event.model.dao.EventDao;
import com.kh.community.event.model.vo.Comment;
import com.kh.community.eventResult.model.dao.EventResultDao;
import com.kh.community.eventResult.model.vo.EventRaffle;
import com.kh.community.review.model.dao.ReviewDao;
import com.kh.community.review.model.vo.Reply;
import com.kh.community.review.model.vo.Review;
import com.kh.concert.model.vo.PageInfo;


public class ReviewService {

	/**
	 * 1. 전체 리뷰 개수 카운트
	 * @return
	 */
	public int reviewListCount() {
		Connection conn = getConnection();
		int result = new ReviewDao().reviewListCount(conn);
		close(conn);
		
		return result;
	}

	/**
	 * 2. 리뷰 게시물 정보 리스트 조회
	 * @param pi
	 * @return
	 */
	public ArrayList<Review> selectList(PageInfo pi) {
		Connection conn = getConnection();
		ArrayList<Review> list = new ReviewDao().selectList(conn,pi);
		close(conn);
		return list;
	}

	/**
	 * 3. 장르별 리뷰게시글 개수 조회
	 * @param genre
	 * @return
	 */
	public int reviewCountByGenre(String genre) {
		Connection conn = getConnection();
		int result = new ReviewDao().reviewCountByGenre(conn,genre);
		close(conn);
		return result;
	}

	/**
	 * 4. 장르별 리뷰게시글 전부 조회
	 * @param pi
	 * @param genre
	 * @return
	 */
	public ArrayList<Review> selectListByGenre(PageInfo pi, String genre) {
		Connection conn = getConnection();
		ArrayList<Review> list = new ReviewDao().selectListByGenre(conn,pi,genre);
		close(conn);
		return list;
	}

	/**
	 * 5. 리뷰게시글 조회수 증가 
	 * @param reviewNo
	 * @return
	 */
	public int plusCount(int reviewNo) {
		Connection conn = getConnection();
		int result = new ReviewDao().plusCount(conn, reviewNo);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	/**
	 * 6. 리뷰게시글 세부조회 (내용빼고다)
	 * @param reviewNo
	 * @return
	 */
	public Review reviewDetail(int reviewNo) {
		Connection conn = getConnection();
		Review r = new ReviewDao().reviewDetail(conn, reviewNo);
		close(conn);
		return r;
	}

	/**
	 * 7. 리뷰게시글 내용조회 (clob to string)
	 * @param reviewNo
	 * @return
	 */
	public String reviewContent(int reviewNo) {
		Connection conn = getConnection();
		String reviewContent = new ReviewDao().reviewContent(conn,reviewNo);
		close(conn);
		return reviewContent;
	}

	/**
	 * 8. 리뷰게시글 삭제
	 * @param reviewNo
	 * @return
	 */
	public int deleteReview(int reviewNo) {
		Connection conn = getConnection();
		int result = new ReviewDao().deleteReview(conn,reviewNo);
		if (result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	/**
	 * 9. 리뷰 게시글에 달린 댓글 총 개수 조회 
	 * @param reviewNo
	 * @return
	 */
	public int selectReplyCount(int reviewNo) {
		Connection conn = getConnection();
		int result = new ReviewDao().selectReplyCount(conn, reviewNo);
		close(conn);
		return result;
	}

	/**
	 * 10. 리뷰게시글 댓글 조회
	 * @param pi
	 * @param reviewNo
	 * @return
	 */
	public ArrayList<Reply> selectReply(PageInfo pi, int reviewNo) {
		Connection conn = getConnection();
		ArrayList<Reply> list = new ReviewDao().selectReply(conn,pi,reviewNo);
		close(conn);
		return list;
	}

	/**
	 * 11. 리뷰게시글 댓글추가
	 * @param reply
	 * @return
	 */
	public int insertReply(Reply reply) {
		Connection conn = getConnection();
		int result = new ReviewDao().insertReply(conn, reply);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;

	}

	/**
	 * 12. 리뷰댓글 수정을 위한 댓글내용 재호출 메소드
	 * @param replyNo
	 * @return
	 */
	public Reply recallForUpdate(int replyNo) {
		Connection conn = getConnection();
		Reply rReply = new ReviewDao().recallForUpdate(conn, replyNo);
		close(conn);
		return rReply;
	}

	/**
	 * 13. 리뷰댓글 수정 
	 * @param replyNo
	 * @param replyContent
	 * @return
	 */
	public int replyUpdate(int replyNo, String replyContent) {
		
		Connection conn = getConnection();
		int result = new ReviewDao().replyUpdate(conn, replyNo, replyContent);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}



}
