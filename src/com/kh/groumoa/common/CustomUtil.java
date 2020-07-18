package com.kh.groumoa.common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class CustomUtil {
	private static CustomUtil instance = null;
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private Statement stmt = null;
	private Properties prop = null;
	private ResultSet rset = null;
	
	
	public CustomUtil() {
		prop = new Properties();
	}
	
	public static CustomUtil inst() {
		if(instance == null) {
			instance = new CustomUtil();
		}		
		return instance;
	}
	
	public void setProp(String filePath) {
		try {
			//String fileName = JDBCTemplate.class.getResource("/sql/driver.properties").getPath();
			String file = CustomUtil.class.getResource(filePath).getPath();
			prop.load(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public String getPropVal(String key) {
		String nnn = prop.getProperty(key);
		return nnn;		
	}
	
	public Connection getCon(String url, String user, String pwd, String driver) {
		
		try {
			Class.forName(prop.getProperty(driver));
			con = DriverManager.getConnection(prop.getProperty(url), prop.getProperty(user), prop.getProperty(pwd));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	
	public PreparedStatement getPstmt(String key) {
		
		try {
			String query = prop.getProperty(key);
			pstmt = con.prepareStatement(prop.getProperty(key));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pstmt;
	}
	
	public Statement getStmt() {
		try {
			stmt = con.createStatement();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return stmt;
	}
	
	public ResultSet getResultSet(String key) {		
		try {
			String query = prop.getProperty(key);
			
			rset = stmt.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rset;
	}
	
	public ResultSet getResultSet() {		
		try {
			rset = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return rset;
	}
	
	public int getResult() {
		int result = 0;
		
		try {
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int getResult(String key) {
		int result = 0;
		
		try {
			result = stmt.executeUpdate(prop.getProperty(key));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public void closeCon() {
		try {
			if(con != null && !con.isClosed()) {
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	public void closePstmt() {
		try {
			if(pstmt != null && !pstmt.isClosed()) {
				pstmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void closeStmt() {
		try {
			if(stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void closeRset() {
		try {
			if(rset != null && !rset.isClosed()) {
				rset.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int RandNum(int min, int max) {
		int randNum = (int)(Math.random() * max + min);
		
		return randNum;
	}
	
	public PageInfo getPageInfo(int currentPage, int limit, int totalCount) {
		
		int maxPage;     //전체 페이지에서 가장 마지막 페이지
		int startPage;   //한번에 표시될 페이지가 시작할 페이지.
		int endPage;     //한번에 표시될 페이지가 끝나는 페이지.
				
		//총 페이지 수 계산.
		//ex) 123개의 목록이 있다면 총 필요한 페이지 수는 13개.
		//총 열개의 페이지를 1페이지에 보여줄 때 가중치에 해당하는 0.1이 1이 될 수 있게끔 0.9를 더해줌.
		//즉, 게시물 목록이 1개 더 있음 한페이지가 더 보이도록함.
		maxPage = (int) ((double) totalCount / limit + 0.9);
		
		//현재 페이지에 보여줄 시작 페이지 수 (10개씩 보여지게 할 경우)
		//아래 쪽 페이지 수가 10개씩 보여진다면
		//1, 11, 21, 31...
		
		startPage = (((int) ((double)currentPage / 10 + 0.9)) - 1) * 10 + 1;
		
		//목록 아래쪽에 보여질 마지막 페이지 수(10, 20, 30)
		endPage = startPage + 10 - 1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(limit, currentPage, maxPage, startPage, endPage, totalCount);
		
		return pi;
		
		/*
		 강사님 코드 기준 사용법.
		currentPage= 1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		limit = 10;
		int listCount = new BoardService().getListCount();
		System.out.println("list Count : " + listCount);
		
		PageInfo pi = inst().getPageInfo(currentPage, limit, listCount);
		
		ArrayList<Board> list = new BoardService().selectList(pi);
		
		String page = "";
		
		if(list != null) {
			page = "views/board/boardList.jsp";
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
		} else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "게시판 조회 실패!");
		}
		
		request.getRequestDispatcher(page).forward(request, response);
		 * */
	}	
	
	public void commit() {
		try {
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void rollback() {
		try {
			con.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
