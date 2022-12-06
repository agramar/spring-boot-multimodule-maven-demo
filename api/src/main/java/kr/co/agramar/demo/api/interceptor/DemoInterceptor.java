package kr.co.agramar.demo.api.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class DemoInterceptor implements HandlerInterceptor {

	private static final String START_TIME_KEY = "startTime";

	@Override
	public boolean preHandle(HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) {
		log.info("requestUri : {}", request.getRequestURI());
		request.setAttribute(START_TIME_KEY, System.currentTimeMillis());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler, @Nullable ModelAndView modelAndView) {
		long startTime = (Long) request.getAttribute(START_TIME_KEY);
		request.removeAttribute(START_TIME_KEY);

		long endTime = System.currentTimeMillis();
		log.info("elapsed time : {}ms", endTime - startTime);
	}
}
