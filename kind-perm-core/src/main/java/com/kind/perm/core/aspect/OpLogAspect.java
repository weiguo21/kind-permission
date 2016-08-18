/**
 * Project Name:kafa-common-base
 * File Name:LogAspect.java
 * Package Name:com.kind.common.trace.aspect
 * Date:2016年7月22日下午4:23:26
 * Copyright (c) 2016, http://www.mcake.com All Rights Reserved.
 *
*/

package com.kind.perm.core.aspect;

import java.io.StringWriter;
import java.lang.reflect.Method;

import javax.annotation.Resource;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;

import com.kind.common.contants.Modules;
import com.kind.common.contants.SubSystem;
import com.kind.common.trace.annotation.OpLogResouce;
import com.kind.perm.core.dao.OpLogDao;
import com.kind.perm.core.domain.OpLogDO;

/**
 * Function:操作日志切面. <br/>
 * Date: 2016年7月22日 下午4:23:26 <br/>
 * 
 * @author weiguo.liu
 * @version 1.0
 * @since JDK 1.7
 * @see
 */
public class OpLogAspect {
	@Resource
	private OpLogDao opLogDao;
	private Logger logger = LoggerFactory.getLogger(getClass());
	private static LocalVariableTableParameterNameDiscoverer parameterNameDiscovere = new LocalVariableTableParameterNameDiscoverer();

	/**
	 * 保存系统操作日志.
	 * 
	 * @param joinPoint
	 * 
	 * @return 方法执行结果
	 * @throws Throwable
	 */
	@Around(value = "@annotation(com.kind.common.trace.annotation.LogResouce)")
	public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
		/**
		 * 获取设置LogResource注解的方法
		 */
		Method method = getMethod(joinPoint);
		OpLogResouce opLogAnnotation = method.getAnnotation(OpLogResouce.class);
		SubSystem subSystem = opLogAnnotation.subSystem();
		Modules module = opLogAnnotation.module();
		String operation = opLogAnnotation.operation();
		String actor = analyzerTemplate(opLogAnnotation.actor(), joinPoint);
		String desc = analyzerTemplate(opLogAnnotation.content(), joinPoint);
		String ipAddr = analyzerTemplate(opLogAnnotation.ipAddr(), joinPoint);
		logger.debug("解析后描述为：" + desc);
		OpLogDO opLog = this.buildOpLog(subSystem,module, operation, actor, desc, ipAddr);
		opLogDao.saveOpLog(opLog);
		/**
		 * 方法执行前拦截
		 */
		return joinPoint.proceed();
	}

	/**
	 * 构造日志内容.
	 * 
	 * @param module
	 * @param content
	 * @param actor
	 * @param description
	 * @param ipAddr
	 * @return
	 */
	private OpLogDO buildOpLog(SubSystem subSystem,Modules module, String desc, String actor, String description, String ipAddr) {
		OpLogDO opLog = new OpLogDO();
		opLog.setSubSystem(subSystem.getCode());
		opLog.setModule(module.getCode());
		opLog.setOperation(desc);
		opLog.setActor(actor);
		opLog.setIpAddr(ipAddr);
		opLog.setContent(description);
		return opLog;
	}

	/**
	 * 解析模版.
	 * 
	 * @param template
	 * 
	 * @param joinPoint
	 * 
	 * @return 解析后描述
	 */
	private String analyzerTemplate(String template, ProceedingJoinPoint joinPoint) {
		Method method = getMethod(joinPoint);
		// 获取方法中定义的参数名称
		String[] parameterNames = parameterNameDiscovere.getParameterNames(method);
		// 获取参数实例对象
		Object[] args = joinPoint.getArgs();
		Velocity.init();
		VelocityContext context = new VelocityContext();
		StringWriter outString = new StringWriter();
		/**
		 * 向上下文中写入变量
		 */
		for (int i = 0; i < parameterNames.length; i++) {
			context.put(parameterNames[i], args[i]);
		}
		context.put("ip", "192.168.0.32");
		/**
		 * 解析模板
		 */
		Velocity.evaluate(context, outString, "mystring", template);
		return outString.toString();
	}

	/**
	 * 获取当前执行的方法.
	 * 
	 * @param joinPoint
	 * 
	 * @return 方法
	 */
	private Method getMethod(ProceedingJoinPoint joinPoint) {
		/**
		 * 获取方法签名
		 */
		String methodName = joinPoint.getSignature().getName();
		/**
		 * 获取目标类的所有方法
		 */
		Method[] methods = joinPoint.getTarget().getClass().getMethods();
		Method resultMethod = null;
		/**
		 * 查询当前调用的方法
		 */
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				// 找到当前要执行的方法
				resultMethod = method;
				break;
			}
		}
		return resultMethod;
	}
}
