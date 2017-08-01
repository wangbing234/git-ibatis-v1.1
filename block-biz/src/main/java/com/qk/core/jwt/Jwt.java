/*
 * Powered By [rapid-framework]
 *  copyright © 趋快科技(武汉)有限公司
 * Since 2017 - 2017
 */
package com.qk.core.jwt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JOSEObjectType;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.qk.core.framework.dto.ResultBean;
import com.qk.core.module.user.entity.User;

import net.minidev.json.JSONObject;

/**
 * Jwt 用户验证登录
 * @author bing.wang
 * @version 1.0
 * @since 1.0
 * */
public class Jwt {

	/**
	 * 失效时间7天
	 */
	private static final long EXPIRE_HOUR = 7*24;
	
	/**
	 * 秘钥
	 */
	private static final byte[] SECRET = "wb3d9901d2276917dfa 7df11_qkkj2017".getBytes();

	/**
	 * 初始化head部分的数据为 { "alg":"HS256", "type":"JWT" }
	 */
	private static final JWSHeader header = new JWSHeader(JWSAlgorithm.HS256, JOSEObjectType.JWT, null, null, null,
			null, null, null, null, null, null, null, null);

	/**
	 * 生成token，该方法只在用户登录成功后调用
	 * 
	 * @param Map集合，可以存储用户id，token生成时间，token过期时间等自定义字段
	 * @return token字符串,若失败则返回null
	 */
	public static String createToken(String uid, Object userObj) {
		Map<String, Object> payload = new HashMap<String, Object>();
		long dateLong = new Date().getTime();
		payload.put("uid", uid);// 用户ID
		payload.put("iat", dateLong);//生成时间
		payload.put("ext", dateLong + EXPIRE_HOUR * 1000*3600);//失效时间
		payload.put("data", JSON.toJSONString(userObj));//携带的数据
		String tokenString = null;
		// 创建一个 JWS object
		JWSObject jwsObject = new JWSObject(header, new Payload(new JSONObject(payload)));
		try {
			// 将jwsObject 进行HMAC签名
			jwsObject.sign(new MACSigner(SECRET));
			tokenString = jwsObject.serialize();
		} catch (JOSEException e) {
			System.err.println("签名失败:" + e.getMessage());
			e.printStackTrace();
		}
		return tokenString;
	}

	/**
	 * 校验token是否合法，返回Map集合,集合中主要包含 state状态码 data鉴权成功后从token中提取的数据
	 * 该方法在过滤器中调用，每次请求API时都校验
	 * 
	 * @param token
	 * @return Map<String, Object>
	 */
	public static JwtValidateResult<User> validToken(String token) {
		JwtValidateResult<User> jvr=new JwtValidateResult<User>();
		try {
			JWSObject jwsObject = JWSObject.parse(token);
			Payload payload = jwsObject.getPayload();
			JWSVerifier verifier = new MACVerifier(SECRET);
			if (jwsObject.verify(verifier)) {
				JSONObject jsonOBj = payload.toJSONObject();
				// token校验成功（此时没有校验是否过期）
				jvr.setState(TokenState.VALID);
				// 若payload包含ext字段，则校验是否过期
				if (jsonOBj.containsKey("ext")) {
					long extTime = Long.valueOf(jsonOBj.get("ext").toString());
					long curTime = new Date().getTime();
					// 过期了
					if (curTime > extTime) {
						jvr.setState(TokenState.EXPIRED);
					}
				}
				jvr.setData(JSON.parseObject(jsonOBj.get("data").toString(),User.class));
				jvr.setState(TokenState.INVALID);
			} else {
				// 校验失败
				jvr.setState(TokenState.INVALID);
			}

		} catch (Exception e) {
			 e.printStackTrace();
			// token格式不合法导致的异常
			jvr.setState(TokenState.INVALID);
		}
		return jvr;
	}
}
