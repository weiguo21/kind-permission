<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title></title>
<%@ include file="/WEB-INF/views/include/easyui.jsp"%>
</head>
<body style="font-family: '微软雅黑'">
<div id="tb" style="padding:5px;height:auto">
    <div>
    	<shiro:hasPermission name="sys:perm:save">
    	<a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-add" onclick="toSave();">添加</a>
    	<span class="toolbar-item dialog-tool-separator"></span>
    	</shiro:hasPermission>
        <shiro:hasPermission name="sys:perm:remove">
        <a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-remove" onclick="removeMenu()">删除</a>
        <span class="toolbar-item dialog-tool-separator"></span>
        </shiro:hasPermission>
        <shiro:hasPermission name="sys:perm:change">
        <a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-edit" onclick="change()">修改</a>
        </shiro:hasPermission>
    </div>
</div>
<table id="dg"></table>
 
<div id="dlg"></div> 
<div id="icon_dlg"></div>  

<script type="text/javascript">
var dg;
var d;
var permissionDg;
var parentPermId;
$(function(){   
	dg=$('#dg').treegrid({  
	method: "get",
    url:'${ctx}/system/permission/menu/json', 
    fit : true,
	fitColumns : true,
	border : false,
	idField : 'id',
	treeField:'name',
	parentField : 'parentId',
	iconCls: 'icon',
	animate:true, 
	rownumbers:true,
	singleSelect:true,
	striped:true,
    columns:[[
		{field:'ck',checkbox:true },
        {field:'id',title:'id',hidden:true,width:100},    
        {field:'name',title:'名称',width:100},
        {field:'url',title:'资源路径',width:100},
        {field:'sort',title:'排序'},
        {field:'description',title:'描述',width:100}
    ]],
    enableHeaderClickMenu: false,
    enableHeaderContextMenu: false,
    enableRowContextMenu: false,
    onLoadSuccess: function(data){
    	if(data){
    		$.each(data.rows,
    		function(index,item){
    		  if(item.checked){
    			$('#dg').datagrid('checkRow',index);
    		  }
    		});
    	}
    },
    toolbar:'#tb',
    dataPlain: true
	});
	
});

//弹窗增加
function toSave() {
	//父级权限
	var row = dg.treegrid('getSelected');
	if(row){
		parentPermId=row.id;
	}
	
	d=$('#dlg').dialog({    
	    title: '添加菜单',    
	    width: 450,    
	    height: 320,    
	    closed: false,    
	    cache: false,
	    maximizable:true,
	    resizable:true,
	    href:'${ctx}/system/permission/menu/save',
	    modal: true,
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

//删除
function removeMenu(){
	var row = dg.treegrid('getSelected');
	if(rowIsNull(row)) return;
	parent.$.messager.confirm('提示', '删除后无法恢复您确定要删除？', function(data){
		if (data){
			$.ajax({
				type:'get',
				url:"${ctx}/system/permission/remove/"+row.id,
				success: function(data){
					if(successTip(data,dg))
			    		dg.treegrid('reload');
				}
			});
			//dg.datagrid('reload'); //grid移除一行,不需要再刷新
		} 
	});

}

//修改
function change(){
	var row = dg.treegrid('getSelected');
	if(rowIsNull(row)) return;
	//父级权限
	parentPermId=row.parentId;
	d=$("#dlg").dialog({   
	    title: '修改菜单',    
	    width: 450,    
	    height: 320,    
	    href:'${ctx}/system/permission/menu/change/'+row.id,
	    maximizable:true,
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

var nowIcon;
var icon_dlg;
</script>
</body>
</html>