$(document).ready(function() {
	
	//FROM验证信息
	$("#findForm").validate({
		rules: {
			txtXQDM: {required: true},
			ddlSZQY: {required: true},
			txtPSSD: {required: true}
			}
		});
	$("#updForm").validate({
		rules: {
				hidWPssd: {required: true},
				hidWfc: {required: true},
				hidYfc: {required: true},
				txtFcjg: {required: true, number: true}
			}
		});
	
	// 小区代码
	$("#IYJG").attr("src","VIEWT00351CSDIFFY.action");
	
	//查询
	$("#btnSearch").click(function(){	
		if ($("#findForm").valid())
		{
			$("#pageindex").val(1);
			BindData();			
			var randomnumber=Math.floor(Math.random()*100000);
			$("#IYJG").attr("src","VIEWT00351CSDIFFY.action?ddlSZQY=" + $("#ddlSZQY").val() + "&txtXQMC=" + $("#txtXQDM").val() + "&txtPSSD=" + $("#txtPSSD").val() + "&rand="+randomnumber);
			$("#hidWPssd").val($("#txtPSSD").val());
			$("#spWPssd").text($("#txtPSSD").val());
		}
	});
	
	//更新
	$("#btnUpd").click(function(){	
		if ($("#updForm").valid())
		{
			var url = "EDITT00351A.action";
			var data = {SLID : $("#hidWfc").val(),
						txtJYSJ : $("#hidWPssd").val(),
						txtPFMJG : $("#txtFcjg").val()};
			$.ajax({
				   type: "GET",
				   url: url,
				   cache: false,
				   data: data,
				   dataType: "html",
				   complete:function()
		           {
						$("#loading").hide();
		           },
				   success: function(msg){
		        	   $("#hidWPssd").val("");
		        	   $("#spWPssd").text("");		        	   
		        	   $("#hidWfc").val("");
		        	   $("#spWfc").text("");
		        	   $("#hidYfc").val("");
		        	   $("#spYfc").text("");
		        	   $("#txtFcjg").val("");
		        	   $("#btnSearch").click();
				   },
				   error: function(){					   
					   $("#loading").hide();
					   $.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
				   }
			});
		}
	});

	// 小区代码
	$("#spXQDM").click(function(){
		var szqy = $("#ddlSZQY").val();
		var pssd = $("#txtPSSD").val();
//		alert("szqy: "+szqy +",pssd: "+pssd);
		if (szqy == null || szqy == "") {
			$.notifyBar({html: '请先选择所在区域' });
			$("#ddlSZQY").focus();
		} else {
			$("#hidSelect").val("XQ");
			var xqdm = $("#txtXQDM").val();
//			alert(xqdm);
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

function setWfc(wfc)
{	
	$("#spWfc").text(wfc);
	$("#hidWfc").val(wfc);
}

function setYfc(yfc,pfmjg)
{	
	$("#spYfc").text(yfc);
	$("#hidYfc").val(yfc);
	$("#txtFcjg").val(pfmjg);
}

function BindData(){
	$("#loading").ajaxStart(function(){
         $("#loading").show();
        }
    );
	var url = "xtwh/FINDVIEWT00351CSDIFFW.action";
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
		     var data = msg.tabwList;
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
            	 tmprow.find("#chk").html("<input type='radio' name='rdoISDIR' id='rdoSel" + i + "' onclick=\"setWfc('"+n.slid+"')\" class='radio'/>");
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
