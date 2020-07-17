package com.kh.groumoa.group.model.service;

import java.sql.Connection;

import com.kh.groumoa.group.model.dao.BoardDao;
import com.kh.groumoa.group.model.vo.BoardVO;

import static com.kh.groumoa.common.JDBCTemplate.*;

public class BoardService {

	public int insertBoard(BoardVO requestBoard) {
		Connection con = getConnection();
		int result = 0;
		
		
		int insertBoard = new BoardDao().insertBoard(con, requestBoard);
		
		
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		
		
		return result;
	}

}
