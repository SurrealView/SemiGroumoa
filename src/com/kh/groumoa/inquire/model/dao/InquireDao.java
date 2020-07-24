package com.kh.groumoa.inquire.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

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
		
		String qurey = prop.getProperty("insertInquire");
		
		try {
			pstmt = con.prepareStatement(qurey);
			pstmt.setString(1, requestInquire.getCategoryCode());
			pstmt.setInt(2, requestInquire.getGroupCode());
			pstmt.setInt(3, requestInquire.getWriterCode());
			pstmt.setString(4, requestInquire.getTitle());
			pstmt.setString(5, requestInquire.getDetail());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}
