package com.kh.groumoa.fee.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.groumoa.common.PageInfo;
import com.kh.groumoa.fee.model.service.FeeService;
import com.kh.groumoa.fee.model.vo.FeeVO;
import com.kh.groumoa.group.model.vo.GroupVO;

/**
 * Servlet implementation class SelectFeeListServlet
 */
@WebServlet("/selectList.fee")
public class SelectFeeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectFeeListServlet() {
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
		
	    GroupVO group = (GroupVO) request.getSession().getAttribute("selectedGroup"); //접속한 동호회 객체 받아오기
		int groupCode = group.getGroupCode();
		
		FeeVO fee = new FeeVO();
		fee.setGroupCode(groupCode);
		
		//전달받은 request가 있다면 전달받은 값으로 덮어 씀
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		//한 페이지에 보여질 목록 갯수
		limit = 10;
		
		//전체 목록 갯수를 조회
		int listCount = new FeeService().getListCount(fee);
		
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
		ArrayList<FeeVO> list = new FeeService().selectList(pi, fee);
		System.out.println(pi);
		System.out.println("testFeeList : " + list);
		String page = "";
		if(list != null) {
			page = "views/group/feeList.jsp";
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
		} else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "회비 내역 조회 실패");
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
