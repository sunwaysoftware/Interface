$(document).ready(function() {
	

	$("#ddlSZQYFind").change(function(){
		$("#txtXQFind").val('');
		$("#txtXQTIP").val('');
	});
	
	$("#spXQDM").click(function(){
		var szqy = $("#ddlSZQYFind").val();
		if (szqy == null || szqy == "") {
			$.notifyBar({html: '请先选择所在区域' });
			$("#ddlSZQYFind").focus();
			return;
		}
		$("#hidSelect").val("XQ");
		var infoID = $("#txtXQFind").val();
		openXQMCDialog(szqy, infoID, '#infoTreeDIV');
	});
	
	// 房屋类型
	$("#spFWLX").click(function(){
		$("#hidSelect").val("FWLX");
		var infoID = $("#txtFWLXFind").val();
		openFWLXDialog(infoID, '#infoTreeDIV');
	});
	
	// 建筑结构
	$("#spJZJG").click(function(){
		$("#hidSelect").val("JZJG");
		var infoID = $("#txtJZJGFind").val();
		openJZJGDialog(infoID, '#infoTreeDIV');
	});
	
	$("#dialog").dialog({
		modal: true,
        shadow: true,
        closed: true,
	       buttons:[{
				text:'选择',
				iconCls:'icon-ok',
				handler:function(){
	    	   $("#dialog").dialog("close");
							var selectValue;
								if ($("#hidSelect").val() == "XQ") {
									var szqy = $("#ddlSZQYFind").val();
									var selectValue = getSelectedXQValue();
									$("#txtXQFind").val(selectValue);
									getXQ(szqy, selectValue, '#txtXQTIP');
								} else if ($("#hidSelect").val() == 'JZJG') {
									selectValue = getSelectedJZJGValue();
									$("#txtJZJGFind").val(selectValue);
									getJZJG(selectValue,'#txtJZJGNm');
								}else if($("#hidSelect").val() == 'FWLX'){
									selectValue = getSelectedFWLXValue();
									$("#txtFWLXFind").val(selectValue);
									getFWLX(selectValue,'#txtFWLXNm');
								}
						}
	               },{
	   				text:'关闭',
					iconCls:'icon-cancel',
					handler:function(){
						$("#dialog").dialog('close');
					}
				}]
			});

});

//function BindData(){
//	$("#loading").ajaxStart(
//        function()
//        {
//         $("#loading").show();
//        }
//    );
//	var url = "FINDSCPSJGJY.action";
//	var data = {txtSwidFind : $("#txtSWIDFind").val(),
//				pageIndex : $("#pageindex").val(),
//				txtNsrmcFind : $("#txtNSRMCFind").val(),
//				ddlSZQYFind : $("#ddlSZQYFind").val(),
//				txtXQDMFind : $("#txtXQFind").val(),
//				txtFWLXFind : $("#txtFWLXFind").val(),
//				txtJZJGFind : $("#txtJZJGFind").val(),
//				txtJcnfbgnFind : $("#txtJYSJMINFind").val(),
//				txtJcnfendFind : $("#txtJYSJMAXFind").val(),
//				txtJZMJMINFind : $("#txtJZMJMINFind").val(),
//				txtJZMJMAXFind : $("#txtJZMJMAXFind").val()
//				};
//	$.ajax({
//		   type: "POST",
//		   url: url,
//		   cache: false,
//		   data: data,
//		   dataType: "json",
//		   complete:function()                                                    
//           {
//				$("#loading").hide();
//           },
//		   success: function(msg){
//		     var data = msg.v003314List;
//		     var row = $("#rowtemplate").clone();
//		     $("#divShow").html("");
//		     row.appendTo("#divShow");
//             $.each(data, function(i, n){ 
//            	var tmprow = row.clone();
//            	tmprow.attr("id","");
//            	tmprow.find("#no").text(formatString(n.recordIndex));
//            	tmprow.find("#fcid").html("<a href=javascript:Show(\'../sjcj/DETAILT00302.action?FCID=" + n.cd00302Fcid + "\',300,420,'市场法房产详细信息'); title='点击查看详细信息' >" + n.cd00302Fcid + "</a>");
//            	tmprow.find("#swid").html("<a href=javascript:Show(\'../sjcj/DETAILT00301.action?SWID=" + n.cd00301Swid + "\',300,420,'市场法登记详细信息'); title='点击查看详细信息' >" + n.cd00301Swid + "</a>");
//            	tmprow.find("#nsrmc").text(formatString(n.nsrmc));
//            	tmprow.find("#jyjg").text('￥'+formatNumber(n.pgjg,'#,##0.00'));
//            	tmprow.find("#pssd").text(formatString(n.cd00002Pssdy));
//            	tmprow.find("#pfmjg").text('￥'+formatNumber(n.pfmjg,'#,##0.00'));
//            	tmprow.find("#jysj").text(formatDate(n.jysj));
//            	tmprow.find("#xqnm").text(formatString(n.xqnm));
//            	tmprow.find("#fwlx").text(formatString(n.fwlx));
//            	tmprow.find("#jylx").text(formatString(n.jylx));
//            	tmprow.find("#jzjg").text(formatString(n.jzjg));
//            	tmprow.find("#szlc").text(formatString(n.szlc));
//            	tmprow.find("#zlc").text(formatString(n.zlc));
//            	tmprow.find("#jzmj").text(formatNumber(n.jzmj,'#,##0.00'));
//            	tmprow.find("#gapsjg").text('￥'+formatNumber(n.gbpgjg,'#,##0.00'));
//            	tmprow.find("#scpsjg").text('￥'+formatNumber(n.scpgjg,'#,##0.00'));
//            	tmprow.find("#scpsczr").text(formatString(n.scpgczr));	
//            	tmprow.find("#upddate").text(formatDateTime(n.upddate));
//				tmprow.find("#czr").text(formatString(n.czr));
//				tmprow.find("#note").text(formatString(n.note));
//			
//            	tmprow.appendTo("#divShow");//添加到模板的容器中    
//            	tmprow=null;
//               });             
//             row=null;
//             $("#pageindex").val(msg.pageIndex);
//             $("#pagecount").text(msg.pageCount);
//             $("#rowcount").text(msg.rowCount);
//             SetButtonState();
//		   },
//		   error: function(){
//			   $("#loading").hide();
//			   $.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
//		   }
//	});	
//}