package com.kh.groumoa.group.model.dao;

import static com.kh.groumoa.common.JDBCTemplate.close;
import static com.kh.groumoa.common.JDBCTemplate.getConnection;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.groumoa.common.PageInfo;
import com.kh.groumoa.common.model.vo.AttachmentVo;
import com.kh.groumoa.group.model.vo.Attachment;
import com.kh.groumoa.group.model.vo.GroupMemberVO;
import com.kh.groumoa.group.model.vo.GroupVO;
import com.kh.groumoa.member.model.dao.MemberDao;
import com.kh.groumoa.member.model.vo.InterestVO;
import com.kh.groumoa.member.model.vo.MemberInterestVO;
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
			pstmt.setInt(2, group.getGroupLeaderCode());
			pstmt.setString(3, group.getRnCode());
			pstmt.setString(4, group.getInterestCode());
			pstmt.setString(5, group.getOpenYn());
			pstmt.setString(6, group.getNickNameyn());
			pstmt.setString(7, group.getGroupRule());
			pstmt.setString(8, group.getDescription());
	
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
				region.setRnCode(rset.getString("RN_CODE"));
				region.setRegionName(rset.getString("REGION_NAME"));
				region.setRegionSpecific(rset.getString("REGION_SPECIFIC"));
			}
			System.out.println("dao" + region);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
		}
		
		return region;
	}
	

	public InterestVO searchInterest(Connection con, String interestCode) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		InterestVO interest = null;
		
		String query = prop.getProperty("searchInterest");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, interestCode);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				interest = new InterestVO();
				interest.setInterestCode(rset.getString("INTEREST_CODE"));
				interest.setInterest(rset.getString("INTEREST"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
		}
		
		return interest;
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
	
	public GroupVO selectGroup(Connection con, int groupCode) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		GroupVO group = null;
		
		String query = prop.getProperty("selectOne");
		System.out.println(groupCode);
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, groupCode);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				group = new GroupVO();
				
				group.setGroupCode(rset.getInt("GROUP_CODE"));
				group.setGroupName(rset.getString("GROUP_NAME"));
				group.setInterestCode(rset.getString("INTEREST_CODE"));
				group.setOpenYn(rset.getString("OPEN_YN"));
				group.setNickNameyn(rset.getString("NICKNAME_YN"));
				group.setRnCode(rset.getString("RN_CODE"));
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
				selectedGroup.setGroupCode(requestGroup.getGroupCode());
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


	public ArrayList<GroupMemberVO> selectList(Connection con, String groupCode) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<GroupMemberVO> list = new ArrayList<GroupMemberVO>();
		
		String query = prop.getProperty("groupMemberList");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, groupCode);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				GroupMemberVO groupMember = new GroupMemberVO();
				
				groupMember.setGroupCode(rset.getInt("GROUP_CODE"));
				groupMember.setMemberCode(rset.getInt("MEMBER_CODE"));
				groupMember.setGroupLeaderyn(rset.getString("GROUP_LEADERYN"));
				
				list.add(groupMember);
			}
			
			
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
				g.setGroupLeaderName(rset.getString("MEMBER_NAME"));
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


	public ArrayList<GroupVO> searchGroupList(Connection con, GroupVO group) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<GroupVO> searchedGroupList = new ArrayList<GroupVO>();
		
		String query = prop.getProperty("searchGroupList");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, group.getGroupName());
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
				g.setRegionName(rset.getString("REGION_NAME"));
				g.setInterest(rset.getString("INTEREST"));
				g.setGroupLeaderName(rset.getString("GROUP_LEADER_NAME"));
				g.setGroupLeaderCode(rset.getInt("GROUP_LEADER_CODE"));
				searchedGroupList.add(g);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return searchedGroupList;
	}


	public ArrayList<GroupVO> selectRecommendedGroupList(Connection con, MemberInterestVO memberInterestVO) {//
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<GroupVO> recommendedGroups = new ArrayList<GroupVO>();;
		String query = prop.getProperty("selectRecommendedGroup");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, memberInterestVO.getInterestCode());
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				GroupVO recommendedGroup = new GroupVO();
				recommendedGroup.setGroupCode(rset.getInt("GROUP_CODE"));
				recommendedGroup.setGroupName(rset.getString("GROUP_NAME"));
			
				recommendedGroup.setInterestCode(rset.getString("GROUP_INTEREST_CODE"));
				recommendedGroup.setOpenYn(rset.getString("OPEN_YN"));
				recommendedGroup.setNickNameyn(rset.getString("NICKNAME_YN"));
				recommendedGroup.setOpenDate(rset.getDate("OPEN_DATE"));
				recommendedGroup.setGroupRule(rset.getString("GROUP_RULE"));
				recommendedGroup.setDescription(rset.getString("DESCRIPTION"));
				recommendedGroup.setRegionName(rset.getString("REGION_NAME"));
				recommendedGroup.setInterest(rset.getString("INTEREST"));
				recommendedGroup.setGroupLeaderName(rset.getString("GROUP_LEADER_NAME"));
				recommendedGroup.setGroupLeaderCode(rset.getInt("GROUP_LEADER_CODE"));
				
				recommendedGroups.add(recommendedGroup);
				System.out.println("test: " + recommendedGroup);

			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return recommendedGroups;
	}

  	public ArrayList<MemberVO> groupMemberList(Connection con, PageInfo pi, int groupCode) {
		ArrayList<MemberVO> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("groupMemberList");
		
		try {
			pstmt = con.prepareStatement(query);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getLimit() + 1;
			int endRow = startRow + pi.getLimit() - 1;
			
/*			pstmt.setInt(1, groupCode);     추가해야합니다...
*/			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<MemberVO>();
			
			while(rset.next()) {
				MemberVO m = new MemberVO();
				m.setUserName(rset.getString("MEMBER_NAME"));
				m.setGroupLeaderyn(rset.getString("GROUP_LEADER_YN"));
				m.setEmail(rset.getString("EMAIL"));
				
				list.add(m);
			}
			
			rset = pstmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(con);
		}
		
		return list;
	}


	public int memberListCount(Connection con) {
		Statement stmt = null;
		int listCount = 0;
		ResultSet rset = null;
		
		String query = prop.getProperty("groupMemberCount");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rset);
		}

		return listCount;
    
  }

	public ArrayList<GroupVO> groupList(Connection con, PageInfo pi) {
		ArrayList<GroupVO> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("groupList");
		
		try {
			pstmt = con.prepareStatement(query);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getLimit() + 1;
			int endRow = startRow + pi.getLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<GroupVO>();
			
			while(rset.next()) {
				GroupVO g = new GroupVO();
				g.setGroupCode(rset.getInt("GROUP_CODE"));
				g.setGroupName(rset.getString("GROUP_NAME"));
				g.setMemberName(rset.getString("MEMBER_NAME"));
				g.setGroupLeaderCode(rset.getInt("GROUP_LEADER_CODE"));
				g.setOpenDate(rset.getDate("OPEN_DATE"));
				g.setInterest(rset.getString("INTEREST"));
				g.setMemberCount(rset.getInt("MEMBER_COUNT"));
				g.setPostCount(rset.getInt("POST"));

				list.add(g);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(con);
		}
		System.out.println(list);
		return list;
	}


	public int groupListCount(Connection con) {
		Statement stmt = null;
		int listCount = 0;
		ResultSet rset = null;

		String query = prop.getProperty("groupListCount");

		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);

			if (rset.next()) {
				listCount = rset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rset);
		}

		return listCount;
	}

	public String groupLeaderList(Connection con, GroupVO groupVO) {
		String name = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("groupLeader");
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, groupVO.getGroupLeaderCode());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				name = rset.getString("MEMBER_NAME");				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return name;
	}

	public AttachmentVo selectAttachment(Connection con, int groupCode) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		AttachmentVo thumbnail = null;
		
		String query = prop.getProperty("selectAttachment");
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, groupCode);
      
      rset = pstmt.executeQuery();
			
			if(rset.next()) {
        
      	thumbnail.setFid(rset.getString("FID"));
				thumbnail.setOriginName(rset.getString("ORIGIN_NAME"));
				thumbnail.setChangeName(rset.getString("CHANGE_NAME"));
				thumbnail.setFilePath(rset.getString("FILE_PATH"));				
        
			}			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return thumbnail;
	}
  
	public GroupVO selectGroupDetail(Connection con, int nno) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		GroupVO member = null;
		
		String query = prop.getProperty("selectGroupDetail");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, nno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				member = new GroupVO();
				
				member.setGroupName(rset.getString("GROUP_NAME"));
				member.setGroupLeaderCode(rset.getInt("GROUP_LEADER_CODE"));
				member.setInterest(rset.getString("INTEREST"));
				member.setMemberName(rset.getString("MEMBER_NAME"));
				member.setEmail(rset.getString("EMAIL"));
				member.setPhone(rset.getString("PHONE"));
				member.setOpenDate(rset.getDate("OPEN_DATE"));
			}
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		System.out.println("테스트" + member);
		return member;
	}


	public GroupVO selecGroupD(Connection con, int nno) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		GroupVO groupG = null;
		
		String query = prop.getProperty("selectGroupDetailG");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, nno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				groupG = new GroupVO();
				groupG.setPostCount(rset.getInt("POST_COUNT"));
			}
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		System.out.println("테스트2"+groupG);
		return groupG;
	}


	public int updateGroup(Connection con, GroupVO group) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateGroup");
		
		try {
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, group.getRnCode());
			pstmt.setString(2, group.getInterestCode());
			pstmt.setString(3, group.getNickNameyn());
			pstmt.setString(4, group.getGroupRule());
			pstmt.setString(5, group.getDescription());
			pstmt.setInt(6, group.getGroupCode());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}


	public int joinGroup(Connection con, int groupCode, int memberCode) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("joinGroup");
		
		try {			
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, memberCode);
			pstmt.setInt(2, groupCode);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
				
		return result;
	}
}