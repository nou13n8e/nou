package com.nou.model;

public class PageDto {
	private int pageTotal;
	private double total;
	private double pagePerList;
	private int pageBlock;
	private int pageStart;
	private int pageEnd;
	
	public PageDto() {
		super();
	}
	
	public PageDto(int pageTotal, double total, double pagePerList, int pageBlock, int pageStart, int pageEnd) {
		super();
		this.pageTotal = pageTotal;
		this.total = total;
		this.pagePerList = pagePerList;
		this.pageBlock = pageBlock;
		this.pageStart = pageStart;
		this.pageEnd = pageEnd;
	}
	
	public int getPageTotal() {
		return pageTotal;
	}
	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}
	public int getTotal() {
		return (int)total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getPagePerList() {
		return (int)pagePerList;
	}
	public void setPagePerList(double pagePerList) {
		this.pagePerList = pagePerList;
	}
	public int getPageBlock() {
		return pageBlock;
	}
	public void setPageBlock(int pageBlock) {
		this.pageBlock = pageBlock;
	}
	public int getPageStart() {
		return pageStart;
	}
	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}
	public int getPageEnd() {
		return pageEnd;
	}
	public void setPageEnd(int pageEnd) {
		this.pageEnd = pageEnd;
	}
}
