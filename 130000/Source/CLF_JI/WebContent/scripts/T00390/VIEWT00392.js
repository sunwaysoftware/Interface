$(document).ready(function() {

	//受理对话框
	if ($('#w2').length>0)
	{
	  $('#w2').dialog({
		title: "受理数据",	
        closed: true,
        iconCls:"icon-search",
	       buttons:[
			{
				text:'关闭',
				iconCls:'icon-cancel',
				handler:function(){
					$("#w2").dialog('close');
				}
			}]
		});
	};
});


function printRD(fcid,fcslh,pgjg){
	$("#w2").window('open');
	var randomnumber=Math.floor(Math.random()*100000);
	$("#IGPG").attr("src","../xtwh/VIEWT003701.action?txtFCID=" + fcid+"&txtFCSLHSign="+ fcslh +"&txtPGJG="+pgjg+"&rand="+randomnumber);
	//if(!window.confirm('契税申报通知单'+fcid+'，是否确认定交税？')) return;
	$("#IGPG").attr("FCID",fcid);
	
}
function QRJS(fcid){
	var url = "../pg/EXECT00392.action";
	$("#loading").show();
	var data = {FCID : fcid};
	$.ajax({
		   type: "GET",
		   url: url,
		   cache: false,
		   data: data,
		   dataType: "json",
		   complete:function() {
				$("#loading").hide();
           },
		   success: function(msg){
        	   if(msg.RD)
        		   {
        		   $.notifyBar({cls:"success", html: '交税认定成功'});
        	       $("#w2").dialog('close');
        		   }
        	   else
        		   $.notifyBar({cls:"error", html: '交税认定失败'});
        	  //重新载入数据
        	   searchDate();
		   },
		   error: function(){
			   $.notifyBar({cls:"error", html: '交税认定失败'});
		   }
	});	
	}
