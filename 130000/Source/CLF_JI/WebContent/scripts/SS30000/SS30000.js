// JavaScript Document
$(document).ready(function() {
	$("#tabs").css("display","");
	$("#tabs").tabs({
	    select:function(event, ui) {
			if(ui.index==1 && !$("#IYSS").attr("src"))
			{
				$("#IYSS").attr("src","../psjgcl/VIEWSS30002.action");
			}
		}
	});
	$("#IWSS").attr("src","../psjgcl/VIEWSS30001.action");
});