<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title></title>
<%@ include file="/WEB-INF/views/include/easyui.jsp"%>
</head>
<body>
<div>
	<form id="mainform" action="${ctx}/system/user/${action}" method="post">
		<table class="formTable">
			<tr>
				<td>用户名：</td>
				<td>
					<input type="hidden" name="id" value="${user.id}"/>
					<input id="username" name="username" class="easyui-validatebox" data-options="width: 150,required:'required',validType:'length[4,20]'" value="${user.username}" /> 
				</td>
			</tr>
			<c:if test="${action != 'change'}">
			<tr>
				<td>密码：</td>
				<td><input id="password" name="password" type="password" class="easyui-validatebox" data-options="width: 150,required:'required',validType:'length[6,20]'"/></td>
			</tr>
			<tr>
				<td>确认密码：</td>
				<td><input id="confirmPassword" name="confirmPassword" type="password" class="easyui-validatebox" data-options="width: 150,required:'required',validType:'equals[$(\'#password\').val()]'"/></td>
			</tr>
			</c:if>
			<tr>
				<td>姓名：</td>
				<td><input name="name" type="text" value="${user.name }" class="easyui-validatebox" data-options="width: 150,required:'required',validType:'length[2,20]'"/></td>
			</tr>
			<tr>
				<td>出生日期：</td>
				<td><input name="birthday" type="text" class="easyui-my97" datefmt="yyyy-MM-dd" data-options="width: 150" value="<fmt:formatDate value="${user.birthday}"/>"/></td>
			</tr>
			<tr>
				<td>性别：</td>
				<td>
				<input type="radio" id="man" name="gender" value="1"/><label for="man">男</label>
				<input type="radio" id="woman" name="gender" value="0"/><label for="woman">女</label>
				</td>
			</tr>
			<tr>
				<td>Email：</td>
				<td><input type="text" name="email" value="${user.email }" class="easyui-validatebox" data-options="width: 150,validType:'email'"/></td>
			</tr>
			<tr>
				<td>电话：</td>
				<td><input type="text" name="mobile" value="${user.mobile }" class="easyui-validatebox"  data-options="width: 150"/></td>
			</tr>
			<tr>
				<td>描述：</td>
				<td><textarea rows="3" cols="41" name="description" style="font-size: 12px;font-family: '微软雅黑'">${user.description}</textarea></td>
			</tr>
		</table>
	</form>
</div>

<script type="text/javascript">
var action="${action}";
//用户 添加修改区分
if(action=='save'){
	$("input[name='gender'][value=1]").attr("checked",true); 
	//用户名存在验证
/* $("#username").validatebox({    
	    required: true,    
	    validType:{
	    	remote:["${ctx}/system/user/checkUsername","username"]
	    }
	});  */
}else if(action=='change'){
	$("#username").attr('readonly','readonly');
	$("input[name='username']").css('background','#eee')
	$("input[name='gender'][value=${user.gender}]").attr("checked",true);
}

//提交表单
$('#mainform').form({    
    onSubmit: function(){    
    	var isValid = $(this).form('validate');
		return isValid;	// 返回false终止表单提交
    },    
    success:function(data){   
    	successTip(data,dg,d);
    }    
});    
</script>
</body>
</html>