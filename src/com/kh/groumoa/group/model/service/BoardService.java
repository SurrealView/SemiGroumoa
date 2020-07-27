package com.kh.groumoa.group.model.service;

import static com.kh.groumoa.common.JDBCTemplate.close;
import static com.kh.groumoa.common.JDBCTemplate.commit;
import static com.kh.groumoa.common.JDBCTemplate.getConnection;
import static com.kh.groumoa.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.groumoa.common.PageInfo;
import com.kh.groumoa.group.model.dao.BoardDao;
import com.kh.groumoa.group.model.dao.ReplyDao;
import com.kh.groumoa.group.model.vo.BoardVO;
import com.kh.groumoa.group.model.vo.ReplyVO;



public class BoardService {

	public int insertBoard(BoardVO requestBoard) {
		Connection con = getConnection();
		int result = 0;
		
		
		result = new BoardDao().insertBoard(con, requestBoard);
		
		
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		
		
		return result;
	}



	public int getListCount(BoardVO board) {
		Connection con = getConnection();
		int listCount = new BoardDao().getListCount(con, board);
		
		close(con);

		return listCount;
	}
	
	//페이징 처리 후 게시물 목록 조회
	public ArrayList<BoardVO> selectList(PageInfo pi, BoardVO board) {
		Connection con = getConnection();
		
		ArrayList<BoardVO> list = new BoardDao().selectList(con, pi, board);
		
		close(con);
		
		return list;
	}

	public BoardVO selectOne(int num) {
		Connection con = getConnection();
		
		BoardVO board = null;
		
		int result = 0;
		
		result = new BoardDao().updateCount(con, num);
		board = new BoardDao().selectOne(con, num);
		
		
		
		if(result > 0 && board != null) {
			commit(con);
		} else {
			rollback(con);
			board = null;
		}
		
		close(con);
		
		return board;
	}



	public int getSearchByWriterResultListCount(String search, int groupCode) {
		
		Connection con = getConnection();
		int listCount = new BoardDao().getSearchByWriterResultListCount(con, search, groupCode);
		
		close(con);

		return listCount;
	}



	public ArrayList<BoardVO> selectSearchByWriterResultList(PageInfo pi, int groupCode, String search) {
		Connection con = getConnection();
		
		ArrayList<BoardVO> list = new BoardDao().selectSearchByWriterResultList(con, pi, groupCode, search);
		
		close(con);
		
		return list;
	}



	public int getSearchByTitleResultListCount(String search, int groupCode) {
		
		Connection con = getConnection();
		
		int listCount = new BoardDao().getSearchByTitleResultListCount(con, search, groupCode);
		
		close(con);

		return listCount;
	}



	public ArrayList<BoardVO> selectSearchByTitleResultList(PageInfo pi, int groupCode, String search) {
		
		Connection con = getConnection();
		
		ArrayList<BoardVO> list = new BoardDao().selectSearchByTitleResultList(con, pi, groupCode, search);
		
		close(con);
		
		return list;
	}



	public int getSearchByContentResultListCount(String search, int groupCode) {
		Connection con = getConnection();
		
		int listCount = new BoardDao().getSearchByContentResultListCount(con, search, groupCode);
		
		close(con);

		return listCount;
	}



	public ArrayList<BoardVO> selectSearchByContentResultList(PageInfo pi, int groupCode, String search) {
		Connection con = getConnection();
		
		ArrayList<BoardVO> list = new BoardDao().selectSearchByContentResultList(con, pi, groupCode, search);
		
		close(con);
		
		return list;
	}


	//게시물 n개 삭제
	public int deleteBoard(ArrayList<BoardVO> requestBoardArray) {
		Connection con = getConnection();
		
		int result = 0;
		int[] resultArr = new int[requestBoardArray.size()];
		
		for (int i = 0; i < requestBoardArray.size(); i++) {

			int resultEach = new BoardDao().deleteBoard(con, requestBoardArray.get(i));

			resultArr[i] = resultEach;
		}
		
		for (int i = 0; i < resultArr.length; i++) {
			if (resultArr[i] == 0) {
				result = 0;
				break;
			}
			result = 1;
		}

		if (result != 0) {
			commit(con);
		} else {
			rollback(con);
		}

		close(con);

		return result;
	}




}
