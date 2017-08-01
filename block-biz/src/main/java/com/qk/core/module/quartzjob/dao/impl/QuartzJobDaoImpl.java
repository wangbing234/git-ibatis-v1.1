/**
 * Powered By [rapid-framework]
 * Copyright  © 趋快科技(武汉)有限公司
 * @author :bing.wang
 * @Description: -QuartzJob
 * @date 2017-07-25 18:27:20
 * @version V1.0
 **/
package com.qk.core.module.quartzjob.dao.impl;


import org.springframework.stereotype.Component;
import com.qk.core.ibatis.dao.impl.BaseDaoImpl;
import com.qk.core.module.quartzjob.dao.QuartzJobDao;

import com.qk.core.module.quartzjob.entity.QuartzJob;



/**
 * dao实现类
 * @author rapid-code
 * @version 1.0
 * @since 1.0
 * */
@Component("quartzJobDaoSystem")
public class QuartzJobDaoImpl extends  BaseDaoImpl<QuartzJob> implements QuartzJobDao {

}
