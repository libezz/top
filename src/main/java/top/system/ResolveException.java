package top.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import top.result.BaseResult;
import top.service.DefaultService;
import top.type.ResultStatusType;

@ControllerAdvice
public class ResolveException {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private DefaultService defaultService;
	
	@ExceptionHandler(TopServerException.class)
	@ResponseBody
	public BaseResult resolveTopServerException(Exception e) {
		BaseResult result = new BaseResult();
		defaultService.setResultDes(result, ResultStatusType.THROW, e.getMessage());
		logger.warn("【{}】:{}=>{}", e.getMessage(), defaultService.getIP(), defaultService.getURI());
		return result;
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public BaseResult resolveException(Exception e) {
		BaseResult result = new BaseResult();
		defaultService.setResultDes(result, ResultStatusType.EXCEPTION);
		logger.warn("【{}】:{}=>{}, {}", e.getClass().getName(), defaultService.getIP(), defaultService.getURI(), e.getMessage());
		return result;
	}
}
