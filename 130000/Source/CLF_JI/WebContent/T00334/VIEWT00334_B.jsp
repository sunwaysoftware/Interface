<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title><s:property value="%{getText('app.global.title')}" /></title>
<link href="../css/screen.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>

<script type="text/javascript" src="../scripts/T00334/VIEWT00334_B.js"></script>
<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	$(function() {
		$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
		$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });				
	});	

</script>
<style type="text/css">
body {
	background-color: #FFFFFF;
}
</style>
</head>
<body>
<table class="easyui-datagrid" style="height:150px">
  	<thead>
		<tr>
			<th field="name1" width="50">操作</th>
			<th field="name2" width="150"><s:property value="%{getText('app.sjpg.t00334.slid')}" /></th>
			<th field="name3" width="170" align="right"><s:property value="%{getText('app.sjpg.t00334.pfmjg')}" /></th>	
			<th field="name14" width="150" align="right"><s:property value="%{getText('app.sjpg.t00334.ypfmjg')}" /></th>					
			<th field="name4" width="80"><s:property value="%{getText('app.sjpg.t00334.yxj')}" /></th>
			<th field="name5" width="180"><s:property value="%{getText('app.sjpg.t00334.zyxj')}" /></th>		
			<th field="name6" width="150"><s:property value="%{getText('app.xtwh.t00303.zcdzl')}" /></th>
			<th field="name7" width="180"><s:property value="%{getText('app.sjpg.t00334.xqdm')}" /></th>				
			<th field="name8" width="80"><s:property value="%{getText('app.sjpg.t00334.zlc')}" /></th>
			<th field="name9" width="150"><s:property value="%{getText('app.xtwh.info.jylx')}" /></th>
			<th field="name0" width="150"><s:property value="%{getText('app.xtwh.info.fwlx')}" /></th>
			<th field="name11" width="150"><s:property value="%{getText('app.xtwh.info.jzjg')}" /></th>
			<th field="name12" width="80"><s:property value="%{getText('app.sjpg.t00334.szlc')}" /></th>					
			<th field="name13" width="120"><s:property value="%{getText('app.sjpg.t00334.jysj')}" /></th>			
			<th field="name15" width="150"><s:property value="%{getText('app.upddate')}" /></th>
			<th field="name16" width="150"><s:property value="%{getText('app.czr')}" /></th>
			<th field="name17" width="150"><s:property value="%{getText('app.note')}" /></th>
		</tr>
      </thead>
		<tbody>
		<s:iterator value="tabList">
		<tr>
			<td><a href="javascript:ShowDialog('<s:property value="cd00302Fcid" />','<s:property value="cdSlid" />');"><img src="../images/info.png" title="<s:property value="%{getText('app.sjpg.t00334a.title')}" />" alt="<s:property value="%{getText('app.sjpg.t00334a.title')}" />" height="16" width="16" /></a></td>
			<td>
				<s:if test="%{cdSlid.substring(0,2)=='SL'}"><a href="javascript:Show('../xtwh/DETAILT00357.action?SLID=<s:property value="cdSlid" />',300,420,'swid');" title='点击查看详细信息' ><s:property value="cdSlid" /></a></s:if>
				<s:else><a href="javascript:Show('../xtwh/DETAILT00351GS.action?SLID=<s:property value="cdSlid" />',300,420,'swid');" title='点击查看详细信息' ><s:property value="cdSlid" /></a></s:else>
			</td>
			<td align="right"><s:text name="app.global.format.moneyZh"><s:param value="pfmjg" /></s:text></td>	
			<td align="right"><s:text name="app.global.format.moneyZh"><s:param value="ypfmjg" /></s:text></td>							
			<td align="right"><s:property value="yxj" /></td>
			<td align="center">
			  <s:if test='%{zyxj}'><s:property value="%{getText('app.global.checkbox.true')}" /></s:if>
			  <s:else><s:property value="%{getText('app.global.checkbox.false')}" /></s:else>
			</td>
			<td><s:property value="fwtdzl" /></td>
			<td><s:property value="xqdm" /></td>					
			<td align="right"><s:property value="zlc" /></td>
			<td><s:property value="jylx" /></td>
			<td><s:property value="fwlx" /></td>
			<td><s:property value="jzjg" /></td>
			<td align="right"><s:property value="szlc" /></td>					
			<td align="center"><s:text name="app.global.format.date"><s:param value="jysj" /></s:text></td>						
			<td align="center"><s:text name="app.global.format.datetime"><s:param value="upddate" /></s:text></td>
			<td><s:property value="czr" /></td>
			<td><s:property value="note" />&nbsp;</td>
		</tr>
		</s:iterator>
      </tbody>
	</table>
