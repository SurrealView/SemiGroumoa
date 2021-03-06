package com.kh.groumoa.fee.model.service;

import static com.kh.groumoa.common.JDBCTemplate.close;
import static com.kh.groumoa.common.JDBCTemplate.commit;
import static com.kh.groumoa.common.JDBCTemplate.getConnection;
import static com.kh.groumoa.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.groumoa.common.PageInfo;
import com.kh.groumoa.fee.model.dao.FeeDao;
import com.kh.groumoa.fee.model.vo.FeeVO;
import com.kh.groumoa.group.model.dao.BoardDao;
import com.kh.groumoa.scheduler.model.dao.SchedulerDao;

public class FeeService {

	public int getListCount(FeeVO fee) {
		Connection con = getConnection();
		int listCount = new FeeDao().getListCount(con, fee);
		
		close(con);

		return listCount;
	}

	public ArrayList<FeeVO> selectList(PageInfo pi, FeeVO fee) {
		Connection con = getConnection();
		
		ArrayList<FeeVO> list = new FeeDao().selectList(con, pi, fee);
		
		close(con);
		
		return list;
	}

	public int insertFee(FeeVO fee) {
		Connection con = getConnection();

		int result = new FeeDao().insertFee(con, fee);

		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public int deleteFee(ArrayList<FeeVO> requestFeeArray) {
		Connection con = getConnection();
		int result = 0;
		
		int[] resultArr = new int[requestFeeArray.size()];
		
		for (int i = 0; i < requestFeeArray.size(); i++) {

			int resultEach = new FeeDao().deleteFee(con, requestFeeArray.get(i));

			resultArr[i] = resultEach;
		}
		
		for (int i = 0; i < resultArr.length; i++) {
			if (resultArr[i] == 0) {
				result = 0;
				break;
			}
			result = 1;
		}

		if (result != 0) {
			commit(con);
		} else {
			rollback(con);
		}

		close(con);

		return result;
	}

}
