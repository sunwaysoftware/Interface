$(document).ready(function() {
	
	//对象编号
	$("#txtROOTIDFind").blur(function(){
		$("#ddlROOTIDFind").val($("#txtROOTIDFind").val());
	});
	
	$("#ddlROOTIDFind").change(function(){
		$("#txtROOTIDFind").val($("#ddlROOTIDFind").val());;
	});
	
});

function AppSubmitUpload(){
	 
	$("#dialog").dialog({
		modal: true,
        shadow: true,
        closed: true,
	       buttons:[{
				text:'确定',
				iconCls:'icon-ok',
				handler:function(){
	    	   $("#dialog").dialog('close');
				}
			},{
				text:'取消',
				iconCls:'icon-cancel',
				handler:function(){
					$("#dialog").dialog('close');
				}
			}]
		});
}