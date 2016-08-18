<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title></title>
<%@ include file="/WEB-INF/views/include/easyui.jsp"%>
</head>
<body>   
<table id="ur_dg" class="ztree"></table>
<script type="text/javascript">
	var ur_dg;
	var setting = {
	    	check: {
					enable: true,
					chkboxType: { "Y": "", "N": "" }
				},
			data: {
				simpleData: {
					enable: true,
					idKey: "id",
					pIdKey: "pid"
				},
				key: {
					name: "orgName"
				}

			}
		};
$(function (){
	//获取树
	$.ajax({
		async : false,
		url : '${ctx}/system/organization/json',
		type : "get",
		dataType : "json",
		success : function(datas) {
			ur_dg = $.fn.zTree.init($("#ur_dg"), setting, datas);
		},
		error : function(event, errors) {
			$.easyui.messager.alert("加载失败");
		}
	});
	//勾选默认值
	$.ajax({
		async:false,
		type:'get',
		url:"${ctx}/system/user/${userId}/org",
		success: function(data){
			if(data){
				for(var i=0,j=data.length;i<j;i++){
					//ur_dg.datagrid('selectRecord',data[i]);
					//console.info(data[i]);
					var nodes = ur_dg.getNodesByParam("id", data[i], null);//根据org的ID值获取符合的节点
					//console.info(nodes);
					for (var d=0, b=nodes.length; d < b; d++) {//对符合的节点进行遍历勾选
						ur_dg.checkNode(nodes[d], true  , false );
					}
				}
			} 
		},
		error : function(event, errors) {
			$.easyui.messager.alert("加载失败");
		}
	});
})
	
	//保存用户机构
	function saveUserOrg() {
		var newRoleList = [];
		var data = ur_dg.getCheckedNodes(true);
		//所选的机构列表
		for (var i = 0, j = data.length; i < j; i++) {
			console.info(data[i].id);
			newRoleList.push(data[i].id);
		}
		
		$.ajax({
			async : false,
			type : 'POST',
			data : JSON.stringify(newRoleList),
			contentType : 'application/json;charset=utf-8', //必须
			url : "${ctx}/system/user/${userId}/updateOrg",
			success : function(data) {
				if (data == 'success') {
					parent.$.messager.show({
						title : "提示",
						msg : "操作成功！",
						position : "bottomRight"
					});
				} else {
					$.easyui.messager.alert(data);
				}
			}
		});
		
	}
</script>
</body>
</html>