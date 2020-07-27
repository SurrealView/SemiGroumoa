package com.kh.groumoa.fee.model.dao;

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
import com.kh.groumoa.fee.model.vo.FeeVO;

public class FeeDao {
	private Properties prop = new Properties();

	public FeeDao() {
		String fileName = FeeDao.class.getResource("/sql/fee/fee-query.properties").getPath();

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

	public int getListCount(Connection con, FeeVO fee) {
		PreparedStatement pstmt = null;
		int listCount = 0;
		ResultSet rset = null;

		String query = prop.getProperty("listCount");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, fee.getGroupCode());
			rset = pstmt.executeQuery();

			if (rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		return listCount;
	}

	public ArrayList<FeeVO> selectList(Connection con, PageInfo pi, FeeVO fee) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<FeeVO> list = null;

		String query = prop.getProperty("selectList");

		try {
			pstmt = con.prepareStatement(query);
			int startRow = (pi.getCurrentPage() - 1) * pi.getLimit() + 1;
			int endRow = startRow + pi.getLimit() - 1;
			
			pstmt.setInt(1, fee.getGroupCode());
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();

			list = new ArrayList<FeeVO>();

			while (rset.next()) {
				FeeVO f = new FeeVO();
				f.setGroupCode(fee.getGroupCode());
				f.setMemberCode(rset.getInt("MEMBER_CODE"));
				f.setFeeCategory(rset.getString("FEE_CATEGORY"));
				f.setDetail(rset.getString("DETAIL"));
				f.setFee(rset.getString("FEE"));
				f.setFeeDate(rset.getString("FEE_DATE").substring(0, 10));
				f.setFeeCode(rset.getInt("FEE_CODE"));
				list.add(f);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		return list;
	}

	public int insertFee(Connection con, FeeVO fee) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertFee");

		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, fee.getGroupCode());
			pstmt.setInt(2, fee.getMemberCode());
			pstmt.setString(3, fee.getFeeCategory());
			pstmt.setString(4, fee.getFee());
			pstmt.setString(5, fee.getDetail());
			pstmt.setString(6, fee.getFeeDate());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int deleteFee(Connection con, FeeVO feeVO) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteBoard");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, feeVO.getFeeCode());
			pstmt.setInt(2, feeVO.getGroupCode());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

}
