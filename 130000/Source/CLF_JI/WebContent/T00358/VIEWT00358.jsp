<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title><s:property value="%{getText('app.global.title')}" /></title>

<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>


<script type="text/javascript" src="../scripts/T00358/VIEWT00358.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>

<link href="../css/screen.css" rel="stylesheet" type="text/css"/>
<style type="text/css">
<!--
body {
	background-color: #FFFFFF;
}
-->
</style>

</head>
<body>
<%@include file="../wait.jsp" %>
<div style="display: none;">
<script type="text/javascript" src="../scripts/wz_tooltip.js"></script>
<s:actionerror/><s:actionmessage/>
<s:if test="%{ngMxList!=null}">
<span id="errInfo">
<table>
<tr>
	<th twidth="150">操作</th>
	<th twidth="150"><s:property value="%{getText('app.sjsh.t12084.shyy')}" /></th>
	<th twidth="150"><s:property value="%{getText('app.sjsh.t12084.bxsh')}" /></th>
</tr>
<s:iterator value="ngMxList" status="step">
<tr>
	<s:if test="%{openWinUrl!=''}">
	<td><a href="javascript:showParamWin('<s:property value="openWinUrl"/>');"><img title="未通过" alt='未通过' src='../images/warning.gif'/></a></td>
	</s:if>
	<s:else>
	<td><img title="未通过" alt='未通过' src='../images/warning.gif'/></td>
	</s:else>
	<td><s:property value="shyy"/></td>
	<td><s:property value="shmc"/></td>
</tr>
</s:iterator>
</table>
</span>
</s:if>
<table>
<tr>
	<td valign="top">
		<fieldset style="width:500px;height:180px"><legend>【<s:property value="%{getText('app.sjpg.t00332.title')}" />】</legend>
       <s:if test="%{t00332Bean==null}">
      	 <span class="txtRed">该纳税人未进行个案估价</span>
       </s:if>
       <s:else>
       <table width="100%" border="0" cellspacing="0" cellpadding="5">
         <tr>
           <td>
           		<s:property value="%{getText('app.sjpg.t02032.gbpgjg')}" /><a href="javascript:Show('../pg/VIEWT00335.action?txtFCID=<s:property value="txtFCID" />&txtPSSD=<s:property value="txtPSSD"/>',450,900,'估价信息');"><img src='../images/info.png' height='16' width='16' /></a> : <span class="txtRed"><s:text name="app.global.format.money"><s:param value="t00332Bean.gbpgjg" /></s:text></span>
			</td>
         </tr>
       	</table>
       	【<s:property value="%{getText('app.sjpg.t00333.title')}" />】
			<table id="scroll1" class="scroll" cellpadding="0" cellspacing="0" style="width:480px;height:100px">
			  <thead>
				<tr>
					<th twidth="150"><s:property value="%{getText('app.sjpg.t00333.qtxznm')}" /></th>
					<th twidth="80"><s:property value="%{getText('app.sjpg.t00333.xzxs')}" /></th>
					<th twidth="80"><s:property value="getText('app.xtwh.t00353.yslb')"/></th>
					<th twidth="200"><s:property value="%{getText('app.note')}" /></th>	
				</tr>
				</thead>
				<tbody>
     				<s:iterator value="xzList" status="index" id="xzEntity">
					<tr>
						<td><s:property value="qtxznm"/></td>
						<td align="right"><s:text name="app.global.format.double"><s:param value="xzxs"/></s:text></td>
						<td align="center">
							<s:if test="%{czlx==0}">
								<s:property value="getText('app.xtwh.t00353.yslb.mcl')"/>
							</s:if>
							<s:else>
								<s:property value="getText('app.xtwh.t00353.yslb.DA')"/>
							</s:else>
						</td>
						<td><s:property value="note" default=""/>&nbsp;</td>
					</tr>
					</s:iterator>
				</tbody>	
			</table>		     	
      	</s:else>
		</fieldset>
	</td>
	<td valign="top">
		<fieldset style="width:195px"><legend>【选择的<s:property value="getText('app.sjpg.t00358.title')" />】</legend>
			<div id="ddlSL" style="width:180px;height:165px;overflow:auto;border: 2px inset #FFFFFF;">
			<s:if test="%{slTempList.size()>0}">
				<s:iterator value="slTempList" status="index" id="slTempEntity">
					<span class="qtxz"><s:property value="cdSlid"/><a href="javascript:;" QTXZ="<s:property value="cdSlid"/>" onclick="qtxzClick(this);">[删]</a></span>
				</s:iterator>			
			</s:if>
			<s:else>
				<s:iterator value="pgslList" status="index" id="pgslEntity">
					<span class="qtxz"><s:property value="cdSlid"/><a href="javascript:;" QTXZ="<s:property value="cdSlid"/>" onclick="qtxzClick(this);">[删]</a></span>
				</s:iterator>				
			</s:else>
			</div>
		</fieldset>
	</td>
</tr>
</table>

