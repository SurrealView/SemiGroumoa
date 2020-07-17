package com.kh.groumoa.notice.controller;

import static com.kh.groumoa.common.CustomUtil.inst;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.groumoa.common.PageInfo;
import com.kh.groumoa.notice.model.service.NoticeService;
import com.kh.groumoa.notice.model.vo.NoticeVo;
import com.kh.groumoa.payment.model.service.PaymentService;
import com.kh.groumoa.payment.model.vo.PaymentHistoryVo;

/**
 * Servlet implementation class SelectNoticeListServlet
 */
@WebServlet("/selectList.no")
public class SelectNoticeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectNoticeListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int currentPage;
		int limit;
		NoticeService ns = new NoticeService();		
		currentPage= 1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		limit = 10;
		int listCount = ns.getListCount();
		
		PageInfo pi = inst().getPageInfo(currentPage, limit, listCount);
		
		ArrayList<NoticeVo> list = ns.selectList(pi);
		
		String page = "";
			
		if(list != null) {
			page = "views/manager/notice/noticeList.jsp";
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
		} else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "게시판 조회 실패!");
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
