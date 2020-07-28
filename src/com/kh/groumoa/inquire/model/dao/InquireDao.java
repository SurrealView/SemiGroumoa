package com.kh.groumoa.inquire.model.dao;

import static com.kh.groumoa.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.groumoa.common.PageInfo;
import com.kh.groumoa.inquire.model.vo.InquireVO;

public class InquireDao {
	private Properties prop = new Properties();

	public InquireDao() {
		String fileName = InquireDao.class.getResource("/sql/inquire/inquire-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	
	public int insertInquire(Connection con, InquireVO requestInquire) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertInquire");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, requestInquire.getQuestioner_Code());
			pstmt.setString(2, requestInquire.getQna_Cate_Code());
			pstmt.setString(3, requestInquire.getQna_Title());
			pstmt.setString(4, requestInquire.getQna_Detail());
			
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}


	public ArrayList<InquireVO> selectInquireList(Connection con, PageInfo pi, InquireVO inquire) {
		
		
		
		return null;
	}

	   public ArrayList<InquireVO> selectList(Connection con, PageInfo pi) {
	      Statement stmt = null;
	      ResultSet rset = null;
	      ArrayList<InquireVO> list = null;

	      String query = prop.getProperty("selectList");

	      try {
	         stmt = con.createStatement();
	         rset = stmt.executeQuery(query);

	         list = new ArrayList<InquireVO>();

	         while(rset.next()) {
	            InquireVO i = new InquireVO();

	            i.setQna_Code(rset.getString("QNA_CODE"));
	            i.setQuestioner_Code(rset.getInt("QUESTIONER_CODE"));
	            i.setQna_Cate_Code(rset.getString("QNA_CATE_CODE"));
	            i.setQna_Title(rset.getString("QNA_TITLE"));
	            i.setQna_Detail(rset.getString("QNA_DETAIL"));
	            i.setQna_Date(rset.getDate("QNA_DATE"));
	            i.setQna_Reply(rset.getString("QNA_REPLY"));
	            i.setIsanswered(rset.getString("ISANSWERED"));
	            
	            list.add(i);

	         }

	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close(stmt);
	         close(rset);
	      }

	      return list;
	   }


	public ArrayList<InquireVO> selectQna(Connection con) {
	       Statement stmt = null;
	       ResultSet rset = null;
	       
	       ArrayList<InquireVO> selectQna = null;
	       
	       String query = prop.getProperty("selectList");
	       
	       try {
	            stmt = con.createStatement();
	            rset = stmt.executeQuery(query);

	            selectQna = new ArrayList<InquireVO>();

	            while(rset.next()) {
	               InquireVO i = new InquireVO();

	               i.setQna_Code(rset.getString("QNA_CODE"));
	               i.setQuestioner_Code(rset.getInt("QUESTIONER_CODE"));
	               i.setQna_Cate_Code(rset.getString("QNA_CATE_CODE"));
	               i.setQna_Title(rset.getString("QNA_TITLE"));
	               i.setQna_Detail(rset.getString("QNA_DETAIL"));
	               i.setQna_Date(rset.getDate("QNA_DATE"));
	               i.setQna_Reply(rset.getString("QNA_REPLY"));
	               i.setIsanswered(rset.getString("ISANSWERED"));
	               
	               selectQna.add(i);

	            }

	         } catch (SQLException e) {
	            e.printStackTrace();
	         } finally {
	            close(stmt);
	            close(rset);
	         }

	         return selectQna;
	       
	   }

}
