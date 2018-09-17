<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sw" uri="/sunway"%>

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title><s:property value="%{getText('app.global.title')}" /></title>

<script type="text/javascript" src="../scripts/easyui/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<link href="../css/screen.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="../scripts/DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/jquery.autocomplete.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/TFC001/EDITTFC001.js"></script>
<script type="text/javascript" src="../scripts/T00001/INFOTREEDIV.js"></script>
<script type="text/javascript">
	$(function() {
		$.notifyBar( {
			cls : "success",
			html : '<s:property value="actionMessages.get(0)"/>'
		});
		$.notifyBar( {
			cls : "error",
			html : '<s:property value="actionErrors.get(0)"/>'
		});
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
		<div id="tabs" class="ui-tabs ui-widget ui-widget-content ui-corner-all">
		<div class="datagrid-title">
				<span class="datagrid-title-text">税额登记</span>
			</div>
		<div id="INFO" class="divConect">
		<div style="min-height: 400px">
		<form action="UPDTFC001.action" method="post" id="editForm">		
			<input type="hidden" name="txtSLID" id="txtSLID" value='<s:property value="SLID"/>' />			
			<input type="hidden" name="txtSSQY" id="txtSSQY" value='<s:property value="SSQY"/>' />		
		<table width="500" border="0" cellspacing="3" cellpadding="0">			
			<tr>
				<td>			
					<input type="radio" class="radio" name="rdoMSSIGN" id="rdoMSSIGN0" value="0" checked="checked"/>纳税
				</td>
			</tr>
			<tr>
				<td><label class="labelA">
					<s:property value="getText('app.xtwh.tfc002.djz_qs')"/>
					</label>
					<input type="text" class="easyui-numberbox txtfocus txtNumber" id="txtDJZ_QS" name="txtDJZ_QS" value="0" precision="2" min="0" />
				</td>
			 </tr>
			 <tr>
				<td><label class="labelA">
					<s:property value="getText('app.xtwh.tfc002.djz_yys')"/>
					</label>
					<input type="text" class="easyui-numberbox txtfocus txtNumber"  id="txtDJZ_YYS" name="txtDJZ_YYS" value="0" precision="2" min="0" />
				</td>
			 </tr>
			 <tr>
				<td><label class="labelA">
					<s:property value="getText('app.xtwh.tfc002.djz_cjs')"/>
					</label>
					<input type="text" class="easyui-numberbox txtfocus txtNumber" id="txtDJZ_CJS" name="txtDJZ_CJS" value="0" precision="2" min="0" />
				</td>
			 </tr>
			 <tr>
				<td><label class="labelA">
					<s:property value="getText('app.xtwh.tfc002.djz_dfjys')"/>
					</label>
					<input type="text" class="easyui-numberbox txtfocus txtNumber" id="txtDJZ_DFJYS" name="txtDJZ_DFJYS" value="0" precision="2" min="0" />
				</td>
			 </tr>
			 <tr>
				<td><label class="labelA">
					<s:property value="getText('app.xtwh.tfc002.djz_grsds')"/>
					</label>
					<input type="text" class="easyui-numberbox txtfocus txtNumber"  id="txtDJZ_GRSDS" name="txtDJZ_GRSDS" value="0" precision="2" min="0" />
				</td>
			 </tr>
			 <tr>
				<td><label class="labelA">
					<s:property value="getText('app.xtwh.tfc002.djz_yhs')"/>
					</label>
					<input type="text" class="easyui-numberbox txtfocus txtNumber" id="txtDJZ_YHS" name="txtDJZ_YHS"  value="0" precision="2" min="0" />
				</td>
			 </tr>
			 <tr>
				<td><label class="labelA">
					<s:property value="getText('app.xtwh.tfc002.djz_tdzzs')"/>
					</label>
					<input type="text" class="easyui-numberbox txtfocus txtNumber" " id="txtDJZ_TDZZS" name="txtDJZ_TDZZS" value="0"  precision="2" min="0" />
				</td>
			 </tr>
			 <tr>
				<td><label class="labelA">
					<s:property value="getText('app.xtwh.tfc002.fphm')"/>
					</label>
					<input type="text" class="text" id="txtFPHM" name="txtFPHM" />
				</td>
			 </tr>
			 	 <tr>
				<td><label class="labelA">
					<s:property value="getText('app.xtwh.tfc002.qssphm')"/>
					</label>
					<input type="text" class="text" id="txtQSSPHM" name="txtQSSPHM" />
				</td>
			 </tr>
			 <tr>
				<td><label class="labelA">
					<s:property value="getText('app.xtwh.tfc002.dfgssphm')"/>
					</label>
					<input type="text" class="text"  id="txtDFGSSPHM" name="txtDFGSSPHM" />
				</td>
			 </tr>
		<%-- 	 <tr>
				<td><label class="labelA">
					<s:property value="getText('app.xtwh.tfc002.updatetime')"/>
					</label>
					<input name="txtUPDATETIME" id="txtUPDATETIME" type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdatefocus"/>
					</td>
			 </tr> --%>
			 
			<tr>
				<td>							
										
					<input type="radio" class="radio" name="rdoMSSIGN" id="rdoMSSIGN1" value="1"/>免税		
				</td>
					<tr>
                <td><label class="labelA">
                        <s:property	value="%{getText('app.xtwh.tfc002.ms_zcyj')}" />:
                    </label>   
                    <select name="txtMSZCYJ" id="txtMSZCYJ" style="width:120px"  class="txtfocus">   
                       <option value="" >请选择</option>   
                       <s:iterator  value="mszcyjList" status="index">   
                        <option value="<s:property value="id"/>"><s:property value="js"/></option>   
                     </s:iterator>   
                    </select>                  
                   </td>
           	</tr>
				
			</tr>
           
			
		</table>
		</form>
		</div>
		<div class="divbottom">
		<div>
		<a href="#" id="btnAdd" name="btnAdd" class="easyui-linkbutton" plain="true" iconCls="icon-save"><s:property value="getText('app.button.save')" /></a>
		<a href="VIEWTFC001.action" class="easyui-linkbutton" plain="true" iconCls="icon-back"><s:property value="getText('app.button.back')" /></a></div>
			
		</div>
		</div>
		</div>
		</td>
	</tr>
</table>
</body>
</html>