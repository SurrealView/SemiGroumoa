package com.kh.groumoa.scheduler.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.groumoa.member.model.vo.MemberVO;
import com.kh.groumoa.scheduler.model.vo.SchedulerVO;

/**
 * Servlet implementation class InsertSchedulerServlet
 */
@WebServlet("/insert.sch")
public class InsertSchedulerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertSchedulerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String schCode = request.getParameter("schCode");
		String schTitle = request.getParameter("schTitle");
		String schDetail = request.getParameter("schDetail");
		String schDate = request.getParameter("schDate");
//		String dateWritten = request.getParameter("dateWritten"); SYSDATE 사용 예정
		String groupCode = request.getParameter("groupCode");
//		int writerCode = Integer.parseInt(request.getParameter("writerCode"));
		char status = request.getParameter("status").charAt(0);
		
		// writerCode는 로그인유저의 멤버코드에서 받아온다
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		int writerCode = loginUser.getMemberCode();
		
		SchedulerVO schedule = new SchedulerVO();
		schedule.setSchCode(schCode);
		schedule.setSchTitle(schTitle);
		schedule.setSchDetail(schDetail);
//		schedule.setSchDate(schDate);
		
		schedule.setWriterCode(writerCode);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
