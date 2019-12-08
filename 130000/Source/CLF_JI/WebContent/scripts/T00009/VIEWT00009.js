$(document).ready(function() {
	
	
});

function BindData(){

	$("#loading").ajaxStart(
        function()
        {
        	$("#loading").show();
        }
    );
	var url = "xtwh/FINDT00009.action";
	$.ajax({
		   type: "GET",
		   url: url,
		   data: {txtUSERIDFind: $("#txtUSERIDFind").val(), txtUSERNMFind: $("#txtUSERNMFind").val(), pageIndex: $("#pageindex").val()},
		   cache: false,
		   dataType: "json",
		   complete:function()                                                    
           {
				$("#loading").hide();
           },
		   success: function(msg){
		     var data = msg.ssgxList;
		     var row = $("#rowtemplate").clone();
		     $("#divShow").html("");
		     row.appendTo("#divShow");
             $.each(data, function(i, n){ 
            	 var tmprow = row.clone();
            	 tmprow.attr("id","");
            	 tmprow.find("#no").text(formatString(n.recordIndex));
            	 tmprow.find("#userid").text(formatString(n.cd00002Userid));
            	 tmprow.find("#usernm").text(formatString(n.usernm));
            	 tmprow.find("#ssgx").text(formatString(n.ssgx));
            	 tmprow.find("#upddate").text(formatDateTime(n.upddate));
            	 tmprow.find("#czr").text(formatString(n.czr));
            	 tmprow.find("#note").text(formatString(n.note));
            	 tmprow.find("#edit").html("<a href=ADDT00009.action?ACT=U&USERID=" + n.cd00002Userid+"&SSGX="+ n.cd00001Ssgx+"><img src=\"../images/ico/Edit.gif\" title=\"编辑\" alt=\"编辑\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>&nbsp;<a href=javascript:DelSSGX('"+n.cd00002Userid+"','"+n.cd00001Ssgx+"')><img src=\"../images/ico/Delete.gif\" title=\"删除\" alt=\"删除\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>");
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
function DelSSGX(userID,ssgx){
	var flag = confirm('确定要删除'+userID+'吗?');
	if (flag) {
		$.ajax({
			  type:'GET',
			  cache: false,
			  url:'DelSSGX.action',
			  data:{USERID: userID , SSGX: ssgx},
			  success:function(res){
				  BindData();
			  },
			  complete:function()                                                    
	           {
					$("#loading").hide();
	           },
			  error:function(){
				 $.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
			  }
		});
	}
}
