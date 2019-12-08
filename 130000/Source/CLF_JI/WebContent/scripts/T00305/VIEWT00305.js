$(document).ready(function() {
	$("#tabs").css("display","");
	$("#tabs").tabs({
	    select:function(event, ui) {
			if(ui.index==1 && !$("#IYCZ").attr("src"))
			{
				$("#IYCZ").attr("src","../xtwh/VIEWT00305Y.action");
			}		
    	}	
	});
	$("#IWCZ").attr("src","../xtwh/VIEWT00305W.action");
});