<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sw" uri="/sunway" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title><s:property value="%{getText('app.global.title')}" /></title>
<link href="../css/screen.css" rel="stylesheet" type="text/css"/>
<link href="../css/jquery.autocomplete.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>

<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/T00303/EDITT00303.js"></script>
<script type="text/javascript" src="../scripts/T00352/T00352TREEDIV.js"></script>
<script type="text/javascript" src="../scripts/T00001/INFOTREEDIV.js"></script>
<script type="text/javascript" src="../scripts/jquery.autocomplete.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	$(function() {
		$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
		$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });
	});    
</script>
<style type="text/css">
<!--
.labelA {
	width: 60px;
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
		<span class="datagrid-title-text"><s:property value="%{getText('app.xtwh.t00303.title')}" /></span>
	</div>
	<div id="INFO" class="divConect">
	<div style="min-height:400px">
	<form id="editForm" action="EDITT00303.action" method="post">
	<input type="hidden" name="ACT" value="<s:property value="ACT"/>" />
	<input type="hidden" name="txtUPDATE" id="txtUPDATE" value="<s:text name="app.global.format.datetime"><s:param value="t00303Bean.upddate"/></s:text>" />
	<input type="hidden" name="hidSelect" id="hidSelect" />
	<s:if test='%{ACT!="C"}'>
		<input name="LFID" type="hidden" id="LFID" value="<s:property value="t00303Bean.lfid" />" />
		<input name="ddlSZQY" type="hidden" id="ddlSZQY" value="<s:property value="t00303Bean.cd00001Szqy" />" />
	</s:if>      
   		<table width="700" border="0" cellspacing="0" cellpadding="2">
		    <tr>  
                <td><label class="labelA">
						<s:property value="getText('app.xtwh.info.szqy')"/>
					</label>
					<s:if test='%{ACT=="U"}'>
	   				  <s:set name="MOD" >D</s:set>
					  <sw:szqy items="szqyList" name="ddlSZQY" classid="txtfocus" id="ddlSZQY" checked="t00303Bean.cd00001Szqy" disabled="MOD" />
					</s:if><s:else>
					  <sw:szqy items="szqyList" name="ddlSZQY" classid="txtfocus" id="ddlSZQY" checked="t00303Bean.cd00001Szqy" disabled="ACT" />
					</s:else>
				</td>
               </tr>
			<tr> 
				<td><label class="labelA">
                  		<s:property	value="%{getText('app.xtwh.t00303.xqmc')}" />
              		 </label>
               	   <span class="txtInfonm txtfocus"><input name="txtXQTIP" id="txtXQTIP" type="text" value="<s:property value="t00303Bean.xqnm" />" readonly="readonly" <s:if test='%{ACT!="C"}'>disabled="disabled"</s:if> /><span<s:if test='%{ACT=="C"}'> id="spXQDM"</s:if>></span></span><input type="hidden" id="txtXQDM" name="txtXQDM" value="<s:property value="t00303Bean.cd00352Xqdm" />"/>
               </td>
           </tr>
      		<tr>
	    		<td><label class="labelA">						  						  
						<s:property value="%{getText('app.xtwh.t00303.zlc')}" />
					</label>
				   <input name="txtZLC"  id="txtZLC" type="text" class="txtfocus txtNumber" value="<s:property value="t00303Bean.zlc" />" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />
				</td>
			</tr>
			<!-- <tr>
	    		<td><label class="labelA">
						<s:property	value="%{getText('app.xtwh.t00303.ywdt')}" />
					</label>
							<input name="rdoYWDT" id="rdoYWDT" type="radio" class="radio" value="true"
							<s:if test='%{t00303Bean.ywdt}'>checked="checked"</s:if> <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />
							有
							<input name="rdoYWDT" id="rdoYWDT" type="radio" class="radio" value="false" 
							<s:if test='%{!t00303Bean.ywdt}'>checked="checked"</s:if> <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>  />
							无
				</td>		
			</tr>
			<tr>
	    		<td><label class="labelA">
						有无架空层
					</label>
							<input name="rdoYWJKC" id="rdoYWJKC" type="radio" class="radio" value="true"
							<s:if test='%{t00303Bean.ywjkc}'>checked="checked"</s:if> <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />
							有
							<input name="rdoYWJKC" id="rdoYWJKC" type="radio" class="radio" value="false" 
							<s:if test='%{!t00303Bean.ywjkc}'>checked="checked"</s:if> <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>  />
							无
				</td>		
			</tr> -->
			<tr>
	    		<td><label class="labelA">  
						<s:property	value="%{getText('app.xtwh.t00303.clh')}" />
					</label>
						  <input name="txtCLH"  id="txtCLH" type="text" value="<s:property value="t00303Bean.clh" />" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> /></td>
			</tr>			
      		<tr>
	    		<td><label class="labelA">  
						<s:property	value="%{getText('app.xtwh.t00303.zcdzl')}" />
					</label>
						  <input name="txtFWTDZL" class="txtfocus" id="txtFWTDZL" style="width:250"   type="text" value="<s:property value="t00303Bean.zcdzl" />" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> /></td>
			             
			</tr>      		
      		<tr>
	    		<td><label class="labelA">  
						<s:property	value="%{getText('app.xtwh.t00303.lfbm')}" />
					</label>
						  <input name="txtZCDZBM" id="txtZCDZBM" style="width:250" type="text" value="<s:property value="t00303Bean.zcdzbm" />" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> /></td>
			</tr> 			 					
			<tr>
	    		<td><label class="labelA">				  
						<s:property	value="%{getText('app.note')}" />
					</label>
							<textarea name="txtNOTE" id="txtNOTE" cols="20" rows="3" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> ><s:property value="t00303Bean.note" /></textarea></td>
			</tr>
		</table>
		</form>
		</div>				  
	<div id="dialog" class="easyui-window" title="请选择类型..." icon="icon-ok" style="width:350px;height:350px;padding:5px;background: #fafafa;">
		<div id="infoTreeDIV"></div>
	</div>	
<table id="test"></table>						  
	<div class="divbottom">
	<div>
	<s:if test='%{ACT=="U"}'>
	  <a href="javascript:AppSubmit();"><img src="../images/ico/Edit.gif" width="16" height="16" title="<s:property value="getText('app.button.upd')"/>" alt="<s:property value="getText('app.button.upd')"/>" /><s:property value="getText('app.button.upd')"/></a>
	</s:if> 
	<s:elseif test='%{ACT=="C"}'>
	  <a href="javascript:AppSubmit();"><img src="../images/ico/Update.gif" width="16" height="16" title="<s:property value="getText('app.button.save')"/>" alt="<s:property value="getText('app.button.save')"/>" /><s:property value="getText('app.button.save')"/></a>
	</s:elseif> 
	<s:elseif test='%{ACT=="D"}'>
	  <a href="javascript:AppSubmit();"><img src="../images/ico/Delete.gif" width="16" height="16" title="<s:property value="getText('app.button.del')"/>" alt="<s:property value="getText('app.button.del')"/>" /><s:property value="getText('app.button.del')"/></a>
	</s:elseif> 
	<a href="VIEWT00303.action"><img src="../images/ico/Cancel.gif" width="16" height="16" title="<s:property value="getText('app.button.back')"/>" alt="<s:property value="getText('app.button.back')"/>" /><s:property value="getText('app.button.back')"/></a>
</div>
</div>

</div>
</div>
<s:if test='%{ACT=="C" && t00303Bean.cd00352Xqdm!=null && t00303Bean.cd00001Szqy!=null}'>
	<script type="text/javascript" language="javascript">
		getXQ("<s:property value='t00303Bean.cd00001Szqy'/>","<s:property value='t00303Bean.cd00352Xqdm'/>","#txtXQTIP");
	</script>
</s:if>
    </td>
  </tr>
</table>
</body>
</html>
