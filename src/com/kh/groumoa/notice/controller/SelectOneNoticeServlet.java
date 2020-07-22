package com.kh.groumoa.notice.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.groumoa.common.model.vo.AttachmentVo;
import com.kh.groumoa.notice.model.service.NoticeService;
import com.kh.groumoa.notice.model.vo.NoticeVo;

/**
 * Servlet implementation class SelectOneNoticeServlet
 */
@WebServlet("/selectOne.no")
public class SelectOneNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectOneNoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*int no = Integer.parseInt((String) request.getAttribute("num"));*/
		//int nno = Integer.parseInt((String) request.getAttribute("num"));
		int num = Integer.parseInt(request.getParameter("num"));
		//String noticeId = (String)request.getAttribute("tdId");
		String noticeId = "N" + num;
		
		HashMap<String, Object> hmap = new NoticeService().selectFileMap(noticeId);
		//NoticeVo no = new NoticeService().selectOne(noticeId);
		
		NoticeVo no = (NoticeVo) hmap.get("notice");
		ArrayList<AttachmentVo> fileList = (ArrayList<AttachmentVo>) hmap.get("attach");						
		
		String page = "";
		
		if(no != null) {
			page = "views/manager/notice/noticeDetail.jsp";
			request.setAttribute("notice", no);
			
			if(fileList.size() > 0) {
				request.setAttribute("fileList", fileList);
			}
			
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
