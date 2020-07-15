package com.kh.groumoa.member.model.service;


import static com.kh.groumoa.common.JDBCTemplate.getConnection;
import static com.kh.groumoa.common.JDBCTemplate.close;
import static com.kh.groumoa.common.JDBCTemplate.commit;
import static com.kh.groumoa.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

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
		
		int result1 = new MemberDao().insertMember(con, requestMember);
		
		MemberVO loginUser = new MemberDao().loginCheck(con, requestMember);
		
		int result2 = new MemberDao().insertMemberInterest(con, requestMemberInterest);
		
//		
//		if(result > 0) {
//			if(true) { //
//				commit(con);
//			} else {
//				rollback(con);
//			}
//		} else {
//			rollback(con);
//		}
		
		close(con);
		
		return result1;
	}

}
