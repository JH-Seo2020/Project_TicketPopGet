package com.kh.user.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.user.model.dao.SearchDao;
import com.kh.user.model.vo.PageInfo;
import com.kh.user.model.vo.Search;

public class SearchService {
	
	public int searchListCount(String keyword) {
		Connection conn = getConnection();
		int listCount = new SearchDao().searchListCount(conn,keyword);
		close(conn);
		return listCount;
	}
	
	public ArrayList<Search> searchList(PageInfo pi, String keyword){
		Connection conn = getConnection();
		ArrayList<Search> search = new SearchDao().searchList(conn,pi,keyword);
		close(conn);
		return search;
	}

}
