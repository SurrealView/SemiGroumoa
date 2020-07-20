package com.kh.groumoa.group.model.dao;

import static com.kh.groumoa.common.JDBCTemplate.close;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.groumoa.common.PageInfo;
import com.kh.groumoa.group.model.vo.BoardVO;


public class BoardDao {
	
	
private Properties prop = new Properties();
	
	public BoardDao() {
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
	
	public int insertBoard(Connection con, BoardVO requestBoard) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertBoard");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, requestBoard.getCategoryCode());
			pstmt.setString(2, requestBoard.getGroupCode());
			pstmt.setInt(3, requestBoard.getWriterCode());
			pstmt.setString(4, requestBoard.getTitle());
			pstmt.setString(5, requestBoard.getDetail());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int getListCount(Connection con, BoardVO board) {//
		PreparedStatement pstmt = null;
		int listCount = 0;
		ResultSet rset = null;
		
		String query = prop.getProperty("listCount");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, board.getGroupCode());
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return listCount;
		
	}
	
	//페이징 처리 후 게시물 목록 조회
	public ArrayList<BoardVO> selectList(Connection con, PageInfo pi, BoardVO board) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<BoardVO> list = null;
		
		String query = prop.getProperty("selectList");
		
		try {
			pstmt = con.prepareStatement(query);
			int startRow = (pi.getCurrentPage() - 1) * pi.getLimit() + 1;
			int endRow = startRow + pi.getLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<>();
			
			while(rset.next()) {
				BoardVO b = new BoardVO();
				b.setPostCode(rset.getString("POST_CODE"));
				b.setCategoryName(rset.getString("CATEGORY_NAME"));
				b.setMemberName(rset.getString("MEMBER_NAME"));
				b.setTitle(rset.getString("TITLE"));
				b.setPostDate(rset.getDate("POST_DATE"));
				list.add(b);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return list;
	}

	public int updateCount(Connection con, int num) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateCount");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, num);
			pstmt.setInt(2, num);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public BoardVO selectOne(Connection con, int num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		BoardVO board = null;
		
		String query = prop.getProperty("selectOne");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, num);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				board = new BoardVO();
				board.setCategoryName(rset.getString("CATEGORY_NAME"));
				board.setPostCode(rset.getString("POST_CODE"));
				board.setMemberName(rset.getString("MEMBER_NAME"));
				board.setTitle(rset.getString("TITLE"));
				board.setDetail(rset.getString("DETAIL"));
				board.setPostDate(rset.getDate("POST_DATE"));
				board.setStatus(rset.getString("STATUS"));
				board.setPcount(rset.getInt("PCOUNT"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return board;
	}

}
