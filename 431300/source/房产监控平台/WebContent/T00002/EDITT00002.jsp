<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title><s:property value="%{getText('app.global.title')}" /></title>

<script type="text/javascript" src="../scripts/easyui/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<link href="../css/screen.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="../scripts/T00002/EDITT00002.js"></script>
<script type="text/javascript" src="../scripts/T00001/INFOTREEDIV.js"></script>
<script type="text/javascript" src="../scripts/DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../scripts/simpleTips/jquery.simpleTips-1.0.js"></script>
<link rel="stylesheet" type="text/css" href="../scripts/simpleTips/jquery.simpleTips.css" />
<script type="text/javascript">
	$(function() {
		$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
		$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });
		
	});  
	<s:if test='%{ACT=="C"}'>getSSGX('<s:property value="SSGX"/>','#txtSSGXTIP');</s:if>  
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
	
    <div id="tabs" class="ui-tabs ui-widget ui-widget-content ui-corner-all">
       	<div class="datagrid-title">
			<span class="datagrid-title-text"><s:property value="%{getText('app.xtwh.t00002.title')}" /></span>
		</div>
		<div id="INFO" class="divConect">
		<div style="min-height:400px">
<form id="editForm" action="EDITT00002.action" method="post">
	<input type="hidden" name="ACT" id="ACT" value="<s:property value="ACT"/>" /> 
	<input type="hidden" name="txtUPDATE" id="txtUPDATE" value="<s:text name="app.global.format.datetime"><s:param value="t00002Bean.upddate"/></s:text>" />
	<!-- 2012-2-16日添加 更新操作时存储原用户编码及税收管辖 ↓ -->
	<s:if test='%{ACT == "U"}'>
		<input type="hidden" name="txtUSERIDOLD" id="txtUSERIDOLD" value='<s:property value="t00002Bean.userid" />' />
		<input type="hidden" name="txtSSGXOLD" id="txtSSGXOLD" value='<s:property value="t00002Bean.cd00001Ssgx" />' />
	</s:if>
	<!-- ↑ -->
	<s:if test='%{ACT=="D"}'>
		<input name="txtUSERID" type="hidden" id="txtUSERID" value="<s:property value="t00002Bean.userid" />" />
	</s:if>
		<table width="550" border="0" cellspacing="3" cellpadding="0">
		 <tr>
   		 <td>
		<fieldset style="height:233px;width:200px">
                <legend>基本信息</legend>
                    <table width="350" border="0" cellspacing="2" cellpadding="0">
      		<tr>
	    		<td><label class="labelA">		    		
						<s:property value="%{getText('app.xtwh.t00002.userid')}" />
					</label>
					<input onkeyup="value=this.value.replace(/\D+/g,'')" name="txtUSERID" class="txtfocus" id="txtUSERID" type="text" <s:if test='%{ACT != "C"}'> value="<s:property value="t00002Bean.userid" />"</s:if> <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> /><span id="txtUSERSpan"></span>
				</td>
			</tr>
			<tr>
	    		<td><label class="labelA">				
						<s:property value="%{getText('app.xtwh.t00002.usernm')}" />
					</label>
					<input name="txtUSERNM" class="txtfocus" id="txtUSERNM" type="text" <s:if test='%{ACT != "C"}'> value="<s:property value="t00002Bean.usernm" />"</s:if> <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> onkeyup="value=value.replace(/[ -~]/g,'')" />  <span style="font-color:red;">请输入汉字</span>
				</td>
			</tr>
			<s:if test='%{ACT=="C"}'>
			<tr>
	    		<td><label class="labelA">				
						<s:property value="%{getText('app.xtwh.t00002.userpwd')}" />
					</label>
					123456
				</td>
			</tr>
			</s:if>
			<tr>
	    		<td><label class="labelA">
						<s:property value="%{getText('app.note')}" />
					</label>
					<textarea name="txtNOTE" id="txtNOTE" cols="30" rows="5" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> ><s:if test='%{ACT != "C"}'><s:property value="t00002Bean.note" /></s:if></textarea>
				</td>
			</tr>			
			<s:if test='%{ISADMIN==2}'>
				<tr>
		    		<td><label class="labelA">		
							<s:property value="%{getText('app.xtwh.t00002.isadmin')}" />
						</label>
						<input name="rdoISADMIN" id="rdoISADMIN" type="radio" class="radio" value="2"
						<s:if test='%{t00002Bean.isadmin==2  && ACT != "C"}'>checked="checked"</s:if> 
						<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />
						管理员
