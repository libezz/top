package top.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SuppressWarnings("deprecation")
@Configuration
public class TopServerConfigurer extends WebMvcConfigurerAdapter {

	@Autowired
	private RefererInterceptor refererInterceptor;
	@Autowired
	private LoggingInterceptor loggingInterceptor;
	@Autowired
	private RolesInterceptor rolesInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(refererInterceptor).addPathPatterns("/**");
		registry.addInterceptor(loggingInterceptor).addPathPatterns("/**");
		registry.addInterceptor(rolesInterceptor).addPathPatterns("/**");
		super.addInterceptors(registry);
	}
}
