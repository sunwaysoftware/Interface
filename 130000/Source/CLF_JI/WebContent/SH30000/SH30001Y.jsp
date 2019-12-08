<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:property value="%{getText('app.global.title')}" /></title>
<script type="text/javascript" src="../scripts/jquery.min.js"></script>

<script type="text/javascript" src="../scripts/common.js"></script>
<script type="text/javascript" src="../scripts/SH30000/SH30001Y.js"></script>
<link href="../css/screen.css" rel="stylesheet" type="text/css" />


<script type="text/javascript">
	$(function() {
		$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
		$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });
	});
</script>
<style type="text/css">
<!--
body {
	background-color: #FFFFFF;
}
-->
</style>
</head>
<body>
<table border="0" align="left" cellpadding="0" cellspacing="0" class="table1">
  <tr>
    <td align="left" valign="top">
		<form id="editForm" action="EXECSH30002.action" method="post">
        <div id="apDiv1">
        <table width="300" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td>&nbsp;<s:property value="getText('app.sjcj.t00301.swid')"/></td>
            <td>&nbsp;<input type="text" class="txtID" id="txtSWIDFind" name="txtSWIDFind" value="<s:property value="txtSWIDFind"/>" /></td>
          </tr>
          <tr>
            <td>&nbsp;<s:property value="getText('app.sjcj.t00301.nsrmc')"/></td>
            <td>&nbsp;<input type="text" class="txtNSRMC" id="txtNSRMCFind" name="txtNSRMCFind" value="<s:property value="txtNSRMCFind"/>" /></td>
          </tr>
        </table>
        </div>
		<input name="btnSearch" type="button" id="btnSearch" class="button" value="<s:property value="getText('app.button.search')"/>" /><input name="btnConditions" type="button" title="显示搜索条件" id="btnConditions" class="button" value="↓" />
		状态符号说明：
		<img src="../images/ico/1.gif" title="<s:property value="%{getText('app.sjsh.sh00000.success')}" />" alt="<s:property value="%{getText('app.sjsh.sh00000.success')}" />"/>
		<input type="hidden" id="hidFlag" name="hidFlag" />
      <table id="scroll1" class="scroll" cellpadding="0" cellspacing="0" style="width:100%;height:350px">
        <thead>
          <tr>
            <th twidth="40"><input type="checkbox" name="chkSelAll" id="chkSelAll" class="rootCheck radio" value="true"/></th>
            <th twidth="40">No</th>
            <th twidth="80"><s:property value="%{getText('app.sjsh.sh00000.flag')}" /></th>
            <th twidth="150"><s:property value="%{getText('app.sjcj.t00302.fcid')}" /></th>
            <th twidth="150"><s:property value="%{getText('app.sjcj.t00301.swid')}" /></th>
            <th twidth="120"><s:property value="%{getText('app.sjcj.t00301.nsrmc')}" /></th>
            <th twidth="100"><s:property value="%{getText('app.xtwh.info.szqy')}" /></th>
            <th twidth="100"><s:property value="%{getText('app.xtwh.t00303.xqmc')}" /></th>     
            <th twidth="100"><s:property value="%{getText('app.xtwh.info.jzjg')}" /></th>              
            <th twidth="150"><s:property value="%{getText('app.sjcj.t00302.jzmj')}" /></th>             
            <th twidth="150"><s:property value="%{getText('app.xtwh.info.fwlx')}" /></th>         
            <th twidth="80"><s:property value="%{getText('app.sjcj.t00302.szlc')}" /></th>
            <th twidth="80"><s:property value="%{getText('app.sjcj.t00302.bwjfh')}" /></th>
            <th twidth="80"><s:property value="%{getText('app.xtwh.info.fwcx')}" /></th>
            <th twidth="80"><s:property value="%{getText('app.xtwh.info.cgzk')}" /></th>                   
            <th twidth="100"><s:property value="%{getText('app.xtwh.info.jylx')}" /></th>
            <!--
            <th twidth="120"><s:property value="%{getText('app.sjcj.t00302.tdsyqmj')}" /></th>
            <th twidth="80"><s:property value="%{getText('app.sjcj.t00302.rjl')}" /></th>            
            <th twidth="120"><s:property value="%{getText('app.sjcj.t00302.fdcdat')}" /></th>
            -->
            <th twidth="100"><s:property value="%{getText('app.sjcj.t00302.jysj')}" /></th>            
            <th twidth="120"><s:property value="%{getText('app.sjcj.t00302.jyjg')}" /></th>
            <th twidth="150"><s:property value="%{getText('app.upddate')}" /></th>
            <th twidth="80"><s:property value="%{getText('app.czr')}" /></th>
          </tr>
        </thead>
        <tbody id="divShow">
          <tr id="rowtemplate">
            <td id="chk" align="center"></td>
            <td id="no" align="center"></td>
            <td id="msg" align="center"></td>
            <td id="fcid" align="center"></td>
            <td id="swid"></td>
            <td id="nsrmc"></td>
            <td id="szqy"></td>
            <td id="xqnm"></td>   
            <td id="jzjg"></td>             
            <td align="right" id="jzmj"></td>              
            <td id="fwlx"></td>         
            <td align="right" id="szlc"></td>   
            <td id="bwjfh"></td>                       
            <td id="fwcx"></td>   
            <td id="cgzk"></td>                            
            <td id="jylx"></td>
            <!--
            <td align="right" id="tdsyqmj"></td>
            <td align="right" id="rjl"></td>            
            <td id="fdcdat"></td>
            -->
            <td id="jysj"></td>            
            <td align="right" id="jyjg"></td>
            <td id="upddate" align="center"></td>
            <td id="czr"></td>
          </tr>
        </tbody>
      </table>
    </form>
    
    <div class="divbottom">
      <a href="javascript:void(0)" onClick="document.getElementById('hidFlag').value='1';AppSubmit();">
        <img src="../images/ico/Add.gif" width="16" height="16" title="<s:property value="getText('app.sjsh.sh00000.button.rSh')"/>" alt="<s:property value="getText('app.sjsh.sh00000.button.rSh')"/>" /><s:property value="getText('app.sjsh.sh00000.button.rSh')"/>
      </a>
      <a href="javascript:void(0)" onClick="document.getElementById('hidFlag').value='2';AppSubmit();">
        <img src="../images/ico/Add.gif" width="16" height="16" title="<s:property value="getText('app.sjsh.sh00000.button.rShAll')"/>" alt="<s:property value="getText('app.sjsh.sh00000.button.rShAll')"/>" /><s:property value="getText('app.sjsh.sh00000.button.rShAll')"/>
      </a>
    </div>
  </td>
  </tr>
</table>
</body>
</html>