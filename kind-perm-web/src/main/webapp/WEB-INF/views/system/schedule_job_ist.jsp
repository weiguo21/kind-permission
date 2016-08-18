<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title></title>
<%@ include file="/WEB-INF/views/include/easyui.jsp"%>
</head>
<body>
<div id="tt" class="easyui-tabs">   
    <div title="计划中的任务" data-options="refreshable: false">   
        <div id="tb" style="padding:5px;height:auto">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-standard-clock-add" plain="true" onclick="add();">添加</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-standard-clock-pause" plain="true" onclick="stop();">暂停</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-standard-clock" plain="true" onclick="resume();">恢复</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-standard-clock-delete" plain="true" onclick="del();">删除</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-standard-clock-edit" plain="true" onclick="upd();">修改表达式</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-standard-clock-play" plain="true" onclick="startNow();">立即运行一次</a>
		</div>
		<table id="dg"></table>   
    </div>   
    <div title="运行中的任务" data-options="refreshable: false">   
        <table id="dg_running"></table>    
    </div>   
</div>  

<div id="dlg"></div>  
<script type="text/javascript">
var dg;
var dg_running;
var d;
$(function(){   
	dg=$('#dg').datagrid({    
    url:'${ctx}/system/scheduleJob/json', 
    fit : true,
	fitColumns : true,
	border : false,
	idField : 'id',
	striped:true,
	pagination:true,
	rownumbers:true,
	pageNumber:1,
	pageSize : 20,
	pageList : [ 10, 20, 30, 40, 50 ],
	remoteSort:false,
	singleSelect:true,
    columns:[[    
        {field:'name',title:'任务名',sortable:true,width:30},    
        {field:'group',title:'任务组',sortable:true,width:30},
        {field:'cronExpression',title:'cron表达式',sortable:true,width:70,editor: "text"},
        {field:'status',title:'状态',sortable:true,width:30},
        {field:'className',title:'任务类',sortable:true},
        {field:'description',title:'描述',sortable:true}
    ]],
    toolbar:'#tb',
    autoEditing: true,          //该属性启用双击行时自定开启该行的编辑状态
    singleEditing: true,
    onAfterEdit:function(rowIndex, rowData, changes){
    	sureUpd(rowData);
    }
	});
	
});

$('#tt').tabs({    
	fit:true,
    border:false,    
    onSelect:function(title,index){    
    	if(index==1){
    		dg_running=$('#dg_running').datagrid({    
    		    url:'${ctx}/system/scheduleJob/running/json', 
    		    fit : true,
    			fitColumns : true,
    			border : false,
    			idField : 'id',
    			striped:true,
    			pagination:true,
    			rownumbers:true,
    			pageNumber:1,
    			pageSize : 20,
    			pageList : [ 10, 20, 30, 40, 50 ],
    			remoteSort:false,
    			singleSelect:true,
    		    columns:[[    
    		        {field:'name',title:'任务名',sortable:true,width:30},    
    		        {field:'group',title:'任务组',sortable:true,width:30},
    		        {field:'cronExpression',title:'cron表达式',sortable:true,width:70,editor: "text"},
    		        {field:'status',title:'状态',sortable:true,width:30},
    		        {field:'className',title:'任务类',sortable:true},
    		        {field:'description',title:'描述',sortable:true}
    		    ]]
    			});
    	}
    }    
});  

//添加
function add() {
	d=$("#dlg").dialog({   
	    title: '添加定时任务',    
	    width: 300,    
	    height: 200,    
	    href:'${ctx}/system/scheduleJob/add',
	    modal:true,
	    buttons:[{
			text:'确认',
			handler:function(){
				$("#mainform").submit(); 
			}
		},{
			text:'取消',
			handler:function(){
					d.panel('close');
				}
		}]
	});
}

//暂停
function stop(){
	var row = dg.datagrid('getSelected');
	if(rowIsNull(row)) return;
	parent.$.messager.confirm('提示', '确定要暂停任务？', function(data){
		if (data){
			$.ajax({
				type:'get',
				url:"${ctx}/system/scheduleJob/"+row.name+"/"+row.group+"/stop",
				success: function(data){
					if(data=='success'){
						dg.datagrid('reload');
						parent.$.messager.show({ title : "提示",msg: "操作成功！", position: "bottomRight" });
					}else{
						parent.$.messager.alert(data);
					}  
				}
			});
		}
	});
}

//恢复
function resume(){
	var row = dg.datagrid('getSelected');
	if(rowIsNull(row)) return;
	parent.$.messager.confirm('提示', '确定要恢复任务？', function(data){
		if (data){
			$.ajax({
				type:'get',
				url:"${ctx}/system/scheduleJob/"+row.name+"/"+row.group+"/resume",
				success: function(data){
					if(data=='success'){
						dg.datagrid('reload');
						parent.$.messager.show({ title : "提示",msg: "操作成功！", position: "bottomRight" });
					}else{
						parent.$.messager.alert(data);
					}  
				}
			});
		}
	});
}

//删除
function del(){
	var row = dg.datagrid('getSelected');
	if(rowIsNull(row)) return;
	parent.$.messager.confirm('提示', '删除后无法恢复您确定要删除？', function(data){
		if (data){
			$.ajax({
				type:'get',
				url:"${ctx}/system/scheduleJob/"+row.name+"/"+row.group+"/delete",
				success: function(data){
					if(data=='success'){
						dg.datagrid('reload');
						parent.$.messager.show({ title : "提示",msg: "操作成功！", position: "bottomRight" });
					}else{
						parent.$.messager.alert(data);
					}  
				}
			});
		}
	});
}

//修改表达式
function upd(){
	var row = dg.datagrid('getSelected');
	if(rowIsNull(row)) return;
	var rowIndex=dg.datagrid('getRowIndex',row);
	dg.datagrid('beginEdit',rowIndex);
}

//确认修改
function sureUpd(row){
	parent.$.messager.confirm('提示', '确定要修改任务？', function(data){
		if (data){
			$.ajax({
				type:'get',
				url:"${ctx}/system/scheduleJob/"+row.name+"/"+row.group+"/update",
				data:"cronExpression="+row.cronExpression,
				success: function(data){
					if(data=='success'){
						dg.datagrid('reload');
						parent.$.messager.show({ title : "提示",msg: "操作成功！", position: "bottomRight" });
					}else{
						parent.$.messager.alert(data);
					}  
				}
			});
			d.panel('close');
		}else{
			dg.datagrid('rejectChanges');
		}
	});
}

//立即运行一次
function startNow(){
	var row = dg.datagrid('getSelected');
	if(rowIsNull(row)) return;
	parent.$.messager.confirm('提示', '确定要立即运行一次该任务？', function(data){
		if (data){
			$.ajax({
				type:'get',
				url:"${ctx}/system/scheduleJob/"+row.name+"/"+row.group+"/startNow",
				success: function(data){
					if(data=='success'){
						//dg.datagrid('reload');
						parent.$.messager.show({ title : "提示",msg: "操作成功！", position: "bottomRight" });
					}else{
						parent.$.messager.alert(data);
					}  
				}
			});
		}
	});
}

</script>
</body>
</html>