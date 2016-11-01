/**
 * Project Name:kafa-common-base
 * File Name:PropertyReloader.java
 * Package Name:com.kind.common.config
 * Date:2016-4-28下午4:13:07
 * Copyright (c) 2016, http://www.kindapp.net All Rights Reserved.
 *
 */
package com.kind.common.config;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
/**
 * 
 * @author weiguo21
 *
 */
@Component
public class PropertyReloader {

	@Resource(name = "propertyConfigurer")
	private CustomizedPropertyConfigurer customizedPropertyConfigurer;

	@Scheduled(initialDelay = 10 * 60 * 1000, fixedDelay = 5 * 60 * 1000)
	public void reload() {
		customizedPropertyConfigurer.reload();
	}

}
