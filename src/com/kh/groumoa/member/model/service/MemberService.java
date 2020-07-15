package com.kh.groumoa.member.model.service;


import static com.kh.groumoa.common.JDBCTemplate.getConnection;
import static com.kh.groumoa.common.JDBCTemplate.close;
import static com.kh.groumoa.common.JDBCTemplate.commit;
import static com.kh.groumoa.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.kh.groumoa.member.model.dao.MemberDao;
import com.kh.groumoa.member.model.vo.MemberVO;


public class MemberService {

	public MemberVO loginCheck(MemberVO requestMember) {
		Connection con = getConnection();
		
		MemberVO loginUser = new MemberDao().loginCheck(con, requestMember);
		
		close(con);
		
		return loginUser;
		
	}

	public int insertMember(MemberVO requestMember) {
		Connection con = getConnection();
		
		int result = new MemberDao().insertMember(con, requestMember);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

}
