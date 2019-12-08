<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title><s:property value="%{getText('app.global.title')}" /></title>

<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<link href="../css/screen.css" rel="stylesheet" type="text/css" />



<script type="text/javascript" src="../scripts/T00335/VIEWT00335.js"></script>

<style type="text/css">
body {
	background-color: #FFFFFF;
}
</style>
</head>
<body>
<script type="text/javascript" src="../scripts/wz_tooltip.js"></script>
<table border="0" align="left" cellpadding="0" cellspacing="0" class="table1">
  <tr>
    <td height="100" align="left" valign="top">
			
		<table class="scroll" id="scroll1" cellpadding="1" cellspacing="0" style="width:100%;height:100px;">
        	<thead>
			<tr>
<!--				<th twidth="50">操作</th>-->
				<th twidth="150"><s:property value="%{getText('app.sjpg.t00334.fcid')}" /></th>
				<th twidth="150"><s:property value="%{getText('app.sjpg.t00334.slid')}" /></th>
				<th twidth="180"><s:property value="%{getText('app.sjpg.t00334.pfmjg')}" /></th>
				<th twidth="120"><s:property value="%{getText('app.sjpg.t00334.yxj')}" /></th>
				<th twidth="180"><s:property value="%{getText('app.sjpg.t00334.zyxj')}" /></th>
				<th twidth="120"><s:property value="%{getText('app.sjpg.t00334.jysj')}" /></th>				
				<th twidth="150"><s:property value="%{getText('app.sjpg.t00334.xqdm')}" /></th>
				<th twidth="150"><s:property value="%{getText('app.xtwh.info.fwlx')}" /></th>
				<th twidth="150"><s:property value="%{getText('app.xtwh.info.jylx')}" /></th>
				<th twidth="150"><s:property value="%{getText('app.xtwh.info.jzjg')}" /></th>				
				<th twidth="150"><s:property value="%{getText('app.sjpg.t00334.szlc')}" /></th>
				<th twidth="150"><s:property value="%{getText('app.sjpg.t00334.zlc')}" /></th>
				<th twidth="180"><s:property value="%{getText('app.sjpg.t00334.ypfmjg')}" /></th>
				<th twidth="150"><s:property value="%{getText('app.xtwh.t00303.zcdzl')}" /></th>
				<th twidth="150"><s:property value="%{getText('app.sjpg.t00334.ywdt')}" /></th>
				<th twidth="150"><s:property value="%{getText('app.upddate')}" /></th>
				<th twidth="150"><s:property value="%{getText('app.czr')}" /></th>
				<th twidth="150"><s:property value="%{getText('app.note')}" /></th>
			</tr>
            </thead>
			<tbody>
			<s:iterator value="pgslList">
			<tr>
<!--				<td align="center"><a href="javascript:ShowDialog('<s:property value="cd00302Fcid" />','<s:property value="cdSlid" />','<s:property value="cd00002Pssd" />');"><img src="../images/info.png" title="<s:property value="%{getText('app.sjpg.t00334a.title')}" />" alt="<s:property value="%{getText('app.sjpg.t00334a.title')}" />" /></a></td>-->
				<td align="center"><a href="javascript:Show('../sjcj/DETAILT00302.action?FCID=<s:property value="cd00302Fcid" />',500,420,'市场法房产详细信息');" title='点击查看详细信息' ><s:property value="cd00302Fcid" /></a></td>
				<td align="center"><a href="javascript:Show('../xtwh/DETAILT00351GS.action?SLID=<s:property value="cdSlid" />',300,420,'swid');" title='点击查看详细信息' ><s:property value="cdSlid" /></a></td>
				<td align="right"><s:text name="app.global.format.moneyZh"><s:param value="pfmjg" /></s:text></td>
				<td align="right"><s:property value="yxj" /></td>
				<td align="center">
				  <s:if test='%{zyxj}'><s:property value="%{getText('app.global.checkbox.true')}" /></s:if>
				  <s:else><s:property value="%{getText('app.global.checkbox.false')}" /></s:else>
				</td>
				<td><s:text name="app.global.format.date"><s:param value="jysj" /></s:text></td>				
				<td><s:property value="xqdm" /></td>
				<td><s:property value="fwlx" /></td>
				<td><s:property value="jylx" /></td>
				<td><s:property value="jzjg" /></td>				
				<td align="right"><s:property value="szlc" /></td>
				<td align="right"><s:property value="zlc" /></td>
				<td align="right"><s:text name="app.global.format.moneyZh"><s:param value="ypfmjg" /></s:text></td>
				<td><s:property value="fwtdzl" /></td>
				<td align="center">
				  <s:if test='%{ywdt}'><s:property value="%{getText('app.global.checkbox.true')}" /></s:if>
				  <s:else><s:property value="%{getText('app.global.checkbox.false')}" /></s:else>
				</td>
				<td><s:text name="app.global.format.datetime"><s:param value="upddate" /></s:text></td>
				<td><s:property value="czr" /></td>
				<td><s:property value="note" />&nbsp;</td>
			</tr>
			</s:iterator>
            </tbody>
		</table>
