package com.kind.common.validation;

import java.lang.reflect.Field;

import com.kind.common.uitls.StringUtils;
import com.kind.common.validation.annotation.Validation;
/**
 * 
 * Function:验证工具类. <br/>
 * @date:2016年4月23日 下午1:43:28 <br/>
 * @author weiguo.liu
 * @version:
 * @since:JDK 1.7
 */
public class ValidateProvider {
	/**
	 * validation resource。
	 */
	private static Validation validation;

	/**
	 * 默认构造。
	 */
	public ValidateProvider() {
		super();
	}

	/**
	 * 解析的入口。
	 * 
	 * @param object
	 * @throws Exception
	 */
	public static void valid(Object object) throws Exception {
		/**
		 * 获取object的类型
		 */
		Class<? extends Object> clazz = object.getClass();
		/**
		 * 获取该类型声明的成员
		 */
		Field[] fields = clazz.getDeclaredFields();
		/**
		 * 遍历属性
		 */
		for (Field field : fields) {
			/**
			 * 对于private私有化的成员变量，通过setAccessible来修改器访问权限
			 */
			field.setAccessible(true);
			validate(field, object);
			/**
			 * 重新设置会私有权限
			 */
			field.setAccessible(false);
		}
	}

	public static void validate(Field field, Object object) throws Exception {

		String description;
		Object value;

		/**
		 * 获取对象的成员的注解信息
		 */
		validation = field.getAnnotation(Validation.class);
		value = field.get(object);
		if (validation == null)
			return;
		description = validation.description().equals("") ? field.getName()
				: validation.description();
		/**
		 * 注解解析
		 */
		if (!validation.isEmpty()) {
			if (value == null || StringUtils.isBlank(value.toString())) {
				throw new Exception(description + "不能为空");
			}
		}

		if (value.toString().length() > validation.maxLength()
				&& validation.maxLength() != 0) {
			throw new Exception(description + "长度不能超过" + validation.maxLength());
		}

		if (value.toString().length() < validation.minLength()
				&& validation.minLength() != 0) {
			throw new Exception(description + "长度不能小于" + validation.minLength());
		}
		if (validation.regexType() != RegexType.NONE) {
			switch (validation.regexType()) {
			case NONE:
				break;
			case SPECIAL_CHAR:
				if (RegexUtils.hasSpecialChar(value.toString())) {
					throw new Exception(description + "不能含有特殊字符");
				}
				break;
			case CHINESE:
				if (RegexUtils.isChinese2(value.toString())) {
					throw new Exception(description + "不能含有中文字符");
				}
				break;
			case EMAIL:
				if (!RegexUtils.isEmail(value.toString())) {
					throw new Exception(description + "地址格式不正确");
				}
				break;
			case IP:
				if (!RegexUtils.isIpAddr(value.toString())) {
					throw new Exception(description + "地址格式不正确");
				}
				break;
			case NUMBER:
				if (!RegexUtils.isNumber(value.toString())) {
					throw new Exception(description + "不是数字");
				}
				break;
			case PHONE_NUMBER:
				if (!RegexUtils.isPhoneNumber(value.toString())) {
					throw new Exception(description + "不是数字");
				}
				break;
			default:
				break;
			}
		}

		if (StringUtils.isNotBlank(validation.regexp())) {
			if (value.toString().matches(validation.regexp())) {
				throw new Exception(description + "格式不正确");
			}
		}
	}
}
