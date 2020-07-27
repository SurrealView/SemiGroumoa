package com.kh.groumoa.product.model.service;

import static com.kh.groumoa.common.JDBCTemplate.close;
import static com.kh.groumoa.common.JDBCTemplate.commit;
import static com.kh.groumoa.common.JDBCTemplate.getConnection;
import static com.kh.groumoa.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.groumoa.common.PageInfo;
import com.kh.groumoa.group.model.dao.BoardDao;
import com.kh.groumoa.group.model.vo.BoardVO;
import com.kh.groumoa.product.model.dao.ProductDao;
import com.kh.groumoa.product.model.vo.ProductBoughtVO;

public class ProductService {

	public int insertPaymentHistory(ProductBoughtVO requestProduct) {
		int result = 0;
		
		Connection con = getConnection();
		
		result = new ProductDao().insertPaymentHistory(con, requestProduct);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		return result;
		
	}

	public int getListCount(ProductBoughtVO product) {
		Connection con = getConnection();
		int listCount = new ProductDao().getListCount(con, product);
		
		close(con);

		return listCount;
	}

	public ArrayList<ProductBoughtVO> selectList(PageInfo pi, ProductBoughtVO product) {
		Connection con = getConnection();
		
		ArrayList<ProductBoughtVO> list = new ProductDao().selectList(con, pi, product);
		
		close(con);
		
		return list;
	}

}
