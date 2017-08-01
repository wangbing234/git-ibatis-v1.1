/*
 * Powered By [rapid-framework]
 *  copyright © 趋快科技(武汉)有限公司
 * Since 2017 - 2017
 */

package com.qk.core.module.user.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.qk.core.ibatis.service.impl.BaseServiceImpl;
import com.qk.core.module.user.dao.UserDao;
import com.qk.core.module.user.entity.User;
import com.qk.core.module.user.service.UserService;


/**
 *   Service实现类
 * @author rapid-code
 * @version 1.0
 * @since 1.0
 * */
@Service
@Component("userServiceSystem")
public class UserServiceImpl extends BaseServiceImpl<User,UserDao> implements UserService {


}
