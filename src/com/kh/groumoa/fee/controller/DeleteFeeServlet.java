package com.kh.groumoa.fee.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.groumoa.fee.model.service.FeeService;
import com.kh.groumoa.fee.model.vo.FeeVO;
import com.kh.groumoa.group.model.vo.GroupVO;

/**
 * Servlet implementation class DeleteFeeServlet
 */
@WebServlet("/delete.fee")
public class DeleteFeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteFeeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		GroupVO group = (GroupVO) request.getSession().getAttribute("selectedGroup");
		int groupCode = group.getGroupCode();
		
		System.out.println("test groupCode : " + groupCode);
		
		String[] arr = request.getParameterValues("feeCode");
		System.out.println("test arr : " + arr);

		ArrayList<FeeVO> requestFeeArray = new ArrayList<FeeVO>();
		for (int i = 0; i < arr.length; i++) {
			FeeVO f = new FeeVO();
			f.setGroupCode(groupCode);
			f.setFeeCode(Integer.parseInt(arr[i]));
			requestFeeArray.add(f);
		}

		int result = new FeeService().deleteFee(requestFeeArray);

		String page = "";
		if (result > 0) {
			page = "/views/common/successPage.jsp";
			request.setAttribute("successCode", "deleteFee");// successPage에 delete에 해당하는 속성값 만들기
			request.getRequestDispatcher(page).forward(request, response);
		} else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "회비 내역 삭제 실패!");
			request.getRequestDispatcher(page).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
