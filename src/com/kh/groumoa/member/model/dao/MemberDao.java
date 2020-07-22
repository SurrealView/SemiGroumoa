package com.kh.groumoa.member.model.dao;

import static com.kh.groumoa.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.groumoa.common.PageInfo;
import com.kh.groumoa.member.model.vo.MemberInterestVO;
import com.kh.groumoa.member.model.vo.MemberVO;


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
				loginUser.setUserPwd(rset.getString("MEMBER_PWD"));
				loginUser.setUserName(rset.getString("MEMBER_NAME"));
				loginUser.setGender(rset.getString("GENDER"));
				loginUser.setRnCode(rset.getString("RN_CODE"));
				loginUser.setAddress(rset.getString("ADDRESS"));
				loginUser.setPhone(rset.getString("PHONE"));
				loginUser.setEnrollDate(rset.getDate("ENROLL_DATE"));
				loginUser.setStatus(rset.getString("STATUS"));
				
				java.sql.Date birthDate = rset.getDate("BIRTH_DATE");
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
				String birthDateString = sdf.format(birthDate);
				
				loginUser.setBirthDate(birthDateString);
				//System.out.println(birthDateString);
				//loginUser.setBirthDate(rset.getDate("BIRTH_DATE"));
				System.out.println(loginUser);
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

	public MemberVO insertMember(Connection con, MemberVO requestMember) {
		PreparedStatement pstmt = null;
		MemberVO responseMember = null;
		int result = 0;
		
		String query = prop.getProperty("insertMember");
			
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, requestMember.getEmail());
			pstmt.setString(2, requestMember.getUserPwd());
			pstmt.setString(3, requestMember.getUserName());
			pstmt.setString(4, requestMember.getGender());
			pstmt.setString(5, requestMember.getRnCode());
			pstmt.setString(6, requestMember.getAddress());
			pstmt.setString(7, requestMember.getPhone());
			pstmt.setString(8, requestMember.getBirthDate());

			result = pstmt.executeUpdate();
			
			if(result > 0) {
				responseMember = loginCheck(con, requestMember);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		System.out.println(responseMember);
		
		return responseMember;
		
	}
	
	public int insertMemberInterest(Connection con, MemberVO requestMember, MemberInterestVO requestMemberInterest) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertMemberInterest");
		
		try {
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, requestMember.getMemberCode());
			pstmt.setString(2, requestMemberInterest.getInterestCode());
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}
	
	public int idCheck(Connection con, String email) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("idCheck");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, email);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
		}
		return result;
	}
	
	public int getListCount(Connection con) {
		Statement stmt = null;
		int listCount = 0;
		ResultSet rset = null;
		
		String query = prop.getProperty("listCount");
		
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

	public ArrayList<MemberVO> selectList(Connection con, PageInfo pi) {
		ArrayList<MemberVO> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectList");
		
		try {
			pstmt = con.prepareStatement(query);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getLimit() + 1;
			int endRow = startRow + pi.getLimit() - 1;
			
			System.out.println("start" + startRow);
			System.out.println("end" + endRow);
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<MemberVO>();
			
			while(rset.next()) {
				MemberVO m = new MemberVO();
				m.setMemberCode(rset.getInt("MEMBER_CODE"));
				m.setEmail(rset.getString("EMAIL"));
				m.setUserName(rset.getString("MEMBER_NAME"));
				m.setEnrollDate(rset.getDate("ENROLL_DATE"));
				m.setGroupLeaderyn(rset.getString("GROUP_LEADER_YN"));
				m.setPostCode(rset.getInt("POST"));
				System.out.println(m);
				list.add(m);				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		System.out.println(list);
		return list;
	}

	public ArrayList<MemberVO> selectLeader(Connection con, PageInfo pi) {
		ArrayList<MemberVO> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectLeader");
		
		try {
			pstmt = con.prepareStatement(query);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getLimit() + 1;
			int endRow = startRow + pi.getLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<MemberVO>();
			
			while(rset.next()) {
				MemberVO m = new MemberVO();
				m.setMemberCode(rset.getInt("MEMBER_CODE"));
				m.setEmail(rset.getString("EMAIL"));
				m.setUserName(rset.getString("MEMBER_NAME"));
				m.setEnrollDate(rset.getDate("ENROLL_DATE"));
				m.setGroupLeaderyn(rset.getString("GROUP_LEADER_YN"));
				
				list.add(m);				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		System.out.println(list);
		return list;
	}

	public int getLeaderCount(Connection con) {
		Statement stmt = null;
		int listCount = 0;
		ResultSet rset = null;
		
		String query = prop.getProperty("leaderCount");
		
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

	public MemberVO selectMember(Connection con, int num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		MemberVO member = null;
		
		String query = prop.getProperty("selectMember");
		
		try {
			pstmt = con.prepareStatement(query);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		
		
		return null;
	}

}