</td>
  </tr>
  <tr>
  	<td>
  		<table border="0" cellpadding="2" cellspacing="0">
            <tr>
  			  <td colspan="6" class="txtGreen">说明：</td>
		    </tr>  						
  			<tr>  			  
  			  <th width="600" align="center" valign="top">比准价格</th>  			
  			  <th width="13" align="center" valign="top" nowrap="nowrap">&nbsp;</th>
  			  <th width="100" align="center" valign="top" nowrap="nowrap"><s:property value="%{getText('app.sjpg.t00334.pfmjg')}" /></th>
			</tr>
		</table>
		<s:set var="sumPfmjg" value="0.0"/>
        <s:iterator value="gsList"> 
        <table border="0" cellpadding="2" cellspacing="0"> 
  			<tr>
  			    <td align="center" valign="top">
		  			<span class="txtRed"><s:text name="app.global.format.money"><s:param value="ypfmjg" /></s:text> × <s:text name="app.global.format.double"><s:param value="wjxz"/></s:text>
		  			<s:iterator value="xzList"><s:if test="czlx==0"> × <s:property value="qtxzNm"/></s:if></s:iterator><s:iterator value="xzList"><s:if test="czlx==1"> + <s:property value="qtxzNm"/></s:if></s:iterator></span><a href="javascript:void(0)" title="显示详细其它修正系数"  onmouseover="TagToTip('FcQTXZXX<s:property value="#index.index"/>')" onmouseout="UnTip()">(详)</a>
	  		  	</td>	
				<td align="center" nowrap="nowrap">=</td>
	  		  	<td align="center" valign="middle" nowrap="nowrap"><span class="txtRed"><s:text name="app.global.format.moneyZh"><s:param value="pfmjg" /></s:text></span></td>
  			</tr>
  		</table>
  			<s:set var="sumPfmjg" value="#sumPfmjg+pfmjg"/>
  			<span id="FcQTXZXX<s:property value="#index.index"/>" style="display:none">
  			<table border="0" cellpadding="2" cellspacing="0"> 
  			<tr> 				
		  		<td align="center" valign="top">
		  			<table width="100%" border="1" cellpadding="2" cellspacing="0">
		  				<caption></caption>
		  				<tr>
		  					<th>名称
		  					</th>
		  					<th>公式
		  					</th>
		  				</tr>
		  				<tr>
		  					<td>物价指数</td>
		  					<td><s:text name="app.global.format.double"><s:param value="wjxz"/></s:text></td>
		  				</tr>
		  				<s:iterator value="xzList">
		  				<tr>
		  					<td><s:property value="cd00053Qtxzid"/>
		  					</td>
		  					<td><s:property value="qtxzNm"/>
		  					</td>
		  				</tr>
		  				</s:iterator>
		  			</table>
		  		</td>
