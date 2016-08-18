/**
 * Project Name:kind-common-base
 * File Name:CustomizedPropertyConfigurer.java
 * Package Name:com.kind.common.config
 * Date:2016-4-28下午4:13:07
 * Copyright (c) 2016, http://www.kindapp.net All Rights Reserved.
 *
 */
package com.kind.common.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
/**
 * 
 * @author cary
 *
 */
@SuppressWarnings("unchecked")
public class CustomizedPropertyConfigurer extends PropertyPlaceholderConfigurer {

	private static Map<String, Object> ctxPropertiesMap;

	@Override
	protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props)
	      throws BeansException {
		super.processProperties(beanFactoryToProcess, props);
		ctxPropertiesMap = new HashMap<String, Object>();
		for (Object key : props.keySet()) {
			String keyStr = key.toString();
			String value = props.getProperty(keyStr);
			ctxPropertiesMap.put(keyStr, value);
		}
	}

	public static <T> T getContextProperty(String name) {
		return (T) ctxPropertiesMap.get(name);
	}

	@SuppressWarnings("rawtypes")
	public void reload() {
		try {
			Properties result = mergeProperties();
			// logger.error("reload properties!"+result);

			HashMap nc = new HashMap<String, Object>();
			nc.putAll(result);
			ctxPropertiesMap = nc;
		} catch (Exception ex) {
			logger.error("reload properties error!", ex);
		}
	}

}
