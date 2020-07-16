package com.kh.groumoa.common;

public class PageInfo {
	int limit;
	int currentPage;
	int maxPage;
	int startPage;
	int endPage;
	int totalCount;
	
	
	public PageInfo() {
		
	}	

	public PageInfo(int limit, int currentPage, int maxPage, int startPage, int endPage, int totalCount) {
		super();
		this.limit = limit;
		this.currentPage = currentPage;
		this.maxPage = maxPage;
		this.startPage = startPage;
		this.endPage = endPage;
		this.totalCount = totalCount;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	@Override
	public String toString() {
		return "PageInfo [limit=" + limit + ", currentPage=" + currentPage + ", maxPage=" + maxPage + ", startPage="
				+ startPage + ", endPage=" + endPage + ", totalCount=" + totalCount + "]";
	}
	
	
}
