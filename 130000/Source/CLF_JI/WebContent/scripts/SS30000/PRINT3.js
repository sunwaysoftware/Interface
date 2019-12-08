// JavaScript Document
$(document).ready(function() {
	$("#dy").click(function(){
		showPrint3();
		document.all.WebBrowser.ExecWB(6,1);
	});	
	$("#zjdy").click(function(){
		showPrint3();
		document.all.WebBrowser.ExecWB(6,6);
	});	
	$("#ymsz").click(function(){
		showPrint3();
		document.all.WebBrowser.ExecWB(8,1);
	});	
	$("#dyyl").click(function(){
		showPrint3();
		document.all.WebBrowser.ExecWB(7,1);
	});	
});

//执行打印操作
function showPrint3() {
	$.ajax({
		   type: "GET",
		   cache: false,
		   url: "SCPRINTCZ.action",
		   data: {chkSel: $("#chkSel").val()},
		   dataType : "json",
		   success: function(msg){
		   },
		   error: function(){
			   $.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
		   }
	});
}