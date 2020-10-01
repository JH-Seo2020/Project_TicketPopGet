package com.kh.community.review.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.community.eventResult.model.dao.EventResultDao;
import com.kh.community.eventResult.model.vo.EventRaffle;
import com.kh.community.review.model.dao.ReviewDao;
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

}
