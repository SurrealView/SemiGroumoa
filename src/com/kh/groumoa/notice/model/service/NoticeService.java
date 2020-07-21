package com.kh.groumoa.notice.model.service;

import static com.kh.groumoa.common.CustomUtil.inst;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.kh.groumoa.common.PageInfo;
import com.kh.groumoa.notice.model.dao.NoticeDao;
import com.kh.groumoa.notice.model.vo.NoAttach;
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

	public int insertNotice(NoticeVo no, ArrayList<NoAttach> fileList) {
		int result = 0;
		
		inst().setProp("/sql/driver.properties");
		
		Connection con = inst().getCon("url", "user", "password", "driver");
		
		NoticeDao nd = new NoticeDao();		
		
		result = nd.insertNotice(no);
		
		if(result > 0) {
			String noId = nd.selectCurrId();
			
			result = 0;
			
			for(int i = 0; i < fileList.size(); i++) {
				fileList.get(i).setNid(noId);
				
				result += nd.insertAttachment(fileList.get(i));
			}
		}
		
		if(result == fileList.size()) {
			inst().commit();
			result = 1;
		} else {
			inst().rollback();
		}
		
		inst().closeCon();
		
		return result;
	}

	public NoticeVo selectOne(String noticeId) {
		inst().setProp("/sql/driver.properties");		
		Connection con = inst().getCon("url", "user", "password", "driver");
		
		NoticeVo no = new NoticeDao().selectOne(noticeId);
		
		if(no != null) {
			inst().commit();
		} else {
			inst().rollback();
		}
		
		inst().closeCon();
		
		return no;
	}

	public HashMap<String, Object> selectFileMap(String noticeId) {
		inst().setProp("/sql/driver.properties");		
		Connection con = inst().getCon("url", "user", "password", "driver");
		HashMap<String, Object> hmap = null;
		
		hmap = new NoticeDao().selectFileMap(noticeId);		
		
		inst().closeCon();
		
		return hmap;
	}
	//
	public int updateNotice(NoticeVo no, ArrayList<NoAttach> fileList, ArrayList<NoAttach> oldFileList) {
		int result = 0;
		
		inst().setProp("/sql/driver.properties");
		
		Connection con = inst().getCon("url", "user", "password", "driver");
		
		NoticeDao nd = new NoticeDao();		
		
		result = nd.updateNotice(no);
		
		if(result > 0) {
			//String noId = nd.selectCurrId();
			
			result = 0;
			
			for(int i = 0; i < fileList.size(); i++) {
				fileList.get(i).setNid(no.getNoticeCategory());
				
				if(i < oldFileList.size()) {
					fileList.get(i).setFid(oldFileList.get(i).getFid());
					fileList.get(i).setNid(no.getNoticeCode());
					result += nd.updateAttachment(fileList.get(i));
				} else {
					result += nd.insertAttachment(fileList.get(i));
				}
			}
		}
		
		if(result == fileList.size()) {
			inst().commit();
			result = 1;
		} else {
			inst().rollback();
		}
		
		inst().closeCon();
		
		return result;
	}

}
