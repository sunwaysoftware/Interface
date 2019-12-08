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
<script type="text/javascript" src="../scripts/WS00001/EDITTWS00001.js"></script>
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

		bindLFXXValue("","<s:property value="t00352Bean.CLH" />", "#T00303DIV","<s:property value="ACT"/>");
		var szqy =$("#ddlSZQY").val();
		setParentIds(szqy);	
	});
</script>
<style type="text/css">
<!--
.labelA {
	width:120px;
}
.labelB{
	color:blue;	
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
				value="%{getText('app.xtwh.t00351.title')}" />房产变更信息</span>
	</div>
  <form id="editForm" action="#" method="post">
	<input type="hidden" name="ACT" value="<s:property value="ACT"/>" />
	<input type="hidden" name="txtUPDATE" id="txtUPDATE" value="<s:text name="app.global.format.datetime"><s:param value="t00352Bean.upddate"/></s:text>" />
	<input type="hidden" name="hidSelect" id="hidSelect" />
	<input type="hidden" name="txtZCDZL" id="txtZCDZL" value="<s:property value="t00352Bean.zcdzl"/>" />
	<input type="hidden" name="hidXZLX" id="hidXZLX" value="<s:property value="XZLX"/>" />
	<input type="hidden" name="txtNSRMC" id="txtNSRMC" value="<s:property value="t00352Bean.nsrmc"/>" />
	<input type="hidden" name="txtSWID" id="txtSWID" value="<s:property value="t00352Bean.cd00301Swid"/>"/>
	<input name="FCID" type="hidden" id="FCID" value="<s:property value="t00352Bean.fcid" />" />
	<input type="hidden" id="txtFWLX" name="txtFWLX" value="<s:property value='txtFWLXSL' />" />
	<input type="hidden" id="txtDF" name="txtDF" value="<s:property value='t00352Bean.DF' />" />
	<input type="hidden" id="txtCX" name="txtCX" value="<s:property value='t00352Bean.CX' />" />
	<input type="hidden" id="txtCG" name="txtCG" value="<s:property value='t00352Bean.CG' />" />
	<input type="hidden" id="txtCLH" name="txtCLH" value="<s:property value='t00352Bean.CLH' />" />
	<table width="700" border="0" cellspacing="5" cellpadding="0">
	
	<tr>
		<td valign="top">
		  <fieldset>
		  	<legend>【基本信息】</legend>
			<table width="100%" border="0" cellspacing="2" cellpadding="0">	
			 	<tr>
			 		<td>
			 			<table>
			 				<tr>
				    			<td><label class="labelA">			
										转让方名称/企业名称:
									</label>
									<label class="labelB">
									&nbsp;<s:property value="t00352Bean.ZRFMC"/>
									</label>
								</td>
							</tr>		
				      		<tr>
					    		<td><label class="labelA">	
										转让方身份证照类型:
									</label>
									<label class="labelB">
									&nbsp;<s:property value="t00352Bean.ZRFSFLX"/>
									</label>
								</td>
							</tr>
							<tr>
				    			<td><label class="labelA">
										转让方身份代码/企业组织机构代码:
									</label>
									<label class="labelB">
									&nbsp;<s:property value="t00352Bean.ZRFSFID"/>
									</label>				
								</td>
							</tr>
			 			</table>
			 		</td>
			 		<td>
			 			<table>
			 				<tr>
				    			<td><label class="labelA">			
										承受方名称/企业名称:
									</label>
									<label class="labelB">
									&nbsp;<s:property value="t00352Bean.CSFMC"/>
									</label>
								</td>
							</tr>		
				      		<tr>
					    		<td><label class="labelA">	
										承受方身份证照类型:
									</label>
									<label class="labelB">
									&nbsp;<s:property value="t00352Bean.CSFSFLX"/>
									</label>
								</td>
							</tr>
							<tr>
				    			<td><label class="labelA">
										承受方身份代码/企业组织机构代码
									</label>
									<label class="labelB">
									&nbsp;<s:property value="t00352Bean.CSFSFID"/>
									</label>				
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
	      			<td valign="top">
			    		<table width="100%" border="0" cellspacing="2" cellpadding="0">
				    		<tr>
								<td><label class="labelA">
										<s:property value="%{getText('app.xtwh.t00303.clh')}" />:
									</label>
									<label class="labelB">
						  				&nbsp;<s:property value="t00352Bean.CLH" />
						  			</label>
								</td>
							</tr>
				      		<tr>
					    		<td><label class="labelA">
										<s:property	value="%{getText('app.xtwh.t00303.zcdzl')}" />:
									</label>
									<label class="labelB">
								  &nbsp;<s:property value="t00352Bean.LFDZ" />
								  </label>
								  </td>
							</tr>
							<tr>
		                    	<td><label class="labelA">
		                        		<s:property value="getText('app.sjcj.t00302.bwjfh')"/>:
		                        	</label>
		                        	<label class="labelB">
					  				&nbsp;<s:property value="t00352Bean.DYFH"/>
					  				</label>
		                    	</td>
	                    	</tr>
	                    	<tr>
		                    	<td><label class="labelA">
		                                <s:property value="getText('app.sjcj.t00302.szlc')"/>:
		                            </label>
		                            <label class="labelB">
		                            &nbsp;<s:property value="t00352Bean.SZLC" default="0"/>
		                            </label>
		                        </td>
	                    	</tr>
	                    	<tr>
		                        <td><label class="labelA">
		                                <s:property	value="%{getText('app.xtwh.info.jzjg')}" />:
		                            </label>
		                            <label class="labelB">
		                            &nbsp;<s:property value="t00352Bean.JZJG" />
		                            </label>
		                         </td>
	                         </tr>
	                         <tr>
	                         	<td>
	                         		<label class="labelA">
	                         			<s:property value="%{getText('app.xtwh.info.ghyt')}" />
	                         		</label>
	                         		<label class="labelB">
	                         		&nbsp;<s:property value="t00352Bean.SJYT" />
	                         		</label>
	                         	</td>
	                         </tr>
						</table>
                   	</td>
                   	<td valign="top">
			    		<table width="100%" border="0" cellspacing="2" cellpadding="0">
		      				<tr>
                               <td>
								<div id="T00303DIV">
								  <%@include file="../T00303/T00303DIV.jsp" %>
								</div>
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
	                        	<td><label class="labelA"><s:property value="getText('app.sjcj.t00302.fczh')"/>:</label>
	                        	<label class="labelB">
	                        	&nbsp;<s:property value="t00352Bean.YFCZH"/>
	                        	</label>
	                        	</td>
                        	</tr>
                        	
                        	<tr>
		                        <td><label class="labelA">
		                                <s:property value="getText('app.sjcj.t00302.jzmj')"/>:
		                            </label>
		                            <label class="labelB">
		                            &nbsp;<s:property value="t00352Bean.JZMJ" default="0"/>
		                            </label>
		                        </td>
	                        </tr>
	                        <tr>
		                        <td><label class="labelA">
		                                <s:property value="getText('app.sjcj.t00302.jyjg')"/>:
		                            </label>
		                            <label class="labelB">
		                            &nbsp;<s:text name="app.global.format.moneyZh"><s:param value="t00352Bean.jyjg" /></s:text>
		                            </label>
		                        </td>
		                    </tr>
		                     <tr>
		                    	<td><label class="labelA">
		                                <s:property value="getText('app.sjcj.t00302.jysj')"/>:
		                            </label>
		                            <label class="labelB">
		                         	&nbsp;<s:if test="null!=t00352Bean.jysj"><s:text name="app.global.format.date"><s:param value="t00352Bean.jysj" /></s:text></s:if>
		                         	</label>
					 			 	<!-- 默认变更日期为当�?-->
									<s:if test='%{null==t00352Bean.jysj}'>
										<script type="text/javascript">$("#txtJYSJ").val('<s:property value="" />');</script>
									</s:if>
		                        </td>
	                        </tr>
                    	</table>
                   	</td>
                   	<td valign="top">
	    				<table width="350" border="0" cellspacing="2" cellpadding="0">
	                    	  
	                         <tr>
		                        <td><label class="labelA">
		                                <s:property	value="%{getText('app.xtwh.info.jylx')}" />:
		                            </label>
		                            <label class="labelB">
		                              &nbsp;<s:property value="t00352Bean.JYLX" />
		                            </label>
		                          </td>
	                    	</tr>
                        	
	                        <tr>
		                        <td><label class="labelA">
		                                <s:property	value="%{getText('app.xtwh.info.fwlx')}" />:
		                            </label>
		                            <label class="labelB">
		                              &nbsp;<s:property value="t00352Bean.FWLX" />
		                            </label>
		                        </td>
	                    	</tr>
		                    <tr>
		                    <td>
	                        	<label class="labelA"><s:property value="getText('app.sjcj.t00302.djrq')"/>:</label>
	                           <label class="labelB">
	                            &nbsp;<s:if test="null!=t00352Bean.djrq"><s:text name="app.global.format.date"><s:param value="t00352Bean.djrq" /></s:text></s:if>		
					           </label>
	                        </td>
	                        </tr>
	                        <tr>
	                        	<td>
	                        	<label class="labelA"><s:property value="getText('app.sjcj.t00302.sfsyfc')" />:</label>
	                        	<label class="labelB">
	                        		&nbsp;<s:property value="t00352Bean.sfsyfcmc" />
	                        	</label>
	                        	</td>
	                        </tr>
	                        <tr>
	                        	<td>
	                        		<label class="labelA"><s:property value="%{getText('app.ws.yjg')}" />:</label>
	                        		<label class="labelB">
	                        		&nbsp;<s:text name="app.global.format.moneyZh"><s:param value="t00352Bean.yjgView" /></s:text>
	                        		</label>
	                        	</td>
	                        </tr>
	                        <tr>
	                        	<td>
	                        		<label class="labelA"><s:property value="%{getText('app.ws.pgjg')}" />:</label>
	                        		<label class="labelB">
	                        		&nbsp;<s:text name="app.global.format.moneyZh"><s:param value="t00352Bean.pgjgView" /></s:text>
	                        		</label>
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
    		<fieldset><legend>【综合修正】<input type="hidden" id="hidZHXZ" name="hidZHXZ" value="" /></legend>
	        <table width="100%" border="0" cellspacing="0" cellpadding="0">
	          <tr>
	            <td>
                  <div id="ddlQTXZ" class="divZhxz">
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
						              <textarea name="txtNOTET00302" id="txtNOTET00302" cols="120" rows="6" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> ><s:property value="t00352Bean.note" /></textarea>
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
  <form id="psForm" action="PSXML.action">
	<input type="hidden" id="txtFCID" name="txtFCID" value="<s:property value='tBean.fcid' />" />	
	</form>
  <div class="divbottom">    
  <!-- <a id="subSL" href="javascript:void(0)"><img src="../images/ico/Edit.gif" width="16" height="16" title="<s:property value="getText('app.button.upd')"/>" alt="<s:property value="getText('app.button.upd')"/>" />提交信息</a>
      <a href="../sjcj/ADDT00302XML.action?txtEDIT=Y&ddlBGLX=0&ACT=U&FCID=<s:property value='t00352Bean.fcid' />"><img src="../images/ico/Edit.gif" width="16" height="16" title="<s:property value="getText('app.button.upd')"/>" alt="<s:property value="getText('app.button.upd')"/>" />修改信息</a>    -->
	  <a id="el" href="javascript:void(0)"><img src="../images/ico/Edit.gif" width="16" height="16" title="<s:property value="getText('app.button.upd')"/>" alt="<s:property value="getText('app.button.upd')"/>" />修改信息</a>
  </div>
  </div>  
	<div id="dialog" class="easyui-window" title="请选择类型..." icon="icon-ok" style="width:350px;height:350px;padding:5px;background: #fafafa;">
		<div id="infoTreeDIV"></div>
	</div>
</td>
</tr>
</table>

</body>
</html>