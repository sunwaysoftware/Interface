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
			url:'../sjcx/LISTV00301A.action',
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
                     
			            {title:'<s:property value="%{getText('app.sjcj.t00301.swid')}" />',field:'swid',width:150,formatter:function(value,rec){
          			            return "<a href=javascript:Show('DETAILV00301A.action?SWID=" + encodeURI(rec.swid) + "',200,420,'市场法登记详细信息'); title='点击查看详细信息' >" + rec.swid + "</a>";
          			            }},
			            {title:'<s:property value="%{getText('app.sjcj.t00301.nsrmc')}" />',field:'nsrmc',width:120},
			            {title:'<s:property value="%{getText('app.xtwh.info.zjlx')}" />',field:'zjlx',width:80},
			            {title:'<s:property value="%{getText('app.sjcj.t00301.zz')}" />',field:'zz',width:120},
			            {title:'<s:property value="%{getText('app.sjcj.t00301.lxdh')}" />',field:'lxdh',width:120}
			           
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
