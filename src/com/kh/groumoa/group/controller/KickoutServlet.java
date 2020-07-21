package com.kh.groumoa.group.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.groumoa.group.model.service.GroupService;
import com.kh.groumoa.group.model.vo.GroupMemberVO;
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
		String Code = request.getParameter("memberCode");
		String groupCode = request.getParameter("groupCode");
		
		int memberCode = 0;
		if(Code != "" && Code != null) {
			memberCode = Integer.parseInt(Code);
		}
		
		int result = new GroupService().kickOut(memberCode);
		
		ArrayList<GroupMemberVO> list = new GroupService().selectList(groupCode);
		
		String page = "";
		if(result > 0) {
			if(list != null) {
				page = "views/group/groupPplManagement.jsp";
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
