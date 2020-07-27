package com.kh.groumoa.group.model.service;
import static com.kh.groumoa.common.JDBCTemplate.close;
import static com.kh.groumoa.common.JDBCTemplate.commit;
import static com.kh.groumoa.common.JDBCTemplate.getConnection;
import static com.kh.groumoa.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.groumoa.common.PageInfo;
import com.kh.groumoa.common.model.vo.AttachmentVo;
import com.kh.groumoa.group.model.dao.GroupDao;
import com.kh.groumoa.group.model.vo.Attachment;
import com.kh.groumoa.group.model.vo.GroupMemberVO;
import com.kh.groumoa.group.model.vo.GroupVO;
import com.kh.groumoa.member.model.dao.MemberDao;
import com.kh.groumoa.member.model.vo.InterestVO;
import com.kh.groumoa.member.model.vo.MemberInterestVO;
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
				group.setGroupCode(groupCode);
				
				result2 += new GroupDao().insertAttachment(con, fileList.get(i));
			}
			System.out.println("test result2 : " + result2);
			
		}
		
		if(result1 > 0 && result2 == fileList.size()) {
			commit(con);
			result = 1;
		} else {
			rollback(con);
		}
		
		close(con);
		System.out.println("test result : " + result);
		
		return result;
	}
	
	//지역 조회
	public RegionVO searchRegion(String rnCode) {
		Connection con = getConnection();
		
		RegionVO region = new GroupDao().searchRegion(con, rnCode);
		System.out.println("rn서비스" + rnCode);
		if(region != null) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);		
		
		return region;
	}
	
	//활동 분야 조회
	public InterestVO searchInterest(String interestCode) {
		Connection con = getConnection();
		
		InterestVO interest = new GroupDao().searchInterest(con, interestCode);
		
		if(interest != null) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);		
		
		return interest;
	}
	
	//동호회 입력내용 조회
	public GroupVO selectOne(int groupCode) {
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
	public int updateGroup(GroupVO group) {
		Connection con = getConnection();
		int result = 0;
		int result1 = 0;
		int result2 = 0;
		
		result = new GroupDao().updateGroup(con,group);
		
		//result1 = new GroupDao().updateThumbnailContent(con, group);
		
/*		if(result1 > 0) {
//			int groupCode = new GroupDao().selectCurrval(con);
			
			for(int i = 0; i < fileList.size(); i++) {
				fileList.get(i).setGroupCode(group.getGroupCode());
//				group.setGroupCode(groupCode);
				
				result2 += new GroupDao().updateAttachment(con, fileList.get(i));
			}
			
//			System.out.println(groupCode);
		}*/
		
		if(result > 0 /*&& result2 == fileList.size()*/) {
			commit(con);/*
			result = 1;*/
		} else {
			rollback(con);
		}
		
		close(con);
		
		System.out.println("service" + result);
		return result;
	}
	
	//회원 조회
	public ArrayList<GroupMemberVO> selectList(String groupCode) {
		Connection con = getConnection();
		ArrayList<GroupMemberVO> list = new GroupDao().selectList(con, groupCode);
		
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
		
		//지역명 가져오기
		RegionVO region = new GroupDao().searchRegion(con, selectedGroup.getRnCode());
		selectedGroup.setRegionName(region.getRegionName() + " " + region.getRegionSpecific());
		
		//활동분야 가져오기
		System.out.println(selectedGroup.getInterestCode());
		InterestVO interest = new GroupDao().searchInterest(con, selectedGroup.getInterestCode());
		
		System.out.println(interest);
		selectedGroup.setInterest(interest.getInterest());		
		
		close(con);
		return selectedGroup;
	}
	

	public ArrayList<GroupVO> selectMyGroupList(MemberVO loginUser) {
		Connection con = getConnection();
		
		ArrayList<GroupVO> myGroupList = new GroupDao().selectMyGroupList(con, loginUser);
		
		close(con);
		
		return myGroupList;
	}

	public ArrayList<GroupVO> selectMyGroupListAsLeader(MemberVO loginUser) {
		Connection con = getConnection();
		
		ArrayList<GroupVO> myGroupListAsLeader = new GroupDao().selectMyGroupListAsLeader(con, loginUser);
		
		close(con);
		
		return myGroupListAsLeader;
	}

	public ArrayList<GroupVO> searchGroupList(GroupVO group) {
		Connection con = getConnection();
		
		ArrayList<GroupVO> searchedGroupList = new GroupDao().searchGroupList(con, group);
		
		close(con);
		
		return searchedGroupList;
	}

	public ArrayList<ArrayList<GroupVO>> selectRecommendedGroupList(MemberVO loginUser) {
		Connection con = getConnection();
		
		ArrayList<MemberInterestVO> loginUserInterests = new MemberDao().selectMemberInterests(con, loginUser); 
		
		ArrayList<ArrayList<GroupVO>> recommendedGroupList = new ArrayList<ArrayList<GroupVO>>();
		
		for(int i = 0; i < loginUserInterests.size(); i++) {

			
			ArrayList<GroupVO> recommendedGroups = new GroupDao().selectRecommendedGroupList(con, loginUserInterests.get(i));
			recommendedGroupList.add(recommendedGroups);
		}
		
		
		close(con);
		
		return recommendedGroupList;
	}
  
  	public ArrayList<MemberVO> groupMemberList(PageInfo pi, int GroupCode) {
		Connection con = getConnection();
		
		ArrayList<MemberVO> list = new GroupDao().groupMemberList(con, pi, GroupCode);
		
		close(con);		
		
		return list;
	}

	public int memberListCount() {
		Connection con = getConnection();
		int listCount = new GroupDao().memberListCount(con);
		
		close(con);
		
		return listCount;
  
  }

	public ArrayList<GroupVO> groupList(PageInfo pi) {
		Connection con = getConnection();
		
		ArrayList<GroupVO> list = new GroupDao().groupList(con, pi);
		
		close(con);
		
		return list;
	}

	public String groupLeaderList(GroupVO groupVO) {
		Connection con = getConnection();
		
		String name = new GroupDao().groupLeaderList(con, groupVO);
		
		close(con);
		
		return name;
	}

	public int groupListCount() {
		Connection con = getConnection();
		int listCount = new GroupDao().groupListCount(con);
		
		close(con);
		
		return listCount;
	}

	public AttachmentVo selectAttachment(int groupCode) {
		
		Connection con = getConnection();
		
		AttachmentVo attach = new GroupDao().selectAttachment(con, groupCode);
		
		close(con);
		
		return attach;
  }

	public GroupVO selectGroup(int nno) {
		Connection con = getConnection();
		GroupVO group = new GroupDao().selectGroupDetail(con, nno);
		
		close(con);
		
		return group;
	}

	public GroupVO selectGroupD(int nno) {
		Connection con = getConnection();
		GroupVO groupD = new GroupDao().selecGroupD(con, nno);
		close(con);
		return groupD;

	}

	public int joinGroup(GroupVO group, MemberVO loginUser) {
		
		Connection con = getConnection();
		
		int result = new GroupDao().joinGroup(con, group.getGroupCode(), loginUser.getMemberCode());
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

}