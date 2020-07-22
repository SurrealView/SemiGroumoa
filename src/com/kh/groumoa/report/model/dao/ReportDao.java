package com.kh.groumoa.report.model.dao;

import static com.kh.groumoa.common.CustomUtil.inst;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.kh.groumoa.common.model.vo.AttachmentVo;
import com.kh.groumoa.report.model.vo.ReportVo;

public class ReportDao {

	public int insertReport(ReportVo re) {
		inst().setProp("/sql/notice/notice.properties");
		PreparedStatement pstmt = null;
		int result = 0;
		
		pstmt = inst().getPstmt("insertReport");
		
		try {
			//insertReport=INSERT INTO TB_REPORT VALUES(('RE' || TO_CHAR(SEQ_REP.NEXTVAL, 'FM999999999')), ?, ?, ?, SYSDATE, ?, ?, 'N')			
			pstmt.setInt(1, re.getReporter());
			pstmt.setInt(2, re.getReported());
			pstmt.setString(3, re.getReportCategory());
			pstmt.setString(4, re.getReportTitle());
			pstmt.setString(5, re.getReportDetail());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			inst().closePstmt();
		}
				
		
		return result;
	}

	public String getResultId() {
		Statement stmt = null;
		ResultSet rset = null;
		inst().setProp("/sql/notice/notice.properties");
		
		stmt = inst().getStmt();
		
		rset = inst().getResultSet("selectCurrval");
				
		String reId = "";
		try {
			reId = "RE" + rset.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			inst().closeRset();
			inst().closeStmt();
		}
		
		return reId;
	}

	public int insertAttach(AttachmentVo attachmentVo) {
		PreparedStatement pstmt = null;		
		int result = 0;
		inst().setProp("/sql/notice/notice.properties");
		pstmt = inst().getPstmt("insertAttachment");
		
		try {
			pstmt.setString(1, attachmentVo.getOriginName());
			pstmt.setString(2, attachmentVo.getChangeName());
			pstmt.setString(3, attachmentVo.getFilePath());
			pstmt.setInt(4, attachmentVo.getFileLevel());
			pstmt.setString(5, attachmentVo.getReportCode());
			
			result = inst().getResult();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			inst().closePstmt();
		}
		
		
		return result;
	}

}
