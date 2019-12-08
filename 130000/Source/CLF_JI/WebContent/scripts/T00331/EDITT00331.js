// JavaScript Document
var bshow = false;
$(document).ready(function() {
	$("#IGPG").attr("src","VIEWT00358.action?txtFCID=" + $("#IGPG").attr("FCID") + "&txtPSSD=" + $("#IGPG").attr("PSSD") + "&txtSWID=" + $("#IGPG").attr("SWID"));
	$("#showPG").click(function() {
		if(!$("#IPG").attr("src"))
		{
			$("#IPG").attr("src","VIEWT00334.action?ACT=C&txtFCID=" + $("#IPG").attr("FCID") + "&txtPSSD=" + $("#IPG").attr("PSSD"));
		}
		if (!bshow)
		{	
			$("#PG").show();
		}
		else
		{
			$("#PG").hide();
		}
		bshow = !bshow;
		
	});	
});
