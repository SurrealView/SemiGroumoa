package com.kh.groumoa.notice.controller;

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
import com.kh.groumoa.notice.model.service.NoticeService;
import com.kh.groumoa.notice.model.vo.NoticeVo;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class InsertNoticeServlet
 */
@WebServlet("/insert.no")
public class InsertNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertNoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//작성자 정보, 게시글 내용, 게시글 제목, 파일 경로 및 파일, 		
		if(ServletFileUpload.isMultipartContent(request)) {
			int maxSize = 1024 * 1024 * 10;
			
			String root = request.getSession().getServletContext().getRealPath("/");
			String savePath = root + "notice_uploadFiles/";
			
			String filestr = request.getParameter("notice_upload");
			
			//이 순간 파일이 생성.
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			ArrayList<String> saveFiles = new ArrayList<>();
			ArrayList<String> originFiles = new ArrayList<>();
			
			Enumeration<String> files = multiRequest.getFileNames();
			
			while(files.hasMoreElements()) {
				String name = files.nextElement();
				
				saveFiles.add(multiRequest.getFilesystemName(name));
				originFiles.add(multiRequest.getOriginalFileName(name));
			}
			
			String multiTitle = multiRequest.getParameter("noTitle");
			String multiContent = multiRequest.getParameter("noContent");
			//String multiWriter = multiRequest.getParameter("noManager");
			String email = multiRequest.getParameter("noEmail");
			String category = multiRequest.getParameter("kind");
			
			//String noticeWriter = ((Manager) (request.getSession().getAttribute("loginUswer"))).getManagerCode();
			
			NoticeVo no = new NoticeVo();
			
			no.setNoticeTitle(multiTitle);
			no.setNoticeDetail(multiContent);
			//no.setMnWriterID(multiWriter);			
			//no.setMnWriterID("M1");
			no.setMnWriterCode("M1");
			no.setNoticeCategory(category);
			
			ArrayList<AttachmentVo> fileList = new ArrayList<>();
			
			for(int i = originFiles.size() - 1; i >= 0; i--) {
				AttachmentVo at = new AttachmentVo();
				
				at.setFid("F" + i);
				at.setFilePath(savePath);
				at.setOriginName(originFiles.get(i));
				at.setChangeName(saveFiles.get(i));
				
				if(i == originFiles.size() - 1) {
				   at.setFileLevel(0);
				}
				else {
					at.setFileLevel(1);
				}
				
				fileList.add(at);
			}			
//			String title = (String)request.getParameter("noTitle");
//			String writer = (String)request.getParameter("noManager");
//			String email = (String)request.getParameter("noEmail");
//			String content = (String)request.getParameter("noContent");
			
			int result = new NoticeService().insertNotice(no, fileList);
			
			if(result > 0) {
				response.sendRedirect(request.getContextPath() + "/selectList.no");
			} else {
				for(int i = 0; i < saveFiles.size(); i++) {
					File failedFile = new File(savePath + saveFiles.get(i));
					
					failedFile.delete();
				}
				
//				/*request.setAttribute("msg", "게시글 등록 실패");
//				request.getRequestDispatcher(path)*/
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
