package com.kh.groumoa.group.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.groumoa.group.model.service.GroupService;
import com.kh.groumoa.group.model.vo.GroupVO;

/**
 * Servlet implementation class UpdategroupServlet
 */
@WebServlet("/update.gr")
public class UpdategroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdategroupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String groupCode = request.getParameter("groupCode");
		String thumbNail = request.getParameter("thumbNail");
		String description = request.getParameter("description");
		String [] arr = request.getParameterValues("openYn");
		String [] irr = request.getParameterValues("nickNameyn");
		String groupRule = request.getParameter("groupRule");
		String openYn = "";
		if(arr != null) {
			for(int i = 0; i < arr.length; i++) {
				groupRule += arr[i];
			}
		}
		String nickNameyn = "";
		if(irr != null) {
			for(int i = 0; i < irr.length; i++) {
				nickNameyn += irr[i];
			}
		}
		
		GroupVO requestGroup = new GroupVO();
		requestGroup.setGroupCode(groupCode);
		requestGroup.setThumbNail(thumbNail);
		requestGroup.setDescription(description);
		requestGroup.setOpenYn(openYn);
		requestGroup.setNickNameyn(nickNameyn);
		requestGroup.setGroupRule(groupRule);
		
		int result = new GroupService().updateGroup(requestGroup);
		
		GroupVO selectOneGroup = new GroupService().selectOne(groupCode);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
