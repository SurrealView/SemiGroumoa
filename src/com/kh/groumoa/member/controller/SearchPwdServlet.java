package com.kh.groumoa.member.controller;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.groumoa.common.CustomUtil;
import com.kh.groumoa.common.javamail.JavaMailUtil;
import com.kh.groumoa.member.model.service.MemberService;
import com.kh.groumoa.member.model.vo.MemberVO;

/**
 * Servlet implementation class SearchPwdServlet
 */
@WebServlet("/searchPwd.me")
public class SearchPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchPwdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		
		MemberVO requestMember = new MemberVO();
		requestMember.setEmail(email);
		
		MemberVO responseMember = new MemberService().searchPwd(requestMember);
		
		String msg = "";
		//일치하는 이메일 있을경우 이메일로 변경된 비밀번호 발송하는 로직
		if(responseMember != null) {
			//System.out.println("not null");
			
			String newPwd = new CustomUtil().generateRandomString(8);
			//System.out.println("test newPwd : " + newPwd);
			
			int result = new MemberService().updateMemberPwd(email, newPwd);
			
			System.out.println(result);
			//이메일로 변경된 비밀번호 발송하는 로직 추가
			try {
				JavaMailUtil.sendMail(email, newPwd);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			msg = "이메일로 변경된 이메일을 발송했습니다.";
		} else {
			//System.out.println("null");
			msg = "아이디를 확인해주세요.";
		}
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		new Gson().toJson(msg, response.getWriter());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
