$(document).ready(function() {

	
	
});

function BindData(){
	$("#loading").ajaxStart(
        function()
        {
         $("#loading").show();
        }
    );
	var url = "../sjcj/FINDT00301.action";
	var data = {txtSWIDFind : $("#txtSWIDFind").val(),
				txtNSRMCFind : $("#txtNSRMCFind").val(),
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
            	 tmprow.find("#swid").html("<a href=javascript:Show(\'DETAILT00301.action?SWID=" + n.swid + "\',300,420,'市场法登记详细信息'); title='点击查看详细信息' >" + n.swid + "</a>");
            	 tmprow.find("#nsrmc").text(formatString(n.nsrmc));
            	 tmprow.find("#zjlx").text(formatString(n.zjlx));
            	 tmprow.find("#zz").text(formatString(n.zz));
            	 tmprow.find("#lxdh").text(formatString(n.lxdh));
            	 if(msg.ACT=="M")
            		 tmprow.find("#edit").html("<a href=ADDT00301.action?ACT=U&txtSWIDFind=" + encodeURI(n.swid) + "><img src=\"../images/ico/Edit.gif\" title=\"编辑\" alt=\"编辑\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>&nbsp;<a href=ADDT00301.action?ACT=D&txtSWIDFind=" + encodeURI(n.swid) + "><img src=\"../images/ico/Delete.gif\" title=\"删除\" alt=\"删除\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>");
            	 else
            		 tmprow.find("#edit").html("<a href=\"#\" onclick=\"window.parent.addFCXX('" + n.swid + "')\"><img src=\"../images/ico/AddInfo.gif\" title=\"添加\" alt=\"添加\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>&nbsp;");
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