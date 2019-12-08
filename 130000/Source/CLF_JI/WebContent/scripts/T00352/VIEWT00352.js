$(document).ready(function() {
	//FROM验证信息
	$("#uploadForm").validate({
		rules: {
			upload: {required: true}
		}
	});
	
	$("#ddlSZQYFind").change(function(){
		$("#txtXqnmFind").val("");
		$("#txtXqIdFind").val("");
		getDivXqmcData($('#ddlSZQYFind').val(), '', '#T00352Tree');
	});
	
});

//根据选项，请求action作编辑用
function getXQRdoValue(infoid,infonm){
	//判断点击的单选按钮类型，根据单选按钮类型，为隐藏域赋值
	
	$("#txtXqIdFind").val(infoid);
	searchDate();
};
//显示小区详细信息
function ShowXQXX(xqdm)
{
	Show('../xtwh/DETAILT00352.action?XQDM=' + xqdm,500,400,'XQMC');
}
