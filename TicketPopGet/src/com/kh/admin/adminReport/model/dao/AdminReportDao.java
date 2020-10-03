package com.kh.admin.adminReport.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.admin.adminMember.model.vo.Page;
import com.kh.admin.adminReport.model.vo.Report;

public class AdminReportDao {
	private Properties prop = new Properties();
	
	public AdminReportDao() {
		
		String fileName = AdminReportDao.class.getResource("/sql/admin/adminReport_mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public int reportListCount(Connection conn) {
		
		int result = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("reportListCount");
		
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		return result;
	}
	
	public ArrayList<Report> reportListT(Connection conn, Page p){
		
		ArrayList<Report> t = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("reportListT");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (p.getCurrentPage()-1)*p.getBoardLimit() +1;
			int endRow = startRow + p.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				t.add(new Report(rset.getInt("report_no"),
						         rset.getString("user_id"),
						         rset.getString("report_type"),
						         rset.getString("report_cate"),
						         rset.getString("report_content"),
						         rset.getDate("report_date"),
						         rset.getString("report_status"),
						         rset.getInt("content_no")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return t;
	}
	
	public ArrayList<Report> reportListR(Connection conn, Page p){
		
		ArrayList<Report> t = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("reportListR");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (p.getCurrentPage()-1)*p.getBoardLimit() +1;
			int endRow = startRow + p.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				t.add(new Report(rset.getInt("report_no"),
						         rset.getString("user_id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return t;
	}
	
	public ArrayList<Report> reportListC(Connection conn, ArrayList<Report> list){
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "";
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getReportCate().equals("홍보게시판")) {
				sql = prop.getProperty("reportInfoBoard");
				
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, list.get(i).getContentNo());
					pstmt.setString(2, list.get(i).getTroublemaker());
					pstmt.setInt(3, list.get(i).getReportNo());
					
					rset = pstmt.executeQuery();
					if(rset.next()) {
						list.get(i).setReportInfo(rset.getString("board_title"));
						list.get(i).setReportInfoContent(rset.getString("BOARD_CONTNET"));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					close(rset);
					close(pstmt);
				}

			}else if(list.get(i).getReportCate().equals("이벤트댓글")){
				sql = prop.getProperty("reportInfoEventComment");
				
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, list.get(i).getContentNo());
					pstmt.setString(2, list.get(i).getTroublemaker());
					pstmt.setInt(3, list.get(i).getReportNo());
					
					rset = pstmt.executeQuery();
					if(rset.next()) {
						list.get(i).setReportInfo(rset.getString("event_title") + " 의" + rset.getInt("comment_no") + "번째댓글");
						list.get(i).setReportInfoContent(rset.getString("event_content"));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					close(rset);
					close(pstmt);
				}
			}else if(list.get(i).getReportCate().equals("후기")) {
				sql = prop.getProperty("reportInfoReview");
				
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, list.get(i).getContentNo());
					pstmt.setString(2, list.get(i).getTroublemaker());
					pstmt.setInt(3, list.get(i).getReportNo());
					
					rset = pstmt.executeQuery();
					if(rset.next()) {
						list.get(i).setReportInfo(rset.getString("review_title"));
						list.get(i).setReportInfoContent(rset.getString("review_content"));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					close(rset);
					close(pstmt);
				}
			}else if(list.get(i).getReportCate().equals("후기댓글")) {
				sql = prop.getProperty("reportInfoReviewReply");
				
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, list.get(i).getContentNo());
					pstmt.setString(2, list.get(i).getTroublemaker());
					pstmt.setInt(3, list.get(i).getReportNo());
					
					rset = pstmt.executeQuery();
					if(rset.next()) {
						list.get(i).setReportInfo(rset.getString("review_title") + " 의" + rset.getInt("reply_no") + "번째 댓글");
						list.get(i).setReportInfoContent(rset.getString("reply_content"));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					close(rset);
					close(pstmt);
				}
			}
		}
		return list;
	}
	
	public int checkReport(Connection conn, int reportNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("checkReport");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, reportNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int deleteReport(Connection conn, Report r) {
		
		int result1 = 0;
		int result2 = 0;
		int result3 = 1;
		PreparedStatement pstmt = null;
		String sql = "";
		
		if(r.getReportCate().equals("홍보게시판")) {
			sql = prop.getProperty("deleteReportBoard");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, r.getContentNo());
				
				result1 = pstmt.executeUpdate();
				result2 = checkReport(conn, r.getReportNo());
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			
		}else if(r.getReportCate().equals("후기")) {
			sql = prop.getProperty("deleteReportReview");
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, r.getContentNo());
				
				result1 = pstmt.executeUpdate();
				result2 = checkReport(conn, r.getReportNo());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			sql = prop.getProperty("deleteReportReviewReply");
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, r.getContentNo());
				
				result3 = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			
			
		}else if(r.getReportCate().equals("후기댓글")) {
			sql = prop.getProperty("deleteReportReply");
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, r.getContentNo());
				
				result1 = pstmt.executeUpdate();
				result2 = checkReport(conn, r.getReportNo());
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			
		}else if(r.getReportCate().equals("이벤트댓글")){
			sql = prop.getProperty("deleteReportEventComment");
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, r.getContentNo());
				
				result1 = pstmt.executeUpdate();
				result2 = checkReport(conn, r.getReportNo());
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			
		}
		
		return result1 * result2 * result3; 
	}
	
}
