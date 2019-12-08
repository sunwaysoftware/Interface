<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sw" uri="/sunway"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"></meta>
<title><s:property value="%{getText('app.global.title')}" /></title>
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<script type="text/javascript" src="../scripts/jquery.autocomplete.js"></script>
<script type="text/javascript" src="../scripts/jquery.maskedinput.js"></script>
<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../scripts/jquery.maskedinput.js"></script>
<script type="text/javascript" src="../scripts/T00302/EDITT00302.js"></script>
<script type="text/javascript" src="../scripts/T00352/T00352TREEDIV.js"></script>
<script type="text/javascript" src="../scripts/T00053/T00053TREEDIV.js"></script>
<script type="text/javascript" src="../scripts/T00001/INFOTREEDIV.js"></script>
<script type="text/javascript" src="../scripts/T00303/T00303DIV.js"></script>
<script type="text/javascript"
	src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>
<link type="text/css" rel="stylesheet" href="../css/screen.css"></link>
<link type="text/css" rel="stylesheet"
	href="../css/jquery.autocomplete.css"></link>
<script type="text/javascript">
	$(function() {
		$.notifyBar({
			cls : "success",
			html : '<s:property value="actionMessages.get(0)"/>'
		});
		$.notifyBar({
			cls : "error",
			html : '<s:property value="actionErrors.get(0)"/>'
		});

		var szqy = $("#ddlSZQY").val();
		setParentIds(szqy);
	});
