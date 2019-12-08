$(document).ready(function() {

	$("#dialog").dialog({
		modal: true,
        shadow: true,
        closed: true,
	       buttons:[{
				text:'添加',
				iconCls:'icon-add',
				handler:function(){
		    	   var selectValue = getSelectedSZQYValue();
					var displayValue = getSelectedSZQYName();
					var szqy = $("#hidSZQY").val();
					if (szqy.search(selectValue)==-1) {
						$("#ddlSZQY").append(
								"<span class=\"qtxz\">" + displayValue
										+ " <a href=\"javascript:;\" SZQY=\"" + selectValue
										+ "\" onclick=\"szqyClick(this);\">[删]</a></span>");
						$("#hidSZQY").val($("#hidSZQY").val() + selectValue +',');
					}else{
						alert("已选择！");
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
	$("#btnAddSZQY").click(function(){
		openSZQYDialog('',"#infoTreeDIV");
	});	
	
	//保存
	$("#btnSave").click(function(){
		
		SaveData();
	
	});
	
	$('#ssgxTree').tree({
		animate: true,
		url: 'TREEssgx.action',
		//data: data,
		onClick: function(node){
			//alert('当前节点：'+ node.id + node.text);
		    GetData(node.id);
		}
	});
	
});

//得到数据
function GetData(id){
	
	$("#SSGXId").val(id);
	$("#ddlSZQY").html("");
	$("#hidSZQY").val("");
	$.ajax({
		   type: "GET",
		   cache: false,
		   url: "FINDT00052.action",
		   data: {SSGXId:id},
	       success: function(msg){
			   var data = msg.szqyList;
			   $.each(data, function(i, n){
				   $("#ddlSZQY").append(
							"<span class=\"qtxz\">" + n.szqy
									+ " <a href=\"javascript:;\" SZQY=\"" + n.cd00001Szqy
									+ "\" onclick=\"szqyClick(this);\">[删]</a></span>");
					$("#hidSZQY").val($("#hidSZQY").val() + n.cd00001Szqy +',');
			   });
		   },
		   error: function(){
			   $.messager.alert('错误信息','请求已发送，服务器无应答！','error');
		   }	 
		 
	});	
}

//其它修正
function szqyClick(obj) {
	var szqy = $("#hidSZQY").val();
	var selectszqy = $(obj).attr("SZQY")+',';
	$("#hidSZQY").val(szqy.replace(selectszqy, ''));
	$(obj).parent().remove();
};
//后台保存数据
function SaveData()
{
	$.ajax({
		   type: "GET",
		   cache: false,
		   url: "EDITT00052.action",
		   data: {hidSZQY:$("#hidSZQY").val(),
					SSGXId:$("#SSGXId").val()},
	       success: function(msg){
			$.notifyBar({cls: "success", html: '修改成功'});
		   },
		   error: function(){
			   $.messager.alert('错误信息','请求已发送，服务器无应答！','error');
		   }	 
		 
	});	
}