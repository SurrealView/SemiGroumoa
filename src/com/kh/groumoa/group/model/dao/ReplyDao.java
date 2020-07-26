package com.kh.groumoa.group.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.groumoa.group.model.vo.ReplyVO;
import static com.kh.groumoa.common.JDBCTemplate.*;


public class ReplyDao {
	
	private Properties prop = new Properties();
	
	public ReplyDao() {
		String fileName = BoardDao.class.getResource("/sql/board/board-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int insertReply(Connection con, ReplyVO reply) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertReply");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, reply.getPostCode());
			pstmt.setInt(2, reply.getWriterCode());
			pstmt.setString(3, reply.getDetail());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<ReplyVO> selectReplyList(Connection con, int postCode) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ReplyVO> list = null;
		
		String query = prop.getProperty("selectReplyList");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, postCode);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<ReplyVO>();
			
			while(rset.next()) {
				ReplyVO r = new ReplyVO();
				r.setReplyCode(rset.getInt("REPLY_CODE"));
				r.setPostCode(rset.getInt("POST_CODE"));
				r.setWriterCode(rset.getInt("WRITER_CODE"));
				r.setDetail(rset.getString("REPLY_DETAIL"));
				r.setReplyDate(rset.getDate("REPLY_DATE"));
				r.setWriterName(rset.getString("MEMBER_NAME"));
				
				list.add(r);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

}
