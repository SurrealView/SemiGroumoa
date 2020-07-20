package com.kh.groumoa.group.model.vo;

public class GroupMemberVO implements java.io.Serializable {
	private int memberCode;
	private int groupCode;
	private String groupLeaderyn;
	
	public GroupMemberVO() {}

	public GroupMemberVO(int memberCode, int groupCode, String groupLeaderyn) {
		super();
		this.memberCode = memberCode;
		this.groupCode = groupCode;
		this.groupLeaderyn = groupLeaderyn;
	}

	public int getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(int memberCode) {
		this.memberCode = memberCode;
	}

	public int getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(int groupCode) {
		this.groupCode = groupCode;
	}

	public String getGroupLeaderyn() {
		return groupLeaderyn;
	}

	public void setGroupLeaderyn(String groupLeaderyn) {
		this.groupLeaderyn = groupLeaderyn;
	}

	@Override
	public String toString() {
		return "GroupMember [memberCode=" + memberCode + ", groupCode=" + groupCode + ", groupLeaderyn=" + groupLeaderyn
				+ "]";
	}

}
