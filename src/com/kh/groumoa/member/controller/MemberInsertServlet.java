package com.kh.groumoa.member.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.groumoa.member.model.service.MemberService;
import com.kh.groumoa.member.model.vo.MemberInterestVO;
import com.kh.groumoa.member.model.vo.MemberVO;

/**
 * Servlet implementation class MemberInsertServlet
 */
@WebServlet("/insert.me")
public class MemberInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//매개변수 받아오기 ...
		String email = request.getParameter("email");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		String phoneHead = request.getParameter("phoneHead");
		String tel1 = request.getParameter("tel1");
		String tel2 = request.getParameter("tel2");
		String phone = phoneHead + "-" + tel1 + "-" + tel2;
		String rnCode = request.getParameter("rnCode"); // 주소 api 사용시 수정
		String address = request.getParameter("address"); // 주소 api 사용시 수정
		String gender = request.getParameter("gender");
		String birthDate = request.getParameter("birthDate");
		
		
		MemberVO requestMember = new MemberVO();
		requestMember.setEmail(email);
		requestMember.setUserPwd(userPwd);
		requestMember.setUserName(userName);
		requestMember.setPhone(phone);
		requestMember.setRnCode(rnCode);
		requestMember.setAddress(address);
		requestMember.setGender(gender);
		requestMember.setBirthDate(birthDate);
		
		String[] iarr = request.getParameterValues("interest");
		
		ArrayList<MemberInterestVO> requestMemberInterest = new ArrayList<MemberInterestVO>();
		for(int i = 0; i < iarr.length; i++) {
			MemberInterestVO memberInterest = new MemberInterestVO();
			memberInterest.setInterestCode(iarr[i]);
			
			requestMemberInterest.add(memberInterest);
		}
		
		int result = new MemberService().insertMember(requestMember, requestMemberInterest);
		
		String page = "";
		if(result > 0) {
			page = "/views/common/successPage.jsp";
			//response.sendRedirect(page);
			request.setAttribute("successCode", "insertMember");
			request.getRequestDispatcher(page).forward(request, response);
		} else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "회원 가입 실패!");
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
