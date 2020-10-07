package com.kh.user.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.user.model.vo.Member;

import static com.kh.common.JDBCTemplate.*;

public class MemberDao {
   
   private Properties prop = new Properties();
   
   /**
    * @author 김현선
    */
   public MemberDao() {
      
      String fileName = MemberDao.class.getResource("/sql/user/user-mapper.xml").getPath();
      
      try {
         prop.loadFromXML(new FileInputStream(fileName));
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   /**
    * @param conn
    * @param userId
    * @param userPwd
    * @return
    * @author 김현선
    */
   public Member loginMember(Connection conn, String userId, String userPwd) {
      
      Member m = null;
      
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      
      String sql = prop.getProperty("loginMember");
      
      try {
         pstmt = conn.prepareStatement(sql);
         
         pstmt.setString(1, userId);
         pstmt.setString(2, userPwd);
         
         rset = pstmt.executeQuery();
         
         if(rset.next()) {
            m = new Member(rset.getInt("USER_NO"),
                         rset.getString("USER_ID"),
                         rset.getString("USER_PWD"),
                         rset.getString("USER_NAME"),
                         rset.getString("EMAIL"),
                         rset.getString("PHONE"),
                         rset.getDate("BIRTHDATE"),
                         rset.getString("GENDER"),
                         rset.getDate("DELETE_DATE"),
                         rset.getString("DELETE_STATUS"),
                         rset.getString("BLACKLIST_STATUS"),
                         rset.getInt("REPORT_COUNT"),
                         rset.getString("DELETE_REASON"));
         }
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close(rset);
         close(pstmt);
      }
      
      return m;

   }

   /**
    * @param conn
    * @param checkId
    * @return
    * @author 김현선
    */
   public int idCheck(Connection conn, String checkId) {
      
      int count = 0;
      
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      
      String sql = prop.getProperty("idCheck");
      
      try {
         pstmt = conn.prepareStatement(sql);
         
         pstmt.setString(1, checkId);
         
         rset = pstmt.executeQuery();
         
         if(rset.next()) {
            count = rset.getInt(1);
         }
         
         
      } catch (SQLException e) {
         e.printStackTrace();
      }finally {
         close(rset);
         close(pstmt);
      }
   
      return count;
   }
   
   public int loginAdmin(Connection conn, String userId, String userPwd){
      
      int result = 0;
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      String sql = prop.getProperty("loginAdmin");
      
      try {
         pstmt = conn.prepareStatement(sql);
         
         pstmt.setString(1, userId);
         pstmt.setString(2, userPwd);
         
         rset = pstmt.executeQuery();
         
         if(rset.next()) {
            result = rset.getInt(1); 
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }finally {
         close(rset);
         close(pstmt);
      }
      return result;
   }
   
   /**
    * 비밀번호 변경
    * @param conn
    * @param userId
    * @param userPwd
    * @param newPwd
    * @return
    * @author 이금이
    */
   public int updatePwd(Connection conn, String userId, String userPwd, String newPwd) {
      
      int result = 0;
      
      PreparedStatement pstmt = null;
      
      String sql = prop.getProperty("updatePwd");
      
      try {
         pstmt = conn.prepareStatement(sql);
         
         pstmt.setString(1, newPwd);
         pstmt.setString(2, userId);
         pstmt.setString(3, userPwd);
         
         result = pstmt.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close(pstmt);
      }
      
      return result;
      
   }
   
   /**
    * 갱신한 아이디 리스트 조회
    * @param conn
    * @param userId
    * @return
    * @author 이금이
    */
   public Member selectMember(Connection conn, String userId) {
      Member m = null;
      
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      
      String sql = prop.getProperty("selectMember");
      
      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, userId);
         rset = pstmt.executeQuery();
         
         if(rset.next()) {
            m = new Member(rset.getInt("USER_NO"),
                      rset.getString("USER_ID"),
                      rset.getString("USER_PWD"),
                      rset.getString("USER_NAME"),
                      rset.getString("EMAIL"),
                      rset.getString("PHONE"),
                      rset.getDate("BIRTHDATE"),
                      rset.getString("GENDER"),
                      rset.getDate("DELETE_DATE"),
                      rset.getString("DELETE_STATUS"),
                      rset.getString("BLACKLIST_STATUS"),
                      rset.getInt("REPORT_COUNT"),
                      rset.getString("DELETE_REASON"));
         }
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close(rset);
         close(pstmt);
      }
      
      return m;
   }

   public int insertMember(Connection conn, Member m) {
      
      int result = 0;
      
      PreparedStatement pstmt = null;
      
      String sql = prop.getProperty("insertMember");
      
      try {
         pstmt = conn.prepareStatement(sql);
         
         pstmt.setString(1, m.getUserId());
         pstmt.setString(2, m.getUserPwd());
         pstmt.setString(3, m.getUserName());
         pstmt.setString(4, m.getEmail());
         pstmt.setString(5, m.getPhone());
         pstmt.setDate(6, m.getBirthdate());
         pstmt.setString(7, m.getGender());
         
         result = pstmt.executeUpdate();
         
      } catch (SQLException e) {
         e.printStackTrace();
      }finally {
         close(pstmt);
      }
      
      return result;
      
   }
   
   /**
    * @param conn
    * @param userId
    * @param reason
    * @return
    * @author 이금이
    */
   public int updateDelete(Connection conn, String userId, String reason) {
      
      int result = 0;
      
      PreparedStatement pstmt = null;
      
      String sql = prop.getProperty("updateDelete");
      
      try {
         pstmt = conn.prepareStatement(sql);
         
         pstmt.setString(1, reason);
         pstmt.setString(2, userId);
         
         result=pstmt.executeUpdate();
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close(pstmt);
      }
      
      return result;
   }
   
   
   
	   /**
	 * @param conn
	 * @param m
	 * @return
	 * @author 이금이
	 */
	public int updateMember(Connection conn, Member m) {
		   int result = 0;
		   
		   PreparedStatement pstmt = null;
		   String sql = prop.getProperty("updateInfo");
		   
		   try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getUserName());
			pstmt.setDate(2, m.getBirthdate());
			pstmt.setString(3, m.getGender());
			pstmt.setString(4, m.getPhone());
			pstmt.setString(5, m.getEmail());
			pstmt.setString(6, m.getUserId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		} 
		   
		   return result;
	   }

