package com.kh.groumoa.group.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.groumoa.group.model.service.GroupService;
import com.kh.groumoa.group.model.vo.GroupVO;
import com.kh.groumoa.member.model.vo.RegionVO;

/**
 * Servlet implementation class GroupInfo
 */
@WebServlet("/GroupInfo.gi")
public class GroupInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroupInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GroupVO group = (GroupVO) request.getSession().getAttribute("selectedGroup");
		
		RegionVO regionSearch = new GroupService().searchRegion(group.getRnCode());
		System.out.println("테스트2"+regionSearch);
		
		
		String page = "";
		if(regionSearch != null) {
			page = "views/group/groupUpdate.jsp";
/*			request.setAttribute("group", group);
			request.setAttribute("fileList", fileList);*/
			request.setAttribute("regionSearch", regionSearch);/*
			request.setAttribute("selectGroup", selectGroup);
			System.out.println("selectGroup" + selectGroup);*/
/*				response.sendRedirect(request.getContextPath() + "/views/group/groupUpdate.jsp");
*/			} else {
/*			for(int i = 0; i < saveFiles.size(); i++) {
				File failedFile = new File(savePath + saveFiles.get(i));
					
				failedFile.delete();							
			}*/
			
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "동호회 등록 실패!!");
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
