package com.kh.groumoa.report.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static com.kh.groumoa.common.CustomUtil.inst;

import com.kh.groumoa.common.PageInfo;
import com.kh.groumoa.notice.model.service.NoticeService;
import com.kh.groumoa.notice.model.vo.NoticeVo;
import com.kh.groumoa.report.model.service.ReportService;
import com.kh.groumoa.report.model.vo.ReportVo;

/**
 * Servlet implementation class SelectReportListServlet
 */
@WebServlet("/selectList.re")
public class SelectReportListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectReportListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
								
		int currentPage;
		int limit;
		int nowPage = 0;
		ReportService rs = new ReportService();			
		currentPage= 1;
		if(request.getParameter("currentPage") != null) {
			/*String str = (String) request.getParameter("currentPage");
			currentPage = Integer.parseInt(str);*/
			currentPage = Integer.parseInt(request.getParameter("currentPage"));	
			nowPage = Integer.parseInt(request.getParameter("currentPage"));
			
			currentPage = nowPage;
		}		
		limit = 10;
		int listCount = rs.getListCount();
		
		PageInfo pi = inst().getPageInfo(currentPage, limit, listCount);
		
		ArrayList<ReportVo> reList = rs.selectList(pi);	
		
		
		String page = "";
		
		if(reList != null) {
			page = "views/manager/report/reportList.jsp";
			request.setAttribute("list", reList);
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
