$(document).ready(function() {

	
});

function BindData(){
	$("#loading").ajaxStart(
        function()
        {
         $("#loading").show();
        }
    );
	var url = "xtwh/FINDT00053.action";
	var data = {ddlXZLXFind : $("#ddlXZLXFind").val(),
			txtQtxzmcFind : $("#txtQtxzmcFind").val(),
			ddlSZQYFind : $("#ddlSZQYFind").val(),
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
		     var data = msg.operList;
		     var row = $("#rowtemplate").clone();
		     $("#divShow").html("");
		     row.appendTo("#divShow");
             $.each(data, function(i, n){ 
            	 var tmprow = row.clone();
            	 tmprow.attr("id","");
            	 tmprow.find("#no").text(formatString(n.recordIndex));
            	 tmprow.find("#qtxznm").text(formatString(n.qtxznm));
            	 tmprow.find("#szqy").text(formatString(n.szqy));
            	 tmprow.find("#parentnm").text(formatString(n.parentnm));
            	 tmprow.find("#xzmc").text(formatString(n.xzmc));
            	 tmprow.find("#xzxs").text(formatNumber(n.xzxs,'#,##0.00'));
            	 if(n.czlx==0)
            		 tmprow.find("#yslb").text('×');
            	 else
            		 tmprow.find("#yslb").text('＋');
            	 tmprow.find("#dir").text(formatString(n.isdir));
            	 tmprow.find("#upddate").text(formatDateTime(n.upddate));
            	 tmprow.find("#czr").text(formatString(n.czr));
            	 tmprow.find("#note").text(formatString(n.note));
            	 tmprow.find("#edit").html("<a href=ADDT00053.action?ACT=U&QTXZID=" + n.qtxzid + "><img src=\"../images/ico/Edit.gif\" title=\"编辑\" alt=\"编辑\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>&nbsp;<a href=ADDT00053.action?ACT=D&QTXZID=" + n.qtxzid + "><img src=\"../images/ico/Delete.gif\" title=\"删除\" alt=\"删除\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>");
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


