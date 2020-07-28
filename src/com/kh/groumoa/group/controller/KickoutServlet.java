package com.kh.groumoa.group.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.groumoa.common.PageInfo;
import com.kh.groumoa.group.model.service.GroupService;
import com.kh.groumoa.group.model.vo.GroupVO;
import com.kh.groumoa.member.model.dao.MemberDao;
import com.kh.groumoa.member.model.service.MemberService;
import com.kh.groumoa.member.model.vo.MemberVO;

/**
 * Servlet implementation class KickoutServlet
 */
@WebServlet("/kickout.ko")
public class KickoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KickoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GroupVO group = (GroupVO) request.getSession().getAttribute("selectedGroup");
		int groupCode = group.getGroupCode();
		
		System.out.println("test groupCode : " + groupCode);
		
		int memberCode = Integer.parseInt(request.getParameter("memberCode"));
		
		int result = new MemberService().kickOut(memberCode, groupCode);
		System.out.println(memberCode);
		int currentPage; 
		int limit;		 
		int maxPage;	
		int startPage;  
		int endPage;   
		
		currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		limit = 10;
		
		int listCount = new MemberService().getListCount();
		
		maxPage = (int)((double) listCount / limit + 0.9);
		
		startPage = (((int) ((double) currentPage / 10 + 0.9)) - 1) * 10 + 1;
		
		endPage = startPage + 10 - 1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(limit, currentPage, maxPage, startPage, endPage, listCount);
		System.out.println(pi);
		
		ArrayList<MemberVO> list = new MemberService().selectGroupMemberList(pi, memberCode, groupCode);
		
		String page = "";
		if(result > 0) {
			if(list != null) {
				page = "views/member/groupPplManagement.jsp";
				request.setAttribute("list", list);
			} else {
				page = "views/common/errorPage.jsp";
				request.setAttribute("msg", "멤버 추방 실패!");
			}
		} else {
			request.setAttribute("msg", "멤버 추방 실패!");
			request.getRequestDispatcher("views/common/errorPage.jsp");
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
