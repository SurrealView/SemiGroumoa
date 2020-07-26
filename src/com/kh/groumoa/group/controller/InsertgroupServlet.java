package com.kh.groumoa.group.controller;

import java.io.File;
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
import com.kh.groumoa.group.model.vo.Attachment;
import com.kh.groumoa.group.model.vo.GroupVO;
import com.kh.groumoa.member.model.vo.MemberVO;
import com.kh.groumoa.member.model.vo.RegionVO;
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
	        MemberVO loginUser = (MemberVO) request.getSession().getAttribute("loginUser");
	        int groupLeaderCode = loginUser.getMemberCode();
	        
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
	        
	     /*   String groupCode = multiRequest.getParameter("groupCode");*/ 
			String rnCode = multiRequest.getParameter("rnCode");
			String name = multiRequest.getParameter("groupName");
			String description = multiRequest.getParameter("description");
/*			String [] iarr = request.getParameterValues("interest");
*/			String interest = multiRequest.getParameter("interest");
			String openYn = multiRequest.getParameter("openYn");
			String nickNameyn = multiRequest.getParameter("nickNameyn");
			String groupRule = multiRequest.getParameter("groupRule");
			String regionName = multiRequest.getParameter("regionName");
			String regionSpecific = multiRequest.getParameter("regionSpecific");
			
/*			String interest = "";
			if(iarr != null) {
				for(int i = 0; i < iarr.length; i++) {
					interest += iarr[i];
				}
			}
*/			
/*			System.out.println("interest" + interest);
*/		
/*			ArrayList<MemberInterestVO> requestMemberInterest = new ArrayList<MemberInterestVO>();
			for(int i = 0; i < iarr.length; i++) {
				MemberInterestVO memberInterest = new MemberInterestVO();
				memberInterest.setInterestCode(iarr[i]);
				
				requestMemberInterest.add(memberInterest);
			}  */
		
			
			GroupVO group = new GroupVO();
		/*	group.setGroupCode(Integer.parseInt(groupCode));*/
			group.setGroupName(name);
			group.setGroupLeaderCode(groupLeaderCode);
			group.setRnCode(rnCode);
			group.setInterestCode(interest);
			group.setNickNameyn(nickNameyn);
			group.setOpenYn(openYn);
			group.setGroupRule(groupRule);
			group.setDescription(description);
			
			RegionVO region = new RegionVO();
			region.setRnCode(rnCode);
			region.setRegionName(regionName);
			region.setRegionSpecific(regionSpecific);
			
			System.out.println("테스트1" + rnCode);
			ArrayList<Attachment> fileList = new ArrayList<>();
			for(int  i = originFiles.size() - 1; i >= 0; i--) {
				Attachment at = new Attachment();
				
				at.setFilePath(savePath);
				at.setOriginName(originFiles.get(i));
				at.setChangeName(saveFiles.get(i));
				
				if(i == originFiles.size() - 1) {
					at.setFileLevel(0);
				} else {
					at.setFileLevel(1);
				}
				
				fileList.add(at);
			}
			
			int result = new GroupService().insertGroup(group, fileList);
			
			GroupVO selectGroup = new GroupService().selectOne(group.getGroupCode());
			System.out.println("지역코드" + rnCode);
			RegionVO regionSearch = new GroupService().searchRegion(rnCode);
			System.out.println("테스트2"+regionSearch);
			String page = "";
			if(result > 0) {
				page = "views/group/groupUpdate.jsp";
				request.setAttribute("group", group);
				request.setAttribute("fileList", fileList);
				request.setAttribute("regionSearch", regionSearch);
				request.setAttribute("selectGroup", selectGroup);
/*				response.sendRedirect(request.getContextPath() + "/views/group/groupUpdate.jsp");
*/			} else {
				for(int i = 0; i < saveFiles.size(); i++) {
					File failedFile = new File(savePath + saveFiles.get(i));
						
					failedFile.delete();							
				}
				
				page = "views/common/errorPage.jsp";
				request.setAttribute("msg", "동호회 등록 실패!!");
			}
			request.getRequestDispatcher(page).forward(request, response);	
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
