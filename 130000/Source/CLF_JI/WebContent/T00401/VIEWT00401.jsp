<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>体外评估管理</title>
<link type="text/css" rel="stylesheet" href="../css/screen.css" />
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript"	src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"	src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	$(function() {
	    $.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
	    $.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>'});
	    
		$('#dg').datagrid({
			striped : true,
			pagination : true,
			rownumbers : true,
			height : getGirdHeight(),
			url : '../sjcj/FINDT00401.do',
			onLoadError : function() {
				$.messager.alert('错误信息', '请求已发送，服务器无应答！', 'error');
			},
			queryParams : {
				qQlr : $("#txtQLR").val(),
				qGyqk : $("#txtGYQK").val()
			},
			frozenColumns : [[{
					title : '操作',
					field : 'id',
					formatter:function(value,row,index){
						return "<a href=\"javascript:showpParentWin('[体外评估编辑]','sjcj/LOADT00401.do?act=U&pk=" + value +"','frameTWPGGL'); \"><img src=\"../images/ico/Edit.gif\" alt=\"编辑\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a><a href=\"javascript:showpParentWin('[体外评估编辑]','sjcj/LOADT00401.do?act=D&pk=" + value +"','frameTWPGGL'); \"><img src=\"../images/ico/Delete.gif\" alt=\"删除\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>";
					},
					align : 'center',
					width : 40
			}]],
			columns : [ [ {
				title : '不动产证号',
				field : 'bdczh',
				width : 300
			}, {
				title : "合同价格",
				field : "htjg",
				width : 100,
				align : 'right',
				formatter:function (value, row, index) {
                    if (row != null) {
                    	return formatNumber(value, '#,##0.00');
                    }
             }}, {
				title : "评估价格",
				field : "pgjg",
				width : 100,
				align : 'right',
				formatter:function (value, row, index) {
                    if (row != null) {
                    	return formatNumber(value, '#,##0.00');
                    }
             }}, {
				title : "建筑面积",
				field : "jzmj",
				width : 100,
				align : 'right',
				formatter:function (value, row, index) {
                    if (row != null) {
                        return formatNumber(value, '#,##0.00');
                    }
             }}, {
				title : '交易时间',
				field : 'jysj',
				width : 100,
				align : 'center',
				formatter:function (value, row, index) {
					return formatDate(value);
             }},{
				title : '权利人',
				field : 'qlr',
				width : 200
			}, {
				title : '共有情况',
				field : 'gyqk',
				width : 200
			}, {
				title : '坐落地址',
				field : 'zldz',
				width : 300
			}, {
				title : '不动产单元号',
				field : 'bdcdyh',
				width : 250
			}, {
				title : '权利类型',
				field : 'qllx',
				width : 220
			}, {
				title : '权利性质',
				field : 'qlxz',
				width : 180
			}, {
				title : '规划用途',
				field : 'ghyt',
				width : 150
			} ] ],
			fitColumn : false, 	//列自适应宽度
			nowap : true	 		//列内容多时自动折至第二行
		});
	});

	function searchData() {
		$('#dg').datagrid('options').pageIndex = 1;
		var p = $('#dg').datagrid('getPager');
		if (p) {
			$(p).pagination({
				pageIndex : 1
			});
		}
		$('#dg').datagrid('options').queryParams = {
			qQlr : $("#txtQLR").val(),
			qGyqk : $("#txtGYQK").val()
		};
		$('#dg').datagrid('reload');
	};

	function exportExcel(){
		$("#frmExcel").submit();
	};
</script>
</head>
<body>
<form id="frmExcel" action="../sjcj/EXPT00401.do" method="post">
	<table>
		<tr>
			<td>权利人</td>
			<td><input type="text" id="txtQLR" name="txtQLR"></td>
			<td>共有情况</td>
			<td><input type="text" id="txtGYQK" name="txtGYQK"></td>
			<td><a id="btnSearch" href="javascript:searchData();"
				class="easyui-linkbutton" iconCls="icon-search">查询</a>
				<a id="btnExport" href="javascript:exportExcel();"
				class="easyui-linkbutton" iconCls="icon-excel" title="数据导出限制1000条">导出</a>
			</td>
		</tr>
	</table>
</form>

	<table id="dg"></table>
	<div class="divbottom">
		<s:url id="urlAdd" action="LOADT00401"><s:param name="act">C</s:param>	</s:url> 
		<s:a href="%{urlAdd}">
				<img src="../images/ico/Add.gif" width="16" height="16" title="<s:property value="getText('app.button.add')"/>" alt="<s:property value="getText('app.button.add')"/>" /><s:property value="getText('app.button.add')" />
		</s:a>
	</div>
</body>
</html>