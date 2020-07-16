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
import java.util.Properties;

public class CustomUtil {
	private static CustomUtil instance = null;
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private Statement stmt = null;
	private Properties prop = null;
	private ResultSet rset = null;
	
	
	public CustomUtil() {		
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
			prop.load(new FileReader(CustomUtil.class.getResource(filePath).getPath()));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public String getPropVal(String key) {
		return prop.getProperty(key);		
	}
	
	public Connection getCon(String url, String user, String pwd) {
		
		try {
			con = DriverManager.getConnection(url, user, pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	
	public PreparedStatement getPstmt(String key) {
		
		try {
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
			rset = stmt.executeQuery(prop.getProperty(key));
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
	
	//사용법
	//import static로 CustomUtil.inst;를 해줍니다.
	//inst()함수를 통해서 다른 public 함수들을 불러오면 됩니다.
	
	//ex) int result = inst().getResult(); 
}
