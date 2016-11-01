/**
 * Project Name:kind-common-base
 * File Name:BaseDaoMyBatisImpl.java
 * Package Name:com.kind.common.persistence.mybatis
 * Date:2016-4-28下午4:13:07
 * Copyright (c) 2016, http://www.kindapp.net All Rights Reserved.
 *
 */
package com.kind.common.persistence.mybatis;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kind.common.persistence.BaseDaoMybatis;

/**
 * 
 * Function:mybatis基类实现. <br/>
 * 
 * @author weiguo21
 * @version:@param <T>
 * @version:@param <PK>
 * @since:JDK 1.7
 */
@SuppressWarnings("rawtypes")
public class BaseDaoMyBatisImpl<T, PK extends Serializable> extends SqlSessionDaoSupport
		implements BaseDaoMybatis<T, PK> {
	protected Logger logger = LoggerFactory.getLogger(getClass());

	protected static final int PAGE_SIZE = 10;

	protected static final Object[] NO_ARGUMENTS = new Object[0];

	@Resource
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}

	@Override
	public int insert(String statementName, T t) {
		int rows = getSqlSession().insert(statementName, t);
		return rows;
	}

	@Override
	public int update(String statementName, T t) {
		int rows = getSqlSession().update(statementName, t);
		return rows;
	}

	@Override
	public int updateByMap(String statementName, Map<?, ?> params) {
		int rows = getSqlSession().update(statementName, params);
		return rows;

	}

	@Override
	public int delete(String statementName, PK pk) {
		int rows = getSqlSession().delete(statementName, pk);
		return rows;
	}

	@Override
	public int deleteByMap(String statementName, Map<?, ?> params) {
		int rows = getSqlSession().delete(statementName, params);
		return rows;
	}

	@Override
	public int count(String statementName, Object object) {
		int result = 0;
		result = (Integer) getForObject(statementName, object);
		return result;
	}

	@Override
	public T getById(String statementName, PK pk) {
		return getSqlSession().selectOne(statementName, pk);
	}

	public Object getForObject(String statementName, Object o) {
		return getSqlSession().selectOne(statementName, o);
	}

	@Override
	public List<T> query(String statementName, Object o) {
		return getSqlSession().selectList(statementName, o);

	}

	@Override
	public List<?> queryForList(String statementName, Object o) {
		return getSqlSession().selectList(statementName, o);
	}

	@Override
	public List<T> queryByMap(String statementName, Map<?, ?> map) {
		return getSqlSession().selectList(statementName, map);
	}

	@Override
	public int batchInsert(String statementName, List list) {
		return getSqlSession().insert(statementName, list);
	}

	@Override
	public int batchUpdate(String statementName, List list) {
		return getSqlSession().update(statementName, list);
	}

	@Override
	public int batchDelete(String statementName, List list) {
		return getSqlSession().delete(statementName, list);
	}

	/**
	 * 输出SQL日志.
	 * 
	 * @param sqlId
	 * @param param
	 */
	public void trace(String statementName, Object param) {
		Configuration configuration = getSqlSession().getConfiguration();
		/**
		 * sqlId为配置文件中的sqlId
		 */
		MappedStatement mappedStatement = configuration.getMappedStatement(statementName);
		/**
		 * 参数为传入到SQL语句中的参数.
		 */
		BoundSql boundSql = mappedStatement.getBoundSql(param);
		/**
		 * 得到SQL语句
		 */
		String sql = boundSql.getSql().trim();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		logger.info("info-sql: " + sdf.format(new Date()) + "  " + sql);
	}

	public boolean isDebugEnabled() {
		return true;
	}

}
