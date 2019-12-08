$(document).ready(function() {

	//FROM验证信息
	$("#editForm").validate({
		rules: {
			ddlSZQY: {required: true},
			rdoXQ: {required: true},
			txtXQNM: {required: true, maxlength : 200,myxqmc:true},
			txtXQBM: {maxlength : 400},
			txtVIEWORDER: {required: true, number: true, maxlength : 14},
			txtNOTE: {required: true, maxlength : 200},
			rdoISDIR: {required: true}
		},
		messages:{
			txtXQNM:{myxqmc:"<img src='../images/exclamation.gif' align='absmiddle' title='你输入的小区名称在其所在区域内重复！'/>"}
			
        }
	});
	
	$.validator.methods.myxqmc = function(value, element, param){
	    //在这里使用上面的三个参数进行校验
		if (value)
		{	
			if ($("#ISEXISTXQNM").val()!="true")
			{
			return true;
			}
		}
		
	};
	//房产证号判断
	$("#txtXQNM").blur(function(){
		var xqnm = $("#txtXQNM").val();
		var Sxqnm= $("#txtXQNM").attr("XQNM");
		if(xqnm != ''){
			if (xqnm != Sxqnm)
				{
					isExistXqnm(xqnm,$("#ddlSZQY").val(),getSelectedXQValue());
				}
				else
				{
					$("#ISEXISTXQNM").val(false);
				}
			
		}
	});	
	$("#ddlSZQY").change(function(){
		getXqmcData('','','','#ACT');
	});
});

//设置小区位置信息
function showXQR(xqdm) {
	$.ajax({
		   type: "GET",
		   cache: false,
		   url: "FINDT00352BYXQ.action",
		   data: {XQDM: xqdm},
		   dataType : "json",
		   success: function(msg){
				var bean = msg.t00352Bean;
				$("#XQDM").val(bean.xqdm);
				$("#txtXQDMH").val(bean.xqdmh);
				$("#txtXQNM").val(bean.xqnm);
				$("#txtVIEWORDER").val(bean.vieworder);
				if (bean.note == null) {
					$("#txtNOTE").val("");
				} else {
					$("#txtNOTE").val(bean.note);
				}
				if (bean.isdir) {
					$("#rdoISDIR1").attr("checked","checked");
				} else {
					$("#rdoISDIR2").attr("checked","checked");
				}
				$("#txtUPDATE").val(formatDateTime(bean.upddate));
				getXqmcData(bean.parentdm,bean.xqdm,bean.parentdm,'U');
		   },
		   error: function(){
			   $.messager.alert('错误信息','请求已发送，服务器无应答！','error');
		   }
	});
}
//设置小区位置信息
function isExistXqnm(xqnm,szqy,parentid) {
	$.ajax({
		   type: "POST",
		   cache: false,
		   url: "FINDT00352AJAX.action",
		   data: {XQNM: xqnm,SQZY:szqy,rdoXQ:parentid},
		   dataType : "json",
		   success: function(msg){
			   if (msg.xqzt!=0)
				   {
				   $("#ISEXISTXQNM").val(true);
				   }
			   else
				   {
				   $("#ISEXISTXQNM").val(false);
				   }			   
		   },
		   error: function(){
			   $.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
		   }
	});
}