package com.lk.commons.utils;

import java.util.List;

/**
 * 对easyui控件响应结果集进行封装
 * @author Administrator
 *
 */
public class EasyUIDgResult {

	//总记录数
	private long total;
	//返回的结果集
	private List<?> rows;
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	
}
