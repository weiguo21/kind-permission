<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title></title>
<%@ include file="/WEB-INF/views/include/easyui.jsp"%>
</head>
<body>
<div>
	<form id="mainform" action="${ctx}/system/permission/${action}" method="post">
	<table  class="formTable">
		<tr>
			<td>菜单名称：</td>
			<td>
				<input type="hidden" name="id" value="${permission.id }"/>
				<input type="hidden" name="type" value="F"/>
				<input id="name" name="name" type="text" value="${permission.name }" class="easyui-validatebox" data-options="width: 180,required:'required',validType:'length[2,20]'"/>
			</td>
		</tr>
		<tr>
			<td>菜单路径：</td>
			<td><input id="url" name="url" type="text" value="${permission.url }" class="easyui-validatebox"  data-options="width: 180" class="easyui-validatebox"/></td>
		</tr>
		<tr>
			<td>菜单图标：</td>
			<td>
				<select id="icon" name="icon" class="easyui-comboicons" data-options="width: 180, autoShowPanel: false, multiple: false, size: '16', value: '${permission.icon }'"></select>
			</td>
		</tr>
		<tr>
			<td>上级菜单：</td>
			<td><input id="parentId" name="parentId" value="${permission.parentId}"/></td>
		</tr>
		<tr>
			<td>排序：</td>
			<td><input id="sortNo" type="text" name="sortNo" value="${permission.sortNo }" class="easyui-numberbox" data-options="width: 180" /></td>
		</tr>
		<tr>
			<td>描述：</td>
			<td><textarea rows="3" cols="41" name="description">${permission.description}</textarea></td>
		</tr>
	</table>
	</form>
</div> 
<script type="text/javascript">
//父级权限
var action="${action}";
if(action=='save'){
	$('#parentId').val(parentPermId);
}else if(action=='update'){
	$('#parentId').val(parentPermId);
}

//上级菜单
$('#parentId').combotree({
	width:180,
	method:'GET',
    url: '${ctx}/system/permission/menu/json',
    idField : 'id',
    textFiled : 'name',
	parentField : 'parentId',
	iconCls: 'icon',
    animate:true
});  

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


</script>
</body>
</html>