package com.kh.groumoa.group.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.groumoa.group.model.vo.GroupVO;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class InsertgroupServlet
 */
@WebServlet("/insert.gr")
public class InsertgroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertgroupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(ServletFileUpload.isMultipartContent(request)) {
			int maxSize = 1024 * 1024 * 10;
			
			String root = request.getSession().getServletContext().getRealPath("/");
			
			String savePath = root + "thumbnail_uploadFiles/";
			
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			ArrayList<String> saveFiles = new ArrayList<>();
			
			ArrayList<String> originFiles = new ArrayList<>();
			
			Enumeration<String> files = multiRequest.getFileNames();
			
			while(files.hasMoreElements()) {
				String name = files.nextElement();
				
				saveFiles.add(multiRequest.getFilesystemName(name));
				originFiles.add(multiRequest.getOriginalFileName(name));
			}
			
			String groupCode = request.getParameter("groupCode");
			String openDate = request.getParameter("openDate");
			String rnCode = request.getParameter("rnCode");
			String name = request.getParameter("name");
			String interest = request.getParameter("interest");
			String description = request.getParameter("description");
			String openYn = request.getParameter("openYn");
			String nickNameyn = request.getParameter("nickNameyn");
			String groupRule = request.getParameter("groupRule");
			
			java.sql.Date date = null;
			
			if(openDate != "") {
				date = java.sql.Date.valueOf(openDate);
			} else {
				date = new java.sql.Date(new GregorianCalendar().getTimeInMillis());
			}
			
			GroupVO group = new GroupVO();
			group.setGroupCode(groupCode);
			group.setOpenDate(date);
			group.setRnCode(rnCode);
			group.setGroupName(name);
			group.setInterestCode(interest);
			
			group.setDescription(description);
			group.setOpenYn(openYn);
			group.setNickNameyn(nickNameyn);
			group.setGroupRule(groupRule);
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
