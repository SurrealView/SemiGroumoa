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
		int result = 0;
		
		MemberVO responseMember = new MemberDao().insertMember(con, requestMember);
		
		int[] resultArr = new MemberDao().insertMemberInterest(con, responseMember, requestMemberInterest);
		
		for(int i = 0; i < resultArr.length; i++) {
			if(resultArr[i] == 0) {
				result = 0; 
				break;
			} 
			result = 1;
		}
		
		if(responseMember != null && result != 0) {
			commit(con);
			result = 1;
		} else {
			rollback(con);
			result = 0;
		}
		
		
		close(con);
		
		return result;
	}

}
