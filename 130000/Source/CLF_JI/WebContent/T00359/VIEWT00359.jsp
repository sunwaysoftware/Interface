<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sw" uri="/sunway" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title><s:property value="%{getText('app.global.title')}" /></title>

<link rel="stylesheet" type="text/css" href="../css/screen.css" />
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>

<script type="text/javascript" src="../scripts/DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/T00359/VIEWT00359.js"></script>
<script type="text/javascript" src="../scripts/T00352/T00352TREEDIV.js"></script>
<script type="text/javascript" src="../scripts/T00053/T00053TREEDIV.js"></script>
<script type="text/javascript" src="../scripts/T00001/INFOTREEDIV.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	$(function() {
		$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
		$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });
	});
	
</script>

</head>
<body>
<table border="0" align="left" cellpadding="0" cellspacing="0" class="table1">
  <tr>
    <td align="left" valign="top">
	
    <div class="ui-widget-content">
	<div class="datagrid-title">
		<span class="datagrid-title-text"><s:property value="%{getText('app.xtwh.t00359.title')}" /></span>                    
        </div>
	<form action="VIEWT00359.action" method="post" id="editForm">
		<input type="hidden" name="hidSelect" id="hidSelect" />
		<table>
			<tr>
				<td>
					<s:property value="getText('app.xtwh.info.szqy')"/>
	    			<sw:szqy items="szqyList" name="ddlSZQY" id="ddlSZQY" checked="ddlSZQY" display="请选择..." classid="txtfocus"/>
				</td>
			</tr>
			<tr>
                <td>
                     <s:property value="%{getText('app.xtwh.info.fwlx')}" />                    
                      <span class="txtInfonm txtfocus"><input name="txtFWLXTIP" id="txtFWLXTIP" type="text" value="<s:property value="v00359Bean.fwlx"/>" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/><span id="spFWLX"></span></span><input type="hidden" id="txtFWLX" name="txtFWLX" value="<s:property value="v00359Bean.cd00001Fwlx"/>"/>
                </td>
           	</tr>
			<tr>
              <td align="left">
              	<label><input type="checkbox" class="radio" name="checkedAll" id="checkedAll"/>全选/取消全选</label>
              </td>
            </tr>
			<tr>
				<td>
				<div id="Zhxz"></div>
				</td>
			</tr>
		</table>
		</form>
<div class="divbottom">
<div>
	<a id="aUpdate" href="javascript:void(0)">
	<img src="../images/ico/Update.gif" width="16" height="16"/><s:property value="%{getText('app.xtwh.t00359.save')}" />
	</a>
	
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
