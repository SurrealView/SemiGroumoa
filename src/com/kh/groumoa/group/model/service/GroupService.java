package com.kh.groumoa.group.model.service;
import static com.kh.groumoa.common.JDBCTemplate.*;

import java.sql.Connection;

import com.kh.groumoa.group.model.dao.GroupDao;
import com.kh.groumoa.group.model.vo.GroupVO;

public class GroupService {
	
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
