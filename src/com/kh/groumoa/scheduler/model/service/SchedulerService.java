package com.kh.groumoa.scheduler.model.service;



import static com.kh.groumoa.common.JDBCTemplate.close;
import static com.kh.groumoa.common.JDBCTemplate.getConnection;

import java.sql.Connection;

import com.kh.groumoa.scheduler.model.dao.SchedulerDao;
import com.kh.groumoa.scheduler.model.vo.SchedulerVO;

public class SchedulerService {
	
	public SchedulerVO ScheduleInsert(SchedulerVO reqestMember) {
		Connection con = getConnection();
		
		SchedulerVO loginUser = new SchedulerDao().ScheduleInsert(con,reqestMember);

		close(con);
		
		return loginUser;
	}

}
