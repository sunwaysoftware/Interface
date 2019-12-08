$(document).ready(function() {
	//FROM验证信息
	$("#uploadForm").validate({
		rules: {
			upload: {required: true}
		}
	});
	

	//模板数据导出
	$("#btnDownload").click(function(){
		window.location="../Date/gpsj.xls";
		
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
							var szqy = $("#ddlSZQYFind").val();
							var selectValue = getSelectedXQValue();
							if(null==selectValue) return;
							$("#txtXQFind").val(selectValue);
							getXQ(szqy, selectValue, '#txtXQTIP');
						}
	       },{
				text:'关闭',
				iconCls:'icon-cancel',
				handler:function(){
					$("#dialog").dialog('close');
				}
			}]
		});	

	$("#ddlSZQYFind").change(function(){
		$("#txtXQFind").val('');
		$("#txtXQTIP").val('');
		getDivXqmcData($('#ddlSZQYFind').val(), '', '#T00352Tree');
	});
	
	$("#spXQDM").click(function(){
		var szqy = $("#ddlSZQYFind").val();
		if (szqy == null || szqy == "") {
			$.notifyBar({html: '请先选择所在区域'});
			$("#ddlSZQYFind").focus();
			return;
		}
		var infoID = $("#txtXQFind").val();
		openXQMCDialog(szqy, infoID, '#infoTreeDIV');
	});
});


//根据选项，请求action作编辑用
function getXQRdoValue(infoid,infonm){
	//判断点击的单选按钮类型，根据单选按钮类型，为隐藏域赋值
	$("#TIPXQMC").text(infonm);
	$("#XQDM").val(infoid);
	$("#txtXQFind").val(infoid);	
	BindData();
};

function BindData(){
	$("#loading").ajaxStart(
        function()
        {
         $("#loading").show();
        }
    );
	var url = "../xtwh/FINDT00304.action";
	var data = {
			txtSWIDFind : $("#txtSWIDFind").val(),
			txtNSRMCFind : $("#txtNSRMCFind").val(),
			ddlSZQYFind : $("#ddlSZQYFind").val(),
			txtXQFind : $("#txtXQFind").val(),
			txtFWTDZLFind : $("#txtFWTDZLFind").val(),
			ACT : $("#ACT").val(),
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
            	 tmprow.find("#swid").html("<a href=javascript:Show(\'../xtwh/DETAILT00304.action?SWID=" + n.gpid + "\',300,420,'swid'); title='点击查看详细信息' >" + n.swid + "</a>");
            	 tmprow.find("#xqmc").text(formatString(n.xqmc));
            	 if(n.ywdt)
            		 tmprow.find("#ywdt").text($("#chkTrue").val());
            	 else
            		 tmprow.find("#ywdt").text($("#chkFalse").val());
            	 tmprow.find("#zlc").text(formatString(n.zlc));
            	 tmprow.find("#fwtdzl").text(formatString(n.fwtdzl));
            	 tmprow.find("#fwlx").text(formatString(n.fwlx));
            	 tmprow.find("#jylx").text(formatString(n.jylx));
            	 tmprow.find("#jzjg").text(formatString(n.jzjg));
            	 tmprow.find("#jzmj").text(formatNumber(n.jzmj,'#,##0.00'));
            	 tmprow.find("#fwcx").text(formatString(n.fwcx));
            	 tmprow.find("#zbjg").text(formatNumber(n.zbjg,'#,##0.00'));
            	 tmprow.find("#cgzk").text(formatString(n.cgzk));
            	 tmprow.find("#szlc").text(formatString(n.szlc));
            	 tmprow.find("#bwjfh").text(formatString(n.bwjfh));
            	 tmprow.find("#zbjg").text('￥'+formatNumber(n.zbjg,'#,##0.00'));
            	 tmprow.find("#tdsyqmj").text(formatNumber(n.tdsyqmj,'#,##0.00'));
            	 tmprow.find("#gpsj").text(formatDate(n.gpsj));
            	 tmprow.find("#hx").text(formatString(n.hx));
            	 tmprow.find("#nsrmc").text(formatString(n.nsrmc));
            	 tmprow.find("#upddate").text(formatDateTime(n.upddate));
            	 tmprow.find("#czr").text(formatString(n.czr));
            	 tmprow.find("#note").text(formatString(n.note));
            	 if(n.sfzj)
            		 tmprow.find("#sfzj").text($("#chkTrue").val());
            	 else
            		 tmprow.find("#sfzj").text($("#chkFalse").val());
            	 tmprow.find("#edit").html("<a href=ADDT00304.action?ACT=U&GPID=" + n.gpid + "><img src=\"../images/ico/Edit.gif\" title=\"编辑\" alt=\"编辑\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>&nbsp;<a href=ADDT00304.action?ACT=D&GPID=" + n.gpid + "><img src=\"../images/ico/Delete.gif\" title=\"删除\" alt=\"删除\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>");
            	 
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