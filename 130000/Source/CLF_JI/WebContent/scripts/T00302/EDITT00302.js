$(document)
		.ready(
				function() {
					chkZRFSBH();
					chkCSFSBH();
					
					$("input:radio[name='rdoZRFNSRLX']").change(function(){
						if ($("#rdoZRFNSRLX0:checked").val() == 0){
							$("#lblZRFZJLX").html("证件类型(转)");
							$("#lblZRFZJHM").html("证件号码(转)");
						} else {
							$("#lblZRFZJLX").html("法人证件类型");
							$("#lblZRFZJHM").html("法人证件号码");
						}
					});
					$("input:radio[name='rdoCSFNSRLX']").change(function(){
						if ($("#rdoCSFNSRLX0:checked").val() == 0){
							$("#lblCSFZJLX").html("证件类型(承)");
							$("#lblCSFZJHM").html("证件号码(承)");
						} else {
							$("#lblCSFZJLX").html("法人证件类型");
							$("#lblCSFZJHM").html("法人证件号码");
						}
					});
					
					// setQYSBHview();
					/**
					 * 房屋坐落失焦调用（采集添加与删除时通用）
					 */
					$("#txtZCDZL").blur(
							function() {
								var valZCDZL = $("#txtZCDZL").val();
								var valZCDZLTemp = $("#txtZCDZL").attr("temp");
								if ((valZCDZL != valZCDZLTemp)
										&& (null != valZCDZL)
										&& ("" != valZCDZL)) {
									blurZCDZL();
								}
								$("#txtZCDZL").attr("temp", valZCDZL);
							});

					if ($("#isExistQmpg").val() == 1) {
						clock();
					} else {
						unclock();
					}

					$("#txtCLH").blur(clhblur);

					if ($("#FCIDD").val() != undefined) {
						if ($("#FCIDD").val() != '') {
							var a = $("#FCIDD").val();
							// alert(a);
							bindInfoValue(a);
						}
					}

					// 未通过对话框
					if ($('#wc').length > 0) {
						$('#wc').dialog({
							title : "未通过信息",
							closed : true,
							iconCls : "icon-search",
							buttons : [ {
								text : '查看未通过信息',
								iconCls : 'icon-search',
								handler : function() {
									showWin($("#FCIDD").val());
								}
							}, {
								text : '关闭',
								iconCls : 'icon-cancel',
								handler : function() {
									$("#wc").dialog('close');
								}
							} ]
						});
					}
					;

					// 已通过对话框
					if ($('#ww').length > 0) {
						$('#ww').dialog({
							title : "已通过信息",
							closed : true,
							iconCls : "",
							buttons : [ {
								text : '传入金税三期',
								iconCls : '',
								handler : function() {
									sendDJZXML($("#FCIDD").val());
								}
							}, {
								text : '关闭',
								iconCls : 'icon-cancel',
								handler : function() {
									$("#ww").dialog('close');
								}
							} ]
						});
					}
					;
					// 已通过对话框
					if ($('#divsbh').length > 0) {
						$('#divsbh').dialog({
							title : "验证企业纳税识别号",
							closed : true,
							iconCls : "",
							onClose : function() {
								$('#test').datagrid('loadData', {
									total : 0,
									tabList : []
								}); // clear datagrid data
							},
							buttons : [ {
								text : '关闭',
								iconCls : 'icon-cancel',
								handler : function() {
									$("#divsbh").dialog('close');
								}
							} ]
						});
					}
					;
					$("#subBtn").click(function() {
						$("#s").window("open");
					});

					// 查询对话框
					if ($('#s').length > 0) {
						$('#s').dialog({
							title : "确认数据",
							closed : true,
							iconCls : "icon-ok",
							buttons : [ {
								text : '确认',
								iconCls : 'icon-ok',
								handler : function() {
									$("#actCount").val("0");
									subData();
									$("#s").dialog('close');
								}
							}, {
								text : '关闭',
								iconCls : 'icon-cancel',
								handler : function() {
									$("#s").dialog('close');
								}
							} ]
						});
					}
					;

					// 受理对话框
					if ($('#w2').length > 0) {
						$('#w2').dialog({
							title : "确认数据",
							closed : true,
							iconCls : "icon-ok",
							buttons : [ {
								text : '确认',
								iconCls : 'icon-ok',
								handler : function() {
									$("#actCount").val("1");
									subData();
									$("#w2").dialog('close');
								}
							}, {
								text : '关闭',
								iconCls : 'icon-cancel',
								handler : function() {
									$("#w2").dialog('close');
								}
							} ]
						});
					}
					;
					if ($('#pic').length > 0) {
						$('#pic').dialog({
							title : "选择图片",
							closed : true,
							iconCls : "icon-ok",
							buttons : [ {
								text : '关闭',
								iconCls : 'icon-cancel',
								handler : function() {
									$("#pic").dialog('close');
								}
							} ]
						});
					}
					;
					if ($('#xmpg').length > 0) {
						$('#xmpg').dialog({
							title : "全面评估数据查询",
							closed : true,
							iconCls : "icon-ok",
							buttons : [ {
								text : '关闭',
								iconCls : 'icon-cancel',
								handler : function() {
									$("#xmpg").dialog('close');
								}
							} ]
						});
					}
					;
					showYJG();

					// 文本框的输入格式限制
					$("#txtDJRQ").mask("9999-99-99");
					$("#txtJYSJ").mask("9999-99-99");
					// FROM验证信息
					$("#editForm")
							.validate(
									{
										rules : {
											txtZJHM : {
												required : true,
												maxlength : 300,
												myZJHM : true
											},
											txtSWID : {
												required : true,
												maxlength : 300,
												mySWID : true
											},
											txtNSRMC : {
												required : true,
												maxlength : 100
											},
											txtZJLXId : {
												required : true
											},
											txtLXDH : {
												maxlength : 13
											},
											txtCSFZJLX : {
												required : true
											},
											txtCSFZJHM : {
												required : true,
												maxlength : 300,
												myCSFZJHM : true
											},
											txtCSFNSRMC : {
												required : true
											},
											txtYDDH : {
												maxlength : 11
											},
											txtNOTET00301 : {
												maxlength : 200
											},
											txtXQDM : {
												required : true
											},
											ddlSZQY : {
												required : true
											},
											txtZCDZL : {
												required : true
											},
											txtZLC : {
												required : true,
												number : true,
												maxlength : 3
											},
											txtCLH : {
												maxlength : 50
											},// required: true,
											rdoYWDT : {
												required : true
											},
											txtNOTE : {
												maxlength : 200
											},
											txtFWLX : {
												required : true
											},
											txtGHYTT : {
												required : true
											},
											txtJYLX : {
												required : true
											},
											txtJZJGT : {
												required : true
											},
											txtFCZH : {
												required : true
											},
											txtJZMJ : {
												required : true,
												number : true,
												min : 1,
												maxlength : 14
											},
											txtSZLC : {
												required : true,
												number : true,
												maxlength : 3,
												mySZLC : true
											},
											txtBWJFH : {
												required : true,
												maxlength : 100
											},
											txtTDSYQMJ : {
												required : true,
												number : true,
												maxlength : 14
											},
											txtJYJG : {
												required : true,
												number : true,
												maxlength : 14,
												min : 1
											},
											txtJYSJ : {
												required : true,
												dateISO : true
											},
											txtDJRQ : {
												required : true,
												dateISO : true
											},
											txtXJXQMC : {
												required : true
											},
											txtYJG : {
												number : true,
												maxlength : 14
											},
											txtSBPGJG : {
												required : true,
												number : true,
												maxlength : 14
											},
											hidZHXZ : {
												myZHXZ : true
											},
											rdoSFSYFC : {
												required : true
											},
											txtMFGJDM : {
												required : true
											},
											txtGMFGJDM : {
												required : true
											}
//											,txtHTBH : {
//												required : true
//											}
										},
										messages : {
											txtZJHM : {
												myZJHM : "<img src='../images/exclamation.gif' align='absmiddle' title='证件号码格式不正确！'/>"
											},
											txtSZLC : {
												mySZLC : "<img src='../images/exclamation.gif' align='absmiddle' title='你输入的总层数小于所在层数！'/>"
											},
											// txtZLC:{myZLC:"<img
											// src='../images/exclamation.gif'
											// align='absmiddle'
											// title='房屋类型与总楼层不匹配！'/>"},
											txtSWID : {
												mySWID : "<img src='../images/exclamation.gif' align='absmiddle' title='证件号码格式不正确！'/>"
											},
											hidZHXZ : {
												myZHXZ : "<img src='../images/exclamation.gif' align='absmiddle' title='综合修正有些项没有选择！'/>"
											},
											txtCSFZJHM : {
												myCSFZJHM : "<img src='../images/exclamation.gif' align='absmiddle' title='证件号码格式不正确！'/>"
											}
										}
									});

					// 这里定义了一个名为equal的规则
					// value是指当前校验域的值
					// element是指当前检验的域
					// param是指在rules中设定的参数
					// 这三个参数会在进行校验时由系统自动带入
					$.validator.methods.mySZLC = function(value, element, param) {
						// 在这里使用上面的三个参数进行校验
						if (value) {
							// 如果该对象不存在说明是添加。添加时不用判断。
							if (parseInt($("#txtZLC").val()) >= parseInt(value)) {
								return true;// 如果当前域的值等于指定的参数就通过校验
							}

						}
					};

					// 这里定义了一个名为equal的规则
					// value是指当前校验域的值
					// element是指当前检验的域
					// param是指在rules中设定的参数
					// 这三个参数会在进行校验时由系统自动带入
					$.validator.methods.myZLC = function(value, element, param) {
						// 在这里使用上面的三个参数进行校验
						if (value) {
							// 如果该对象不存在说明是添加。添加时不用判断。
							// 高层
							if ($("#txtFWLX").val() == INFO_FWLX_03) {
								if (parseInt($("#txtZLC").val()) > 8) {
									return true;// 如果当前域的值等于指定的参数就通过校验
								}
							}// 多层
							else if ($("#txtFWLX").val() != INFO_FWLX_07) {
								if (parseInt($("#txtZLC").val()) <= 8) {
									return true;// 如果当前域的值等于指定的参数就通过校验
								}
							}// 非住宅
							else {
								return true;
							}

						}
					};

					$.validator.methods.mySWID = function(value, element, param) {
						// 在这里使用上面的三个参数进行校验
						if (value) {
							if ($("#ACT").val() == "U") {
								return true;
							}
							var strs = value.split("、");
							for (var i = 0; i < strs.length; i++) {
								// 如果该对象不存在说明是添加。添加时不用判断。
								if (!checkSFZ($("#txtZJLXId").val(), strs[i])) {
									return false;
								}
							}
							return true;
						}
					};
					$.validator.methods.myZJHM = function(value, element, param) {
						// 在这里使用上面的三个参数进行校验
						if (value) {
							// 如果该对象不存在说明是添加。添加时不用判断。
							if (!checkSFZ($("#txtZJLXId").val(), value)) {
								return false;
							}
							return true;
						}
					};
					$.validator.methods.myCSFZJHM = function(value, element, param) {
						// 在这里使用上面的三个参数进行校验
						if (value) {
							// 如果该对象不存在说明是添加。添加时不用判断。
							if (!checkSFZ($("#txtCSFZJLX").val(), value)) {
								return false;
							}
							return true;
						}
					};
					$.validator.methods.myZHXZ = function(value, element, param) {
						//在这里使用上面的三个参数进行校验
						var zhxz = $("#hidZHXZ").val();
						
						if (value)
						{
							//这里对数组循环判断
							var sValue = "";
							var sPValue = "";
							var TypeID = $(".ZHXZ option:selected");
							for(var i=0;i<TypeID.length;i++){            
								sValue = sValue + TypeID[i].value + ',';//这里得到复选框选中项的值
								sPValue = sPValue + $(TypeID[i]).attr("parentid") + ',';				
					        } 
							
							
							var zhxzList = zhxz.split(",") ;
							//var tmpI = true;
							for(var i=0; i<zhxzList.length; i++){
								if(sPValue.search(zhxzList[i] + ',')==-1){
									//alert("综合信息有些类型没有选择！");
									return false;
								}
							}
							$("#hidZHXZid").val(sValue);
							return true;
							
						}
						else
						{
							if (zhxz=="" || zhxz==null)
								return true;
						}
					};

					// 证件类型
					$("#spZJLX").click(function() {
						var infoID = $("#txtZJLXId").val();
						$("#hidSelect").val("ZJLX");
						openZJLXDialog(infoID, '#infoTreeDIV');
					});

					// 输入证件类型代码获得类型
					$("#txtZJLXNm").blur(function() {
						var zjlxId = $("#txtZJLXNm").val();
						var flag = isNaN(zjlxId);
						if (zjlxId != '') {
							if (!flag)
								getZJLX_ZR(zjlxId, '#txtZJLXNm');
						} else {
							$("#txtZJLXId").val("");
						}
					});

					// 承受房证件类型
					$("#spCSFZJLX").click(function() {
						var infoID = $("#txtCSFZJLX").val();
						$("#hidSelect").val("CSFZJLX");
						openZJLXDialog(infoID, '#infoTreeDIV');
					});

					// 输入承受方证件类型代码获得类型
					$("#txtCSFZJLXNm").blur(function() {
						var csfzjlxId = $("#txtCSFZJLXNm").val();
						var flag = isNaN(csfzjlxId);
						if (csfzjlxId != '') {
							if (!flag)
								getZJLX_CS(csfzjlxId, '#txtCSFZJLXNm');
						} else {
							$("#txtCSFZJLX").val("");
						}
					});

					// 国籍
					$("#spMFGJDM").click(function() {
						var infoID = $("#txtMFGJDM").val();
						$("#hidSelect").val("MFGJDM");
						openGJDMDialog(infoID, '#infoTreeDIV');
					});
					
					$("#txtMFGJDMTIP").blur(function() {
						var mfgjdm = $("#txtMFGJDMTIP").val();
						var flag = isNaN(mfgjdm);
						if (mfgjdm != '') {
							if (!flag)
								getGJDM(mfgjdm, '#txtMFGJDMTIP');
						} else {
							$("#txtMFGJDM").val("");
						}
					});
					

					$("#spGMFGJDM").click(function() {
						var infoID = $("#txtGMFGJDM").val();
						$("#hidSelect").val("GMFGJDM");
						openGJDMDialog(infoID, '#infoTreeDIV');
					});
					
					$("#txtGMFGJDMTIP").blur(function() {
						var mfgjdm = $("#txtGMFGJDMTIP").val();
						var flag = isNaN(mfgjdm);
						if (mfgjdm != '') {
							if (!flag)
								getGJDM(mfgjdm, '#txtGMFGJDMTIP');
						} else {
							$("#txtGMFGJDM").val("");
						}
					});

					// 房屋类型
					$("#spFWLX").click(function() {
						if ($("#isExistQmpg").val() == 1) {
							return;
						}
						$("#hidSelect").val("FWLX");
						var infoID = $("#txtFWLX").val();
						openFWLXDialog(infoID, '#infoTreeDIV');
					});

					// 输入房屋类型代码获得类型
					$("#txtFWLXTIP").blur(function() {
						var fwlxId = $("#txtFWLXTIP").val();
						var flag = isNaN(fwlxId);
						if (fwlxId != '') {
							if (!flag)
								getFWLX(fwlxId, '#txtFWLXTIP');

						} else {
							$("#txtFWLX").val("");
						}
					});

					// 交易类型
					$("#spJYLX").click(function() {

						$("#hidSelect").val("JYLX");
						var infoID = $("#txtJYLX").val();
						openJYLXDialog(infoID, '#infoTreeDIV');
					});

					// 输入交易类型代码获得类型
					$("#txtJYLXTIP").blur(function() {
						var jylxId = $("#txtJYLXTIP").val();
						var flag = isNaN(jylxId);
						if (jylxId != '') {
							if (!flag)
								getJYLX(jylxId, '#txtJYLXTIP');
						} else {
							$("#txtJYLX").val("");
						}
					});

					// 建筑结构
					$("#spJZJG").click(function() {
						if ($("#isExistQmpg").val() == 1) {
							return;
						}
						$("#hidSelect").val("JZJGT");
						var infoID = $("#txtJZJGT").val();
						openJZJGDialog(infoID, '#infoTreeDIV');
					});

					// 输入建筑结构代码获得类型
					$("#txtJZJGTTIP").blur(function() {
						var jzjgId = $("#txtJZJGTTIP").val();
						var flag = isNaN(jzjgId);
						if (jzjgId != '') {
							if (!flag)
								getJZJG(jzjgId, '#txtJZJGTTIP');
						} else {
							$("#txtJZJGT").val("");
						}
					});
					//
					$("#txtLH").blur(function() {
						showFcPic();
					});
					// 规划用途
					$("#spGHYT").click(function() {
						if ($("#isExistQmpg").val() == 1) {
							return;
						}
						$("#hidSelect").val("GHYTT");
						var infoID = $("#txtGHYTT").val();
						openGHYTDialog(infoID, '#infoTreeDIV');
						// openSEZLDialog(infoID, '#infoTreeDIV');
					});

					// 输入规划用途代码获得类型
					$("#txtGHYTTTIP").blur(function() {
						var ghytId = $("#txtGHYTTTIP").val();
						var flag = isNaN(ghytId);
						if (ghytId != '') {
							if (!flag)
								getGHYT(ghytId, '#txtGHYTTTIP');

						} else {
							$("#txtGHYTT").val("");
						}
					});
					// 综合修正
					$("#btnAddQTXZ").click(function() {
						var szqy = $("#ddlSZQY").val();
						if (szqy == null || szqy == "") {
							$.notifyBar({
								html : '请先选择所在区域'
							});
							$("#ddlSZQY").focus();
						} else {
							$("#hidSelect").val("QTXZ");
							openCGZKDialog('', "#infoTreeDIV");
						}
					});

					// 所在区域
					$("#ddlSZQY").change(function() {
						$("#mapZZ").hide();
						var szqy = $(this).val();
						setParentIds(szqy);
						// 控制GIS按钮是否显示
						if (null != szqy && "" != szqy) {
							var qy = szqy.substr(0, 4);
							// 如果是“株洲”区号,则显示GIS按钮
							if ("4302" == qy) {
								$("#mapZZ").show();
							}
						}
					});

					// 绑定小区文本框改变事件
					bingXQChange("#txtXQTIP");

					// 弹出对话框
					$("#dialog")
							.dialog(
									{
										modal : true,
										shadow : true,
										closed : true,
										buttons : [
												{
													text : '选择',
													iconCls : 'icon-ok',
													handler : function() {
														if ($("#hidSelect")
																.val() != "QTXZ")
															$("#dialog")
																	.dialog(
																			"close");
														var selectValue;
														if ($("#hidSelect")
																.val() == "ZJLX") {
															selectValue = getSelectedZJLXValue();
															$("#txtZJLXId")
																	.val(
																			selectValue);
															getZJLX(
																	selectValue,
																	'#txtZJLXNm');
															// 选择证件类型后，验证证件号码是否有效
															// var zjlx =
															// $("#txtZJLX").val();
															// validateZjlxYxws(zjlx,
															// "#txtSWID");
														} else if ($(
																"#hidSelect")
																.val() == "CSFZJLX") {
															selectValue = getSelectedZJLXValue();
															$("#txtCSFZJLX")
																	.val(
																			selectValue);
															getZJLX(
																	selectValue,
																	'#txtCSFZJLXNm');
														} else if ($(
																"#hidSelect")
																.val() == "XQ") {
															var szqy = $(
																	"#ddlSZQY")
																	.val();
															selectValue = getSelectedXQValue();
															$("#txtXQDM")
																	.val(
																			selectValue);
															getXQ(
																	szqy,
																	selectValue,
																	'#txtXQTIP');
															// 得到照片
															showFcPic();
															// 根据选择小区带出相关信息
															// readXQinfo($("#txtXQDM").val());
														} else if ($(
																"#hidSelect")
																.val() == "JZJG") {
															selectValue = getSelectedJZJGValue();
															$("#txtJZJG")
																	.val(
																			selectValue);
															getJZJG(
																	selectValue,
																	'#txtJZJGTIP');
														} else if ($(
																"#hidSelect")
																.val() == "FWLX") {
															selectValue = getSelectedFWLXValue();
															$("#txtFWLX")
																	.val(
																			selectValue);
															getFWLX(
																	selectValue,
																	'#txtFWLXTIP');
															var szqy = $(
																	"#ddlSZQY")
																	.val();
															setParentIds(szqy);
															showYJG();
														} else if ($(
																"#hidSelect")
																.val() == "JYLX") {
															selectValue = getSelectedJYLXValue();
															$("#txtJYLX")
																	.val(
																			selectValue);
															getJYLX(
																	selectValue,
																	'#txtJYLXTIP');
															showYJG();
														} else if ($(
																"#hidSelect")
																.val() == "JZJGT") {
															selectValue = getSelectedJZJGValue();
															$("#txtJZJGT")
																	.val(
																			selectValue);
															getJZJG(
																	selectValue,
																	'#txtJZJGTTIP');
														} else if ($(
																"#hidSelect")
																.val() == "GHYTT") {
															selectValue = getSelectedGHYTValue();
															$("#txtGHYTT")
																	.val(
																			selectValue);
															getGHYT(
																	selectValue,
																	'#txtGHYTTTIP');

															showYJG();
															// getSEZL(selectValue,'#txtGHYTTTIP');
														} else if ($(
																"#hidSelect")
																.val() == "MFGJDM") {
															selectValue = getSelectedGJDMValue();
															$("#txtMFGJDM")
																	.val(
																			selectValue);
															getGJDM(
																	selectValue,
																	'#txtMFGJDMTIP');

														} else if ($(
																"#hidSelect")
																.val() == "GMFGJDM") {
															selectValue = getSelectedGJDMValue();
															$("#txtGMFGJDM")
																	.val(
																			selectValue);
															getGJDM(
																	selectValue,
																	'#txtGMFGJDMTIP');

														} else if ($(
																"#hidSelect")
																.val() == "QTXZ") {
															// 节点父id
															var parentID = getSelectedCGZKparentID();
															// 节点父Nm
															var parentNM = getSelectedCGZKparentNM();
															// 节点id
															var selectValue = getSelectedCGZKValue();
															// 节点Name
															var displayValue = getSelectedCGZKName();
															// 隐藏域（父类已选择id字符串）
															var parentQtxzs = $(
																	"#hidPARENTQTXZ")
																	.val();
															// 隐藏域（子类类已选择id字符串）
															var qtxzs = $(
																	"#hidQTXZ")
																	.val();
															// 此处为限定，在大类下只能选择一个子类
															if (qtxzs
																	.search(selectValue) == -1
																	&& parentQtxzs
																			.search(parentID) == -1) {
																$("#ddlQTXZ")
																		.append(
																				"<span class=\"qtxz\">"
																						+ parentNM
																						+ ":"
																						+ displayValue
																						+ " <a href=\"javascript:;\"  PANENTQTXZ=\""
																						+ parentID
																						+ "\" QTXZ=\""
																						+ selectValue
																						+ "\" onclick=\"qtxzClick(this);\">[删]</a></span>");
																$("#hidQTXZ")
																		.val(
																				$(
																						"#hidQTXZ")
																						.val()
																						+ selectValue
																						+ ',');
																$(
																		"#hidPARENTQTXZ")
																		.val(
																				$(
																						"#hidPARENTQTXZ")
																						.val()
																						+ parentID
																						+ ',');

															} else {
																$
																		.notifyBar({
																			html : '已选择'
																		});
															}
														}
													}
												},
												{
													text : '关闭',
													iconCls : 'icon-cancel',
													handler : function() {
														$("#dialog").dialog(
																'close');
													}
												} ]
									});

					// 房产证号判断
					// $("#txtFCZH").blur(function(){
					// var fczh = $("#txtFCZH").val();
					// if(fczh != '' && fczh != '无'){
					// isExistFczh(fczh);
					// }
					// });

					// 通过地址查询pgt00320表中的数据
					$("#sechQMSj").click(function() {
						isExistQmpg();
					});

				});

