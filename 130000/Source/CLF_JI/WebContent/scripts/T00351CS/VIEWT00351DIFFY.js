$(document).ready(function() {	

	$("#pageindex").val(1);

	//查询
	$("#btnSearch").click(function(){	
		if (""==$("#txtXQDM").val()){
			$.notifyBar({html: '请选择小区'});
			return;
		}
		$("#pageindex").val(1);
		BindData();
	});		
	
	// 小区代码
	$("#spXQDM").click(function(){
		var szqy = $("#ddlSZQY").val();
		var pssd = $("#txtPSSD").val();
		if (szqy == null || szqy == "") {
			$.notifyBar({html: '请先确定【无价格小区】' });
			$("#ddlSZQY").focus();
		} else {
			$("#hidSelect").val("XQ");
			var xqdm = $("#txtXQDM").val();
			openXQMCDialog(szqy, xqdm, pssd, '#infoTreeDIV');
		}
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
					$("#txtXQDM").val(selectValue);
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
	
});

function BindData(){
//	alert($("#txtXQMC").val());
	$("#loading").ajaxStart(function(){
         $("#loading").show();
        }
    );
	var url = "xtwh/FINDVIEWT00351CSDIFFY.action";
	var data = {txtXQMC : $("#txtXQDM").val(),
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
		     var data = msg.tabyList;
		     var row = $("#rowtemplate").clone();
		     $("#divShow").html("");
		     row.appendTo("#divShow");
             $.each(data, function(i, n){
            	 var tmprow = row.clone();
            	 tmprow.attr("id","");
            	 tmprow.find("#no").text(formatString(n.recordIndex));
            	 tmprow.find("#slid").html("<a href=javascript:Show(\'../xtwh/DETAILT00351.action?SLID=" + n.slid + "\',300,420,'swid'); title='点击查看详细信息' >" + n.slid + "</a>");
            	 tmprow.find("#xqnm").text(formatString(n.xqnm));
            	 tmprow.find("#fwlx").text(formatString(n.fwlx));
            	 tmprow.find("#jylx").text(formatString(n.jylx));
            	 tmprow.find("#jzjg").text(formatString(n.jzjg));
            	 tmprow.find("#pfmjg").text(formatString(n.pfmjg));
            	 tmprow.find("#chk").html("<input type='radio' name='chkSel' name='rdoISDIR' id='rdoSel" + i + "' onclick=\"window.parent.setYfc('"+n.slid+"','" + n.pfmjg + "')\" class='radio'/>");
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
