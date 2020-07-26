package com.kh.groumoa.report.model.service;

import static com.kh.groumoa.common.CustomUtil.inst;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.kh.groumoa.common.PageInfo;
import com.kh.groumoa.common.model.vo.AttachmentVo;
import com.kh.groumoa.report.model.dao.ReportDao;
import com.kh.groumoa.report.model.vo.ReportVo;

public class ReportService {

	public int insertReport(ReportVo re, ArrayList<AttachmentVo> attachList) {
		int result = 0;				
		inst().setProp("/sql/driver.properties");		
		Connection con = inst().getCon("url", "user", "password", "driver");
		
		ReportDao rd = new ReportDao();
		
		result = rd.insertReport(re);
		
		if(result > 0) {
			String reId = rd.getResultId();
			
			for(int i = 0; i < attachList.size(); i++) {
				//리포트 아이디 추가 부분 필요.
				attachList.get(i).setReportCode(reId);
				result += rd.insertAttach(attachList.get(i));
			}			
		}
		
		if(result == attachList.size()) {
			inst().commit();
			result = 1;
		} else {
			inst().rollback();
		}
		
		inst().commit();
		
		return result;
	}

	public int getListCount() {
		int result = 0;
		
		inst().setProp("/sql/driver.properties");		
		Connection con = inst().getCon("url", "user", "password", "driver");
		
		ReportDao rd = new ReportDao();
		
		result = rd.getCount();
		
		inst().closeCon();
		
		return result;
	}

	public ArrayList<ReportVo> selectList(PageInfo pi) {
		ArrayList<ReportVo> reList = null;
		inst().setProp("/sql/driver.properties");		
		Connection con = inst().getCon("url", "user", "password", "driver");
		
		ReportDao rd = new ReportDao();
		
		reList = rd.selectList(pi);
		
		inst().closeCon();
		
		return reList;
	}

	public HashMap<String, Object> selectFileMap(String reId) {
		HashMap<String, Object> hmap = null;
		
		inst().setProp("/sql/driver.properties");		
		Connection con = inst().getCon("url", "user", "password", "driver");
		
		ReportDao rd = new ReportDao();
		
		ReportVo re = rd.selectOneReport(reId);
		
		ArrayList<AttachmentVo> list = rd.selectFileList(reId);
		
		hmap = new HashMap<>();
		
		hmap.put("report", re);
		hmap.put("attach", list);
		
		inst().closeCon();
		
		return hmap;
	}

	

}
