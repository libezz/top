package top.system;

import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import top.service.DefaultService;

@Component
public class RefererInterceptor extends HandlerInterceptorAdapter {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private DefaultService defaultService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String uri = defaultService.getURI(request);
		if("/index.html".equals(uri)) {
			return true;
		}
		String referer = request.getHeader("referer");
		if(StringUtils.isBlank(referer)) {
			response.sendRedirect("/");
			return false;
		}
		String refHost = new URL(referer).getHost();
		String reqHost = request.getServerName();
		if(reqHost.equals(refHost)) {
			return true;
		}
		logger.warn("【redirect】:{}<={}", defaultService.getIP(request), referer);
		response.sendRedirect("/");
		return false;
	}
}