// 其它修正
function qtxzClick(obj) {
	var qtxz = $("#hidQTXZ").val();
	var selectQtxz = $(obj).attr("QTXZ") + ',';
	$("#hidQTXZ").val(qtxz.replace(selectQtxz, ''));
	$(obj).parent().remove();

	var parentqtxz = $("#hidPARENTQTXZ").val();
	var parentselectQtxz = $(obj).attr("PANENTQTXZ") + ',';
	$("#hidPARENTQTXZ").val(parentqtxz.replace(parentselectQtxz, ''));
};

// 根据所在区域设置父类型隐藏域
function setZhxz(szqy, fwlx) {
	// alert("setParentIds: "+szqy);
	var fcid;
	var DF = $("#txtDF").val();
	var CX = $("#txtCX").val();
	var CG = $("#txtCG").val();
	fcid = $("#FcidForZhxz").val();
	if (szqy == "")
		return;
	// 清空综合修正隐藏域
	cleanZhxz();
	$("#loading").show();
	var url = "ZHXZT00302.action";
	var data = {
		ddlSZQY : szqy,
		FCID : fcid,
		txtFWLX : fwlx
	};
	$.ajax({
		type : "POST",
		url : url,
		cache : false,
		data : data,
		dataType : "json",
		success : function(myMsg) {
			$("#tt1").html("");
			var data = myMsg.qtxzList;
			$.each(data,
					function(i, n) {
						if (n.qtxznm == DF) {
							n.isId = true;
						}
						if (n.qtxznm == CX) {
							n.isId = true;
						}
						if (n.qtxznm == CG) {
							n.isId = true;
						}
						addZHXZ(n.cd00053Qtxzid, n.parentId, n.qtxznm, n.isDir,
								n.isId);
					});
		},
		complete : function() {
			$("#loading").hide();
		},
		error : function() {
			$.notifyBar({
				cls : "error",
				html : '请求已发送，服务器无应答'
			});
		}
	});
}
// 根据所在区域设置父类型隐藏域
function setQMZhxz(szqy, fwlx) {
	// alert("setParentIds: "+szqy);
	var DF = $("#txtDF").val();
	var CX = $("#txtCX").val();
	var CG = $("#txtCG").val();
	var fcid = $("#FcidForZhxz").val();
	if (szqy == "")
		return;
	// 清空综合修正隐藏域
	cleanZhxz();
	$("#loading").show();
	var url = "ZHXZT00302QM.action";
	var data = {
		ddlSZQY : szqy,
		FCID : fcid,
		txtFWLX : fwlx
	};
	$.ajax({
		type : "POST",
		url : url,
		cache : false,
		data : data,
		dataType : "json",
		success : function(myMsg) {
			$("#tt1").html("");
			var data = myMsg.qtxzList;
			$.each(data,
					function(i, n) {
						if (n.qtxznm == DF) {
							n.isId = true;
						}
						if (n.qtxznm == CX) {
							n.isId = true;
						}
						if (n.qtxznm == CG) {
							n.isId = true;
						}
						addZHXZ(n.cd00053Qtxzid, n.parentId, n.qtxznm, n.isDir,
								n.isId);
					});
		},
		complete : function() {
			$("#loading").hide();
		},
		error : function() {
			$.notifyBar({
				cls : "error",
				html : '请求已发送，服务器无应答'
			});
		}
	});
}
// 判断房产证号是否存在
function isExistFczh(FCZH) {
	var url = "ISEXISTFCZH.action";
	var data = {
		FCZH : FCZH
	};

	$.ajax({
		type : "GET",
		url : url,
		cache : false,
		data : data,
		dataType : "json",
		success : function(myMsg) {
			var msg = myMsg.ISEXISTFCZH;
			var bean = myMsg.v00302Bean;
			if (msg) {
				// $.notifyBar({cls:"warning", html: '房产证号已存在，请确认！'});
				$("#ISEXISTFCZH").val(true);
				$("#txtZJHM").val(formatString(bean.zjhm));
				$("#txtNSRMC").val(formatString(bean.nsrmc));
				$("#txtZJLXNm").val(formatString(bean.zjlx));
				$("#txtZJLXId").val(formatString(bean.cd00001Zjlx));
				$("#txtLXDH").val(formatString(bean.lxdh));
				$("#txtBWJFH").val(formatString(bean.bwjfh));
				$("#txtSZLC").val(formatString(bean.szlc));
				$("#txtJZMJ").val(formatString(bean.jzmj));
				$("#txtJYJG").val(formatString(bean.jyjg));
				$("#txtJZJGTTIP").val(formatString(bean.jzjg));
				$("#txtJYLXTIP").val(formatString(bean.jylx));
				$("#txtFWLXTIP").val(formatString(bean.fwlx));
				$("#txtDJRQ").val(formatDate(bean.djrq));
				$("#txtJZJGT").val(formatString(bean.cd00001Jzjg));
				$("#txtJYLX").val(formatString(bean.cd00001Jylx));
				$("#txtFWLX").val(formatString(bean.cd00001Fwlx));
				$("#txtZCDZL").val(formatString(bean.fwtdzl));
				$("#txtBWJFH").blur();
				$("#txtZCDZL").blur();
			} else {
				$("#ISEXISTFCZH").val(false);
			}
		},
		error : function() {
			$.notifyBar({
				cls : "error",
				html : '请求已发送，服务器无应答'
			});
		}
	});
}

