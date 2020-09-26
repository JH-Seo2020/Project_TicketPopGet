package com.kh.play.model.service;
import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.concert.model.vo.PageInfo;
import com.kh.play.model.dao.PlayDao;
import com.kh.play.model.vo.Play;

public class PlayService {
	
	
	/**
	 * 1. 연극 총 개수 조회용 서비스
	 * @return			현재 게시중인 연극 컨텐츠 총 개수
	 * @author 			서지혜
	 */
	public int selectListCount() {
		
		Connection conn = getConnection();
		int result = new PlayDao().selectListCount(conn);
		
		close(conn);
		
		return result;
	}

	/**
	 * 2. 연극 메인리스트 조회용 서비스
	 * @param pi		페이징 정보
	 * @return			페이지에 해당되는 연극컨텐츠 정보 리스트
	 * @author 			서지혜
	 */
	public ArrayList<Play> selectList(PageInfo pi) {
		
		Connection conn = getConnection();
		ArrayList<Play> list = new PlayDao().selectList(conn, pi);
		
		close(conn);
		
		return list;
	}

	/**
	 * 3. 연극 세부조회용 서비스
	 * @param contentNo		컨텐츠번호
	 * @return				해당 컨텐츠 상세정보 
	 * @author				서지혜
	 */
	public Play playDetailView(int contentNo) {
		
		Connection conn = getConnection();
		Play playObject = new PlayDao().playDetailView(conn, contentNo);
		close(conn);
		return playObject;
	}

}
