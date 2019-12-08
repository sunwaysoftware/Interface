$(document).ready(function() {
	
	
	//FROM验证信息
	$("#editForm").validate({
		rules: {
			ddlSZQY: {required: true},
			txtPSSD: {required: true},
			txtGPQZ: {required: true, number: true},
			txtGPXF: {required: true, number: true}
			}
	});
	
	// 所在区域
	$("#ddlSZQY").change(function(){
		$("#txtXQMC").val('');
		$("#txtXQMCNM").val('');
	});	
	
	// 小区代码
	$("#spXQMC").click(function(){
		var szqy = $("#ddlSZQY").val();
		if (szqy == null || szqy == "") {
			$.notifyBar({html: '请先选择所在区域' });
			$("#ddlSZQY").focus();
		} else {
			$("#hidSelect").val("XQ");
			var xqdm = $("#txtXQMC").val();
			openXQMCDialog(szqy, xqdm, '#infoTreeDIV');
		}
	});
	
	// 房屋类型
	$("#spFWLX").click(function(){
		$("#hidSelect").val("FWLX");
		var infoID = $("#txtFWLX").val();
		openFWLXDialog(infoID, '#infoTreeDIV');
	});

	// 交易类型
	$("#spJYLX").click(function(){
		$("#hidSelect").val("JYLX");
		var infoID = $("#txtJYLX").val();
		openJYLXDialog(infoID, '#infoTreeDIV');
	});

	// 建筑结构
	$("#spJZJG").click(function(){
		$("#hidSelect").val("JZJG");
		var infoID = $("#txtJZJG").val();
		openJZJGDialog(infoID, '#infoTreeDIV');
	});
	
	//弹出对话框
	$("#dialog").dialog({
		modal: true,
        shadow: true,
        closed: true,
	       buttons:[{
				text:'选择',
				iconCls:'icon-ok',
				handler:function(){ 
            	if ($("#hidSelect").val() != "QTXZ")
            		$("#dialog").dialog("close");
				var selectValue;
				if ($("#hidSelect").val() == "XQ") {
					var szqy = $("#ddlSZQY").val();
					selectValue = getSelectedXQValue();
					$("#txtXQMC").val(selectValue);
					getXQ(szqy, selectValue, '#txtXQMCNM');
				} else if ($("#hidSelect").val() == "JZJG") {
					selectValue = getSelectedJZJGValue();
					$("#txtJZJG").val(selectValue);
					getJZJG(selectValue,'#txtJZJGNM');
				} else if ($("#hidSelect").val() == "FWLX") {
					selectValue = getSelectedFWLXValue();
					$("#txtFWLX").val(selectValue);
					getFWLX(selectValue, '#txtFWLXNM');
				} else if ($("#hidSelect").val() == "JYLX") {
					selectValue = getSelectedJYLXValue();
					$("#txtJYLX").val(selectValue);
					getJYLX(selectValue,'#txtJYLXNM');
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

	//查询
	$("#btnSearch").click(function(){
		if ($("#editForm").valid())
		{
			$("#pageindex").val(1);
			BindData();
		}
	});
	
});

function BindData(){
	$("#loading").ajaxStart(function(){
         $("#loading").show();
        }
    );
	var url = "xtwh/FINDVIEWT00351CSSAME.action";
	var data = {ddlSZQY : $("#ddlSZQY").val(),
				txtXQMC : $("#txtXQMC").val(),
				txtFWLX : $("#txtFWLX").val(),
				txtJZJG : $("#txtJZJG").val(),
				txtJYLX : $("#txtJYLX").val(),
				rdoYWDT : $("#rdoYWDT").val(),
				txtPSSD : $("#txtPSSD").val(),
				pageIndex : $("#pageindex").val()};
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
		     var data = msg.tabList;
		     var row = $("#rowtemplate").clone();
		     $("#divShow").html("");
		     row.appendTo("#divShow");
             $.each(data, function(i, n){
            	 var tmprow = row.clone();
            	 tmprow.attr("id","");
            	 tmprow.find("#no").text(formatString(n.recordIndex));
            	 tmprow.find("#slid").html("<a href=javascript:Show(\'../xtwh/DETAILT00351.action?SLID=" + n.slid + "\',300,420,'swid'); title='点击查看详细信息' >" + n.slid + "</a>");
            	 tmprow.find("#xqnm").text(formatString(n.xqnm));
            	 tmprow.find("#zldz").text(formatString(n.fwtdzl));
            	 tmprow.find("#fwlx").text(formatString(n.fwlx));
            	 tmprow.find("#jylx").text(formatString(n.jylx));
            	 tmprow.find("#jzjg").text(formatString(n.jzjg));
            	 tmprow.find("#slcnt").text(formatString(n.slCount));
            	 tmprow.find("#bzcnt").text(formatString(n.gpCount));
            	 tmprow.find("#chk").html("<input type='checkbox' name='chkSel' id='chkSel' value='"+n.slid+"' class='childCheck radio'/>");
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
