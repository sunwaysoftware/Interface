$(document).ready(function() {
	
	//初期加载数据
	BindData();
	
	$("#subA").click(function(){
		if(''==$("#txtPSSDFind").val()){
			$.messager.alert('提示信息','请输入要统计的年份！','warning');
			return;
		}
//		BingData();
		$("#bb").window('open');
		$('#sxkz').show();
	});
	
	/*$("#parA").click(function(){
		$("#bb").window('open');
		$('#sxkz').show();
	});	*/

	//FROM验证信息
	$("#findForm").validate({
		rules: {
			txtPSSDFind: {required: true}
		}
	});
	
	// 税收管辖
	$("#spSSGX").click(function(){
		$("#hidSelect").val("SSGX");
		var infoID = $("#txtSSGX").val();
		openSSGXCONDDialog(infoID, '#infoTreeDIV');
	});
	
	//弹出对话框
	$("#dialog").dialog({
		modal: true,
        shadow: true,
        closed: true,
	       buttons:[{
				text:'选择',
				iconCls:'icon-ok',
				handler:function() {
	    	   $("#dialog").dialog("close");
							var selectValue;
							
							if ($("#hidSelect").val() == "SSGX") {
								selectValue = getSelectedSSGXValue();
								$("#txtSSGX").val(selectValue);
								getSSGX(selectValue,'#txtSSGXTIP');
							}
						}
	               },{
	   				text:'关闭',
					iconCls:'icon-cancel',
					handler:function(){
						$("#dialog").dialog('close');
					}
				}]
			});	
	
	//税收管辖退格清除内容
	$("#txtSSGXTIP").blur(function(){
		var id = $("#txtSSGXTIP").val();
		var flag = isNaN(id);
		
		if(id == '' && !flag){
			
			$("#txtSSGXTIP").val("");
			$("#txtSSGX").val("");
		}
	});
});

