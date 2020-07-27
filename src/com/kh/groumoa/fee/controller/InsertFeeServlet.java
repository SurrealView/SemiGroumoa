package com.kh.groumoa.fee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.groumoa.fee.model.service.FeeService;
import com.kh.groumoa.fee.model.vo.FeeVO;
import com.kh.groumoa.group.model.vo.GroupVO;

/**
 * Servlet implementation class InsertFeeServlet
 */
@WebServlet("/insert.fee")
public class InsertFeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertFeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String feeChoose = request.getParameter("feeChoose");
		String feeNum = request.getParameter("feeNum");
		String feeDate = request.getParameter("feeDate");
		String feeDetail = request.getParameter("feeDetail");
		int feeMember = Integer.parseInt(request.getParameter("feeMember"));
		
		GroupVO group = (GroupVO) request.getSession().getAttribute("selectedGroup");
		int groupCode = group.getGroupCode();
		
		FeeVO fee = new FeeVO();
		fee.setGroupCode(groupCode);
		fee.setFee(feeNum);
		if(feeChoose.equals("plus"))
			fee.setFeeCategory("입금");
		else
			fee.setFeeCategory("출금");
		fee.setFeeDate(feeDate);
		fee.setDetail(feeDetail);
		fee.setMemberCode(feeMember);
		
		int result = new FeeService().insertFee(fee);
		
		String page = "";
		if (result > 0) {
			response.sendRedirect(request.getContextPath() + "/selectList.fee");
		} else {
			request.setAttribute("mag", "회비 내역 작성 실패");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
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
