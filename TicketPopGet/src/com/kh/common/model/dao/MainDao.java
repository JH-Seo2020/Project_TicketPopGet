package com.kh.common.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import static com.kh.common.JDBCTemplate.*;
import com.kh.common.model.vo.MainContent;

public class MainDao {
	
	Properties prop = new Properties();
	
	public MainDao() {
		
		String fileName = MainDao.class.getResource("/sql/main/main-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public MainContent selectTbConcert(Connection conn) {
		MainContent tbConcert = null;
		Statement stmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectTbConcert");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			while(rset.next()) {
				tbConcert = new MainContent(rset.getInt("content_no"),
								rset.getInt("tbConRate"),
								rset.getString("content_type"),
								rset.getString("content_title"),
								rset.getString("content_chimg"),
								rset.getString("content_imgpath"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		return tbConcert;
	}

	public MainContent selectTbPlay(Connection conn) {
		MainContent tbPlay = null;
		Statement stmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectTbPlay");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			while(rset.next()) {
				tbPlay = new MainContent(rset.getInt("content_no"),
								rset.getInt("tbPlayRate"),
								rset.getString("content_type"),
								rset.getString("content_title"),
								rset.getString("content_chimg"),
								rset.getString("content_imgpath"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		return tbPlay;
	}

	public MainContent selectTbEx(Connection conn) {
		MainContent tbEx = null;
		Statement stmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectTbEx");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			while(rset.next()) {
				tbEx = new MainContent(rset.getInt("content_no"),
								rset.getInt("tbExTicket"),
								rset.getString("content_type"),
								rset.getString("content_title"),
								rset.getString("content_chimg"),
								rset.getString("content_imgpath"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		return tbEx;
	}

	public ArrayList<MainContent> selectNews(Connection conn) {
		ArrayList<MainContent> news = new ArrayList<>();
		Statement stmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectNews");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			while(rset.next()) {
				news.add (new MainContent(rset.getInt("content_no"),
											rset.getString("content_type"),
											rset.getString("content_title"),
											rset.getString("content_chimg"),
											rset.getString("content_imgpath"),
											rset.getDate("concert_date")
											));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		return news;
	}
	
	
	
	

}
