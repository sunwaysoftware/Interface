<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sw" uri="/sunway" %>

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title><s:property value="%{getText('app.global.title')}" /></title>
  
<link rel="stylesheet" type="text/css" href="../css/screen.css"/>
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/selectMultiple.js"></script>
<script type="text/javascript" src="../scripts/T00352/CONFIRMT00352.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>

<script type="text/javascript">
	$(function() {
		$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
		$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });
	});
</script>
<style type="text/css">
div{float: left;}
#bu{float: left;}
#ba{float: right;}
</style>

</head>
<body>
<table border="0" align="left" cellpadding="0" cellspacing="0" class="table1">
  <tr>
    <td align="left" valign="top">
    <div id="tabs" class="ui-widget-content">
	        <ul class="ui-tabs-nav ui-helper-reset ui-helper-clearfix datagrid-title" style="height:25px;border-bottom:1px solid #8DB2E3;" >
	            <li><a href="#INFO"><span style="color:#15428b;font-weight:bold;padding-left:5px;"><s:property value="%{getText('app.xtwh.t003521.title')}" /></span></a></li>
	        </ul>
		<div id="INFO" class="divConect">
		<div style="min-height:400px">
<form  id="editForm" method="post" action="UPDATET00352.action" onsubmit="selectItem();">
	<table border="0" cellspacing="0" cellpadding="2">
        <tr>
          <td colspan="3" align="center">
          	<s:property value="getText('app.xtwh.info.szqy')"/>&nbsp;&nbsp;&nbsp;&nbsp;
            <sw:szqy items="szqyList" name="ddlSZQY" id="ddlSZQY" checked="ddlSZQY" classid="txtfocus"/>
          </td>
        </tr>
        <tr>
        	<td>
        		<select	multiple name="DDLUNABLEXQ" id="DDLUNABLEXQ">
					<s:iterator value="unableList" status="index">
							<option value="<s:property value="xqdm" />">
								<s:property	value="xqnm" />
							</option>
					</s:iterator>
				</select> 
        	</td>
        	<td>
        		<select multiple name="DDLABLEXQ" id="DDLABLEXQ">
					<s:iterator value="ableList" status="index">
							<option value="<s:property value="xqdm" />">
								<s:property	value="xqnm" />
							</option>
					</s:iterator>
				</select>
        	</td>
        </tr>
</table>
	<input class="button" type="submit" value="确  认" />
</form>

<script type="text/javascript">
	createMovableOptions("DDLUNABLEXQ", "DDLABLEXQ", 500, 300, '新建估价分区', '已确认估价分区');
	function selectItem()
	{
		var obj = document.getElementById('DDLABLEXQ');
		for(var no=0;no<obj.options.length;no++){
			obj.options[no].selected = true;
		}
		
		var obj2 = document.getElementById('DDLUNABLEXQ');
		for(var no2=0;no2<obj2.options.length;no2++){
			obj2.options[no2].selected = true;
		}
	} 
	function aClick(){
		selectItem();
	}
</script>
</div>
</div>
</div>
  </td>
  </tr>
</table>
</body>

</html>
