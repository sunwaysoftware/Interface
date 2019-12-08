<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sw" uri="/sunway"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"></meta>
<title><s:property value="%{getText('app.global.title')}" /></title>
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<script type="text/javascript" src="../scripts/jquery.autocomplete.js"></script>
<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../scripts/T00352/T00352TREEDIV.js"></script>
<script type="text/javascript" src="../scripts/T00053/T00053TREEDIV.js"></script>
<script type="text/javascript" src="../scripts/T00001/INFOTREEDIV.js"></script>
<script type="text/javascript" src="../scripts/formatDate.js"></script>
<script type="text/javascript" src="../scripts/jquery.maskedinput.js"></script>
<script type="text/javascript" src="../scripts/T00302/EDITT00302.js"></script>
<link type="text/css" rel="stylesheet" href="../css/screen.css"></link>
<link type="text/css" rel="stylesheet"
	href="../css/jquery.autocomplete.css"></link>
<script type="text/javascript"
	src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../scripts/T00303/T00303DIV.js"></script>
<script type="text/javascript">
            $(function () {
                $.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
                $.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>'});
              //国籍
              getGJDM(INFO_GJDM_156, '#txtMFGJDMTIP');
              $("#txtMFGJDM").val(INFO_GJDM_156);
              getGJDM(INFO_GJDM_156, '#txtGMFGJDMTIP');
              $("#txtGMFGJDM").val(INFO_GJDM_156);    
            <s:if test='%{v00302Bean.fcid==null}'>
                <s:if test='%{ACT=="C"}'>
                //纳税人性质，默认为企业
                getZJLX(INFO_ZJLX_01, '#txtZJLXNm');
                $("#txtZJLXId").val(INFO_ZJLX_01);
                //纳税人性质，默认为企业
                getZJLX(INFO_ZJLX_01, '#txtCSFZJLXNm');
                $("#txtCSFZJLX").val(INFO_ZJLX_01);
                
                </s:if>
            </s:if>
            <s:else>
                if ($("#txtZJLXId").val() != "")
                    getZJLX($("#txtZJLXId").val(), '#txtZJLXNm');
                if ($("#txtCSFZJLX").val() != "")
                    getZJLX($("#txtCSFZJLX").val(), '#txtCSFZJLXNm');
                if ($("#txtFWLX").val() != "")
                    getFWLX($("#txtFWLX").val(), '#txtFWLXTIP');
                if ($("#txtJYLX").val() != "")
                    getJYLX($("#txtJYLX").val(), '#txtJYLXTIP');
                if ($("#txtJZJGT").val() != "")
                    getJZJG($("#txtJZJGT").val(), '#txtJZJGTTIP');
                if ($("#txtGHYTT").val() != "")
                    getGHYT($("#txtGHYTT").val(), '#txtGHYTTTIP');
                clhblur();
            </s:else>
                
                
            });
        </script>
