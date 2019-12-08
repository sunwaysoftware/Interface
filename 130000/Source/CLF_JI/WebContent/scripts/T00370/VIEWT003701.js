$(document).ready(function() {
	
	 /*if( $("#rdo1").click(function(){
		 if($("#rdo1").attr('checked')==true){
			 $("#txt1").removeAttr("disabled"); 
		 }else{
			 $("#txt1").attr("disabled","disabled"); 
		 }
			  
		}))
		
	   if($("#rdo2").click(function(){
		   if($("#rdo2").attr('checked')==true){
				 $("#txt2").removeAttr("disabled"); 
			 }else{
				 $("#txt2").attr("disabled","disabled"); 
			 }
				  
		}))
		if($("#rdo3").click(function(){
			 if($("#rdo3").attr('checked')==true){
				 $("#txt3").removeAttr("disabled"); 
			 }else{
				 $("#txt3").attr("disabled","disabled"); 
			 }
				   
	     }))	
		if($("#rdo4").click(function(){
			 if($("#rdo4").attr('checked')==true){
				 $("#txt4").removeAttr("disabled"); 
			 }else{
				 $("#txt4").attr("disabled","disabled"); 
			 }
				   
		}))
		 if( $("#rdo5").click(function(){
			 if($("#rdo5").attr('checked')==true){
				 $("#txt5").removeAttr("disabled"); 
			 }else{
				 $("#txt5").attr("disabled","disabled"); 
			 }
				  
		}))
		if($("#rdo6").click(function(){
			 if($("#rdo6").attr('checked')==true){
				 $("#txt6").removeAttr("disabled"); 
			 }else{
				 $("#txt6").attr("disabled","disabled"); 
			 }
				   
			}))
		if($("#rdo7").click(function(){
			 if($("#rdo7").attr('checked')==true){
				 $("#txt7").removeAttr("disabled"); 
			 }else{
				 $("#txt7").attr("disabled","disabled"); 
			 }
				  
			}))	*/		
		
	
	//FROM验证信息
	$("#editForm").validate({
		rules: {
			txtSZNM:{required: true, maxlength : 200},
			txtXZXS:{required: true, number: true},
			txtNOTE:{maxlength : 200},
			txtSZ:{required: true,mySZ:true}
		},
		messages:{
			txtSZ:{mySZ:"<img src='../images/exclamation.gif' align='absmiddle' title='输入的税种已存在！'/>"}
			
        }
	});
	
	
	/*//FROM验证信息
	$("#valForm").validate({
		rules: {
//			txtFPID:{required: true},
//			txtSPID:{required: true},
//			rdoSFMS:{required: true},
//			rdoSFZS:{required: true}
		}
		
	});*/
	//这里定义了一个名为equal的规则
	//value是指当前校验域的值
	//element是指当前检验的域
	//param是指在rules中设定的参数
	//这三个参数会在进行校验时由系统自动带入
	$.validator.methods.mySZ = function(value, element, param){
	    //在这里使用上面的三个参数进行校验
		if (value)
		{
			//如果该对象不存在说明是添加。添加时不用判断。
			var SZ=$("#SZ").val();
			var SZ1=$("#txtSZ").val()+"/";
			if (SZ==SZ1)
				{
				return false;
				}
			else
				return true;			
		}
	};	
	
	$("#btnhx").click(function(){
		if(!window.confirm('数据进行完税认定后无法回退，是否确认操作？')) return;
		hxXML();
	});	
	
	$("#btnDJZSe").click(function(){
		sendDJZSe();	
	});
	
});


//后台更新数据
function hxXML(){
	if(!window.confirm('是否确认'+$("#txtFCID").val()+'该笔交易已经完税？')) return;
	$("#loading").show();
	$.ajax({
		   type: "POST",
		   cache: false,
		   url: "HX.action",
		   dataType: "json",
		   data: { 
					txtFCID : $("#txtFCID").val(),
					txtFPID : $("#txtFPID").val(),
					txtSPID : $("#txtSPID").val(),
					txtDFSPID :	 $("#txtDFSPID").val()
					},
			complete:function()
	        {
				$("#loading").hide();
	        },		
		   success: function(msg){
					if(msg.txtHXSign == "Y"){
						$.notifyBar({cls:"success", html: '成功回写完税信息！'});
						window.parent.QRJS($("#txtFCID").val());
					}
					if(msg.txtHXSign == "N"){
						$.messager.alert('错误信息',msg.errorMessage,'error');
					}						
//			  
		   },
		   error: function(){
			   $.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
		   
		   }
	});	
}

function sendDJZSe(){
	$("#loading").show();
	$.ajax({
		type:"POST",
		cache: false,
		url: "../sjcj/SENDXMLSE.action",
		dataType:"json",
		data:{
			FCID : $("#txtFCID").val()
			},
			complete:function()
	        {
				$("#loading").hide();
	        },	
		success:function(msg){
				var bean = msg.t00370Bean;				
				if(bean.result_code == "1"){
					var data = bean.szxxList;
					var b = false;
		             $.each(data, function(i, n){ 
		            	 //判断是否金三通过评估系统取得数据进行纳税fwuuid为空表示没有取得
		            	 if (checkIsNotEmpty(n.fwuuid))
		            	 {
		            		 b = true;
		            	 }
		            	 if(n.cd_00001_sz == "01"){
		            		 $("#txt1").val(n.se);
		            	 }else if(n.cd_00001_sz == "02"){
		            		 $("#txt2").val(n.se);
		            	 }else if(n.cd_00001_sz == "03"){
		            		 $("#txt3").val(n.se);
		            	 }else if(n.cd_00001_sz == "04"){
		            		 $("#txt4").val(n.se);
		            	 }else if(n.cd_00001_sz == "05"){
		            		 $("#txt5").val(n.se);
		            	 }else if(n.cd_00001_sz == "06"){
		            		 $("#txt6").val(n.se);
		            	 }else if(n.cd_00001_sz == "07"){
		            		 $("#txt7").val(n.se);
		            	 }else if(n.cd_00001_sz == "08"){
		            		 $("#txt8").val(n.se);
		            	 }
		               });
					//$("#txtFPID").val(bean.fphm_djz);
					//$("#txtSPID").val(bean.qssphm_djz);
					//$("#txtDFSPID").val(bean.dfgssphm_djz);
		            if (!b)
		            	{
		            	$.notifyBar({cls:"error", html: "没有获取到金三征管完税信息！"});
		            	}
		            else
		            	{
		            	$.notifyBar({cls:"success", html: bean.result_info});
		            	}
					
				}else{
					$.notifyBar({cls:"error", html: bean.result_info});
				}
				
			},
		error:function(msg){
				$.notifyBar({cls:"error", html: '连接失败'});
		}
	});
}



