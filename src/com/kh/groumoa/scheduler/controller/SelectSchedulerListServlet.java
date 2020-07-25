package com.kh.groumoa.scheduler.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.groumoa.group.model.vo.GroupVO;
import com.kh.groumoa.scheduler.model.vo.SchedulerVO;
import com.kh.groumoa.scheduler.model.service.SchedulerService;

/**
 * Servlet implementation class SelectSchedulerListServlet
 */
@WebServlet("/selectList.sch")
public class SelectSchedulerListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectSchedulerListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GroupVO group = (GroupVO) request.getSession().getAttribute("selectedGroup");
		int groupCode = group.getGroupCode(); //그룹 코드 받아오기
		
		System.out.println("groupCode : " + groupCode);
		
		ArrayList<SchedulerVO> list = new SchedulerService().selectScheduleList(groupCode);
		
		System.out.println(list);
		
		String page = "";
		if(list != null) {
			page = "views/group/scheduler/groupCalendar.jsp";
			request.setAttribute("list", list);
		} else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "일정 조회 실패");
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
