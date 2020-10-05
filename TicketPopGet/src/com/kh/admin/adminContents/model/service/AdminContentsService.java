package com.kh.admin.adminContents.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.admin.adminContents.model.dao.AdminContentsDao;
import com.kh.admin.adminContents.model.vo.Contents;
import com.kh.admin.adminMember.model.vo.Page;

public class AdminContentsService {
	
	/**
	 * 컨텐츠수 조회용 서비스
	 * @return 조회된 수
	 */
	public int contentsListCount() {
		Connection conn = getConnection();
		
		int result = new AdminContentsDao().contentsListCount(conn);
		
		close(conn);
		return result;
		
	}
	
	/**
	 * 컨텐츠 조회용 서비스
	 * @param p 페이징처리르 위한 페이지객체
	 * @return 조회된 컨텐츠리스트
	 */
	public ArrayList<Contents> contentsList(Page p) {
		Connection conn = getConnection();
		
		ArrayList<Contents> list = new AdminContentsDao().contentsList(conn, p);
		
		close(conn);
		
		return list;
	}
	
	/**
	 * 연극 등록용 서비스
	 * @param c 등록할 컨텐츠 객체
	 * @return 처리된 행 수
	 */
	public int insertPlay(Contents c) {
		Connection conn = getConnection();
		
		int result = new AdminContentsDao().insertPlay(conn, c);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	/**
	 * 콘서트 등록용 서비스
	 * @param c 등록할 컨텐츠 객체
	 * @return 처리된 행 수
	 */
	public int insertConcert(Contents c) {
		
		Connection conn = getConnection();
		
		int result = new AdminContentsDao().insertConcert(conn, c);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	/**
	 * 전시 등록용 서비스
	 * @param c 등록할 컨턴츠 객체
	 * @return 처리된 행 수
	 */
	public int insertExhibition(Contents c) {
		Connection conn = getConnection();
		int result = new AdminContentsDao().insertExhibition(conn, c);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	/**
	 * 컨텐츠 상세보기용 서비스
	 * @param contentNo			상세보기 요청할 콘텐츠번호
	 * @param contentType		상세보기 요청할 콘텐츠타입
	 * @return					조회된 컨텐츠
	 */
	public Contents contentDetail(int contentNo, String contentType, int roundNo) {
		
		Connection conn = getConnection();
		
		Contents c = new AdminContentsDao().contentDetail(conn, contentNo, contentType, roundNo);
		
		close(conn);
		
		return c;
	}
	
	/**
	 * 연극 수정용 서비스
	 * @param c	수정할 객체
	 * @return  처리된 행 수
	 */
	public int updatePlay(Contents c) {
		Connection conn = getConnection();
		
		int result = new AdminContentsDao().updatePlay(conn, c);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	/**
	 * 콘서트 수정용 서비스
	 * @param c 등록할 컨텐츠 객체
	 * @return 처리된 행 수
	 */
	public int updateConcert(Contents c) {
		
		Connection conn = getConnection();
		
		int result = new AdminContentsDao().updateConcert(conn, c);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);

		return result;
	}
	
	/**
	 * 전시 수정용 서비스
	 * @param c 등록할 컨턴츠 객체
	 * @return 처리된 행 수
	 */
	public int updateExhibition(Contents c) {
		Connection conn = getConnection();
		int result = new AdminContentsDao().updateExhibition(conn, c);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	/**
	 * 컨텐츠 삭제용 서비스
	 * @param contentNo		삭제할 컨텐츠번호
	 * @param contentType	삭제할 컨텐츠 타입
	 * @return				처리된 행 수
	 */
	public int deleteContents(int contentNo, String contentType) {
		Connection conn = getConnection();
		
		int result = new AdminContentsDao().deleteContents(conn, contentNo, contentType);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
}
