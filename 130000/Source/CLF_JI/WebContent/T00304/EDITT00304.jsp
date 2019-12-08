<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sw" uri="/sunway" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title><s:property value="%{getText('app.global.title')}" /></title>
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<script type="text/javascript" src="../scripts/jquery.autocomplete.js"></script>
<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/DatePicker/WdatePicker.js"></script>

<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../scripts/T00304/EDITT00304.js"></script>
<script type="text/javascript" src="../scripts/T00352/T00352TREEDIV.js"></script>
<script type="text/javascript" src="../scripts/T00053/T00053TREEDIV.js"></script>
<script type="text/javascript" src="../scripts/T00001/INFOTREEDIV.js"></script>
<script type="text/javascript" src="../scripts/CZ00006/CZ00006.js"></script>
<link type="text/css" rel="stylesheet" href="../css/screen.css" />
<link type="text/css" rel="stylesheet" href="../css/jquery.autocomplete.css" />


<script type="text/javascript">
	$(function() {
		$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
		$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });
	});    
</script>
<style type="text/css">
<!--
.labelA {
	width:120px;
}
-->
</style>

</head>
<body>
<table border="0" align="left" cellpadding="0" cellspacing="0" class="table1">
  <tr>
    <td align="left" valign="top">
	
	<div class="ui-widget-content">
        <ul class="ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header">
            <li><a href="#INFO"><span><s:property value="%{getText('app.xtwh.t00304.title')}" /></span></a></li>                    
        </ul>
		<div id="INFO" class="divConect">
