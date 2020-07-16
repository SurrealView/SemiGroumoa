package com.kh.groumoa.group.model.dao;

import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.groumoa.group.model.vo.GroupVO;
import static com.kh.groumoa.common.JDBCTemplate.*;

public class GroupDao {
	private Properties prop = new Properties();
	
	public GroupDao() {
		String fileName = GroupDao.class.getResource("/sql/group/group-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int updateGroup(Connection con, GroupVO requestGroup) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateGroup");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, requestGroup.getOpenYn());
			pstmt.setString(2, requestGroup.getNickNameyn());
			pstmt.setString(3, requestGroup.getGroupRule());
			pstmt.setString(4, requestGroup.getDescription());
			pstmt.setString(5, requestGroup.getThumbNail());
			pstmt.setString(6, requestGroup.getGroupCode());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
				
		
		
		return result;
	}

}
