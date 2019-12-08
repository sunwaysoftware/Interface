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
	var url = "../sjsh/FINDSH30002.action";
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
		     var data = msg.operList;
		     var row = $("#rowtemplate").clone();
		     $("#divShow").html("");
		     row.appendTo("#divShow");
             $.each(data, function(i, n){ 
            	 var tmprow = row.clone();
            	 tmprow.attr("id","");
            	 tmprow.find("#chk").html("<input type='checkbox' name='chkSel' id='chkSel' value='"+n.fcid+"' class='childCheck radio'/>");
            	 tmprow.find("#no").text(formatString(n.recordIndex));
            	 tmprow.find("#fcid").html("<a href=javascript:Show(\'../xtwh/DETAILT00305Y.action?FCID=" + n.fcid + "\',300,420,'详细信息'); title='点击查看详细信息' >" + n.fcid + "</a>");
            	 tmprow.find("#swid").html("<a href=javascript:Show(\'../sjcj/DETAILT00301.action?SWID=" + n.cd00301Swid + "\',300,420,'登记详细信息'); title='点击查看详细信息' >" + n.cd00301Swid + "</a>");
            	 tmprow.find("#nsrmc").text(formatString(n.nsrmc));
            	 tmprow.find("#szqy").text(formatString(n.szqy));
            	 tmprow.find("#xqnm").text(formatString(n.xqnm));
            	 tmprow.find("#fwtdzl").text(formatString(n.fwtdzl));
            	 tmprow.find("#fwlx").text(formatString(n.fwlx));
            	 tmprow.find("#jylx").text(formatString(n.jylx));
            	 tmprow.find("#jzjg").text(formatString(n.jzjg));
            	 tmprow.find("#jzmj").text(formatNumber(n.jzmj,'#,##0.00'));
            	 tmprow.find("#fwcx").text(formatString(n.fwcx));
            	 tmprow.find("#cgzk").text(formatString(n.cgzk));
            	 tmprow.find("#szlc").text(formatString(n.szlc));
            	 tmprow.find("#bwjfh").text(formatString(n.bwjfh));
            	 tmprow.find("#jyjg").text('￥'+formatNumber(n.jyjg,'#,##0.00'));
            	 tmprow.find("#tdsyqmj").text(formatNumber(n.tdsyqmj,'#,##0.00'));
            	 tmprow.find("#rjl").text(formatNumber(n.rjl,'#,##0.00'));
            	 tmprow.find("#jysj").text(formatDate(n.jysj));
            	 tmprow.find("#fdcdat").text(formatString(n.fdcdat));
            	 tmprow.find("#upddate").text(formatDateTime(n.upddate));
            	 tmprow.find("#czr").text(formatString(n.czr));
            	 tmprow.find("#msg").html("<img title=\"审核通过\" alt='审核通过' src='../images/ico/1.gif'/>");
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