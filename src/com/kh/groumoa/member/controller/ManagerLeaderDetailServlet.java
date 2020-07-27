package com.kh.groumoa.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Manager;

import com.kh.groumoa.member.model.service.MemberService;
import com.kh.groumoa.member.model.vo.ManagerVO;
import com.kh.groumoa.member.model.vo.MemberVO;

/**
 * Servlet implementation class ManagerLeaderDetailServlet
 */
@WebServlet("/LeaderDetail.ld")
public class ManagerLeaderDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerLeaderDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		
		int nno = 0;
		if(num != "" && num != null) {
			nno = Integer.parseInt(num);
		}
		
		ManagerVO manager = new MemberService().selectLeaderDetail();
		ManagerVO managerD = new MemberService().selectLeaderDetailD(nno);
		
		String page = "";
		if(manager != null) {
			page = "views/manager/m_managerLeaderDetail.jsp";
			request.setAttribute("manager", manager);
			request.setAttribute("managerD", managerD);
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
