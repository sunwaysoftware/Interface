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

<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/T00055/EDITT00055.js"></script>
<script type="text/javascript" src="../scripts/T00001/INFOTREEDIV.js"></script>
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
	width: 100px;
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
            <li><a href="#INFO"><span><s:property value="%{getText('app.xtwh.t00055.title')}" /></span></a></li>                    
        </ul>
		<div id="INFO" class="divConect">
		<div style="min-height:400px">
<form action="EDITT00055.action" method="post" id="editForm">
		<input type="hidden" name="ACT" value='<s:property value="ACT"/>' /> 
		<input type="hidden" name="txtUPDATE" id="txtUPDATE" value="<s:text name="app.global.format.datetime"><s:param value="t00055Bean.upddate"/></s:text>" />
        <table width="500" border="0" cellspacing="0" cellpadding="2">
          <tr>
            <td valign="top">
            	<table width="100%" border="0" cellspacing="3" cellpadding="0">
            		<tr>
		    			<td><label class="labelA">
								<s:property value="getText('app.xtwh.t00055.zjlx')"/>
							</label>
							<span class="txtInfonm txtfocus"><input type="text" id="txtZJLXNm" name="txtZJLXNm" value="<s:property value="t00055Bean.zjlx"/>" readonly="readonly" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> /><span<s:if test='%{ACT=="C"}'> id="spZJLX"</s:if>></span></span><input type="hidden" id="txtZJLXId" name="txtZJLXId" value="<s:property value="t00055Bean.cd00001Zjlx"/>"/>
						</td>									
					</tr>
                    <tr>
                        <td><label class="labelA">	
                               <s:property value="getText('app.xtwh.t00055.yxws')"/>
                            </label>
                            <input type="text" class="txtfocus txtNumber" id="txtYXWS" name="txtYXWS" value="<s:property value="t00055Bean.yxws"/>"  <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />	
                        </td>
                    </tr>
                    <tr>
                        <td><label class="labelA">		
                                <s:property value="%{getText('app.note')}" />
                            </label>
                            <textarea name="txtNOTE" id="txtNOTE" cols="26" rows="3"  <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> ><s:property value="t00055Bean.note" /></textarea>
                        </td>
                    </tr>
                </table>
            </td>
          </tr>
        </table>
        </form>
        </div>
		<div class="divbottom">
			<s:if test='%{ACT=="U"}'>
				<a href="javascript:AppSubmit();">
					<img src="../images/ico/Edit.gif" width="16" height="16" title="<s:property value="getText('app.button.upd')"/>" alt="<s:property value="getText('app.button.upd')"/>" /><s:property value="getText('app.button.upd')"/>
				</a>
			</s:if> 
			<s:elseif test='%{ACT=="C"}'>
				<a href="javascript:AppSubmit();">
					<img src="../images/ico/Update.gif" width="16" height="16" title="<s:property value="getText('app.button.save')"/>" alt="<s:property value="getText('app.button.save')"/>" /><s:property value="getText('app.button.save')"/>
				</a>
			</s:elseif> 
			<s:elseif test='%{ACT=="D"}'>
				<a href="javascript:AppSubmit();">
					<img src="../images/ico/Delete.gif" width="16" height="16" title="<s:property value="getText('app.button.del')"/>" alt="<s:property value="getText('app.button.del')"/>" /><s:property value="getText('app.button.del')"/>
				</a>
			</s:elseif> 
			<a href="VIEWT00055.action">
				<img src="../images/ico/Cancel.gif" width="16" height="16" title="<s:property value="getText('app.button.back')"/>" alt="<s:property value="getText('app.button.back')"/>" /><s:property value="getText('app.button.back')"/>
			</a>
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
