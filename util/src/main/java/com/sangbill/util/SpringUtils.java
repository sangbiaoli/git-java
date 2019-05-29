package com.sangbill.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy(false)
public class SpringUtils implements ApplicationContextAware,DisposableBean {

	private static ApplicationContext context;

	private SpringUtils() {
	}

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		SpringUtils.context = context;
	}
	
	//清空applicationContext 设置其为null
    @Override
    public void destroy() throws Exception {
        SpringUtils.clearHolder();
    }
    
    public static void clearHolder(){
        context=null;
    }

	public static <T> T getBean(Class<T> clazz) {
		if (clazz == null)
			return null;
		return context.getBean(clazz);
	}

	public static <T> T getBean(String beanName, Class<T> clazz) {
		if (null == beanName || "".equals(beanName.trim())) {
			return null;
		}
		if (clazz == null)
			return null;
		return (T) context.getBean(beanName, clazz);
	}

	public static ApplicationContext getContext() {
		if (context == null)
			return null;
		return context;
	}

	public static void publishEvent(ApplicationEvent event) {
		if (context == null)
			return;
		context.publishEvent(event);
	}

}