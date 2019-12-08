<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sw" uri="/sunway"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title><s:property value="%{getText('app.global.title')}" /></title>

<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<link href="../css/screen.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../scripts/T00321/EDITT00321.js"></script>
<script type="text/javascript" src="../scripts/T00352/T00352TREEDIV.js"></script>
<script type="text/javascript" src="../scripts/T00053/T00053TREEDIV.js"></script>
<script type="text/javascript" src="../scripts/T00001/INFOTREEDIV.js"></script>
<script type="text/javascript" src="../scripts/jquery.autocomplete.js"></script>
<link type="text/css" rel="stylesheet" href="../css/jquery.autocomplete.css" />
<script type="text/javascript" src="../scripts/T00303/T00303DIV.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	$(function() {
		$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
		$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });
		if ($('#txtFWLX').val()!='')
			{
			getFWLX($('#txtFWLX').val(), '#txtFWLXTIP');
			}
		if ($('#txtJZJGT').val()!='')
			{
			getJZJG($('#txtJZJGT').val(),'#txtJZJGTTIP');
			}
		if ($('#ddlSZQY').val()!='')
		{
			$("#ddlSZQY").change();
		}
	});
</script>
<style type="text/css">
<!--
.labelA {
	width: 120px;
}
-->
</style>

</head>
<body>
<table border="0" align="left" cellpadding="0" cellspacing="0"
	class="table1">
	<tr>
		<td align="left" valign="top">
		<div class="ui-widget-content">
	<div class="datagrid-title">
		<span class="datagrid-title-text"><s:property
				value="%{getText('一手房交易数据')}" /></span>
	</div>		
		<form id="editForm" action="EDITT00321.action" method="post">
		<input	type="hidden" name="ACT" id="ACT" value="<s:property value="ACT"/>" /> 
		<input	type="hidden" name="txtUPDATE" id="txtUPDATE" value="<s:text name="app.global.format.datetime"><s:param value="tBean.upddate"/></s:text>" />
		<input type="hidden" name="hidSelect" id="hidSelect" /> 
		<input	type="hidden" name="FWTDZL" id="FWTDZL"	value="<s:property value="t00303Bean.fwtdzl"/>" /> 
		<input	type="hidden" name="hidXZLX" id="hidXZLX"	value="<s:property value="XZLX"/>" /> 
		<input type="hidden" name="SZQY" id="SZQY"	value="<s:property value="t00303Bean.cd00001Szqy"/>" /> 
		<input	type="hidden" name="JYSJ" id="JYSJ"	value="<s:property value="tBean.jysj"/>" />
		<s:if test='%{FROM=="U"}'>
			<input type="hidden" name="txtZCDZL" id="txtZCDZL" value="<s:property value="tBean.zcdzl" />" /> 
		</s:if>
		<table width="650" border="0" cellspacing="3" cellpadding="0">
			<tr>
				<td>
				<fieldset>
				<legend>【楼房信息】</legend>
					<table width="100%" border="0" cellspacing="2" cellpadding="0">
						<tr>
							<td valign="top" width="350">
		    					<table width="100%" border="0" cellspacing="3" cellpadding="0">
									<tr>
										<td><label class="labelA">
												<s:property value="%{getText('app.xtwh.t00303.clh')}" />
											</label>
								  				<input name="txtCLH" class="" id="txtCLH" type="text" value="<s:property value="t00303Bean.clh" />" <s:if test='%{ACT!="C"}'>disabled="disabled"</s:if>/>
										</td>
									</tr>
									<tr>
										<td><label class="labelA">
												<s:property value="%{getText('幢号')}" />
											</label>
								  				<input name="txtZH" class="" id="txtZH" type="text" value="<s:property value="t00303Bean.clh" />" <s:if test='%{ACT!="C"}'>disabled="disabled"</s:if>/>
										</td>
									</tr>
									<tr>
										<td><label class="labelA">
												<s:property value="%{getText('单元号')}" />
											</label>
								  				<input name="txtDYH" class="" id="txtDYH" type="text" value="<s:property value="t00303Bean.clh" />" <s:if test='%{ACT!="C"}'>disabled="disabled"</s:if>/>
										</td>
									</tr>
									<tr>
										<td><label class="labelA">
												<s:property value="%{getText('房号')}" />
											</label>
								  				<input name="txtDYH" class="" id="txtDYH" type="text" value="<s:property value="t00303Bean.clh" />" <s:if test='%{ACT!="C"}'>disabled="disabled"</s:if>/>
										</td>
									</tr>
									<tr>
										<td><label class="labelA"> <s:property value="%{getText('app.xtwh.t00303.zcdzl')}" /></label> 
											<input name="txtZCDZL" id="txtZCDZL" type="text" class="txtfocus" value="<s:property value="tBean.zcdzl"/>" <s:if test='%{FROM=="U"}'>disabled="disabled"</s:if> /></td>
									</tr>
									<tr>
								  	<td><label class="labelA">
											<s:property value="getText('app.xtwh.t00351.szlc')"/>
										</label>
							  			<input name="txtSZLC" class="txtfocus txtNumber" id="txtSZLC" type="text" value="<s:property value="tBean.szlc" />" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />
							  		</td>
								</tr>									 
								</table>
                   			</td>                   			
							<td valign="top" >
					    		<table width="100%" border="0" cellspacing="2" cellpadding="0">
						          	<tr>
										<td>
										<div id="T00303DIV"><%@include file="../T00303/T00303DIV.jsp"%></div>
										</td>
									</tr>
						        </table>
					        </td>
				        </tr>
					</table>
	      	</fieldset>
	      	<fieldset>
				<legend>【房产信息】</legend>
					<table width="100%" border="0" cellspacing="3" cellpadding="0">
						<tr>	                        
                        	<td width="350">
			    				<label class="labelA"><s:property value="%{getText('app.xtwh.info.fwlx')}" /></label>
								<span class="txtInfonm txtfocus"><input name="txtFWLXTIP" id="txtFWLXTIP" type="text" value="<s:property value="tBean.fwlxsc" />" readonly="readonly"  /><span id="spFWLX"></span></span><input type="hidden" id="txtFWLX" name="txtFWLX" value="<s:property value="tBean.cd00001Fwlx" />"/>
					        </td>
					        <td>			    				
				    			<label class="labelA"><s:property value="%{getText('app.xtwh.info.jzjg')}" /></label>
							  	<span class="txtInfonm txtfocus"><input name="txtJZJGTTIP" id="txtJZJGTTIP" type="text" value="<s:property value="tBean.jzjg" />" readonly="readonly"  /><span id="spJZJG"></span></span><input type="hidden" id="txtJZJGT" name="txtJZJGT" value="<s:property value="tBean.cd00001Jzjg" />"/>
						  	<td>
						</tr>
						 
						<tr>
							<td>
				    			<label class="labelA"><s:property value="%{getText('app.sjcj.t12003.jcnf')}" /></label>
		     					<input name="txtJCNF"  id="txtJCNF" class="txtfocus txtNumber" maxlength="4" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>  type="text" value="<s:property value="v00303Bean.jcnf" />"  />
	          		            
						  	</td>
						  	<td>
						  	    <label class="labelA"><s:property value="%{getText('建筑面积')}" /></label>
		     					<input name="txtJZMJ"  id="txtJZMJ" class="txtfocus txtNumber"  <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>  type="text" value="<s:property value="v00303Bean.jcnf" />"  />
						  	</td>
					  	</tr>
					  	<tr>
					  		<td><label class="labelA"><s:property value="getText('app.xtwh.t00351.jysj')" /></label> 
								<input name="txtJYSJ" id="txtJYSJ" type="text" value="<s:if test="null!=tBean.jysj"><s:text name="app.global.format.date"><s:param value="tBean.jysj" /></s:text></s:if>" onfocus="WdatePicker({date:'#F{$dp.$D(\'txtJYSJ\',null);}'})" class="Wdatefocus"  />
								<!-- 默认变更日期为当?-->								
							</td>
							<td><label class="labelA"><s:property value="getText('评估价格')" /></label> 
								<input name="txtPFMJG" class="txtfocus txtNumber" id="txtPFMJG" type="text" value="<s:property value="tBean.pfmjg" default="0" />" />
							</td>							
						</tr>						
	        		</table>
				</fieldset>
			 </td>
		</tr>
		<tr>
			<td>
				<table width="100%" border="0" cellspacing="2" cellpadding="0">
					<tr>
						<td>
      						<fieldset><legend>【综合修正】<input type="hidden" id="hidZHXZ" name="hidZHXZ" value="" /></legend>
					            <table width="100%" border="0" cellspacing="0" cellpadding="0">
					             <tr>
					                <td>
					                  <div id="ddlQTXZ" class="divZhxz">
						                <div id="tt1">                    
											
										</div>
						              </div>								              
									  <input type="hidden" id="hidZHXZid" name="hidZHXZid" value="" />
					                </td>
					            </tr>
					            </table>
				        	</fieldset>
			        	</td>
			        	
	  				</tr>
				</table>
			</td>
	  	</tr>
	  	<tr>
	  		<td>
	  			<table width="100%" border="0" cellspacing="2" cellpadding="0">
	  				<tr>
	  					<td>
				        	<fieldset>
				                <legend>【备注】</legend>
				                    <table width="200" border="0" cellspacing="4" cellpadding="0">
				                    <tr>
							            <td>
							              <textarea name="txtNOTET00351" id="txtNOTET00351" cols="120" rows="6" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> ><s:property value="tBean.note" /></textarea>
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
			<div><a href="javascript:AppSubmit();"><img src="../images/ico/Update.gif" width="16" height="16" title="<s:property value="getText('app.button.save')"/>" alt="<s:property value="getText('app.button.save')"/>" /><s:property value="getText('app.button.save')" /></a> <a href="VIEWT00321.action"><img
				src="../images/ico/Cancel.gif" width="16" height="16" title="<s:property value="getText('app.button.back')"/>" alt="<s:property value="getText('app.button.back')"/>" /><s:property value="getText('app.button.back')" /></a></div>
			</div>
			<div id="dialog" class="easyui-window" title="请选择类型..." icon="icon-ok" style="width:350px;height:350px;padding:5px;background: #fafafa;">
				<div id="infoTreeDIV"></div>
			</div>
		</div>
		</td>
	</tr>
</table>


</body>

</html>