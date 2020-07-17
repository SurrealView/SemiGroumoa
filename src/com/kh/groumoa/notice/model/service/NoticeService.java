package com.kh.groumoa.notice.model.service;

import static com.kh.groumoa.common.CustomUtil.inst;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.groumoa.common.PageInfo;
import com.kh.groumoa.notice.model.dao.NoticeDao;
import com.kh.groumoa.notice.model.vo.NoticeVo;

public class NoticeService {

	public int getListCount() {
		int result = 0;
		
		inst().setProp("/sql/driver.properties");
		
		Connection con = inst().getCon("url", "user", "password", "driver");
		
		NoticeDao nd = new NoticeDao();
		
		result = nd.getListCount();
		
		return result;
	}

	public ArrayList<NoticeVo> selectList(PageInfo pi) {
		ArrayList<NoticeVo> list = null;
		inst().setProp("/sql/driver.properties");
		
		Connection con = inst().getCon("url", "user", "password", "driver");
		
		NoticeDao nd = new NoticeDao();
		list = nd.selectList(pi);
		
		inst().closeCon();
		
		return list;
	}

}
