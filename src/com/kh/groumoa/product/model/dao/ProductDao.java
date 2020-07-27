package com.kh.groumoa.product.model.dao;

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
import com.kh.groumoa.group.model.dao.BoardDao;
import com.kh.groumoa.group.model.vo.BoardVO;
import com.kh.groumoa.product.model.vo.ProductBoughtVO;
import static com.kh.groumoa.common.JDBCTemplate.*;

public class ProductDao {


	private Properties prop = new Properties();
	
	public ProductDao() {
		String fileName = BoardDao.class.getResource("/sql/product/product-query.properties").getPath();
		
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

	public int insertPaymentHistory(Connection con, ProductBoughtVO requestProduct) {
			
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("insertPaymentHistory");
		
		try {
			pstmt = con.prepareStatement(query);
			//세팅하기
			pstmt.setString(1, requestProduct.getPbCode());
			pstmt.setInt(2, requestProduct.getGroupCode());
			pstmt.setString(3, requestProduct.getProductCode());
			pstmt.setInt(4, requestProduct.getPayerCode());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int getListCount(Connection con, ProductBoughtVO product) {
		PreparedStatement pstmt = null;
		int listCount = 0;
		ResultSet rset = null;
		
		String query = prop.getProperty("listCount");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, product.getGroupCode());
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

	public ArrayList<ProductBoughtVO> selectList(Connection con, PageInfo pi, ProductBoughtVO product) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ProductBoughtVO> list = null;
		
		String query = prop.getProperty("selectList");
		
		try {
			pstmt = con.prepareStatement(query);
			int startRow = (pi.getCurrentPage() - 1) * pi.getLimit() + 1;
			int endRow = startRow + pi.getLimit() - 1;
			
			pstmt.setInt(1, product.getGroupCode());
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<ProductBoughtVO>();
			
			while(rset.next()) {
				ProductBoughtVO p = new ProductBoughtVO();
				p.setGroupCode(rset.getInt("GROUP_CODE"));
				p.setPayerCode(rset.getInt("PAYER_CODE"));
				p.setPayerName(rset.getString("MEMBER_NAME"));
				p.setPbCode(rset.getString("PB_CODE"));
				p.setPbDate(rset.getDate("PB_DATE"));
				p.setProductCode(rset.getString("PRODUCT_CODE"));
				p.setProductDetail(rset.getString("DETAIL"));
				p.setProductPrice(rset.getInt("PRICE"));
				p.setProductTerms(rset.getString("TERMS"));
				p.setRefundAvailableDate(rset.getDate("REFUND_AVAILABLE_DATE"));
				
				list.add(p);
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

}
