package com.kh.groumoa.inquire.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.groumoa.group.model.dao.BoardDao;
import com.kh.groumoa.group.model.vo.BoardVO;
import com.kh.groumoa.inquire.model.dao.InquireDao;
import com.kh.groumoa.inquire.model.vo.InquireVO;
import com.kh.groumoa.member.model.vo.MemberVO;

import static com.kh.groumoa.common.JDBCTemplate.*;


public class InquireService {

	public int insertInquire(InquireVO requestInquire) {
		Connection con = getConnection();
		
		int result = 0;
		
		result = new InquireDao().insertInquire(con, requestInquire);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		return result;
		
	}

	public ArrayList<InquireVO> selectInquireList(MemberVO loginUser) {
		Connection con = getConnection();
		
		ArrayList<InquireVO> list = new InquireDao().selectList(con, pi, inquire);
		
		close(con);
		
		return list;
	}
	

}
