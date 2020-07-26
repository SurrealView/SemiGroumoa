package com.kh.groumoa.report.model.dao;

import static com.kh.groumoa.common.CustomUtil.inst;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.kh.groumoa.common.PageInfo;
import com.kh.groumoa.common.model.vo.AttachmentVo;
import com.kh.groumoa.notice.model.vo.NoticeVo;
import com.kh.groumoa.report.model.vo.ReportVo;

public class ReportDao {

	public int insertReport(ReportVo re) {
		inst().setProp("/sql/report/report.properties");
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
		inst().setProp("/sql/report/report.properties");
		
		stmt = inst().getStmt();
		
		rset = inst().getResultSet("selectCurrval");
				
		String reId = "";
		try {
			if(rset.next()) {
				reId = "RE" + rset.getInt(1);
			}
			
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
		inst().setProp("/sql/report/report.properties");
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

	public int getCount() {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		inst().setProp("/sql/report/report.properties");
		
		stmt = inst().getStmt();
		
		
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

	public ArrayList<ReportVo> selectList(PageInfo pi) {
		PreparedStatement pstmt = null;		
		ResultSet rset = null;
		ArrayList<ReportVo> reList = null;
		
		inst().setProp("/sql/report/report.properties");
		pstmt = inst().getPstmt("selectList");
		
		int startRow = (pi.getCurrentPage() - 1) * pi.getLimit() + 1;
		int endRow = startRow + pi.getLimit() - 1;
		
		try {
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();
			
			reList = new ArrayList<ReportVo>();
			
			while(rset.next()) {
				ReportVo re = new ReportVo();
				re.setReportCode(rset.getString("REPORT_CODE"));
				re.setRno(re.getReportCode());				
				re.setReporter(rset.getInt("REPORTER"));
				re.setReported(rset.getInt("REPORTED"));
				re.setReporterID(rset.getString("EMAIL1"));
				re.setReportedID(rset.getString("EMAIL2"));
				re.setReportCategory(rset.getString("REPORT_CATEGORY"));
				re.setReportDate(rset.getDate("REPORT_DATE"));
				re.setReportTitle(rset.getString("REPORT_TITLE"));
				re.setReportDetail(rset.getString("REPORT_DETAIL"));
				re.setIsDealt(rset.getString("ISDEALT"));
				
				reList.add(re);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			inst().closeRset();
			inst().closePstmt();
		}
		
		return reList;
	}

	public HashMap<String, Object> selectFileMap(String reId) {
		PreparedStatement pstmt = null;		
		ResultSet rset = null;
		HashMap<String, Object> hmap = null;		
		inst().setProp("/sql/report/report.properties");
		pstmt = inst().getPstmt("selectFileOne");		
		ArrayList<AttachmentVo> list = null;
		ReportVo re = null;
		
		
		try {
			pstmt.setString(1, reId);
			
			rset = inst().getResultSet();
			
			while(rset.next()) {
				if(re == null) {
					//신고자코드, 피신고자코드
					//신고자, 피신고자 ID
					//게시물 코드, 게시물번호
					//게시물 작성일자, 컨텐츠 내용
					//제목, 카테고리										
					
				}
				
				AttachmentVo na = new AttachmentVo();

				na.setFid(rset.getString("FID"));
				na.setOriginName(rset.getString("ORIGIN_NAME"));
				na.setChangeName(rset.getString("CHANGE_NAME"));
				na.setFilePath(rset.getString("FILE_PATH"));
				na.setUploadDate(rset.getDate("UPLOAD_DATE"));
				na.setFileLevel(rset.getInt("FILE_LEVEL"));
				na.setReportCode(reId);				
				
				list.add(na);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public ReportVo selectOneReport(String reId) {
		PreparedStatement pstmt = null;		
		ResultSet rset = null;
		inst().setProp("/sql/report/report.properties");
		pstmt = inst().getPstmt("selectReportOne");		
		ReportVo re = null;
		
		try {
			pstmt.setString(1, reId);
			
			rset = inst().getResultSet();
			
			if(rset.next()) {
				re = new ReportVo();
				
				re.setRno(reId);
				re.setReportCode(reId);
				re.setReporter(rset.getInt("REPORTER"));
				re.setReported(rset.getInt("REPORTED"));
				re.setReportCategory(rset.getString("REPORT_CATEGORY"));
				re.setReportDate(rset.getDate("REPORT_DATE"));
				re.setReportTitle(rset.getString("REPORT_TITLE"));
				re.setReportDetail(rset.getString("REPORT_DETAIL"));
				re.setReporterID(rset.getString("EMAIL1"));
				re.setReportedID(rset.getString("EMAIL2"));
				
				/*REPORT_CODE	VARCHAR2(10 BYTE)
				REPORTER	NUMBER
				REPORTED	NUMBER
				REPORT_CATEGORY	VARCHAR2(30 BYTE)
				REPORT_DATE	DATE
				REPORT_TITLE	VARCHAR2(60 BYTE)
				REPORT_DETAIL	VARCHAR2(3000 BYTE)
				ISDEALT	CHAR(1 BYTE)*/
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			inst().closeRset();
			inst().closePstmt();
		}
		
		return re;
	}

	public ArrayList<AttachmentVo> selectFileList(String reId) {
		PreparedStatement pstmt = null;		
		ResultSet rset = null;		
		inst().setProp("/sql/report/report.properties");
		pstmt = inst().getPstmt("selectFileOne");		
		ArrayList<AttachmentVo> list = null;
		
		
		try {
			pstmt.setString(1, reId);
			
			rset = inst().getResultSet();
			
			list = new ArrayList<AttachmentVo>();
			
			while(rset.next()) {				
				AttachmentVo na = new AttachmentVo();

				na.setFid(rset.getString("FID"));
				na.setOriginName(rset.getString("ORIGIN_NAME"));
				na.setChangeName(rset.getString("CHANGE_NAME"));
				na.setFilePath(rset.getString("FILE_PATH"));
				na.setUploadDate(rset.getDate("UPLOAD_DATE"));
				na.setFileLevel(rset.getInt("FILE_LEVEL"));
				na.setReportCode(reId);				
				
				list.add(na);
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
