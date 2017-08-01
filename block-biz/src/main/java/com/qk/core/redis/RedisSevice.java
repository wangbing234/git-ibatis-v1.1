package com.qk.core.redis;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import com.alibaba.fastjson.JSON;
import com.qk.core.module.user.entity.User;

/**
 * redis服务
 * @author bing.wang
 *
 */
public class RedisSevice {
	//日志对象
	private  final Logger logger = LoggerFactory.getLogger(this.getClass());
	//redis模板
	private RedisTemplate<String, Object> redisTemplate;
	//互捐系统用户的标识字段
	public static final String ADMIN_USER="admin_user";
    //商城系统用户的标识字段
    public final String SHOP_USER="SHOP_USER";
    //前端用户对应token字段
    public final String USER_TOKEN_MAPPING="USER_TOKEN_MAPPING";
   //后端
    public final String MANAGER_TOKEN_MAPPING="Manager_TOKEN_MAPPING";
    //session 超时时间
    private final Integer SESSION_TIMEOUT=7;
	
	public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
	
//	/**-----------------------------后端用户--------------------------------------------**/
//
//	/**
//	 * 创建token
//	 * @param token
//	 * @param mebId
//	 */
//	public void createUserToken(String token,User user){
//		// 添加 一个 hash集合
//		HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
//		hash.put(token,ADMIN_USER, JSON.toJSONString(user));
//		addUserTokenMapping(user.getId()+"", token);
//		logger.info("创建token："+token);
//	}
//	
//	 /**
//	  * 增加用户和token对应
//	  * @param token
//	  * @param key
//	  * @param obj
//	  */
//	 public void addUserTokenMapping(String userID,String token){
//		HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
//		Object oldToken=hash.get(USER_TOKEN_MAPPING, userID);
//		if(oldToken!=null) {
//			redisTemplate.delete(oldToken.toString());
//		}
//		hash.put(USER_TOKEN_MAPPING, userID, token);
//	 }
//	
//	/**
//	 * 创建token
//	 * @param token
//	 * @param mebId
//	 */
//	public User checkUserToken(String token){
//		 if (StringUtils.isBlank(token)) {
//	            return null;
//	      }
//		 HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
//		 Object tokenObject = hash.get(token, ADMIN_USER);
//		 if (null==tokenObject) {
//	            return null;
//	      }
//		 redisTemplate.boundHashOps(token).expire(SESSION_TIMEOUT, TimeUnit.DAYS);
//	     return JSON.parseObject(tokenObject.toString(), User.class);
//	}
//	
//	
//	/**
//	 * 登录退出
//	 * @param token
//	 * @param mebId
//	 */
//	 public void deleteToken(String token) {
//		 redisTemplate.delete(token);
//		 //删除对应关系
//		 HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
//		 hash.delete(USER_TOKEN_MAPPING, token);
//	 }
	 
	 
	 
	 
	 /**-----------------------------后端用户--------------------------------------------**/
	
	 
}
