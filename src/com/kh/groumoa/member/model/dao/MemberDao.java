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
import com.kh.groumoa.member.model.vo.ManagerVO;
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

			if (rset.next()) {
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
				// System.out.println(birthDateString);
				// loginUser.setBirthDate(rset.getDate("BIRTH_DATE"));
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

			if (result > 0) {
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

	public ArrayList<MemberInterestVO> selectMemberInterests(Connection con, MemberVO loginUser) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<MemberInterestVO> loginUserInterests = new ArrayList<MemberInterestVO>();

		String query = prop.getProperty("selectMemberInterests");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, loginUser.getMemberCode());
			rset = pstmt.executeQuery();

			while (rset.next()) {
				MemberInterestVO mi = new MemberInterestVO();

				mi.setMemberCode(rset.getInt("MEMBER_CODE"));
				mi.setInterestCode(rset.getString("INTEREST_CODE"));

				loginUserInterests.add(mi);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return loginUserInterests;
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

			if (rset.next()) {
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

	public ArrayList<MemberVO> selectList(Connection con, PageInfo pi) {
		ArrayList<MemberVO> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectList");
		
		try {
			pstmt = con.prepareStatement(query);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getLimit() + 1;
			int endRow = startRow + pi.getLimit() -1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<MemberVO>();
			
			if(rset.next()) {
				MemberVO m = new MemberVO();
				m.setMemberCode(rset.getInt("MEMBER_CODE"));
				m.setEmail(rset.getString("EMAIL"));
				m.setUserName(rset.getString("MEMBER_NAME"));
				m.setEnrollDate(rset.getDate("ENROLL_DATE"));
				m.setPostCode(rset.getInt("POST"));
				
				list.add(m);
			}
			System.out.println("dao list"+list);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(con);
		}
		return list;	
	}

	public ArrayList<ManagerVO> selectLeader(Connection con, PageInfo pi) {
		ArrayList<ManagerVO> list = null;
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

			list = new ArrayList<ManagerVO>();

			while (rset.next()) {
				ManagerVO m = new ManagerVO();
				m.setManagerCode(rset.getString("MANAGER_CODE"));
				m.setManagerName(rset.getString("MANAGER_NAME"));
				m.setManagerId(rset.getString("MANAGER_ID"));
				m.setManagerPwd(rset.getString("MANAGER_PWD"));
				m.setNoticeCode(rset.getString("NOTICE_CODE"));
				
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

	public MemberVO selectMember(Connection con, int nno) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		MemberVO member = null;
		
		String query = prop.getProperty("selectMember");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, nno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				member = new MemberVO();
				
				member.setPostCode(rset.getInt("POST"));
				member.setPenaltyCode(rset.getInt("PENALTY"));
				member.setEnrollDate(rset.getDate("ENROLL_DATE"));
				member.setUserName(rset.getString("MEMBER_NAME"));
				member.setEmail(rset.getString("EMAIL"));
				member.setGroupName(rset.getString("GROUP_NAME"));
				member.setUserPwd(rset.getString("MEMBER_PWD"));
				member.setQuestion(rset.getInt("QUESTION"));
				member.setReply(rset.getInt("REPLY"));
			}
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return member;
	}

	public int getMemberCode(Connection con, String email) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("selectMemberCode");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, email);

			rset = pstmt.executeQuery();

			if (rset.next()) {
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


	public MemberVO searchId(Connection con, MemberVO requestMember) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		MemberVO responseMember = new MemberVO();
		
		String query = prop.getProperty("searchId");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, requestMember.getUserName());
			pstmt.setString(2, requestMember.getPhone());
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				responseMember.setEmail(rset.getString("EMAIL"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
				
		return responseMember;
	}
	
	public MemberVO searchPwd(Connection con, MemberVO requestMember) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		MemberVO responseMember = null;
		
		String query = prop.getProperty("searchPwd");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, requestMember.getEmail());
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				responseMember = new MemberVO();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
      			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return responseMember;
	}

	public int updateMemberPwd(Connection con, String email, String newPwd) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateMemberPwd");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, newPwd);
			pstmt.setString(2, email);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
  }

	public int getGroupLeaderCount(Connection con) {
		Statement stmt = null;
		int listCount = 0;
		ResultSet rset = null;

		String query = prop.getProperty("listGroupLeaderCount");

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

	public ArrayList<MemberVO> selectGroupLeaderList(Connection con, PageInfo pi) {
		ArrayList<MemberVO> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("selectGroupLeader");

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

			while (rset.next()) {
				MemberVO m = new MemberVO();
				m.setGroupLeaderCode(rset.getInt("GROUP_LEADER_CODE"));
				m.setEmail(rset.getString("EMAIL"));
				m.setUserName(rset.getString("MEMBER_NAME"));
				m.setEnrollDate(rset.getDate("ENROLL_DATE"));
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

	public int selectGroupMemberList(Connection con) {
		Statement stmt = null;
		int listCount = 0;
		ResultSet rset = null;

		String query = prop.getProperty("listGroupMemberCount");

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

	public ArrayList<MemberVO> selectGroupMemberList(Connection con, PageInfo pi) {
		ArrayList<MemberVO> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("selectGroupMemberList");

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

			while (rset.next()) {
				MemberVO m = new MemberVO();
				m.setGroupCode(rset.getInt("GROUP_CODE"));
				m.setMemberCode(rset.getInt("MEMBER_CODE"));
				m.setEmail(rset.getString("EMAIL"));
				m.setUserName(rset.getString("MEMBER_NAME"));
				m.setEnrollDate(rset.getDate("ENROLL_DATE"));
				m.setPostCode(rset.getInt("POST"));
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

	public MemberVO selectMemberG(Connection con, int nno) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		MemberVO memberG = null;
		
		String query = prop.getProperty("selectMemberG");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, nno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				memberG = new MemberVO();
				
				memberG.setGroupName(rset.getString("GROUP_NAME"));
				memberG.setGroupLeaderCode(rset.getInt("GROUP_LEADER_CODE"));
			}
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return memberG;
	}

	public ArrayList<MemberVO> selectGroupMemberList(PageInfo pi, Connection con, int memberCode, int groupCode) {
		ArrayList<MemberVO> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectGroupMemberList");
		
		try {
			pstmt = con.prepareStatement(query);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getLimit() + 1;
			int endRow = startRow + pi.getLimit() - 1;

			System.out.println("start" + startRow);
			System.out.println("end" + endRow);
						
			pstmt.setInt(1, memberCode);
			pstmt.setInt(2, groupCode);
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<MemberVO>();

			while (rset.next()) {
				MemberVO m = new MemberVO();
				m.setGroupLeaderCode(rset.getInt("GROUP_LEADER_CODE"));
				m.setEmail(rset.getString("EMAIL"));
				m.setUserName(rset.getString("MEMBER_NAME"));
				System.out.println(m);
				list.add(m);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return list;
	}
	
	//동호회 회원 추방
		public int kickOut(Connection con, int memberCode, int groupCode) {
			PreparedStatement pstmt = null;
			int result = 0;
				
			String query = prop.getProperty("kickOut");
				
			try {
				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, memberCode);
				pstmt.setInt(2, groupCode);
					
				result = pstmt.executeUpdate();
					
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
				
			return result;
		}

		public ArrayList<MemberVO> selectGroupMemberListMain(PageInfo pi, Connection con, int groupCode) {
			ArrayList<MemberVO> list = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String query = prop.getProperty("selectGroupMemberListMain");
			
			try {
				pstmt = con.prepareStatement(query);
				
				int startRow = (pi.getCurrentPage() - 1) * pi.getLimit() + 1;
				int endRow = startRow + pi.getLimit() - 1;

				System.out.println("start" + startRow);
				System.out.println("end" + endRow);
							
				pstmt.setInt(1, groupCode);
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
				
				rset = pstmt.executeQuery();
				
				list = new ArrayList<MemberVO>();

				while (rset.next()) {
					MemberVO m = new MemberVO();
					m.setMemberCode(rset.getInt("MEMBER_CODE"));
					m.setEmail(rset.getString("EMAIL"));
					m.setUserName(rset.getString("MEMBER_NAME"));
					m.setEnrollDate(rset.getDate("ENROLL_DATE"));
					m.setGroupLeaderCode(rset.getInt("GROUP_LEADER_CODE"));
					m.setPostCode(rset.getInt("POST"));
					System.out.println(m);
					list.add(m);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			
			
			return list;
		}

		public ManagerVO selectLeaderDetail(Connection con) {
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			ManagerVO list = null;
			
			String query = prop.getProperty("selectLeaderDetail");

			try {
				pstmt = con.prepareStatement(query);
				
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					list = new ManagerVO();
					list.setManagerName(rset.getString("MANAGER_NAME"));
					list.setManagerId(rset.getString("MANAGER_ID"));
					list.setManagerPwd(rset.getString("MANAGER_PWD"));
				}
				
			
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
				close(rset);
			}
			
			return list;
		}

		public ManagerVO selectLeaderDetailD(Connection con, int nno) {
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			ManagerVO list = null;
			
			String query = prop.getProperty("selectLeaderDetailD");

			try {
				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, nno);
				
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					list = new ManagerVO();
					list.setNoticeCode(rset.getString("NOTICE"));
				}
				
			
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
				close(rset);
			}
			
			return list;
		}

}
