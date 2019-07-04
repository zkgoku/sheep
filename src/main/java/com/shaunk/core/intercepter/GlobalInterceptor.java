package com.shaunk.core.intercepter;

import com.shaunk.core.exception.UserAuthExpireException;
import com.shaunk.core.exception.UserNoLoginException;
import com.shaunk.core.vo.UserInfo;
import com.shaunk.service.UserServiceI;
import com.shaunk.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @Project sheep
 * @Package com.shaunk.core.intercepter
 * @Name GlobalInterceptor
 * @Version 1.0
 * @Data: 2019/6/28 4:45 PM
 * @Author: shaunk
 * @Description: 全局拦截器
 */
@Slf4j
@Component
public class GlobalInterceptor extends HandlerInterceptorAdapter {


	@Autowired
	private UserServiceI userService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2)
			throws Exception {

		log.info("全局拦截器");
		// 检查header 是否存在token
		String token = request.getHeader(JwtUtil.HEADER_AUTH);
		if (StringUtils.isEmpty(token)){
			log.error("<缺少token>,请重新登录");
			throw new UserNoLoginException("缺少token,请重新登录");
		}

		// 检查token 是否合法
		String userId = JwtUtil.validateToken(token);
		if (StringUtils.isEmpty(userId)){
			log.error("<token失效>,请重新登录,token->{}", token);
			throw new UserAuthExpireException("token已过期,请重新登录");
		}

		// 获取用户信息
		UserInfo userInfo = userService.getUserInfoByCache(userId);
		if (userInfo == null){
			log.error("<登录失败>,请重新登录,token->{}", token);
			throw new UserAuthExpireException("token已失效,请重新登录");
		}

		// 检查token 是否为最新
		if (!token.equals(userInfo.getToken())){
			log.error("<登录失败>,请重新登录,token->{}", token);
			throw new UserAuthExpireException("token已失效,请重新登录");
		}

		// 放入UserContextHolder 中
		UserContextHolder.set(userInfo);

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3)
			throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {

		// 删除 放入UserContextHolder信息
		UserContextHolder.remove();
	}

	
//	private UserInfo getUser(HttpServletRequest request){
//		String userId = request.getHeader("user-id");
//		UserInfo user = new UserInfo();
//		user.setUserId(NumberUtils.toInt(userId, 14));
//		UserInfoVo user1 = userService.selectUserInfoById(user.getUserId());
//		if (user1 != null) {
//			user.setNickName(user1.getNickName());
//		}
//		return user;
//	}
}