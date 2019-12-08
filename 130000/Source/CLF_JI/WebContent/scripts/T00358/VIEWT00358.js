$(document).ready(function() {
	//FROM验证信息
	$("#editForm").validate({
		rules: {
			txtFCID : {required: true},
			txtSLID : {required: true, mySLID:true}
		},
		messages:{
			txtSLID:{mySLID:"<img src='../images/exclamation.gif' title='实例个数不够！'/>"}
        }
	});

	
	//这里定义了一个名为equal的规则
	//value是指当前校验域的值
	//element是指当前检验的域
	//param是指在rules中设定的参数
	//这三个参数会在进行校验时由系统自动带入
	$.validator.methods.mySLID = function(value, element, param){
	    //在这里使用上面的三个参数进行校验    
		if (value)
		{
			//如果该对象不存在说明是添加。添加时不用判断。
			var sls = value.split(",");
			var sl1 = "";
			if (sls.length > 0)
			{
				sl1 = sls[0];
			}
			if (sl1.indexOf('BZ')==0 || sl1.indexOf('BB')==0)
			{
				if (sls.length > 1)
				{
					return true;//如果当前域的值等于指定的参数就通过校验
				}
			}
			else
			{
				if (sls.length > 3)
				{
					return true;//如果当前域的值等于指定的参数就通过校验
				}
			}
		}		
	};
});


/**
 * Save SCSL list
 * @param obj
 * @return
 */
function saveSL(selectValue){
	var sl = $("#txtSLID").val();
	var sls = sl.split(",");
	if (sls.length > 3)
	{
		alert("最后选择三个实例！");
	}
	else
	{	
		if (sls.length>0)
		{
			if (sls[0].indexOf('BZ')==0)
			{
				alert("最后选择一个标准实例！");	
				return;
			}
		}
		
		if (sl.search(selectValue)==-1) {
			$("#txtSLID").val($("#txtSLID").val()+selectValue+",");
			$("#ddlSL").append(
					"<span class=\"qtxz\">" + selectValue
							+ " <a href=\"javascript:;\" QTXZ=\"" + selectValue
							+ "\" onclick=\"qtxzClick(this);\">[删]</a></span>");
		}else{
			alert("已选择！");
		}
		
	}
}

//其它修正
function qtxzClick(obj) {
	var qtxz = $("#txtSLID").val();
	var selectQtxz = $(obj).attr("QTXZ")+',';
	$("#txtSLID").val(qtxz.replace(selectQtxz, ''));
	$(obj).parent().remove();
};

/**
 * 彈出窗口
 * @param value 稅務ID
 * @return
 */
function showWin(value){
	Show("../sjsh/FINDSCSHNGMX.action?txtSWIDFind="+value, 500, 850, value);
}