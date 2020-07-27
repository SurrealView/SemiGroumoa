package com.kh.groumoa.group.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.groumoa.common.model.vo.AttachmentVo;
import com.kh.groumoa.group.model.service.GroupService;
import com.kh.groumoa.group.model.vo.GroupVO;

/**
 * Servlet implementation class SelectOneGroupAsLeaderServlet
 */
@WebServlet("/selectOneAsLeader.gr")
public class SelectOneGroupAsLeaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectOneGroupAsLeaderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int groupCode = Integer.parseInt(request.getParameter("groupCode"));
		
		GroupVO requestGroup = new GroupVO();
		requestGroup.setGroupCode(groupCode);
		
		GroupVO selectedGroup = new GroupService().selectOneGroup(requestGroup);

		AttachmentVo attach = new GroupService().selectAttachment(requestGroup.getGroupCode());
		
		if(selectedGroup != null) {
			request.getSession().setAttribute("selectedGroup", selectedGroup);
			request.getSession().setAttribute("thumbnail", attach);
			response.sendRedirect("views/group/groupMainPageAsLeader.jsp");//동호회메인페이지로 경로 변경 필요
		} else {
			request.setAttribute("msg", "그룹 페이지 보이기 실패!");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
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
