package com.sangbill.entity;


import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import lombok.Data;

@Data
public class PageSupport implements Serializable {
	private static final long serialVersionUID = 1L;
	private int pageSize = 0;
	private int pageNo;
	private int pageCount = 0;
	private int recordCount;
	private List items;  //某一分页页的列表数据
	private List records;//所有数据
	
	public PageSupport(List records, List items,int recordCount, int pageSize, int pageNo) {
		this.items = items;
		this.records = records;
		this.pageSize = pageSize;
		this.pageNo = pageNo;
		setRecordCount(recordCount);
	}
	
	public void setRecordCount(int recordCount) {
		if (recordCount > 0) {
			this.recordCount = recordCount;
			this.pageCount = (recordCount - 1) / this.pageSize + 1;
		}
	}
	
	public List getPage(int pageNo){
		if(pageNo <= 0 || pageNo > pageCount || records == null || records.size() == 0){
			return Collections.emptyList();
		}else{
			int fromIndex = (pageNo - 1)*pageSize;
			int toIndex = pageNo*pageSize;
			if(toIndex > recordCount){
				toIndex = recordCount;
			}
			return records.subList(fromIndex, toIndex);
		}
	}
}