<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title></title>
<%@ include file="/WEB-INF/views/include/easyui.jsp"%>
</head>
<body>   
<table id="ur_dg"></table>
<script type="text/javascript">
	var ur_dg;
	ur_dg=$('#ur_dg').datagrid({    
	method: "get",
	url:'${ctx}/system/role/json', 
    fit : true,
	fitColumns : true,
	border : false,
	idField : 'id',
	pagination:true,
	rownumbers:true,
	pageNumber:1,
	pageSize : 10,
	pageList : [ 10, 20, 30, 40, 50 ],
	striped:true,
    columns:[[    
		{field:'ck',checkbox:true},
        {field:'id',title:'id',hidden:true,sortable:true,width:100},    
        {field:'name',title:'角色名称',sortable:true,width:100},
        {field:'roleCode',title:'角色编码',sortable:true,width:100},
        {field:'description',title:'描述',sortable:true,width:100,tooltip: true}
    ]],
    onLoadSuccess:function(){
    	//获取用户拥有角色,选中.
    	$.ajax({
    		async:false,
			type:'get',
			url:"${ctx}/system/user/${userId}/role",
			success: function(data){
				if(data){
					for(var i=0,j=data.length;i<j;i++){
						ur_dg.datagrid('selectRecord',data[i]);
					}
				} 
			}
		});
    }
	});

//保存用户角色
function saveUserRole(){
	var newRoleList=[];
	var data=ur_dg.datagrid('getSelections');
	//所选的角色列表
	for(var i=0,j=data.length;i<j;i++){
		newRoleList.push(data[i].id);
	}
	$.ajax({
		async:false,
		type:'POST',
		data:JSON.stringify(newRoleList),
		contentType:'application/json;charset=utf-8',	//必须
		url:"${ctx}/system/user/${userId}/changeRole",
		success: function(data){
			if(data=='success'){
				parent.$.messager.show({ title : "提示",msg: "操作成功！", position: "bottomRight" });
			}else{
				$.easyui.messager.alert(data);
			}
		}
	});
}
</script>
</body>
</html>