$(document).ready(function() {
	
});

function MyTip(obj,arg)
{    
	var tips = $(obj).attr("TIPS");
	if (tips===undefined)
	{		
		var data = {ROLEID : arg};
		$.ajax({
			   type: "GET",
			   url: "../ajax/GETRIGHT.action",
			   cache: false,
			   data: data,
			   dataType: "json",
			   complete:function()                                                    
	           {
					Tip(obj,'该权限列表',tips);
	           },
			   success: function(msg){				
			     var data = msg.rightList;
			     tips = '  该权限列表' + '<br/>';
		         $.each(data, function(i, n){ 	
		        	 tips = tips + n.rightnm + '<br/>';
		           });	
		         $(obj).attr("TIPS",tips);
			   },
			   error: function(){
				   
			   }
		});	
	}
	else
	{
		Tip(obj,'该权限列表',tips); 
		return true; 
	}
}