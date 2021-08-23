package org.zerock.domain;

public class Criteria {
	//	페이지 번호
	private int pageNum;
	//	한 페이지당 데이터 갯수
	private int amount;
	//	Type
	private String type;
	//	Keyword
	private String keyword;
	
	//	기본생성자
	public Criteria() {
		this(1,10);
	}
	//	매개변수 2개인 생성자	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum; 
		this.amount = amount;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	@Override
	public String toString() {
		return "Criteria [pageNum=" + pageNum + ", amount=" + amount + ", type=" + type + ", keyword=" + keyword + "]";
	}
	
}
