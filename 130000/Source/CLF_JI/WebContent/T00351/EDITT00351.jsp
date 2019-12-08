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
<script type="text/javascript" src="../scripts/DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../scripts/jquery.maskedinput.js"></script>
<script type="text/javascript" src="../scripts/T00351/EDITT00351.js"></script>
<script type="text/javascript" src="../scripts/T00352/T00352TREEDIV.js"></script>
<script type="text/javascript" src="../scripts/T00053/T00053TREEDIV.js"></script>
<script type="text/javascript" src="../scripts/T00001/INFOTREEDIV.js"></script>
<script type="text/javascript" src="../scripts/jquery.autocomplete.js"></script>
<link type="text/css" rel="stylesheet" href="../css/jquery.autocomplete.css" />
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../scripts/T00303/T00303DIV.js"></script>
<script type="text/javascript">
	$(function() {
		$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
		$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });
		
		//bindLFXXValue("<s:property value='v00303Bean.zcdzl'/>","<s:property value="v00303Bean.clh" />","#T00303DIV","<s:property value='ACT'/>");
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
<table border="0" align="left" cellpadding="0" cellspacing="0" class="table1">
  <tr>
    <td align="left" valign="top">
	
	<div class="ui-widget-content">
	<div class="datagrid-title">
		<span class="datagrid-title-text"><s:property
				value="%{getText('app.xtwh.t00351.title')}" />--维护信息</span>
	</div>
<form id="editForm" action="EDITT00351.action" method="post">
	<input type="hidden" name="ACT" value="<s:property value="ACT"/>" />
	<input type="hidden" name="txtUPDATE" id="txtUPDATE" value="<s:text name="app.global.format.datetime"><s:param value="tBean.upddate"/></s:text>" />
	<input type="hidden" name="hidSelect" id="hidSelect" />
	<input type="hidden" name="hidXZLX" id="hidXZLX" value="<s:property value="XZLX"/>" />
	<input name="SLID" type="hidden" id="SLID" value="<s:property value="tBean.slid" />" />
	
	<table width="650" border="0" cellspacing="3" cellpadding="0">
		 <tr>
			<td>
			<fieldset>
			<legend>【房产信息】</legend>
				<table width="100%" border="0" cellspacing="2" cellpadding="0">
					<tr>
						<td valign="top" width="350">
	    					<table width="100%" border="0" cellspacing="3" cellpadding="0">
	    					
                        <tr>	                        
                        	<td width="350">
			    				<label class="labelA"><s:property value="%{getText('app.xtwh.info.fwlx')}" /></label>
								<span class="txtInfonm txtfocus"><input name="txtFWLXTIP" id="txtFWLXTIP" type="text" value="<s:property value="tBean.fwlxsc" />" readonly="readonly" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> /><span<s:if test='%{ACT!="D"}'> id="spFWLX"</s:if>></span></span><input type="hidden" id="txtFWLX" name="txtFWLX" value="<s:property value="tBean.cd00001Fwlx" />"/>
					        </td>
					    </tr>
					    <tr>    
					        <td>			    				
				    			<label class="labelA"><s:property value="%{getText('app.xtwh.info.jzjg')}" /></label>
							  	<span class="txtInfonm txtfocus"><input name="txtJZJGTTIP" id="txtJZJGTTIP" type="text" value="<s:property value="tBean.jzjg" />" readonly="readonly" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> /><span<s:if test='%{ACT!="D"}'> id="spJZJG"</s:if>></span></span><input type="hidden" id="txtJZJGT" name="txtJZJGT" value="<s:property value="tBean.cd00001Jzjg" />"/>
						  	</td>
					   </tr>
					   <tr>
						  	<td>
				    			<label class="labelA"><s:property value="%{getText('建成年份')}" /></label>
							  	<input name="txtJCNF" id="txtJCNF" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> type="text" <s:if test='%{ACT != "C"}'>value="<s:property value="tBean.jcnf"/>"</s:if> onfocus="WdatePicker({dateFmt:'yyyy'})" class="Wdatefocus" />
						  	</td>
						</tr>
							</table>
	           			</td>
						<td valign="top">
				    		<table width="100%" border="0" cellspacing="2" cellpadding="0">
					           <tr>
								    <td><label class="labelA"><s:property value="getText('app.xtwh.info.szqy')"/></label>
								    <s:if test='%{ACT == "D"}'>
								    		<sw:szqy items="szqyList" name="ddlSZQY" classid="txtfocus" id="ddlSZQY" checked="v00303Bean.cd00001Szqy" disabled="disabled"  />
								    </s:if>
								    <s:else>
								    		<sw:szqy items="szqyList" name="ddlSZQY" classid="txtfocus" id="ddlSZQY" checked="v00303Bean.cd00001Szqy"  /> 
								    </s:else>
										
								         </td>
							   </tr>       
								<tr>
									<td><label class="labelA">
											<s:property value="%{getText('app.xtwh.t00303.xqcx')}" />
										</label>
								 			<input name="txtXQCX"  id="txtXQCX" type="text" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>/>
									</td>
								</tr>
									<tr>
										<td><label class="labelA">
													 <s:property value="%{getText('app.xtwh.t00303.xqmc')}" />
										</label>
										  <span class="txtInfonm txtfocus"><input name="txtXQTIP" id="txtXQTIP"  value="<s:property value="v00303Bean.xqnm"/>" type="text" readonly="readonly" <s:if test='%{ACT == "D"}'>disabled="disabled"</s:if> /><span<s:if test='%{ACT!="D"}'> id="spXQDM"</s:if>></span></span><input type="hidden" id="txtXQDM" name="txtXQDM" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> value="<s:property value="v00303Bean.cd00352Xqdm" />"/>
										<span onclick="ShowXQXX()" ><img src="../images/ico/light.gif" title="图片查询" alt="图片查询" width="16" height="16" align="absmiddle"></span>
											</td>
								</tr>
								<!-- 采集页面用  -->	
								<tr>
								       <td>
									       <div id="xqcxDIV" style="display:none;">
									        <label class="labelA">
												<s:property value="%{getText('app.xtwh.t00352.xjxqmc')}" />
											</label>
											<input name="txtXJXQMC" class="txtfocus" id="txtXJXQMC" type="text" disabled="disabled"/>
											<input name="hidPARENTDM"  id="hidPARENTDM" type="hidden" />
											<input name="hidXQZT"  id="hidXQZT" type="hidden" />
										    </div>
								      </td>
								</tr>
