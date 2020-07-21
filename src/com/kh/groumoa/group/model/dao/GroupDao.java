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
import java.util.ArrayList;
import java.util.Properties;

import com.kh.groumoa.group.model.vo.Attachment;
import com.kh.groumoa.group.model.vo.GroupMemberVO;
import com.kh.groumoa.group.model.vo.GroupVO;
import com.kh.groumoa.member.model.vo.MemberVO;
import com.kh.groumoa.member.model.vo.RegionVO;

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
		
		return result;
	}

	public int selectCurrval(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		int groupCode = 0;
		
		String query = prop.getProperty("selectCurrval");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				groupCode = rset.getInt("currval");
				
//				groupCode = Integer.toString(id);
				
/*				if(id < 10) {
					groupCode = "G000"+ id;					
				} else if(id >= 10) {
					groupCode = "G00" + id;
				}*/
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
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, attachment.getOriginName());
			pstmt.setString(2, attachment.getChangeName());
			pstmt.setString(3, attachment.getFilePath());
			pstmt.setInt(4, attachment.getFileLevel());
			pstmt.setInt(5, attachment.getGroupCode());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public RegionVO searchRegion(Connection con, String rnCode) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		RegionVO region = null;
		
		String query = prop.getProperty("searchRegion");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, rnCode);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				region = new RegionVO();
				region.setRnCode("RN_CODE");
				region.setRegionName(rset.getString("REGION_NAME"));
				region.setRegionSpecific(rset.getString("REGION_SPECIFIC"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con);
			close(rset);
		}
		
		return region;
	}
	
	public int updateThumbnailContent(Connection con, GroupVO group) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateGroup");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, group.getOpenYn());
			pstmt.setString(2, group.getNickNameyn());
			pstmt.setString(3, group.getGroupRule());
			pstmt.setString(4, group.getDescription());
			pstmt.setInt(5, group.getGroupCode());

			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("Dao" + result);
		return result;
	}
	
	public GroupVO selectGroup(Connection con, String groupCode) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		GroupVO group = null;
		
		String query = prop.getProperty("selectOne");
		System.out.println(groupCode);
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, groupCode);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				group = new GroupVO();
				
				group.setGroupCode(rset.getInt("GROUP_CODE"));
				group.setGroupName(rset.getString("GROUP_NAME"));
				group.setInterestCode(rset.getString("INTEREST_CODE"));
				group.setOpenYn(rset.getString("OPEN_YN"));
				group.setNickNameyn(rset.getString("NICKNAME_YN"));
				group.setOpenDate(rset.getDate("OPEN_DATE"));
				group.setGroupRule(rset.getString("GROUP_RULE"));
				group.setDescription(rset.getString("DESCRIPTION"));
//				System.out.println(group);

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con);
			close(pstmt);
		}
		System.out.println(group);
		return group;
	}

	public int updateAttachment(Connection con, Attachment attachment) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateAttachment");
		
		try {
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, attachment.getOriginName());
			pstmt.setString(2, attachment.getChangeName());
			pstmt.setString(3, attachment.getFilePath());
			pstmt.setInt(4, attachment.getFileLevel());
			pstmt.setInt(5, attachment.getGroupCode());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	//동호회페이지 동호회 조회
	

	
	//동호회 1개 조회(일반페이지)
	public GroupVO selectOneGroup(Connection con, GroupVO requestGroup) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		GroupVO selectedGroup = null;
		
		String query = prop.getProperty("selectOneGroup");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, requestGroup.getGroupCode());
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

	//동호회 회원 추방
	public int kickOut(Connection con, int memberCode) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("kickOut");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, memberCode);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}


	public ArrayList<MemberVO> selectList(Connection con, String groupCode) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<MemberVO> list = new ArrayList();
		
		String query = prop.getProperty("groupMemberList");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, groupCode);
			
			if(rset.next()) {
				MemberVO member = new MemberVO();
				
				member.setGroupCode(rset.getInt("GROUP_CODE"));
				member.setMemberCode(rset.getInt("MEMBER_CODE"));
				member.setGroupLeaderyn(rset.getString("GROUP_LEADERYN"));
				member.setUserName(rset.getString("USER_NAME"));
				member.setPhone(rset.getString("PHONE"));
				member.setEmail(rset.getString("EMAIL"));
				member.setEnrollDate(rset.getDate("ENROLL_DATE"));
				
				list.add(member);
			}
			System.out.println(list);
			rset = pstmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		
		return list;
	}


	public ArrayList<GroupVO> selectMyGroupList(Connection con, MemberVO loginUser) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<GroupVO> myGroupList = new ArrayList<GroupVO>();
		
		String query = prop.getProperty("selectMyGroupList");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, loginUser.getMemberCode());
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				GroupVO g = new GroupVO();
				g.setGroupCode(rset.getInt("GROUP_CODE"));
				g.setGroupName(rset.getString("GROUP_NAME"));
				g.setRnCode(rset.getString("RN_CODE"));
				g.setInterestCode(rset.getString("INTEREST_CODE"));
				g.setOpenYn(rset.getString("OPEN_YN"));
				g.setNickNameyn(rset.getString("NICKNAME_YN"));
				g.setOpenDate(rset.getDate("OPEN_DATE"));
				g.setGroupRule(rset.getString("GROUP_RULE"));
				g.setDescription(rset.getString("DESCRIPTION"));
				g.setInterest(rset.getString("INTEREST"));
				g.setRegionName(rset.getString("REGION_NAME"));
				g.setGroupLeaderName(rset.getString("GROUP_LEADER_NAME"));
				
				myGroupList.add(g);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return myGroupList;
	}


	public ArrayList<GroupVO> selectMyGroupListAsLeader(Connection con, MemberVO loginUser) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<GroupVO> myGroupListAsLeader = new ArrayList<GroupVO>();
		
		String query = prop.getProperty("selectMyGroupListAsLeader");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, loginUser.getMemberCode());
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				GroupVO g = new GroupVO();
				g.setGroupCode(rset.getInt("GROUP_CODE"));
				g.setGroupName(rset.getString("GROUP_NAME"));
				g.setRnCode(rset.getString("RN_CODE"));
				g.setInterestCode(rset.getString("INTEREST_CODE"));
				g.setOpenYn(rset.getString("OPEN_YN"));
				g.setNickNameyn(rset.getString("NICKNAME_YN"));
				g.setOpenDate(rset.getDate("OPEN_DATE"));
				g.setGroupRule(rset.getString("GROUP_RULE"));
				g.setDescription(rset.getString("DESCRIPTION"));
				g.setGroupLeaderYn(rset.getString("GROUP_LEADER_YN"));
				g.setRegionName(rset.getString("REGION_NAME"));
				g.setInterest(rset.getString("INTEREST"));
				myGroupListAsLeader.add(g);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return myGroupListAsLeader;
	}


}