<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title><s:property value="%{getText('app.global.title')}" /></title>

<link href="../css/screen.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/T00003/EDITT00003.js"></script>
<script type="text/javascript" src="../scripts/T00001/INFOTREEDIV.js"></script>
	<style>
		.toolbar{
			height:30px;
			padding:5px;
		}
		body{
		margin:0px;
		padding:0px;
		}
		
	</style>
	<script>
	</script>
<script type="text/javascript">
	$(function() {
		$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
		$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });
		
	});    
		function enable(){
			$('a.easyui-linkbutton').linkbutton('enable');
		}
		function disable(){
			$('a.easyui-linkbutton').linkbutton('disable');
		}
		function changetext(){
			$('#add').linkbutton({text:'new add'});
		}
</script>

<style type="text/css">
<!--
.labelA {
	width: 80px;
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
			<span class="datagrid-title-text"><s:property value="%{getText('app.xtwh.t00003.title')}" /></span>
		</div>
		<div id="INFO" class="divConect">
		<div style="min-height:400px">
		<form id="editForm" action="EDITT00003.action" method="post">
			<input type="hidden" name="ACT" value="<s:property value="ACT"/>" />
			<input type="hidden" name="txtUPDATE" id="txtUPDATE" value="<s:text name="app.global.format.datetime"><s:param value="t00003Bean.upddate"/></s:text>" />
			<input type="hidden" id="SSGX" name="SSGX" value="<s:iterator value="ssgxList" status="index" id="ssgxEntity"><s:property value='cd00001Ssgx'/>,</s:iterator>" />
			<s:if test='%{ACT!="C"}'>
				<input name="txtROLEID" type="hidden" id="txtROLEID" value="<s:property value="t00003Bean.roleid" />" />
			</s:if>
			<s:if test='%{ACT=="D"}'>
				<input name="txtROLENM" type="hidden" id="txtROLENM" value="<s:property value="t00003Bean.rolenm" />" />
			</s:if>
		      		<table width="350" border="0" cellspacing="3" cellpadding="0">
					 <tr>
				   		 <td valign="top">
						<fieldset>
				           <legend>基本信息</legend>
				               <table width="100%" border="0" cellspacing="2" cellpadding="0">
									<tr>
							    		<td><label class="labelA">	
												<s:property value="%{getText('app.xtwh.t00003.rolenm')}" />
											</label>											
											<input name="txtROLENM" class="txtfocus" id="txtROLENM" type="text" 
											value="<s:property value="t00003Bean.rolenm" />" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> />
											
										</td>
									</tr>
									<tr>
							    		<td><label class="labelA">	
												<s:property value="%{getText('app.note')}" />
											</label>
											<textarea name="txtNOTE" id="txtNOTE" cols="30" rows="5" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> ><s:property value="t00003Bean.note" /></textarea>
										</td>
									</tr>			
								</table>
						</fieldset>
						<fieldset><legend>权限信息</legend>
		                    <table width="100%" border="0" cellspacing="2" cellpadding="0">
							<tr>
								<td>
							<div id="divRight" style="padding-left:30px; padding-right: 50px;width:500px;height:400px;overflow:auto;border: 1px solid #71a9d2;">
							<ul id="tt2" class="easyui-tree">
								<!-- <li>
									<span>数据采集</span>
									<ul>
										<li style="padding-left:20px">
											<span><input type="checkbox" class="radio" value="0000002" name="chkRIGHTID" id="chkRIGHTID"  <s:if test="%{rights.contains('0000002')}">checked="checked"</s:if>/>数据采集</span>
										</li>
										<li style="padding-left:20px">
											<span><input type="checkbox" class="radio" value="0000003" name="chkRIGHTID" id="chkRIGHTID"  <s:if test="%{rights.contains('0000003')}">checked="checked"</s:if>/>数据采集[从房产部门]</span>
										</li>
<!--										<li style="padding-left:20px">-->
<!--											<span><input type="checkbox" class="radio" value="0000007" name="chkRIGHTID" id="chkRIGHTID"  <s:if test="%{rights.contains('0000007')}">checked="checked"</s:if>/>数据修改</span>-->
<!--										</li>
									</ul>
								</li> -->
								<li>
									<span>房产估价</span>
									<ul>
										<li style="padding-left:20px">
											<span><input type="checkbox" class="radio" value="0000002" name="chkRIGHTID" id="chkRIGHTID"  <s:if test="%{rights.contains('0000002')}">checked="checked"</s:if>/>数据采集</span>
										</li>
										<li style="padding-left:20px">
											<span><input type="checkbox" class="radio" value="0000003" name="chkRIGHTID" id="chkRIGHTID"  <s:if test="%{rights.contains('0000003')}">checked="checked"</s:if>/>数据采集[从房产部门]</span>
										</li>
										<li style="padding-left:22px">
											<span><input type="checkbox" class="radio" value="0000010" name="chkRIGHTID" id="chkRIGHTID" <s:if test="%{rights.contains('0000010')}">checked="checked"</s:if>/>房产评估</span>
										</li>
										<li style="padding-left:22px">
											<span><input type="checkbox" class="radio" value="0000013" name="chkRIGHTID" id="chkRIGHTID" <s:if test="%{rights.contains('0000013')}">checked="checked"</s:if>/>个案评估</span>
										</li>
										<li style="padding-left:22px">
											<span><input type="checkbox" class="radio" value="0000022" name="chkRIGHTID" id="chkRIGHTID" <s:if test="%{rights.contains('0000022')}">checked="checked"</s:if>/>评估结果通知单</span>
										</li>
										<li style="padding-left:22px">
											<span><input type="checkbox" class="radio" value="0000019" name="chkRIGHTID" id="chkRIGHTID" <s:if test="%{rights.contains('0000019')}">checked="checked"</s:if>/>认定处理</span>
										</li>										
									</ul>
								</li>
								<li>
									<span>查询统计</span>
									<ul>
										<li style="padding-left:22px">
											<span><input type="checkbox" class="radio" value="00000241" name="chkRIGHTID" id="chkRIGHTID" <s:if test="%{rights.contains('00000241')}">checked="checked"</s:if>/>房产信息查询</span>
										</li>
										<li style="padding-left:22px">
											<span><input type="checkbox" class="radio" value="00000251" name="chkRIGHTID" id="chkRIGHTID" <s:if test="%{rights.contains('00000251')}">checked="checked"</s:if>/>房产价格对比分析-正常</span>
										</li>
										<li style="padding-left:22px">
											<span><input type="checkbox" class="radio" value="00000252" name="chkRIGHTID" id="chkRIGHTID" <s:if test="%{rights.contains('00000252')}">checked="checked"</s:if>/>房产价格对比分析-个案评估</span>
										</li>
										<li style="padding-left:22px">
											<span><input type="checkbox" class="radio" class="radio" value="00000253" name="chkRIGHTID" id="chkRIGHTID" <s:if test="%{rights.contains('00000253')}">checked="checked"</s:if>/>价格走势分析图</span>
										</li>
										<li style="padding-left:22px">
											<span><input type="checkbox" class="radio" value="00000254" name="chkRIGHTID" id="chkRIGHTID" <s:if test="%{rights.contains('00000254')}">checked="checked"</s:if>/>交易量统计</span>
										</li>
										<li style="padding-left:22px">
											<span><input type="checkbox" class="radio" value="00000255" name="chkRIGHTID" id="chkRIGHTID" <s:if test="%{rights.contains('00000255')}">checked="checked"</s:if>/>评估个数对比图</span>
										</li>
									</ul>
								</li>
								<li>
									<span>系统维护</span>
									<ul>
										<li style="padding-left:22px">
											<span><input type="checkbox" class="radio" value="00000271" name="chkRIGHTID" id="chkRIGHTID" <s:if test="%{rights.contains('00000271')}">checked="checked"</s:if>/>系统常规配置</span>
										</li>
										<li style="padding-left:22px">
											<span><input type="checkbox" class="radio" value="00000272" name="chkRIGHTID" id="chkRIGHTID" <s:if test="%{rights.contains('00000272')}">checked="checked"</s:if>/>用户操作日志</span>
										</li>
										<!-- 
										<li style="padding-left:22px">
											<span><input type="checkbox" class="radio" value="00000281" name="chkRIGHTID" id="chkRIGHTID" <s:if test="%{rights.contains('00000281')}">checked="checked"</s:if>/>参数基本信息</span>
										</li>
									
										<li style="padding-left:22px">
											<span><input type="checkbox" class="radio" value="00000282" name="chkRIGHTID" id="chkRIGHTID" <s:if test="%{rights.contains('00000282')}">checked="checked"</s:if>/>房地产分布区域列表</span>
										</li>
											 -->
										
										<li style="padding-left:22px">
											<span><input type="checkbox" class="radio" value="00000283" name="chkRIGHTID" id="chkRIGHTID" <s:if test="%{rights.contains('00000283')}">checked="checked"</s:if>/>估价分区</span>
										</li>
										<li style="padding-left:22px">
											<span><input type="checkbox" class="radio" value="00000284" name="chkRIGHTID" id="chkRIGHTID" <s:if test="%{rights.contains('00000284')}">checked="checked"</s:if>/>楼房普查数据</span>
										</li>
										<li style="padding-left:22px">
											<span><input type="checkbox" class="radio" value="00000285" name="chkRIGHTID" id="chkRIGHTID" <s:if test="%{rights.contains('00000285')}">checked="checked"</s:if>/>全面评估市场法房产信息</span>
										</li>
										<li style="padding-left:22px">
											<span><input type="checkbox" class="radio" value="00000286" name="chkRIGHTID" id="chkRIGHTID" <s:if test="%{rights.contains('00000286')}">checked="checked"</s:if>/>全面评估重复地址房产信息</span>
										</li>
										<!-- <li style="padding-left:22px">
											<span><input type="checkbox" class="radio" value="00000284" name="chkRIGHTID" id="chkRIGHTID" <s:if test="%{rights.contains('00000284')}">checked="checked"</s:if>/>新建小区确认</span>
										</li> -->

										<li style="padding-left:22px">
											<span><input type="checkbox" class="radio" value="00000291" name="chkRIGHTID" id="chkRIGHTID" <s:if test="%{rights.contains('00000291')}">checked="checked"</s:if>/>综合修正区域性设置</span>
										</li>
										<li style="padding-left:22px">
											<span><input type="checkbox" class="radio" value="00000292" name="chkRIGHTID" id="chkRIGHTID" <s:if test="%{rights.contains('00000292')}">checked="checked"</s:if>/>市场法综合修正</span>
										</li>
										<li style="padding-left:22px">
											<span><input type="checkbox" class="radio" value="00000293" name="chkRIGHTID" id="chkRIGHTID" <s:if test="%{rights.contains('00000293')}">checked="checked"</s:if>/>估价待办</span>
										</li>
										<li style="padding-left:22px">
											<span><input type="checkbox" class="radio" value="00000294" name="chkRIGHTID" id="chkRIGHTID" <s:if test="%{rights.contains('00000294')}">checked="checked"</s:if>/>楼层系数修正</span>
										</li>
										<li style="padding-left:22px">
											<span><input type="checkbox" class="radio" value="00000295" name="chkRIGHTID" id="chkRIGHTID" <s:if test="%{rights.contains('00000295')}">checked="checked"</s:if>/>交易价格指数修正-环比</span>
										</li>
										<li style="padding-left:22px">
											<span><input type="checkbox" class="radio" value="00000297" name="chkRIGHTID" id="chkRIGHTID" <s:if test="%{rights.contains('00000297')}">checked="checked"</s:if>/>建筑成新修正</span>
										</li>
										<li style="padding-left:22px">
											<span><input type="checkbox" class="radio" value="00000298" name="chkRIGHTID" id="chkRIGHTID" <s:if test="%{rights.contains('00000298')}">checked="checked"</s:if>/>建筑结构修正</span>
										</li>
										<li style="padding-left:22px">
											<span><input type="checkbox" class="radio" value="00000296" name="chkRIGHTID" id="chkRIGHTID" <s:if test="%{rights.contains('00000296')}">checked="checked"</s:if>/>分区估价值修正</span>
										</li>
										<li style="padding-left:22px">
											<span><input type="checkbox" class="radio" value="00000299" name="chkRIGHTID" id="chkRIGHTID" <s:if test="%{rights.contains('00000299')}">checked="checked"</s:if>/>分区配置方法选择</span>
										</li>
										<li style="padding-left:22px">
											<span><input type="checkbox" class="radio" value="00000321" name="chkRIGHTID" id="chkRIGHTID" <s:if test="%{rights.contains('00000321')}">checked="checked"</s:if>/>可比实例库</span>
										</li>
										<li style="padding-left:22px">
											<span><input type="checkbox" class="radio" value="00000360" name="chkRIGHTID" id="chkRIGHTID" <s:if test="%{rights.contains('00000360')}">checked="checked"</s:if>/>中介数据</span>
										</li>
										<li style="padding-left:22px">
											<span><input type="checkbox" class="radio" value="00000361" name="chkRIGHTID" id="chkRIGHTID" <s:if test="%{rights.contains('00000361')}">checked="checked"</s:if>/>挂牌数据</span>
										</li>
										<li style="padding-left:22px">
											<span><input type="checkbox" class="radio" value="00000362" name="chkRIGHTID" id="chkRIGHTID" <s:if test="%{rights.contains('00000362')}">checked="checked"</s:if>/>一手房交易的数据</span>
										</li>
										<li style="padding-left:22px">
											<span><input type="checkbox" class="radio" value="00000322" name="chkRIGHTID" id="chkRIGHTID" <s:if test="%{rights.contains('00000322')}">checked="checked"</s:if>/>标准房维护</span>
										</li>
										<li style="padding-left:22px">
											<span><input type="checkbox" class="radio" value="00000363" name="chkRIGHTID" id="chkRIGHTID" <s:if test="%{rights.contains('00000363')}">checked="checked"</s:if>/>小区标准房[可测算]</span>
										</li>
										<li style="padding-left:22px">
											<span><input type="checkbox" class="radio" value="00000364" name="chkRIGHTID" id="chkRIGHTID" <s:if test="%{rights.contains('00000364')}">checked="checked"</s:if>/>小区标准房[不可测算]</span>
										</li>
										<li style="padding-left:22px">
											<span><input type="checkbox" class="radio" value="00000365" name="chkRIGHTID" id="chkRIGHTID" <s:if test="%{rights.contains('00000365')}">checked="checked"</s:if>/>标准房价格指数对比</span>
										</li>
										<!--
										<li style="padding-left:22px">
											<span><input type="checkbox" class="radio" value="00000323" name="chkRIGHTID" id="chkRIGHTID" <s:if test="%{rights.contains('00000323')}">checked="checked"</s:if>/>标准房价格指数更新</span>
										</li>
										  -->
										<li style="padding-left:22px">
											<span><input type="checkbox" class="radio" value="00000351" name="chkRIGHTID" id="chkRIGHTID" <s:if test="%{rights.contains('00000351')}">checked="checked"</s:if>/>用户基本信息</span>
										</li>
										<li style="padding-left:22px">
											<span><input type="checkbox" class="radio" value="00000352" name="chkRIGHTID" id="chkRIGHTID" <s:if test="%{rights.contains('00000352')}">checked="checked"</s:if>/>角色基本信息</span>
										</li>
										<li style="padding-left:22px">
											<span><input type="checkbox" class="radio" value="00000353" name="chkRIGHTID" id="chkRIGHTID" <s:if test="%{rights.contains('00000353')}">checked="checked"</s:if>/>权限基本信息</span>
										</li>
<!--										<li style="padding-left:22px">-->
<!--											<span><input type="checkbox" class="radio" value="0000039" name="chkRIGHTID" id="chkRIGHTID" <s:if test="%{rights.contains('0000039')}">checked="checked"</s:if>/>数据备份</span>-->
<!--										</li>-->
									</ul>
								</li>
							</ul>
							</div>
								</td>
							</tr>
						</table>
						</fieldset>
						</td>
					</tr>
				</table>
		</form>
			</div>
			<div class="divbottom" >
			<div>
				<s:if test='%{ACT=="U"}'>
					<a href="javascript:AppSubmit();" >
					<img src="../images/ico/Edit.gif" width="16" height="16" title="<s:property value="getText('app.button.upd')"/>" alt="<s:property value="getText('app.button.upd')"/>" /><s:property value="getText('app.button.upd')"/>
					</a>
				</s:if> 
				<s:elseif test='%{ACT=="C"}'>
					<a href="javascript:AppSubmit();" >
					<img src="../images/ico/Update.gif" width="16" height="16" title="<s:property value="getText('app.button.save')"/>" alt="<s:property value="getText('app.button.save')"/>" /><s:property value="getText('app.button.save')"/>
					</a>
				</s:elseif> 
				<s:elseif test='%{ACT=="D"}'>
					<a href="javascript:AppSubmit();" >
					<img src="../images/ico/Delete.gif" width="16" height="16" title="<s:property value="getText('app.button.del')"/>" alt="<s:property value="getText('app.button.del')"/>" /><s:property value="getText('app.button.del')"/>
					</a>
				</s:elseif> 
				<a href="VIEWT00003.action" >
				<img src="../images/ico/Cancel.gif" width="16" height="16" title="<s:property value="getText('app.button.back')"/>" alt="<s:property value="getText('app.button.back')"/>" /><s:property value="getText('app.button.back')"/>
				</a>
			</div>
			
			</div>	
				
		</div>
</div>
    </td>
  </tr>
</table>

</body>
	
</html>
