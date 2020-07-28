package com.kh.groumoa.inquire.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.groumoa.common.PageInfo;
import com.kh.groumoa.group.model.service.BoardService;
import com.kh.groumoa.group.model.vo.BoardVO;
import com.kh.groumoa.group.model.vo.GroupVO;
import com.kh.groumoa.inquire.model.service.InquireService;
import com.kh.groumoa.inquire.model.vo.InquireVO;
import com.kh.groumoa.member.model.vo.MemberVO;

/**
 * Servlet implementation class SelectInquireListServlet
 */
@WebServlet("/select.in")
public class SelectInquireListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectInquireListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<InquireVO> selectQna = new InquireService().selectInquire();
	      //System.out.println("selectQna : " + selectQna);
	      String page = "";
	      
	      if(selectQna != null) {
	         page = "/views/group/myInquiry.jsp";
	         request.setAttribute("selectQna", selectQna);
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
