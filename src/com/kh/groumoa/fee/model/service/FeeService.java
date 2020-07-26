package com.kh.groumoa.fee.model.service;

import static com.kh.groumoa.common.JDBCTemplate.close;
import static com.kh.groumoa.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.groumoa.common.PageInfo;
import com.kh.groumoa.fee.model.dao.FeeDao;
import com.kh.groumoa.fee.model.vo.FeeVO;

public class FeeService {

	public int getListCount(FeeVO fee) {
		Connection con = getConnection();
		int listCount = new FeeDao().getListCount(con, fee);
		
		close(con);

		return listCount;
	}

	public ArrayList<FeeVO> selectList(PageInfo pi, FeeVO fee) {
		Connection con = getConnection();
		
		ArrayList<FeeVO> list = new FeeDao().selectList(con, pi, fee);
		
		close(con);
		
		return list;
	}

}
