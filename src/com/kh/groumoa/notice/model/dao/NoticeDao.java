package com.kh.groumoa.notice.model.dao;

import static com.kh.groumoa.common.CustomUtil.inst;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kh.groumoa.common.PageInfo;
import com.kh.groumoa.notice.model.vo.NoticeVo;

public class NoticeDao {

	public int getListCount() {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		inst().setProp("/sql/notice/notice.properties");
		
		stmt = inst().getStmt();
		
		//String query = inst().getPropVal("listCount");
		
		rset = inst().getResultSet("listCount");		
		
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

	public ArrayList<NoticeVo> selectList(PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<NoticeVo> list = null;
		
		pstmt = inst().getPstmt("selectList");

		int startRow = (pi.getCurrentPage() - 1) * pi.getLimit() + 1;
		int endRow = startRow + pi.getLimit() - 1;
		
		try {
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = inst().getResultSet();
			
			list = new ArrayList<NoticeVo>();
			
			while(rset.next()) {
				NoticeVo n = new NoticeVo();
				
				/*NOTICE_CODE	VARCHAR2(5 BYTE)
				NOTICE_CATEGORY	VARCHAR2(15 BYTE)
				NOTICE_TITLE	VARCHAR2(60 BYTE)
				NOTICE_DETAIL	VARCHAR2(3000 BYTE)
				NOTICE_DATE	DATE
				MN_WRITER_CODE	VARCHAR2(5 BYTE)
				NOTICE_STATUS	CHAR(1 BYTE)*/
				//RNUM, NOTICE_CODE, NOTICE_CATEGORY, NOTICE_TITLE, NOTICE_DETAIL, NOTICE_DATE, MANAGER_ID, NOTICE_STATUS
				n.setnNo(rset.getInt("RNUM"));
				n.setNoticeCode(rset.getString("NOTICE_CODE"));
				n.setNoticeCategory(rset.getString("NOTICE_CATEGORY"));
				n.setNoticeTitle(rset.getString("NOTICE_TITLE"));
				n.setNoticeTitle(rset.getString("NOTICE_DETAIL"));
				n.setNoticeDate(rset.getDate("NOTICE_DATE"));
				n.setMnWriterCode(rset.getString("MN_WRITER_CODE"));
				n.setMnWriterID(rset.getString("MANAGER_ID"));
				n.setNoticeStatus(rset.getString("NOTICE_STATUS"));
				
				list.add(n);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			inst().closeRset();
			inst().closePstmt();
		}
		
		return list;
	}

}
