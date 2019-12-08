// JavaScript Document
$(document).ready(function() {
	$("#tabs").css("display","");
	$("#tabs").tabs({
	    select:function(event, ui) {
			if(ui.index==1 && !$("#IYSH").attr("src"))
			{
				$("#IYSH").attr("src","../sjsh/VIEWSH30002.action");
			}		
		}	
	});
	$("#IWSH").attr("src","../sjsh/VIEWSH30001.action");
});