package top.service;

import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.entity.VisitorPO;
import top.global.VisitorRole;
import top.repository.VisitorRepository;

@Service
public class DefaultService extends BaseService {

	@Autowired
	private VisitorRepository visitorRepository;
	
	public VisitorPO initVisit() {
		String ip = getIP();
		VisitorPO visitor = visitorRepository.findByVisitIp(ip);
		if(visitor == null) {
			visitor = new VisitorPO();
			visitor.setVisitIp(ip);
		} else if(!DateUtils.isSameDay(visitor.getLastModifiedDate(), new Date())) {
			visitor.setMessageCount(VisitorRole.MESSAGE_COUNT);
			visitor.setSignUpCount(VisitorRole.SIGN_UP_COUNT);
		}
		visitor.setVisitCount(visitor.getVisitCount() + 1);
		visitorRepository.save(visitor);
		return visitor;
	}
}
