<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sw" uri="/sunway" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title><s:property value="%{getText('app.global.title')}" /></title>

<link rel="stylesheet" type="text/css" href="../css/screen.css" />
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>

<script type="text/javascript" src="../scripts/DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/T00353/EDITT00353.js"></script>
<script type="text/javascript" src="../scripts/T00001/INFOTREEDIV.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>

<script type="text/javascript">
	$(function() {
		$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
		$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });
		<s:if test='%{ACT=="U"}'>
		getCGZKDiv('<s:property value="t00353Bean.cd00001Infoid"/>','#INFOCGZKDIV','<s:property value="t00353Bean.cd00001Fwlx"/>');
		</s:if>
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
	
    <div class="ui-widget-content">
	<div class="datagrid-title">
		<span class="datagrid-title-text"><s:property value="%{getText('app.xtwh.t00353.title')}" /></span>                
    </div>
	<div style="min-height:400px">
	<div id="showStatus" class="txtGreen"></div>
	<form action="EDITT00353.action" method="post" id="editForm">
			<input type="hidden" name="ACT" value='<s:property value="ACT"/>' /> 
			<input type="hidden" name="txtUPDATE" id="txtUPDATE" value="<s:text name="app.global.format.datetime"><s:param value="t00353Bean.upddate"/></s:text>" />		
			<input type="hidden" name="hidSelect" id="hidSelect" />
			<table width="500" border="0" cellspacing="0" cellpadding="0">
			  <tr>
			    <td colspan="2" align="center">
			    	<s:property value="getText('app.xtwh.info.szqy')"/>&nbsp;&nbsp;&nbsp;&nbsp;
			        <sw:szqy items="szqyList" name="ddlSZQY" classid="txtfocus" id="ddlSZQY" checked="t00353Bean.cd00001Szqy" />
			    </td>
			  </tr>
			  <tr>
	             <td colspan="2" align="center">
	                <s:property value="%{getText('app.xtwh.info.fwlx')}" />
 	                <span class="txtInfonm txtfocus"><input name="txtFWLXTIP" id="txtFWLXTIP" type="text" value="<s:property value="t00353Bean.fwlx"/>" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/><span id="spFWLX"></span></span><input type="hidden" id="txtFWLX" name="txtFWLX" value="<s:property value="t00353Bean.cd00001Fwlx"/>"/>
	          	 </td>
	          </tr>
			  <tr>
			    <td>
			    <!--
			    <s:property value="getText('app.xtwh.info.cgzk')"/>：<span id="TIPCGZK" name="TIPCGZK"><s:property value="t00353Bean.cgzk"/></span>
			    <input type="hidden" name="CGZK" id="CGZK" value='<s:property value="t00353Bean.cd00001Cgzk"/>'/>
			    -->
			    <s:property value="getText('app.xtwh.t00001.rootnm')"/>：<span id="TIPCGZK" name="TIPCGZK"><s:property value="t00353Bean.infoNm"/></span>
				<input type="hidden" name="CGZK" id="CGZK" value='<s:property value="t00353Bean.cd00001Infoid"/>'/>
			    <div class="infodiv" id="INFOCGZKDIV"></div>
			    </td>
			    <td valign="top">
			    	<table width="100%" border="0" cellspacing="3" cellpadding="0">
			    		<!--<tr>
						    <td><label class="labelA">
									<s:property value="getText('app.xtwh.t00001.pssd')"/>
								</label>
									<input type="text" id="txtPSSD" name="txtPSSD" value="<s:property value="t00353Bean.cd00002Pssd"/>"  onfocus="WdatePicker({dateFmt:'yyyy'})" class="Wdatefocus" />
							</td>
						</tr>-->
						<tr>
							<td><label class="labelA">		
									<s:property value="getText('app.xtwh.sywh.xzxs')"/>
								</label>
								<input type="text" class="txtfocus txtNumber" id="txtXZXS" name="txtXZXS" value="<s:property value="t00353Bean.xzxs"/>" />	
							</td>
			         	</tr>
			         	<tr>
							<td><label class="labelA"><s:property value="getText('app.xtwh.t00353.yslb')"/></label>
								<input type="radio" class="radio" name="rdoCZLX" id="rdoCZLX0" value="0" checked="checked"/><s:property value="getText('app.xtwh.t00353.yslb.mcl')"/>
								<input type="radio" class="radio" name="rdoCZLX" id="rdoCZLX1" value="1" <s:if test="%{1==t00353Bean.czlx}">checked="checked"</s:if> /><s:property value="getText('app.xtwh.t00353.yslb.DA')"/>
							</td>
						</tr>
			         	<tr>
							<td><label class="labelA">
									<s:property value="%{getText('app.note')}" />
								</label>
								<textarea name="txtNOTE" id="txtNOTE" cols="20" rows="3"><s:property value="t00353Bean.note" /></textarea>
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
				<a href="VIEWT00353.action">
					<img src="../images/ico/Cancel.gif" width="16" height="16" title="<s:property value="getText('app.button.back')"/>" alt="<s:property value="getText('app.button.back')"/>" /><s:property value="getText('app.button.back')"/></a>
			</div>
			<div id="dialog" class="easyui-window" title="请选择类型..." icon="icon-ok" style="width:350px;height:350px;padding:5px;background: #fafafa;">
		 	 <div id="infoTreeDIV"></div>
			</div>
		</div>
	</div>
    </td>
  </tr>
</table>
</body>

</html>
