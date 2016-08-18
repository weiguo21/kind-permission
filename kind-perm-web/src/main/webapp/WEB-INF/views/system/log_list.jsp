<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title></title>
<%@ include file="/WEB-INF/views/include/easyui.jsp"%>
<script src="${ctx}/static/plugins/My97DatePicker/WdatePicker.js" type="text/javascript"></script>

</head>
<body style="font-family: '微软雅黑'">
<div id="tb" style="padding:5px;height:auto">
		<form id="searchFrom" action="">
			<input type="text" name="filter_LIKES_operationCode" class="easyui-validatebox" data-options="width:150,prompt: '操作编码'"/>
			<input type="text" name="filter_LIKES_description" class="easyui-validatebox" data-options="width:150,prompt: '操作内容'"/>
	        <input type="text" name="filter_GTD_createDate" class="easyui-my97" datefmt="yyyy-MM-dd HH:mm:ss" data-options="width:150,prompt: '操作开始日期'" />
	        - <input type="text" name="filter_LTD_createDate" class="easyui-my97" datefmt="yyyy-MM-dd HH:mm:ss" data-options="width:150,prompt: '操作结束日期'"/>
	        <a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-search" onclick="cx()">查询</a>
		</form>
        <shiro:hasPermission name="sys:log:delete">
       	<a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-remove" onclick="delM()">删除</a>
       	<span class="toolbar-item dialog-tool-separator"></span>
       	</shiro:hasPermission>
       	<shiro:hasPermission name="sys:log:exportExcel">
       	<a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-standard-page-excel" onclick="exportExcel()">导出Excel</a>
       	</shiro:hasPermission>
    </div>
<table id="dg"></table> 
<div id="dlg"></div>  
<script type="text/javascript">
var dg;
$(function(){   
	dg=$('#dg').datagrid({  
	method: "get",
    url:'${ctx}/system/log/json', 
    fit : true,
	fitColumns : true,
	border : false,
	striped:true,
	idField : 'id',
	pagination:true,
	rownumbers:true,
	pageNumber:1,
	pageSize : 30,
	pageList : [ 10, 20, 30, 40, 50 ],
    columns:[[    
		{field:'ck',checkbox:true},  
		{field:'id',title:'id',hidden:true},  
		{field:'creater',title:'用户',sortable:true},
		{field:'createDate',title:'操作时间',sortable:true},
        {field:'operationCode',title:'操作编码',sortable:true},    
        {field:'description',title:'内容',sortable:true,width:100,},
        {field:'requestParam',title:'参数',sortable:true,width:100,},
      	{field:'executeTime',title:'执行时间(mm)',sortable:true},
      	{field:'ip',title:'IP',sortable:true},
      	{field:'os',title:'操作系统',sortable:true},
    	{field:'browser',title:'浏览器',sortable:true}
    ]],
    headerContextMenu: [
        {
            text: "冻结该列", disabled: function (e, field) { return dg.datagrid("getColumnFields", true).contains(field); },
            handler: function (e, field) { dg.datagrid("freezeColumn", field); }
        },
        {
            text: "取消冻结该列", disabled: function (e, field) { return dg.datagrid("getColumnFields", false).contains(field); },
            handler: function (e, field) { dg.datagrid("unfreezeColumn", field); }
        }
    ],
    enableHeaderClickMenu: true,
    enableHeaderContextMenu: true,
    enableRowContextMenu: false,
    rowTooltip: true,
    toolbar:'#tb'
});
});

//删除
function del(id){
		parent.$.messager.confirm('提示', '删除后无法恢复您确定要删除？', function(data){
			if (data){
				$.ajax({
					type:'get',
					url:"${ctx}/system/log/delete/"+id,
					success: function(data){
						successTip(data,dg);
					}
				});
			} 
		});

}

//删除多个
function delM(){
	var idList=[];
	var data=dg.datagrid('getSelections');
	for(var i=0,j=data.length;i<j;i++){
		idList.push(data[i].id);
	}
	
	var row = dg.datagrid('getSelected');
	if(rowIsNull(row)) return;
	parent.$.messager.confirm('提示', '删除后无法恢复您确定要删除？', function(data){
		if (data){
			$.ajax({
				type:'POST',
				url:"${ctx}/system/log/delete",
				data:JSON.stringify(idList),
				contentType:'application/json;charset=utf-8',
				success: function(data){
					if(data=='success'){
						dg.datagrid('reload');
						dg.datagrid('clearSelections');
						parent.$.messager.show({ title : "提示",msg: "操作成功！", position: "bottomRight" });
					} else{
						parent.$.messager.alert('提示',data);
					} 
				}
			});
			//dg.datagrid('reload'); //grid移除一行,不需要再刷新
		} 
	});
}

//创建查询对象并查询
function cx(){
	var obj=$("#searchFrom").serializeObject();
	dg.datagrid('load',obj); 
}

//导出excel
function exportExcel(){
	var url = "${ctx}/system/log/exportExcel";
	window.location.href = url;
}

</script>
</body>
</html>