<!--	<tr>-->
<!--		<td><label class="labelA">-->
<!--				<s:property value="%{getText('app.xtwh.t00303.zlc')}" />-->
<!--			</label>-->
<!--			    <s:if test='%{ACT=="A"}'>-->
<!--			    <s:property value="v00303Bean.zlc" default="1"/>-->
<!--			    </s:if>  				-->
<!-- 				<s:else>-->
<!--			    <input name="txtZLC" class="txtfocus txtNumber" id="txtZLC" type="text" value="<s:property value="v00303Bean.zlc" default="1"/>"  <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>/>-->
<!--			    </s:else>-->
<!--		</td>-->
<!--	</tr>	-->
					        </table>
				        </td>
	   				</tr>
				</table>
     		</fieldset>
<!--	      	<fieldset>-->
<!--				<legend>【房产信息】</legend>-->
<!--					<table width="100%" border="0" cellspacing="3" cellpadding="0">-->
<!--						-->
<!--						 <tr>-->
<!--								-->
<!--					  	</tr>-->
<!--						<tr>-->
<!--							<td>-->
<!--				    			<label class="labelA"><s:property value="%{getText('app.xtwh.info.jylx')}" /></label>-->
<!--							  	<span class="txtInfonm txtfocus"><input name="txtJYLXTIP" id="txtJYLXTIP" type="text" value="<s:property value="tBean.jylxsc" />" readonly="readonly" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> /><span<s:if test='%{ACT!="D"}'> id="spJYLX"</s:if>></span></span><input type="hidden" id="txtJYLX" name="txtJYLX" value="<s:property value="tBean.cd00001Jylx" />"/>-->
<!--						  	</td>-->
<!--						  	<td>-->
<!--						  	</td>-->
<!--					  	</tr>						-->
<!--                        -->
<!--	        		</table>-->
<!--				</fieldset>-->
		 	</td>
		</tr>
		<tr>
			<td>
<!--				<table width="100%" border="0" cellspacing="2" cellpadding="0">-->
<!--					<tr>-->
<!--						<td>-->
<!--      						<fieldset><legend>【综合修正】<input type="hidden" id="hidZHXZ" name="hidZHXZ" value="" /></legend>-->
<!--					            <table width="100%" border="0" cellspacing="0" cellpadding="0">-->
<!--					             <tr>-->
<!--					                <td>-->
<!--					                  <div id="ddlQTXZ" class="divZhxz">-->
<!--						                <ul id="tt1">                    -->
<!--											-->
<!--										</ul>-->
<!--						              </div>								              -->
<!--									  <input type="hidden" id="hidZHXZid" name="hidZHXZid" value="" />-->
<!--					                </td>-->
<!--					            </tr>-->
<!--					            </table>-->
<!--				        	</fieldset>-->
<!--			        	</td>-->
<!--			        	-->
<!--	  				</tr>-->
<!--				</table>-->
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
<div>
	<s:if test='%{ACT=="U"}'>
	  <a href="javascript:AppSubmit();" id="editLink"><img src="../images/ico/Edit.gif" width="16" height="16" title="<s:property value="getText('app.button.save')"/>" alt="<s:property value="getText('app.button.upd')"/>" /><s:property value="getText('app.button.upd')"/></a>
	</s:if>
	<s:elseif test='%{ACT=="D"}'>
	  <a href="javascript:AppSubmit();"><img src="../images/ico/Delete.gif" width="16" height="16" title="<s:property value="getText('app.button.save')"/>" alt="<s:property value="getText('app.button.del')"/>" /><s:property value="getText('app.button.del')"/></a>
	</s:elseif>
	</div>	
	<div id="dialog" class="easyui-window" title="请选择类型..." icon="icon-ok" style="width:350px;height:350px;padding:5px;background: #fafafa;">
		<div id="infoTreeDIV"></div>
	</div>
    </div>
    <div class="ui-widget-content">
	<div class="datagrid-title">
		<span class="datagrid-title-text"><s:property
				value="%{getText('app.xtwh.t00351.title')}" />--交易价格</span>
	</div>
    <div id="JYJG">
	    <iframe id="frmJYJG" name="frmJYJG" frameborder="0" height="350" width="100%" src="../xtwh/VIEWT00351B.action?SLID=<s:property value="tBean.slid" />&ACT=<s:property value="ACT" />"></iframe>
	</div>
	</div>
	<div class="divbottom">
		<a href="VIEWT00351.action"><img src="../images/ico/Cancel.gif" width="16" height="16" title="<s:property value="getText('app.button.back')"/>" alt="<s:property value="getText('app.button.back')"/>" /><s:property value="getText('app.button.back')"/></a>
    </div>    
   
   </td>
  </tr>
</table>

</body>
</html>