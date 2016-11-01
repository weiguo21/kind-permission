package com.kind.common.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.kind.common.validation.RegexType;

/**
 * 
 * Function:数据验证注解. <br/>
 * 
 * @date:2016年5月13日 下午1:41:36 <br/>
 * @author weiguo.liu
 * @version:
 * @since:JDK 1.7
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
public @interface Validation {

	/**
	 * 是否可以为空 isEmpty:. <br/>
	 * TODO
	 * 
	 * @author weiguo.liu
	 * @return
	 */
	boolean isEmpty() default false;

	/**
	 * 最大长度 maxLength:. <br/>
	 * TODO
	 * 
	 * @author weiguo.liu
	 * @return
	 */
	int maxLength() default 0;

	/**
	 * 最小长度 minLength:. <br/>
	 * TODO
	 * 
	 * @author weiguo.liu
	 * @return
	 */
	int minLength() default 0;

	/**
	 * 提供几种常用的正则验证 regexType:. <br/>
	 * TODO
	 * 
	 * @author weiguo.liu
	 * @return
	 */
	RegexType regexType() default RegexType.NONE;

	/**
	 * 自定义正则验证. <br/>
	 * 
	 * @author weiguo.liu
	 * @return
	 */
	String regexp() default "";

	/**
	 * 参数或者字段描述,这样能够显示友好的异常信息
	 * 
	 * @author weiguo.liu
	 * @return
	 */
	String description() default "";

}
