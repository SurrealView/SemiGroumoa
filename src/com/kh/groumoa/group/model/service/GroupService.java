package com.kh.groumoa.group.model.service;
import static com.kh.groumoa.common.JDBCTemplate.close;
import static com.kh.groumoa.common.JDBCTemplate.commit;
import static com.kh.groumoa.common.JDBCTemplate.getConnection;
import static com.kh.groumoa.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.groumoa.group.model.dao.GroupDao;
import com.kh.groumoa.group.model.vo.Attachment;
import com.kh.groumoa.group.model.vo.GroupVO;
import com.kh.groumoa.member.model.vo.MemberVO;
import com.kh.groumoa.member.model.vo.RegionVO;

public class GroupService {
	
	//동호회 생성
	public int insertGroup(GroupVO group, ArrayList<Attachment> fileList) {
		Connection con = getConnection();
		int result = 0;
		int result1 = 0;
		int result2 = 0;
		
		result1 = new GroupDao().insertThumbnailContent(con, group);
		
		if(result1 > 0) {
			int groupCode = new GroupDao().selectCurrval(con);
			
			for(int i = 0; i < fileList.size(); i++) {
				fileList.get(i).setGroupCode(groupCode);
//				group.setGroupCode(groupCode);
				
				result2 += new GroupDao().insertAttachment(con, fileList.get(i));
			}
			
		}
		
		if(result1 > 0 && result2 == fileList.size()) {
			commit(con);
			result = 1;
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}
	
	//지역 조회
	public RegionVO searchRegion(String rnCode) {
		Connection con = getConnection();
		
		RegionVO region = new GroupDao().searchRegion(con, rnCode);
		
		if(region != null) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);		
		
		return region;
	}
	
	//동호회 입력내용 조회
	public GroupVO selectOne(String groupCode) {
		Connection con = getConnection();
		int result = 0;
		
		GroupVO selectedGroup = new GroupDao().selectGroup(con, groupCode);
		System.out.println(selectedGroup);
		if(selectedGroup != null) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return selectedGroup;
	}

	
	//동호회 기본정보 수정
	public int updateGroup(GroupVO group, ArrayList<Attachment> fileList) {
		Connection con = getConnection();
		int result = 0;
		int result1 = 0;
		int result2 = 0;
		
		result1 = new GroupDao().updateThumbnailContent(con, group);
		
		if(result1 > 0) {
			int groupCode = new GroupDao().selectCurrval(con);
			
			for(int i = 0; i < fileList.size(); i++) {
				fileList.get(i).setGroupCode(groupCode);
//				group.setGroupCode(groupCode);
				
				result2 += new GroupDao().updateAttachment(con, fileList.get(i));
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
	
	//동호회 회원 추방
	public int kickOut (int memberCode) {
		Connection con = getConnection();
		int result = 0;
		
		result = new GroupDao().kickOut(con, memberCode);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		return result;
	}
	
	//회원 조회
	public ArrayList<MemberVO> selectList() {
		Connection con = getConnection();
		ArrayList<MemberVO> list = new GroupDao().selectList(con);
		
		close(con);
		
		return list;
	}
	
	
	//동호회페이지 동호회 조회
	
	
/*	//동호회 
	public GroupVO selectOne(String groupCode) {
		Connection con = getConnection();
		int result = 0;
		
		GroupVO group = new GroupDao().
		
		return result;
	}*/
	
	//동호회 조회
	public GroupVO selectOneGroup(GroupVO Group) {
		Connection con = getConnection();
		
		GroupVO selectedGroup = new GroupDao().selectOneGroup(con, Group);
		
		close(con);
		System.out.println(selectedGroup);
		return selectedGroup;
	}
	

}