// 格式化部位及房号
function defineBWJFH(obj) {
	// var bwjfhLength = $(obj).val().length;
	// if(bwjfhLength == 1){
	// $(obj).val($(obj).val()+"-");
	// }
	// $(obj).val($(obj).val().toUpperCase());
}

// 根据二手房和住宅显示原价格
function showYJG() {
	// $("#divYJG").hide();
	$("#divSBPGJG").hide();
	// $("#txtSBPGJG").val(0);

	// $("#txtYJG").attr("disabled","disabled");
	// $("#txtSBPGJG").attr("disabled","disabled");
	// if(($("#txtGHYTT").val() == "01") && ($("#txtJYLX").val() == "012")){
	// $("#txtYJG").removeAttr("disabled");
	// $("#divYJG").show();
	// }
	if (($("#txtFWLX").val() == INFO_FWLX_07)) {
		$("#txtSBPGJG").removeAttr("disabled");
		$("#divSBPGJG").show();
	}
}

function subData() {

	$.ajax({
		type : 'POST',
		url : 'EDITT003711.action',
		cache : false,
		data : {
			FCIDSUB : $("#FCIDSUB").val(),
			INFOMSGSUB : $("#INFOMSGSUB").val(),
			actCount : $("#actCount").val(),
			OINSID : $("#OINSID").val()
		},
		dataType : 'json',
		success : function(resMsg) {
			if (resMsg.resSign == "warning") {
				$.notifyBar({
					cls : 'warning',
					html : resMsg.resMsg
				});
				$("#w2").window('open');
			} else if (resMsg.resSign == "success") {
				$.notifyBar({
					cls : 'success',
					html : resMsg.resMsg
				});
				t = setTimeout('showWindow()', 2000);

			} else if (resMsg.resSign == "error") {
				$.notifyBar({
					cls : 'error',
					html : resMsg.resMsg
				});
			}

		},
		error : function() {
			$.notifyBar({
				cls : 'error',
				html : '请求已发送，系统无响应'
			});
		}
	});
}

