package com.qk.core.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.qk.core.beanutils.annotation.OAuthRequired;
import com.qk.core.domain.Busi;
import com.qk.core.domain.SystemCache;
import com.qk.core.framework.dto.ResultBean;
import com.qk.core.framework.dto.ResultEnum;
import com.qk.core.jwt.Jwt;
import com.qk.core.jwt.JwtValidateResult;
import com.qk.core.jwt.TokenState;
import com.qk.core.module.user.entity.User;
import com.qk.core.module.user.service.UserService;


/**
 * @author bing.wang
 *
 */
public class AdminLoginInterceptor implements HandlerInterceptor {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if(handler instanceof HandlerMethod) {
			HandlerMethod hm = (HandlerMethod)handler;
			Boolean authRequired=hm.getMethod().isAnnotationPresent(OAuthRequired.class);
	        if(authRequired) {
//	        	JwtValidateResult<User> jvr = Jwt.validToken(request.getHeader(Busi.TOKEN));
//	        	//如果请求合法
//	        	if(jvr.getState()==TokenState.VALID) {
//	        		SystemCache.setLoaclUser(jvr.getData());
//	        	}
//	        	else {
//	        		printError(response, JSON.toJSONString(new ResultBean(ResultEnum.NO_LOGIN_ERROR.getCode(),"您未登录，请重新登录！")));
//	        		return false;
//	        	}
	        	SystemCache.setLoaclUser(mokeUser());
	        }
		}
		else{
		    logger.info("无效的请求！"); 
			printError(response, "reject!");
			return false;
		}
		return true;
	}
	
	private User mokeUser(){
		WebApplicationContext ctx = ContextLoader.getCurrentWebApplicationContext();
		UserService userService=(UserService)ctx.getBean("userServiceSystem");
		User mUser=userService.get(1);
		return mUser;
	}
	
	private void printError(HttpServletResponse response,String str)throws Exception
	{
		response.getWriter().println(str);
		response.getWriter().close();
	}


	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
    }

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
        //释放资源 避免内存溢出
        HandlerMethod hm = (HandlerMethod)handler;
        Object hmBean = hm.getBean();
//        logger.info("ContextInterceptor: "+hmBean.toString());
//        if(	hmBean instanceof AdminLoginController) {
//            ControllerContext.remove();
//        }

	}
	
}
