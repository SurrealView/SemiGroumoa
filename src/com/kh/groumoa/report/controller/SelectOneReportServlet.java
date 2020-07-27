package com.kh.groumoa.report.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.groumoa.common.model.vo.AttachmentVo;
import com.kh.groumoa.report.model.service.ReportService;
import com.kh.groumoa.report.model.vo.ReportVo;

/**
 * Servlet implementation class SelectOneReportServlet
 */
@WebServlet("/selectOne.re")
public class SelectOneReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectOneReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int num = Integer.parseInt(request.getParameter("num"));
		
		String reId = "RE" + num;
		ReportService rs = new ReportService();
		HashMap<String, Object> hmap = rs.selectFileMap(reId);
		
		ReportVo re = (ReportVo) hmap.get("report");
		ArrayList<AttachmentVo> fileList = (ArrayList<AttachmentVo>) hmap.get("attach");						
		
		String page = "";
		
		if(re != null) {
			page = "views/manager/report/reportDetail.jsp";
			request.setAttribute("report", re);
			
			request.setAttribute("fileList", fileList);
			/*if(fileList != null && fileList.size() > 0) {
				request.setAttribute("fileList", fileList);
			}*/
			
		} else {
			
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
