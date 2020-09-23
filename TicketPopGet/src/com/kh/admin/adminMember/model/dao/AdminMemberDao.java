package com.kh.admin.adminMember.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.user.model.vo.Member;

public class AdminMemberDao {
	
	private Properties prop;
	
	public AdminMemberDao() {
		String fileName = AdminMemberDao.class.getResource("/sql/admin/adminMember_mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Member> selectMemberList(Connection conn){
		// select문 => 여러행
		ArrayList<Member> list = new ArrayList<>();
		
		return list;
	}
	
}
