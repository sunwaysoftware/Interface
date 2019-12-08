// JavaScript Document
$(document).ready(function() {
	$("#tabs").css("display","");
	$("#tabs").tabs({
	    select:function(event, ui) {
			if(ui.index==1 && !$("#IFCXX").attr("src"))
			{
				$("#IFCXX").attr("src","../sjcj/VIEWT00302.action");
			}
    	}	
	});
	$("#IDJXX").attr("src","../sjcj/VIEWT00301.action");
	
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

function addFCXX(swid){
	$("#IFCXX").attr("src","../sjcj/ADDT00302.action?ACT=C&SWID=" + encodeURI(swid));
	$("#tabs").tabs('select', 1);
}