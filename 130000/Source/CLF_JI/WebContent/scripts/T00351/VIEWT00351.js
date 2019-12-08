$(document).ready(function() {
	//FROM验证信息
	$("#uploadForm").validate({
		rules: {
			upload: {required: true}
		}
	});
	
	//查询
	$("#selDel").click(function(){
		DelData();

	});	

	$("#ddlSZQYFind").change(function(){
		$("#txtXQFind").val("");
		getDivXqmcEdit($('#ddlSZQYFind').val(), '', '#T00352Tree');
	});
});



//根据选项，请求action作编辑用
function getXQRdoValue(infoid,infonm){
	//判断点击的单选按钮类型，根据单选按钮类型，为隐藏域赋值
	$("#TIPXQMC").text(infonm);
	$("#XQDM").val(infoid);
	$("#txtXQFind").val(infoid);
	searchDate();
};

function DelData(){
	/*$("#loading").ajaxStart(
        function()
        {
         $("#loading").show();
        }
    );*/
	var selvalue="";
	$("input[id='chkSel'][type=checkbox]:checked").each(function() { //由于复选框一般选中的是多个,所以可以循环输出
		selvalue = selvalue + $(this).val() + ",";
    });
    if (selvalue=="")
	{
		$.notifyBar({cls:"error", html: '请选择要删除的数据！'});
		return;
	}
	var url = "xtwh/DELSELT00351.action";
	var data = {chkSel : selvalue
			};
			
	$.ajax({
		   type: "POST",
		   url: url,
		   cache: false,
		   data: data,
		   dataType: "html",
		   complete:function()
           {
				$("#loading").hide();
           },
		   success: function(msg){
			    $('#test').datagrid('reload');	
			  
		   },
		   error: function(){
			   $("#loading").hide();
			   $.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
		   }
	});
}