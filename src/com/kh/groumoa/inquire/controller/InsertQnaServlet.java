package com.kh.groumoa.inquire.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.groumoa.group.model.service.BoardService;
import com.kh.groumoa.group.model.vo.BoardVO;
import com.kh.groumoa.inquire.model.service.InquireService;
import com.kh.groumoa.inquire.model.vo.InquireVO;

/**
 * Servlet implementation class InsertQnaServlet
 */
@WebServlet("/insert.qa")
public class InsertQnaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertQnaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("qTitle");
		String categoryCode = request.getParameter("category");
		System.out.println(categoryCode);
		//int groupCode = Integer.parseInt(request.getParameter("groupCode"));
		//int groupCode = 2; //임시
		String temp = request.getParameter("writerCode");
//		System.out.println("temp : " + temp);
		int writerCode = Integer.parseInt(temp);
//		System.out.println("test writerCode : " + writerCode);
		String detail = request.getParameter("qContent");
		
		
		//String requestAttachment = request.getParameter("attachment");//로직 추가해야됨
		
		InquireVO requestInquire = new InquireVO();
		requestInquire.setQna_Title(title);
		requestInquire.setQna_Cate_Code(categoryCode);
		requestInquire.setQuestioner_Code(writerCode);
		requestInquire.setQna_Detail(detail);
		
		int result = new InquireService().insertInquire(requestInquire);
		ArrayList<InquireVO> selectQna = new InquireService().selectInquire();
		String page = "";
		
		if(selectQna != null) {
			page = "/views/group/myInquiry.jsp";
			request.setAttribute("selectQna", selectQna);
			request.getRequestDispatcher(page).forward(request, response);
		}
		
		/* if(result > 0) {
			page = "/views/common/successPage.jsp";
			//response.sendRedirect(page);
			request.setAttribute("successCode", "insertInquire");//successPage에 insertBoard에 해당하는 속성값 만들기
			request.getRequestDispatcher(page).forward(request, response);
		} else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "게시판 작성 실패!");
			request.getRequestDispatcher(page).forward(request, response);
	} */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
