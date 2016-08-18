
package com.kind.perm.core.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kind.common.persistence.mybatis.BaseDaoMyBatisImpl;
import com.kind.perm.core.dao.UserDao;
import com.kind.perm.core.domain.UserDO;
import com.kind.perm.core.dto.request.UserQueryRequest;

/**
 * 
 * Function:用户数据访问实现. <br/>
 * 
 * @date:2016年6月12日 下午14:06:08 <br/>
 * @author weiguo.liu
 * @version:
 * @since:JDK 1.7
 */
@Repository("userDao")
public class UserDaoImpl extends BaseDaoMyBatisImpl<UserDO, Serializable> implements UserDao {

	@Override
	public UserDO getUser(String username) {
		return (UserDO) super.getForObject(NAMESPACE + "getByUsername", username);
	}

	@Override
	public void saveUser(UserDO userDO) {
		super.insert(NAMESPACE + "save", userDO);
	}

	@Override
	public void changePassword(UserDO userDO) {
		super.update(NAMESPACE + "change", userDO);
	}

	@Override
	public List<UserDO> page(UserQueryRequest request) {
		return super.query(NAMESPACE + "page", request);
	}

	@Override
	public int count(UserQueryRequest request) {
		return super.count(NAMESPACE + "count", request);
	}

	@Override
	public UserDO getById(Long id) {
		return super.getById(NAMESPACE + "getById", id);
	}

	@Override
	public void change(UserDO userDO) {
		super.update(NAMESPACE + "change", userDO);
	}

	@Override
	public void remove(Long id) {
		super.delete(NAMESPACE + "removeById", id);
	}


}
