<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title><s:property value="%{getText('app.global.title')}" /></title>

<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<link href="../css/screen.css" rel="stylesheet" type="text/css"/>

<script type="text/javascript" src="../scripts/T00009/EDITT00009.js"></script>
<script type="text/javascript" src="../scripts/T00002/EDITT00002.js"></script>
<script type="text/javascript" src="../scripts/T00001/INFOTREEDIV.js"></script>
<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../scripts/T00002/fun.js"></script>



<script type="text/javascript">
	$(function() {
		$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
		$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });
		getRole('<s:property value="t00009Bean.cd00002Userid" />','<s:property value="ACT"/>');	
		getRight('<s:property value="t00009Bean.cd00002Userid" />','<s:property value="ACT"/>');
	});    
</script>
<style type="text/css">
<!--
.labelA {
	width: 80px;
}
-->
</style>

</head>
<body>
<table border="0" align="left" cellpadding="0" cellspacing="0" class="table1">
  <tr>
    <td align="left" valign="top">
	
    <div id="tabs" class="ui-widget-content">
        <ul class="ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header">
            <li><a href="#INFO"><span><s:property value="%{getText('app.xtwh.t00009.title')}" /></span></a></li>                    
        </ul>
		<div id="INFO" class="divConect">
		<div style="min-height:400px">
<form action="EDITT00009.action" method="post" id="editForm">
	<input type="hidden" name="ACT" value="<s:property value="ACT"/>" /> 
	<input type="hidden" name="txtUPDATE" id="txtUPDATE" value="<s:text name="app.global.format.datetime"><s:param value="t00009Bean.upddate"/></s:text>" />
	<s:if test='%{ACT=="U"}'>
		<input name="txtUSERID" id="txtUSERID" type="hidden" value="<s:property value="t00009Bean.cd00002Userid" />" />
	</s:if> 	
   		<table width="400" border="0" cellspacing="3" cellpadding="0">
		 	<tr>
   		 		<td valign="top">
			<fieldset>
                <legend>基本信息</legend>
                    <table width="250" border="0" cellspacing="2" cellpadding="0">
      		<tr>
	    		<td><label class="labelA">		    		
					    <s:property value="%{getText('app.xtwh.t00002.userid')}" />
					</label>					
				</td>
				<td>
					<input name="txtUSERID" class="txtfocus" id="txtUSERID" type="text" value="<s:property value="t00009Bean.cd00002Userid" />" <s:if test='%{ACT=="U"}'>disabled="disabled"</s:if>/>
	    			<s:if test='%{ACT!="U"}'>
						<input type="button" value="查询" name="btnQuery" class="button" id="btnQuery" />
						<input type="button" value="重新查询" name="btnReQuery" class="button" id="btnReQuery"  style="display:none;"/>
					</s:if> 
				</td>
			</tr>
		</table>
		<div id="showStatus" style="display:none;"></div>
	</fieldset>
		<table width="400" border="0" cellspacing="3" cellpadding="0">
		 	<tr>
		 		<td>
			 		<s:if test='%{ISADMIN && ACT=="C"}'>
				    	<s:property value="getText('app.xtwh.info.ssgx')"/>：<span id="TIPSSGX" name="TIPSSGX"><s:property value="t00009Bean.ssgx"/></span>
				        <div class="infodiv" id="INFOSSGXDIV"></div>
					</s:if>
				<input type="hidden" name="hidSSGX" id="hidSSGX" <s:if test='%{ACT=="C"}'>value="<s:property value="SSGX"/>"</s:if><s:else>value="<s:property value="t00009Bean.cd00001Ssgx"/>"</s:else>/>	
				</td>
		 		<td valign="top">
					<fieldset style="width:200px"><legend>角色信息</legend>
		                <table width="100%" border="0" cellspacing="2" cellpadding="0">
							<tr>
								<td>
							<div id="divRole"></div>
								</td>
							</tr>
						</table>
					</fieldset>
				</td>
				<td valign="top">
					<fieldset style="width:200px"><legend>权限信息</legend>
						<table width="100%" border="0" cellspacing="2" cellpadding="0">
							<tr>
								<td>
							<div id="divRight"></div>
								</td>
							</tr>
						</table>
					</fieldset>
				</td>
			</tr>
</table>	
</td>
  </tr>
</table>
</form>
</div>
	<div class="divbottom">
	<div>
		<s:if test='%{ACT=="U"}'>
			<a href="javascript:AppSubmit();">
				<img src="../images/ico/Edit.gif" width="16" height="16" title="<s:property value="getText('app.button.upd')"/>" alt="<s:property value="getText('app.button.upd')"/>" /><s:property value="getText('app.button.upd')"/>
			</a>
		</s:if>
		<s:if test='%{ACT=="C"}'>
			<a href="javascript:;" id="btnAdd" disabled="disabled"><img src="../images/ico/Update.gif" width="16" height="16" title="<s:property value="getText('app.button.save')"/>" alt="<s:property value="getText('app.button.save')"/>" /><s:property value="getText('app.button.save')"/></a>
		</s:if>
		<a href="VIEWT00009.action">
	    	<img src="../images/ico/Cancel.gif" width="16" height="16" title="<s:property value="getText('app.button.back')"/>" alt="<s:property value="getText('app.button.back')"/>"/><s:property value="getText('app.button.back')" />
	    </a>
	</div>
	</div>
	<!-- 
	<div id="dialog" class="easyui-window" title="请选择类型..." icon="icon-ok" style="width:350px;height:350px;padding:5px;background: #fafafa;">
		<div id="infoTreeDIV"></div>
	</div> -->
	
	<s:if test='%{ACT=="C"}'>
		<script type="text/javascript">		
		<s:if test='%{t00009Bean.cd00001Ssgx!=null && t00009Bean.cd00002Userid!=null}'>
		setUserEnable();
		getSSGXDiv('<s:property value="t00009Bean.cd00001Ssgx"/>','#INFOSSGXDIV');
		//根据隐藏域判断点击情况，如果符合，则刷新		
		flushRoleAndRight('<s:property value="t00009Bean.cd00002Userid"/>','<s:property value="t00009Bean.cd00001Ssgx"/>');
		flushUpdate('<s:property value="t00009Bean.cd00001Ssgx"/>', '<s:property value="t00009Bean.cd00002Userid"/>');
		</s:if>
		<s:else>
			getSSGXDiv('<s:property value="SSGX"/>','#INFOSSGXDIV');
		</s:else>
		</script>
	</s:if>
	<s:else>
		<script type="text/javascript">getSSGXDiv('<s:property value="t00009Bean.cd00001Ssgx"/>','#INFOSSGXDIV');</script>
	</s:else>
</div>
</div>
    </td>
  </tr>
</table>
</body>
</html>
