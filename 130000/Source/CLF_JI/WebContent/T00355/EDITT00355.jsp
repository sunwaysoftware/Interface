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
<!-- InstanceBeginEditable name="head" <script type="text/javascript" src="../scripts/messages_cn.js"></script>-->
<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/T00355/EDITT00355.js"></script>
<script type="text/javascript" src="../scripts/T00001/INFOTREEDIV.js"></script>
<script type="text/javascript" src="../scripts/T00352/T00352TREEDIV.js"></script>
<script type="text/javascript" src="../scripts/T00053/T00053TREEDIV.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>

<script type="text/javascript">
	$(function() {
		$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
		$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });
	});
</script>
<style type="text/css">
.labelA {
	width: 80px;
}
</style>

</head>
<body>
<table border="0" align="left" cellpadding="0" cellspacing="0" class="table1">
  <tr>
    <td align="left" valign="top">
	
    <div class="ui-widget-content">
	<div class="datagrid-title">
		<span class="datagrid-title-text"><s:property value="%{getText('app.xtwh.t00355.title')}" /></span>                   
	</div>
	<div style="min-height:400px">

	<div id="showStatus" class="txtGreen"></div>
	<form action="EDITT00355.action" method="post" id="editForm">
		<input type="hidden" name="ACT" id="ACT" value='<s:property value="ACT"/>' /> 
		<input type="hidden" name="LC" id="LC" value='<s:property value="t00355Bean.lc"/>'/>
		<input type="hidden" name="ZCS" id="ZCS" value='<s:property value="t00355Bean.zcs"/>'/>
		<input type="hidden" name="txtUPDATE" id="txtUPDATE" value="<s:text name="app.global.format.datetime"><s:param value="t00355Bean.upddate"/></s:text>" />
		<input type="hidden" name="hidSelect" id="hidSelect" />
        <table width="500" border="0" cellspacing="3" cellpadding="0">  
          <tr>
            <td>
                <label class="labelA">
                <s:property value="getText('app.xtwh.info.szqy')"/>
                </label>
		        <sw:szqy items="szqyList" name="ddlSZQY" classid="txtfocus" id="ddlSZQY" checked="t00355Bean.cd00001Szqy" />
            </td>
          </tr>
          <tr>
             <td>
                <label class="labelA">
                    <s:property value="%{getText('app.xtwh.info.fwlx')}" />      
               </label>              
               <span class="txtInfonm txtfocus"><input name="txtFWLXTIP" id="txtFWLXTIP" type="text" value="<s:property value="t00355Bean.fwlx"/>" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/><span id="spFWLX"></span></span><input type="hidden" id="txtFWLX" name="txtFWLX" value="<s:property value="t00355Bean.cd00001Fwlx"/>"/>
          	 </td>
          </tr>
          <tr>
            <td>
                <label class="labelA">
               		<s:property value="getText('app.xtwh.t00355.lc')"/>
                </label>
                <input type="text" class="txtfocus txtNumber" id="txtLC" name="txtLC" value='<s:property value="t00355Bean.lc" default="0" />'/>
            </td>
          </tr>
          <tr>
            <td>
                <label class="labelA">
                	<s:property value="getText('app.xtwh.t00355.zlc')"/>
                </label>
                <input type="text" class="txtfocus txtNumber" id="txtZCS" name="txtZCS" value='<s:property value="t00355Bean.zcs" default="0" />'/><span id="TipZcs"></span>
            </td>
          </tr>
          <!--<tr>
				<td><label class="labelA"><s:property value="getText('app.xtwh.t00303.ywdt')"/></label>
					<input type="radio" class="radio rdoYWDT" name="rdoYWDT" id="rdoYWDT0" value="0" checked="checked" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>/><s:property value="getText('app.xtwh.t00355.w')"/>
					<input type="radio" class="radio rdoYWDT" name="rdoYWDT" id="rdoYWDT1" value="1" <s:if test="%{1==t00355Bean.ywdt}">checked="checked"</s:if> <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>/><s:property value="getText('app.xtwh.t00355.y')" />
				</td>
		  </tr>-->
          
          <tr>
            <td>
                <label class="labelA">
                	<s:property value="getText('app.xtwh.sywh.xzxs')"/>(%)
                </label>
                <input type="text" class="txtfocus txtNumber" id="txtXZXS" name="txtXZXS" value="<s:property value="t00355Bean.xzxs" default="0" />" />	
            </td>
          </tr>
          <tr>
				<td><label class="labelA"><s:property value="getText('app.xtwh.t00353.yslb')"/></label>
					<input type="radio" class="radio" name="rdoCZLX" id="rdoCZLX0" value="0" checked="checked" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>/><s:property value="getText('app.xtwh.t00353.yslb.mcl')"/>
					<input type="radio" class="radio" name="rdoCZLX" id="rdoCZLX1" value="1" <s:if test="%{1==t00355Bean.czlx}">checked="checked"</s:if> <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>/><s:property value="getText('app.xtwh.t00353.yslb.DA')" />
				</td>
		  </tr>		  
          <tr>
            <td>
                <label class="labelA">
                	<s:property value="%{getText('app.note')}" />
                </label>
                <textarea name="txtNOTE" cols="20" rows="3" id="txtNOTE" ><s:property value="t00355Bean.note" /></textarea>
            </td>
          </tr>
        </table>
        </form>
   	</div>        
		<div class="divbottom">
		<div>
			<a href="javascript:void(0)" id="btnUpd" name="btnUpd" <s:if test='%{ACT=="C"}'>style="display:none"</s:if>><img src="../images/ico/Edit.gif" width="16" height="16" title="<s:property value="getText('app.button.upd')"/>" alt="<s:property value="getText('app.button.upd')"/>" /><s:property value="getText('app.button.upd')"/></a>
			<a href="javascript:void(0)" id="btnAdd" name="btnAdd" <s:if test='%{ACT!="C"}'>style="display:none"</s:if>><img src="../images/ico/Update.gif" width="16" height="16" title="<s:property value="getText('app.button.save')"/>" alt="<s:property value="getText('app.button.save')"/>" /><s:property value="getText('app.button.save')"/></a>
			<a href="VIEWT00355.action">
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