</head>
<body>
	<table border="0" align="left" cellpadding="0" cellspacing="0" class="table1">
		<tr>
			<td align="left" valign="top">
				<div class="ui-widget-content">
					<div class="datagrid-title">
						<span class="datagrid-title-text"><s:property
								value="%{getText('app.sjcj.t00302.title')}" /></span>
					</div>
					<div id="s"
						style="width: 350px; height: 200px; padding: 5px; background: #fafafa;">
						<form action="subForm" action="EDITT003711.action" method="POST">
							<input type="hidden" name="FCIDSUB" id="FCIDSUB"
								value='<s:property value="v00302Bean.fcid" />'></input> <input
								type="hidden" name="actCount" id="actCount"></input> <input
								type="hidden" name="FCID" id="FCID"></input> <input
								type="hidden" name="FcidForZhxz" id="FcidForZhxz"></input> <input
								type="hidden" name="OINSID" id="OINSID"
								value='<s:property value="t00352Bean.OINSID" />'></input>
							<table>
								<tr>
									<td><s:property value='getText("app.sjcj.t00302.fcid")' />:</td>
									<td><s:property value="v00302Bean.fcid" /></td>
								</tr>
								<tr>
									<td><s:property value='getText("app.sjpg.t10031.note")' />:</td>
									<td></td>
								</tr>
								<tr>
									<td colspan="2"><textarea name="INFOMSGSUB"
											id="INFOMSGSUB" cols="50" rows="6"></textarea></td>
								</tr>
							</table>
						</form>
					</div>
					<div id="wc"
						style="width: 380px; height: 150px; padding: 5px; background: #fafafa;">

						<input type="hidden" name="FCIDD" id="FCIDD"
							value="<s:property value="FCIDD"/>"></input>
						<table>
							<tr>
								<td><img title=\ "未通过\" alt='未通过'
									src='../images/ico/21.gif'></img>此数据评估未通过 <a
									href=javascript:Show(
									'../sjcj/DETAILT00302.action?FCID=<s:property value="FCIDD"/>
									',400,420,'市场法房产详细信息'); title='点击查看详细信息'><s:property
											value="FCIDD" /></a></td>
							</tr>
						</table>
					</div>
					<div id="ww"
						style="width: 380px; height: 150px; padding: 5px; background: #fafafa;">

						<input type="hidden" name="FCIDD" id="FCIDD"
							value="<s:property value="FCIDD"/>"></input>
						<table>

							<tr>
								<td><img title=\ "已通过\" alt='已通过' src='../images/ico/2.gif'></img>此数据评估已通过
									<a href="javascript:Show(
									'../sjcj/DETAILT00302.action?FCID=<s:property value='FCIDD'/>
									',400,420,'市场法房产详细信息');" title='点击查看详细信息'><s:property
											value="FCIDD" /></a></td>
							</tr>
							<tr>
								<td><a
									href="../pg/EXECT00391.action?FCID=<s:property value="FCIDD"/>"
									target=\"_blank\"><img title=\ "存量房交易价格申报评估结果通知单\" alt='打印'
										src='../images/ico/print.gif'></img>打印通知单</a></td>
							</tr>
						</table>
					</div>
					<div id="divsbh"
						style="width: 700px; height: 400px; padding: 5px; background: #fafafa;">
						纳税人识别号：<input type="text" id="txtQYSBH" name="txtQYSBH"
							style="width: 270px;" class="txtInfonm txtfocus"></input>&nbsp;<a
							id="lkQYSBH" href="javascript:void(0);" onclick="findQYSBH()">验证</a>&nbsp;<a
							id="lkQYOK" style="display: none;"></a>
						<table id="test"></table>
					</div>

					<form id="editForm" action="EDITT00302.action" method="post">
						<input type="hidden" name="ACT" id="ACT"
							value="<s:property value="ACT"/>"></input> <input type="hidden"
							name="txtUPDATE" id="txtUPDATE"
							value="<s:text name="app.global.format.datetime"><s:param value="tBean.upddate"/></s:text>"></input>
						<input type="hidden" name="hidSelect" id="hidSelect"></input> <input
							type="hidden" name="FWTDZL" id="FWTDZL"
							value="<s:property value="t00303Bean.fwtdzl"/>"></input> <input
							type="hidden" name="hidXZLX" id="hidXZLX"
							value="<s:property value="XZLX"/>"></input> <input type="hidden"
							name="isPIC" id="isPIC" value="<s:property value="isPIC"/>"></input>
						<input type="hidden" name="FCID" id="FCID"
							value="<s:property value="v00302Bean.fcid"/>"></input> <input
							type="hidden" name="FCIDD" id="FCIDD"
							value="<s:property value="FCIDD"/>"></input><input type="hidden"
							name="ISEXISTFCZH" id="ISEXISTFCZH"></input><input type="hidden"
							name="isExistQmpg" id="isExistQmpg"></input><input type="hidden"
							name="isClocktZT" id="isClocktZT"></input><input type="hidden"
							id="txtDF" name="txtDF"
							value="<s:property value='t00352Bean.DF' />"></input> <input
							type="hidden" id="txtCX" name="txtCX"
							value="<s:property value='t00352Bean.CX' />"></input>

						<s:if test='%{t00352Bean == null}'>
							<input type="hidden" id="txtCG" name="txtCG" value=""></input>
						</s:if>
						<s:elseif test='%{t00352Bean.CG == "B"}'>
							<input type="hidden" id="txtCG" name="txtCG" value="4.2米以内"></input>
						</s:elseif>
						<s:else>
							<input type="hidden" id="txtCG" name="txtCG" value="4.2米以上"></input>
						</s:else>
						<input type="hidden" id="txtFCSLH" name="txtFCSLH"
							value="<s:property value='t00352Bean.FCSLH' />"></input><input
							type="hidden" id="txtROOMID" name="txtROOMID"
							value="<s:property value='t00352Bean.ROOMID' />"></input> <input
							type="hidden" id="txtOwnRoomid" name="txtOwnRoomid"
							value="<s:property value='t00352Bean.ownRoomid' />"></input><input
							type="hidden" id="txtOINSID" name="txtOINSID"
							value="<s:property value='t00352Bean.OINSID' />"></input><input
							type="hidden" id="tempZLC" name="tempZLC"
							value="<s:property value='t00352Bean.ZLC' />"></input>

						<table width="100%" border="0" cellspacing="5" cellpadding="0">
							<tr>
								<td>
									<fieldset>
										<legend>
											【楼房信息】
											<s:property value='t00352Bean.FCSLH' />
										</legend>
										<table width="100%" border="0" style="border-collapse:separate; border-spacing:5 px;">
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
												</span> <span id="divszqyLable"><input id="SZQYNM"
														type="text" style="BORDER: 0px"></input> </span></td>
												<td><span class="labelC"> <s:property
															value="%{getText('app.xtwh.t00303.clh')}" />
												</span></td>
												<td><input name="txtCLH" class="txtfocus" id="txtCLH"
													type="text" value="<s:property value="v00302Bean.clh" />"
													<s:if test='%{ACT!="C"}'>disabled="disabled"</s:if>></input><span
													id="mapZZ" style="display: none;"><a
														href="javascript:openMap();"><img alt="查看地图"
															src="../images/earth.png" height="16" width="16"></img></a></span></td>
												<td><span class="labelC"><s:property
															value="getText('app.sjcj.t00302.fczh')" /></span></td>
												<td><input name="txtFCZH" class="txtfocus" id="txtFCZH"
													type="text" value="<s:property value="v00302Bean.fczh"/>"></input>
												</td>
												<td></td>
												<td><input type="hidden" id="txtHTBH" name="txtHTBH"
													value="<s:property value="v00302Bean.htbh" />"
													class="txtfocus"></input></td>												
											</tr>
											<tr>
												<td><s:property
														value="%{getText('app.xtwh.t00303.zcdzl')}" /></td>
												<td><input name="txtZCDZL" id="txtZCDZL" type="text"
													class="txtfocus"
													value="<s:property value="v00302Bean.zcdzl" />"
													<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>></input></td>
												<td><s:property value="getText('app.sjcj.t00302.lh')" /></td>
												<td><input name="txtLH" id="txtLH" type="text"
													value="<s:property value="v00302Bean.lh"/>"></input></td>
												<td><s:property value="getText('app.sjcj.t00302.dyh')" /></td>
												<td><input name="txtDyh" id="txtDyh" type="text"
													value="<s:property value="v00302Bean.dyh"/>"></input></td>
												<td><s:property
														value="getText('app.sjcj.t00302.bwjfh')" /></td>
												<td><input name="txtBWJFH" id="txtBWJFH" type="text"
													class="txtfocus"
													value="<s:property value="v00302Bean.bwjfh"/>"
													onkeyup="defineBWJFH(this)"></input></td>
											</tr>
											<tr>
												<td><s:property
														value="%{getText('app.xtwh.t00303.xqcx')}" /></td>
												<td><input name="txtXQCX" id="txtXQCX" type="text"
													<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>></input></td>
												<td><s:property
														value="%{getText('app.xtwh.t00303.xqmc')}" /></td>
												<td><span class="txtInfonm txtfocus"> <input
														name="txtXQTIP" id="txtXQTIP"
														value="<s:property value="v00303Bean.xqnm"/>" type="text"
														readonly="readonly"
														<s:if test='%{ACT == "D"}'>disabled="disabled"</s:if>></input><span
														<s:if test='%{ACT!="D"}'> id="spXQDM"</s:if>></span></span><input
													type="hidden" id="txtXQDM" name="txtXQDM"
													<s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>
													value="<s:property value="v00303Bean.cd00352Xqdm" />"></input></td>
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
													value="<s:property value="v00302Bean.szlcmc" default="1"/>"></input>
												</td>
											</tr>
											<tr>
												<td><s:property
														value="%{getText('app.xtwh.info.jzjg')}" /></td>
												<td><span class="txtInfonm txtfocus"><input
														name="txtJZJGTTIP" id="txtJZJGTTIP" type="text"
														value="<s:property value="v00302Bean.jzjg" />"
														onkeyup="this.value = this.value.replace(/\D/g, '')"
														onafterpaste="this.value=this.value.replace(/\D/g,'')"></input><span
														<s:if test='%{ACT!="D"}'> id="spJZJG"</s:if>></span></span><input
													type="hidden" id="txtJZJGT" name="txtJZJGT"
													value="<s:property value="v00302Bean.cd00001Jzjg" />"></input></td>
												<td><s:property
														value="%{getText('app.sjcj.t12003.jcnf')}" /></td>
												<td><input name="txtJCSJ" id="txtJCSJ" type="text"
													value="<s:property value="v00302Bean.jcsj" />"
													maxlength="4" onfocus="WdatePicker({dateFmt: 'yyyy'})"
													class="Wdate"></input></td>
												<td><s:property value="getText('app.sjcj.t00302.wsjs')" /></td>
												<td><input name="txtWSJS" class="txtNumber"
													id="txtWSJS" type="text"
													value="<s:property value="v00302Bean.wsjs" default="0"/>"></input></td>
												<td><s:property value="getText('app.sjcj.t00302.wsrq')" /></td>
												<td><input name="txtWSRQ" id="txtWSRQ" type="text"
													value="<s:if test="null!=v00302Bean.wsrq"><s:text name="app.global.format.date"><s:param value="v00302Bean.wsrq" /></s:text></s:if>"
													onfocus="WdatePicker({dateFmt: 'yyyy-MM-dd'})"
													class="Wdate"></input></td>
											</tr>
											<tr>
												<td>
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
										<table width="100%" border="0" style="border-collapse:separate; border-spacing:5 px;">
											<tr>
												<td><s:property
														value="%{getText('app.xtwh.info.fwlx')}" /></td>
												<td><span class="txtInfonm txtfocus"><input
														name="txtFWLXTIP" id="txtFWLXTIP" type="text"
														value="<s:property value="v00302Bean.fwlxSc" />"
														onkeyup="this.value = this.value.replace(/\D/g, '')"
														onafterpaste="this.value=this.value.replace(/\D/g,'')"></input><span
														<s:if test='%{ACT!="D"}'> id="spFWLX"</s:if>></span></span><input
													type="hidden" id="txtFWLX" name="txtFWLX"
													value="<s:property value="v00302Bean.cd00001Fwlx" />"></input>
												</td>											
												<td><s:property
														value="%{getText('app.xtwh.info.ghyt')}" /></td>
												<td><span class="txtInfonm txtfocus"><input
														name="txtGHYTTTIP" id="txtGHYTTTIP" type="text"
														value="<s:property value="v00302Bean.ghyt" />"
														onkeyup="this.value = this.value.replace(/\D/g, '')"
														onafterpaste="this.value=this.value.replace(/\D/g,'')"></input><span
														<s:if test='%{ACT!="D"}'> id="spGHYT"</s:if>></span></span><input
													type="hidden" id="txtGHYTT" name="txtGHYTT"
													value="<s:property value="v00302Bean.cd00001Ghyt" />"></input>
												</td>
												<td><s:property
														value="%{getText('app.xtwh.info.jylx')}" /></td>
												<td><span class="txtInfonm txtfocus"><input
														name="txtJYLXTIP" id="txtJYLXTIP" type="text"
														value="<s:property value="v00302Bean.jylxSc" />"
														onkeyup="this.value = this.value.replace(/\D/g, '')"
														onafterpaste="this.value=this.value.replace(/\D/g,'')"></input><span
														<s:if test='%{ACT!="D"}'> id="spJYLX"</s:if>></span></span><input
													type="hidden" id="txtJYLX" name="txtJYLX"
													value="<s:property value="v00302Bean.cd00001Jylx" />"></input>
												</td>
												<td><s:property value="getText('app.sjcj.t00302.jzmj')" /></td>
												<td><input name="txtJZMJ" class="txtfocus txtNumber"
													id="txtJZMJ" type="text"
													value="<s:property value="v00302Bean.jzmj" default="0"/>"></input></td>
											</tr>
											<tr>
												<td><s:property value="getText('app.sjcj.t00302.jyjg')" /></td>
												<td><input name="txtJYJG" class="txtfocus txtNumber"
													id="txtJYJG" type="text"
													value="<s:property value="v00302Bean.jyjg" default="0"/>"></input></td>
												<td><s:property value="getText('app.sjcj.t00302.djrq')" /></td>
												<td><input name="txtDJRQ" id="txtDJRQ" type="text"
													value="<s:if test="null!=v00302Bean.djrq"><s:text name="app.global.format.date"><s:param value="v00302Bean.djrq" /></s:text></s:if>"
													onfocus="WdatePicker({dateFmt: 'yyyy-MM-dd'})"
													class="Wdatefocus"></input></td>
												<td><s:property value="getText('app.sjcj.t00302.jysj')" /></td>
												<td><input name="txtJYSJ" id="txtJYSJ" type="text"
													value="<s:if test="null!=v00302Bean.jysj"><s:text name="app.global.format.date"><s:param value="v00302Bean.jysj" /></s:text></s:if>"
													onfocus="WdatePicker({dateFmt: 'yyyy-MM-dd'})"
													class="Wdatefocus"></input></td>													
												<td><s:property
														value="getText('app.sjcj.t00302.sfsyfc')" /></td>
												<td><input style="border: 0" name="rdoSFSYFC"
													type="radio" id="rdoSFSYFC0" value="0"></input>否 <input
													style="border: 0" name="rdoSFSYFC" type="radio"
													id="rdoSFSYFC1" value="1" checked="checked"></input>是</td>
											</tr>
											<tr>
												<td><s:property value="getText('app.sjcj.t00302.yjg')" /></td>
												<td><input class="txtNumber" name="txtYJG" id="txtYJG"
													type="text"
													value="<s:property value="v00302Bean.yjg"  default="0"/>"></input>
												</td>											
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
														<s:property value="getText('app.sjcj.t00302.sbpgjg')" />
														<input class="txtfocus txtNumber" name="txtSBPGJG"
															id="txtSBPGJG" type="text"
															value="<s:property value="v00302Bean.sbpgjg"  default="0"/>"></input>
													</div>
												</td>
											</tr>
										</table>
									</fieldset>
									<fieldset>
										<legend>【申报双方信息】</legend>
										<table border="0" width="100%" style="border-collapse:separate; border-spacing:5 px;">
											<tr>
												<td width="100"><b>转让方类型</b></td>
												<td><input type="radio" id="rdoZRFNSRLX0"
													name="rdoZRFNSRLX" value="0" checked="checked"></input>自然人
													<input type="radio" id="rdoZRFNSRLX1" name="rdoZRFNSRLX"
													value="1"></input>纳税人</td>
												<td width="100"><b>承受方类型</b></td>
												<td><input type="radio" id="rdoCSFNSRLX0"
													name="rdoCSFNSRLX" value="0" checked="checked"></input>自然人
													<input type="radio" id="rdoCSFNSRLX1" name="rdoCSFNSRLX"
													value="1"></input>纳税人</td>
											</tr>
											<tr>
												<td>国籍/地区</td>
												<td><span class="txtInfonm txtfocus"
													style="width: 250px;"><input type="text"
														style="width: 230px;" id="txtMFGJDMTIP"
														name="txtMFGJDMTIP"
														value="<s:property value="v00302Bean.mfgjdm"/>"
														onkeyup="this.value = this.value.replace(/\D/g, '')"
														onafterpaste="this.value=this.value.replace(/\D/g,'')"></input><span
														<s:if test='%{ACT!="D"}'> id="spMFGJDM"</s:if>></span></span><input
													type="hidden" id="txtMFGJDM" name="txtMFGJDM"
													value="<s:property value="t00302Bean.cd00001Mfgjdm"/>"></input></td>
												<td>国籍/地区</td>
												<td><span class="txtInfonm txtfocus"
													style="width: 250px;"><input type="text"
														style="width: 230px;" id="txtGMFGJDMTIP"
														name="txtGMFGJDMTIP"
														value="<s:property value="v00302Bean.gmfgjdm"/>"
														onkeyup="this.value = this.value.replace(/\D/g, '')"
														onafterpaste="this.value=this.value.replace(/\D/g,'')"></input><span
														<s:if test='%{ACT!="D"}'> id="spGMFGJDM"</s:if>></span></span><input
													type="hidden" id="txtGMFGJDM" name="txtGMFGJDM"
													value="<s:property value="t00302Bean.cd00001Gmfgjdm"/>"></input>
												</td>
											</tr>
											<tr>
												<td><div id="lblZRFZJLX">
														<s:property value="getText('app.sjcj.t00301.zjlx')" />
													</div></td>
												<td><span class="txtInfonm txtfocus"
													style="width: 250px;"><input type="text"
														style="width: 230px;" id="txtZJLXNm" name="txtZJLXNm"
														value="<s:property value="t00301Bean.zjlx"/>"
														onkeyup="this.value = this.value.replace(/\D/g, '')"
														onafterpaste="this.value=this.value.replace(/\D/g,'')"></input><span
														<s:if test='%{ACT!="D"}'> id="spZJLX"</s:if>></span></span><input
													type="hidden" id="txtZJLXId" name="txtZJLXId"
													value="<s:property value="t00301Bean.cd00001Zjlx"/>"></input></td>
												<td><div id="lblCSFZJLX">
														<s:property value="getText('app.sjcj.t00301.csfzjlx')" />
													</div></td>
												<td><span class="txtInfonm txtfocus"
													style="width: 250px;"><input type="text"
														style="width: 230px;" id="txtCSFZJLXNm"
														name="txtCSFZJLXNm"
														value="<s:property value="v00302Bean.csfzjlx"/>"
														onkeyup="this.value = this.value.replace(/\D/g, '')"
														onafterpaste="this.value=this.value.replace(/\D/g,'')"></input><span
														<s:if test='%{ACT!="D"}'> id="spCSFZJLX"</s:if>></span></span><input
													type="hidden"
													value="<s:property value="v00302Bean.cd00001csfzjlx"/>"
													id="txtCSFZJLX" name="txtCSFZJLX"></input></td>
											</tr>
											<tr>
												<td><div id="lblZRFZJHM">
														<s:property value="getText('app.sjcj.t00301.swid')" />
													</div></td>
												<td><input type="text" class="txtfocus" id="txtZJHM"
													name="txtZJHM" style="width: 250px;"
													value="<s:property value="t00301Bean.swid"/>"></input></td>
												<td><div id="lblCSFZJHM">
														<s:property value="getText('app.sjcj.t00301.csfzjhm')" />
													</div></td>
												<td><input type="text" class="txtfocus" id="txtCSFZJHM"
													style="width: 250px;" name="txtCSFZJHM"
													value="<s:property value="v00302Bean.csfzjhm"/>"></input></td>
											</tr>
											<tr>
												<td><s:property
														value="getText('app.sjcj.t00301.nsrmc')" /></td>
												<td><input type="text" class="txtfocus" id="txtNSRMC"
													style="width: 250px;" name="txtNSRMC"
													value="<s:property value="t00301Bean.nsrmc"/>"></input></td>
												<td><s:property
														value="getText('app.sjcj.t00301.csfnsrmc')" /></td>
												<td><input type="text" class="txtfocus"
													id="txtCSFNSRMC" style="width: 250px;" name="txtCSFNSRMC"
													value="<s:property value="v00302Bean.csfnsrmc"/>"></input></td>
											</tr>
											<tr>
												<td><s:property value="getText('app.sjcj.t00301.lxdh')" /></td>
												<td><input type="text" id="txtLXDH" name="txtLXDH"
													style="width: 250px;"
													value="<s:property value="t00301Bean.lxdh"/>"></input></td>
												<td><s:property value="getText('app.sjcj.t00301.lxdh')" /></td>
												<td><input type="text" id="txtCSFLXDH"
													name="txtCSFLXDH" style="width: 250px;"
													value="<s:property value="v00302Bean.csflxdh"/>"></input></td>
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
															value=""></input>
													</legend>
													<table width="100%" border="0" cellspacing="0"
														cellpadding="0">
														<tr>
															<td>
																<div id="ddlQTXZ" class="divZhxz">
																	<div id="tt1"></div>
																</div> <input type="hidden" id="hidZHXZid" name="hidZHXZid"
																value=""></input>
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
						<s:if test='%{ACT=="C"}'>
							<a href="javascript:AppSubmit();" id="subpg"><img
								src="../images/ico/Update.gif" width="16" height="16"
								title="<s:property value="getText('app.button.save')"/>"
								alt="<s:property value="getText('app.button.save')"/>"></img> <s:property
									value="getText('app.button.save')" /></a>
							<s:if test='%{t00352Bean.wsSign == "Y"}'>
								<a href="javascript:" id="subBtn"><img
									src="../images/ico/upload.png" width="16" height="16"
									title="<s:property value="getText('app.ws1.button')"/>"
									alt="<s:property value="getText('app.ws1.button')"/>"></img> <s:property
										value="getText('app.ws1.button')" /></a>
							</s:if>
						</s:if>
					</div>
					<div id="dialog" class="easyui-window" title="请选择类型..."
						icon="icon-ok"
						style="width: 350px; height: 350px; padding: 5px; background: #fafafa;">
						<div id="infoTreeDIV"></div>
					</div>
					<div id="pic"
						style="width: 900px; height: 650px; padding: 5px; background: #fafafa;">
						<iframe id="ipic" src="" width="100%" height="100%"></iframe>
					</div>
					<div id="xmpg"
						style="width: 500px; height: 400px; padding: 5px; background: #fafafa;">
						<iframe id="qmpg" src="" width="100%" height="100%"
							frameborder="0" scrolling="no"></iframe>
					</div>
				</div>
				<div id="w2"
					style="width: 350px; height: 200px; padding: 5px; background: #fafafa;">
					<input type="hidden" id="isVal"></input>
					<table width="300" border="0" cellspacing="0" cellpadding="0">
						<tr>存在重复数据，是否替换？
						</tr>
					</table>
				</div>
				<div title="房产录入"></div>
				<div id="FcPic"></div>
			</td>
		</tr>
	</table>
	<script type="text/javascript">
            $(function () {
                //为显示地图按钮用
                $("#ddlSZQY").change();
            });
        </script>
</body>
</html>
