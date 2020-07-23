package com.kh.groumoa.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.groumoa.common.PageInfo;
import com.kh.groumoa.member.model.service.MemberService;
import com.kh.groumoa.member.model.vo.MemberVO;

/**
 * Servlet implementation class ManagerpplServlet
 */
@WebServlet("/managerPpl.mn")
public class ManagerpplServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerpplServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int currentPage; //현제 페이지를 표시할 변수
		int limit;		 //한 페이지에 게시글이 몇 개 보여질 것인지 표시
		int maxPage;	 //전체 페이지에서 가장 마지막 페이지
		int startPage;   //한 번에 표시될 페이지가 시작할 페이지
		int endPage;     //한 번에 표시될 페이지가 끝나는 페이지
		
		currentPage = 1;
		
		//전달받은 request가 있다면 전달받은 값으로 덮어 씀
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		//한 페이지에 보여질 목록 갯수
		limit = 10;
		
		//전체 목록 갯수를 조회
		int listCount = new MemberService().getListCount();
		
		//총 페이지 수 계산
		//예를 들면 목록 갯수가 123개 이면
		//총 필요한 페이지 수는 13개이다.
		maxPage = (int)((double) listCount / limit + 0.9);
		
		//현재 페이지에 보여줄 시작 페이지 수 (10개씩 보여지게 할 경우)
		//아래 쪽 페이지 수가 10개씩 보여진다면
		//1, 11, 21, 31 ...
		startPage = (((int) ((double) currentPage / 10 + 0.9)) - 1) * 10 + 1;
		
		//목록 아래쪽에 보여질 마지막 페이지 수(10, 20, 30, ...)
		endPage = startPage + 10 - 1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(limit, currentPage, maxPage, startPage, endPage, listCount);
		System.out.println(pi);
		ArrayList<MemberVO> list = new MemberService().selectList(pi);
		
		System.out.println("리스트 : " + list);
		
		String page = "";
		if(list != null) {
			page = "views/manager/m_managerppl.jsp";
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
		} else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "회원 조회 실패!");
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
