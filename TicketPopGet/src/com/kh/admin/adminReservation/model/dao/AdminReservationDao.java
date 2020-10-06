package com.kh.admin.adminReservation.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AdminReservationDao {
	
	private Properties prop = new Properties();
	
	public AdminReservationDao() {
		
		String fileName = AdminReservationDao.class.getResource("/sql/admin/adminReservation_mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