<!--						<input name="rdoISADMIN" id="rdoISADMIN" type="radio" class="radio" value="1"-->
<!--						<s:if test='%{t00002Bean.isadmin==1}'>checked="checked"</s:if> -->
<!--						<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />-->
<!--						普通管理员-->
						<input name="rdoISADMIN" id="rdoISADMIN" type="radio" class="radio" value="0"
						<s:if test='%{(null==t00002Bean || t00002Bean.isadmin!=2)  && ACT != "C"}'>checked="checked"</s:if><s:elseif test='%{ACT == "C"}'>checked="checked"</s:elseif>
						<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />
						非管理员
					</td>
				</tr>
			</s:if>
			<tr>
				<td>
				<label class="labelA">	
				<s:property value="%{getText('app.xtwh.t00002.qx')}" />
				</label>
					<select name="txtQXID" id="txtQXID" class="txtfocus" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>>
				        <option <s:if test="%{0==t00002Bean.qxid}">selected="selected"</s:if> value="0">
				                  普通用户
				        </option>
				         <option <s:if test="%{1==t00002Bean.qxid}">selected="selected"</s:if> value="1">
				                  用户管理
				        </option>
				        <option <s:if test="%{2==t00002Bean.qxid}">selected="selected"</s:if> value="2">
				                  发给房产税款信息
				        </option>
					</select>
				</td>
			</tr>		
			<tr>
					<td><label class="labelA">
							<s:property value="getText('app.xtwh.info.ssgxname')" />
						</label>	
						<span class="txtInfonm txtfocus"><input type="text" id="txtSSGXTIP" name="txtSSGXTIP" readonly="readonly" value="<s:property value="t00002Bean.ssgx"/>" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> /><span <s:if test='%{ACT!="D"}'> id="spSSGX"</s:if> <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>></span></span><input type="hidden" id="txtSSGX" name="txtSSGX" <s:if test='%{ACT=="C"}'>value="<s:property value="SSGX"/>"</s:if><s:else>value="<s:property value="t00002Bean.cd00001Ssgx"/>"</s:else> />
					</td>
				</tr>			
		</table>
		</fieldset>
		</td>		
		</tr>
		</table>
		</form>
		</div>
	
	<div id="dialog"  title="请选择类型..." icon="icon-ok" style="width:350px;height:350px;padding:5px;background: #fafafa;">
		<div id="infoTreeDIV"></div>
	</div>
	
</div>
</div>
<div class="divbottom">
	<div>
		<s:if test='%{ACT=="U"}'>
			<a href="javascript:AppSubmit();" class="easyui-linkbutton" plain="true" iconCls="icon-edit"><s:property value="getText('app.button.upd')"/>
			</a>
		</s:if> 
		<s:elseif test='%{ACT=="C"}'>
			<a href="javascript:AppSubmit();" class="easyui-linkbutton" plain="true" iconCls="icon-save"><s:property value="getText('app.button.save')"/>
			</a>
		</s:elseif> 
		<s:elseif test='%{ACT=="D"}'>
			<a href="javascript:AppSubmit();" class="easyui-linkbutton" plain="true" iconCls="icon-delete"><s:property value="getText('app.button.del')"/>
			</a>
		</s:elseif> 
		<a href="VIEWT00002.action" class="easyui-linkbutton" plain="true" iconCls="icon-back"><s:property value="getText('app.button.back')"/>
		</a>
	</div>	
	</div>
    </td>
  </tr>
</table>
</body>
</html>
