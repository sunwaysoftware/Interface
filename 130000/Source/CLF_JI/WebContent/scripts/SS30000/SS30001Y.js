$(document).ready(function() {	
	
	$('.rootCheck').click(function(){ 		
		$(".childCheck").each(function(){	
			$(this)[0].checked=$('.rootCheck')[0].checked;
		});			
	});
});

function BindData(){
	$("#loading").ajaxStart(
        function(){
         $("#loading").show();
        }
    );
	var url = "../psjgcl/FINDT00041SC.action";
	var data = {txtSWIDFind : $("#txtSWIDFind").val(),
				txtNSRMCFind : $("#txtNSRMCFind").val(),
				txtFCSLHFind: $("#txtFCSLHFind").val(),
				pageIndex : $("#pageindex").val()};
	$.ajax({
		   type: "POST",
		   url: url,
		   cache: false,
		   data: data,
		   dataType: "json",
		   complete:function() {
				$("#loading").hide();
				$("#divShow .childCheck").click(function(){ 		
	         	    var b = true;
	         		$(".childCheck").each(function(){         		
	         			if 	(!$(this)[0].checked) {
	         				b = false;				
	         			}
	         		});		
	         		$('.rootCheck')[0].checked = b;
	         	});
           },
		   success: function(msg){
		     var data = msg.tabList;
		     var row = $("#rowtemplate").clone();
		     $("#divShow").html("");
		     row.appendTo("#divShow");
             $.each(data, function(i, n){ 
            	 var tmprow = row.clone();
            	 tmprow.attr("id","");
            	 tmprow.find("#chk").html("<input type='checkbox' name='chkSel' id='chkSel' value='"+n.cd123Id+"' class='childCheck radio'/>");
            	 tmprow.find("#no").text(formatString(n.recordIndex));
            	 tmprow.find("#fcid").html("<a href=javascript:Show(\'../xtwh/DETAILT00305Y.action?FCID=" + n.cd123Id + "\',300,420,'详细信息'); title='点击查看详细信息' >" + n.cd123Id + "</a>");
            	 tmprow.find("#swid").html("<a href=javascript:Show(\'../sjcj/DETAILT00301.action?SWID=" + n.cd12301Swid + "\',300,420,'登记详细信息'); title='点击查看详细信息' >" + n.cd12301Swid + "</a>");
            	 tmprow.find("#nsrmc").text(formatString(n.nsrmc));
            	 tmprow.find("#pgjg").text('￥'+formatNumber(n.pgjg,'#,##0.00'));
            	 tmprow.find("#jsze").text('￥'+formatNumber(n.jsze,'#,##0.00'));
            	 tmprow.find("#ynze").text('￥'+formatNumber(n.ynze,'#,##0.00'));
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
			   $.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
		   }
	});	
}