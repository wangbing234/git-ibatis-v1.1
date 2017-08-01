/*
 * Powered By [rapid-framework]
 *  copyright © 趋快科技(武汉)有限公司
 * Since 2017 - 2017
 */

package com.qk.core.module.user.dao.impl;


import org.springframework.stereotype.Component;
import com.qk.core.ibatis.dao.impl.BaseDaoImpl;
import com.qk.core.module.user.dao.UserDao;

import com.qk.core.module.user.entity.User;



/**
 *   dao实现类
 * @author rapid-code
 * @version 1.0
 * @since 1.0
 * */
@Component("userDaoSystem")
public class UserDaoImpl extends  BaseDaoImpl<User> implements UserDao {

}