</script>
</head>
<body>
	<table border="0" align="left" cellpadding="0" cellspacing="0"
		class="table1">
		<tr>
			<td align="left" valign="top">
				<div class="ui-widget-content">
					<div class="datagrid-title">
						<span class="datagrid-title-text">房产变更信息</span>
					</div>
					<div id="divsbh"
						style="width: 700px; height: 400px; padding: 5px; background: #fafafa;">
						纳税人识别号：<input type="text" id="txtQYSBH" name="txtQYSBH"
							style="width: 270px;" class="txtInfonm txtfocus"></input>&nbsp;<a
							id="lkQYSBH" href="javascript:void(0);" onclick="findQYSBH()">验证</a>&nbsp;<a
							id="lkQYOK" href="javascript:void(0);" onclick="findQYOK()">确定交易</a>
						<table id="test"></table>
					</div>
					<form id="editForm" action="EDITT00302.action" method="post">
						<input type="hidden" name="ACT" id="ACT"
							value="<s:property value="ACT"/>"></input> <input type="hidden"
							name="txtUPDATE" id="txtUPDATE"
							value="<s:text name="app.global.format.datetime"><s:param value="tBean.upddate"/></s:text>"></input>
						<input type="hidden" name="hidSelect" id="hidSelect"
							<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>></input> <input
							type="hidden" name="hidXZLX" id="hidXZLX"
							value="<s:property value="XZLX"/>"></input> <input type="hidden"
							name="txtSWID" id="txtSWID"
							value="<s:property value="t00301Bean.swid"/>"
							<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>></input> <input
							type="hidden" name="txtFCSLH" id="txtFCSLH"
							value="<s:property value='tBean.txtFCSLH' />"
							<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>></input> <input
							type="hidden" name="isExistQmpg" id="isExistQmpg"
							value="<s:property value='tBean.isExistQmpg' />"></input> <input
							type="hidden" name="isClocktZT" id="isClocktZT"></input> <input
							type="hidden" name="FCID" id="FCID"
							value="<s:property value="tBean.fcid" />"></input> <input
							type="hidden" name="FcidForZhxz" id="FcidForZhxz"
							value="<s:property value="tBean.fcid" />"></input> <input
							type="hidden" name="SZQYDM" id="SZQYDM"
							value="<s:property value='v00303Bean.cd00001Szqy' />"></input>

						<table style="width: 100%;">
							<tr>
								<td colspan="8"><s:property
										value="getText('app.sjcj.t00302.fcid')" /> <s:property
										value="tBean.fcid" /></td>
							</tr>
							<tr>
								<td>
									<fieldset>
										<legend>【楼房信息(幢)】</legend>
										<table
											style="border-collapse: separate; border-spacing: 5 px; width: 100%;">
											<tr>
												<td><s:property value="getText('app.xtwh.info.szqy')" /></td>
												<td><span id="divszqy"> <s:if
															test='%{ACT == "D"}'>
															<sw:szqy items="szqyList" name="ddlSZQY"
																classid="txtfocus" id="ddlSZQY"
																checked="v00303Bean.cd00001Szqy" disabled="disabled" />
														</s:if> <s:else>
															<sw:szqy items="szqyList" name="ddlSZQY"
																classid="txtfocus" id="ddlSZQY"
																checked="v00303Bean.cd00001Szqy" />
														</s:else>
												</span> <span id="divszqyLable"> <input type="text"
														class="txtfocus"
														value="<s:property value='v00303Bean.szqy'/>"
														readonly="readonly"></input>
												</span></td>
												<td><s:property
														value="%{getText('app.xtwh.t00303.clh')}" /></td>
												<td><input name="txtCLH" class="txtfocus" id="txtCLH"
													type="text" value="<s:property value="tBean.clh" />"
													<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>></input></td>
												<td><s:property value="getText('app.sjcj.t00302.fczh')" /></td>
												<td><input name="txtFCZH" class="txtfocus" id="txtFCZH"
													type="text" value="<s:property value="tBean.fczh"/>"
													<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>></input></td>
												<td></td>
												<td><input type="hidden" id="txtHTBH" name="txtHTBH"
													value="<s:property value="tBean.htbh" />" class="txtfocus"
													<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>></input></td>													
											</tr>
											<tr>
												<td><s:property
														value="%{getText('app.xtwh.t00303.zcdzl')}" /></td>
												<td><input name="txtZCDZL" class="txtfocus"
													id="txtZCDZL" type="text"
													value="<s:property value="tBean.zcdzl" />"
													<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>></input></td>
												<td><s:property value="getText('app.sjcj.t00302.lh')" /></td>
												<td><input name="txtLH" id="txtLH" type="text"
													value="<s:property value="tBean.lh"/>"
													<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>></input></td>
												<td><s:property value="getText('app.sjcj.t00302.dyh')" /></td>
												<td><input name="txtDyh" id="txtDyh" type="text"
													value="<s:property value="tBean.dyh"/>"
													<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>></input></td>
												<td><s:property
														value="getText('app.sjcj.t00302.bwjfh')" /></td>
												<td><input name="txtBWJFH" id="txtBWJFH" type="text"
													class="txtfocus" value="<s:property value="tBean.bwjfh"/>"
													<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>></input></td>
											</tr>
											<tr>
												<td><s:property
														value="%{getText('app.xtwh.t00303.xqcx')}" /></td>
												<td><input name="txtXQCX" id="txtXQCX" type="text"
													<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>></input></td>
												<td><s:property
														value="%{getText('app.xtwh.t00303.xqmc')}" /></td>
												<td><span class="txtInfonm txtfocus"><input
														name="txtXQTIP" id="txtXQTIP"
														value="<s:property value="v00303Bean.xqnm"/>" type="text"
														readonly="readonly"
														<s:if test='%{ACT == "D"}'>disabled="disabled"</s:if>></input><span
														<s:if test='%{ACT!="D"}'> id="spXQDM"</s:if>></span></span><input
													type="hidden" id="txtXQDM" name="txtXQDM"
													<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>
													value="<s:property value="v00303Bean.cd00352Xqdm" />"></input>
												</td>
												<td><s:property
														value="%{getText('app.xtwh.t00303.zlc')}" /></td>
												<td><s:if test='%{ACT=="A"}'>
														<s:property value="v00303Bean.zlc" default="1" />
													</s:if> <s:else>
														<input name="txtZLC" class="txtfocus txtNumber"
															id="txtZLC" type="text"
															value="<s:property value="v00303Bean.zlc" default="1"/>"
															<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>></input>
													</s:else></td>
												<td><s:property value="getText('app.sjcj.t00302.szlc')" /></td>
												<td><input name="txtSZLC" class="txtfocus txtNumber"
													id="txtSZLC" type="text"
													value="<s:property value="tBean.szlc" default="0"/>"
													<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>></input></td>
											</tr>
											<tr>
												<td><s:property
														value="%{getText('app.xtwh.info.jzjg')}" /></td>
												<td><span class="txtInfonm txtfocus"><input
														name="txtJZJGTTIP" id="txtJZJGTTIP" type="text"
														value="<s:property value="tBean.jzjg" />"
														readonly="readonly"
														<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>></input><span
														<s:if test='%{ACT!="D"}'> id="spJZJG"</s:if>></span></span><input
													type="hidden" id="txtJZJGT" name="txtJZJGT"
													<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>
													value="<s:property value="tBean.cd00001Jzjg" />"></input></td>
												<td><s:property
														value="%{getText('app.sjcj.t12003.jcnf')}" /></td>
												<td><input name="txtJCSJ" id="txtJCSJ" type="text"
													value="<s:property value="tBean.jcsj" />" maxlength="4"
													onfocus="WdatePicker({dateFmt: 'yyyy'})" class="Wdate"
													<s:if test='%{ACT == "D"}'>disabled="disabled"</s:if>></input></td>
												<td><s:property value="getText('app.sjcj.t00302.wsjs')" /></td>
												<td><input name="txtWSJS" class="txtNumber"
													id="txtWSJS" type="text"
													value="<s:property value="tBean.wsjs" default="0"/>"
													<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>></input></td>
												<td><s:property value="getText('app.sjcj.t00302.wsrq')" /></td>
												<td><input name="txtWSRQ" id="txtWSRQ" type="text"
													value="<s:if test="null!=tBean.wsrq"><s:text name="app.global.format.date"><s:param value="tBean.wsrq" /></s:text></s:if>"
													onfocus="WdatePicker({dateFmt: 'yyyy-MM-dd'})"
													class="Wdate"
													<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>></input></td>
											</tr>
											<tr>
												<td colspan="8">
													<div id="xqcxDIV" style="display: none;">
														<label class="labelL"> <s:property
																value="%{getText('app.xtwh.t00352.xjxqmc')}" />
														</label> <input name="txtXJXQMC" class="txtfocus" id="txtXJXQMC"
															type="text" disabled="disabled"></input> <input
															name="hidPARENTDM" id="hidPARENTDM" type="hidden"></input>
														<input name="hidXQZT" id="hidXQZT" type="hidden"></input>
													</div>
												</td>
											</tr>
										</table>
									</fieldset>
									<fieldset>
										<legend>【房产信息】</legend>
										<table
											style="border-collapse: separate; border-spacing: 5 px; width: 100%;">
											<tr>
												<td><s:property
														value="%{getText('app.xtwh.info.fwlx')}" /></td>
												<td><span class="txtInfonm txtfocus"><input
														name="txtFWLXTIP" id="txtFWLXTIP" type="text"
														value="<s:property value="tBean.fwlxSc" />"
														readonly="readonly"
														<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>></input><span
														<s:if test='%{ACT!="D"}'> id="spFWLX"</s:if>></span></span><input
													type="hidden"
													<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>
													id="txtFWLX" name="txtFWLX"
													value="<s:property value="tBean.cd00001Fwlx" />"></input></td>
												<td><s:property
														value="%{getText('app.xtwh.info.ghyt')}" /></td>
												<td><span class="txtInfonm txtfocus"><input
														name="txtGHYTTTIP" id="txtGHYTTTIP" type="text"
														value="<s:property value="tBean.ghyt" />"
														onkeyup="this.value = this.value.replace(/\D/g, '')"
														onafterpaste="this.value=this.value.replace(/\D/g,'')"
														<s:if test='%{ACT == "D"}'>disabled="disabled"</s:if>></input><span
														<s:if test='%{ACT!="D"}'> id="spGHYT"</s:if>></span></span><input
													type="hidden" id="txtGHYTT" name="txtGHYTT"
													value="<s:property value="tBean.cd00001Ghyt" />"></input></td>
												<td><s:property
														value="%{getText('app.xtwh.info.jylx')}" /></td>
												<td><span class="txtInfonm txtfocus"><input
														name="txtJYLXTIP" id="txtJYLXTIP" type="text"
														value="<s:property value="tBean.jylxSc" />"
														readonly="readonly"
														<s:if test='%{ACT == "D"}'>disabled="disabled"</s:if>></input><span
														<s:if test='%{ACT!="D"}'> id="spJYLX"</s:if>></span></span><input
													type="hidden"
													<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>
													id="txtJYLX" name="txtJYLX"
													value="<s:property value="tBean.cd00001Jylx" />"></input></td>
												<td><s:property value="getText('app.sjcj.t00302.jzmj')" /></td>
												<td><input name="txtJZMJ" class="txtfocus txtNumber"
													id="txtJZMJ" type="text"
													value="<s:property value="tBean.jzmj" default="0"/>"
													<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>></input></td>
											</tr>
											<tr>
												<td><s:property value="getText('app.sjcj.t00302.jyjg')" /></td>
												<td><input name="txtJYJG" class="txtfocus txtNumber"
													id="txtJYJG" type="text"
													value="<s:property value="tBean.jyjg" default="1"/>"
													<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>></input></td>
												<td><s:property value="getText('app.sjcj.t00302.djrq')" /></td>
												<td><input name="txtDJRQ" id="txtDJRQ" type="text"
													value="<s:if test="null!=tBean.djrq"><s:text name="app.global.format.date"><s:param value="tBean.djrq" /></s:text></s:if>"
													onfocus="WdatePicker({dateFmt: 'yyyy-MM-dd'})"
													class="Wdatefocus"
													<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>></input></td>
												<td><s:property value="getText('app.sjcj.t00302.jysj')" /></td>
												<td><input name="txtJYSJ" id="txtJYSJ" type="text"
													value="<s:if test="null!=tBean.jysj"><s:text name="app.global.format.date"><s:param value="tBean.jysj" /></s:text></s:if>"
													onfocus="WdatePicker({dateFmt: 'yyyy-MM-dd'})"
													class="Wdatefocus"
													<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>></input>
													<!-- 默认变更日期为当??--> <s:if test='%{null==tBean.jysj}'>
														<script type="text/javascript">
															$("#txtJYSJ")
																	.val(
																			'<s:property value="" />');
														</script>
													</s:if></td>
												<td><s:property
														value="getText('app.sjcj.t00302.sfsyfc')" /></td>
												<td><input style="border: 0" name="rdoSFSYFC"
													type="radio" id="rdoSFSYFC0" value="0"
													<s:if test="%{tBean.sfsyfc == 0}">checked="checked"</s:if>
													<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>></input>否
													<input style="border: 0" name="rdoSFSYFC" type="radio"
													id="rdoSFSYFC1" value="1"
													<s:if test="%{tBean.sfsyfc == 1}">checked="checked"</s:if>
													<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>></input>是</td>													
											</tr>
											<tr>
												<td><s:property
														value="%{getText('app.sjcj.t00302.yjg')}" /></td>
												<td><input class="txtNumber" name="txtYJG" id="txtYJG"
													type="text" value="<s:property value='tBean.yjg' />"
													<s:if test='%{ACT == "D"}'>disabled="disabled"</s:if>></input></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
											</tr>
											<tr>
												<td colspan="8">
													<div id="divSBPGJG">
														<label class="labelA"><s:property
																value="%{getText('app.sjcj.t00302.fcpgjg')}" /></label> <input
															class="txtfocus txtNumber" name="txtSBPGJG"
															id="txtSBPGJG" type="text"
															value="<s:property value='tBean.sbpgjg' />"
															<s:if test='%{ACT == "D"}'>disabled="disabled"</s:if>></input>
													</div>
												</td>
											</tr>
										</table>
									</fieldset>
									<fieldset>
										<legend>
											【申报双方信息】
											<s:property value='tBean.txtFCSLH' />
										</legend>
										<table
											style="border-collapse: separate; border-spacing: 5 px; width: 100%;">
											<tr>
												<td width="100"><b>转让方类型</b></td>
												<td><input type="radio" id="rdoZRFNSRLX0"
													name="rdoZRFNSRLX" value="0"
													<s:if test="%{tBean.nsrLx_zr == 0}">checked="checked"</s:if>
													<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>></input>自然人
													<input type="radio" id="rdoZRFNSRLX1" name="rdoZRFNSRLX"
													value="1"
													<s:if test="%{tBean.nsrLx_zr == 1}">checked="checked"</s:if>
													<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>></input>纳税人
												</td>
												<td width="100"><b>承受方类型</b></td>
												<td><input type="radio" id="rdoCSFNSRLX0"
													name="rdoCSFNSRLX" value="0"
													<s:if test="%{tBean.nsrLx_cs == 0}">checked="checked"</s:if>
													<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>></input>自然人
													<input type="radio" id="rdoCSFNSRLX1" name="rdoCSFNSRLX"
													value="1"
													<s:if test="%{tBean.nsrLx_cs == 1}">checked="checked"</s:if>
													<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>></input>纳税人
												</td>
											</tr>
											<tr>
												<td>国籍/地区</td>
												<td><span class="txtInfonm txtfocus"
													style="width: 250px;"><input type="text"
														style="width: 230px;" id="txtMFGJDMTIP"
														name="txtMFGJDMTIP"
														value="<s:property value="tBean.mfgjdm"/>"
														<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>
														onkeyup="this.value = this.value.replace(/\D/g, '')"
														onafterpaste="this.value=this.value.replace(/\D/g,'')"></input><span
														<s:if test='%{ACT!="D"}'> id="spMFGJDM"</s:if>></span></span><input
													type="hidden" id="txtMFGJDM" name="txtMFGJDM"
													<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>
													value="<s:property value="tBean.cd00001Mfgjdm"/>" /></td>
												<td>国籍/地区</td>
												<td><span class="txtInfonm txtfocus"
													style="width: 250px;"><input type="text"
														style="width: 230px;" id="txtGMFGJDMTIP"
														name="txtGMFGJDMTIP"
														value="<s:property value="tBean.gmfgjdm"/>"
														<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>
														onkeyup="this.value = this.value.replace(/\D/g, '')"
														onafterpaste="this.value=this.value.replace(/\D/g,'')"></input><span
														<s:if test='%{ACT!="D"}'> id="spGMFGJDM"</s:if>></span></span><input
													type="hidden" id="txtGMFGJDM" name="txtGMFGJDM"
													<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>
													value="<s:property value="tBean.cd00001Gmfgjdm"/>" /></td>
											</tr>
											<tr>
												<td><div id="lblZRFZJLX">
														<s:property value="getText('app.xtwh.info.zjlx')" />
													</div></td>
												<td><span class="txtInfonm txtfocus"
													style="width: 250px;"><input type="text"
														style="width: 230px;" id="txtZJLXNm" name="txtZJLXNm"
														value="<s:property value="t00301Bean.zjlx"/>"
														readonly="readonly"
														<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>></input><span
														<s:if test='%{ACT!="D"}'> id="spZJLX"</s:if>></span></span><input
													type="hidden" id="txtZJLXId" name="txtZJLXId"
													value="<s:property value="t00301Bean.cd00001Zjlx"/>"
													<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> /></td>
												<td><div id="lblCSFZJLX">
														<s:property value="getText('app.sjcj.t00301.csfzjlx')" />
													</div></td>
												<td><span class="txtInfonm txtfocus"
													style="width: 250px;"><input type="text"
														style="width: 230px;" id="txtCSFZJLXNm"
														name="txtCSFZJLXNm"
														value="<s:property value="tBean.txtCSFZJLX"/>"
														readonly="readonly"
														<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>></input><span
														<s:if test='%{ACT!="D"}'> id="spCSFZJLX"</s:if>></span></span><input
													type="hidden" id="txtCSFZJLX" name="txtCSFZJLX"
													<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>
													value="<s:property value="tBean.cd00001csfzjlx" />" /></td>
											</tr>
											<tr>
												<td><div id="lblZRFZJHM">
														<s:property value="getText('app.sjcj.t00301.swid')" />
													</div></td>
												<td><input type="text" class="txtfocus" id="txtZJHM"
													name="txtZJHM" style="width: 250px;"
													value="<s:property value="t00301Bean.zjhm"/>"
													<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>></input>
												</td>
												<td><div id="lblCSFZJHM">
														<s:property value="getText('app.sjcj.t00301.csfzjhm')" />
													</div></td>
												<td><input type="text" class="txtfocus" id="txtCSFZJHM"
													name="txtCSFZJHM" style="width: 250px;"
													value="<s:property value="tBean.txtCSFZJHM"/>"
													<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>></input>
												</td>
											</tr>
											<tr>
												<td><s:property
														value="getText('app.sjcj.t00301.nsrmc')" /></td>
												<td><input type="text" class="txtfocus" id="txtNSRMC"
													style="width: 250px;" name="txtNSRMC"
													value="<s:property value="t00301Bean.nsrmc"/>"
													<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>></input>
												</td>
												<td><s:property
														value="getText('app.sjcj.t00301.csfnsrmc')" /></td>
												<td><input type="text" class="txtfocus"
													id="txtCSFNSRMC" name="txtCSFNSRMC" style="width: 250px;"
													value="<s:property value="tBean.txtCSFNSRMC"/>"
													<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>></input>
												</td>
											</tr>
											<tr>
												<td><s:property value="getText('app.sjcj.t00301.lxdh')" /></td>
												<td><input type="text" id="txtLXDH" name="txtLXDH"
													style="width: 250px;"
													value="<s:property value="t00301Bean.lxdh"/>"
													<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>></input>
												</td>
												<td><s:property value="getText('app.sjcj.t00301.lxdh')" /></td>
												<td><input type="text" id="txtCSFLXDH"
													name="txtCSFLXDH" style="width: 250px;"
													value="<s:property value="tBean.csflxdh"/>"
													<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>></input>
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
												<fieldset>
													<legend>
														【综合修正】<input type="hidden" id="hidZHXZ" name="hidZHXZ"
															value=""
															<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>></input>
													</legend>
													<table width="100%" border="0" cellspacing="0"
														cellpadding="0">
														<tr>
															<td>
																<div id="ddlQTXZ" class="divZhxz"
																	<s:if test='%{ACT == "D"}'>disabled="disabled"</s:if>>
																	<div id="tt1"></div>
																</div> <input type="hidden" id="hidZHXZid" name="hidZHXZid"
																value=""
																<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>></input>
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
					<div class="divbottom">
						<s:if test='%{ACT=="U"}'>
							<a href="javascript:AppSubmit();"><img
								src="../images/ico/Edit.gif" width="16" height="16"
								title="<s:property value="getText('app.button.upd')"/>"
								alt="<s:property value="getText('app.button.upd')"/>"></img> <s:property
									value="getText('app.button.upd')" /></a>
						</s:if>
						<s:elseif test='%{ACT=="D"}'>
							<a href="javascript:AppSubmit();"><img
								src="../images/ico/Delete.gif" width="16" height="16"
								title="<s:property value="getText('app.button.del')"/>"
								alt="<s:property value="getText('app.button.del')"/>"></img> <s:property
									value="getText('app.button.del')" /></a>
						</s:elseif>
						<s:if test='%{ACT!="C"}'>
							<s:set name="BG">M</s:set>
						</s:if>
						<a href="../pg/VIEWPG30001.action?ACT=<s:property value="BG"/>"><img
							src="../images/ico/Cancel.gif" width="16" height="16"
							title="<s:property value="getText('app.button.back')"/>"
							alt="<s:property value="getText('app.button.back')"/>"></img> <s:property
								value="getText('app.button.back')" /></a>
					</div>
				</div>
				<div id="dialog" class="easyui-window" title="请选择类型..."
					icon="icon-ok"
					style="width: 350px; height: 350px; padding: 5px; background: #fafafa;">
					<div id="infoTreeDIV"></div>
				</div>
				<div id="xmpg"
					style="width: 500px; height: 400px; padding: 5px; background: #fafafa;">
					<iframe id="qmpg" src="" width="100%" height="100%" frameborder="0"
						scrolling="no"></iframe>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>