package com.kh.groumoa.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.groumoa.member.model.service.MemberService;
import com.kh.groumoa.member.model.vo.MemberVO;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.me")
public class LoginServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
       
    }
    
   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String email = request.getParameter("email");
      String userPwd = request.getParameter("userPwd");
      
      
      MemberVO requestMember = new MemberVO();
      requestMember.setEmail(email);
      requestMember.setUserPwd(userPwd);
      
      MemberVO loginUser = new MemberService().loginCheck(requestMember);
      
      if(loginUser != null) {
         request.getSession().setAttribute("loginUser", loginUser);
         response.sendRedirect("index.jsp");
      } else {
         request.setAttribute("msg", "로그인 실패!");
         request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
      }
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      doGet(request, response);
   }

}