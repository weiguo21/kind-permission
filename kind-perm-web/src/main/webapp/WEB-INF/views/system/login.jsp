<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter"%>
<%@ page import="org.apache.shiro.authc.ExcessiveAttemptsException"%>
<%@ page import="org.apache.shiro.authc.IncorrectCredentialsException"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%
String error = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
request.setAttribute("error", error);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<title>后台管理系统</title>
	<script src="${ctx}/static/plugins/easyui/jquery/jquery-1.11.1.min.js"></script>
	<link rel="stylesheet" type="text/css" href="${ctx}/static/css/bglogin.css" />
	<script>
	var captcha;
	function refreshCaptcha(){  
	    document.getElementById("img_captcha").src="${ctx}/static/images/kaptcha.jpg?t=" + Math.random();  
	}  
	</script>
</head>
<body>
	<div>
	<form id="loginForm" action="${ctx}/a/login" method="post">
		<div class="login_top">
			<div class="login_title">
				后台管理系统登录 
			</div>
		</div>
		<div style="float:left;width:100%;">
			<div class="login_main">
				<div class="login_main_top"></div>
				<div class="login_main_errortip">&nbsp;</div>
				<div class="login_main_ln">
					<input type="text" id="username" name="username" value=""/>
				</div>
				<div class="login_main_pw">
					<input type="password" id="password" name="password" value=""/>
				</div>
				<div class="login_main_remb">
					<input id="rm" name="rememberMe" type="hidden"/><!-- <label for="rm"><span>记住我</span></label> -->
				</div>
				<div class="login_main_submit">
					<button onclick=""></button>
				</div>
			</div>
		</div>
	</form>
	</div>
	<c:choose>
		<c:when test="${error eq 'com.kind.common.exception.CaptchaException'}">
			<script>
				$(".login_main_errortip").html("验证码错误，请重试");
			</script>
		</c:when>
		<c:when test="${error eq 'org.apache.shiro.authc.UnknownAccountException'}">
			<script>
				$(".login_main_errortip").html("帐号或密码错误，请重试");
			</script>
		</c:when>
		<c:when test="${error eq 'org.apache.shiro.authc.IncorrectCredentialsException'}">
			<script>
				$(".login_main_errortip").html("帐号或密码错误，请重试");
			</script>
		</c:when>
	</c:choose>
</body>
</html>
