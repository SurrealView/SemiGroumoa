package com.kh.groumoa.member.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.groumoa.member.model.vo.MemberVO;
import com.kh.groumoa.member.model.dao.MemberDao;

import static com.kh.groumoa.common.JDBCTemplate.*;

public class MemberDao {
	
private Properties prop = new Properties();
	
	public MemberDao() {
		String fileName = MemberDao.class.getResource("/sql/member/member-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public MemberVO loginCheck(Connection con, MemberVO requestMember) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		MemberVO loginUser = null;
		
		String query = prop.getProperty("loginSelect");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, requestMember.getEmail());
			pstmt.setString(2, requestMember.getUserPwd());
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				loginUser = new MemberVO();
				
				loginUser.setMemberCode(rset.getInt("MEMBER_CODE"));
				loginUser.setEmail(rset.getString("EMAIL"));
				loginUser.setUserPwd(rset.getString("USER_PWD"));
				loginUser.setUserName(rset.getString("USER_NAME"));
				loginUser.setGender(rset.getString("GENDER"));
				loginUser.setRnCode(rset.getString("RN_CODE"));
				loginUser.setAddress(rset.getString("ADDRESS"));
				loginUser.setPhone(rset.getString("PHONE"));
				loginUser.setBirthDate(rset.getDate("BIRTH_DATE"));
				loginUser.setEnrollDate(rset.getDate("ENROLL_DATE"));
				loginUser.setStatus(rset.getString("STATUS"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		
		
		return loginUser;
	}

}
