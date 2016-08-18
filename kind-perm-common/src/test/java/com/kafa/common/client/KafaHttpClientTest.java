/**
 * Project Name:kafa-common-base
 * File Name:KafaHttpClientTest.java
 * Package Name:com.kind.common.client
 * Date:2016年7月8日下午4:42:08
 * Copyright (c) 2016, http://www.mcake.com All Rights Reserved.
 *
*/

package com.kafa.common.client;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kind.common.client.KindHttpClient;

import junit.framework.TestCase;

/**
 * Function:KafaHttpClient单元测试. <br/>
 * Date: 2016年7月8日 下午4:42:08 <br/>
 * 
 * @author weiguo.liu
 * @version
 * @since JDK 1.7
 * @see
 */
public class KafaHttpClientTest extends TestCase {
	private static final Logger logger = LoggerFactory.getLogger(KafaHttpClientTest.class);

	@Test
	public void testGet() {
		String content = KindHttpClient.doGet("http://www.baidu.com");
		logger.debug("content:" + content);
	}

}
