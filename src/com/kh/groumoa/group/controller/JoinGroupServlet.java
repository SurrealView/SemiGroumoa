package com.kh.groumoa.group.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.groumoa.group.model.service.GroupService;
import com.kh.groumoa.group.model.vo.GroupVO;
import com.kh.groumoa.member.model.vo.MemberVO;

/**
 * Servlet implementation class JoinGroupServlet
 */
@WebServlet("/join.gr")
public class JoinGroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinGroupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		GroupVO group = (GroupVO) request.getSession().getAttribute("selectedGroup");
		MemberVO loginUser = (MemberVO) request.getSession().getAttribute("loginUser");
		
		int result = new GroupService().joinGroup(group, loginUser);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