<!--		  		<td width="298" align="center" valign="top" nowrap="nowrap">-->
<!--		  			<table width="100%" border="1" cellpadding="2" cellspacing="0">-->
<!--		  				<caption></caption>-->
<!--		  				<tr>-->
<!--		  					<th align="center">名称-->
<!--		  					</th>-->
<!--		  					<th align="center">公式-->
<!--		  					</th>-->
<!--		  				</tr>-->
<!--		  				<s:iterator value="qtxzList">-->
<!--		  				<tr>-->
<!--		  					<td><s:property value="cd00053Qtxzid"/>-->
<!--		  					</td>-->
<!--		  					<td><s:property value="qtxzNm"/>-->
<!--		  					</td>-->
<!--		  				</tr>-->
<!--		  				</s:iterator>		  				-->
<!--		  			</table>		  		-->
<!--	  		  </td>	  		  -->
  			</tr>
  			</table>
  			</span>  			
  		</s:iterator>
	<s:property value="%{getText('app.sjpg.t00331.pgjg')}" /> = <s:property value="%{getText('app.sjpg.t00334.pfmjg')}" /> × <s:property value="%{getText('app.sjpg.t00331.jzmj')}" /> × 个案评估修正<a href="javascript:void(0)" title="显示详细个案修正系数"  onmouseover="TagToTip('GAXZ')" onmouseout="UnTip()">(详)</a><br/>
	<span class="txtRed"><s:text name="app.global.format.moneyZh"><s:param value="txtPGJG" /></s:text></span> = <span class="txtRed"><s:text name="app.global.format.moneyZh"><s:param value="#sumPfmjg" /></s:text></span><s:if test="%{gsList.size()>1}"> / <span class="txtRed"><s:property value="gsList.size()"/></span></s:if> × <span class="txtRed"><s:text name="app.global.format.double"><s:param value="txtJZMJ" /></s:text>
	<s:iterator value="t00333List"><s:if test="czlx==0"> × <s:property value="qtxznm"/></s:if></s:iterator>
<s:iterator value="t00333List"><s:if test="czlx==1"> + <s:property value="qtxznm"/></s:if></s:iterator></span>
<!--	 + <span class="txtRed"><s:set var="xz" value="txtPGJG-#sumPfmjg/gsList.size() * txtJZMJ"></s:set>-->
<!--	 <s:if test="%{xz>0}"><s:text name="app.global.format.double"><s:param value="xz"/></s:text></s:if>-->
<!--	<s:else>(<s:text name="app.global.format.double"><s:param value="xz"/></s:text>)</s:else></span>-->
<!--	<a href="javascript:void(0)" title="显示详细其它修正系数"  onmouseover="TagToTip('DcQTXZXX')" onmouseout="UnTip()">(详)</a>-->
<!--	<span id="DcQTXZXX" style="display:none">-->
<!--  	<table width="100%" border="1" cellpadding="2" cellspacing="0">-->
<!--		<caption>其它修正</caption>-->
<!--		<tr>-->
<!--			<th align="center">名称</th>-->
<!--			<th align="center">公式</th>-->
<!--		</tr>-->
<!--		<s:iterator value="dpgXzList">-->
<!--		<tr>-->
<!--			<td><s:property value="cd00053Qtxzid"/>-->
<!--			</td>-->
<!--			<td><s:property value="qtxzNm"/>-->
<!--			</td>-->
<!--		</tr>-->
<!--		</s:iterator>-->
<!--	</table>-->
	</td>
  </tr>
</table>
<span id="GAXZ" style="display:none">
	<table border="1" cellpadding="0" cellspacing="0">
		<caption>个案评估修正</caption>
		<tr>
			<th align="center">名称</th>
			<th align="center">运算</th>
			<th align="center">公式</th>
		</tr>
		<s:iterator value="t00333List">
		<tr>
			<td><s:property value="qtxzid"/>
			</td>
			<td align="center"><s:if test="czlx==0">×</s:if><s:else>+</s:else></td>
			<td><s:property value="qtxznm"/>
			</td>
		</tr>
		</s:iterator>
	</table>
</span>
</body>
</html>