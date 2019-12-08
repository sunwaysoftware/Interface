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

<script type="text/javascript" src="../scripts/T00304/VIEWT00304.js"></script>
<script type="text/javascript" src="../scripts/T00352/T00352TREEDIV.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>>
<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/jquery.autocomplete.js"></script>
<link href="../css/jquery.autocomplete.css" rel="stylesheet" type="text/css" />



<script type="text/javascript">
	$(function() {
		$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
		$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });
	});    
</script>
<style type="text/css">

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
<table border="0" align="left" cellpadding="0" cellspacing="0" class="table1">
  <tr>
    <td align="left" valign="top">
    <div class="ui-widget-content">
        <ul class="ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header">
            <li><a href="#INFO"><span><s:property value="%{getText('app.xtwh.t00304.title')}" /></span></a></li>                    
        </ul>
		<div id="INFO" class="divConect">
		<table border="0" align="left" cellpadding="0" cellspacing="0" width="800">
			<tr>
				<td align="left" valign="top">
					<form id="findForm" action="#" method="post">
					<input type="hidden" name="txtXQFind" id="txtXQFind" />
					<input type="hidden" name="chkTrue" id="chkTrue" value="<s:property value="%{getText('app.global.checkbox.true')}" />"/>
					<input type="hidden" class="txtID" id="txtSWIDFind" name="txtSWIDFind"/>
					<input type="hidden" class="txtNSRMC" id="txtNSRMCFind" name="txtNSRMCFind"/>
					<input type="hidden" name="chkFalse" id="chkFalse" value="<s:property value="%{getText('app.global.checkbox.false')}" />"/>
					  <input type="hidden" name="ACT" id="ACT" value="<s:property value="ACT" />" />
					  <input name="btnSearch" type="button" id="btnSearch" class="button" value="<s:property value="getText('app.button.search')"/>" />
					  <!--  
					  <input name="btnConditions" type="button" title="显示搜索条件" id="btnConditions" class="button" value="↓" />
					  -->
					  <div id="dialog" class="easyui-window" title="请选择类型..." icon="icon-ok" style="width:350px;height:350px;padding:5px;background: #fafafa;">
					    <div id="infoTreeDIV"></div>
					  </div>   
					   <table width="200" height="430" border="0" cellspacing="2" cellpadding="0">
					   <!-- 
					  <tr>
					    <td><span class="titlespan"><s:property value="getText('app.sjcj.t00301.swid')"/></span>
					    </td>
					  </tr>
					  <tr>
					    <td><span class="titlespan"><s:property value="getText('app.sjcj.t00301.nsrmc')"/></span>
					    </td>
					  </tr> -->
					  <tr>
					    <td><span class="titlespan"><s:property value="getText('app.xtwh.info.szqy')"/></span>
					    <sw:szqy items="szqyList" name="ddlSZQYFind" id="ddlSZQYFind" display="全部"/></td>
					  </tr>  
					  <tr>
					    <td><span class="titlespan"><s:property value="getText('app.xtwh.t00303.zcdzl')"/></span>
					    <input type="text" id="txtFWTDZLFind" name="txtFWTDZLFind" value="<s:property value="txtFWTDZLFind"/>" /></td>
					  </tr>
					  <tr>
					    <td valign="top"><span class="titlespan"><s:property value="getText('app.xtwh.t00303.xqmc')"/></span>
					    <div class="infodivbz" id="T00352Tree"></div></td>
					  </tr>
					</table>
				</form>
			</td>
			<td valign="top">	
			<table id="scroll1" class="scroll" cellpadding="0" cellspacing="0" style="width:100%;height:350px">
				<thead>
					<tr>
						<th twidth="50">No</th>
						<th twidth="50">操作</th>
						<!--
						<th twidth="150"><s:property value="%{getText('app.sjcj.t00301.swid')}" /></th>
						<th twidth="150"><s:property value="%{getText('app.sjcj.t00301.nsrmc')}" /></th>	
						-->		
						<th twidth="180"><s:property value="%{getText('app.sjpg.t00331.fwtdzl')}" /></th>
						<th twidth="100"><s:property value="%{getText('app.xtwh.t00303.xqmc')}" /></th>
						<th twidth="80"><s:property value="%{getText('app.xtwh.t00303.zlc')}" /></th>			
						<th twidth="100"><s:property value="%{getText('app.xtwh.t00303.ywdt')}" /></th>	
						<th twidth="120"><s:property value="%{getText('app.xtwh.info.jzjg')}" /></th>	
						<th twidth="150"><s:property value="%{getText('app.sjcj.t00302.jzmj')}" /></th>						
						<th twidth="150"><s:property value="%{getText('app.xtwh.info.fwlx')}" /></th>					
						<th twidth="100"><s:property value="%{getText('app.sjcj.t00302.szlc')}" /></th>
						<!--
						<th twidth="100"><s:property value="%{getText('app.xtwh.info.fwcx')}" /></th>
						<th twidth="100"><s:property value="%{getText('app.xtwh.info.cgzk')}" /></th>	
						-->				
						<th twidth="120"><s:property value="%{getText('app.xtwh.info.jylx')}" /></th>
						<!--
						<th twidth="150"><s:property value="%{getText('app.sjcj.t00302.bwjfh')}" /></th>
						<th twidth="150"><s:property value="%{getText('app.sjcj.t00302.tdsyqmj')}" /></th>
						-->
						<th twidth="150"><s:property value="%{getText('app.xtwh.t00304.zbjg')}" /></th>
						<th twidth="120"><s:property value="%{getText('app.xtwh.t00304.gpsj')}" /></th>
						<th twidth="120"><s:property value="%{getText('app.xtwh.t00304.hx')}" /></th>			
						<th twidth="100"><s:property value="%{getText('app.xtwh.t00304.sfzj')}" /></th>
						<th twidth="150"><s:property value="%{getText('app.upddate')}" /></th>
						<th twidth="80"><s:property value="%{getText('app.czr')}" /></th>
						<th twidth="150"><s:property value="%{getText('app.note')}" /></th>
					</tr>
				</thead>
				<tbody id="divShow">
					<tr id="rowtemplate">
						<td id="no" align="center"></td>
						<td id="edit" align="center"></td>
						<!--
						<td id="swid"></td>
						<td id="nsrmc"></td>
						-->						
						<td id="fwtdzl"></td>
						<td id="xqmc"></td>	
						<td id="zlc" align="right"></td>			
						<td align="center" id="ywdt"></td>
						<td id="jzjg"></td>			
						<td align="right" id="jzmj"></td>			
						<td id="fwlx"></td>			
						<td align="right" id="szlc"></td>
						<!--
						<td id="fwcx"></td>
						<td id="cgzk"></td>	
						-->						
						<td id="jylx"></td>
						<!--
						<td id="bwjfh"></td>
						<td align="right" id="tdsyqmj"></td>
						-->	
						<td align="right" id="zbjg"></td>
						<td id="gpsj" align="center"></td>			
						<td id="hx"></td>			
						<td align="center" id="sfzj"></td>
						<td id="upddate" align="center"></td>
						<td id="czr"></td>
						<td id="note"></td>
					</tr>
				</tbody>
			</table>
			<div>
			    <table cellpadding="0" cellspacing="0" style="width:600px">
					<tr>
					<td>
						<s:url id="urlAdd" action="ADDT00304"><s:param name="ACT">C</s:param></s:url>
						<s:a href="%{urlAdd}">
							<img src="../images/ico/Add.gif" width="16" height="16" title="<s:property value="getText('app.button.add')"/>" alt="<s:property value="getText('app.button.add')"/>" /><s:property value="getText('app.button.add')"/>
						</s:a>
					</td>
					<td>
						<form action="../sjcj/UPLOAD.action" method="post" id="uploadForm" enctype="multipart/form-data">
							<input type="file" name="upload" id="upload" size="50" />
							<input name="btnSearch" type="submit" id="btnSearch" class="button" value="上  传" />
						</form>
					</td>
					</tr>
					<tr>
					<td></td>
					<td ><span style="color:red">*注：导入数据前，请确定数据格式及内容正确！</span><a href="../Date/import_gpsj.xls">模板下载</a></td>
					</tr>
				</table>
			</div>
		</td>
	</tr>
</table>
</div>
</div>
    </td>
  </tr>
</table>
</body>
</html>
