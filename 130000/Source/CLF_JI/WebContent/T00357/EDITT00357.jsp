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
<script type="text/javascript" src="../scripts/T00357/EDITT00357.js"></script>
<script type="text/javascript" src="../scripts/T00352/T00352TREEDIV.js"></script>
<script type="text/javascript" src="../scripts/T00053/T00053TREEDIV.js"></script>
<script type="text/javascript" src="../scripts/T00001/INFOTREEDIV.js"></script>
<script type="text/javascript" src="../scripts/jquery.autocomplete.js"></script>
<link type="text/css" rel="stylesheet" href="../css/jquery.autocomplete.css" />
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../scripts/T00303/T00303DIV.js"></script>

<script type="text/javascript" src="../scripts/formatDate.js"></script>
<script type="text/javascript" src="../scripts/jquery.maskedinput.js"></script>

<script type="text/javascript">
	$(function() {
		$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
		$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });
		<s:if test='%{ACT!="C"}'>	
		if ($('#ddlSZQY').val()!='')
		{
			$("#ddlSZQY").change();
		}
	     //bindLFXXValue("<s:property value='v00303Bean.zcdzl'/>","<s:property value="v00303Bean.clh" />","#T00303DIV","<s:property value='ACT'/>");
		</s:if>
	});
</script>
<style type="text/css">
<!--
.labelA {
	width:120px;
}
-->
.labelL {
	width:100px;
}
.labelC {
	width:50px;
}
.labelD {
	width:40px;
}
.labelM {
	width:100px;
}
</style>

</head>
<body>
<table border="0" align="left" cellpadding="0" cellspacing="0" class="table1">
  <tr>
    <td align="left" valign="top">
	
		<div class="ui-widget-content">
		<div class="datagrid-title">
			<span class="datagrid-title-text"><s:property value="%{getText('app.xtwh.t00357.title')}" /></span>                   
		</div>
	<div style="min-height:400px">
