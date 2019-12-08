$(document).ready(function() {

	//FROM验证信息
	$("#editForm").validate({
		rules: {
			ddlSZQY: {required: true},
			ddlXZLX: {required: true},
			txtQTXZNM: {required: true, maxlength : 200},
			txtXZXS: {required: true, number: true},
			txtVIEWORDER: {required: true, number: true, maxlength: 14},
			txtNOTE: {maxlength : 200},
			rdoQTXZ: {required: true},
			rdoISDIR: {required: true}
		}
	});

	$("#ddlSZQY").change(function(){
		getQtxzData('','','','#ACT');
	});
	$("#ddlXZLX").change(function(){
		getQtxzData('','','','#ACT');
	});
});

//设置其它修正位置信息
function showQTXZR(qtxzid) {
	$.ajax({
		   type: "GET",
		   cache: false,
		   url: "FINDT00053BYQTXZ.action",
		   data: {QTXZID: qtxzid},
		   dataType : "json",
		   success: function(msg){
				var bean = msg.t00053Bean;
				$("#QTXZID").val(bean.qtxzid);
				$("#txtQTXZNM").val(bean.qtxznm);
				$("#txtXZXS").val(bean.xzxs);
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
				getQtxzData(bean.parentid,bean.qtxzid,bean.parentid,'U');
		   },
		   error: function(){
			   $.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
		   }
	});
}
/**
 * 获取列表数据
 * @param szqy,xzlx,parentid
 * @author cheng
 */
function getQtxzDataBySzqy(szqy,xzlx,parentid){
	if( szqy != '' && xzlx != '' ){
		$.ajax({
			  type:'GET',
			  cache: false,
			  url:'TREET00053DIV.action',
			  data:'SZQY=' + szqy + '&XZLX=' + xzlx + '&QTXZID=' + parentid +'&NOQTXZID=' + "" + '&PARENTID=' + parentid + '&ACT=' + 'C',
			  success:function(res){
					 $('#T00053TreeDIV').html(res);
			  },
			  error:function(){
				 alert('操作失败!');
			  }
		});
	} else {
		 $('#T00053TreeDIV').html("");
	}
}