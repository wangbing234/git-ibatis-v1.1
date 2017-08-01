package com.qk.core.domain;

import com.qk.core.module.user.entity.User;

public class SystemCache {
	private static ThreadLocal<User> loaclUser= new ThreadLocal<User>();

	public static User getLoaclUser() {
		return loaclUser.get();
	}

	public static void setLoaclUser(User user) {
		loaclUser.set(user);
	}

 
	
	
}