function showWindow() {
	window.location.href = "../WS00001/VIEWWS00001.jsp";
	clearTimeout(t);
}

function allCS() {
	var ywjg = -1;
	if ($("#rdoYWJG0:checked").val() == 0)
		ywjg = 0;
	if ($("#rdoYWJG1:checked").val() == 1)
		ywjg = 1;
	document.getElementById('hidFlag').value = '2';
	$("#txtMONTHFind").val($("#txtCSYF").val());
	// $("#txtXQFind").val($("#txtXQFind").val());
	// $("#txtSLIDFind").val($("txtSLIDFind").val());
	$("#txtZCDZL").val($("#txtXQCX").val());
	$("#txtFWLXCS").val($("#txtFWLX").val());
	$("#ddlSZQYCS").val($("#ddlSZQYFind").val());
	$("#txtYWJG").val(ywjg);
	AppSubmit();
}

// function gjData(fcid){
// $.ajax({
// type : "POST",
// url : "../xtwh/FINDT00351BZFCSY.action",
// dataType : "json",
// data : {
//
// txtMONTHFind : $("#txtMONTHFind").val(),
// txtYWJG : ywjg
// },
// complete:function(){
// $("#r").hide();
// },
// success: function(res){
// var beans = res.tabList;
// var sum = beans.length;
// var cntS = 0; cntF = 0;
// $.each(beans, function(i, b){
// $.ajax({
// type : "POST",
// url : "EXEV00351JSON.action",
// dataType : "json",
// data : {
// hidFlag : 1,
// chkSelTemp : b.slid,
// txtMONTHFind : $("#txtCSYF").val(),
// txtCSJYSJ : $("#txtCSJYSJ").val()
// },
// complete:function(){
// $('#p').progressbar('setValue', Math.floor(100*(cntS+cntF)/sum));
// if(cntS+cntF == sum){
// alert(测算执行完毕);
// }
// },
// success: function(data){
// cntS++;
// },
// error: function(aa,bb,cc){
// cntF++;
// //$.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
// }
// });
// });
// },
// error: function(aa,bb,cc){
// $.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
// }
// });
//	
// };

