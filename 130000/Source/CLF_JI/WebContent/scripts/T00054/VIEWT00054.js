$(document).ready(function() {
	//查询
	$("#btnSearch").click(function(){
		BindData();
	});	
	
	
	
	
});

function BindData(){

	$("#loading").ajaxStart(
        function()
        {        	
        	$("#loading").show();        	
        }
    );
	var url = "xtwh/FINDT00054.action";
	var data = {ddlSZQYFind: $("#ddlSZQYFind").val()};
	$.ajax({
		   type: "GET",
		   url: url,
		   data: data,
		   cache: false,
		   dataType: "json",
		   complete:function()                                                    
           {
				$("#loading").hide();
           },
		   success: function(msg){
		     var data = msg.jybzjList;
		     var row = $("#rowtemplate").clone();
		     $("#divShow").html("");
		     row.appendTo("#divShow");
             $.each(data, function(i, n){ 
            	 var tmprow = row.clone();
            	 tmprow.attr("id","");
            	 tmprow.find("#szqy").text(formatString(n.szqy));
            	 tmprow.find("#bzbm").text(formatString(n.bzbm));
            	 tmprow.find("#bzmc").text(formatString(n.bzmc));
            	 tmprow.find("#jzqs").text(formatNumber(n.jzqsMin,'#,##0.00')+'--'+formatNumber(n.jzqsMax,'#,##0.00'));
            	 tmprow.find("#lsxs").text(formatNumber(n.lsxsMin,'#,##0.00')+'--'+formatNumber(n.lsxsMax,'#,##0.00'));
            	 tmprow.find("#jgxgc").text(formatNumber(n.jgxgcMin,'#,##0.00')+'--'+formatNumber(n.jgxgcMax,'#,##0.00'));
            	 tmprow.find("#upddate").text(formatDateTime(n.upddate));
            	 tmprow.find("#czr").text(formatString(n.cd00002Czr));
            	 tmprow.find("#note").text(formatString(n.note));
            	 tmprow.find("#edit").html("<a href=ADDT00054.action?ACT=U&BZBM=" + n.bzbm +"&SZQY=" + n.cd00001Szqy +"><img src=\"../images/ico/Edit.gif\" title=\"编辑\" alt=\"编辑\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a><a href=ADDT00054.action?ACT=D&BZBM=" + n.bzbm +"&SZQY=" + n.cd00001Szqy +"><img src=\"../images/ico/Delete.gif\" title=\"删除\" alt=\"删除\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>");
            	 
            	 tmprow.appendTo("#divShow");//添加到模板的容器中    
            	 tmprow=null;
               });             
             row=null;
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
function DelRJL(tdyt,szqy,rjl){
	var flag = confirm('确定要删除容积率为'+rjl+'的数据吗?');
	if (flag) {
		$.ajax({
			  type:'GET',
			  cache: false,
			  url:'DelRJL.action',
			  data:{TDYT: tdyt , ddlSZQY: szqy ,txtRJL:rjl},
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
