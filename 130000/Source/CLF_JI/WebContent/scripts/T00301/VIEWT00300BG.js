// JavaScript Document
$(document).ready(function() {
	$("#tabs").css("display","");
	$("#tabs").tabs({
	    select:function(event, ui) {
			if(ui.index==1 && !$("#IFCXX").attr("src"))
			{
				$("#IFCXX").attr("src","../sjcj/VIEWT00302.action?ACT=M");
			}
    	}	
	});
	$("#IDJXX").attr("src","../sjcj/VIEWT00301.action?ACT=M");
	
	window.setInterval("reinitIframe()", 500);
});

function reinitIframe(){	
	var iframe = document.getElementById("IFCXX");
	try{
	iframe.height =  iframe.contentWindow.document.documentElement.scrollHeight;
	}
	catch (ex){}
	
	iframe = document.getElementById("IDJXX");
	try{
	iframe.height =  iframe.contentWindow.document.documentElement.scrollHeight;
	}
	catch (ex){}
	
}