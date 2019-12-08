$(document).ready(function() {
	$("#tabs").css("display","");
	$("#tabs").tabs({
	    select:function(event, ui) {
			if(ui.index==1 && !$("#IFC").attr("src"))
			{
				$("#IFC").attr("src","../sjcx/LISTV00302AINIT.action?CZH=" + $("#IFC").attr("CZH"));
			}
    	}	
	});
	$("#IDJ").attr("src","../sjcx/LISTV00301AINIT.action?CZH=" + $("#IDJ").attr("CZH"));
});