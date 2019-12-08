$(document).ready(function() {
	

});

function BindData(){
	$("#loading").ajaxStart(
        function()
        {
         $("#loading").show();
        }
    );
	var url = "../xtwh/FINDT00051.action";
	var data = {ddlSZQYFind : $("#ddlSZQYFind").val(), 
				txtPSSD:$("#txtPSSD").val(), 
				pageIndex: $("#pageindex").val()};
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
		     var data = msg.jsblList;
		     var row = $("#rowtemplate").clone();
		     $("#divShow").html("");
		     row.appendTo("#divShow");
             $.each(data, function(i, n){ 
            	 var tmprow = row.clone();
            	 tmprow.attr("id","");
            	 tmprow.find("#no").text(formatString(n.recordIndex));
            	 tmprow.find("#pssd").text(formatDate(n.cd00002Pssd));
            	 tmprow.find("#szqy").text(formatString(n.szqy));
            	 tmprow.find("#fwlx").text(formatString(n.fwlx));
            	 tmprow.find("#jylx").text(formatString(n.jylx));
            	 tmprow.find("#jsbl").text(formatNumber(n.jsbl,'#,##0.00'));
            	 tmprow.find("#sl").text(formatNumber(n.sl,'#,##0.00'));
            	 tmprow.find("#upddate").text(formatDateTime(n.upddate));
            	 tmprow.find("#czr").text(formatString(n.czr));
            	 tmprow.find("#note").text(formatString(n.note));
            	 tmprow.find("#edit").html("<a href=ADDT00051.action?ACT=U&txtPSSD="+n.cd00002Pssd+"&ddlSZQY="+n.cd00001Szqy+"&txtFWLX="+n.cd00001Fwlx+"&txtJYLX="+n.cd00001Jylx+"><img src=\"../images/ico/Edit.gif\" title=\"编辑\" alt=\"编辑\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>&nbsp;<a href=javascript:DelSLZS('"+n.cd00001Szqy+"','"+n.cd00002Pssd+"','"+n.cd00001Fwlx+"','"+n.cd00001Jylx+"')><img src=\"../images/ico/Delete.gif\" title=\"删除\" alt=\"删除\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>");
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
 * 删除
 * @param userID
 * @return
 */
function DelSLZS(szqy,pssd,fwlx,jylx){
	var flag = confirm('确定要删除'+szqy+'吗?');
	if (flag) {
		$.ajax({
			   type: "GET",
			   cache: false,
			   url: "EDITT00051.action",
			   data: {ddlSZQY:szqy, txtPSSD:pssd, ACT: 'D', txtFWLX:fwlx, txtJYLX:jylx},
			   success: function(msg){
				   BindData();
			   },
			   complete:function()                                                    
	           {
					$("#loading").hide();
	           },
			   error: function(){
				   $.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
			   }
		});	
	}
}
