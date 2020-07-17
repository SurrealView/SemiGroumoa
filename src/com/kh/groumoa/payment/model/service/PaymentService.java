package com.kh.groumoa.payment.model.service;

import static com.kh.groumoa.common.CustomUtil.inst;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kh.groumoa.common.PageInfo;
import com.kh.groumoa.payment.model.dao.PaymentDao;
import com.kh.groumoa.payment.model.vo.PaymentHistoryVo;

public class PaymentService {

	public int getListCount() {
		int result = 0;
		
		Connection con = inst().getCon("url", "user", "password", "driver");
		
		PaymentDao pd = new PaymentDao();
		
		result = pd.getListCount();
		
		return result;
	}

	public ArrayList<PaymentHistoryVo> selectList(PageInfo pi) {
		ArrayList<PaymentHistoryVo> list = null;
		Connection con = inst().getCon("url", "user", "password", "driver");
		
		PaymentDao pd = new PaymentDao();
		list = pd.selectList(pi);
		
		inst().closeCon();
		
		return null;
	}
	
//	public int getListCount(Connection con) {		
//		Statement stmt = null;
//		int listCount = 0;		
//		ResultSet rset = null;
//		
//		String query = prop.getProperty("listCount");
//		
//		try {
//			stmt = con.createStatement();
//			
//			rset = stmt.executeQuery(query);			
//			
//			if(rset.next()) {
//				System.out.println("listCOunt 불러오는중..");
//				listCount = rset.getInt(1);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			close(rset);
//			close(stmt);
//		}
//			
//		return listCount;
//	}
	
}