<form id="editForm" action="EDITT00357.action" method="post">
	<input type="hidden" name="ACT" id="ACT" value="<s:property value="ACT"/>" />
	<input type="hidden" name="txtUPDATE" id="txtUPDATE" value="<s:text name="app.global.format.datetime"><s:param value="tBean.upddate"/></s:text>" />
	<input type="hidden" name="hidSelect" id="hidSelect" />	
	<input type="hidden" name="hidXZLX" id="hidXZLX" value="<s:property value="XZLX"/>" />
	<s:if test='%{ACT!="C"}'>
		<input name="SLID" type="hidden" id="SLID" value="<s:property value="tBean.slid" />" />
	</s:if>
		<table width="700" border="0" cellspacing="3" cellpadding="0">
	  		<tr>
				<td>
					<fieldset>
		                <legend>【楼房信息】</legend>
		                    <table width="700" border="0" cellspacing="2" cellpadding="0">
					      		<tr>
						    		<td>
							    		<table width="700" border="0" cellspacing="2" cellpadding="0">
								    		<tr>
												<td>
													<span class="labelL"><s:property value="getText('app.xtwh.info.szqy')"/></span>
										           	<s:if test='%{ACT == "D"}'>
										           		<sw:szqy items="szqyList" name="ddlSZQY" classid="txtfocus" id="ddlSZQY" checked="v00303Bean.cd00001Szqy" disabled="disabled"  />
										           	</s:if>
										           	<s:else>
										           		<sw:szqy items="szqyList" name="ddlSZQY" classid="txtfocus" id="ddlSZQY" checked="v00303Bean.cd00001Szqy"  /> 
										           	</s:else>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													<span class="labelC">
														<s:property value="%{getText('app.xtwh.t00303.clh')}" />
													</span>
										  				<input name="txtCLH" class="txtfocus" id="txtCLH" type="text" value="<s:property value="v00303Bean.clh" />" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>/>		
											    </td>
											</tr>
										    <tr>
										   		<td><span class="labelL">
														<s:property	value="%{getText('app.xtwh.t00303.zcdzl')}" />
													</span>
														<input name="txtZCDZL" class="txtfocus" id="txtZCDZL" type="text" value="<s:property value="v00303Bean.zcdzl" />" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />	
													<span class="labelC">
														<s:property value="getText('app.xtwh.t00357.lh')"/>
													</span>
													<input name="txtLH" id="txtLH" type="text"  style="width:70px;" value="<s:property value="tBean.lh" />" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />
												
													<span>
														<s:property value="getText('app.xtwh.t00357.dyh')"/>
													</span>
													<input name="txtDYH" id="txtDYH" type="text" style="width:40px;"  value="<s:property value="tBean.dyh" />" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />
													
													<span>
														<s:property value="getText('app.sjcj.t00302.bwjfh')"/>
													</span>
													<input name="txtBWJFH" id="txtBWJFH" type="text"  style="width:70px;"  class="txtfocus"  value="<s:property value="tBean.bwjfh" />"  onkeyup="defineBWJFH(this)" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />
												</td>	
											</tr>
				                    	<tr>
			                    	
			                    	<td>
							    		<table width="700" border="0" cellspacing="0" cellpadding="0">
						      				            
													<tr>
														<td><span class="labelL">
																<s:property value="%{getText('app.xtwh.t00303.xqcx')}" />
															</span>
												  				<input name="txtXQCX"  id="txtXQCX" type="text" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>/>
															<span class="labelC">
																 <s:property value="%{getText('app.xtwh.t00303.xqmc')}" />
													 		</span>
													    	<span class="txtInfonm txtfocus"><input name="txtXQTIP" id="txtXQTIP"  value="<s:property value="v00303Bean.xqnm"/>" type="text" readonly="readonly" <s:if test='%{ACT == "D"}'>disabled="disabled"</s:if> /><span<s:if test='%{ACT!="D"}'> id="spXQDM"</s:if>></span></span><input type="hidden" id="txtXQDM" name="txtXQDM" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> value="<s:property value="v00303Bean.cd00352Xqdm" />"/>
													      		<s:if test='%{ACT != "D"}'><span onclick="ShowXQXX()" ><img src="../images/ico/light.gif" title="图片查询" alt="图片查询" width="16" height="16" align="absmiddle"></span></s:if>
													    	<span class="labelC">
																<s:property value="%{getText('app.xtwh.t00303.zlc')}" />
															</span>
														    <s:if test='%{ACT=="A"}'>
														    <s:property value="v00303Bean.zlc" default="1"/>
														    </s:if>  				
											 				<s:else>
														    <input name="txtZLC" class="txtfocus txtNumber" style="width:40px;" id="txtZLC" type="text" value="<s:property value="v00303Bean.zlc" default="1"/>"  <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>/>
														    </s:else>
														    <span class="labelC">
								                                <s:property value="getText('app.sjcj.t00302.szlc')"/>
								                            </span>
								                            <input name="txtSZLC" class="txtfocus txtNumber" style="width:40px;" id="txtSZLC" type="text" value="<s:property value="tBean.szlc" default="0"/>"  <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>/>
								                        </td>
													</tr>
													
													</table>
													</td>
											  	
													
												</tr>
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
													
													
							                    	<tr>
								                        <td><span class="labelL">
								                                <s:property	value="%{getText('app.xtwh.info.jzjg')}" />
								                            </span>
								                              <span class="txtInfonm txtfocus"><input name="txtJZJGTTIP" id="txtJZJGTTIP" type="text" value="<s:property value="tBean.jzjg" />" readonly="readonly"  <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> /><span<s:if test='%{ACT!="D"}'> id="spJZJG"</s:if>></span></span><input type="hidden" id="txtJZJGT" name="txtJZJGT" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> value="<s:property value="tBean.cd00001Jzjg" />"/>
								                         <span class="labelC">
						                                       <s:property	value="%{getText('app.sjcj.t12003.jcnf')}" />
						                                      </span>
						                                   <input name="txtJCSJ" id="txtJCSJ" type="text" style="width:70px;" value="<s:property value="tBean.jcsj" />" maxlength="4"  onkeyup="value=this.value.replace(/\D+/g,'')"  <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> onfocus="WdatePicker({dateFmt:'yyyy'})" class="Wdate" />
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
											  	<td><label class="labelL">
														<s:property value="getText('app.xtwh.t00357.jzmj')"/>
													</label>
										  			<input name="txtJZMJ" class="txtfocus txtNumber" id="txtJZMJ" type="text" value="<s:property value="tBean.jzmj" default="0" />" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />
									  				<s:property value="%{getText('app.xtwh.info.fwlx')}" />
												  	<span class="txtInfonm txtfocus"><input name="txtFWLXTIP" id="txtFWLXTIP" type="text" value="<s:property value="tBean.fwlxsc" />" readonly="readonly"  <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> /><span<s:if test='%{ACT!="D"}'> id="spFWLX"</s:if>></span></span><input type="hidden" id="txtFWLX" name="txtFWLX" value="<s:property value="tBean.cd00001Fwlx" />" />
													<s:property value="%{getText('app.xtwh.info.jylx')}" />
												  	<span class="txtInfonm txtfocus"><input name="txtJYLXTIP" id="txtJYLXTIP" type="text" value="<s:property value="tBean.jylxsc" />" readonly="readonly"  <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> /><span<s:if test='%{ACT!="D"}'> id="spJYLX"</s:if>></span></span><input type="hidden" id="txtJYLX" name="txtJYLX" value="<s:property value="tBean.cd00001Jylx" />"/>
											  	</td>
											</tr>
											<tr>
									    		<td><label class="labelL">
														<s:property value="getText('app.xtwh.t00357.pgjg_dj')"/>
													</label>
										  			<input name="txtPGJG" class="txtfocus txtNumber" id="txtPGJG" type="text" value="<s:property value="tBean.pgjg" default="0" />" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />
									  				<s:property value="getText('app.xtwh.t00357.jysj')"/>
										 			 <input name="txtJYSJ" id="txtJYSJ" type="text" value="<s:if test="null!=tBean.jysj"><s:text name="app.global.format.date"><s:param value="tBean.jysj" /></s:text></s:if>" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdatefocus"  <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />
									 			 </td>
								 			 </tr>
		                           		</table>
	                           		</td>
	                           		<td valign="top">
					    				<table width="100%" border="0" cellspacing="2" cellpadding="0">

