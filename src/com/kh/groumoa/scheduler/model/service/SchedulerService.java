package com.kh.groumoa.scheduler.model.service;

import static com.kh.groumoa.common.JDBCTemplate.*;

import java.sql.Connection;

import com.kh.groumoa.scheduler.model.dao.SchedulerDao;
import com.kh.groumoa.scheduler.model.vo.SchedulerVO;

public class SchedulerService {

	public int insertSchedule(SchedulerVO schedule) {
		System.out.println("service in");
		Connection con = getConnection();

		int result = new SchedulerDao().insertSchedule(con, schedule);

		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		System.out.println("service result : " + result);
		close(con);
		
		return result;
	}

}
