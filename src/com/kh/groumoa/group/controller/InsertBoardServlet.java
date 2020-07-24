package com.kh.groumoa.group.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.groumoa.group.model.service.BoardService;
import com.kh.groumoa.group.model.vo.BoardVO;
import com.kh.groumoa.group.model.vo.GroupVO;

/**
 * Servlet implementation class InsertBoardServlet
 */
@WebServlet("/insert.bo")
public class InsertBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String categoryCode = request.getParameter("category");
		int groupCode = Integer.parseInt(request.getParameter("groupCode"));
		//int groupCode = 2; //임시
		int writerCode = Integer.parseInt(request.getParameter("writerCode"));
		String detail = request.getParameter("content");
		
		
		//String requestAttachment = request.getParameter("attachment");//로직 추가해야됨
		
		BoardVO requestBoard = new BoardVO();
		requestBoard.setTitle(title);
		requestBoard.setCategoryCode(categoryCode);
		requestBoard.setGroupCode(groupCode);
		requestBoard.setWriterCode(writerCode);
		requestBoard.setDetail(detail);
		
		int result = new BoardService().insertBoard(requestBoard);
		
		String page = "";
		if(result > 0) {
			page = "/views/common/successPage.jsp";
			//response.sendRedirect(page);
			request.setAttribute("successCode", "insertBoard");//successPage에 insertBoard에 해당하는 속성값 만들기
			request.getRequestDispatcher(page).forward(request, response);
		} else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "게시판 작성 실패!");
			request.getRequestDispatcher(page).forward(request, response);
	}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
