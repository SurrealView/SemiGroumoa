package com.kh.groumoa.inquire.model.service;

import java.sql.Connection;

import com.kh.groumoa.inquire.model.dao.InquireDao;
import com.kh.groumoa.inquire.model.vo.InquireVO;
import static com.kh.groumoa.common.JDBCTemplate.*;


public class InquireService {

	public int insertInquire(InquireVO requestInquire) {
		Connection con = getConnection();
		
		int result = 0;
		
		int insertInquire = new InquireDao().insertInquire(con, requestInquire);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		return result;
		
	}
	

}
