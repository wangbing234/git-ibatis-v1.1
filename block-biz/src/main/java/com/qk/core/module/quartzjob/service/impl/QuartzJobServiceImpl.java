package com.qk.core.module.quartzjob.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.qk.core.domain.Busi;
import com.qk.core.ibatis.service.impl.BaseServiceImpl;
import com.qk.core.module.quartzjob.dao.QuartzJobDao;
import com.qk.core.module.quartzjob.entity.QuartzJob;
import com.qk.core.module.quartzjob.service.QuartzCache;
import com.qk.core.module.quartzjob.service.QuartzJobService;
import com.qk.module.font.common.exception.BusiException;

@Service
@Component("quartzJobServiceSystem")
public class QuartzJobServiceImpl extends BaseServiceImpl<QuartzJob,QuartzJobDao> implements QuartzJobService,InitializingBean {

	@Resource(name="quartzCache")
	private QuartzCache quartzCache;

	
	@Override
	public void afterPropertiesSet() throws Exception {
		quartzCache.init();
		this.list(null, null).forEach(map -> updateCache(map));
	}

	/**
	 * 更新参数到缓存
	 */
	public void updateCache(QuartzJob map) {
		quartzCache.put(map.getJobId(), map);
	}

	/**
	 * 更新参数
	 * 
	 * @param key
	 * @param value
	 */
	@Override
	public int update(QuartzJob map) throws BusiException {
		this.baseDao.update(map);
		// 更新缓存
		updateCache(this.baseDao.get(map.getJobId()));
		return 1;
	}

	public boolean valid(String jobId) throws BusiException {
		boolean isStop = quartzCache.valid(jobId);
		this.baseDao.update(jobId, "stop", isStop ? Busi.YES : Busi.NO);
		return true;
	}
}
