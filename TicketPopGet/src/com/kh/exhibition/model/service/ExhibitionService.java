package com.kh.exhibition.model.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.concert.model.vo.PageInfo;
import com.kh.exhibition.model.dao.ExhibitionDao;
import com.kh.exhibition.model.vo.Exhibition;
import com.kh.play.model.dao.PlayDao;
import com.kh.play.model.vo.Play;

public class ExhibitionService {

	/**
	 * 1. 전시컨텐츠 총 개수 조회
	 * @return			전시컨텐츠 총 개수(상태y)
	 * @author 			서지혜
	 */
	public int selectListCount() {
		
		Connection conn = getConnection();
		int result = new ExhibitionDao().selectListCount(conn);
		
		close(conn);
		
		return result;
	}

	/**
	 * 2. 요청 페이지에 들어갈 전시 컨텐츠 리스트 조회
	 * @param pi		페이징처리용 객체
	 * @return			요청페이지에 들어갈 전시정보리스트
	 * @author			서지혜
	 */
	public ArrayList<Exhibition> selectList(PageInfo pi) {
		
		Connection conn = getConnection();
		
		ArrayList<Exhibition> list = new ExhibitionDao().selectList(conn, pi);
		
		close(conn);
		
		return list;
	}

	/**
	 * 3. 각 전시 컨텐츠 상세조회 페이지 요청 
	 * @param contentNo		컨텐츠번호
	 * @return				관련 전시 정보 객체(1줄)
	 * @author				서지혜
	 */
	public Exhibition exhibitionDetailView(int contentNo) {
		
		Connection conn = getConnection();
		Exhibition exObject = new ExhibitionDao().exhibitionDetailView(conn, contentNo);
		
		close(conn);
		return exObject;
	}

	/**
	 * 4. 해당 지역 별 전시 컨텐츠 리스트 조회 서비스
	 * @param pi
	 * @param local
	 * @return
	 */
	public ArrayList<Exhibition> selectLocalList(PageInfo pi, String local) {
		
		Connection conn = getConnection();
		ArrayList<Exhibition> list = new ExhibitionDao().selectLocalList(conn, pi, local);
		close(conn);
		return list;
	}

	/**
	 * 5. 찜하기 목록에 추가 
	 * @param contentNo
	 * @param userNo
	 * @return
	 */
	public int updateWish(int contentNo, int userNo) {
		Connection conn = getConnection();
		int result = new ExhibitionDao().updateWish(conn, contentNo, userNo);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}

	

}
