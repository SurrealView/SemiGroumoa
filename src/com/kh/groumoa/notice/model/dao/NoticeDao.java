package com.kh.groumoa.notice.model.dao;

import static com.kh.groumoa.common.CustomUtil.inst;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.kh.groumoa.common.PageInfo;
import com.kh.groumoa.notice.model.vo.NoAttach;
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
		inst().setProp("/sql/notice/notice.properties");
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
				String code = rset.getString("NOTICE_CODE");
				n.setnNo(code);
				n.setNoticeCode(rset.getString("NOTICE_CODE"));
				n.setNoticeCategory(rset.getString("NOTICE_CATEGORY"));
				n.setNoticeTitle(rset.getString("NOTICE_TITLE"));
				n.setNoticeDetail(rset.getString("NOTICE_DETAIL"));
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

	public int insertNotice(NoticeVo no) {
		inst().setProp("/sql/notice/notice.properties");
		PreparedStatement pstmt = inst().getPstmt("insertNotice");
		int result = 0;
		try {
			//INSERT INTO TB_NOTICE 
			//VALUES(('N' || TO_CHAR(SEQ_NOTICE.NEXTVAL, 'FM99999999999')), ?, ?, ?, SYSDATE, ?, 'Y')
//			NOTICE_CODE	VARCHAR2(5 BYTE)
//			NOTICE_CATEGORY	VARCHAR2(15 BYTE)
//			NOTICE_TITLE	VARCHAR2(60 BYTE)
//			NOTICE_DETAIL	VARCHAR2(3000 BYTE)
//			NOTICE_DATE	DATE
//			MN_WRITER_CODE	VARCHAR2(5 BYTE)
//			NOTICE_STATUS	CHAR(1 BYTE)
			pstmt.setString(1, no.getNoticeCategory());
			pstmt.setString(2, no.getNoticeTitle());
			pstmt.setString(3, no.getNoticeDetail());
			pstmt.setString(4, no.getMnWriterCode());
			
			result = inst().getResult();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			inst().closePstmt();
		}
		
		return result;
	}
	

	public String selectCurrId() {
		Statement stmt = inst().getStmt();		
		inst().setProp("/sql/notice/notice.properties");
		ResultSet rset = inst().getResultSet("selectCurrval");
		
		String nId = null;
		
		try {
			if(rset.next()) {
				nId = "N" + rset.getString("currval");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			inst().closeStmt();
			inst().closeRset();
		}
		
		// TODO Auto-generated method stub
		return nId;
	}

	public int insertAttachment(NoAttach noAttach) {
		PreparedStatement pstmt = null;		
		int result = 0;
		inst().setProp("/sql/notice/notice.properties");
		pstmt = inst().getPstmt("insertAttachment");
		
		try {
			//insertAttachment=INSERT INTO TB_ATTACHMENT(FID, ORIGIN_NAME, CHANGE_NAME, FILE_PATH, UPLOAD_DATE, FILE_LEVEL, STATUS, NOTICE_CODE) VALUES(?, ?, ?, ?, SYSDATE, ?, 'Y', ?)
			pstmt.setString(1, noAttach.getOriginName());
			pstmt.setString(2, noAttach.getChangeName());
			pstmt.setString(3, noAttach.getFilePath());
			pstmt.setInt(4, noAttach.getFileLevel());
			pstmt.setString(5, noAttach.getNid());
			
			result = inst().getResult();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			inst().closePstmt();
		}
		
		
		return result;
	}

	public NoticeVo selectOne(String noticeId) {
		inst().setProp("/sql/notice/notice.properties");
		PreparedStatement pstmt = inst().getPstmt("selectOne");
		NoticeVo no = null;
		ResultSet rset = null;
		
		try {
			pstmt.setString(1, noticeId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				//N.NOTICE_CATEGORY, N.NOTICE_TITLE, 
				//N.NOTICE_DETAIL, N.NOTICE_DATE, M.MANAGER_CODE, M.MANAGER_ID 
				no.setnNo(noticeId);
				no.setNoticeCode(noticeId);
				no.setMnWriterCode(rset.getString("MANAGER_CODE"));
				no.setMnWriterID(rset.getString("MANAGER_ID"));
				no.setNoticeDate(rset.getDate("NOTICE_DATE"));
				no.setNoticeDetail(rset.getString("NOTICE_DETAIL"));
				no.setNoticeTitle(rset.getString("NOTICE_TITLE"));
				no.setNoticeCategory(rset.getString("NOTICE_CATEGORY"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			inst().closeRset();
			inst().closeStmt();
		}		
		
		return no;
	}

	public HashMap<String, Object> selectFileMap(String noticeId) {
		inst().setProp("/sql/notice/notice.properties");
		HashMap<String, Object> hmap = null;
		ArrayList<NoAttach> list = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		NoticeVo no = null;
		
		pstmt = inst().getPstmt("selectFileOne");
		
		try {
			pstmt.setString(1, noticeId);
			rset = pstmt.executeQuery();
			list = new ArrayList<>();
			while(rset.next()) {
				if(no == null) {
					no = new NoticeVo();
					no.setnNo(noticeId);
					no.setNoticeCode(noticeId);
					no.setMnWriterCode(rset.getString("MANAGER_CODE"));
					no.setMnWriterID(rset.getString("MANAGER_ID"));
					no.setNoticeDate(rset.getDate("NOTICE_DATE"));
					no.setNoticeDetail(rset.getString("NOTICE_DETAIL"));
					no.setNoticeTitle(rset.getString("NOTICE_TITLE"));
					no.setNoticeCategory(rset.getString("NOTICE_CATEGORY"));
				}
				
				NoAttach na = new NoAttach();

				na.setFid(rset.getString("FID"));
				na.setOriginName(rset.getString("ORIGIN_NAME"));
				na.setChangeName(rset.getString("CHANGE_NAME"));
				na.setFilePath(rset.getString("FILE_PATH"));
				na.setUploadDate(rset.getDate("UPLOAD_DATE"));
				
				list.add(na);
			}
			
			hmap = new HashMap<>();
			
			hmap.put("notice", no);
			hmap.put("attach", list);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return hmap;
	}	

}
