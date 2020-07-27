package com.kh.groumoa.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.groumoa.group.model.dao.GroupDao;
import com.kh.groumoa.group.model.service.GroupService;
import com.kh.groumoa.group.model.vo.GroupVO;

/**
 * Servlet implementation class GroupDetailServlet
 */
@WebServlet("/detail.gd")
public class GroupDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroupDetailServlet() {
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
		
		GroupVO group = new GroupService().selectGroup(nno);
		GroupVO groupD = new GroupService().selectGroupD(nno);
		
		String page = "";
		if(group != null) {
			page = "views/manager/m_managerGroupDetail.jsp";
			request.setAttribute("group", group);
			request.setAttribute("groupD", groupD);
		} else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "그룹 상세 조회 실패!");
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
