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

import com.kh.concert.model.vo.PageInfo;
import com.kh.user.model.vo.MyPageShow;

public class MyPageDao {
	
	private Properties prop = new Properties();
	
	public MyPageDao() {
	      
	      String fileName = MemberDao.class.getResource("/sql/user/mypage-mapper.xml").getPath();
	      
	      try {
	         prop.loadFromXML(new FileInputStream(fileName));
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	   }
	
	public MyPageShow selectShowList(Connection conn, String userId) {


		MyPageShow mps = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectShowList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				mps=new MyPageShow(rset.getString("USER_ID"),
						           rset.getInt("TICKET_NO"),
						           rset.getString("CONTENT_TYPE"),
						           rset.getDate("VIEW_DATE"),
						           rset.getString("CONTENT_TITLE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return mps;
		
	}
	
}
