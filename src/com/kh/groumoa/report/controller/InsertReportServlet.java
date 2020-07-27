package com.kh.groumoa.report.controller;

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
import com.kh.groumoa.common.model.vo.AttachmentVo;
import com.kh.groumoa.member.model.service.MemberService;
import com.kh.groumoa.report.model.service.ReportService;
import com.kh.groumoa.report.model.vo.ReportVo;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class InsertReportServlet
 */
@WebServlet("/insert.re")
public class InsertReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		if(ServletFileUpload.isMultipartContent(request)) {
			int maxSize = 1024 * 1024 * 10;
			String savePath = request.getSession().getServletContext().getRealPath("/") + "upload_reportFiles/";
			
			String fileStr = request.getParameter("report_upload");
			
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			ArrayList<String> saveFiles = new ArrayList<>();
			ArrayList<String> originFiles = new ArrayList<>();
			
			Enumeration<String> files = multiRequest.getFileNames();
			
			while(files.hasMoreElements()) {
				String name = files.nextElement();
				
				saveFiles.add(multiRequest.getFilesystemName(name));
				originFiles.add(multiRequest.getOriginalFileName(name));
			}
			
			String multiTitle = multiRequest.getParameter("reTitle");
			String multiContent = multiRequest.getParameter("reContent");
			//String multiWriter = multiRequest.getParameter("noManager");
			String reStr = multiRequest.getParameter("reporter");
			int reporter = Integer.parseInt(reStr);
			//int reported = Integer.parseInt(multiRequest.getParameter("reported"));
			int reported = new MemberService().getMemberCode(multiRequest.getParameter("reported"));
			String category = multiRequest.getParameter("kind");
			
			ReportVo re = new ReportVo();
			
			re.setReportTitle(multiTitle);
			re.setReportDetail(multiContent);
			//no.setMnWriterID(multiWriter);			
			//no.setMnWriterID("M1");
			//no.setMnWriterCode("M1");
			re.setReporter(reporter);
			re.setReported(reported);
			re.setReportCategory(category);
			
			ArrayList<AttachmentVo> attachList = new ArrayList<>();
			
			for(int i = 0; i < saveFiles.size(); i++) {
				AttachmentVo attach = new AttachmentVo();
				
				attach.setChangeName(saveFiles.get(i));
				attach.setOriginName(originFiles.get(i));
				attach.setFilePath(savePath);
				
				attachList.add(attach);
			}
			
			int result = new ReportService().insertReport(re, attachList);
			
			String page= request.getContextPath() + "/selectList.re";
			if(result > 0) {
				response.sendRedirect(page);
			} else {
				
			}
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
