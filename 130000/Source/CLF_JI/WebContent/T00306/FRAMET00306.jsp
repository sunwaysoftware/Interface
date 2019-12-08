<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sw" uri="/sunway"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><s:property value="%{getText('app.global.title')}" /></title>
<link rel="stylesheet" type="text/css" href="../scripts/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="../scripts/easyui/themes/icon.css" />
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<link href="../css/screen.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../scripts/DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../scripts/T00352/T00352TREEDIV.js"></script>
<script type="text/javascript" src="../scripts/T00306/FRAMET00306.js"></script>
<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/T00001/INFOTREEDIV.js"></script>
<script type="text/javascript" src="../scripts/simpleTips/jquery.simpleTips-1.0.js"></script>
<script type="text/javascript" src="../scripts/jquery.maskedinput.js"></script>
<link rel="stylesheet" type="text/css" href="../scripts/simpleTips/jquery.simpleTips.css" />
<script type="text/javascript" src="../scripts/jquery.autocomplete.js"></script>
<link type="text/css" rel="stylesheet" href="../css/jquery.autocomplete.css" />
<script type="text/javascript" src="../scripts/formatDate.js"></script>
<style type="text/css">
.Wdatefocus1{
	/*border:#71a9d2 1px solid;
	height:20px;*/
	background:#FFE6E6 url(../scripts/DatePicker/skin/datePicker.gif) no-repeat right;
	/*width: 100px;*/
}


.LeftText{
   margin: 3px;
   float: left;
   height: 180px;
   border: 1px solid #A6CBD9;
   background-color: #FFF;
}

