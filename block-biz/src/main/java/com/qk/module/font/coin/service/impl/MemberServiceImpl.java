package com.qk.module.font.coin.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.TreeNode;
import com.qk.core.framework.dto.ResultBean;
import com.qk.core.framework.dto.ResultEnum;
import com.qk.core.ibatis.sql.criteria.And;
import com.qk.core.ibatis.sql.criteria.Restrictions;
import com.qk.module.font.coin.dao.impl.MebAccountDaoImpl;
import com.qk.module.font.coin.dao.impl.MebBasicDaoImpl;
import com.qk.module.font.coin.dao.impl.MebCoinDaoImpl;
import com.qk.module.font.coin.dao.impl.MebInfoDaoImpl;
import com.qk.module.font.coin.dao.impl.MebStateLogDaoImpl;
import com.qk.module.font.coin.dao.impl.MebStatisticsDaoImpl;
import com.qk.module.font.coin.dao.impl.MebWalletDaoImpl;
import com.qk.module.font.coin.domain.entity.MebAccount;
import com.qk.module.font.coin.domain.entity.MebBasic;
import com.qk.module.font.coin.domain.entity.MebCoin;
import com.qk.module.font.coin.domain.entity.MebInfo;
import com.qk.module.font.coin.domain.entity.MebStateLog;
import com.qk.module.font.coin.domain.entity.MebStatistics;
import com.qk.module.font.coin.domain.entity.MebWallet;
import com.qk.module.font.coin.domain.enums.Busi;
import com.qk.module.font.coin.domain.req.ChangePwdReq;
import com.qk.module.font.coin.domain.req.ForgetPwdReq;
import com.qk.module.font.coin.domain.req.SignupReq;
import com.qk.module.font.coin.service.MemberService;
import com.qk.module.font.common.exception.BusiException;

/**
 * 会员服务类
 */
