$(document).ready(function() {
	//评估
	$('#PG').click(function()
	{ 	
		var selvalue="";
		$("input[id='chkSel'][type=checkbox]:checked").each(function() { //由于复选框一般选中的是多个,所以可以循环输出
			selvalue = selvalue + $(this).val() + ",";
	    });
		if (selvalue=="")		
		{
			$.messager.alert('警告信息','请选择要操作的数据！','warning');
			return;
		}
		
		$("#hidFlag").val(1);
		$("input[id='chkSel'][type=hidden]").val(selvalue);	
		AppSubmit();
	});
	//评估所有的
	$('#PGALL').click(function()
	{ 				
		$.messager.confirm('系统提示', '您确定要全部评估吗?', function(r) {
            if (r) {
            	$("#hidFlag").val(2);
        		AppSubmit();
            }
        });
		
	});
});


/**
 * 彈出窗口
 * @param value 稅務ID
 * @return
 */
function showWin(value){
	Show("FINDSCPGNGMX.action?txtSWIDFind="+value, 330, 400, value);
}