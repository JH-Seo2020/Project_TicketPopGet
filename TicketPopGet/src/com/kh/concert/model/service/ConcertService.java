package com.kh.concert.model.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Clob;
import java.sql.Connection;
import java.util.ArrayList;

import com.kh.community.review.model.vo.Review;
import com.kh.concert.model.dao.ConcertDao;
import com.kh.concert.model.vo.Concert;
import com.kh.concert.model.vo.PageInfo;

public class ConcertService {
	
	/**
	 * 1. 콘서트 컨텐츠 개수 조회용 서비스
	 * @return 			콘서트 컨텐츠의 총 개수
	 * @author 			서지혜
	 */
	public int selectListCount() {
		
		Connection conn = getConnection();
		int result = new ConcertDao().selectListCount(conn);
		
		close(conn);
		
		return result;
	}

	/**
	 * 2. 요청한 페이지에 해당하는 컨텐츠 정보 리스트 조회용 서비스
	 * @param pi 		페이징처리용 7개 변수 
	 * @return 			해당 페이지에 들어갈 컨텐츠 정보 리스트
	 * @author 			서지혜
	 */
	public ArrayList<Concert> selectList(PageInfo pi) {
		
		Connection conn = getConnection();
		
		ArrayList<Concert> list = new ConcertDao().selectList(conn, pi);
		
		close(conn);
		
		return list;
	}

	/**
	 * 3. 콘서트 세부 조회 페이지 조회용 서비스
	 * @param concertNo		해당 콘서트 컨텐츠 번호
	 * @return				번호에 해당하는 콘서트 정보 객체(1개)
	 * @author 				서지혜
	 */
	public Concert concertDetailView(int concertNo) {
		
		Connection conn = getConnection();
		Concert concertObject = new ConcertDao().concertDetailView(conn,concertNo);
		
		close(conn);
		
		return concertObject;
	}

	/**
	 * 4. 콘서트 정보 Clob to String으로 가져오는 테스트메소드 
	 * @param concertNo		해당 콘서트 컨텐츠 번호
	 * @return				info 컬럼 내용
	 * @author 				서지혜
	 */
	public String concertInfo(int concertNo) {
		
		Connection conn = getConnection();
		String info = new ConcertDao().concertInfo(conn, concertNo);
		close(conn);
		return info;
	}

	/**
	 * 5. 리뷰총개수조회
	 * @param contentNo
	 * @return				개수
	 * @author 				서지혜
	 */
	public int selectReview(int contentNo) {
		
		Connection conn = getConnection();
		int result = new ConcertDao().selectReview(conn,contentNo); 
				
		close(conn);
		
		return result;
	}

	/**
	 * 6. 리뷰전부가져와
	 * @param pi
	 * @param contentNo
	 * @return				리뷰전부
	 * @author 				서지혜
	 */
	public ArrayList<Review> selectReviewsAll(PageInfo pi, int contentNo) {
		
		Connection conn = getConnection();
		ArrayList<Review> list = new ConcertDao().selectReviewsAll(conn,pi,contentNo);
		
		close(conn);
		
		return list;
	}

	
	
	
	
	
	
	
	
}
