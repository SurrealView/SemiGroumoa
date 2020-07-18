package com.kh.groumoa.group.model.dao;

import static com.kh.groumoa.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.kh.groumoa.group.model.vo.Attachment;
import com.kh.groumoa.group.model.vo.GroupVO;
import com.kh.groumoa.member.model.vo.MemberVO;

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


	public int insertThumbnailContent(Connection con, GroupVO group) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertGroup");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, group.getGroupName());
			pstmt.setString(2, group.getRnCode());
			pstmt.setString(3, group.getInterestCode());
			pstmt.setString(4, group.getOpenYn());
			pstmt.setString(5, group.getNickNameyn());
			pstmt.setString(6, group.getGroupRule());
			pstmt.setString(7, group.getDescription());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("Dao" + result);
		return result;
	}

	public String selectCurrval(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		String groupCode = "";
		
		String query = prop.getProperty("selectCurrval");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				int id = rset.getInt("currval");
				
//				groupCode = Integer.toString(id);
				
				if(id < 10) {
					groupCode = "G000"+ id;					
				} else if(id >= 10) {
					groupCode = "G00" + id;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rset);
		}
		
		return groupCode;
	}

	public int insertAttachment(Connection con, Attachment attachment) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertAttachment");
		
		try {
			GroupVO group = new GroupVO();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, attachment.getOriginName());
			pstmt.setString(2, attachment.getChangeName());
			pstmt.setString(3, attachment.getFilePath());
			pstmt.setInt(4, attachment.getFileLevel());
			pstmt.setString(5, attachment.getGroupCode());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
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
			pstmt.setString(5, requestGroup.getGroupCode());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	
	//동호회 1개 조회(일반페이지)
	public GroupVO selectOneGroup(Connection con, GroupVO requestGroup) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		GroupVO selectedGroup = null;
		
		String query = prop.getProperty("selectOneGroup");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, requestGroup.getGroupCode());
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				selectedGroup = new GroupVO();
				selectedGroup.setGroupName(rset.getString("GROUP_NAME"));
				selectedGroup.setRnCode(rset.getString("RN_CODE"));
				selectedGroup.setInterestCode(rset.getString("INTEREST_CODE"));
				selectedGroup.setOpenYn(rset.getString("OPEN_YN"));
				selectedGroup.setNickNameyn(rset.getString("NICKNAME_YN"));
				selectedGroup.setOpenDate(rset.getDate("OPEN_DATE"));
				selectedGroup.setGroupRule(rset.getString("GROUP_RULE"));
				selectedGroup.setDescription(rset.getString("DESCRIPTION"));	
			} 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		
		return selectedGroup;
	}


}