<!--					    				 <tr>-->
<!--									            <td>-->
<!--									    			<label class="labelA"><s:property value="%{getText('app.xtwh.info.jzjg')}" /></label>-->
<!--												  	<span class="txtInfonm txtfocus"><input name="txtJZJGTTIP" id="txtJZJGTTIP" type="text" value="<s:property value="tBean.jzjg" />" readonly="readonly"  <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> /><span<s:if test='%{ACT!="D"}'> id="spJZJG"</s:if>></span></span><input type="hidden" id="txtJZJGT" name="txtJZJGT" value="<s:property value="tBean.cd00001Jzjg" />"/>-->
<!--											  	</td>-->
<!--										  	</tr>-->
										  
											
					    			
<!--										  	<tr>-->
<!--									    		<td>-->
<!--									    			<label class="labelA"><s:property value="%{getText('app.xtwh.info.fwlx')}" /></label>-->
<!--												  	<span class="txtInfonm txtfocus"><input name="txtFWLXTIP" id="txtFWLXTIP" type="text" value="<s:property value="tBean.fwlxsc" />" readonly="readonly"  <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> /><span<s:if test='%{ACT!="D"}'> id="spFWLX"</s:if>></span></span><input type="hidden" id="txtFWLX" name="txtFWLX" value="<s:property value="tBean.cd00001Fwlx" />" />-->
<!--												</td>-->
<!--											</tr>-->

											
				 						</table>
				 					</td>
                           		</tr>
                       		</table>
				 		</fieldset>
						<fieldset>
			                <legend>【基本信息】</legend>
			                    <table width="100%" border="0" cellspacing="2" cellpadding="0">
			                    	<tr>
							    		<td><label class="labelL">
												<s:property value="getText('app.sjcj.t00301.nsrmc')"/>
											</label>
												 <input name="txtNSRMC" id="txtNSRMC" type="text" value="<s:property value="tBean.nsrmc" />" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>/>
										
												<s:property value="getText('app.sjcj.t00301.swid')"/>
												 <input name="txtSWID" id="txtSWID" type="text" value="<s:property value="tBean.cd00301Swid" />" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />
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
		      						<fieldset><legend>【综合修正】<input type="hidden" id="hidZHXZ" name="hidZHXZ" value="" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> /></legend>
								        <table width="100%" border="0" cellspacing="0" cellpadding="0">
								          <tr>
								            <td>
							                  <div id="ddlQTXZ" class="divZhxz" <s:if test='%{ACT == "D"}'>disabled="disabled"</s:if>>
								                <div id="tt1">                    
													
												</div>
								              </div>								              
											  <input type="hidden" id="hidZHXZid" name="hidZHXZid" value="" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />
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
									              <textarea name="txtNOTET00357" id="txtNOTET00357" cols="120" rows="6" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> ><s:property value="tBean.note" /></textarea>
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
</div>
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
	<a href="VIEWT00357.action"><img src="../images/ico/Cancel.gif" width="16" height="16" title="<s:property value="getText('app.button.back')"/>" alt="<s:property value="getText('app.button.back')"/>" /><s:property value="getText('app.button.back')"/></a>
</div>
	<div id="dialog" class="easyui-window" title="请选择类型..." icon="icon-ok" style="width:350px;height:350px;padding:5px;background: #fafafa;">
		<div id="infoTreeDIV"></div>
	</div>
	<div id="pic" style="width:900px;height:650px;padding:5px;background:#fafafa;" >
        	<iframe id="ipic" src="" width="100%" height="100%"></iframe>
    </div>

</div>
</div>
</div>
    </td>
  </tr>
</table>
</body>
</html>
