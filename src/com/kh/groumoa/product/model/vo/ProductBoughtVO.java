package com.kh.groumoa.product.model.vo;

import java.sql.Date;

public class ProductBoughtVO implements java.io.Serializable{
	private String pbCode;
	private int groupCode;
	private Date pbDate;
	private String productCode;
	private int payerCode;
	private Date refundAvailableDate;
	
	private String productDetail;
	private String payerName;
	private int productPrice;
	private String productTerms;

	public ProductBoughtVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductBoughtVO(String pbCode, int groupCode, Date pbDate, String productCode, int payerCode,
			Date refundAvailableDate, String productDetail, String payerName, int productPrice, String productTerms) {
		super();
		this.pbCode = pbCode;
		this.groupCode = groupCode;
		this.pbDate = pbDate;
		this.productCode = productCode;
		this.payerCode = payerCode;
		this.refundAvailableDate = refundAvailableDate;
		this.productDetail = productDetail;
		this.payerName = payerName;
		this.productPrice = productPrice;
		this.productTerms = productTerms;
	}

	public String getPbCode() {
		return pbCode;
	}

	public void setPbCode(String pbCode) {
		this.pbCode = pbCode;
	}

	public int getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(int groupCode) {
		this.groupCode = groupCode;
	}

	public Date getPbDate() {
		return pbDate;
	}

	public void setPbDate(Date pbDate) {
		this.pbDate = pbDate;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public int getPayerCode() {
		return payerCode;
	}

	public void setPayerCode(int payerCode) {
		this.payerCode = payerCode;
	}

	public Date getRefundAvailableDate() {
		return refundAvailableDate;
	}

	public void setRefundAvailableDate(Date refundAvailableDate) {
		this.refundAvailableDate = refundAvailableDate;
	}

	public String getProductDetail() {
		return productDetail;
	}

	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}

	public String getPayerName() {
		return payerName;
	}

	public void setPayerName(String payerName) {
		this.payerName = payerName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductTerms() {
		return productTerms;
	}

	public void setProductTerms(String productTerms) {
		this.productTerms = productTerms;
	}

	@Override
	public String toString() {
		return "ProductBoughtVO [pbCode=" + pbCode + ", groupCode=" + groupCode + ", pbDate=" + pbDate
				+ ", productCode=" + productCode + ", payerCode=" + payerCode + ", refundAvailableDate="
				+ refundAvailableDate + ", productDetail=" + productDetail + ", payerName=" + payerName
				+ ", productPrice=" + productPrice + ", productTerms=" + productTerms + "]";
	}

	
}
