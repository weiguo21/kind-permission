/**
 * Project Name:kind-common-base
 * File Name:JSONMapper.java
 * Package Name:com.kind.common.mapper
 * Date:2016-4-28下午4:13:07
 * Copyright (c) 2016, http://www.kind.com All Rights Reserved.
 *
 */
package com.kind.common.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;

/**
 * Function:JSONMapper. <br/>
 * Date: 2016年5月4日 下午1:00:58 <br/>
 * 
 * @author weiguo21
 * @version
 * @since JDK 1.7
 * @see
 */
public class JSONMapper {
	private static Logger logger = LoggerFactory.getLogger(JSONMapper.class);
	private static SerializeConfig mapping = new SerializeConfig();
	private static String dateFormat;
	static {
		dateFormat = "yyyy-MM-dd HH:mm:ss";
		mapping.put(Date.class, new SimpleDateFormatSerializer(dateFormat));
	}

	private JSONMapper() {

	}

	private static class FastJsonMapperHolder {
		private static JSONMapper instance = new JSONMapper();
	}

	public static JSONMapper getInstance() {
		return FastJsonMapperHolder.instance;
	}

	/**
	 * 功能描述：把JSON数据转换成普通字符串列表.
	 * 
	 * @param jsonData.
	 *           
	 * @return
	 * @throws Exception
	 */
	public static List<String> getStringList(String jsonData) throws Exception {
		return JSON.parseArray(jsonData, String.class);
	}

	public String toJson(Object object) {
		try {
			return JSON.toJSONString(object);
		} catch (Exception e) {
			logger.warn("write to json string error:" + object, e);
			return null;
		}
	}

	/**
	 * 功能描述：把JSON数据转换成指定的java对象.
	 * 
	 * @param jsonData
	 * @param clazz指定的java对象
	 * @return
	 * @throws Exception
	 */
	public <T> T getSingleBean(String jsonData, Class<T> clazz) throws Exception {
		return JSON.parseObject(jsonData, clazz);
	}

	/**
	 * 功能描述：把JSON数据转换成指定的java对象列表.
	 * 
	 * @param jsonData
	 * @param clazz指定的java对象
	 * @return
	 * @throws Exception
	 */
	public <T> List<T> getBeanList(String jsonData, Class<T> clazz) throws Exception {
		return JSON.parseArray(jsonData, clazz);
	}

	/**
	 * 功能描述：把JSON数据转换成较为复杂的java对象列表.
	 * 
	 * @param jsonData
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getBeanMapList(String jsonData) throws Exception {
		return JSON.parseObject(jsonData, new TypeReference<List<Map<String, Object>>>() {
		});
	}

	/**
	 * 将网络请求下来的数据用fastJson处理空的情况，并将时间戳转化为标准时间格式.
	 * 
	 * @param result
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public String dealResponseResult(String result) {
		result = JSON.toJSONString(result, SerializerFeature.WriteClassName, SerializerFeature.WriteMapNullValue,
				SerializerFeature.WriteNullBooleanAsFalse, SerializerFeature.WriteNullListAsEmpty,
				SerializerFeature.WriteNullNumberAsZero, SerializerFeature.WriteNullStringAsEmpty,
				SerializerFeature.WriteDateUseDateFormat, SerializerFeature.WriteEnumUsingToString,
				SerializerFeature.WriteSlashAsSpecial, SerializerFeature.WriteTabAsSpecial);
		return result;
	}
}
