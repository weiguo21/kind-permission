/**
 * Project Name:kind-common-base
 * File Name:BaseDaoMybatis.java
 * Package Name:com.kind.common.persistence
 * Date:2016-4-28下午4:13:07
 * Copyright (c) 2016, http://www.kindapp.net All Rights Reserved.
 *
 */
package com.kind.common.persistence;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 
 * Function:mybatis基类接口. <br/>
 * 
 * @author weiguo21
 * @version:@param <T>
 * @version:@param <PK>
 * @since:JDK 1.7
 */
@SuppressWarnings("rawtypes")
public interface BaseDaoMybatis<T, PK extends Serializable> {
	/**
	 * 影响记录条数.
	 * 
	 * @param statementName
	 * @param rows
	 *            受影响的记录数
	 * @return
	 */
	public int insert(String statementName, T t);

	/**
	 * 修改一条记录.
	 * 
	 * @param statementName
	 * @param entity
	 *            修改的对象个数，正常情况=1
	 * @return
	 */
	public int update(String statementName, T t);

	/**
	 * 修改符合条件的记录.
	 * 
	 * @param statementName.
	 * @param param参数值包括WHERE条件目标字段和新值等.
	 * 
	 * @return 修改的记录个数
	 */
	public int updateByMap(String statementName, Map<?, ?> param);

	/**
	 * 按主键删除记录.
	 * 
	 * @param primaryKey
	 * @return 删除的对象个数，正常情况=1
	 */
	public int delete(String statementName, PK pk);

	/**
	 * 删除符合条件的记录.
	 * <p>
	 * <strong>此方法一定要慎用，如果条件设置不当，可能会删除有用的记录./strong>
	 * </p>
	 * 
	 * @param param
	 * @return
	 */
	public int deleteByMap(String statementName, Map<?, ?> params);

	/**
	 * 查询符合条件的记录数.
	 * 
	 * @param param
	 * 
	 * @return
	 */
	public int count(String statementName, Object object);

	/**
	 * 按主键取记录.
	 * 
	 * @param primaryKey
	 *            主键值.
	 * 
	 * @return 记录实体对象，如果没有符合主键条件的记录，则返回null.
	 */
	public T getById(String statementName, PK pk);

	/**
	 * 按条件查询记录
	 * 
	 * @return 全部记录实体对象的List
	 */
	public List<T> query(String statementName, Object o);

	/**
	 * 按条件查询记录.
	 * 
	 * @param param
	 *            查询条件参数
	 * @return
	 */
	public List<?> queryForList(String statementName, Object o);

	/**
	 * 按条件查询记录.
	 * 
	 * @param param
	 *            查询条件参数
	 * @return
	 */
	public List<T> queryByMap(String statementName, Map<?, ?> param);

	/**
	 * 批量插入.
	 * 
	 * @param statementName
	 * @param list
	 * @return
	 */
	public int batchInsert(String statementName, final List list);

	/**
	 * 批量修改
	 * 
	 * @param statementName
	 * @param list
	 * @return
	 */
	public int batchUpdate(String statementName, List list);

	/**
	 * 批量删除.
	 * 
	 * @param statementName
	 * @param list
	 * @return
	 */
	public int batchDelete(String statementName, final List list);
}