<table border="0" align="left" cellpadding="0" cellspacing="0" class="table1">
  <tr>
    <td align="left" valign="top">
			
	<fieldset style="width:700px"><legend>【<s:property value="getText('app.sjpg.t00358.title')" />】</legend>	
	<form id="editForm" action="../pg/EXECPG30000G.action" method="post">
		<input type="hidden" id="txtSWID" name="txtSWID" value="<s:property value="txtSWID" />" />
		<input type="hidden" id="txtFCID" name="txtFCID" value="<s:property value="txtFCID" />" />
		<input type="hidden" id="txtPSSD" name="txtPSSD" value="<s:property value="txtPSSD"/>" />  
		<s:if test="%{slTempList.size()>0}">
		<input type="hidden" id="txtSLID" name="txtSLID" size="100" value="<s:iterator value="slTempList" status="index" id="slTempEntity"><s:property value="cdSlid"/>,</s:iterator>" /> 		
       	</s:if>
		<s:else>
		<input type="hidden" id="txtSLID" name="txtSLID" size="100" value="<s:iterator value="pgslList" status="index" id="pgslEntity"><s:property value="cdSlid"/>,</s:iterator>" />
		</s:else>
        <div id="apDiv1" style="left:15px;top:190px;">	
		<s:property value="getText('app.sjpg.pg30000g.histroy')"/>
		<select id="txtPSSDTOJYJG" name="txtPSSDTOJYJG">
			<option value="1">01月</option>
			<option value="2">02月</option>
			<option value="3">03月</option>
			<option value="4">04月</option>
			<option value="5">05月</option>
			<option value="6">06月</option>
			<option value="7">07月</option>
			<option value="8">08月</option>
			<option value="9">09月</option>
			<option value="10">10月</option>
			<option value="11">11月</option>
			<option value="12" selected="selected">12月</option>
		</select>			
        </div>
		<input type="button" class="button" id="btnSearch" name="btnSearch" value="<s:property value="getText('app.button.search')" />" /><input name="btnConditions" type="button" title="显示搜索条件" id="btnConditions" class="button" value="↓" />
		<table id="scroll2" class="scroll" cellpadding="0" cellspacing="0" style="width:100%;height:250px">
		    <thead>
				<tr>
					<th twidth="40"><s:property value="getText('app.no')"/></th>
					<th twidth="50">选择</th>
					<!--  
					<th twidth="150"><s:property value="getText('app.sjpg.t00358.fcid')" /></th>
					-->
					<th twidth="150"><s:property value="getText('app.sjpg.t00358.slid')" /></th>
					<th twidth="120"><s:property value="getText('app.sjpg.t00358.pssd')" /></th>
					<th twidth="100"><s:property value="getText('app.sjpg.t00358.yxj')" /></th>
					<th twidth="180"><s:property value="getText('app.sjpg.t00358.zyxj')" /></th>					
					<th twidth="180"><s:property value="getText('app.sjpg.t00358.fwtdzl')" /></th>
					<th twidth="120"><s:property value="getText('app.sjpg.t00358.xqnm')" /></th>					
					<th twidth="80"><s:property value="getText('app.sjpg.t00358.zlc')" /></th>					
					<th twidth="100"><s:property value="getText('app.sjpg.t00358.ywdt')" /></th>
					<th twidth="100"><s:property value="getText('app.sjpg.t00358.jylx')" /></th>					
					<th twidth="150"><s:property value="getText('app.sjpg.t00358.fwlx')" /></th>
					<th twidth="100"><s:property value="getText('app.sjpg.t00358.jzjg')" /></th>					
					<th twidth="100"><s:property value="getText('app.sjpg.t00358.szlc')" /></th>
					<!--  	
					<th twidth="100"><s:property value="getText('app.sjpg.t00358.fwcx')" /></th>
					<th twidth="100"><s:property value="getText('app.sjpg.t00358.cgzk')" /></th>
					-->
					<th twidth="120"><s:property value="getText('app.sjpg.t00358.jysj')" /></th>					
					<th twidth="120"><s:property value="getText('app.sjpg.t00358.pfmjg')" /></th>			
				</tr>
		    </thead>
			<tbody id="divShow">
				<tr id="rowtemplate">
					<td id="no" align="center"></td>
					<td id="chk" align="center"></td>
					<!-- 
					<td id="fcid"></td>
					-->
					<td id="slid" align="center"></td>
					<td id="pssd" align="center"></td>
					<td align="right" id="yxj"></td>
					<td align="center" id="zyxj"></td>					
					<td id="fwtdzl"></td>
					<td id="xqnm"></td>					
					<td align="right" id="zlc"></td>					
					<td id="ywdt" align="center"></td>
					<td id="jylx"></td>					
					<td id="fwlx"></td>
					<td id="jzjg"></td>					
					<td align="right" id="szlc"></td>
					<!-- 
					<td id="fwcx"></td>
					<td id="cgzk"></td>
					-->
					<td id="jysj" align="center"></td>					
					<td align="right" id="pfmjg"></td>
				</tr>
			</tbody>
		</table>	
	  </form>
			
		<div class="divbottom">
			<a href="javascript:AppSubmit();"><img
				src="../images/ico/Edit.gif" width="16" height="16" title="<s:property value="getText('app.sjpg.pg00000.button.pg')" />" alt="<s:property value="getText('app.sjpg.pg00000.button.pg')" />" /><s:property value="getText('app.sjpg.pg00000.button.pg')" /></a>	
		</div>			
		</fieldset>		
		
</td>
  </tr>
</table>
<script type="text/javascript">
AppSubmit();
</script>
<input type="hidden" name="chkTrue" id="chkTrue" value="<s:property value="%{getText('app.global.checkbox.true')}" />"/>
<input type="hidden" name="chkFalse" id="chkFalse" value="<s:property value="%{getText('app.global.checkbox.false')}" />"/>
</div>
</body>
</html>