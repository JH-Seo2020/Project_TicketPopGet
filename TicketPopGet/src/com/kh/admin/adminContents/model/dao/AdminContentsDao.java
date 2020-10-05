package com.kh.admin.adminContents.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.admin.adminContents.model.vo.Contents;
import com.kh.admin.adminMember.model.vo.Page;

public class AdminContentsDao {
	
	private Properties prop = new Properties();
	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	public AdminContentsDao() {
		
		String fileName = AdminContentsDao.class.getResource("/sql/admin/adminContents_mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public int contentsListCount(Connection conn) {
		
		int result = 0;
		Statement stmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("listCount");
		
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(stmt);
			close(rset);
		}
		return result;
	}
	
	public ArrayList<Contents> contentsList(Connection conn, Page p) {
		
		ArrayList<Contents> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("list");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (p.getCurrentPage()-1)*p.getBoardLimit() +1;
			int endRow = startRow + p.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Contents(rset.getInt("content_no"),
						              rset.getString("content_type"),
						              rset.getString("content_title"),
						              rset.getString("content_subject"),
						              rset.getString("place"),
						              rset.getString("limit"),
						              rset.getString("price"),
						              rset.getString("content_keyword"),
						              rset.getString("info"),
						              rset.getString("content_status"),
						              rset.getInt("latitude"),
						              rset.getInt("longitude"),
						              rset.getString("region"),
						              rset.getString("content_ogimg"),
						              rset.getString("content_chimg"),
						              rset.getString("content_imgpath")
						              ));
			}
			
			for(Contents c : list) {
				if(c.getContentType().equals("연극")) {
					sql = prop.getProperty("listPlay");
					
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setInt(1, c.getContentNo());
					rset = pstmt.executeQuery();
					
					while(rset.next()) {
						c.setContentTerm(format.format((rset.getDate("play_start"))) + " ~ " + format.format(rset.getDate("play_end")));
						c.setContentRuntime(rset.getString("play_runtime"));
						c.setRound(rset.getString("round_count"));
						c.setRoundNo(rset.getInt("round_no"));
					}
				}else if(c.getContentType().equals("전시")) {
					sql = prop.getProperty("listExhibition");
					
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setInt(1, c.getContentNo());
					rset = pstmt.executeQuery();
					
					while(rset.next()) {
						c.setContentTerm(format.format(rset.getDate("exhibition_start")) + " ~ " + format.format(rset.getDate("exhibition_end")));
						c.setContentRuntime("-");
					}
				}else if(c.getContentType().equals("콘서트")) {
					sql = prop.getProperty("listConcert");
					
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setInt(1, c.getContentNo());
					rset = pstmt.executeQuery();
					
					while(rset.next()) {
						c.setContentTerm(format.format(rset.getDate("concert_date")));
						c.setContentRuntime(rset.getString("concert_runtime"));
					}
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public int insertPlay(Connection conn, Contents c) {
		int result1 = 0;
		int result2 = 0;
		int result3 = 0;
		PreparedStatement pstmt = null;
		String sql = "";
		try {
			sql = prop.getProperty("insertPlayContent");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, c.getContentTitle());
			pstmt.setString(2, c.getContentSubject());
			pstmt.setString(3, c.getPlace());
			pstmt.setString(4, c.getLimit());
			pstmt.setString(5, c.getPrice());
			pstmt.setString(6, c.getContentKeyword());
			pstmt.setString(7, c.getInfo());
			pstmt.setString(8, c.getRegion());
			pstmt.setString(9, c.getContentOgImg());
			pstmt.setString(10, c.getContentChImg());
			pstmt.setString(11, c.getContentImgPath());
			
			result1 = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			sql = prop.getProperty("insertPlay");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getStartDate());
			pstmt.setString(2, c.getEndDate());
			pstmt.setString(3, c.getContentRuntime());
			
			result2 = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			sql = prop.getProperty("insertRound");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getRound());
			pstmt.setString(2, c.getContentDate());
			pstmt.setString(3, c.getStartTime());
			pstmt.setString(4, c.getEndTime());
			pstmt.setInt(5, c.getMax());
			pstmt.setInt(6, c.getMax());
			
			result3 = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result1*result2*result3;
	}
	
	public int insertConcert(Connection conn, Contents c) {
		
		int result1= 0;
		int result2= 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertConcertContent");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, c.getContentTitle());
			pstmt.setString(2, c.getContentSubject());
			pstmt.setString(3, c.getPlace());
			pstmt.setString(4, c.getLimit());
			pstmt.setString(5, c.getPrice());
			pstmt.setString(6, c.getContentKeyword());
			pstmt.setString(7, c.getInfo());
			pstmt.setString(8, c.getRegion());
			pstmt.setString(9, c.getContentOgImg());
			pstmt.setString(10, c.getContentChImg());
			pstmt.setString(11, c.getContentImgPath());
			
			result1 = pstmt.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		try {
			sql = prop.getProperty("insertConcert");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, c.getStartDate());
			pstmt.setString(2, c.getContentRuntime());
			pstmt.setInt(3, c.getMax());
			pstmt.setInt(4, c.getMax());
			pstmt.setString(5, c.getStartTime());
			pstmt.setString(6, c.getEndTime());
			
			result2=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result1*result2;
	}
	
	public int insertExhibition(Connection conn, Contents c) {
		
		int result1 = 0;
		int result2 = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertExhibitionContent");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, c.getContentTitle());
			pstmt.setString(2, c.getContentSubject());
			pstmt.setString(3, c.getPlace());
			pstmt.setString(4, c.getLimit());
			pstmt.setString(5, c.getPrice());
			pstmt.setString(6, c.getContentKeyword());
			pstmt.setString(7, c.getInfo());
			pstmt.setString(8, c.getRegion());
			pstmt.setString(9, c.getContentOgImg());
			pstmt.setString(10, c.getContentChImg());
			pstmt.setString(11, c.getContentImgPath());
			
			result1 = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		sql = prop.getProperty("insertExhibition");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, c.getStartDate());
			pstmt.setString(2, c.getEndDate());
			
			result2=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result1*result2;
	}
	
	public Contents contentDetail(Connection conn, int contentNo, String contentType, int roundNo) {
		
		Contents c = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "";
		
		if(contentType.equals("연극")) {
			sql = prop.getProperty("selectPlay");
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, contentNo);
				pstmt.setInt(2, roundNo);
				
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					c = new Contents();
					c.setContentNo(contentNo);
					c.setContentType(contentType);
					c.setContentTitle(rset.getString("content_title"));
					c.setContentSubject(rset.getString("content_subject"));
					c.setStartDate(rset.getString("play_start").substring(0,10));
					c.setEndDate(rset.getString("play_end").substring(0,10));
					c.setRound(rset.getString("round_count"));
					c.setContentDate(rset.getString("round_date").substring(0,10));
					c.setContentRuntime(rset.getString("play_runtime"));
					c.setStartTime(rset.getString("round_start"));
					c.setEndTime(rset.getString("round_end"));
					c.setMax(rset.getInt("round_max"));
					c.setPlace(rset.getString("place"));
					c.setRegion(rset.getString("region"));
					c.setLimit(rset.getString("Limit"));
					c.setPrice(rset.getString("price"));
					c.setContentKeyword(rset.getString("content_keyword"));
					c.setInfo(rset.getString("info"));
					c.setContentOgImg(rset.getString("content_ogimg"));
					c.setContentChImg(rset.getString("content_chimg"));
					c.setContentImgPath(rset.getString("content_imgpath"));
					c.setStartDay(rset.getDate("play_start"));
					c.setEndDay(rset.getDate("play_end"));
					c.setContentDay(rset.getDate("round_date"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
		}else if(contentType.equals("전시")) {
			sql = prop.getProperty("selectExhibition");
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, contentNo);
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					c = new Contents();
					c.setContentNo(contentNo);
					c.setContentType(contentType);
					c.setContentTitle(rset.getString("content_title"));
					c.setContentSubject(rset.getString("content_subject"));
					c.setStartDate(rset.getString("exhibition_start").substring(0,10));
					c.setEndDate(rset.getString("exhibition_end").substring(0,10));
					c.setPlace(rset.getString("place"));
					c.setRegion(rset.getString("region"));
					c.setLimit(rset.getString("limit"));
					c.setPrice(rset.getString("price"));
					c.setContentKeyword(rset.getString("content_keyword"));
					c.setContentOgImg(rset.getString("content_ogimg"));
					c.setContentChImg(rset.getString("content_chimg"));
					c.setContentImgPath(rset.getString("content_imgpath"));
					c.setInfo(rset.getString("info"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
			
		}else if(contentType.equals("콘서트")) {
			sql = prop.getProperty("selectConcert");
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, contentNo);
				
				rset = pstmt.executeQuery();
				if(rset.next()) {
					c = new Contents();
					c.setContentNo(contentNo);
					c.setContentType(contentType);
					c.setContentTitle(rset.getString("content_title"));
					c.setContentSubject(rset.getString("content_subject"));
					c.setContentDate(rset.getString("concert_date").substring(0,10));
					c.setStartTime(rset.getString("concert_start"));
					c.setEndTime(rset.getString("concert_end"));
					c.setMax(rset.getInt("concert_max"));
					c.setPlace(rset.getString("place"));
					c.setRegion(rset.getString("region"));
					c.setLimit(rset.getString("limit"));
					c.setPrice(rset.getString("price"));
					c.setContentKeyword(rset.getString("content_keyword"));
					c.setContentOgImg(rset.getString("content_ogimg"));
					c.setContentChImg(rset.getString("content_chimg"));
					c.setContentImgPath(rset.getString("content_imgpath"));
					c.setInfo(rset.getString("info"));
					c.setContentRuntime(rset.getString("concert_runtime"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
		}

		return c;
	}
	
	public int updatePlay(Connection conn, Contents c) {
		int result1 = 0;
		int result2 = 0;
		int result3 = 0;
		PreparedStatement pstmt = null;
		String sql = "";
		try {
			sql = prop.getProperty("updateContent");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, c.getContentTitle());
			pstmt.setString(2, c.getContentSubject());
			pstmt.setString(3, c.getPlace());
			pstmt.setString(4, c.getLimit());
			pstmt.setString(5, c.getPrice());
			pstmt.setString(6, c.getContentKeyword());
			pstmt.setString(7, c.getInfo());
			pstmt.setString(8, c.getRegion());
			pstmt.setString(9, c.getContentOgImg());
			pstmt.setString(10, c.getContentChImg());
			pstmt.setString(11, c.getContentImgPath());
			pstmt.setInt(12, c.getContentNo());
			
			result1 = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			sql = prop.getProperty("updatePlay");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getStartDate());
			pstmt.setString(2, c.getEndDate());
			pstmt.setString(3, c.getContentRuntime());
			pstmt.setInt(4, c.getContentNo());
			
			result2 = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			sql = prop.getProperty("updateRound");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getRound());
			pstmt.setString(2, c.getContentDate());
			pstmt.setString(3, c.getStartTime());
			pstmt.setString(4, c.getEndTime());
			pstmt.setInt(5, c.getMax());
			pstmt.setInt(6, c.getContentNo());
			
			result3 = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result1*result2*result3;
	}
	
	public int updateConcert(Connection conn, Contents c) {
		
		int result1= 0;
		int result2= 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateContent");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, c.getContentTitle());
			pstmt.setString(2, c.getContentSubject());
			pstmt.setString(3, c.getPlace());
			pstmt.setString(4, c.getLimit());
			pstmt.setString(5, c.getPrice());
			pstmt.setString(6, c.getContentKeyword());
			pstmt.setString(7, c.getInfo());
			pstmt.setString(8, c.getRegion());
			pstmt.setString(9, c.getContentOgImg());
			pstmt.setString(10, c.getContentChImg());
			pstmt.setString(11, c.getContentImgPath());
			pstmt.setInt(12, c.getContentNo());
			
			result1 = pstmt.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		try {
			sql = prop.getProperty("updateConcert");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, c.getStartDate());
			pstmt.setString(2, c.getContentRuntime());
			pstmt.setInt(3, c.getMax());
			pstmt.setString(4, c.getStartTime());
			pstmt.setString(5, c.getEndTime());
			pstmt.setInt(6, c.getContentNo());
			
			result2=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}

		return result1*result2;
	}
	
	public int updateExhibition(Connection conn, Contents c) {
		
		int result1 = 0;
		int result2 = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateContent");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, c.getContentTitle());
			pstmt.setString(2, c.getContentSubject());
			pstmt.setString(3, c.getPlace());
			pstmt.setString(4, c.getLimit());
			pstmt.setString(5, c.getPrice());
			pstmt.setString(6, c.getContentKeyword());
			pstmt.setString(7, c.getInfo());
			pstmt.setString(8, c.getRegion());
			pstmt.setString(9, c.getContentOgImg());
			pstmt.setString(10, c.getContentChImg());
			pstmt.setString(11, c.getContentImgPath());
			pstmt.setInt(12, c.getContentNo());
			
			result1 = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		sql = prop.getProperty("updateExhibition");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, c.getStartDate());
			pstmt.setString(2, c.getEndDate());
			pstmt.setInt(3, c.getContentNo());
			
			result2=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result1*result2;
	}
	
	public int deleteContents(Connection conn, int contentNo, String contentType) {
		
		int result1 = 0;
		int result2 = 0;
		
		PreparedStatement pstmt = null;
		String sql = "";
		
		if(contentType.equals("연극")) {
			sql = prop.getProperty("deleteContent");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, contentNo);
				result1=pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			sql = prop.getProperty("deletePlay");
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, contentNo);
				result2=pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			
			
		}else if(contentType.equals("전시")) {
			sql = prop.getProperty("deleteContent");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, contentNo);
				result1=pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			sql = prop.getProperty("deleteExhibition");
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, contentNo);
				result2=pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
		}else if(contentType.equals("콘서트")) {
			sql = prop.getProperty("deleteContent");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, contentNo);
				result1=pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			sql = prop.getProperty("deleteConcert");
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, contentNo);
				result2=pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
		}
		
		return result1*result2;
	}
	
}

