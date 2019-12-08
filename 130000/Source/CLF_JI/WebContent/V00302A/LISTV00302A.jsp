<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><s:property value="%{getText('app.global.title')}" /></title>
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<link href="../css/screen.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>

<script type="text/javascript">
	$(function() {
		
		$('#test').datagrid({
			striped: true,
			url:'../sjcx/LISTV00302A.action',
			sortName: '',
			sortOrder: 'desc',
			height:400,
			onLoadError:function(){
				$.messager.alert('错误信息','请求已发送，服务器无应答！','error');
			},
			queryParams : 
		    {
				
			},			
			columns:[[		
			            {title:'<s:property value="%{getText('app.xtwh.info.szqy')}" />',field:'szqy',width:100},
			            {title:'<s:property value="%{getText('app.sjcj.t00302.fcid')}" />',field:'fcid',width:150},
			            {title:'<s:property value="%{getText('app.sjcj.t00301.swid')}" />',field:'cd00301aSwid',width:150},
			            {title:'<s:property value="%{getText('app.sjcj.t00301.nsrmc')}" />',field:'nsrmc',width:120},
			            {title:'<s:property value="%{getText('app.xtwh.t00303.xqmc')}" />',field:'xqnm',width:100},
			            {title:'<s:property value="%{getText('app.xtwh.t00303.zcdzl')}" />',field:'fwtdzl',width:150},
			            {title:'<s:property value="%{getText('app.xtwh.info.fwlx')}" />',field:'fwlx',width:80},
			            {title:'<s:property value="%{getText('app.xtwh.info.jylx')}" />',field:'jylx',width:80},
			            {title:'<s:property value="%{getText('app.xtwh.info.jzjg')}" />',field:'jzjg',width:120},
			            {title:'<s:property value="%{getText('app.sjcj.t00302.jzmj')}" />',field:'jzmj',width:100,align:'right'},
			            {title:'<s:property value="%{getText('app.xtwh.info.fwcx')}" />',field:'fwcx',width:80},
			            {title:'<s:property value="%{getText('app.xtwh.info.cgzk')}" />',field:'cgzk',width:80},
			            {title:'<s:property value="%{getText('app.sjcj.t00302.szlc')}" />',field:'szlc',width:80,align:'right'},
			            {title:'<s:property value="%{getText('app.sjcj.t00302.bwjfh')}" />',field:'bwjfh',width:80},
			            {title:'<s:property value="%{getText('app.sjcj.t00302.jyjg')}" />',field:'jyjg',width:100,align:'right'},
			            {title:'<s:property value="%{getText('app.sjcj.t00302.dtgj')}" />',field:'dtgj',width:100,align:'right'},
			            {title:'<s:property value="%{getText('app.sjcj.t00302.tdsyqmj')}" />',field:'tdsyqmj',width:100,align:'right'},
			            {title:'<s:property value="%{getText('app.sjcj.t00302.rjl')}" />',field:'rjl',width:80,align:'right'},
			            {title:'<s:property value="getText('app.sjcj.t00302.jysj')"/>',field:'jysj',width:100},
			            {title:'<s:property value="%{getText('app.sjcj.t00302.fdcdat')}" />',field:'fdcdat',width:120},
			            {title:'<s:property value="%{getText('app.upddate')}" />',field:'upddate',width:150,formatter:function(value,rec){return formatDateTime(value);}},
			            {title:'<s:property value="%{getText('app.czr')}" />',field:'czr',width:80},
			            {title:'<s:property value="%{getText('app.note')}" />',field:'note',width:150}
		        ]],
			pagination:true,
			rownumbers:true
			});
	});	
</script>
</head>
<body>
<input type="hidden" name="CZH" id="CZH" value="<s:property value="CZH"/>" />
<table border="0" align="left" cellpadding="0" cellspacing="0" class="table1">
  <tr>
    <td align="left" valign="top">
		<table id="test"></table>
    </td>
  </tr>
</table>
</body>
</html>