/**
 * 录入数据直接评估
 * 
 * @param fwcx
 * @param infoid
 * @param rootid
 * @param szqy
 * @return
 */
function bindInfoValue(fcid) {
	$.ajax({
		type : "GET",
		url : "../pg/EXECPG300011.action",
		cache : false,
		data : {
			hidFlag : 1,
			chkSel : fcid
		},
		dataType : "json",
		success : function(rec) {
			var bean = rec.v00302Bean;
			if (1 == bean.bResult) {
				alert("评估已通过,点击确定进行打印通知单与传入金税三期操作！");
				$('#ww').window('open');
			} else {
				alert("评估未通过,点击确定查看原因！");
				$("#wc").window("open");
			}
		},
		error : function() {
			$.notifyBar({
				cls : "error",
				html : '请求已发送，服务器无应答'
			});
		}
	});
}
/**
 * 打印通知单
 * 
 * @param fwcx
 * @param infoid
 * @param rootid
 * @param szqy
 * @return
 */
function bindInfo(fcid) {
	$.ajax({
		type : "POST",
		url : "../pg/EXECT00391.action",
		cache : false,
		data : {
			FCID : fcid
		},
		dataType : "json",
		success : function(rec) {
			// var bean= rec.bf00000List;
			// if(bean.Fcid == fcid){
			// $.messager.alert('正确信息','打印通知单成功，可以进行完税确认','error');
			// }
		},
		error : function() {
			$.notifyBar({
				cls : "error",
				html : '请求已发送，服务器无应答'
			});
		}
	});
}

function sendDJZXML(fcid) {
	$("#loading").show();
	$.ajax({
		type : "POST",
		cache : false,
		url : "../sjcj/SENDXMLI.action",
		dataType : "json",
		data : {
			FCID : fcid
		},
		complete : function() {
			$("#loading").hide();
		},
		success : function(msg) {
			if ('0' === msg.resSign) {
				$.notifyBar({
					cls : "success",
					html : "评估数据已经成功传入金三征管系统。"
				});
			} else if ('1' === msg.resSign) {
				$.messager.alert('错误信息', '与接口连接失败<br/>' + msg.SLMsg, 'error');
			} else if ('2' === msg.resSign) {
				$.messager.alert('AxisFault错误', '与接口连接失败<br/>' + msg.SLMsg,
						'error');
			} else if ('3' === msg.resSign) {
				$.messager.alert('RemoteException错误', '与接口连接失败<br/>'
						+ msg.SLMsg, 'error');
			} else {
				$.messager.alert('错误信息', msg.SLMsg, 'error');
			}
		},
		error : function() {
			$.notifyBar({
				cls : "error",
				html : '请求已发送，系统无响应'
			});
		}
	});
}

function sendPGJG(fcid) {
	$("#loading").show();
	$.ajax({
		type : "POST",
		cache : false,
		url : "../sjcj/DJZPGJGXML.action",
		dataType : "json",
		data : {
			FCID : fcid
		},
		complete : function() {
			$("#loading").hide();
		},
		success : function(msg) {
			var bean = msg.t00370Bean;
			if ('1' == msg.resSign) {
				$.messager.alert('错误信息', '与接口连接失败<br/>' + msg.SLMsg, 'error');
			} else {
				if ('0' == bean.result_code) {
					$.notifyBar({
						cls : "success",
						html : bean.result_info
					});
				} else {
					$.messager.alert('错误信息', bean.result_info, 'error');
				}
			}
		},
		error : function(msg) {
			$.notifyBar({
				cls : "error",
				html : '请求已发送，系统无响应'
			});
		}
	});
}

