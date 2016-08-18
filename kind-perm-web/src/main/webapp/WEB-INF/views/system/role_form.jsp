<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title></title>
<%@ include file="/WEB-INF/views/include/easyui.jsp"%>
</head>
<body>
<div>
	<form id="mainform" action="${ctx}/system/role/${action}" method="post">
	<table  class="formTable">
		<tr>
			<td>角色名：</td>
			<td>
			<input type="hidden" name="id" value="${id }" />
			<input id="name" name="name" type="text" value="${role.name }" class="easyui-validatebox"  data-options="width: 150,required:'required'"/>
			</td>
		</tr>
		<tr>
			<td>角色编码：</td>
			<td><input id="roleCode" name="code" type="text" value="${role.code }" class="easyui-validatebox"  data-options="width: 150,required:'required'" validType="length[0,30]"/></td>
		</tr>
		<tr>
			<td>排序：</td>
			<td><input id="sortNo" name="sortNo" type="text" value="${role.sortNo}" class="easyui-numberbox" data-options="width: 150" /></td>
		</tr>
		<tr>
			<td>描述：</td>
			<td><textarea rows="3" cols="41" name="description" style="font-size: 12px;font-family: '微软雅黑'">${role.description}</textarea></td>
		</tr>
	</table>
	</form>
</div>
<script type="text/javascript">
var action="${action}";
if(action=='change'){
	$('#roleCode').attr("readonly",true);
	$("#roleCode").css("background","#eee");
}

$(function(){
	$('#mainform').form({    
	    onSubmit: function(){    
	    	var isValid = $(this).form('validate');
			return isValid;	// 返回false终止表单提交
	    },    
	    success:function(data){   
	    	successTip(data,dg,d);
	    }    
	}); 
});

</script>
</body>
</html>