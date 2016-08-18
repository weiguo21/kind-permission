/**
 * Project Name:kind-common-base
 * File Name:KindResult.java
 * Package Name:com.kind.common.dto
 * Date:2016年6月27日下午6:01:04
 * Copyright (c) 2016, http://www.kindapp.net All Rights Reserved.
 *
*/
package com.kind.common.dto;

import java.util.List;

/**
 * Function:DataGridResult. <br/>
 * Date: 2016年6月28日 下午7:19:21 <br/>
 * 
 * @author weiguo21
 * @version
 * @since JDK 1.7
 * @see
 */
public class KafaDataGrid {
	public KafaDataGrid() {
		super();
	}

	public KafaDataGrid(List<?> rows, Long total) {
		super();
		this.rows = rows;
		this.total = total;
	}

	/**
	 * 当前页记录数
	 */
	private List<?> rows;
	/**
	 * 总数
	 */
	private Long total;

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

}
