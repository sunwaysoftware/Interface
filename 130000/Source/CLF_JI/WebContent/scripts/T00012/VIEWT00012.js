$(document).ready(function() {
	
		
	//保存
	//$("#btnSave").click(function(){
	//	SaveData();
	//});
	
	$('#ssgxTree').tree({
		animate: true,
		url: '../ajax/TREEssgx.action',
		//data: data,
		onClick: function(node){
			//alert('当前节点：'+ node.id + node.text);
		    GetData(node.id);
		}
	});
	

});
//初始化
function IniData(){
	$("#rdoISLOGADDF").attr("checked","checked");				   
	$("#rdoISLOGUPDF").attr("checked","checked");
	$("#rdoISLOGDELF").attr("checked","checked");
	$("#rdoISLOGGPGF").attr("checked","checked");
	$("#rdoISLOGDYF").attr("checked","checked");
	$("#rdoISLOGPGF").attr("checked","checked");
	$("#rdoISLOGSHF").attr("checked","checked");
	$("#rdoISLOGSSF").attr("checked","checked");
	$("#rdoISLOGIMP").attr("checked","checked");
	$("#rdoISLOGEXP").attr("checked","checked");
	$("#rdoISLOGBACKUP").attr("checked","checked");
	$("#rdoISLOGBZFCS").attr("checked","checked");
	$("#rdoISLOGNSRD").attr("checked","checked");
	$("#txtQDHGS").val("");
	$("#txtBZJCNF").val("");
	$("#txtNOTE").val("");
	$("#txtFCJKDZ").val("");
	$("#txtCHANNEL_PWD").val("");
	$("#txtCHANNEL_ACC").val("");
	$("#txtCHANNEL_CODE").val("");
	$("#txtWBMBM").val("");
};

//得到数据
function GetData(id){

	$("#SSGXId").val(id);
	
	$.ajax({
		   type: "GET",
		   cache: false,
		   url: "FINDT00012.action",
		   data: {SSGXId:id},
		   dataType:'json',
	       success: function(msg){
			   var bean = msg.t00012Bean;
			   if (bean.upddate)
			   {
				   if (bean.islogadd==1)
				   {
					   $("#rdoISLOGADDT").attr("checked","checked");			
				   }
				   else
				   {
					   $("#rdoISLOGADDF").attr("checked","unchecked");
				   }
				   if (bean.islogupd==1)
				   {
					   $("#rdoISLOGUPDT").attr("checked","checked");
				   }
				   else
				   {
					   $("#rdoISLOGUPDF").attr("checked","checked");
				   }
				   if (bean.islogdel==1)
				   {
					   $("#rdoISLOGDELT").attr("checked","checked");
				   }
				   else
				   {
					   $("#rdoISLOGDELF").attr("checked","checked");
				   }
				   if (bean.isloggpg==1)
				   {
					   $("#rdoISLOGGPGT").attr("checked","checked");
				   }
				   else
				   {
					   $("#rdoISLOGGPGF").attr("checked","checked");
				   }
				   if (bean.islogdy==1)
				   {
					   $("#rdoISLOGDYT").attr("checked","checked");
				   }
				   else
				   {
					   $("#rdoISLOGDYF").attr("checked","checked");
				   }
				   if (bean.islogpg==1)
				   {
					   $("#rdoISLOGPGT").attr("checked","checked");
				   }
				   else
				   {
					   $("#rdoISLOGPGF").attr("checked","checked");
				   }
				   if (bean.islogsh==1)
				   {
					   $("#rdoISLOGSHT").attr("checked","checked");
				   }
				   else
				   {
					   $("#rdoISLOGSHF").attr("checked","checked");
				   }
				   if (bean.islogss==1)
				   {
					   $("#rdoISLOGSST").attr("checked","checked");
				   }
				   else
				   {
					   $("#rdoISLOGSSF").attr("checked","checked");
				   }
				   if (bean.islogimp==1)
				   {
					   $("#rdoISLOGIMPT").attr("checked","checked");
				   }
				   else
				   {
					   $("#rdoISLOGIMPF").attr("checked","checked");
				   }
				   if (bean.islogexp==1)
				   {
					   $("#rdoISLOGEXPT").attr("checked","checked");
				   }
				   else
				   {
					   $("#rdoISLOGEXPF").attr("checked","checked");
				   }
				   if (bean.islogbackup==1)
				   {
					   $("#rdoISLOGBACKUPT").attr("checked","checked");
				   }
				   else
				   {
					   $("#rdoISLOGBACKUPF").attr("checked","checked");
				   }
				   if (bean.islogbzfcs==1)
				   {
					   $("#rdoISLOGBZFCST").attr("checked","checked");
				   }
				   else
				   {
					   $("#rdoISLOGBZFCSF").attr("checked","checked");
				   }
				   if (bean.islognsrd==1)
				   {
					   $("#rdoISLOGNSRDT").attr("checked","checked");
				   }
				   else
				   {
					   $("#rdoISLOGNSRDF").attr("checked","checked");
				   }
				   $("#txtNOTE").val(formatString(bean.note));
				//   $("#txtQDHGS").val(formatString(bean.qdhgs));
				   $("#txtBZJCNF").val(formatString(bean.bzjcnf));
				   $("#txtUPDATE").val(formatDateTime(bean.upddate));
				   $("#txtFCBM").val(formatString(bean.fcbmbm));
				   $("#txtFCJKDZ").val(formatString(bean.fcjkdz));
				   $("#txtCHANNEL_PWD").val(formatString(bean.channel_Pwd));
				   $("#txtCHANNEL_ACC").val(formatString(bean.channel_Acc));
				   $("#txtCHANNEL_CODE").val(formatString(bean.channel_Code));
				   $("#txtWBMBM").val(formatString(bean.wbmbm));
				   $.notifyBar({html: '该参数已存在请设置！'});	
			   }
			   else
			   {
				   IniData();
				   $.notifyBar({html: '请添加该参数！'});	
			   }
		   },
		   error: function(){
			   $.messager.alert('错误信息','请求已发送，服务器无应答！','error');
		   }	 
		 
	});	
}


