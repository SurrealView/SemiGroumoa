package com.kh.groumoa.inquire.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.groumoa.common.PageInfo;

import com.kh.groumoa.inquire.model.dao.InquireDao;
import com.kh.groumoa.inquire.model.vo.InquireVO;
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
	public int getListCount() {
		Connection con = getConnection();
		
		int listCount = new InquireDao().getListCount(con);
		
		close(con);

		return listCount;
	}


	public ArrayList<InquireVO> selectInquireList(PageInfo pi) {
Connection con = getConnection();
		
		ArrayList<InquireVO> list = new InquireDao().selectList(con, pi);
		
		close(con);
		
		return list;
	}
	public ArrayList<InquireVO> selectInquire() {
		Connection con = getConnection();
		
		ArrayList<InquireVO> selectQna = new InquireDao().selectQna(con);
		
		close(con);
		
		return selectQna;
	}


}