.FootText{
   height: 180px;
}
.titlespan
{
 width:50px;
}
.Clear
{
   clear:both;
}
</style>
</head>
<body>
<table  align="left" cellpadding="0" cellspacing="0" class="datagrid" width="100%">
  <tr>
    <td align="left" valign="top">
	   	<div class="ui-widget-content">
			<div class="datagrid-title">
				<span class="datagrid-title-text">楼房相关</span>
			</div>
			<fieldset>
		     <legend class="datagrid-title-text">【楼房信息】</legend>
		     <input type="hidden" id="LFIDE" name="LFIDE" value="<s:property value="v00306Bean.id" />" />
		     <input type="hidden" id="FCIDE" name="FCIDE" value="<s:property value="v00306Bean.fcid" />" />
		     <input type="hidden" id="DYE" name="DYE" value="<s:property value="v00306Bean.dyh" />" />
		     <input type="hidden" id="SZLCE" name="SZLCE" value="<s:property value="v00306Bean.szlc" />" />
		     <input type="hidden" name="txtYXWS" id="txtYXWS" value="" />
			 <input type="hidden" name="txtCSFYXWS" id="txtCSFYXWS" value="" />
		     <input type="hidden" id="hidSelect" name="hidSelect" />
			<table border="0" cellpadding="3" cellspacing="1" width="622" >	
				<tr>
					<td width="13%" align="right"><label class="datagrid-title-text"><s:property value='%{getText("app.xtwh.t00306.szqy")}' /></label></td>
			    <td width="37%"><s:property value="v00306Bean.szqy" /></td>
					<td width="12%" align="right"><strong>
					  <label class="datagrid-title-text"><s:property value='%{getText("app.xtwh.t00306.xqnm")}' /></label>
					</strong></td>
					<td width="38%"><s:property value="v00306Bean.xqnm" /></td>
				</tr>
				<tr>
					<td width="13%" align="right"><strong>
					  <label class="datagrid-title-text"><s:property value='%{getText("app.xtwh.t00306.lcs")}' /></label>
					</strong></td>
			    <td><s:property value="v00306Bean.zlc" /></td>
					<td width="12%" align="right"><strong>
					  <label class="datagrid-title-text"><s:property value='%{getText("app.xtwh.t00306.dygs")}' /></label>
					</strong></td>
					<td><s:property value="v00306Bean.dygs" />					</td>
				</tr>
				<tr>
					<td width="13%" align="right"><strong>
					  <label class="datagrid-title-text"><s:property value='%{getText("app.xtwh.t00306.lh")}' /></label>
					</strong></td>
			    <td><s:property value="v00306Bean.lh" /></td>
					<td width="12%" align="right"><strong>
					  <label class="datagrid-title-text"><s:property value='%{getText("app.note")}' /></label>
					</strong></td>
					<td><s:property value="v00306Bean.note" /></td>
				</tr>
			</table>
			</fieldset>
			<fieldset>
		     <legend class="datagrid-title-text">【房屋信息】</legend>
			<table width="100%" border="0" cellpadding="3" cellspacing="1" class="datagrid-row-over" >				
				<s:iterator value="infoList" id="zcs" status="szlch">
				    <s:if test="#szlch.first">
				    <tr>
				    	<td width="80" align="center" bgcolor="#EFEFEF" class="datagrid-title-text">楼层\单元</td>
				    	<s:iterator value="zcs" id="dyh" status="szdyh">
							<td align="center" class="datagrid-header datagrid-title-text" >
								<s:property value='%{getText("app.xtwh.t00306.dy")}' />	<s:property value="#szdyh.index+1" />
					      </td>					
					  </s:iterator>
				    </tr>
				    </s:if>
					<tr>
						<td align="center" bgcolor="#EFEFEF" class="datagrid-title-text">
							<s:property value='%{getText("app.xtwh.t00306.lc")}' />	<s:property value="#szlch.index+1" />
	                  </td>
						<s:iterator value="zcs" id="dyh" status="szdyh">						
							<td bgcolor="#FFFFFF">			
								<a href="javascript:saveData('<s:property value="#szdyh.index+1" />','<s:property value="#szlch.index+1" />');"><img src="../scripts/easyui/themes/icons/edit_add.gif" title="录入房产" alt="录入房产" width="16" height="16" align="absmiddle" /></a>
								<s:iterator value="dyh">
										<a href="javascript:openDial('<s:property value="fcid" />');" class="easyui-linkbutton" plain="true" ><s:property value="fh" /></a>
								</s:iterator>						
						  </td>
					  </s:iterator>
				  </tr>
			  </s:iterator>
			</table>
		  </fieldset>
		  <fieldset>
		  	<legend class="datagrid-title-text">【无对应房屋信息】</legend>
		  	<table width="100%" border="0" cellpadding="3" cellspacing="1" >
		  		<tr>
		  			<td width="16"><a href="javascript:saveData('<s:property value="#szdyh.index+1" />','<s:property value="#szlch.index+1" />');"><img src="../scripts/easyui/themes/icons/edit_add.gif" title="录入房产" alt="录入房产" width="16" height="16" align="absmiddle" /></a></td>
		  			<s:iterator value="lostList">
		  				<td><a href="javascript:openDial('<s:property value="fcid" />');" class="easyui-linkbutton" plain="true"><s:property value="fh" /></a></td>
		  			</s:iterator>
		  		</tr>
		  	</table>
		  </fieldset>
		</div>
		<div class="divbottom">
			
		</div>
    </td>
  </tr>
