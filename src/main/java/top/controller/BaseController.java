package top.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import top.result.BaseResult;
import top.service.DefaultService;
import top.type.ResultStatusType;

public class BaseController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private DefaultService defaultService;
	
	@RequestMapping("/**")
	public BaseResult getMissing() {
		BaseResult result = new BaseResult();
		defaultService.setResultDes(result, ResultStatusType.MISSING);
		logger.warn("【missing】:{}=>{}", defaultService.getIP(), defaultService.getURI());
		return result;
	}
}
