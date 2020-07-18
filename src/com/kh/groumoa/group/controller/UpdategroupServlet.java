package com.kh.groumoa.group.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.groumoa.common.MyFileRenamePolicy;
import com.kh.groumoa.group.model.service.GroupService;
import com.kh.groumoa.group.model.vo.GroupVO;
import com.oreilly.servlet.MultipartRequest;

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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
