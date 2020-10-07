package com.kh.user.model.dao;


import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.user.model.vo.PageInfo;
import com.kh.user.model.vo.Search;

public class SearchDao {
	
	private Properties prop = new Properties();
	
	public SearchDao() {
		String fileName = MemberDao.class.getResource("/sql/user/search-mapper.xml").getPath();
	      
	      try {
	         prop.loadFromXML(new FileInputStream(fileName));
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	}

	
	public int searchListCount(Connection conn, String keyword) {
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("searchListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+"#"+keyword+"%");
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("LISTVIEW");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return listCount;
	}
	
	public ArrayList<Search> searchList(Connection conn, PageInfo pi, String keyword){
		ArrayList<Search> search = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("searchList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setString(1,  "%"+"#"+keyword+"%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				search.add(new Search(rset.getInt("CONTENT_NO"),
									  rset.getString("CONTENT_TYPE"),
									  rset.getString("CONTENT_TITLE"),
									  rset.getString("PLACE"),
									  rset.getString("PRICE"),
									  rset.getString("REGION"),
									  rset.getString("CONTENT_CHIMG"),
									  rset.getString("CONTENT_IMGPATH")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return search;
		
	}
}
