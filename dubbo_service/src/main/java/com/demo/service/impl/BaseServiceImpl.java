package com.demo.service.impl;

import java.io.Serializable;
import java.util.List;

import com.demo.dao.BaseDao;
import com.demo.page.Page;
import com.demo.service.BaseService;

/**
 * 
 * @Description : 业务实现类
 * @author : liwenjian
 * @version : 1.0
 * @Date : 2016年5月9日 下午2:38:57
 */
public class BaseServiceImpl<T, PK extends Serializable> implements BaseService<T, PK> {

	private BaseDao<T, PK> baseDao;

	public void setBaseDao(BaseDao<T, PK> baseDao) {
		this.baseDao = baseDao;
	}

	public int insert(T entity) {
		return baseDao.insert(entity);
	}

	public int update(T entity) {
		return baseDao.update(entity);
	}

	public int delete(PK primaryKey) {
		return baseDao.delete(primaryKey);
	}

	public T get(PK primaryKey) {
		return baseDao.get(primaryKey);
	}

	public List<T> select() {
		return baseDao.select();
	}

	public List<T> findList(T entity) {
		return baseDao.findList(entity);
	}

	public Page<T> findByPage(Page<T> page) {
		return baseDao.findByPage(page);
	}

}
