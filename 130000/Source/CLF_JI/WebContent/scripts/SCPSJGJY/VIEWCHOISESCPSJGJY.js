$(document).ready(function() {
	
	
	//清空数据
	$("#btnDel").click(function(){
		ClearPSJGJY();
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
								if ($("#hidSelect").val() == 'JZJG') {
									selectValue = getSelectedJZJGValue();
									$("#txtJZJGFind").val(selectValue);
									getJZJG(selectValue,'#txtJZJGTIP');
								}else if($("#hidSelect").val() == 'FWLX'){
									selectValue = getSelectedFWLXValue();
									$("#txtFWLXFind").val(selectValue);
									getFWLX(selectValue,'#txtFWLXTIP');
								}else if($("#hidSelect").val() == 'XQMC'){
									var szqy = $("#ddlSZQYFind").val();
									selectValue = getSelectedXQValue();
									$("#txtXQFind").val(selectValue);
									getXQ(szqy, selectValue, '#txtXQTIP');
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
	//建筑结构
	$("#txtJZJGFind").blur(function(){
		var infoID = $("#txtJZJGFind").val();
		getJZJG(infoID,'#txtJZJGTIP');
	});
	
	$("#btnJZJG").click(function(){
		$("#hidSelect").val('JZJG');
		var infoID = $("#txtJZJGFind").val();
		openJZJGDialog(infoID,"#infoTreeDIV");
	});
	
	//小区名称
	$("#txtXQFind").blur(function() {
		var xqdm = $("#txtXQFind").val();
		if (xqdm == null || xqdm == "") {
			$("#txtXQTIP").val("");
		} else {
			var szqy = $("#ddlSZQYFind").val();
			if (szqy == null || szqy == "") {
				alert('请先选择所在区域！');
				return;
			}
			getXQ(szqy, xqdm, '#txtXQTIP');
		}
	});

	$("#btnXQ").click(function(){
		$("#hidSelect").val("XQMC");
		var szqy = $("#ddlSZQYFind").val();
		if (szqy == null || szqy == "") {
			alert('请先选择所在区域！');
			return;
		}
		var infoID = $("#txtXQFind").val();
		openXQMCDialog(szqy, infoID, '#infoTreeDIV');
	});
	
	// 房屋类型
	$("#txtFWLXFind").blur(function(){
		var infoID = $("#txtFWLXFind").val();
		if (infoID == null || infoID == "") {
			$("#txtFWLXTIP").val("");
		} else {
			getFWLX(infoID, '#txtFWLXTIP');
		}
	});
	$("#btnFWLX").click(function(){
		$("#hidSelect").val("FWLX");
		var infoID = $("#txtFWLXFind").val();
		openFWLXDialog(infoID, '#infoTreeDIV');		
		
	});
	
});

function BindData(){
	$("#loading").ajaxStart(
        function()
        {
         $("#loading").show();
        }
    );
	var url = "FINDSCPSJGJYCHOISE.action";
	var data = {txtSwidFind : $("#txtSwidFind").val(),
				pageIndex : $("#pageindex").val(),
				txtNsrmcFind : $("#txtNsrmcFind").val(),
				txtXQDMFind : $("#txtXQFind").val(),
				txtFWLXFind : $("#txtFWLXFind").val(),
				txtJZJGFind : $("#txtJZJGFind").val(),
				txtJcnfbgnFind : $("#txtJcnfbgnFind").val(),
				txtJcnfendFind : $("#txtJcnfendFind").val()
				};
	$.ajax({
		   type: "GET",
		   url: url,
		   cache: false,
		   data: data,
		   dataType: "json",
		   complete:function()                                                    
           {
				$("#loading").hide();
           },
		   success: function(msg){
		     var data = msg.v00310List;
		     var row = $("#rowtemplate").clone();
		     $("#divShow").html("");
		     row.appendTo("#divShow");
             $.each(data, function(i, n){ 
            	var tmprow = row.clone();
            	tmprow.attr("id","");
            	tmprow.find("#no").text(formatString(n.recordIndex));
            	tmprow.find("#swid").html("<a href=javascript:Show(\'../sjcj/DETAILT00301.action?SWID=" + n.cd00301Swid + "\',300,420,'市场法登记详细信息'); title='点击查看详细信息' >" + n.cd00301Swid + "</a>");  
           	 	tmprow.find("#fcid").html("<a href=javascript:Show(\'../sjcj/DETAILT00302.action?FCID=" + n.cd00302Fcid + "\',300,420,'市场法房产详细信息'); title='点击查看详细信息' >" + n.cd00302Fcid + "</a>");
            	tmprow.find("#nsrmc").text(formatString(n.nsrmc));
            	tmprow.find("#xqmc").text(formatString(n.xqnm));
				tmprow.find("#fwlx").text(formatString(n.fwlx));
				tmprow.find("#jylx").text(formatString(n.jylx));
				tmprow.find("#jzjg").text(formatString(n.jzjg));
				if(n.ywdt)
           		 tmprow.find("#ywdt").text($("#chkTrue").val());
				else
           		 tmprow.find("#ywdt").text($("#chkFalse").val());
				tmprow.find("#zlc").text(formatString(n.zlc));
				tmprow.find("#jzmj").text(formatNumber(n.jzmj,'#,##0.00'));
				tmprow.find("#fwcx").text(formatString(n.fwcx));
				tmprow.find("#cgzk").text(formatString(n.cgzk));
				tmprow.find("#szlc").text(formatString(n.szlc));
            	tmprow.find("#pgjg").text('￥'+formatNumber(n.pgjg,'#,##0.00'));
            	tmprow.find("#pssd").text(formatString(n.cd00002Pssd));
            	tmprow.find("#jyjg").text('￥'+formatNumber(n.jyjg,'#,##0.00'));
            	tmprow.find("#dtgj").text('￥'+formatNumber(n.dtgj,'#,##0.00'));
            	tmprow.find("#rjl").text(formatNumber(n.rjl,'#,##0.00'));
            	tmprow.find("#jysj").text(formatDate(n.jysj));
           	 	tmprow.find("#upddate").text(formatDateTime(n.upddate));
				tmprow.find("#czr").text(formatString(n.czr));
				tmprow.find("#note").text(formatString(n.note));
				
            	tmprow.appendTo("#divShow");//添加到模板的容器中    
            	tmprow=null;
               });             
             row=null;
             $("#pageindex").val(msg.pageIndex);
             $("#pagecount").text(msg.pageCount);
             $("#rowcount").text(msg.rowCount);
             SetButtonState();
		   },
		   error: function(){
			   $("#loading").hide();
			   $.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
		   }
	});	
}

/**
 * 清空估价结果检验
 * @param cjid
 * @return
 */
function ClearPSJGJY(){
	var flag = confirm("确定要清空吗?");
	if (flag) {
		$.ajax({
			   type: "GET",
			   url: "CLEARPSJGJYSC.action",
			   dataType: "json",
			   complete:function()                                                    
			   {
					$("#loading").hide();
			   },
			   success: function(msg){
			     var data = msg.isDel;
			     if (data) {
			    	 alert('清空成功！');
			    	 BindData(); 
				}
			   },
			   error: function(){
				   $("#loading").hide();
				   $.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
			   }
		});	
	}
	
}