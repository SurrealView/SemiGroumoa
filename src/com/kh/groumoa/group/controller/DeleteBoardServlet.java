package com.kh.groumoa.group.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.groumoa.group.model.service.BoardService;
import com.kh.groumoa.group.model.vo.BoardVO;
import com.kh.groumoa.group.model.vo.GroupVO;

/**
 * Servlet implementation class DeleteBoardServlet
 */
@WebServlet("/delete.bo")
public class DeleteBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GroupVO group = (GroupVO) request.getSession().getAttribute("selectedGroup");
		int groupCode = group.getGroupCode();
		System.out.println("test groupCode : " + groupCode);
		String[] parr = request.getParameterValues("postCode");
		System.out.println("test parr : " + parr);
		
		ArrayList<BoardVO> requestBoardArray = new ArrayList<BoardVO>();
		for(int i = 0; i < parr.length; i++) {
			BoardVO b = new BoardVO();
			b.setGroupCode(groupCode);
			b.setPostCode(Integer.parseInt(parr[i]));
			requestBoardArray.add(b);
		}
		
		int result = new BoardService().deleteBoard(requestBoardArray);
		
		String page = "";
		if(result > 0) {
			page = "/views/common/successPage.jsp";
			//response.sendRedirect(page);
			request.setAttribute("successCode", "deleteBoard");//successPage에 delete에 해당하는 속성값 만들기
			request.getRequestDispatcher(page).forward(request, response);
		} else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "게시판 삭제 실패!");
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
