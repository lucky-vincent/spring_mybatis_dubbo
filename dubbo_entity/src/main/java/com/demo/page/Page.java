package com.demo.page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Page<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8036358745002950680L;

	private static final Integer MIN_PAGE = 1;// 最小页数

	private static final Integer DEFAULT_PAGE_SIZE = 20;// 默认每页显示20条数据

	private static final Integer TOTAL_SIZE = 0;// 总数据数

	/**
	 * 当前页码
	 */
	private Integer currentPage = MIN_PAGE;

	/**
	 * 每页显示数
	 */
	private Integer pageSize = DEFAULT_PAGE_SIZE;

	/**
	 * limit的开始位置
	 */
	private Integer offSet;

	/**
	 * 总数据数
	 */
	private Integer totalSize;

	/**
	 * 实体条件
	 */
	private T condition;

	/** 结果集 */
	private List<T> list = new ArrayList<T>();

	/**
	 * 获取当前页码
	 * 
	 * @return 当前页码
	 */
	public Integer getCurrentPage() {
		if (this.currentPage != null && this.currentPage >= 1) {
			return currentPage;
		}
		return MIN_PAGE;
	}

	/**
	 * 设置当前页码
	 * 
	 * @param currentPage
	 *            当前页码
	 */
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * 获取每页显示数
	 * 
	 * @return 每页显示数
	 */
	public Integer getPageSize() {
		if (this.pageSize != null && this.pageSize >= 1) {
			return this.pageSize;
		}
		return DEFAULT_PAGE_SIZE;
	}

	/**
	 * 设置每页显示数
	 * 
	 * @param pageSize
	 *            每页显示数
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getOffSet() {
		offSet = (this.getCurrentPage() - 1) * this.getPageSize();
		return offSet;
	}

	public void setOffSet(Integer offSet) {
		this.offSet = offSet;
	}

	/**
	 * 获取总条数
	 * 
	 * @return 总条数
	 */
	public Integer getTotalSize() {
		if (this.totalSize != null && this.totalSize >= 0) {
			return this.totalSize;
		}
		return TOTAL_SIZE;
	}

	/**
	 * 设置总条数
	 * 
	 * @param totalSize
	 *            总条数
	 */
	public void setTotalSize(Integer totalSize) {
		this.totalSize = totalSize;
	}

	/**
	 * 获取实体条件
	 * 
	 * @return 实体条件
	 */
	public T getCondition() {
		return condition;
	}

	/**
	 * 设置实体条件
	 */
	public void setCondition(T condition) {
		this.condition = condition;
	}

	/**
	 * 获取结果集
	 * 
	 * @return 结果集
	 */
	public List<T> getList() {
		return list;
	}

	/**
	 * 设置结果集
	 * 
	 * @param list
	 *            结果集
	 */
	public void setList(List<T> list) {
		this.list = list;
	}

}
