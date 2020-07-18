package com.kh.groumoa.group.model.service;
import static com.kh.groumoa.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.groumoa.group.model.dao.GroupDao;
import com.kh.groumoa.group.model.vo.Attachment;
import com.kh.groumoa.group.model.vo.GroupVO;
import com.kh.groumoa.member.model.dao.MemberDao;
import com.kh.groumoa.member.model.vo.MemberInterestVO;

public class GroupService {
	
	//동호회 생성
	public int insertGroup(GroupVO group, ArrayList<Attachment> fileList) {
		Connection con = getConnection();
		int result = 0;
		int result1 = 0;
		int result2 = 0;
		
		result1 = new GroupDao().insertThumbnailContent(con, group);
		
		if(result1 > 0) {
			String groupCode = new GroupDao().selectCurrval(con);
			
			for(int i = 0; i < fileList.size(); i++) {
				fileList.get(i).setGroupCode(groupCode);
//				group.setGroupCode(groupCode);
				
				result2 += new GroupDao().insertAttachment(con, fileList.get(i));
			}
			
			System.out.println(groupCode);
		}
		
		if(result1 > 0 && result2 == fileList.size()) {
			commit(con);
			result = 1;
		} else {
			rollback(con);
		}
		
		close(con);
		
		System.out.println("service" + result);
		return result;
	}
	
	//동호회 기본정보 수정
	public int updateGroup(GroupVO requestGroup) {
		Connection con = getConnection();
		
		int result = new GroupDao().updateGroup(con, requestGroup);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		return result;
	}
	
	//동호회 조회(관리자페이지)
	public GroupVO selectOne(String groupCode) {
		Connection con = getConnection();
		
		
		
		return null;
	}


}
