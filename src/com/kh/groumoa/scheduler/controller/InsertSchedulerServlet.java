package com.kh.groumoa.scheduler.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.groumoa.group.model.vo.GroupVO;
import com.kh.groumoa.scheduler.model.service.SchedulerService;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/* String schCode = request.getParameter("schCode"); */
		String schTitle = request.getParameter("schTitle");
		String schDetail = request.getParameter("schDetail");
		String schDate = request.getParameter("schDate");
		int writerCode = Integer.parseInt(request.getParameter("scheMember"));
		GroupVO group = (GroupVO) request.getSession().getAttribute("selectedGroup");
		int groupCode = group.getGroupCode();

		// 스케줄러 객체에 값 입력
		SchedulerVO schedule = new SchedulerVO();
		/* schedule.setSchCode(schCode); */
		schedule.setSchTitle(schTitle);
		schedule.setSchDetail(schDetail);
		schedule.setSchDate(schDate);
		schedule.setGroupCode(groupCode);
		schedule.setWriterCode(writerCode);

		int result = new SchedulerService().insertSchedule(schedule);
		
		ArrayList<SchedulerVO> list = new SchedulerService().selectList(groupCode) ;
		
		System.out.println(list);
		
		String page = "";
		if (result > 0) {
			page = "/views/group/scheduler/groupCalendarManagement.jsp";
			request.setAttribute("schedule", schedule);
			request.setAttribute("list", list);
		} else {
			request.setAttribute("mag", "게시글 작성 실패");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
		request.getRequestDispatcher(page).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