// 显示楼照片
function showFcPic() {
	var lh = $("#txtLH").val();
	var xqdm = $("#txtXQDM").val();
	if (lh == "" || xqdm == "") {
		$("#FcPic").html("");
	} else {
		$("#loading").show();
		$.ajax({
			type : "POST",
			cache : false,
			url : "../xtwh/FINDT00306FByDz.action",
			dataType : "json",
			data : {
				LH : lh,
				txtXQDM : xqdm
			},
			complete : function() {
				$("#loading").hide();
			},
			success : function(msg) {
				var data = msg.tabList;
				var img = '';
				$.each(data, function(i, n) {
					img = img + '<div><img src="' + n.zplj + '" /></div>';
				});
				$("#FcPic").html(img);
			},
			error : function() {
				$("#FcPic").html("");
			}
		});
	}
}

function showWin(value) {
	Show("../pg/FINDSCPGNGMX.action?txtSWIDFind=" + value, 330, 400, value);
}

/*
 * function sendDJZXML(zcdzl){ $.ajax({ type : "POST", cache : false, url :
 * "../sjcj/FindPgtgSJ.action", dataType : "json", data : { txtZCDZL : zcdzl },
 * success : function(msg){ var bean = msg.t00370Bean; if (msg.resSign == '1') {
 * $.messager.alert('错误信息','与接口连接失败','error'); } else { if(bean.result_code ==
 * '0'){ //$.notifyBar({cls: "success", html: bean.result_info});
 * sendPGJG(fcid); }else{ $.messager.alert('错误信息',bean.result_info,'error'); } } },
 * error : function(){ $.notifyBar({cls: "error", html: '请求已发送，系统无响应'}); } }); }
 */

// 判断全面评估数据是否存在
function serchQmpgByFcid(fcid) {
	$("#xmpg").dialog('close');
	var url = "../ajax/FINDT00320AJAX.action";
	var data = {
		FCID : fcid
	};
	$.ajax({
		type : "POST",
		url : url,
		cache : false,
		data : data,
		dataType : "json",
		success : function(myMsg) {

			var bean = myMsg.v00320Bean;
			$("#isExistQmpg").val(1);
			// $("#isExistZT").val(true);
			$("#FcidForZhxz").val(formatString(bean.fcid));
			// $("#txtFCZH").val(formatString(bean.fczh));
			$("#txtZJLXNm").val(formatString(bean.zjlx));
			$("#txtZJLXId").val(formatString(bean.cd00001Zjlx));
			// $("#txtLXDH").val(formatString(bean.lxdh));
			$("#txtBWJFH").val(formatString(bean.bwjfh));
			$("#txtSZLC").val(formatString(bean.szlc));
			$("#txtJZMJ").val(formatString(bean.jzmj));
			// $("#txtJYJG").val(formatString(bean.jyjg));
			$("#txtJZJGTTIP").val(formatString(bean.jzjg));
			$("#txtJYLXTIP").val(formatString(bean.jylx));
			$("#txtFWLXTIP").val(formatString(bean.fwlx));
			// $("#txtDJRQ").val(formatDate(bean.djrq));
			$("#txtJZJGT").val(formatString(bean.cd00001Jzjg));
			$("#txtJYLX").val(formatString(bean.cd00001jylx));
			$("#txtFWLX").val(formatString(bean.cd00001Fwlx));
			$("#txtZCDZL").val(formatString(bean.zcdzl));
			$("#txtZJHM").val(formatString(bean.zjhm));
			// $("#txtNSRMC").val(formatString(bean.nsrmc));

			$("#txtXQTIP").val(formatString(bean.xqnm));
			$("#txtXQDM").val(formatString(bean.cd00352Xqdm));
			$("#txtGHYTTTIP").val(formatString(bean.ghyt));
			$("#txtGHYTT").val(formatString(bean.cd00001Ghyt));
			$("#txtJCSJ").val(formatString(bean.jcnf));
			$("#txtZLC").val(formatString(bean.zlc));
			$("#txtCLH").val(formatString(bean.clh));
			$("#txtBWJFH").val(formatString(bean.fh));
			// $("#txtSBPGJG").val(formatString(bean.pgjg));
			// 读取最新的评估结果
			$.each(bean.outList, function(i, b) {
				$("#txtSBPGJG").val(formatString(b.pgjg));
				return false;
			});
			$("#SZQYNM").val(formatString(bean.szqy));
			$("#SZQYDM").val(formatString(bean.cd00001Szqy));

			setParentIdsQM($("#ddlSZQY").val());
			showYJG();
			clock();

		},
		error : function() {
			$.notifyBar({
				cls : "error",
				html : '请求已发送，服务器无应答'
			});
		}
	});
}

/**
 * 
 */
function isExistQmpg() {
	var zt = $("#sechQMSj").attr("value");
	if (zt == "查询") {
		/*
		 * var url = "../ajax/ISEXISTQMPGQuery.action"; var data = {
		 * ddlSZQYFind:$("#ddlSZQY").val(), zcdzl:$("#txtZCDZL").val(),
		 * txtLH:$("#txtLH").val(), txtDYH:$("#txtDyh").val(),
		 * txtFH:$("#txtBWJFH").val() }; $.ajax({ type: "POST", url: url, cache:
		 * false, data: data, dataType: "json", success: function(myMsg){ var
		 * bean=myMsg.tabList; if(bean==null || bean.length==0) {
		 * $.notifyBar({cls:"error", html: '没有查到相关数据'}); } // if(bean.length==1) // { //
		 * serchQmpgByFcid(bean[0].fcid); // } if (bean.length>=1) {
		 */
		$("#qmpg").attr(
				"src",
				"../ajax/ISEXISTQMPG.action?ddlSZQYFind="
						+ encodeURI($("#ddlSZQY").val()) + "&zcdzl="
						+ encodeURI($("#txtZCDZL").val()) + "&txtLH="
						+ encodeURI($("#txtLH").val()) + "&txtDYH="
						+ encodeURI($("#txtDyh").val()) + "&txtFH="
						+ encodeURI($("#txtBWJFH").val()));
		$("#xmpg").dialog('open');
		/*
		 * } }, error: function(){ $.notifyBar({cls:"error", html:
		 * '请求已发送，服务器无应答'}); }
		 * 
		 * });
		 */
	} else {
		unclock();
	}
}

