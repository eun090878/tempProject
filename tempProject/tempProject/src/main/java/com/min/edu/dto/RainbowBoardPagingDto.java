package com.min.edu.dto;


public class RainbowBoardPagingDto {

	// 제가 공부했던 방법과 차이가 있어서
	// Dto를 조금 수정했습니다. 
	// 복붙 안했습니다. 다 직접 쳤습니당
	private int page;
	private int countList;
	private int totalCount;
	private int countPage;
	private int totalPage;
	private int startPage;
	private int endPage;

	public RainbowBoardPagingDto() {

	}

	public RainbowBoardPagingDto(int page, int totalCount) {
		this.countList = 5;
		this.countPage = 5;
		this.totalCount = totalCount;
		setPage(page);
		setTotalPage(totalCount);
		setStartPage(page);
		setEndPage(this.countPage);
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if (page > totalPage) {
			page = totalPage;
		}
		if (page < 1) {
			page = 1;
		}
		this.page = page;
	}

	public int getCountList() {
		return countList;
	}

	public void setCountList(int countList) {
		this.countList = countList;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getCountPage() {
		return countPage;
	}

	public void setCountPage(int countPage) {
		this.countPage = countPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalCount) {
		int totalPageResult = totalCount / countList;
		if (totalCount % countList > 0) {
			totalPageResult++;
		}
		this.totalPage = totalPageResult;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int page) {
		int startPageResult = ((page - 1) / countPage) * countPage + 1;
		this.startPage = startPageResult;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int countPage) {
		int endPageResult = startPage + countPage - 1;
		this.endPage = endPageResult;
	}

	@Override
	public String toString() {
		return "PagingDto [page=" + page + ", countList=" + countList + ", totalCount=" + totalCount + ", countPage="
				+ countPage + ", totalPage=" + totalPage + ", startPage=" + startPage + ", endPage=" + endPage + "]";
	}

	
	
	
}
