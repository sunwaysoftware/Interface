//JavaScript Document
$(document).ready(function() {
	$("#tabs").css("display","");
	$("#tabs").tabs({
	    select:function(event, ui) {
			if(ui.index==1 && !$("#ICHOISESCPSJGJY").attr("src"))
			{
				$("#ICHOISESCPSJGJY").attr("src","../psjgjy/VIEWCHOISESC.action");
			}
		}
	});
	$("#ISCPSJGJY").attr("src","../psjgjy/VIEWSCPSJGJY.action");
});