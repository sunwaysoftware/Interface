$(document).ready(function() {
	
	
	//初期加载数据
	BindDate();
	
	$("#subA").click(function(){		
//		BingData();	
		$("#bb").window('open');
		$("#sxkz").show();
	});
	
	/*$("#parA").click(function(){
		$("#bb").window('open');
	});*/

	$("#expA").click(function(){
		$("#findForm").submit();
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
});


//绑定数据
function BindDate(){
	$('#tab').datagrid({					
		striped: true,
		height:getGirdHeight(),
		url:'../report/FINDBB00007.action',
		sortOrder: 'desc',
		onLoadError:function(){
			$.messager.alert('错误信息','请求已发送，服务器无应答！','error');
		},
		queryParams : 
	    {
			txtSSGX : $("#txtSSGX").val(),
			txtPSSDMIN : $("#txtPSSDMIN").val(),
			txtPSSDMAX : $("#txtPSSDMAX").val()
		},
		columns:
	   [[  
           {field:'cd00002Pssd',title:'所属月份',rowspan:2,align:'center',width:80},  
           {field:'fwlx',title:'房屋类型',rowspan:2,align:'center',width:80},
           {field:'kpzzs',title:'开票总宗数',rowspan:2,align:'right',width:80,formatter:function(value, rec){
        	   return formatNumber(value, '#,##0');
           }},
           {field:'kpzmj',title:'开票总面积',rowspan:2,align:'right',width:80,formatter:function(value, rec){
        	   return formatNumber(value, '#,##0.00');
           }},
           {title:'合同申报',colspan:2},
           {title:'系统评估',colspan:3},
           {title:'契税',colspan:2},
           {title:'增值税',colspan:2},
           {title:'城市维护建设税',colspan:2},
           {title:'教育费附加',colspan:2},
           {title:'个人所得税',colspan:2},
           {title:'印花税',colspan:2},
           {title:'土地增值税',colspan:2},
           {title:'税额合计',colspan:3}
       ],[  
           {field:'htsbzj',title:'总价',width:80,align:'right',formatter:function(value, rec){
        	   return formatNumber(value, '#,##0.00');
           }},  
           {field:'htsbjj',title:'均价',width:80,align:'right',formatter:function(value, rec){
        	   return formatNumber(value, '#,##0.00');
           }},
           {field:'xtpgzj',title:'总价',width:80,align:'right',formatter:function(value, rec){
        	   return formatNumber(value, '#,##0.00');
           }},  
           {field:'xtpgjj',title:'均价',width:80,align:'right',formatter:function(value, rec){
        	   return formatNumber(value, '#,##0.00');
           }},
           {field:'xtpgzjl',title:'增减率',width:80,align:'right',formatter:function(value, rec){
        	   return formatNumber(value, '#,##0.00');
           }},
           {field:'qssb',title:'申报计税',width:80,align:'right',formatter:function(value, rec){
        	   return formatNumber(value, '#,##0.00');
           }},
           {field:'qspg',title:'评估计税',width:80,align:'right',formatter:function(value, rec){
        	   return formatNumber(value, '#,##0.00');
           }},
           {field:'yyssb',title:'申报计税',width:80,align:'right',formatter:function(value, rec){
        	   return formatNumber(value, '#,##0.00');
           }},
           {field:'yyspg',title:'评估计税',width:80,align:'right',formatter:function(value, rec){
        	   return formatNumber(value, '#,##0.00');
           }},
           {field:'cswhjsssb',title:'申报计税',width:80,align:'right',formatter:function(value, rec){
        	   return formatNumber(value, '#,##0.00');
           }},
           {field:'cswhjsspg',title:'评估计税',width:80,align:'right',formatter:function(value, rec){
        	   return formatNumber(value, '#,##0.00');
           }},
           {field:'jyffjsb',title:'申报计税',width:80,align:'right',formatter:function(value, rec){
        	   return formatNumber(value, '#,##0.00');
           }},
           {field:'jyffjpg',title:'评估计税',width:80,align:'right',formatter:function(value, rec){
        	   return formatNumber(value, '#,##0.00');
           }},
           {field:'grsdssb',title:'申报计税',width:80,align:'right',formatter:function(value, rec){
        	   return formatNumber(value, '#,##0.00');
           }},
           {field:'grsdspg',title:'评估计税',width:80,align:'right',formatter:function(value, rec){
        	   return formatNumber(value, '#,##0.00');
           }},
           {field:'yhssb',title:'申报计税',width:80,align:'right',formatter:function(value, rec){
        	   return formatNumber(value, '#,##0.00');
           }},
           {field:'yhspg',title:'评估计税',width:80,align:'right',formatter:function(value, rec){
        	   return formatNumber(value, '#,##0.00');
           }},
           {field:'tdzzssb',title:'申报计税',width:80,align:'right',formatter:function(value, rec){
        	   return formatNumber(value, '#,##0.00');
           }},
           {field:'tdzzspg',title:'评估计税',width:80,align:'right',formatter:function(value, rec){
        	   return formatNumber(value, '#,##0.00');
           }},
           {field:'sehjsb',title:'申报计税',width:80,align:'right',formatter:function(value, rec){
        	   return formatNumber(value, '#,##0.00');
           }},
           {field:'sehjpg',title:'评估计税',width:80,align:'right',formatter:function(value, rec){
        	   return formatNumber(value, '#,##0.00');
           }},
           {field:'sehjzjl',title:'评估计税',width:80,align:'right',formatter:function(value, rec){
        	   return formatNumber(value, '#,##0.00');
           }}
           
           
       ]],  
       rownumbers:true
			
		
	});
};

//绑定数据
function searchData(){
	$('#tab').datagrid('options').queryParams = 
    {
		txtSSGX : $("#txtSSGX").val(),
		txtPSSDMIN : $("#txtPSSDMIN").val(),
		txtPSSDMAX : $("#txtPSSDMAX").val()
	};
	$('#tab').datagrid('reload');	
};