@Service
public class MemberServiceImpl implements MemberService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private MebAccountDaoImpl mebAccountDao;

	@Autowired
	private MebBasicDaoImpl mebBasicDao;
	
	@Autowired
	private MebInfoDaoImpl mebInfoDao;

	@Autowired
	private MebWalletDaoImpl mebWalletDao;

	@Autowired
	private MebStatisticsDaoImpl mebStatsDao;
	
	@Autowired
	private MebStateLogDaoImpl mebStateLogDao;

	@Autowired
	private MebCoinDaoImpl mebCoinDao;
	

	/**
	 * 会员激活
	 * 
	 * @param mebId
	 * @return
	 * @throws BusiException
	 */
	@Override
	@Transactional
	public boolean active(int mebId)
	{
		And and =new And("meb_id", mebId,Restrictions.EQ);
		MebInfo mebInfo = mebInfoDao.get(and);
		
		String mebState = mebInfo.getMebState();
		if (mebState.equals(Busi.MEB_STATE_UNACTIVE))
		{ // 未激活状态
			// 更新会员状态
			mebInfo.setMebState(Busi.MEB_STATE_UNAUTH);
			mebInfo.setLastStateTime(  new Date());
			mebInfoDao.update(mebInfo);

			// 会员激活记录
			MebStateLog mebStateLog = new MebStateLog();
			mebStateLog.setMebId(mebId);
			mebStateLog.setNewState(Busi.MEB_STATE_UNAUTH);
			mebStateLog.setCreateTime(new Date());
			mebStateLog.setChangeReason(Busi.MEB_STATE_CHANGE_ACTIVE);
			mebStateLogDao.add(mebStateLog);
			return true;
		} 
		else 
		{
			logger.warn("激活：会员状态不符");
			return false;
		}
	}

	/**
	 * 认证<br>
	 * 触发会员推荐人升级判断
	 * 
	 * @param mebId
	 * @return 
	 */
	@Override
	@Transactional
	public synchronized ResultBean auth(String operId,String mebId) 
	{
		ResultBean resultBean = new ResultBean(ResultEnum.SUCCESS);
		// 会员从未认证变为正常
		And and =new And("meb_id", mebId,Restrictions.EQ);
		MebInfo mebInfo = mebInfoDao.get(and);
		
		String mebState = mebInfo.getMebState();

		if (!Busi.MEB_STATE_UNAUTH.equals(mebState))
		{
			resultBean.setCode(ResultEnum.MEB_STATE_ERROR.getCode());
			resultBean.setMsg(ResultEnum.MEB_STATE_ERROR.getMsg());
			return resultBean;
		}
		try
		{
		mebInfo.setMebState(Busi.MEB_STATE_OK);
		mebInfo.setLastStateTime(new Date());
		mebInfoDao.update(mebInfo);

		// 会员状态变更记录
		MebStateLog mebStateLog = new MebStateLog();
		mebStateLog.setMebId(Integer.valueOf(mebId));
		mebStateLog.setNewState(Busi.MEB_STATE_OK);
		mebStateLog.setCreateTime(new Date());
		mebStateLog.setChangeReason(Busi.MEB_STATE_CHANGE_AUTH);
		mebStateLog.setOper(operId);
		mebStateLogDao.add(mebStateLog);
		}
		catch(Exception e)
		{
			logger.error("auth meb exception"+e.getMessage());
			resultBean.setCode(ResultEnum.AUTH_MEB_EXCEPTION.getCode());
			resultBean.setMsg(ResultEnum.AUTH_MEB_EXCEPTION.getMsg());
		}
		return resultBean;
/*
		// 更新-1关联
		int ref = (Integer) mebInfo.getMebReferee();
		if (ref > 0) {
			mebStatsDao.incNumberField(String.valueOf(ref), "mebGroupCount", 1);
		}

		// 更新-2关联
		int ref2 = (Integer) mebInfo.getMebReferee2();
		if (ref2 > 0) {
			mebStatsDao.incNumberField(String.valueOf(ref2), "mebGroup2Count", 1);
		}

		// 更新-3关联
		int ref3 = (Integer) mebInfo.getMebReferee3();
		if (ref3 > 0) {
			mebStatsDao.incNumberField(String.valueOf(ref3), "mebGroup3Count", 1);
		}

		// 更新团队
		int groupId = (int) mebInfo.get("groupId");
		if (groupId > 0) {
			mebGroupDao.incNumberField(String.valueOf(groupId), "count", 1);
		}
	*/}

	/**
	 * 冻结<br>
	 * 触发会员推荐人降级判断
	 * 
	 * @param mebId
	 * @return 
	 */
	@Override
	@Transactional
	public ResultBean freeze(String mebId) 
	{
		ResultBean resultBean = new ResultBean(ResultEnum.SUCCESS);
		And and =new And("meb_id", mebId,Restrictions.EQ);
		MebInfo mebInfo = mebInfoDao.get(and);
		
		String mebState = mebInfo.getMebState();
		if (Busi.MEB_STATE_OK.equals(mebState)) 
		{
			// 冻结会员
			mebInfo.setLastStateTime(new Date());
			mebInfo.setMebState(Busi.MEB_STATE_LOCK);
			mebInfoDao.update(mebInfo);

			// 会员冻结记录
			MebStateLog mebStateLog = new MebStateLog();
			mebStateLog.setMebId(Integer.valueOf(mebId));
			mebStateLog.setNewState(Busi.MEB_STATE_LOCK);
			mebStateLog.setCreateTime(new Date());
			mebStateLog.setChangeReason(Busi.MEB_STATE_CHANGE_LOCK);
			// TODO
			mebStateLog.setOper("");
			mebStateLogDao.add(mebStateLog);
/*TODO			
			// 发送冻结通知
			List<String> args = new ArrayList<String>();
			args.add(freezeReason);
			SmsServiceImpl smsService = (SmsServiceImpl) AiContext.getBean("smsService");
			smsService.noticeToFreeze(mebId, args);*/
		} 
		else 
		{
			logger.warn("冻结：会员状态不符");
			resultBean.setCode(ResultEnum.FREEZE_MEB_ERROR.getCode());
			resultBean.setMsg(ResultEnum.FREEZE_MEB_ERROR.getMsg());
		}
		return resultBean;
	}

	/**
	 * 解冻<br>
	 * 触发会员推荐人升级判断
	 * 
	 * @param mebId
	 * @return 
	 */
	@Transactional
	public ResultBean unfreeze(String mebId) 
	{
		ResultBean resultBean = new ResultBean(ResultEnum.SUCCESS);
		And and =new And("meb_id", mebId,Restrictions.EQ);
		MebInfo mebInfo = mebInfoDao.get(and);
		
		String mebState = mebInfo.getMebState();
		if (Busi.MEB_STATE_LOCK.equals(mebState))
		{
			// 会员从冻结变为正常
			mebInfo.setLastStateTime(new Date());
			mebInfo.setMebState(Busi.MEB_STATE_OK);
			mebInfoDao.update(mebInfo);

			// 会员冻结记录
			MebStateLog mebStateLog = new MebStateLog();
			mebStateLog.setMebId(Integer.valueOf(mebId));
			mebStateLog.setNewState(Busi.MEB_STATE_OK);
			mebStateLog.setCreateTime(new Date());
			mebStateLog.setChangeReason(Busi.MEB_STATE_CHANGE_UNLOCK);
			// TODO
			mebStateLog.setOper("");
			mebStateLogDao.add(mebStateLog);

			// 发送解冻通知
			/*SmsServiceImpl smsService = (SmsServiceImpl) AiContext.getBean("smsService");
			smsService.noticeToUnfreeze(mebId);*/
		}
		else
		{
			logger.warn("解冻：会员状态不符");
			resultBean.setCode(ResultEnum.UNFREEZE_MEB_ERROR.getCode());
			resultBean.setMsg(ResultEnum.UNFREEZE_MEB_ERROR.getMsg());
		}
		return resultBean;
	}

	/**
	 * 注销用户
	 * 
	 * @param params
	 * @return
	 * @throws BusiException
	 */
	@Override
	@Transactional
	public ResultBean unreg(String operId,String mebId)  
	{
		ResultBean resultBean = new ResultBean(ResultEnum.SUCCESS);
		And and =new And("meb_id", mebId,Restrictions.EQ);
		MebInfo mebInfo = mebInfoDao.get(and);
		
		String mebState = mebInfo.getMebState();

		if (Busi.MEB_STATE_CLOSE.equals(mebState))
		{ // 已销号
			return resultBean;
		} 
		else if (!Busi.MEB_STATE_LOCK.equals(mebState))
		{ // 未冻结
			logger.error("待注销会员必须是冻结状态！");
			resultBean.setCode(ResultEnum.UNREG_MEB_EXCEPTION.getCode());
			resultBean.setMsg(ResultEnum.UNREG_MEB_EXCEPTION.getMsg());
			return resultBean;
			
		}
		try
		{
			
		
		// 变更会员状态
		mebInfo.setMebState(Busi.MEB_STATE_CLOSE);
		mebInfoDao.update(mebInfo);

		// 会员状态变更记录
		MebStateLog mebStateLog = new MebStateLog();
		mebStateLog.setMebId(Integer.valueOf(mebId));
		mebStateLog.setNewState(Busi.MEB_STATE_CLOSE);
		mebStateLog.setCreateTime(new Date());
		mebStateLog.setChangeReason(Busi.MEB_STATE_CHANGE_UNREG);
		mebStateLog.setOper(operId);
		mebStateLogDao.add(mebStateLog);

		// 禁止登录
		MebBasic mebBasic = new MebBasic();
		mebBasic.setId(Integer.valueOf(mebId));
		mebBasic.setIsValid(Busi.NO);
		mebBasicDao.update(mebBasic);
		}
		catch(Exception e)
		{
			logger.error("unreg error"+e.getMessage());
			resultBean.setCode(ResultEnum.UNREG_MEB_ERROR.getCode());
			resultBean.setMsg(ResultEnum.UNREG_MEB_ERROR.getMsg());
		}
		return resultBean;
		
/*
		// 推荐人
		int ref = (Integer) mebInfo.getMebReferee();
		int ref2 = (Integer) mebInfo.getMebReferee2();
		int ref3 = (Integer) mebInfo.getMebReferee3();

		// 推荐人惩罚人工处理

		// 变更日志及固定字段
		DaoApi mebRefereeLogDao = (DaoApi) AiContext.getBean("mebRefereeLogDao");
		Map<String, Object> log = new AiMap<Object>();
		log.put("changeType", Busi.REFEREE_CHANGE_UNREG);
		log.put("createTime", new Date());

		// 一级团队继承
		List<Map<String, Object>> mebGroup = mebInfoDao.loadRecords(new Condition("mebReferee", mebId));
		for (Map<String, Object> meb : mebGroup) {
			// 固定字段
			log.put("mebId", meb.get("mebId"));
			log.put("preReferee", mebId);

			// 记录变更日志（推荐人）
			log.put("linkDegree", -1);
			log.put("newReferee", ref);
			mebRefereeLogDao.insertRecord(log);

			int preRef = (Integer) meb.get("mebReferee2"); // 原推荐人
			if (ref2 != preRef) {
				// 记录变更日志（二级推荐人）
				log.put("linkDegree", -2);
				log.put("newReferee", ref2);
				mebRefereeLogDao.insertRecord(log);
			}

			preRef = (Integer) meb.get("mebReferee3"); // 原推荐人
			if (ref3 != preRef) {
				// 记录变更日志（三级推荐人）
				log.put("linkDegree", -3);
				log.put("newReferee", ref3);
				mebRefereeLogDao.insertRecord(log);
			}
		}
		Map<String, Object> map = new AiMap<Object>();
		map.put("mebReferee", ref);
		map.put("mebReferee2", ref2);
		map.put("mebReferee3", ref3);
		mebInfoDao.updateRecords(map, new Condition("mebReferee", mebId));

		// 二级团队继承
		mebGroup = mebInfoDao.loadRecords(new Condition("mebReferee2", mebId));
		for (Map<String, Object> meb : mebGroup) {
			// 固定字段
			log.put("mebId", meb.get("mebId"));
			log.put("preReferee", mebId);

			// 记录变更日志（二级推荐人）
			log.put("linkDegree", -2);
			log.put("newReferee", ref2);
			mebRefereeLogDao.insertRecord(log);

			int preRef = (Integer) meb.get("mebReferee3"); // 原推荐人
			if (ref3 != preRef) {
				// 记录变更日志（三级推荐人）
				log.put("linkDegree", -3);
				log.put("newReferee", ref3);
				mebRefereeLogDao.insertRecord(log);
			}
		}
		map.clear();
		map.put("mebReferee2", ref);
		map.put("mebReferee3", ref2);
		mebInfoDao.updateRecords(map, new Condition("mebReferee2", mebId));

		// 三级团队继承
		mebGroup = mebInfoDao.loadRecords(new Condition("mebReferee3", mebId));
		for (Map<String, Object> meb : mebGroup) {
			// 记录变更日志（三级推荐人）
			log.put("mebId", meb.get("mebId"));
			log.put("linkDegree", -3);
			log.put("preReferee", mebId);
			log.put("newReferee", ref3);
			mebRefereeLogDao.insertRecord(log);
		}
		mebInfoDao.updateRecords("mebReferee3", ref, new Condition("mebReferee3", mebId));
	*/}

	/**
	 * 认证会员信息
	 * 
	 * @param mebId
	 */
	@Transactional
	public void authMember(Map<String, String> args) {/*
		// 检查会员状态
		String mebId = AiContext.getLoginId();
		Map<String, Object> mebInfo = mebInfoDao.loadRecordById(mebId);
		String mebState = mebInfo.get("mebState").toString();
		if (!mebState.equals(Busi.MEB_STATE_UNAUTH)) { // 未认证状态
			throw new BusiException("您的会员状态不符合认证要求");
		}

		String name = args.get("name");
		String id = args.get("id");
		String bankNum = args.get("bankNum");
		String depositBank = args.get("depositBank");
		String detailBank = args.get("detailBank");

		// 更新会员基本信息表
		Map<String, Object> mebBasic = mebBasicDao.loadRecordById(AiContext.getLoginId());
		mebBasic.put("mebName", name);
		mebBasic.put("mebIdentity", id);
		mebBasic.put("authTime", new Date());
		mebBasicDao.updateRecord(mebBasic);

		// 更新会员信息表
		mebInfoDao.updateRecord(mebId, "mebName", name);

		// 更新会员账户表
		DaoApi mebAccountDao = (DaoApi) AiContext.getBean("mebAccountDao");
		AiMap<Object> mebAccount = new AiMap<Object>();
		mebAccount.put("mebId", mebId);
		mebAccount.put("mebName", name);
		mebAccount.put("bankNum", bankNum);
		mebAccount.put("depositBank", depositBank);
		mebAccount.put("detailBank", detailBank);
		mebAccountDao.updateRecord(mebAccount);
	*/}

	/**
	 * 获取下级团队
	 * 
	 * @param mebId
	 * @return
	 */
	public List<TreeNode> getGroup(String mebId, String depth) {
		return null;/*
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		List<Map<String, Object>> list = mebInfoDao.loadRecords("mebReferee", mebId);

		if (null == list)
			return nodes;

		TreeNode tn;
		for (Map<String, Object> m : list) {
			String nodeId = m.get("mebId").toString();
			String nodeText = (Integer.parseInt(depth) + 1) + "级团队" + ", " + m.get("mebName") + ", " + m.get("mebPhone");

			tn = new TreeNode(nodeId, nodeText);
			tn.setLeaf(false);
			nodes.add(tn);
		}
		return nodes;
	*/}

	/**
	 * 变更推荐人
	 * 
	 * @param mebId
	 * @param refPhone
	 * @param refName
	 */
	public void changeRef(String mebId, String refPhone, String refName) {/*
		DaoApi mebRefereeLogDao = (DaoApi) AiContext.getBean("mebRefereeLogDao");
		Map<String, Object> mebInfo = mebInfoDao.loadRecordById(mebId);
		String mebState = mebInfo.get("mebState").toString();
		if (mebState.equals(Busi.MEB_STATE_UNACTIVE) || mebState.equals(Busi.MEB_STATE_UNAUTH)) { // 未激活或未认证状态

		} else {
			throw new BusiException("该会员状态不符合变更推荐人要求");
		}

		And and = new And();
		and.add(new Condition("mebPhone", refPhone));
		and.add(new Condition("mebName", refName));
		List<Map<String, Object>> list = mebInfoDao.loadRecords(and);
		if (list.size() == 1) {
			Map<String, Object> ref = list.get(0);
			mebState = ref.get("mebState").toString();
			if (!mebState.equals(Busi.MEB_STATE_OK)) { // 正常状态
				throw new BusiException("推荐人状态无效");
			}

			// 记录变更日志
			Map<String, Object> log = new AiMap<Object>();
			log.put("mebId", mebId);
			log.put("linkDegree", -1);
			log.put("preReferee", mebInfo.get("mebReferee"));
			log.put("newReferee", ref.get("mebId"));
			log.put("changeType", Busi.REFEREE_CHANGE_MANUAL);
			log.put("createTime", new Date());
			log.put("oper", AiContext.getLoginId());
			mebRefereeLogDao.insertRecord(log);

			if ((Integer) mebInfo.get("mebReferee2") > 0 || (Integer) ref.get("mebReferee") > 0) {
				log.put("linkDegree", -2);
				log.put("preReferee", mebInfo.get("mebReferee2"));
				log.put("newReferee", ref.get("mebReferee"));
				mebRefereeLogDao.insertRecord(log);
			}

			if ((Integer) mebInfo.get("mebReferee3") > 0 || (Integer) ref.get("mebReferee2") > 0) {
				log.put("linkDegree", -3);
				log.put("preReferee", mebInfo.get("mebReferee3"));
				log.put("newReferee", ref.get("mebReferee2"));
				mebRefereeLogDao.insertRecord(log);
			}

			mebInfo.put("mebReferee", ref.get("mebId"));
			mebInfo.put("mebReferee2", ref.get("mebReferee"));
			mebInfo.put("mebReferee3", ref.get("mebReferee2"));
			mebInfoDao.updateRecord(mebInfo);
		} else {
			throw new BusiException("无效推荐人信息");
		}
	*/}
	
	/**
	 * 找回交易支付密码
	 * @author smart迅
	 *
	 * @param request
	 * @return
	 */
	public ResultBean findPayPwd(HttpServletRequest request)
	{
		return null;/*
		String phone = request.getParameter("phone");
		String name = request.getParameter("name");
		
		String pwd = request.getParameter("newpwd");

		// 初始化
		ResponseBean ret = new ResponseBean();
		ret.setMsg("执行失败！");
		ret.setSuccess(false);

		if(pwd.length() < 32)
		{
			ret.setMsg("禁止明文传输密码");
			return ret;
		}
		// 判断用户信息是否正确
		DaoApi mebInfoDao = (DaoApi) AiContext.getBean("mebInfoDao");
		And and = new And();
		and.add(new Condition("mebPhone", phone));
		and.add(new Condition("mebName", name));
		List<Map<String, Object>> list = mebInfoDao.loadRecords(and);
		if (list.size() != 1) {
			ret.setMsg("用户信息不正确！");
			return ret;
		}

		//积分商城注册用户信息
		String sysRegUrl = coreParamCache.get("sysPointUrl");
		String sysPointChangePwdParam = coreParamCache.get("sysPointChangePwd");

		StringBuilder sysPointUrl = new StringBuilder();
		sysPointUrl.append(sysRegUrl);
		sysPointUrl.append(sysPointChangePwdParam);
		log.info("findPayPwd sysPointUrl = "+sysPointUrl);
		String result = null;
		
		Map<String,String> params = new HashMap<String,String>();
		params.put("mebPhone", phone);
		params.put("mebName", name);
		params.put("newPwd", pwd);
		
		try 
		{
			result = HttpTookit.doPost(sysPointUrl.toString(), params, "UTF-8");
			log.info(result);
			JSONObject jsonObject = JSONObject.parseObject(result);
			ret = JSONObject.toJavaObject(jsonObject, ResponseBean.class);
		}
		catch (Exception e)
		{
			log.error("findPayPwd Exception e="+e.getMessage());
		}
		return ret;	
	*/}
	
	/**
	 * 注册
	 * @author smart迅
	 *
	 * @param httpReq
	 * @param req
	 * @return
	 */
	@Override
	@Transactional
	public ResultBean reg(HttpServletRequest httpReq,SignupReq req) 
	{
		ResultBean resultBean = new ResultBean(ResultEnum.SUCCESS);
		try
		{
			String ip = httpReq.getHeader("x-forwarded-for");
			if (ip == null || ip.length() == 0 ||
					"unknown".equalsIgnoreCase(ip))
			{
				ip = httpReq.getHeader("Proxy-Client-IP");
			}
			if (ip == null || ip.length() == 0 ||
					"unknown".equalsIgnoreCase(ip)) 
			{
				ip = httpReq.getHeader("WL-Proxy-Client-IP");
			}
			if (ip == null || ip.length() == 0 || 
					"unknown".equalsIgnoreCase(ip)) 
			{
				ip = httpReq.getRemoteAddr();
			}
		//新增基本表
		MebBasic mebBasic = new MebBasic();
		mebBasic.setMebPhone(req.getPhone());
		mebBasic.setMebName(req.getUserName());
		mebBasic.setMebPwd(req.getPassword());
		mebBasic.setCreateTime(new Date());
		mebBasic.setLastLoginTime(new Date());
		mebBasic.setIsValid("1");
		mebBasic.setCreateIp(ip);
		mebBasic.setLastLoginIp(ip);
		
		int mebId = mebBasicDao.add(mebBasic);
		
		MebInfo mebInfo = new MebInfo();
		mebInfo.setMebId(mebId);
		mebInfo.setMebName(req.getUserName());
		mebInfo.setMebPhone(req.getPhone());
		mebInfo.setMebState(Busi.MEB_STATE_UNACTIVE);
		mebInfo.setMebType(Busi.MEB_OUTTER);
		mebInfo.setMebLevel(1);
		mebInfo.setMebReferee(0);
		mebInfo.setMebReferee2(0);
		mebInfo.setMebReferee3(0);
		mebInfo.setCreateTime(new Date());
		mebInfo.setLastStateTime(new Date());
		mebInfoDao.add(mebInfo);
	
		this.initMemberExtend(Integer.valueOf(mebId));
		// 会员注册记录
		MebStateLog mebStateLog = new MebStateLog(); 
		mebStateLog.setMebId(Integer.valueOf(mebId));
		mebStateLog.setNewState(  Busi.MEB_STATE_UNACTIVE);
		mebStateLog.setCreateTime( new Date());
		mebStateLog.setChangeReason(  Busi.MEB_STATE_CHANGE_REG);
		mebStateLogDao.add(mebStateLog);
		
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			throw new BusiException(e.getMessage());
		}
		return resultBean;
	}

	/**
	 * 初始化会员附属表
	 * 
	 * @param mebId
	 * @param mebName
	 */
	@Transactional
	public void initMemberExtend(Integer mebId) {
		// ***新增财务表
		MebWallet mebWallet = new MebWallet();
		mebWallet.setMebId(mebId);
		mebWallet.setBaseFree(0);
		mebWallet.setBaseFreeze(0);
		mebWallet.setGrowFree(0);
		mebWalletDao.add(mebWallet);

		// ***新增统计表
		MebStatistics mebStats = new MebStatistics();
		mebStats.setMebId(mebId);
		mebStats.setBonusCount(0);
		mebStats.setBaseTotal(0);
		mebStats.setBonusTotal(0);
		mebStats.setGrowTotal(0);
		mebStats.setExitBaseTotal(0);
		mebStats.setExitBonusTotal(0);
		mebStats.setExitGrowTotal(0);
		mebStatsDao.add(mebStats);

		// ***新增账户表
		MebAccount mebAccount = new MebAccount();
		
		mebAccount.setMebId(mebId);
		mebAccount.setBankNum("");
		mebAccount.setDepositBank("");
		mebAccount.setDetailBank("");
		mebAccount.setBankNum2("");
		mebAccount.setDepositBank2("");
		mebAccount.setDetailBank2("");
		mebAccount.setAlipayId("");
		mebAccount.setMicroMsgId("");
		mebAccountDao.add(mebAccount);
		
		//新增mebCoin表
		MebCoin mebCoin = new MebCoin();
		mebCoin.setMebId(mebId);
		mebCoin.setActiveCoin(0);
		mebCoin.setGameCoin(0);
		mebCoinDao.add(mebCoin);
	}



	/**
	 * 用户发起修改密码请求
	 * @author smart迅
	 *
	 * @param req
	 * @return
	 */
	@Override
	public ResultBean pwd(ChangePwdReq req) 
	{
		// 初始化
		ResultBean resultBean = new ResultBean(ResultEnum.SUCCESS);
		// 查询用户信息
		MebBasic mebBasic = mebBasicDao.get(req.getMebId());
		if (null == mebBasic) 
		{
			logger.error("user not found");
			resultBean.setCode(ResultEnum.USER_NOT_EXIT.getCode());
			resultBean.setMsg(ResultEnum.USER_NOT_EXIT.getMsg());
			return resultBean;
		}
		
		if (!req.getOldPwd().equals(mebBasic.getMebPwd()))
		{
			logger.error("old password error");
			resultBean.setCode(ResultEnum.USER_PASSWORD_ERROR.getCode());
			resultBean.setMsg(ResultEnum.USER_PASSWORD_ERROR.getMsg());
			return resultBean;
		}
		
//		boolean isOldPwd = mebBasic.get.equals(Busi.YES); // 旧密码标志检查
		try
		{
			mebBasicDao.update(req.getMebId(), "mebPwd", req.getNewPwd());
		}
		catch(Exception e)
		{
			logger.error("mebBasicDao update error");
			resultBean.setCode(ResultEnum.UPDATE_PASSWORD_ERROR.getCode());
			resultBean.setMsg(ResultEnum.UPDATE_PASSWORD_ERROR.getMsg());
		}
		return resultBean;
	}

	/**
	 * 忘记密码
	 * @author smart迅
	 *
	 * @param req
	 * @return
	 */
	@Override
	public ResultBean forget(ForgetPwdReq req) 
	{
		// 初始化
		ResultBean ret = new ResultBean(ResultEnum.SUCCESS);

		// 判断用户信息是否正确
		And and = new And("mebPhone", req.getPhone(),Restrictions.EQ);
		and.add("mebName", req.getName(),Restrictions.EQ);
		
		MebInfo mebInfo = mebInfoDao.get(and);
		if (null == mebInfo)
		{
			ret.setMsg("用户信息不正确！");
			return ret;
		}
/*	TODO
		// 判断验证码是否正确
		boolean isOpenSms = coreParamCache.get("isOpenSms").equals(Busi.YES);

		boolean isValid;
		if (isOpenSms) {
			SmsService smsService = (SmsService) AiContext.getBean("smsService");
			isValid = smsService.verifycode(phone, yzm);

			if (!isValid) {
				ret.setMsg("验证码错误！");
				return ret;
			}
		} else {
			isValid = yzm.equals("999999");

			if (!isValid) {
				ret.setMsg("测试验证码为999999！");
				return ret;
			}
		}
*/
		// 更新新密码
		And mebBasicAnd = new And("meb_id", mebInfo.getMebId(),Restrictions.EQ);
		MebBasic mebBasic = mebBasicDao.get(mebBasicAnd);
		mebBasic.setMebPwd(req.getPwd());
		mebBasicDao.update(mebBasic);

		ret.setCode(ResultEnum.SUCCESS.getCode());
		ret.setMsg("您的密码已更新，请重新登录！");
		return ret;
	
	}
}
