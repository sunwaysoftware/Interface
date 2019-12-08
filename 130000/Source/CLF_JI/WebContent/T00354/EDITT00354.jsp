<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sw" uri="/sunway" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title><s:property value="%{getText('app.global.title')}" /></title>

<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<link href="../css/screen.css" rel="stylesheet" type="text/css"/>

<script type="text/javascript" src="../scripts/DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/T00354/EDITT00354.js"></script>
<script type="text/javascript" src="../scripts/T00001/INFOTREEDIV.js"></script>

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
            <li><a href="#INFO"><span><s:property value="%{getText('app.xtwh.t00354.title')}" /></span></a></li>                    
        </ul>
		<div id="INFO" class="divConect">
		<div style="min-height:400px">
<s:actionerror/><s:actionmessage/>
<div id="showStatus" class="txtGreen"></div>
<form action="EDITT00354.action" method="post" id="editForm">
		<input type="hidden" name="ACT" value='<s:property value="ACT"/>' /> 
		<input type="hidden" name="txtUPDATE" id="txtUPDATE" value="<s:text name="app.global.format.datetime"><s:param value="t00354Bean.upddate"/></s:text>" />	
	<table width="500" border="0" cellspacing="0" cellpadding="2">
  		<tr>
    		<td colspan="2" align="center">
		    	<s:property value="getText('app.xtwh.info.szqy')"/>&nbsp;&nbsp;&nbsp;&nbsp;
		        <sw:szqy items="szqyList" name="ddlSZQY" classid="txtfocus" id="ddlSZQY" checked="t00354Bean.cd00001Szqy" />
   			</td>
    	</tr>
  		<tr>
   			<td>
		    	<s:property value="getText('app.xtwh.info.fwcx')"/>：<span id="TIPFWCX" name="TIPFWCX"><s:property value="t00354Bean.fwcx"/></span>
		    	<input type="hidden" name="FWCX" id="FWCX" value='<s:property value="t00354Bean.cd00001Fwcx"/>'/>
		        <div class="infodiv" id="INFOFWCXDIV"></div>
    		</td>
    		<td valign="top">
    			<table width="100%" border="0" cellspacing="0" cellpadding="2">
					<tr>
						<td><label class="labelA">
								<s:property value="getText('app.xtwh.t00001.pssd')"/>
							</label>
							<input type="text" id="txtPSSD" name="txtPSSD" value="<s:property value="t00354Bean.cd00002Pssd"/>"  onfocus="WdatePicker({dateFmt:'yyyy'})" class="Wdatefocus txtNumber" />
						</td>
					</tr>
					<tr>
						<td><label class="labelA">		
								<s:property value="getText('app.xtwh.sywh.xzxs')"/>
							</label>
							<input type="text" class="txtfocus txtNumber" id="txtXZXS" name="txtXZXS" value="<s:property value="t00354Bean.xzxs" default="0" />" />	
						</td>
		         	</tr>
		         	<tr>
						<td><label class="labelA">
								<s:property value="%{getText('app.note')}" />
							</label>
							<textarea name="txtNOTE" id="txtNOTE" cols="20" rows="3"><s:property value="t00354Bean.note" /></textarea>
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
			<a href="javascript:void(0)" id="btnUpd" name="btnUpd" <s:if test='%{ACT=="C"}'>style="display:none"</s:if>><img src="../images/ico/Edit.gif" width="16" height="16" title="<s:property value="getText('app.button.upd')"/>" alt="<s:property value="getText('app.button.upd')"/>" /><s:property value="getText('app.button.upd')"/></a>
		  	<a href="javascript:void(0)" id="btnAdd" name="btnAdd" <s:if test='%{ACT!="C"}'>style="display:none"</s:if>><img src="../images/ico/Update.gif" width="16" height="16" title="<s:property value="getText('app.button.save')"/>" alt="<s:property value="getText('app.button.save')"/>" /><s:property value="getText('app.button.save')"/></a>
			<a href="VIEWT00354.action">
				<img src="../images/ico/Cancel.gif" width="16" height="16" title="<s:property value="getText('app.button.back')"/>" alt="<s:property value="getText('app.button.back')"/>" /><s:property value="getText('app.button.back')"/></a>
		</div>
		</div>
<script type="text/javascript">getFWCXDiv('<s:property value="t00354Bean.cd00001Fwcx"/>','#INFOFWCXDIV');</script>
</div>
</div>
    </td>
  </tr>
</table>
</body>
</html>
