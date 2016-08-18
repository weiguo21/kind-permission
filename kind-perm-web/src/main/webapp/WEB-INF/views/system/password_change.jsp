<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>修改密码</title>
<%@ include file="/WEB-INF/views/include/easyui.jsp"%>
</head>
<body>
	<div style="padding: 5px">
	<form id="mainform" action="${ctx }/system/user/changePassword" method="post">
	<table>
		<tr>
			<td>原密码：</td>
			<td>
			<input id="userId" name="userId" type="hidden"  value="${user.id}"/>
			<input id="originPassword" name="originPassword" type="password" class="required"/>
			</td>
		</tr>
		<tr>
			<td>密码：</td>
			<td><input id="targetPassword" name="targetPassword" type="password" class="required" minlength="6" maxlength="20"/></td>
		</tr>
		<tr>
			<td>确认密码：</td>
			<td><input id="confirmPassword" name="confirmPassword" type="password" class="required" equalTo="#targetPassword"/></td>
		</tr>
		<tr>
			<td><input id="submit" type="submit" value="submit" style="display: none"/></td>
			<td></td>
		</tr>
	</table>
	</form>
</div>
<script>
$(function(){
	$("#originPassword").focus();
	$("#mainform").validate({
		rules: {
			originPassword:{
				remote: "${ctx}/system/user/checkPassword"
			}
		},
		messages: {
			orginPassword:{
				remote: "原密码错误"
			}
		},
		 submitHandler:function(form){
			$("#mainform").ajaxSubmit(function(data){
				messageBox(data);
			});
        } 
	});
});
</script>
</body>
</html>