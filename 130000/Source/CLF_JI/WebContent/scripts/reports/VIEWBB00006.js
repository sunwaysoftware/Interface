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
		url:'../report/FINDBB00006.action',
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
           {field:'pgzzs',title:'评估总宗数',rowspan:2,align:'right',width:80,formatter:function(value, rec){
        	   return formatNumber(value, '#,##0');
           }},
           {field:'pgzsbl',title:'占比',rowspan:2,align:'right',width:80,formatter:function(value, rec){
        	   return formatNumber(value, '#,##0.00');
           }},
           {field:'pgzmj',title:'评估总面积',rowspan:2,align:'right',width:80,formatter:function(value, rec){
        	   return formatNumber(value, '#,##0.00');
           }},
           {title:'系统评估',colspan:2},
           {title:'个案评估',colspan:2},
           {title:'已完税',colspan:2},
           {title:'未完税',colspan:2}
       ],[  
           {field:'xtpgzs',title:'宗数',width:80,align:'right',formatter:function(value, rec){
        	   return formatNumber(value, '#,##0');
           }},  
           {field:'xtpgzsbl',title:'占比',width:80,align:'right',formatter:function(value, rec){
        	   return formatNumber(value, '#,##0.00');
           }},
           {field:'gapgzs',title:'宗数',width:80,align:'right',formatter:function(value, rec){
        	   return formatNumber(value, '#,##0');
           }},  
           {field:'gapgzsbl',title:'占比',width:80,align:'right',formatter:function(value, rec){
        	   return formatNumber(value, '#,##0.00');
           }},
           {field:'ywszs',title:'宗数',width:80,align:'right',formatter:function(value, rec){
        	   return formatNumber(value, '#,##0');
           }},
           {field:'ywszsbl',title:'占比',width:80,align:'right',formatter:function(value, rec){
        	   return formatNumber(value, '#,##0.00');
           }},
           {field:'wwszs',title:'宗数',width:80,align:'right',formatter:function(value, rec){
        	   return formatNumber(value, '#,##0');
           }}, 
           {field:'wwszsbl',title:'占比',width:80,align:'right',formatter:function(value, rec){
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