function BindData(){
$('#tab').datagrid({					
		
		striped: true,
		height: getGirdHeight(),
		url:'../report/FINDBB00002.action',
		sortOrder: 'desc',
		onLoadError:function(){
			$.messager.alert('错误信息','请求已发送，服务器无应答！','error');
		},
		queryParams : 
	    {
			txtSSGX : $("#txtSSGX").val(),
			ddlFWLX : '',
			txtPSSDFind : $("#txtPSSDFind").val()
		},
		frozenColumns:[[
		                {field:'ssgx', width:150, title:'单位名称', align:'center', rowspan:2}
		    ]],
		columns:[[            
            {title:'一月份',colspan:4},
            {title:'二月份',colspan:4},
            {title:'三月份',colspan:4},
            {title:'四月份',colspan:4},
            {title:'五月份',colspan:4},
            {title:'六月份',colspan:4},
            {title:'七月份',colspan:4},
            {title:'八月份',colspan:4},
            {title:'九月份',colspan:4},
            {title:'十月份',colspan:4},
            {title:'十一月份',colspan:4},
            {title:'十二月份',colspan:4}
	    ],[
			{field:'janHs', width:50, title:'户数', align:'right'},
			{field:'janSbjg', width:90, title:'申报价格(元)', align:'right', formatter:function(value,rec){
				return '￥' + formatNumber(value,'#,##0');
			}},
			{field:'janPgjg', width:90, title:'评估价格(元)', align:'right', formatter:function(value,rec){
				return '￥' + formatNumber(value,'#,##0');
			}},
			{field:'janHdjg', width:90, title:'核定价格(元)', align:'right', formatter:function(value,rec){
				return '￥' + formatNumber(value,'#,##0');
			}},
			{field:'febHs', width:50, title:'户数', align:'right'},
			{field:'febSbjg', width:90, title:'申报价格(元)', align:'right', formatter:function(value,rec){
				return '￥' + formatNumber(value,'#,##0');
			}},
			{field:'febPgjg', width:90, title:'评估价格(元)', align:'right', formatter:function(value,rec){
				return '￥' + formatNumber(value,'#,##0');
			}},
			{field:'febHdjg', width:90, title:'核定价格(元)', align:'right', formatter:function(value,rec){
				return '￥' + formatNumber(value,'#,##0');
			}},
			{field:'marHs', width:50, title:'户数', align:'right'},
			{field:'marSbjg', width:90, title:'申报价格(元)', align:'right', formatter:function(value,rec){
				return '￥' + formatNumber(value,'#,##0');
			}},
			{field:'marPgjg', width:90, title:'评估价格(元)', align:'right', formatter:function(value,rec){
				return '￥' + formatNumber(value,'#,##0');
			}},
			{field:'marHdjg', width:90, title:'核定价格(元)', align:'right', formatter:function(value,rec){
				return '￥' + formatNumber(value,'#,##0');
			}},
			{field:'arpHs', width:50, title:'户数', align:'right'},
			{field:'arpSbjg', width:90, title:'申报价格(元)', align:'right', formatter:function(value,rec){
				return '￥' + formatNumber(value,'#,##0');
			}},
			{field:'arpPgjg', width:90, title:'评估价格(元)', align:'right', formatter:function(value,rec){
				return '￥' + formatNumber(value,'#,##0');
			}},
			{field:'arpHdjg', width:90, title:'核定价格(元)', align:'right', formatter:function(value,rec){
				return '￥' + formatNumber(value,'#,##0');
			}},
			{field:'mayHs', width:50, title:'户数', align:'right'},
			{field:'maySbjg', width:90, title:'申报价格(元)', align:'right', formatter:function(value,rec){
				return '￥' + formatNumber(value,'#,##0');
			}},
			{field:'mayPgjg', width:90, title:'评估价格(元)', align:'right', formatter:function(value,rec){
				return '￥' + formatNumber(value,'#,##0');
			}},
			{field:'mayHdjg', width:90, title:'核定价格(元)', align:'right', formatter:function(value,rec){
				return '￥' + formatNumber(value,'#,##0');
			}},
			{field:'junHs', width:50, title:'户数', align:'right'},
			{field:'junSbjg', width:90, title:'申报价格(元)', align:'right', formatter:function(value,rec){
				return '￥' + formatNumber(value,'#,##0');
			}},
			{field:'junPgjg', width:90, title:'评估价格(元)', align:'right', formatter:function(value,rec){
				return '￥' + formatNumber(value,'#,##0');
			}},
			{field:'junHdjg', width:90, title:'核定价格(元)', align:'right', formatter:function(value,rec){
				return '￥' + formatNumber(value,'#,##0');
			}},
			{field:'julHs', width:50, title:'户数', align:'right'},
			{field:'julSbjg', width:90, title:'申报价格(元)', align:'right', formatter:function(value,rec){
				return '￥' + formatNumber(value,'#,##0');
			}},
			{field:'julPgjg', width:90, title:'评估价格(元)', align:'right', formatter:function(value,rec){
				return '￥' + formatNumber(value,'#,##0');
			}},
			{field:'julHdjg', width:90, title:'核定价格(元)', align:'right', formatter:function(value,rec){
				return '￥' + formatNumber(value,'#,##0');
			}},
			{field:'augHs', width:50, title:'户数', align:'right'},
			{field:'augSbjg', width:90, title:'申报价格(元)', align:'right', formatter:function(value,rec){
				return '￥' + formatNumber(value,'#,##0');
			}},
			{field:'augPgjg', width:90, title:'评估价格(元)', align:'right', formatter:function(value,rec){
				return '￥' + formatNumber(value,'#,##0');
			}},
			{field:'augHdjg', width:90, title:'核定价格(元)', align:'right', formatter:function(value,rec){
				return '￥' + formatNumber(value,'#,##0');
			}},
			{field:'sepHs', width:50, title:'户数', align:'right'},
			{field:'sepSbjg', width:90, title:'申报价格(元)', align:'right', formatter:function(value,rec){
				return '￥' + formatNumber(value,'#,##0');
			}},
			{field:'sepPgjg', width:90, title:'评估价格(元)', align:'right', formatter:function(value,rec){
				return '￥' + formatNumber(value,'#,##0');
			}},
			{field:'sepHdjg', width:90, title:'核定价格(元)', align:'right', formatter:function(value,rec){
				return '￥' + formatNumber(value,'#,##0');
			}},
			{field:'octHs', width:50, title:'户数', align:'right'},
			{field:'octSbjg', width:90, title:'申报价格(元)', align:'right', formatter:function(value,rec){
				return '￥' + formatNumber(value,'#,##0');
			}},
			{field:'octPgjg', width:90, title:'评估价格(元)', align:'right', formatter:function(value,rec){
				return '￥' + formatNumber(value,'#,##0');
			}},
			{field:'octHdjg', width:90, title:'核定价格(元)', align:'right', formatter:function(value,rec){
				return '￥' + formatNumber(value,'#,##0');
			}},
			{field:'novHs', width:50, title:'户数', align:'right'},
			{field:'novSbjg', width:90, title:'申报价格(元)', align:'right', formatter:function(value,rec){
				return '￥' + formatNumber(value,'#,##0');
			}},
			{field:'novPgjg', width:90, title:'评估价格(元)', align:'right', formatter:function(value,rec){
				return '￥' + formatNumber(value,'#,##0');
			}},
			{field:'novHdjg', width:90, title:'核定价格(元)', align:'right', formatter:function(value,rec){
				return '￥' + formatNumber(value,'#,##0');
			}},
			{field:'decHs', width:50, title:'户数', align:'right'},
			{field:'decSbjg', width:90, title:'申报价格(元)', align:'right', formatter:function(value,rec){
				return '￥' + formatNumber(value,'#,##0');
			}},
			{field:'decPgjg', width:90, title:'评估价格(元)', align:'right', formatter:function(value,rec){
				return '￥' + formatNumber(value,'#,##0');
			}},
			{field:'decHdjg', width:90, title:'核定价格(元)', align:'right', formatter:function(value,rec){
				return '￥' + formatNumber(value,'#,##0');
			}}		
	    ]]	
	});
}


//绑定数据
function searchData(){
	var selvalue="";
	$("input[id='ddlFWLX'][type=checkbox]:checked").each(function() { //由于复选框一般选中的是多个,所以可以循环输出
		selvalue = selvalue + $(this).val() + ",";
    });
	$('#tab').datagrid('options').queryParams = 
    {
		txtSSGX : $("#txtSSGX").val(),
		ddlFWLX : selvalue,
		txtPSSDFind : $("#txtPSSDFind").val()
	};
	$('#tab').datagrid('reload');
};