<form id="editForm" action="EDITT00304.action" method="post">
	<input type="hidden" name="ACT" value="<s:property value="ACT"/>" />
	<input type="hidden" name="txtUPDATE" id="txtUPDATE" value="<s:text name="app.global.format.datetime"><s:param value="t00304Bean.upddate"/></s:text>" />
	<input type="hidden" name="hidSelect" id="hidSelect" />
	<input type="hidden" name="XQDM" id="XQDM" value="<s:property value="t00304Bean.cd00352Xqdm"/>" />
	<input type="hidden" name="FWTDZL" id="FWTDZL" value="<s:property value="t00304Bean.fwtdzl"/>" />
	<!-- <input type="hidden" name="hidXZLX" id="hidXZLX" value="<s:property value="XZLX"/>" /> -->
	<input type="hidden" name="hidNsrmc" id="hidNsrmc" value="<s:property value="t00304Bean.nsrmc"/>" />
	<s:if test='%{ACT!="C"}'>
		<input name="GPID" type="hidden" id="GPID" value="<s:property value="t00304Bean.gpid" />" />
		<input name="ddlSZQY" type="hidden" id="ddlSZQY" value="<s:property value="t00304Bean.cd00001Szqy" />" />
	</s:if>
	<table width="650" border="0" cellspacing="3" cellpadding="0">
	  <tr>
   		<td>
   		<!--
			<fieldset>
				<legend>基本信息</legend>
					<table width="100%" border="0" cellspacing="2" cellpadding="0">
						<tr>
		                    <td><label class="labelA">
		                            <s:property value="getText('app.sjcj.t00301.nsrmc')"/>
		                        </label>
		                        <input name="txtNSRMC"  class="txtfocus txtNSRMC" id="txtNSRMC" type="text" value="<s:property value="t00304Bean.nsrmc" />" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>/>
		                    </td>
		                    <td><label class="labelA">
		                            <s:property value="getText('app.sjcj.t00301.swid')"/>
		                        </label>
		                        <input name="txtSWID" class="txtfocus" id="txtSWID" type="text" value="<s:property value="t00304Bean.swid" />" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>/>
		                   </td>
						</tr>
					</table>
			</fieldset>
		-->
			<fieldset>
              <legend>【楼房信息(幢)】</legend>
					<table width="100%" border="0" cellspacing="2" cellpadding="0">
						<tr>
			      			<td>
			    				<table width="100%" border="0" cellspacing="2" cellpadding="0">
			    					<tr>
					            	 	<td><label class="labelA">
					                            <s:property	value="%{getText('app.xtwh.t00303.zcdzl')}" />
					                        </label>
					                        <input name="txtFWTDZL" class="txtfocus" id="txtFWTDZL" type="text" value="<s:property value="t00304Bean.fwtdzl" />" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>/>
					                    </td>  
				                    </tr>
				                    <tr>  
					                    <td><label class="labelA">
					                            <s:property value="getText('app.xtwh.info.szqy')"/>
					                        </label>
					                          <sw:szqy items="szqyList" name="ddlSZQY" classid="txtfocus" id="ddlSZQY" checked="t00304Bean.cd00001Szqy" disabled="ACT"/>
					                    </td>
				                    </tr>
				                    <tr> 
					                    <td><label class="labelA">
					                            <s:property	value="%{getText('app.xtwh.t00303.xqmc')}" />
					                        </label>
					                        <span class="txtInfonm txtfocus"><input name="txtXQTIP" id="txtXQTIP" type="text" value="<s:property value="t00304Bean.xqmc" />" readonly="readonly" <s:if test='%{ACT!="C"}'>disabled="disabled"</s:if> /><span<s:if test='%{ACT=="C"}'> id="spXQDM"</s:if>></span></span><input type="hidden" id="txtXQDM" name="txtXQDM" value="<s:property value="t00304Bean.cd00352Xqdm" />"/>
					                    </td>
				                    </tr>
			                    </table>
		                    </td>
		                    <td valign="top">
				               <table width="100%" border="0" cellspacing="2" cellpadding="0">
			    					<tr>
					                    <td><label class="labelA">
												<s:property value="%{getText('app.xtwh.t00303.zlc')}" />
											</label>
											<input name="txtZLC" class="txtfocus txtNumber" id="txtZLC" type="text" value="<s:property value="t00304Bean.zlc" default="0"/>" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />
										</td>
									</tr>
									<tr>  
										<td><label class="labelA">
												<s:property value="%{getText('app.xtwh.t00303.ywdt')}" />
											</label>
											<input name="rdoYWDT" id="rdoYWDTT" type="radio" class="radio" value="true" <s:if test='%{t00304Bean.ywdt}'>checked="checked"</s:if>  <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />
											有
											<input name="rdoYWDT" id="rdoYWDTF" type="radio" class="radio" value="false"  <s:if test='%{!t00304Bean.ywdt}'>checked="checked"</s:if>  <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />
											无
										</td>
					                </tr>
								</table>
							</td>
	                    </tr>
                    </table>
			</fieldset>
			<fieldset>
                <legend>【房产信息】</legend>
                    <table width="100%" border="0" cellspacing="2" cellpadding="0">
						 <tr>
			      			<td>
			    				<table width="100%" border="0" cellspacing="2" cellpadding="0">
			    					<tr>
							    		<td><label class="labelA">
												<s:property value="%{getText('app.xtwh.t00304.sfzj')}" />
											</label>
											<input name="rdoSFZJ" id="rdoSFZJT" type="radio" class="radio" value="true" <s:if test='%{t00304Bean.sfzj}'>checked="checked"</s:if>  <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />
											是
											<input name="rdoSFZJ" id="rdoSFZJF" type="radio" class="radio" value="false"  <s:if test='%{!t00304Bean.sfzj}'>checked="checked"</s:if>  <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />
											否
										</td>
									</tr>
			    					
								  	<tr>
									  	<td><label class="labelA">
												<s:property value="getText('app.sjcj.t00302.jzmj')"/>
											</label>
											<input name="txtJZMJ" class="txtfocus txtNumber" id="txtJZMJ" type="text" value="<s:property value="t00304Bean.jzmj" default="0"/>" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />
										</td>
									</tr>
								  	<tr>
										<td><label class="labelA">
												<s:property value="%{getText('app.xtwh.t00304.zbjg')}" />
											</label>
											<input name="txtZBJG" class="txtfocus txtNumber" id="txtZBJG" type="text" value="<s:property value="t00304Bean.zbjg" default="0"/>" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />
										</td>
									</tr>
								  	<tr>
										<td><label class="labelA">
												<s:property value="getText('app.sjcj.t00302.szlc')"/>
											</label>
											<input name="txtSZLC" class="txtfocus txtNumber" id="txtSZLC" type="text" value="<s:property value="t00304Bean.szlc" default="0"/>" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />
										</td>
									</tr>
								  	<tr>
										<td><label class="labelA">
												<s:property value="getText('app.xtwh.t00304.hx')"/>
											</label>
											<input name="txtHX"  id="txtHX" type="text" value="<s:property value="t00304Bean.hx" />" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />
										</td> 
									</tr>
									
								</table>
							</td>
							<td valign="top">
			    				<table width="100%" border="0" cellspacing="2" cellpadding="0">
			    					<tr>
			    						<td><label class="labelA">
												<s:property	value="%{getText('app.xtwh.info.jzjg')}" />
											</label>
											  <span class="txtInfonm txtfocus"><input name="txtJZJGTIP" id="txtJZJGTIP" type="text" value="<s:property value="t00304Bean.jzjg" />" readonly="readonly" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> /><span<s:if test='%{ACT!="D"}'> id="spJZJG"</s:if>></span></span><input type="hidden" id="txtJZJG" name="txtJZJG" value="<s:property value="t00304Bean.cd00001Jzjg" />"/>
									  	</td>
								  	</tr>
								  	<tr>
										<td><label class="labelA">
												<s:property	value="%{getText('app.xtwh.info.fwlx')}" />
											</label>
										  <span class="txtInfonm txtfocus"><input name="txtFWLXTIP" id="txtFWLXTIP" type="text" value="<s:property value="t00304Bean.fwlx" />" readonly="readonly" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> /><span<s:if test='%{ACT!="D"}'> id="spFWLX"</s:if>></span></span><input type="hidden" id="txtFWLX" name="txtFWLX" value="<s:property value="t00304Bean.cd00001Fwlx" />"/>
										</td>
									</tr>
									<tr>
										<td><label class="labelA">
												<s:property	value="%{getText('app.xtwh.info.jylx')}" />
											</label>
											  <span class="txtInfonm txtfocus"><input name="txtJYLXTIP" id="txtJYLXTIP" type="text" value="<s:property value="t00304Bean.jylx" />" readonly="readonly" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> /><span<s:if test='%{ACT!="D"}'> id="spJYLX"</s:if>></span></span><input type="hidden" id="txtJYLX" name="txtJYLX" value="<s:property value="t00304Bean.cd00001Jylx" />"/>
									  	</td>
								  	</tr>
								  	<tr>
										<td>
											<label class="labelA"><s:property value="%{getText('app.xtwh.t00304.gpsj')}" /></label>
											<input type="text" id="txtGPSJ" name="txtGPSJ" value="<s:if test="null!=t00304Bean.gpsj"><s:text name="app.global.format.date"><s:param value="t00304Bean.gpsj" /></s:text></s:if>" onfocus="WdatePicker({maxDate:'%y-%M-%d'})" class="Wdatefocus"  <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />
										</td>
									</tr>
									
		            			</table>
	            			</td>
						</tr>
					</table>
	 			</fieldset>
        		</td>
	        </tr>
	        <tr>
   				<td>
   					<table width="100%" border="0" cellspacing="2" cellpadding="0">
  						<tr><!-- 
    						<td>
						       	<fieldset style="width:200px"><legend>【景观状况】<a id="btnAddQTXZ" name="btnAddQTXZ" style="cursor: pointer;" title="添加"><img src="../images/ico/Add.gif" /></a></legend>
						            <table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
								            <td>
												<div id="ddlQTXZ" style="width:320px;height:60px;overflow:auto;border: 2px inset #FFFFFF;">
													<s:iterator value="t00304aList" status="index" id="qtxzEntity">
								                        <span class="qtxz"><s:property value="qtmc"/> <a href="javascript:;" QTXZ="<s:property value="qtid"/>" onclick="qtxzClick(this);">[删]</a></span>
								                    </s:iterator>
										        </div>
											<input type="hidden" id="hidQTXZ" name="hidQTXZ" value="<s:iterator value="t00304aList" status="index" id="qtxzEntity"><s:property value='qtid'/>,</s:iterator>" />
											</td>
										</tr>
						            </table>
					        	</fieldset>
				        	</td> -->
				        	<td>
					        	<fieldset>
				                <legend>【备注】</legend>
				                    <table width="350" border="0" cellspacing="4" cellpadding="0">
						                    <tr>
									    		<td>
													<textarea name="txtNOTE" id="txtNOTE"  cols="50" rows="4"<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> ><s:property value="t00304Bean.note" /></textarea>
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
	<a href="VIEWT00304.action?ACT=<s:property value="BG"/>"><img src="../images/ico/Cancel.gif" width="16" height="16" title="<s:property value="getText('app.button.back')"/>" alt="<s:property value="getText('app.button.back')"/>" /><s:property value="getText('app.button.back')"/></a>
</div>
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
