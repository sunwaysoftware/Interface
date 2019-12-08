$(document).ready(function() {

	
});

//根据选项，请求action作编辑用
function getQTXZRdoValue(infoid,infonm){
	//判断点击的单选按钮类型，根据单选按钮类型，为隐藏域赋值
	$("#TIPQTXZMC").text(infonm);
	$("#QTXZID").val(infoid);
	window.parent.showQTXZR(infoid);
};