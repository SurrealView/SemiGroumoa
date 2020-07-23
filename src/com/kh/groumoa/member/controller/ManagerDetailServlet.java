package com.kh.groumoa.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.groumoa.member.model.service.MemberService;
import com.kh.groumoa.member.model.vo.MemberVO;

/**
 * Servlet implementation class ManagerDetailServlet
 */
@WebServlet("/detail.mn")
public class ManagerDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		
		MemberVO member = new MemberService().selectMember(num);
		
		String page = "";
		if(member != null) {
			page = "views/manager/m_managerGroupDetail";
			request.setAttribute("member", member);
		} else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "회원 상세 조회 실패!");
		}
		
		request.getRequestDispatcher(page).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
