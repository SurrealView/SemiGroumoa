package com.kh.groumoa.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.groumoa.notice.model.service.NoticeService;

/**
 * Servlet implementation class DeleteNoticeServlet
 */
@WebServlet("/delete.no")
public class DeleteNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteNoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] list = request.getParameterValues("ckNotice");
				
		int result = 0;
		
		/*if(list == null || list.length == 0) {
			noEvent = true;
		}*/
		
		result = new NoticeService().deleteNotice(list);		
					//request.getContextPath() + "/selectList.no"
		String page= request.getContextPath() + "/selectList.no";
		
		if(result == list.length) {
			response.sendRedirect(page);
		} else {
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
}
