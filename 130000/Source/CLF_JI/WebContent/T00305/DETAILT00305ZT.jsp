<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title><s:property value="%{getText('app.global.title')}" /></title>
<link href="../css/screen.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<table width="100%" border="0" align="center" cellpadding="1" cellspacing="1" bgcolor="#CCCCCC">
  <!--<tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcj.t00301.swid')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00305Bean.zjhm" /></td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.sjcj.t00301.nsrmc')" /></td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00305Bean.nsrmc" /></td>
  </tr>-->
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="%{getText('app.sjcx.v003015.sczt')}" /></td>
    <td height="18" bgcolor="#FFFFFF">
      <s:if test="%{v00305Bean.sczt==0}">
        <img title="未操作" alt='未操作' src='../images/ico/0.gif'/>
      </s:if>
      <s:elseif test="%{v00305Bean.sczt==1}">
        <img title="已审核" alt='已审核' src='../images/ico/1.gif'/>
      </s:elseif>
      <s:elseif test="%{v00305Bean.sczt==11}">
        <img title="审核未通过" alt='审核未通过' src='../images/ico/11.gif'/>
      </s:elseif>
      <s:elseif test="%{v00305Bean.sczt==12}">
        <img title="强制审核" alt='强制审核' src='../images/ico/12.gif'/>
      </s:elseif>
      <s:elseif test="%{v00305Bean.sczt==2}">
        <img title="已估价" alt='已估价' src='../images/ico/2.gif'/>
      </s:elseif>
      <s:elseif test="%{v00305Bean.sczt==21}">
        <img title="估价未通过" alt='估价未通过' src='../images/ico/21.gif'/>
      </s:elseif>
      <s:elseif test="%{v00305Bean.sczt==22}">
        <img title="已个案评估" alt='已个案评估' src='../images/ico/22.gif'/>
      </s:elseif>
      <s:elseif test="%{v00305Bean.sczt==3}">
        <img title="已算税" alt='已算税' src='../images/ico/3.gif'/>
      </s:elseif>
      <s:elseif test="%{v00305Bean.sczt==31}">
        <img title="算税未通过" alt='算税未通过' src='../images/ico/31.gif'/>
      </s:elseif>
      <s:elseif test="%{v00305Bean.sczt==4}">
        <img title="打印完成" alt='打印完成' src='../images/ico/4.gif'/>
      </s:elseif>
    </td>
  </tr>
  <tr>
    <td height="18" bgcolor="#EBEADB">打印次数</td>
  	<td height="18" bgcolor="#FFFFFF"><s:property value="v00305Bean.scdycs" default="0" /></td>
  </tr>
</table>
<br />
<table width="100%" border="0" align="center" cellpadding="1" cellspacing="1" bgcolor="#CCCCCC">
  <tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.t00305.lb')" /></td>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.t12005.zt')" /></td>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.czr')" /></td>
  </tr>
  <!--<tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.t00305.scsh')" /></td>   
    <td height="18" bgcolor="#FFFFFF">
    	<s:if test="%{v00305Bean.scshzt==1}">
        	已审核
      	</s:if>
      	<s:elseif test="%{v00305Bean.scshzt==2}">
        	强制审核
      	</s:elseif>
      	<s:elseif test="%{v00305Bean.scshzt<0}">
        	审核未通过
      	</s:elseif>
    </td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00305Bean.scshczr" /></td>
  </tr>
  --><tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.t00305.scpg')" /></td> 
    <td height="18" bgcolor="#FFFFFF">
    	<s:if test="%{v00305Bean.scpgzt>0}">
		<s:text name="app.global.format.moneyZh"><s:param value="v00305Bean.scpgjg"/></s:text>
		</s:if>
    </td> 
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00305Bean.scpgczr" /></td>
  </tr>
  <!--<tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.t00305.scsk')" /></td> 
    <td height="18" bgcolor="#FFFFFF">
    	<s:if test="%{v00305Bean.scskzt>0}">
		<s:text name="app.global.format.moneyZh"><s:param value="v00305Bean.scskjg"/></s:text>
		</s:if>
    </td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00305Bean.scskczr" /></td>
  </tr>
  --><tr>
    <td height="18" bgcolor="#EBEADB"><s:property value="getText('app.xtwh.t00305.scdy')" /></td>
    <td height="18" bgcolor="#FFFFFF">
    	<s:if test="%{v00305Bean.scdycs>0}">
        	打印完成
      	</s:if>
    </td>
    <td height="18" bgcolor="#FFFFFF"><s:property value="v00305Bean.scdyczr" /></td>
  </tr>
</table>
</body>
</html>