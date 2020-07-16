package com.kh.groumoa.payment.model.dao;

import static com.kh.groumoa.common.CustomUtil.inst;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kh.groumoa.common.PageInfo;
import com.kh.groumoa.payment.model.vo.PaymentHistoryVo;

public class PaymentDao {

	public int getListCount() {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		inst().setProp("/sql/notice/notice.properties");
		
		stmt = inst().getStmt();
		
		String query = inst().getPropVal("listCount");
		
		rset = inst().getResultSet(query);		
		
		try {
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			inst().closeRset();
			inst().closeStmt();
		}
		
		return listCount;
	}

	public ArrayList<PaymentHistoryVo> selectList(PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<PaymentHistoryVo> list = null;
		
		pstmt = inst().getPstmt("selectList");

		int startRow = (pi.getCurrentPage() - 1) * pi.getLimit() + 1;
		int endRow = startRow + pi.getLimit() - 1;
		
		try {
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = inst().getResultSet();
			
			list = new ArrayList<PaymentHistoryVo>();
			
			while(rset.next()) {
				PaymentHistoryVo ph = new PaymentHistoryVo();
				
				/*NOTICE_CODE	VARCHAR2(5 BYTE)
				NOTICE_CATEGORY	VARCHAR2(15 BYTE)
				NOTICE_TITLE	VARCHAR2(60 BYTE)
				NOTICE_DETAIL	VARCHAR2(3000 BYTE)
				NOTICE_DATE	DATE
				MN_WRITER_CODE	VARCHAR2(5 BYTE)
				NOTICE_STATUS	CHAR(1 BYTE)*/
				
				ph.setPbCode(rset.getString(""));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	
	
	/*PreparedStatement pstmt = null;
	ResultSet rset = null;
	ArrayList<Board> list = null;
	
	//아까작성햇던 쿠
	String query = prop.getProperty("selectList");
	
	try {
		pstmt = con.prepareStatement(query);
		
		//int startRow = (currentPage - 1) * limit + 1
		int startRow = (pi.getCurrentPage() - 1) * pi.getLimit() + 1;
		int endRow = startRow + pi.getLimit() - 1;
		
		pstmt.setInt(1, startRow);
		pstmt.setInt(2, endRow);
		
		rset = pstmt.executeQuery();
		
		list = new ArrayList<>();
		
		while(rset.next()) {
			Board b = new Board();
			
			b.setBid(rset.getInt("BID"));
			b.setbType(rset.getInt("BTYPE"));
			b.setBno(rset.getInt("BNO"));
			b.setcName(rset.getString("CNAME"));
			b.setbTitle(rset.getString("BTITLE"));
			b.setbContent(rset.getString("BCONTENT"));
			b.setNickName(rset.getString("NICK_NAME"));
			b.setbCount(rset.getInt("BCOUNT"));
			b.setRefBid(rset.getInt("REF_BID"));
			b.setReplyLevel(rset.getInt("REPLY_LEVEL"));
			b.setbDate(rset.getDate("BDATE"));
			b.setStatus(rset.getString("STATUS"));
			
			list.add(b);
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		close(rset);
		close(pstmt);
	}
	
	return list;*/

}
