package com.kh.groumoa.member.model.service;

import static com.kh.groumoa.common.JDBCTemplate.close;
import static com.kh.groumoa.common.JDBCTemplate.commit;
import static com.kh.groumoa.common.JDBCTemplate.getConnection;
import static com.kh.groumoa.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.groumoa.common.PageInfo;
import com.kh.groumoa.group.model.dao.BoardDao;
import com.kh.groumoa.group.model.vo.BoardVO;
import com.kh.groumoa.group.model.vo.GroupVO;
import com.kh.groumoa.member.model.dao.MemberDao;
import com.kh.groumoa.member.model.vo.MemberInterestVO;
import com.kh.groumoa.member.model.vo.MemberVO;

public class MemberService {

	public MemberVO loginCheck(MemberVO requestMember) {
		Connection con = getConnection();

		MemberVO loginUser = new MemberDao().loginCheck(con, requestMember);

		close(con);

		return loginUser;

	}

	public int insertMember(MemberVO requestMember, ArrayList<MemberInterestVO> requestMemberInterest) {
		Connection con = getConnection();
		int result = 0;
		int[] resultArr = new int[requestMemberInterest.size()];

		MemberVO responseMember = new MemberDao().insertMember(con, requestMember);

		for (int i = 0; i < requestMemberInterest.size(); i++) {
			MemberInterestVO requestMemberInterestEach = requestMemberInterest.get(i);

			int resultEach = new MemberDao().insertMemberInterest(con, responseMember, requestMemberInterestEach);

			resultArr[i] = resultEach;
		}

		for (int i = 0; i < resultArr.length; i++) {
			if (resultArr[i] == 0) {
				result = 0;
				break;
			}
			result = 1;
		}

		if (responseMember != null && result != 0) {
			commit(con);
		} else {
			rollback(con);
		}

		close(con);

		return result;
	}

	public ArrayList<MemberVO> selectLeader(PageInfo pi) {
		Connection con = getConnection();

		ArrayList<MemberVO> list = new MemberDao().selectLeader(con, pi);

		close(con);

		return list;
	}

	public int idCheck(String email) {
		Connection con = getConnection();

		int result = new MemberDao().idCheck(con, email);

		close(con);

		return result;
	}

	public MemberVO selectMember(int nno) {
		Connection con = getConnection();
		MemberVO member = null;
		
		member = new MemberDao().selectMember(con, nno);

		close(con);
		
		return member;
	}

	public int getListCount() {
		Connection con = getConnection();
		int listCount = new MemberDao().getListCount(con);

		close(con);

		return listCount;
	}


	public ArrayList<MemberVO> selectList(PageInfo pi) {
		Connection con = getConnection();

		ArrayList<MemberVO> list = new MemberDao().selectList(con, pi);

		close(con);

		return list;
	}

	public int getLeaderCount() {
		Connection con = getConnection();
		int listCount = new MemberDao().getLeaderCount(con);

		close(con);

		return listCount;
	}

	public int getMemberCode(String email) {
		Connection con = getConnection();

		int result = new MemberDao().getMemberCode(con, email);

		close(con);

		return result;
	}

	public int getGroupLeaderCount() {
		Connection con = getConnection();
		int result = new MemberDao().getGroupLeaderCount(con);
		
		close(con);
		
		return result;
	}

	public ArrayList<MemberVO> selectGroupLeaderList(PageInfo pi) {
		Connection con = getConnection();
		
		ArrayList<MemberVO> list = new MemberDao().selectGroupLeaderList(con,pi);
		
		close(con);
		
		return list;
	}

	public int getGroupMemberCount() {
		Connection con = getConnection();
		int result = new MemberDao().selectGroupMemberList(con);
		
		close(con);
		
		return result;
	}

	public ArrayList<MemberVO> selectGroupMemberList(PageInfo pi) {
		Connection con = getConnection();
		ArrayList<MemberVO> list = new MemberDao().selectGroupMemberList(con, pi);
		
		close(con);
		
		return list;
	}
}
