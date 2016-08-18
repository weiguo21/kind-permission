<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title></title>
<%@ include file="/WEB-INF/views/include/easyui.jsp"%>
</head>
<body>
<div>
	<form id="mainform" action="${ctx}/template/community/${action}" method="post">
	<table  class="formTable">
		<tr>
			<td>市：</td>
			<td>
			<input type="hidden" name="id" value="${community.id }" />
			<input name="cityName" type="text" value="${community.cityName}" class="easyui-validatebox"  data-options="required:true,validType:['length[0,255]']" />
			</td>
		</tr>
		<tr>
			<td>市编码：</td>
			<td>
			<input name="cityCode" type="text" value="${community.cityCode}" class="easyui-validatebox"  data-options="required:true,validType:['length[0,255]']" />
			</td>
		</tr>
		<tr>
			<td>区：</td>
			<td>
			<input name="areaName" type="text" value="${community.areaName}" class="easyui-validatebox"  data-options="required:true,validType:['length[0,255]']" />
			</td>
		</tr>
		<tr>
			<td>区编码：</td>
			<td>
			<input name="areaCode" type="text" value="${community.areaCode}" class="easyui-validatebox"  data-options="required:true,validType:['length[0,255]']" />
			</td>
		</tr>
		<tr>
			<td>小区名称：</td>
			<td>
			<input name="community" type="text" value="${community.community}" class="easyui-validatebox"  data-options="required:true,validType:['length[0,255]']" />
			</td>
		</tr>
	</table>
	</form>
</div>
<script type="text/javascript">
$(function(){
	$('#mainform').form({    
	    onSubmit: function(){    
	    	var isValid = $(this).form('validate');
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