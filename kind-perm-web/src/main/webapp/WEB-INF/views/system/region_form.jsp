<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title></title>
<%@ include file="/WEB-INF/views/include/easyui.jsp"%>

</head>
<body>
<div>
	<form id="mainform" action="${ctx}/system/area/${action}" method="post">
	<table  class="formTable">
		<tr>
			<td>区域名称：</td>
			<td>
			<input type="hidden" name="id" value="${id }" data-options="required:false"/>
			<input name="areaName" type="text" value="${areaInfo.areaName }" class="easyui-validatebox"  data-options="required:true,validType:['length[0,50]']" />
			</td>
		</tr>
		<tr>
			<td>区域代码：</td>
			<td>
			<input name="areaCode" type="text" value="${areaInfo.areaCode }" class="easyui-validatebox"  data-options="required:true,validType:['length[0,12]']" />
			</td>
		</tr>
		<tr>
			<td>上级区域名称：</td>
			<td><input id="pid" name="pid" type="text" value="${areaInfo.pid }" class="easyui-validatebox" data-options="required:true,validType:['length[0,9]']" /></td>
		</tr>
	</table>
	</form>
</div>
<script type="text/javascript">
$(function(){
	
	//上级菜单
	$('#pid').combotree({
		width:180,
		method:'GET',
	    url: '${ctx}/system/area/json',
	    idField : 'id',
	    textFiled : 'areaName',
		parentField : 'pid',
	    animate:true
	});  
	
	$('#mainform').form({    
	    onSubmit: function(){    
	    	var isValid = $(this).form('validate');
	    	console.log(isValid);
			return isValid;	// 返回false终止表单提交
	    },    
	    success:function(data){   
	    	if(successTip(data,dg,d))
	    		dg.treegrid('reload');
	    }    
	}); 
});

</script>
</body>
</html>