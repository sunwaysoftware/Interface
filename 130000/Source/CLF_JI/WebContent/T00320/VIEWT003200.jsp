<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sw" uri="/sunway" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><s:property value="%{getText('app.global.title')}" /></title>
<link type="text/css" rel="stylesheet" href="../css/screen.css" />
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<script type="text/javascript" src="../scripts/T00302/VIEWT00302.js"></script>
<script type="text/javascript" src="../scripts/T00352/T00352TREEDIV.js"></script>
<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>
<table border="0" align="left" cellpadding="0" cellspacing="0" class="table1">
  <tr>
<table id="scroll1" class="easyui-datagrid" cellpadding="0" cellspacing="0" style="width:450px;height:300px">
	<thead>
		<tr>
			<th field="edit1" width="40">操作</th>
			<th field="edit2" width="100">房产编码</th>
			<th field="edit5" width="120">测量号</th>
			<th field="edit6" width="200">楼房地址</th>
			<th field="edit7" width="100">楼号</th>				
			<th field="edit8" width="120">单元号</th>
			<th field="edit9" width="150">房号</th>				
			<th field="edit0" width="150">总楼层</th>			
			<th field="edit10" width="80">所在楼层</th>
			<th field="edit11" width="80">建筑结构</th>				
		</tr>
	</thead>
	<tbody>
		<tr>
		<s:iterator value="tabList" status="index">
			<td>
				<img onclick="window.parent.serchQmpgByFcid('<s:property value="fcid" />')" src="../images/ico/Add.gif" width="16" height="16" title="选中记录" alt="选中记录" />
			</td>
			<td><s:property value="fcid" /></td>
			<td><s:property value="clh" /></td>
			<td><s:property value="zcdzl" /></td>
			<td><s:property value="zh" /></td>
			<td><s:property value="dyh" /></td>
			<td><s:property value="fh" /></td>
			<td><s:property value="zlc" /></td>
			<td><s:property value="szlc" /></td>
			<td><s:property value="jzjg" /></td>
		</s:iterator>	
		</tr>
	</tbody>
</table>


  </tr>
</table>
</body>
</html>
