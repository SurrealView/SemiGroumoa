package com.kh.groumoa.inquire.controller;

import java.io.IOException;
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
@WebServlet(name = "InsertQaServlet", urlPatterns = { "/insert.qa" })
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
		String title = request.getParameter("title");
		String categoryCode = request.getParameter("category");
		int groupCode = Integer.parseInt(request.getParameter("groupCode"));
		int writerCode = Integer.parseInt(request.getParameter("writer"));
		String detail = request.getParameter("detail");

		String requestAttachment = request.getParameter("attachment");//로직 추가해야됨

		InquireVO requestInquire = new InquireVO();
		requestInquire.setTitle(title);
		requestInquire.setCategoryCode(categoryCode);
		requestInquire.setGroupCode(groupCode);
		requestInquire.setWriterCode(writerCode);
		requestInquire.setDetail(detail);

		int result = new InquireService().insertInquire(requestInquire);

		String page = "";

		if(result > 0) {
			response.sendRedirect(request.getContextPath() + "/insert.qa");
		} else {
			request.setAttribute("msg", "공지사항 등록 실패!");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
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