</table>
<div id="frame" style="width:542px;height:300;padding:5px;background: #fafafa;">
<table>
<tr>
	<td>
	<fieldset>
	     <legend>【基本信息】</legend>
	     <form id="editForm">
	     	<input type="hidden" id="txtFCID" name="txtFCID" />
	         <table width="460" border="0" align="center" cellpadding="1" cellspacing="1">
				<tr>
	    			<td>
	    			<table width="240" border="0" cellspacing="2" cellpadding="0">
	    				<tr>
                        	<td width="70"><s:property value="getText('app.sjcj.t00302.fczh')"/></td>
                        	<td><input name="txtFCZH" class="txtfocus" id="txtFCZH" type="text" /></td>
                       	</tr>
                       	<tr>
			    			<td><s:property value="getText('app.xtwh.info.zjlx')"/></td>
							<td><span class="txtInfonm txtfocus"><input type="text" id="txtZJLXNm" name="txtZJLXNm" class="typeInput" /><span id="spZJLX"></span></span><input type="hidden" id="txtZJLX" name="txtZJLX"/></td>									
						</tr>
						<tr>
			    			<td><s:property value="getText('app.sjcj.t00301.nsrmc')"/></td>
							<td><input type="text" class="txtfocus" id="txtNSRMC" name="txtNSRMC" /></td>
						</tr>
						<tr>
				    		<td><s:property value="getText('app.sjcj.t00301.swid')"/></td>
							<td><input type="text" class="txtfocus" id="txtSWID" name="txtSWID" /></td>
						</tr>					    			
                        <tr>
	                        <td><s:property	value="%{getText('app.xtwh.info.jylx')}" /></td>
	                        <td><span class="txtInfonm txtfocus"><input name="txtJYLXTIP" id="txtJYLXTIP" type="text" class="typeInput" /><span id="spJYLX"></span></span><input type="hidden" id="txtJYLX" name="txtJYLX" /></td>
                    	</tr>
                        <tr>								
							<td><s:property value="getText('app.sjcj.t00301.lxdh')"/></td>
							<td><input type="text" class="txtfocus" id="txtLXDH" name="txtLXDH" /></td>
						</tr>
					</table>
					</td>
					<td valign="top">
					<table width="240" border="0" cellspacing="2" cellpadding="0">
						<tr>
		                    <td><s:property value="getText('app.sjcj.t00302.djrq')"/></td>
	                        <td><input name="txtDJRQ" id="txtDJRQ" type="text" class="Wdatefocus1" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"   /></td>
                        </tr>
						<tr>
			    			<td width="85"><s:property value="getText('app.xtwh.info.csfzjlx')"/></td>
							<td><span class="txtInfonm txtfocus"><input type="text" id="txtCSFZJLXNm" name="txtCSFZJLXNm" class="typeInput" /><span id="spCSFZJLX"></span></span><input type="hidden" id="txtCSFZJLX" name="txtCSFZJLX"/></td>									
						</tr>
						<tr>
			    			<td><s:property value="getText('app.sjcj.t00301.csfnsrmc')"/></td>
							<td><input type="text" class="txtfocus" id="txtCSFNSRMC" name="txtCSFNSRMC" /></td>
						</tr>
						<tr>
				    		<td><s:property value="getText('app.sjcj.t00301.csfswid')"/></td>
							<td><input type="text" class="txtfocus" id="txtCSFSWID" name="txtCSFSWID" /></td>
						</tr>	
						<tr>
	                    	<td><s:property value="getText('app.sjcj.t00302.jysj')"/></td>
	                        <td><input  name="txtJYSJ" id="txtJYSJ" type="text" value="<s:property value="SysDate" />"  class="Wdatefocus1" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" /></td>
                        </tr>
                        <tr>
	                        <td><s:property value="getText('app.sjcj.t00302.jyjg')"/>(元)</td>
	                        <td><input name="txtJYJG" class="txtfocus txtNumber" id="txtJYJG" type="text" /></td>
	                    </tr>
					</table>
					</td>
				</tr>
			</table>
            <table width="480" border="0" cellspacing="2" cellpadding="0">
            	<tr>
		            <td style="width:72"><s:property value="getText('app.note')" /></td>
		            <td><input name="txtNOTE" id="txtNOTE" type="text" style="width:387" /></td>
          		</tr>
          	</table>
	</form>
	</fieldset>
	</td>
</tr>
<tr>
	<td>
		<fieldset>
		<legend>【房屋信息】</legend>
			<iframe id="ifrLFXX" src="" frameborder="0" height="372" width="100%" ></iframe>
		</fieldset>
	</td>
</tr>
</table>
<form id="printForm" action="" method="post">
	<input type="hidden" name="FCID" id="FCID" />
</form>
</div>
<div id="dialog"  title="请选择类型..." icon="icon-ok" style="width:350px;height:350px;padding:5px;background: #fafafa;">
	<div id="infoTreeDIV"></div>
</div>
</body>
</html>
