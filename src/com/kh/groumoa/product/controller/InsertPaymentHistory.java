package com.kh.groumoa.product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.groumoa.product.model.service.ProductService;
import com.kh.groumoa.product.model.vo.ProductBoughtVO;

/**
 * Servlet implementation class InsertPaymentHistory
 */
@WebServlet("/insertHistory.pr")
public class InsertPaymentHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertPaymentHistory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pbCode = request.getParameter("pbCode");
		int payerCode = Integer.parseInt(request.getParameter("payerCode"));
		String productCode = request.getParameter("productCode");
		int groupCode = Integer.parseInt(request.getParameter("groupCode"));
		
		System.out.println(pbCode + " " +  payerCode +  " " +  productCode + " " + groupCode);
		
		ProductBoughtVO requestProduct = new ProductBoughtVO();
		requestProduct.setPbCode(pbCode);
		requestProduct.setPayerCode(payerCode);
		requestProduct.setProductCode(productCode);
		requestProduct.setGroupCode(groupCode);
		
		int result = new ProductService().insertPaymentHistory(requestProduct);
		String resultMsg = "";
		if(result > 0) {
			resultMsg = "결제내역 삽입 성공";
		} else {
			resultMsg = "결제내역 삽입 실패";
		}
		
		
//		response.setContentType("application/json");
//		response.setCharacterEncoding("UTF-8");
//		new Gson().toJson(resultMsg, response.getWriter());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
