package com.kh.groumoa.group.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.groumoa.group.model.service.ReplyService;
import com.kh.groumoa.group.model.vo.ReplyVO;

/**
 * Servlet implementation class InsertReplyServlet
 */
@WebServlet("/insertReply.bo")
public class InsertReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertReplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int writerCode = Integer.parseInt(request.getParameter("writerCode"));
		int postCode = Integer.parseInt(request.getParameter("postCode"));
		String content = request.getParameter("content");
		
		System.out.println("writerCode : " + writerCode);
		System.out.println("postCode : " + postCode);
		System.out.println("content : " + content);
		
		ReplyVO reply = new ReplyVO();
		reply.setPostCode(postCode);
		reply.setWriterCode(writerCode);
		reply.setDetail(content);
		
		ArrayList<ReplyVO> replyList = new ReplyService().insertReply(reply);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		new Gson().toJson(replyList, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
