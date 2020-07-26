package com.kh.groumoa.scheduler.model.service;

import static com.kh.groumoa.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.groumoa.scheduler.model.dao.SchedulerDao;
import com.kh.groumoa.scheduler.model.vo.SchedulerVO;

public class SchedulerService {

	public int insertSchedule(SchedulerVO schedule) {
		Connection con = getConnection();

		int result = new SchedulerDao().insertSchedule(con, schedule);

		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public ArrayList<SchedulerVO> selectScheduleList(int groupCode) {
		Connection con = getConnection();
		
		ArrayList<SchedulerVO> list = new SchedulerDao().selectScheduleList(con, groupCode);
		
		close(con);
		
		return list;
	}

}
