package com.demo.dao;

import java.io.Serializable;
import java.util.List;

import com.demo.page.Page;

/**
 * 
 * @Description : Dao接口
 * @author : liwenjian
 * @version : 1.0
 * @Date : 2016年1月28日 下午3:17:27
 * @param <T>
 * @param <PK>
 */
public interface BaseDao<T, PK extends Serializable> {

	/**
	 * 
	 * @function: 保存
	 * @param entity
	 * @return int
	 * @exception @author:liwenjian
	 * @since 1.0.0
	 */
	public int insert(T entity);

	/**
	 * 
	 * @function: 更新
	 * @param entity
	 * @return int
	 * @exception @author:liwenjian
	 * @since 1.0.0
	 */
	public int update(T entity);

	/**
	 * 
	 * @function: 删除
	 * @param primaryKey主键
	 * @return int
	 * @exception @author:liwenjian
	 * @since 1.0.0
	 */
	public int delete(PK primaryKey);

	/**
	 * 
	 * @function: 根据主键ID查询
	 * @param primaryKey
	 *            主键
	 * @return T
	 * @exception @author:liwenjian
	 * @since 1.0.0
	 */
	public T get(PK primaryKey);

	/**
	 * 取全部记录
	 * 
	 * @return List<T> 全部记录实体对象的List
	 * @exception @author:liwenjian
	 * @since 1.0.0
	 */
	public List<T> select();

	/**
	 * 根据实体条件查询列表
	 * 
	 * @param entity
	 * @return
	 */
	public List<T> findList(T entity);
	
	/**
	 * 根据页面查询分页
	 * @param page
	 * @return
	 */
	public Page<T> findByPage(Page<T> page);

}
