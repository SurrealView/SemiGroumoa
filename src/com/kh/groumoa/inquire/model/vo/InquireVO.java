package com.kh.groumoa.inquire.model.vo;

import java.sql.Date;

public class InquireVO implements java.io.Serializable{
	private String Qna_Code;
	private int Questioner_Code;
	private String Qna_Cate_Code;
	private String Qna_Title;
	private String Qna_Detail;
	private Date Qna_Date;
	private String Qna_Reply;
	private String Replier_Code;
	private String Isanswered;
	
	public InquireVO() {}

	public InquireVO(String qna_Code, int questioner_Code, String qna_Cate_Code, String qna_Title, String qna_Detail,
			Date qna_Date, String qna_Reply, String replier_Code, String isanswered) {
		super();
		Qna_Code = qna_Code;
		Questioner_Code = questioner_Code;
		Qna_Cate_Code = qna_Cate_Code;
		Qna_Title = qna_Title;
		Qna_Detail = qna_Detail;
		Qna_Date = qna_Date;
		Qna_Reply = qna_Reply;
		Replier_Code = replier_Code;
		Isanswered = isanswered;
	}

	public String getQna_Code() {
		return Qna_Code;
	}

	public void setQna_Code(String qna_Code) {
		Qna_Code = qna_Code;
	}

	public int getQuestioner_Code() {
		return Questioner_Code;
	}

	public void setQuestioner_Code(int questioner_Code) {
		Questioner_Code = questioner_Code;
	}

	public String getQna_Cate_Code() {
		return Qna_Cate_Code;
	}

	public void setQna_Cate_Code(String qna_Cate_Code) {
		Qna_Cate_Code = qna_Cate_Code;
	}

	public String getQna_Title() {
		return Qna_Title;
	}

	public void setQna_Title(String qna_Title) {
		Qna_Title = qna_Title;
	}

	public String getQna_Detail() {
		return Qna_Detail;
	}

	public void setQna_Detail(String qna_Detail) {
		Qna_Detail = qna_Detail;
	}

	public Date getQna_Date() {
		return Qna_Date;
	}

	public void setQna_Date(Date qna_Date) {
		Qna_Date = qna_Date;
	}

	public String getQna_Reply() {
		return Qna_Reply;
	}

	public void setQna_Reply(String qna_Reply) {
		Qna_Reply = qna_Reply;
	}

	public String getReplier_Code() {
		return Replier_Code;
	}

	public void setReplier_Code(String replier_Code) {
		Replier_Code = replier_Code;
	}

	public String getIsanswered() {
		return Isanswered;
	}

	public void setIsanswered(String isanswered) {
		Isanswered = isanswered;
	}

	@Override
	public String toString() {
		return "InquireVO [Qna_Code=" + Qna_Code + ", Questioner_Code=" + Questioner_Code + ", Qna_Cate_Code="
				+ Qna_Cate_Code + ", Qna_Title=" + Qna_Title + ", Qna_Detail=" + Qna_Detail + ", Qna_Date=" + Qna_Date
				+ ", Qna_Reply=" + Qna_Reply + ", Replier_Code=" + Replier_Code + ", Isanswered=" + Isanswered + "]";
	}
	
}










