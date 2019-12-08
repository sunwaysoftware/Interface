// JavaScript Document
$(document).ready(function() {
	$("#tabs").css("display","");
	$("#tabs").tabs({
	    select:function(event, ui) {
			if(ui.index==1 && !$("#IYPG").attr("src"))
			{
				$("#IYPG").attr("src","../pg/VIEWPG30002.action");
			}		
		}	
	});
	$("#IWPG").attr("src","../pg/VIEWPG30001.action");
});