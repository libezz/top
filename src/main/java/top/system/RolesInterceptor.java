package top.system;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import top.entity.UserPO;
import top.entity.VisitorPO;
import top.global.SessionField;
import top.service.DefaultService;
import top.type.URIGroupType;
import top.utils.RoleUtils;
import top.utils.URIUtils;

@Component
public class RolesInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private DefaultService defaultService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = defaultService.getSession(request);
		VisitorPO visitor = (VisitorPO) session.getAttribute(SessionField.VISITOR);
		if(visitor == null) {
			visitor = defaultService.initVisit();
			session.setAttribute(SessionField.VISITOR, visitor);
			session.setAttribute(SessionField.USER, new UserPO());
		}
		UserPO user = (UserPO) session.getAttribute(SessionField.USER);
		URIGroupType group = URIUtils.groupURI(defaultService.getURI());
		if(RoleUtils.isRole(user.getSumRole(), group)) {
			return true;
		} else {
			request.getRequestDispatcher("/default/unrole").forward(request, response);
			return false;
		}
	}
}
