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
<script type="text/javascript" src="../scripts/jquery.maskedinput.js"></script>
<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../scripts/jquery.maskedinput.js"></script>
<script type="text/javascript" src="../scripts/T00320/EDITT00320.js"></script>
<script type="text/javascript" src="../scripts/T00352/T00352TREEDIV.js"></script>
<script type="text/javascript" src="../scripts/T00053/T00053TREEDIV.js"></script>
<script type="text/javascript" src="../scripts/T00001/INFOTREEDIV.js"></script>
<script type="text/javascript" src="../scripts/T00303/T00303DIV.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>
<link type="text/css" rel="stylesheet" href="../css/screen.css" />
<link type="text/css" rel="stylesheet" href="../css/jquery.autocomplete.css" />
<script type="text/javascript">
	$(function() {
		$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
		$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });
		
		var szqy =$("#ddlSZQY").val();
		setParentIds(szqy);
	});
</script>
<style type="text/css">
<!--
.labelA {
	width:120px;
}
.labelB {
	width:123px;
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
		<s:if test='%{TSIGN == "320"}'>
			<span class="datagrid-title-text">全面评估市场法房产信息变更</span>
		</s:if>
		<s:elseif test='%{TSIGN == "3201"}'>
			<span class="datagrid-title-text">全面评估重复地址房产信息变更</span>
    	</s:elseif>
	</div>
  <form id="editForm" action="EDITT00320.action" method="post">
	<input type="hidden" name="ACT" id="ACT" value="<s:property value="ACT"/>" />
	<input type="hidden" name="txtUPDATE" id="txtUPDATE" value="<s:text name="app.global.format.datetime"><s:param value="tBean.upddate"/></s:text>" />
	<input type="hidden" name="hidSelect" id="hidSelect"  <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>/>
	<input type="hidden" name="hidXZLX" id="hidXZLX" value="<s:property value="XZLX"/>" />
	<!-- 标识CLH失焦方法与采集做区别  -->
	<input type="hidden" name="TABLENAME" id="TABLENAME" value="PGT00320" />
	<!-- 标识全面评估查询与重复地址查询区别 -->
	<input type="hidden" name="TSIGN" id="TSIGN" value='<s:property value="TSIGN" />' />
	<input name="FCID" type="hidden" id="FCID" value="<s:property value="tBean.fcid" />" />
	<table width="700" border="0" cellspacing="5" cellpadding="0">
	  <tr>
	    <td valign="top">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
		      		<td>
		        		<label class="labelA"><s:property value="getText('app.sjcj.t00302.fcid')"/></label><s:property value="tBean.fcid"/>
		      		</td>
				</tr>	
			</table>
		</td>
   	</tr>
	<tr>
		<td valign="top">
		  <fieldset>
			<legend>【基本信息】</legend>
			<table width="100%" border="0" cellspacing="2" cellpadding="0">	
			<tr>
				<td>
					<table>
						<tr>
                        	<td><label class="labelA"><s:property value="getText('app.sjcj.t00302.fczh')"/></label>
                        	<input name="txtFCZH"  id="txtFCZH" type="text" value="<s:property value="tBean.fczh"/>" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>/>
                        	</td>
                       	</tr>
                       	<tr>
    						<td><label class="labelA">			
								<s:property value="getText('app.sjcj.t00301.nsrmc')"/>
								</label>
								<input type="text"  id="txtNSRMC" name="txtNSRMC" value="<s:property value="tBean.nsrmc"/>" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />
							</td>
						</tr>	
						<tr>
			    			<td><label class="labelA">
									<s:property value="getText('app.sjcj.t00301.lxdh')"/>
								</label>
								<input type="text" id="txtLXDH" name="txtLXDH" value="<s:property value="tBean.lxdh"/>" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>/>
							</td>
						</tr>
					</table>					
				</td>
				<td valign="top">
					<table width="100%" border="0" cellspacing="2" cellpadding="0">
						<tr>
			    			<td><label class="labelA">
									<s:property value="getText('app.xtwh.info.zjlx')"/>
								</label>
								<span class="txtInfonm txtfocus"><input type="text" id="txtZJLXTIP" name="txtZJLXTIP" value="<s:property value="tBean.zjlx"/>" readonly="readonly" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> /><span<s:if test='%{ACT!="D"}'> id="spZJLX"</s:if>></span></span><input type="hidden" id="txtZJLX" name="txtZJLX" value="<s:property value="tBean.cd00001Zjlx"/>" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>/>					
							</td>
						</tr>
			      		<tr>
				    		<td><label class="labelA">	
									<s:property value="getText('app.sjcj.t00301.swid')"/>
								</label>
								<input type="text"  id="txtZJHM" name="txtZJHM" value="<s:property value="tBean.zjhm"/>" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />
							</td>
						</tr>
					</table>
				</td>
			</tr>
 		    </table>
	      </fieldset>
	      <fieldset>
	        <legend>【楼房信息(幢)】</legend>
	        <table width="100%" border="0" cellspacing="2" cellpadding="0">
	      		<tr>
	      			<td valign="top" width="350" >
			    		<table width="100%" border="0" cellspacing="2" cellpadding="0">
				    		<tr>
								<td><label class="labelA">
										<s:property value="%{getText('app.xtwh.t00303.clh')}" />
									</label>
						  				<input name="txtCLH" class="txtfocus" id="txtCLH" type="text" value="<s:property value="tBean.clh" />" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>/>
								</td>
							</tr>
				      		<tr>
					    		<td><label class="labelA">
										<s:property	value="%{getText('app.xtwh.t00303.zcdzl')}" />
									</label>
								  <input name="txtZCDZL" style="width:200px" class="txtfocus" id="txtZCDZL" type="text" value="<s:property value="tBean.zcdzl" />" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> /></td>
							</tr>
							<tr>
						         <td><label class="labelA">
						             <s:property value="getText('app.sjcj.t00302.lh')"/></label>
									  <input name="txtZH" id="txtZH" type="text"  value="<s:property value="tBean.zh"/>" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>/>
						         </td>
					             </tr>
					             <tr>
						             <td><label class="labelA">
						                 <s:property value="getText('app.sjcj.t00302.dyh')"/></label>
									  	<input name="txtDYH" id="txtDYH" type="text"  value="<s:property value="tBean.dyh"/>" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>/>
						             </td>
					             </tr>
							<tr>
		                    	<td><label class="labelA">
		                        		<s:property value="getText('app.sjcj.t00302.bwjfh')"/></label>
					  				<input name="txtFH" id="txtFH" type="text" class="txtfocus" value="<s:property value="tBean.fh"/>" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />
		                    	</td>
	                    	</tr>
	                    	
	                    	<tr>
		                        <td><label class="labelA">
		                                <s:property	value="%{getText('app.xtwh.info.jzjg')}" />
		                            </label>
		                              <span class="txtInfonm txtfocus"><input name="txtJZJGTIP" id="txtJZJGTIP" type="text" value="<s:property value="tBean.jzjg" />" readonly="readonly"  <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> /><span<s:if test='%{ACT!="D"}'> id="spJZJG"</s:if>></span></span><input type="hidden" id="txtJZJG" name="txtJZJG" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> value="<s:property value="tBean.cd00001Jzjg" />"/>
		                         </td>
	                         </tr>    	                         
						</table>
                   	</td>
                   	<td valign="top" width="350">
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
								      <s:if test='%{ACT != "D"}'><span onclick="ShowXQXX()" ><img src="../images/ico/light.gif" title="图片查询" alt="图片查询" width="16" height="16" align="absmiddle"></span></s:if>
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
							<tr>
								<td><label class="labelA">
										<s:property value="%{getText('app.xtwh.t00303.zlc')}" />
									</label>
									    <s:if test='%{ACT=="A"}'>
									    <s:property value="v00303Bean.zlc" default="1"/>
									    </s:if>  				
						 				<s:else>
									    <input name="txtZLC" class="txtfocus txtNumber" id="txtZLC" type="text" value="<s:property value="v00303Bean.zlc" default="1"/>"  <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>/>
									    </s:else>
								</td>
							</tr>	
							<tr>
		                    	<td><label class="labelA">
		                                <s:property value="getText('app.sjcj.t00302.szlc')"/>
		                            </label>
		                            <input name="txtSZLC" class="txtfocus txtNumber" id="txtSZLC" type="text" value="<s:property value="tBean.szlc" default="0"/>"  <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>/>
		                        </td>
	                    	</tr>
	                    	<tr>
		                        <td><label class="labelA">
		                                <s:property	value="%{getText('app.xtwh.info.jzjg')}" />
		                            </label>
		                              <span class="txtInfonm txtfocus"><input name="txtJZJGTTIP" id="txtJZJGTTIP" type="text" value="<s:property value="tBean.jzjg" />" readonly="readonly"  <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> /><span<s:if test='%{ACT!="D"}'> id="spJZJG"</s:if>></span></span><input type="hidden" id="txtJZJGT" name="txtJZJGT" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> value="<s:property value="tBean.cd00001Jzjg" />"/>
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
	    				<table width="350" border="0" cellspacing="2" cellpadding="0">							
                        	<tr>
		                        <td><label class="labelA">
		                                <s:property	value="%{getText('app.xtwh.info.ghyt')}" />
		                            </label>
		                              <span class="txtInfonm txtfocus"><input name="txtGHYTTIP" id="txtGHYTTIP" type="text" value="<s:property value="tBean.ghyt" />"  onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" <s:if test='%{ACT == "D"}'>disabled="disabled"</s:if>/><span<s:if test='%{ACT!="D"}'> id="spGHYT"</s:if>></span></span><input type="hidden" id="txtGHYT" name="txtGHYT" value="<s:property value="tBean.cd00001Ghyt" />"/>
		                         </td>
	                         </tr>
	                         <tr>
		                        <td><label class="labelA">
		                                <s:property	value="%{getText('app.xtwh.info.fwlx')}" />
		                            </label>
		                              <span class="txtInfonm txtfocus"><input name="txtFWLXTIP" id="txtFWLXTIP" type="text" value="<s:property value="tBean.fwlx" />" readonly="readonly" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> /><span<s:if test='%{ACT!="D"}'> id="spFWLX"</s:if>></span></span><input type="hidden" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> id="txtFWLX" name="txtFWLX" value="<s:property value="tBean.cd00001Fwlx" />"/>
		                        </td>
	                    	</tr>
                        	<tr>
		                        <td><label class="labelA">
		                                <s:property value="getText('app.sjcj.t00302.jzmj')"/>
		                            </label>
		                            <input name="txtJZMJ" class="txtfocus txtNumber" id="txtJZMJ" type="text" value="<s:property value="tBean.jzmj" default="0"/>"  <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>/>
		                        </td>
	                        </tr>
                    	</table>
                   	</td>
                   	<td valign="top">
	    				<table width="350" border="0" cellspacing="2" cellpadding="0">	                    	  
	                         <tr>
		                        <td><label class="labelA">
		                                <s:property	value="%{getText('app.xtwh.info.jylx')}" />
		                            </label>
		                              <span class="txtInfonm txtfocus"><input name="txtJYLXTIP" id="txtJYLXTIP" type="text" value="<s:property value="tBean.jylx" />" readonly="readonly" <s:if test='%{ACT == "D"}'>disabled="disabled"</s:if> /><span<s:if test='%{ACT!="D"}'> id="spJYLX"</s:if>></span></span><input type="hidden" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> id="txtJYLX" name="txtJYLX" value="<s:property value="tBean.cd00001jylx" />"/>
		                          </td>
	                    	</tr>	
	                    	<tr>
						        <td><label class="labelA">
						             <s:property	value="%{getText('app.sjcj.t12003.jcnf')}" />
						            </label>
						            <input name="txtJCNF" id="txtJCNF" type="text" value="<s:property value="tBean.jcnf" />" maxlength="4"  onkeyup="value=this.value.replace(/\D+/g,'')" <s:if test='%{ACT == "D"}'>disabled="disabled"</s:if>/>
						        </td>
					       </tr>	
					       <tr>
		                        <td><label class="labelA">
		                                <s:property value="getText('app.sjcj.t00302.jyjg')"/>
		                            </label>
		                            <input name="txtHDJG" class="txtfocus txtNumber" id="txtHDJG" type="text" value="<s:property value="tBean.hdjg" default="0"/>"  <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>/>
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
		<tr>
			<td>
    		<fieldset><legend>【综合修正】<input type="hidden" id="hidZHXZ" name="hidZHXZ" value="" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> /></legend>
	        <table width="100%" border="0" cellspacing="0" cellpadding="0">
	          <tr>
	            <td>
                  <div id="ddlQTXZ" class="divZhxz" <s:if test='%{ACT == "D"}'>disabled="disabled"</s:if>>
	                <ul id="tt1">                    
						
					</ul>
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
						              <textarea name="txtNOTE" id="txtNOTE" cols="120" rows="6" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> ><s:property value="tBean.note" /></textarea>
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
    <s:if test='%{ACT=="U"}'>
      <a href="javascript:AppSubmit();"><img src="../images/ico/Edit.gif" width="16" height="16" title="<s:property value="getText('app.button.upd')"/>" alt="<s:property value="getText('app.button.upd')"/>" /><s:property value="getText('app.button.upd')"/></a>
    </s:if>
    <s:elseif test='%{ACT=="D"}'>
      <a href="javascript:AppSubmit();"><img src="../images/ico/Delete.gif" width="16" height="16" title="<s:property value="getText('app.button.del')"/>" alt="<s:property value="getText('app.button.del')"/>" /><s:property value="getText('app.button.del')"/></a>
    </s:elseif>
    <s:if test='%{ACT!="C"}'>
      <s:set name="BG">M</s:set>
    </s:if>
    <s:if test='%{TSIGN == "320"}'>
    	<a href="../sjcj/VIEWT00320.action?"><img src="../images/ico/Cancel.gif" width="16" height="16" title="<s:property value="getText('app.button.back')"/>" alt="<s:property value="getText('app.button.back')"/>" /><s:property value="getText('app.button.back')"/></a>
    </s:if>
    <s:elseif test='%{TSIGN == "3201"}'>
    	<a href="../sjcj/VIEWT00320DZ.action?"><img src="../images/ico/Cancel.gif" width="16" height="16" title="<s:property value="getText('app.button.back')"/>" alt="<s:property value="getText('app.button.back')"/>" /><s:property value="getText('app.button.back')"/></a>
    </s:elseif>
  </div>
  </div>  
	<div id="dialog" class="easyui-window" title="请选择类型..." icon="icon-ok" style="width:350px;height:350px;padding:5px;background: #fafafa;">
		<div id="infoTreeDIV"></div>
	</div>
</td>
</tr>
</table>
<script type="text/javascript" language="javascript">
 if($("#ACT").val() == "C"){
	 bindLFXXValue("<s:property value='tBean.zcdzl'/>", "#T00303DIV");
 }
 
</script>
</body>
</html>