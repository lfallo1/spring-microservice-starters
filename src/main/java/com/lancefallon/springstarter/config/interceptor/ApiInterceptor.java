package com.lancefallon.springstarter.config.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * Interceptor designed to allow only logged in users to pass through
 * @author lfallon
 *
 */
@Component
public class ApiInterceptor implements HandlerInterceptor {

	private static final Logger logger = LogManager.getLogger(ApiInterceptor.class);
	
	@Override
	public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object handler, Exception ex)
			throws Exception {
		//stub
	}

	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse res, Object handler, ModelAndView ex)
			throws Exception {
		// stub
	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) {

		logger.debug("hello from the Api interceptor");

		return true;
	}

}