	/**
	 * @param conn
	 * @param userName
	 * @param phone
	 * @return
	 * @author 김현선
	 */
	public Member findUserId(Connection conn, String userName, String phone) {
		
		Member m = null;
	      
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      
	      String sql = prop.getProperty("findUserId");
	      
	      try {
	         pstmt = conn.prepareStatement(sql);
	         
	         pstmt.setString(1, userName);
	         pstmt.setString(2, phone);
	         
	         rset = pstmt.executeQuery();
	         
	         if(rset.next()) {
	            m = new Member(rset.getString("USER_ID"),
	            			   rset.getString("USER_NAME"));
	         }
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close(rset);
	         close(pstmt);
	      }
	      
	      return m;
	}

	/**
	 * @param conn
	 * @param userName
	 * @param userId
	 * @param phone
	 * @return
	 * @author 김현선
	 */
	public Member findUserPwd(Connection conn, String userName, String userId, String phone) {

		  Member m = null;
	      
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      
	      String sql = prop.getProperty("findUserPwd");
	      
	      try {
	         pstmt = conn.prepareStatement(sql);
	         
	         pstmt.setString(1, userName);
	         pstmt.setString(2, userId);
	         pstmt.setString(3, phone);
	         
	         rset = pstmt.executeQuery();
	         
	         if(rset.next()) {
	            m = new Member(rset.getString("USER_PWD"),
	            			   rset.getString("USER_NAME"));
	         }
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close(rset);
	         close(pstmt);
	      }
	      
	      return m;
	}

}