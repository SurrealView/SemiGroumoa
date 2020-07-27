package com.kh.groumoa.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.groumoa.member.model.service.MemberService;
import com.kh.groumoa.member.model.vo.MemberVO;

/**
 * Servlet implementation class SearchIdServlet
 */
@WebServlet("/searchId.me")
public class SearchIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String phoneHead = request.getParameter("phoneHead");
		String tel1 = request.getParameter("tel1");
		String tel2 = request.getParameter("tel2");
		String phone = phoneHead + "-" + tel1 + "-" + tel2;
		
		//System.out.println(phone);
//		System.out.println("name : " + name);
//		System.out.println("phoneHead : " + phoneHead);
//		System.out.println("tel1 : " + tel1);
//		System.out.println("tel2 : " + tel2);
		
		MemberVO requestMember = new MemberVO();
		requestMember.setUserName(name);
		requestMember.setPhone(phone);
		
		MemberVO responseMember = new MemberService().searchId(requestMember);
		
		
		
		String email = responseMember.getEmail();
		System.out.println(email);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		new Gson().toJson(email, response.getWriter());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
