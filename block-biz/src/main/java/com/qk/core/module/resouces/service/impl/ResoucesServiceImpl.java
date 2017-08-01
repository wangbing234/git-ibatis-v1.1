/*
 * Powered By [rapid-framework]
 *  copyright © 趋快科技(武汉)有限公司
 * Since 2017 - 2017
 */

package com.qk.core.module.resouces.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.qk.core.ibatis.service.impl.BaseServiceImpl;
import com.qk.core.module.resouces.dao.ResoucesDao;
import com.qk.core.module.resouces.entity.Resouces;
import com.qk.core.module.resouces.service.ResoucesService;


/**
 *   Service实现类
 * @author rapid-code
 * @version 1.0
 * @since 1.0
 * */
@Service
@Component("resoucesServiceSystem")
public class ResoucesServiceImpl extends BaseServiceImpl<Resouces,ResoucesDao> implements ResoucesService {

	@Override
	public List<Resouces> getMenus(String user) {
		Map<String, Object> map =new HashMap<String, Object>();
		map.put("id", user);
		List<Resouces> list = baseDao.selectAuthMenus(map);
		List<Resouces> rList=new ArrayList<Resouces>();
		for (Resouces resouces : list) {
			 if(resouces.getPid()==1){
				 rList.add(resouces);
			 }
			 else
			 {
				 for (Resouces pSub : rList) {
					 System.out.println(resouces.getPid() +" "  + pSub.getId()); 
					 if(resouces.getPid()==pSub.getId()){
						 pSub.getChildren().add(resouces);
					 }
				 }
			 }
		}
		
		return rList;
	}

}
