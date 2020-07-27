package com.kh.groumoa.inquire.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import javax.print.attribute.standard.RequestingUserName;

import com.kh.groumoa.common.PageInfo;
import com.kh.groumoa.inquire.model.vo.InquireVO;
import static com.kh.groumoa.common.JDBCTemplate.close;

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

}
