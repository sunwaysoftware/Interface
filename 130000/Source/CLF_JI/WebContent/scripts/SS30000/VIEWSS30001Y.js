$(document).ready(function() {
	//选择估价
	$('#print').click(function()
	{ 	
		var b = false;
		$(".childCheck").each(function() {	
			if 	($(this)[0].checked)	
			{
				b = true;
			}
		});
		if (!b)
		{
			alert('请选择要操作的数据！');
			return;
		}
		//行政复议期限
		var qixian = $("#txtQIXIAN").val();
		if (qixian == null || qixian == "") {
			alert('请输入行政复议期限！');
			return;
		}
		if (!checkIsInteger(qixian)) {
			alert('行政复议期限为数字，请重新输入！');
			return;
		}
		$("#findForm").attr("target","_blank");
		$("#findForm").attr("action", "../psjgcl/PrintNSSC.action?T=" + qixian);
		$("#findForm").submit();
	});
});