function clock() {
	$("#txtZLC").attr("readonly", "readonly");
	$("#txtBWJFH").attr("readonly", "readonly");
	$("#txtSZLC").attr("readonly", "readonly");
	$("#txtJZMJ").attr("readonly", "readonly");
	// $("#txtJYJG").attr("disabled","disabled");
	$("#txtJZJGTTIP").attr("readonly", "readonly");
	// $("#txtJYLXTIP").attr("disabled","disabled");
	$("#txtFWLXTIP").attr("readonly", "readonly");
	// $("#txtDJRQ").attr("disabled","disabled");
	$("#txtJZJGT").attr("readonly", "readonly");
	// $("#txtJYLX").attr("disabled","disabled");
	$("#txtFWLX").attr("readonly", "readonly");
	$("#txtZCDZL").attr("readonly", "readonly");
	// $("#txtNSRMC").attr("disabled","disabled");
	// $("#txtLXDH").attr("disabled","disabled");
	$("#txtXQTIP").attr("readonly", "readonly");
	$("#txtXQDM").attr("readonly", "readonly");
	$("#txtGHYTTTIP").attr("readonly", "readonly");
	$("#txtGHYTT").attr("readonly", "readonly");
	$("#txtJCSJ").attr("readonly", "readonly");
	$("#txtZLC").attr("readonly", "readonly");
	$("#txtCLH").attr("readonly", "readonly");
	$("#txtBWJFH").attr("readonly", "readonly");
	$("#txtSBPGJG").attr("readonly", "readonly");
	// $("#txtXQCX").attr("disable","readonly");
	$("#txtLH").attr("readonly", "readonly");
	$("#txtDyh").attr("readonly", "readonly");
	$("#txtBWJFH").attr("readonly", "readonly");
	$("#ddlSZQY").attr("readonly", "readonly");
	$("#SZQYNM").attr("readonly", "readonly");

	$("#isClocktZT").val(1);
	$("#sechQMSj").attr("value", "解锁");
	$("#divszqy").hide();

	$("#divszqyLable").show();
}

function unclock() {
	$("#txtZLC").attr("readonly", "");
	$("#txtBWJFH").attr("readonly", "");
	$("#txtSZLC").attr("readonly", "");
	$("#txtJZMJ").attr("readonly", "");
	// $("#txtJYJG").attr("disabled","");
	$("#txtJZJGTTIP").attr("readonly", "");
	$("#txtJYLXTIP").attr("readonly", "");
	$("#txtFWLXTIP").attr("readonly", "");
	// $("#txtDJRQ").attr("disabled","");
	$("#txtJZJGT").attr("readonly", "");
	$("#txtJYLX").attr("readonly", "");
	$("#txtFWLX").attr("readonly", "");
	$("#txtZCDZL").attr("readonly", "");
	// $("#txtNSRMC").attr("disabled","");
	// $("#txtLXDH").attr("disabled","");
	$("#txtXQTIP").attr("readonly", "");
	$("#txtXQDM").attr("readonly", "");
	$("#txtGHYTTTIP").attr("readonly", "");
	$("#txtGHYTT").attr("readonly", "");
	$("#txtJCSJ").attr("readonly", "");
	$("#txtZLC").attr("readonly", "");
	$("#txtCLH").attr("readonly", "");
	$("#txtBWJFH").attr("readonly", "");
	$("#txtSBPGJG").attr("readonly", "");

	$("#txtLH").attr("readonly", "");
	$("#txtDyh").attr("readonly", "");
	$("#txtBWJFH").attr("readonly", "");
	$("#ddlSZQY").attr("readonly", "");
	// $("#txtXQCX").attr("readonly","");
	$("#SZQYNM").attr("readonly", "");

	$("#isClocktZT").val(0);
	$("#sechQMSj").attr("value", "查询");
	$("#isExistQmpg").val(0);
	$("#divszqy").show();
	$("#divszqyLable").hide();
}

/**
 * 房屋坐落失焦调用（采集添加与删除时通用）
 */
function blurZCDZL() {
	$("#loading").show();
	$.ajax({
		type : 'POST',
		cache : false,
		url : '../xtwh/AUTO00306.action',
		data : {
			txtNOTE : $("#txtZCDZL").val(),
			txtCLH : $("#txtCLH").val()
		},
		dataType : 'json',
		complete : function() {
			$("#loading").hide();
		},
		success : function(msg) {
			var bean = msg.v00306Bean;
			if (msg.resSign == "1") {
				var lfdz = bean.note;
				var lh = bean.lh;
				var xqdm = bean.cd00352Xqdm;
				var szqy = bean.cd00001Szqy;
				// 赋值
				if (checkIsNotEmpty(lfdz)) {
					$("#txtZCDZL").val(lfdz);
					// 赋值后，清除水印效果
					$("#txtZCDZL").attr("watermark", "");
				}
				if (checkIsNotEmpty(lh))
					$("#txtLH").val(lh);
				if (checkIsNotEmpty(szqy))
					$("#ddlSZQY").val(szqy);
				if (checkIsNotEmpty(xqdm)) {
					$("#txtXQDM").val(xqdm);
					getXQ($("#ddlSZQY").val(), xqdm, '#txtXQTIP');
				}
				// 加载图片
				showFcPic();
			} else if (msg.resSign == "0") {
				$.notifyBar({
					cls : "error",
					html : msg.resMsg
				});
			}
		},
		error : function() {
			$.notifyBar({
				cls : "error",
				html : '请求已发送，服务器无应答'
			});
		}
	});
}

function clhblur() {
	var clh = $("#txtCLH").val();
	if (clh == "") {
		$("#txtCLH").attr("BAT", "");
		return;
	}
	var clhbat = $("#txtCLH").attr("BAT");
	if (clhbat == clh) {
		return;
	}
	$("#txtCLH").attr("BAT", clh);
	blurZCDZL();

}

/**
 * (株洲专用)根据“所在区域”，“测量号”打开房产GIS
 */
function openMap() {
	var clh = $("#txtCLH").val();
	if (null != clh && "" != clh) {
		Show("http://149.72.16.211:8081/zzfcds/index.html?dids=" + clh, 600,
				800, "mapWin");
	} else {
		$.notifyBar({
			cls : "error",
			html : "请输入房产测量号！"
		});
	}

}
/**
 * 转让方【纳税识别号】
 */
function findZRFSBH() {
	// alert('转让方【纳税识别号】');

	/*
	 * 一、如果证件类型是01身份证 1、验证纳税人名称 、证件号码 为 必须输入 2、用【税人名称
	 * 、证件号码、证件类型】去金三验证是否进行间接登记，如果没登记就进行间接登记（webservice访问）
	 * 3、webservice返回纳税识别号填入txtZRFSBH
	 * 
	 * 二、如果证件类型是14企业代码 1、根据纳税人提供的纳税识别号去金三提取信息由前台人员进行判断 2、如果前台人员确认该纳税识别号可以交易，
	 * 即把纳税识别号填入txtZRFSBH
	 * 
	 */
	if (checkIsNotEmpty($("#txtZRFSBH").val())) {
		$.messager.confirm('系统提示', '您确定要取消重新验证吗?', function(r) {
			if (r) {
				$("#txtZRFSBH").val("");
				chkZRFSBH();
			}
		});

		return;
	}
	var nsrmc = $("#txtNSRMC").val();
	var swid = $("#txtZJHM").val();
	var zjlxid = $("#txtZJLXId").val();
	var gjdm = $("#txtMFGJDM").val();
	

	if (!checkIsNotEmpty(nsrmc) || !checkIsNotEmpty(swid) || !checkIsNotEmpty(zjlxid) || !checkIsNotEmpty(gjdm)) {
		$.messager.alert('错误信息', '国籍/地区、转让方名称、证件号码、证件类型必须输入！', 'error');
		return;
	}
	
	if ($("#rdoZRFNSRLX0:checked").val() == 0){
		// 个人
		getGRSBH(1, nsrmc, swid, zjlxid, gjdm);
	} else {
		// 企业
		getQYZRFSBH();
	}
}

/**
 * 承受方【纳税识别号】
 */
