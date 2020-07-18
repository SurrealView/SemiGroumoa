package com.kh.groumoa.scheduler.model.dao;

import static com.kh.groumoa.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.groumoa.scheduler.model.vo.SchedulerVO;

public class SchedulerDao {
	private Properties prop = new Properties();

	public SchedulerDao() {
		String fileName = SchedulerDao.class.getResource("/sql/scheduler/scheduler-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int insertSchedule(Connection con, SchedulerVO schedule) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertSchedule");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, schedule.getSchTitle());
			pstmt.setString(2, schedule.getSchDetail());
			pstmt.setString(3, schedule.getSchDate());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public ArrayList<SchedulerVO> selectSchedule(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<SchedulerVO> list = null;

		String query = prop.getProperty("selectSchedule");
		
		try {
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			list = new ArrayList<>();
			
			while(rset.next()) {
				SchedulerVO schedule = new SchedulerVO();
				schedule.getSchCode();
				schedule.getGroupCode();
				schedule.getSchTitle();
				schedule.getSchDetail();
				schedule.getSchDate();
				schedule.getDateWritten();
				schedule.getWriterCode();
				schedule.getStatus();
				
				list.add(schedule);
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
