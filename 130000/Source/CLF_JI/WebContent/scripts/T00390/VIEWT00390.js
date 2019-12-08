// JavaScript Document
$(document).ready(function() {
	$("#tabs").css("display","");
	$("#tabs").tabs({
	    select:function(event, ui) {
			if(ui.index==1 && !$("#ICL").attr("src"))
			{
				$("#ICL").attr("src","../pg/VIEWT00392.action");
			}		
		}	
	});
	$("#IDY").attr("src","../pg/VIEWT00391.action");
});