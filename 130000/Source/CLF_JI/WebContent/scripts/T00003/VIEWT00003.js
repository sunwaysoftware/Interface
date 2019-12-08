$(document).ready(function() {
	
	
});

function BindData(){

	$("#loading").ajaxStart(
        function()
        {
        	$("#loading").show();
        }
    );
	var url = "../xtwh/FINDT00003.action";
	var data = {txtROLENMFind: $("#txtROLENMFind").val(), pageIndex: $("#pageindex").val()};
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
		     var data = msg.roleList;
		     var isadmin = msg.ISADMIN;
		     var row = $("#rowtemplate").clone();
		     $("#divShow").html("");
		     row.appendTo("#divShow");
             $.each(data, function(i, n){ 
            	 var tmprow = row.clone();
            	 tmprow.attr("id","");
            	 tmprow.find("#no").text(formatString(n.recordIndex));
            	 tmprow.find("#roleid").text(formatString(n.roleid));
            	 tmprow.find("#rolenm").text(formatString(n.rolenm));
            	 tmprow.find("#czr").text(formatString(n.czr));
            	 tmprow.find("#upddate").text(formatDateTime(n.upddate));
            	 if(isadmin){
            		 if(n.rolenm != '区域管理员')
            			 tmprow.find("#edit").html("<a href=ADDT00010.action?ACT=U&ROLEID=" + n.roleid +"><img src=\"../images/ico/Add.gif\" title=\"分配\" alt=\"分配\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>&nbsp;<a href=ADDT00003.action?ACT=U&ROLEID=" + n.roleid +"><img src=\"../images/ico/Edit.gif\" title=\"编辑\" alt=\"编辑\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>&nbsp;<a href=ADDT00003.action?ACT=D&ROLEID=" + n.roleid +"><img src=\"../images/ico/Delete.gif\" title=\"删除\" alt=\"删除\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>");
            		 else
            			 tmprow.find("#edit").html("<a href=ADDT00010.action?ACT=U&ROLEID=" + n.roleid +"><img src=\"../images/ico/Add.gif\" title=\"分配\" alt=\"分配\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>");	 
            	 }else{
            		 tmprow.find("#edit").html("<a href=ADDT00010.action?ACT=U&ROLEID=" + n.roleid +"><img src=\"../images/ico/Add.gif\" title=\"分配\" alt=\"分配\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>");	 
            	 }
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


