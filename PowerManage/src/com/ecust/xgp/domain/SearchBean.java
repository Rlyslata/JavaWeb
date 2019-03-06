package com.ecust.xgp.domain;

import java.util.List;
import java.util.Map;

public class SearchBean {
	private String field;
	private int currentPage;//当前页码(将要查询的页)
	private int rawNum;//查询最大行数
	private int maxLines;//结果集最大行数
//	private int start;//查询记录起始行=(currentpage-1)*rawNum
//	private int lastPage;//上一页=currentPage-1>=1
//	private int afterPage;//后一页=currentPage+1<=maxLines/rawNum+1
	private List<Map<String,Object>> beanlist;
	public SearchBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SearchBean(String field,int currentPage, int rawNum, int maxLines, List<Map<String, Object>> beanlist) {
		super();
		this.field=field;
		this.currentPage = currentPage;
		this.rawNum = rawNum;
		this.maxLines = maxLines;
		this.beanlist = beanlist;
	}
	
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field=field;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getRawNum() {
		return rawNum;
	}
	public void setRawNum(int rawNum) {
		this.rawNum = rawNum;
	}
	public int getMaxLines() {
		return maxLines;
	}
	public void setMaxLines(int maxLines) {
		this.maxLines = maxLines;
	}
	public int getStart() {
		return (currentPage-1)*rawNum;
	}
	public int getLastPage() {
		int lastPage=currentPage-1;
		return lastPage>=1?lastPage:1;
	}
	public int getAfterPage() {
		int afterPage=currentPage+1;
		return afterPage<=this.getMaxPage()?afterPage:this.getMaxPage();
	}
	public int getMaxPage() {
		int maxPage;
		if(maxLines<rawNum)
			maxPage=1;
		else {
			if(maxLines%rawNum==0)
				maxPage=maxLines/rawNum;
			else
				maxPage=maxLines/rawNum+1;
		}
		return maxPage;
	}
	public List<Map<String, Object>> getBeanlist() {
		return beanlist;
	}
	public void setBeanlist(List<Map<String, Object>> beanlist) {
		this.beanlist = beanlist;
	}
	@Override
	public String toString() {
		return "SearchBean [field=" + field + ", currentPage=" + currentPage + ", rawNum=" + rawNum + ", maxLines="
				+ maxLines + ", beanlist=" + beanlist + "start="+this.getStart()+
				"lastPage="+this.getLastPage()+"afterPage="+this.getAfterPage()+
				"maxPage="+this.getMaxPage()+"]";
		
	}
}
	
	
	