<script type="text/javascript" src="../scripts/wz_tooltip.js"></script>
<table border="0" align="left" cellpadding="0" cellspacing="0" class="table1">
  <tr>
  	<td>
  		<table border="0" cellpadding="2" cellspacing="0">
            <tr>
  			  <td colspan="6" class="txtGreen">说明：</td>
		    </tr>
  			<tr>
  			  <th width="600" align="center" valign="top">比准价格</th>
  			  <th align="center" valign="top" nowrap="nowrap">&nbsp;</th>
  			  <th width="100" align="center" valign="top" nowrap="nowrap">&nbsp;<s:property value="%{getText('app.sjpg.t00334.pfmjg')}" /></th>
			</tr>
		<s:set var="sumPfmjg" value="0.00"/>
        <s:iterator value="gsList" status="index">          
  			<tr>
		  		<td align="center" valign="top">
		  			<span class="txtRed"><s:text name="app.global.format.money"><s:param value="ypfmjg" /></s:text> × <s:text name="app.global.format.double"><s:param value="wjxz"/></s:text>
		  			<s:iterator value="xzList"><s:if test="czlx==0"> × <s:property value="qtxzNm"/></s:if></s:iterator><s:iterator value="xzList"><s:if test="czlx==1"> + <s:property value="qtxzNm"/></s:if></s:iterator></span><a href="javascript:void(0)" title="显示详细其它修正系数"  onmouseover="TagToTip('FcQTXZXX<s:property value="#index.index"/>')" onmouseout="UnTip()">(详)</a>
	  		  	</td>
	  		  <td align="center" nowrap="nowrap">=</td>
	  		  <td align="center" valign="middle" nowrap="nowrap"><span class="txtRed"><s:text name="app.global.format.money"><s:param value="pfmjg" /></s:text></span>
	  			<s:set var="sumPfmjg" value="#sumPfmjg+pfmjg"/>
	  			<span id="FcQTXZXX<s:property value="#index.index"/>" style="display:none">
	  			<table>
					<tr>
						<td align="center" valign="top"><strong>&nbsp;修正列表</strong></td>
					</tr>	
					<tr>
				  		<td align="center" valign="top">
				  			<table width="100%" border="1" cellpadding="2" cellspacing="0">
				  				<caption></caption>
				  				<tr>
				  					<th>名称</th>
				  					<th>公式</th>
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
					</tr>	
				</table>
				</span>
	  		  </td>
  			</tr> 		
  			</s:iterator>
  		</table>
  		<hr/>
		<table>
			<tr>
				<td><strong><s:property value="%{getText('app.sjpg.t00331.pgjg')}" /></strong></td>
				<s:if test="#sumPfmjg>0">
				<td>=</td>
				<td><strong><s:property value="%{getText('app.sjpg.t00334.pfmjg')}" /></strong></td>
				<td>×</td>
				<td><strong><s:property value="%{getText('app.sjpg.t00331.jzmj')}" /></strong></td>
				<td>×</td>
				<td><strong>评估修正值(%)</strong></td>
				</s:if>
			</tr>
			<tr>
				<td><span class="txtRed"><s:text name="app.global.format.moneyZh"><s:param value="txtPGJG" /></s:text></span></td>
				<s:if test="#sumPfmjg>0">
				<td>=</td>
				<td><span class="txtRed"><s:text name="app.global.format.money"><s:param value="#sumPfmjg" /></s:text></span></td>
				<td><s:if test="%{gsList.size()>1}"> / <span class="txtRed"><s:property value="gsList.size()"/></span></s:if>×</td>
				<td><span class="txtRed"><s:text name="app.global.format.double"><s:param value="txtJZMJ" /></s:text></span></td>
				<td>×</td>
				<td>(1 - <span class="txtRed"><s:property value="txtPGXZ" /></span>%)</td>
				</s:if>
			</tr>
		</table>
</td>
  </tr>  
</table>
</body>
</html>