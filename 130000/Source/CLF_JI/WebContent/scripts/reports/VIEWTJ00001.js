$(document).ready(function() {	
	

	//FROM验证信息
	$("#findForm").validate({
		rules: {
			txtRdsjBgn: {required: true},
			txtRdsjEnd: {required: true}
		}
	});	
	
	$("#subA").click(function(){
		if ($("#findForm").validate()) {
			$('#tab').datagrid('options').queryParams = 
            {
				txtRdsjBgn : $("#txtRdsjBgn").val(),
				txtRdsjEnd : $("#txtRdsjEnd").val()
			};
			$('#tab').datagrid('options').url='../report/FINDTJ00001.do';
			$('#tab').datagrid('reload');
		}
	});
	
	BindDate();
	

});

function BindDate(){
$('#tab').datagrid({
		striped: true,
		height: getGirdHeight(),		
		sortOrder: 'desc',
		onLoadError:function(){
			$.messager.alert('错误信息','请求已发送，服务器无应答！','error');
		},
		queryParams : 
	    {
			txtRdsjBgn : $("#txtRdsjBgn").val(),
			txtRdsjEnd : $("#txtRdsjEnd").val()
		},
		frozenColumns:[[
            {field:'ssgx', width:150, title:'单位名称', align:'center', rowspan:2}
					]],
		columns:[[            
            {title:'申报宗数', field:'hs', width:80, align:'center', rowspan:2},
            {title:'申报总价', field:'sbjg', width:80, align:'right', rowspan:2},
            {title:'评估总价', field:'pgjg', width:80, align:'right', rowspan:2},
            {title:'评估价较申报价', colspan:2},
            {title:'核定总价', field:'hdjg', width:80, align:'right', rowspan:2},
            {title:'征收税款', colspan:5},
            {title:'提升税款金额', field:'tsskje', width:80, align:'right', rowspan:2},
            {title:'异议处理次数', field:'yyclCnt', width:80, align:'right', rowspan:2},
            {title:'个案评估次数', field:'gapgCnt', width:80, align:'right', rowspan:2},
            {title:'税负率', field:'sfl', width:50, align:'right', rowspan:2}
	    ],[
            {field:'pgsbZje',title:'增加额',  width:80, align:'right'},
            {field:'pgsbZf', title:'增幅',  width:50, align:'right'},	       
			{field:'skSum', width:90, title:'总额', align:'right'},
			{field:'skQs', width:80, title:'其中契税', align:'right'},
			{field:'skYys', width:80, title:'其中增值税', align:'right'},
			{field:'skGrsds', width:80, title:'其中个税', align:'right'},			
			{field:'skYhs', width:80, title:'其中印花税', align:'right'}
	    ]]	
	});
}