function findCSFSBH() {
	// alert('承受方【纳税识别号】');

	/*
	 * 业务同上
	 * 
	 */
	if (checkIsNotEmpty($("#txtCSFSBH").val())) {
		$.messager.confirm('系统提示', '您确定要取消重新验证吗?', function(r) {
			if (r) {
				$("#txtCSFSBH").val("");
				chkCSFSBH();
			}
		});

		return;
	}
	var nsrmc = $("#txtCSFNSRMC").val();
	var swid = $("#txtCSFZJHM").val();
	var zjlxid = $("#txtCSFZJLX").val();
	var gjdm = $("#txtGMFGJDM").val();

	if (!checkIsNotEmpty(nsrmc) || !checkIsNotEmpty(swid)
			|| !checkIsNotEmpty(zjlxid) || !checkIsNotEmpty(gjdm)) {
		$.messager.alert('错误信息', '国籍/地区、承受方名称、证件号码、证件类型必须输入！', 'error');
		return;
	}

	if ($("#rdoCSFNSRLX0:checked").val() == 0){
		getGRSBH(2, nsrmc, swid, zjlxid, gjdm);
	} else {
		getQYCSFSBH();
	}
}

// 得到个人纳税识别号
// ifzsf代表1.是转让方，2是承受方
function getGRSBH(ifzsf, nsrmc, swid, zjlxid, gjdm) {
	$("#loading").show();
	if (ifzsf == 1) {
		$("#txtZRFSBH").val("");
	} else {
		$("#txtCSFSBH").val("");
	}

	$.ajax({
		type : 'POST',
		cache : false,
		url : '../wbjh/queryGsZrr.action',// 需要修改的
		data : {
			txtNSRMC : nsrmc,
			txtZJHM : swid,
			txtZJLX : zjlxid,
			txtGJDM : gjdm
		},
		dataType : 'json',
		complete : function() {
			$("#loading").hide();
			if (ifzsf == 1) {
				chkZRFSBH();
			} else {
				chkCSFSBH();
			}
		},
		success : function(msg) {
			var value = msg.txtSBH;
			
			//XML提示信息
			var msgCod = msg.xmlErrCod;
			var msgTxt = msg.xmlErrMsg;
			if("0000"==msgCod){
				if (ifzsf == 1) {
					$("#txtZRFSBH").val(value);
				} else {
					$("#txtCSFSBH").val(value);
				}
				$.messager.show({title:'金三接口提示', msg: '纳税人识别号验证成功！'});					
			}else{
				$.messager.alert('金三接口提示', '错误代码：'+msgCod+'<br/>错误内容：'+msgTxt, 'warning');
			}
		},
		error : function() {
			$.notifyBar({
				cls : "error",
				html : '请求已发送，服务器无应答'
			});
		}
	});
}

// 得到企业纳税识别号
function getQYZRFSBH() {
	$("#divsbh").window("open");
	setQYSBHview(1);

}

function getQYCSFSBH() {
	$("#divsbh").window("open");
	setQYSBHview(2);
}
// 验证企业纳税识别号
function findQYSBH() {
	var sbh = $("#txtQYSBH").val();
	if (!checkIsNotEmpty(sbh)) {
		$.messager.alert('错误信息', '请输入纳税人识别号！', 'error');
		return;
	}
	$('#test').datagrid('options').url = '../wbjh/queryGsQyxx.do';
	$('#test').datagrid('options').queryParams = {
		txtSBH : sbh
	};
	$('#test').datagrid('reload');
	$("#lkQYOK").attr("QYSBH", sbh);
}

function chkZRFSBH() {
	// 不为空的话。清空纳税识别号
	if (!checkIsNotEmpty($("#txtZRFSBH").val())) {
		$("#txtNSRMC").removeAttr("readonly");
		$("#txtZJHM").removeAttr("readonly");
		$("#txtZJLXNm").removeAttr("readonly");
		$("#spZJLX").show();
		$("#lkZRFSBH").text("验证");
		$("#txtZRFSBH").val("");
	} else {
		$("#txtNSRMC").attr("readonly", "readonly");
		$("#txtZJHM").attr("readonly", "readonly");
		$("#txtZJLXNm").attr("readonly", "readonly");
		$("#spZJLX").hide();
		$("#lkZRFSBH").text("取消");
	}
}

function chkCSFSBH() {
	// 不为空的话。清空纳税识别号
	if (!checkIsNotEmpty($("#txtCSFSBH").val())) {
		$("#txtCSFNSRMC").removeAttr("readonly");
		$("#txtCSFZJHM").removeAttr("readonly");
		$("#txtCSFZJLXNm").removeAttr("readonly");
		$("#spCSFZJLX").show();
		$("#lkCSFSBH").text("验证");
		$("#txtCSFSBH").val("");
	} else {
		$("#txtCSFNSRMC").attr("readonly", "readonly");
		$("#txtCSFZJHM").attr("readonly", "readonly");
		$("#txtCSFZJLXNm").attr("readonly", "readonly");
		$("#spCSFZJLX").hide();
		$("#lkCSFSBH").text("取消");
	}
}

// 初始化企业查询列表
// ifzsf代表1.是转让方，2是承受方
function setQYSBHview(ifzsf) {
	$("#lkQYOK").attr("IFZSF", ifzsf);
	$("#txtQYSBH").val("");
	$('#test').datagrid({
		striped : true,
		height : 300,
		url : '',
		sortOrder : 'desc',
		onDblClickRow : function(rowIndex, rowData) {
			var ifzsf = $("#lkQYOK").attr("IFZSF");
			if (ifzsf == "1") {
				var zrfsbh = $("#txtZRFSBH").val();
				if (zrfsbh == "") {
					$("#txtZRFSBH").val(rowData.nsrsbh);
				} else {
					$("#txtZRFSBH").val(zrfsbh + "、" + rowData.nsrsbh);
				}
				chkZRFSBH();
			} else {
				var csfsbh = $("#txtCSFSBH").val();
				if (csfsbh == "") {
					$("#txtCSFSBH").val(rowData.nsrsbh);
				} else {
					$("#txtCSFSBH").val(csfsbh + "、" + rowData.nsrsbh);
				}
				chkCSFSBH();
			}
			$.messager.alert('提示信息', '纳税人识别号添加成功！', 'info');
			// 双击关闭窗体
			// $("#divsbh").dialog('close');
		},
		onLoadError : function() {
			$.messager.alert('错误信息', '请求已发送，服务器无应答！', 'error');
		},
		queryParams : {},
		columns : [ [ {
			title : '纳税人状态',
			field : 'nsrzt',
			width : 70
		}, {
			title : '组织机构代码',
			field : 'zzjgdm',
			width : 100
		}, {
			title : '纳税人名称',
			field : 'nsrmc',
			width : 200
		}, {
			title : '主管税务机关',
			field : 'zgswjg',
			width : 100
		}, {
			title : '主管税务所（科、分局）',
			field : 'zgsws',
			width : 100
		}, {
			title : '纳税人识别号',
			field : 'nsrsbh',
			width : 100
		}, {
			title : '法定代表人姓名',
			field : 'fddbr',
			width : 100
		}, {
			title : '法定代表人（负责人、业主）身份证件种类',
			field : 'frzjlx',
			width : 120
		}, {
			title : '法定代表人（负责人、业主）身份证件号码',
			field : 'frzjhm',
			width : 120
		}, {
			title : '生产经营地址',
			field : 'scjydz',
			width : 100
		}, {
			title : '经营范围',
			field : 'jyfw',
			width : 100
		}, {
			title : '注册地址',
			field : 'zcdz',
			width : 100
		} ] ],
		rownumbers : true
	});
}
