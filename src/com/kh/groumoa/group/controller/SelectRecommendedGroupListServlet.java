package com.kh.groumoa.group.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.groumoa.group.model.service.GroupService;
import com.kh.groumoa.group.model.vo.GroupVO;
import com.kh.groumoa.member.model.vo.MemberVO;

/**
 * Servlet implementation class SelectRecommendedGroupListServlet
 */
@WebServlet("/selectRecommendedList.gr")
public class SelectRecommendedGroupListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectRecommendedGroupListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberVO loginUser = (MemberVO) request.getSession().getAttribute("loginUser");
		
			ArrayList<GroupVO> recommendedGroupList = new GroupService().selectRecommendedGroupList(loginUser);

		
			String page = "";
		
		
			page = "views/group/recommendedGroupList.jsp";
			//request.setAttribute("recommendedGroupList", recommendedGroupList);
		System.out.println(recommendedGroupList);
//			else {
//			page = "views/common/errorPage.jsp";
//			request.setAttribute("msg", "내 동호회 조회 실패");//새로운 로직 생각하기
//		}
		//request.getRequestDispatcher(page).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
