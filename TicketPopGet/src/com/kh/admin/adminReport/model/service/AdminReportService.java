package com.kh.admin.adminReport.model.service;

import static com.kh.common.JDBCTemplate.*;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.admin.adminMember.model.vo.Page;
import com.kh.admin.adminReport.model.dao.AdminReportDao;
import com.kh.admin.adminReport.model.vo.Report;

public class AdminReportService {
	
	/**
	 * 신고관리 게시물수 조회용 서비스
	 * @return		조회된 게시물 수
	 */
	public int reportListCount() {
		
		Connection conn = getConnection();
		
		int result = new AdminReportDao().reportListCount(conn);
		
		close(conn);
		
		return result;
	}
	
	/**
	 * 신고관리 리스트 조회용 서비스
	 * @param p		페이징처리를 위한 페이지 객체
	 * @return		조회된 게시글들
	 */
	public ArrayList<Report> reportList(Page p){
		
		Connection conn = getConnection();
		
		ArrayList<Report> tlist = new AdminReportDao().reportListT(conn, p);
		ArrayList<Report> rlist = new AdminReportDao().reportListR(conn, p);
		
		ArrayList<Report> rtlist = new ArrayList<>();
		for(Report t : tlist) {
			rtlist.add(new Report(t.getReportNo(),
					            t.getTroublemaker(),
					       	    t.getReportType(),
					       	    t.getReportCate(),
					       	    t.getReportContent(),
					       	    t.getReportDate(),
					       	    t.getReportStatus(),
					       	    t.getContentNo()));
		};
		
		for(int i=0; i<rlist.size(); i++) {
			rtlist.get(i).setReporter(rlist.get(i).getReporter());
		};
		
		ArrayList<Report> list = new AdminReportDao().reportListC(conn, rtlist);
		
		return list;
	}
	
	/**
	 * 신고관리 신고내용 확인용 서비스
	 * @param reportNo		확인할 신고번호
	 * @return
	 */
	public int checkReport(int reportNo) {
		
		Connection conn = getConnection();
		
		int result = new AdminReportDao().checkReport(conn, reportNo);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}
	
	/**
	 * 신고된 게시물 삭제용 서비스
	 * @param r   삭제해야할 게시물타입, 게시물번호가 들어있는 객체
	 * @return    처리된 행 수
	 */
	public int deleteReport(Report r) {
		
		Connection conn = getConnection();
		
		int result = new AdminReportDao().deleteReport(conn, r);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}
	
}