//后台保存数据
function SaveData(){
	if($("#rdoISLOGADDT")[0].checked)
	{
		rdoISLOGADD=true;
	}
	else
	{
		rdoISLOGADD=false;
	}
	if($("#rdoISLOGUPDT")[0].checked)
	{
		rdoISLOGUPD=true;
	}
	else
	{
		rdoISLOGUPD=false;
	}
	if($("#rdoISLOGDELT")[0].checked)
	{
		 rdoISLOGDEL=true;
	}
	else
	{
		rdoISLOGDEL=false;
	}
	if($("#rdoISLOGGPGT")[0].checked)
	{
		rdoISLOGGPG=true;
	}
	else
	{
		rdoISLOGGPG=false;
	}
	if($("#rdoISLOGDYT")[0].checked)
	{
		rdoISLOGDY=true;
	}
	else
	{
		rdoISLOGDY=false;
	}
	if($("#rdoISLOGPGT")[0].checked)
	{
		rdoISLOGPG=true;
	}
	else
	{
		rdoISLOGPG=false;
	}
	if($("#rdoISLOGSHT")[0].checked)
	{
		 rdoISLOGSH=true;
	}
	else
	{
		rdoISLOGSH=false;
	}
	if($("#rdoISLOGSST")[0].checked)
	{
		rdoISLOGSS=true;
	}
	else
	{
		rdoISLOGSS=false;
	}
	if($("#rdoISLOGIMPT")[0].checked)
	{
		rdoISLOGIMP=true;
	}
	else
	{
		rdoISLOGIMP=false;
	}
	if($("#rdoISLOGEXPT")[0].checked)
	{
		rdoISLOGEXP=true;
	}
	else
	{
		rdoISLOGEXP=false;
	}
	if($("#rdoISLOGBACKUPT")[0].checked)
	{
		rdoISLOGBACKUP=true;
	}
	else
	{
		rdoISLOGBACKUP=false;
	}
	if($("#rdoISLOGBZFCST")[0].checked)
	{
		rdoISLOGBZFCS=true;
	}
	else
	{
		rdoISLOGBZFCS=false;
	}
	if($("#rdoISLOGNSRDT")[0].checked)
	{
		rdoISLOGNSRD=true;
	}
	else
	{
		rdoISLOGNSRD=false;
	}
	var txtNOTE=$("#txtNOTE").val();
	var txtUPDATE=$("#txtUPDATE").val();
	
	$.ajax({
		   type: "GET",
		   cache: false,
		   url: "EDITT00012.action",
		   data: {ACT:'U',
				SSGXId:$("#SSGXId").val(),	
				rdoISLOGADD:rdoISLOGADD,
				rdoISLOGUPD:rdoISLOGUPD,
				rdoISLOGDEL:rdoISLOGDEL,
				rdoISLOGGPG:rdoISLOGGPG,
				rdoISLOGDY:rdoISLOGDY,
				rdoISLOGPG:rdoISLOGPG,
				rdoISLOGSH:rdoISLOGSH,
				rdoISLOGSS:rdoISLOGSS,
				rdoISLOGIMP:rdoISLOGIMP,
				rdoISLOGEXP:rdoISLOGEXP,
				rdoISLOGBACKUP:rdoISLOGBACKUP,
				rdoISLOGBZFCS:rdoISLOGBZFCS,
				rdoISNSRD:rdoISNSRD,
				txtNOTE:txtNOTE,
				txtUPDATE:txtUPDATE,
				txtFCJKDZ:txtFCJKDZ,
				txtFCBM:txtFCBM,
				txtCHANNEL_PWD:txtCHANNEL_PWD,
				txtCHANNEL_ACC:txtCHANNEL_ACC,
				txtCHANNEL_CODE:txtCHANNEL_CODE,
				txtWBMBM:txtWBMBM
				},
	       success: function(msg){
			$.notifyBar({cls: "success", html: '修改成功'});
		   },
		   error: function(){
			   $.messager.alert('错误信息','请求已发送，服务器无应答！','error');
		   }	 
		 
	});	
}
