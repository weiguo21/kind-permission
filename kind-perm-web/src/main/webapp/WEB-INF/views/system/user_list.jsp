<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title></title>
<%@ include file="/WEB-INF/views/include/easyui.jsp"%>
<script src="${ctx}/static/plugins/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
</head>
<body>
<div id="tb" style="padding:5px;height:auto">
        <div>
        	<form id="searchFrom" action="">
       	        <input type="text" name="username" class="easyui-validatebox" data-options="width:150,prompt: '昵称'"/>
       	        <input type="text" name="mobile" class="easyui-validatebox" data-options="width:150,prompt: '电话'"/>
		        <input type="text" name="createTimeStart" class="easyui-my97" datefmt="yyyy-MM-dd" data-options="width:150,prompt: '开始日期'"/>
		        - <input type="text" name="createTimeEnd" class="easyui-my97" datefmt="yyyy-MM-dd" data-options="width:150,prompt: '结束日期'"/>
		        <span class="toolbar-item dialog-tool-separator"></span>
		        <a href="javascript(0)" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="query()">查询</a>
			</form>
			<shiro:hasPermission name="sys:user:save">
	       		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="save();">添加</a>
	       		</shiro:hasPermission>
	       		<span class="toolbar-item dialog-tool-separator"></span>
	       		<shiro:hasPermission name="sys:user:remove">
	            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" data-options="disabled:false" onclick="removeUser()">删除</a>
	        	</shiro:hasPermission>
	        	<span class="toolbar-item dialog-tool-separator"></span>
	        	<shiro:hasPermission name="sys:user:change">
	            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="change()">修改</a>
	            </shiro:hasPermission>
	            <span class="toolbar-item dialog-tool-separator"></span>
	            <shiro:hasPermission name="sys:user:roleView">
        		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-hamburg-suppliers" plain="true" onclick="userForRole()">用户角色</a>
        		</shiro:hasPermission>
        </div> 
        
  </div>
<table id="dg"></table> 
<div id="dlg"></div>  
<script type="text/javascript">
var dg;
var d;
$(function(){   
	dg=$('#dg').datagrid({    
	method: "get",
    url:'${ctx}/system/user/json', 
    fit : true,
	fitColumns : true,
	border : false,
	idField : 'id',
	striped:true,
	pagination:true,
	rownumbers:true,
	pageNumber:1,
	pageSize : 20,
	pageList : [20],
	singleSelect:true,
	selectOnCheck: true,
	checkOnSelect: true,
    columns:[[
		{field:'ck',checkbox:true },
        {field:'id',title:'id',hidden:true},    
        {field:'username',title:'帐号',sortable:true,width:100},    
        {field:'name',title:'昵称',sortable:true,width:100},
        {field:'gender',title:'性别',sortable:true,
        	formatter : function(value, row, index) {
       			return value==1?'男':'女';
        	}
        },
        {field:'email',title:'email',sortable:true,width:100},
        {field:'mobile',title:'电话',sortable:true,width:100},
        {field:'visitCount',title:'登录次数',sortable:true},
        {field:'lastVisitTime',title:'上一次登录',sortable:true}
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
    toolbar:'#tb'
	});
});

//弹窗增加
function save() {
	d=$("#dlg").dialog({   
	    title: '添加用户',    
	    width: 380,    
	    height: 380,    
	    href:'${ctx}/system/user/toSave',
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

//删除
function removeUser(){
	var row = dg.datagrid('getSelected');
	if(rowIsNull(row)) return;
	parent.$.messager.confirm('提示', '删除后无法恢复您确定要删除？', function(data){
		if (data){
			$.ajax({
				type:'get',
				url:"${ctx}/system/user/remove/"+row.id,
				success: function(data){
					successTip(data,dg);
				}
			});
		} 
	});
}

//弹窗修改
function change(){
	var row = dg.datagrid('getSelected');
	if(rowIsNull(row)) return;
	d=$("#dlg").dialog({   
	    title: '修改用户',    
	    width: 380,    
	    height: 340,    
	    href:'${ctx}/system/user/change/'+row.id,
	    maximizable:true,
	    modal:true,
	    buttons:[{
			text:'修改',
			handler:function(){
				$('#mainform').submit(); 
			}
		},{
			text:'取消',
			handler:function(){
					d.panel('close');
				}
		}]
	});
}

//用户角色弹窗
function userForRole(){
	var row = dg.datagrid('getSelected');
	if(rowIsNull(row)) return;
	$.ajaxSetup({type : 'GET'});
	d=$("#dlg").dialog({   
	    title: '用户角色管理',    
	    width: 580,    
	    height: 350,  
	    href:'${ctx}/system/user/'+row.id+'/userRole',
	    maximizable:true,
	    modal:true,
	    buttons:[{
			text:'确认',
			handler:function(){
				saveUserRole();
				d.panel('close');
			}
		},{
			text:'取消',
			handler:function(){
					d.panel('close');
			}
		}]
	});
}
//用户机构弹窗
function userForOrg(){
	var row = dg.datagrid('getSelected');
	if(rowIsNull(row)) return;
	$.ajaxSetup({type : 'GET'});
	d=$("#dlg").dialog({   
	    title: '用户机构管理',    
	    width: 580,    
	    height: 350,  
	    href:'${ctx}/system/user/'+row.id+'/userOrg',
	    maximizable:true,
	    modal:true,
	    buttons:[{
			text:'确认',
			handler:function(){
				saveUserOrg();
				d.panel('close');
			}
		},{
			text:'取消',
			handler:function(){
					d.panel('close');
			}
		}]
	});
}

//查看
function look(){
	var row = dg.datagrid('getSelected');
	if(rowIsNull(row)) return;
	d=$("#dlg").dialog({   
	    title: '修改用户',    
	    width: 380,    
	    height: 340,    
	    href:'${ctx}/system/user/update/'+row.id,
	    maximizable:true,
	    modal:true,
	    buttons:[{
			text:'取消',
			handler:function(){
					d.panel('close');
				}
		}]
	});
}

//创建查询对象并查询
function query(){
	var obj=$("#searchFrom").serializeObject();
	dg.datagrid('load',obj); 
}

</script>
</body>
</html>