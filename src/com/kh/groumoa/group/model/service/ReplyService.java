package com.kh.groumoa.group.model.service;

import static com.kh.groumoa.common.JDBCTemplate.close;
import static com.kh.groumoa.common.JDBCTemplate.commit;
import static com.kh.groumoa.common.JDBCTemplate.getConnection;
import static com.kh.groumoa.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.groumoa.group.model.dao.BoardDao;
import com.kh.groumoa.group.model.dao.ReplyDao;
import com.kh.groumoa.group.model.vo.ReplyVO;

public class ReplyService {

	public ArrayList<ReplyVO> insertReply(ReplyVO reply) {
		Connection con = getConnection();
		
		int result = new ReplyDao().insertReply(con, reply);
		ArrayList<ReplyVO> replyList = new ReplyDao().selectReplyList(con, reply.getPostCode());
		
		if(result > 0 && replyList != null) {
			commit(con);
		} else {
			rollback(con);
			replyList = null;
		}
		
		close(con);
		
		return replyList;
	}

	public ArrayList<ReplyVO> selectReplyList(int num) {
		Connection con = getConnection();
		
		ArrayList<ReplyVO> replyList = new ReplyDao().selectReplyList(con, num);
		
		close(con);
		
		return replyList;
	}
}
	

