$(document).ready(function() {		
	
	$('.rootCheck').click(function(){ 		
		$(".childCheck").each(function(){	
			$(this)[0].checked=$('.rootCheck')[0].checked;
		});			
	});
});

function BindData(){
	$("#loading").ajaxStart(
        function()
        {
         $("#loading").show();
        }
    );
	var url = "../pg/FINDPG30002.action";
	var data = {txtSWIDFind : $("#txtSWIDFind").val(),
				txtNSRMCFind : $("#txtNSRMCFind").val(),
				pageIndex : $("#pageindex").val()};
	$.ajax({
		   type: "GET",
		   url: url,
		   cache: false,
		   data: data,
		   dataType: "json",
		   complete:function() {
				$("#loading").hide();
				$("#divShow .childCheck").click(function()
	             { 		
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
            	 tmprow.find("#chk").html("<input type='checkbox' name='chkSel' id='chkSel' value='"+n.cd00302Fcid+"' class='childCheck radio'/>");
            	 tmprow.find("#no").text(formatString(n.recordIndex));
            	 tmprow.find("#fcid").html("<a href=javascript:Show(\'../xtwh/DETAILT00305Y.action?FCID=" + n.cd00302Fcid + "\',300,420,'详细信息'); title='点击查看详细信息' >" + n.cd00302Fcid + "</a>");
            	 tmprow.find("#swid").html("<a href=javascript:Show(\'../sjcj/DETAILT00301.action?SWID=" + n.cd00301Swid + "\',300,420,'登记详细信息'); title='点击查看详细信息' >" + n.cd00301Swid + "</a>");
            	 tmprow.find("#nsrmc").text(formatString(n.nsrmc));
            	 tmprow.find("#pgczr").text(formatString(n.pgCzr));
            	 tmprow.find("#pgjg").text('￥'+formatNumber(n.pgjg,'#,##0.00'));
            	 tmprow.find("#pgjgga").text('￥'+formatNumber(n.gbpgjg,'#,##0.00'));
            	 tmprow.find("#msg").html("<img title=\"估价通过\" alt='估价通过' src='../images/ico/2.gif'/>");
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