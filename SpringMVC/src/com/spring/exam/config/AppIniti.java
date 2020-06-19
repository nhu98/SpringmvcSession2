package com.spring.exam.config;

import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppIniti extends AbstractAnnotationConfigDispatcherServletInitializer {
	 @Override
	protected Class<?>[] getRootConfigClasses() {
		
		return new Class[] {AppContext.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {WebMvcConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}
	
}
