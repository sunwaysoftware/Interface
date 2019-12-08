/**
 * 获取列表数据
 * @param qtxzid,noqtxzid,parentid,ACT
 * @author Lee
 */
function getQtxzData(qtxzid,noqtxzid,parentid,ACT){
	var szqy = $('#ddlSZQY').val();
	var xzlx = $('#ddlXZLX').val();
	if( szqy != '' && xzlx != '' ){
		$.ajax({
			  type:'GET',
			  cache: false,
			  url:'TREET00053DIV.action',
			  data:'SZQY=' + szqy + '&XZLX=' + xzlx + '&QTXZID=' + qtxzid +'&NOQTXZID=' + noqtxzid + '&PARENTID=' + parentid + '&ACT=' + ACT,
			  success:function(res){
					 $('#T00053TreeDIV').html(res);
			  },
			  error:function(){
				 $.messager.alert('错误信息','操作失败！','error');
			  }
		});
	} else {
		 $('#T00053TreeDIV').html("");
	}

}
$(document).ready(function() {
	$("#rdoQTXZ").change(function(){
		getSelectedQTXZValue();
	});
});

//获取列表选中键
function getSelectedQTXZValue(){
	return strIsEmpty($("input[name='rdoQTXZ'][type='radio']:checked").val());	
}
//获取列表选中值
function getSelectedQTXZName(){
	return $("input[name='rdoQTXZ'][type='radio']:checked").attr("title");	
}

//获取列表选中值
function getSelectedQTXZparentID(){
	return $("input[name='rdoQTXZ'][type='radio']:checked").attr("parentQTXZID");	
}

/**
 * 其他修正
 * @param qtxzID
 * @return
 */
function openQTXZDialog(szqy,xzlx,qtxzid,obj){
	if (szqy != "" && xzlx !="" ) {
		getDivQtxzData(szqy,xzlx,qtxzid, obj);
		$("#dialog").dialog('open');
	}
}

//嵌入页面的形式打开数据
function getDivQtxzData(szqy,xzlx,qtxzID,obj){
	$(obj).html('');
	$.ajax({
		  type:'GET',
		  url:'TREET00053.action',
		  data:'SZQY=' + szqy + '&XZLX=' + xzlx + '&QTXZID=' + qtxzID,
		  complete:function()
          {
			$("#loading").hide();
		
			$($(obj).find(".expanded")).click(
					 function(){
						 var aQTXZID = $(this).attr("expQTXZID");
						 getDivQtxzData(szqy,xzlx,aQTXZID,obj);
					 	}
					 );
			
			//给列表中的单选按钮添加单击事件
			 
			 //判断函数是否存在
			 if(typeof(getQTXZRdoValue)=="function") {
				 
				 $($(obj).find(".radioQTXZ")).click(
					 function(){			
						 getQTXZRdoValue($(this).val(),$(this).attr("expQTXZNM"));
					 }
				 );
				 var objChk = $(obj).find(".radioQTXZ:checked");
				 if ($(objChk).length==1)
				 {
					 getQTXZRdoValue($(objChk).val(),$(objChk).attr("expQTXZNM"));
				 }
			 };
			
          },
		  success:function(res){
			 $(obj).html(res);
		  },
		  error:function(){
			 $.messager.alert('错误信息','操作失败！','error');
		  }
	});
}

//T00053编辑时用
function getDivQtxzEdit(szqy,xzlx,qtxzID,obj){
	$(obj).html('');
	$.ajax({
		  type:'GET',
		  url:'TREET00053EDIT.action',
		  data:'SZQY=' + szqy + '&XZLX=' + xzlx + '&QTXZID=' + qtxzID,
		  complete:function()
		  {
			$("#loading").hide();
			$($(obj).find(".expanded")).click(
					 function(){
						 var aQTXZID = $(this).attr("expQTXZID");
						 getDivQtxzEdit(szqy,xzlx,aQTXZID,obj);
					 	}
					 );
			
			//给列表中的单选按钮添加单击事件
			 
			 //判断函数是否存在
			 if(typeof(getQTXZRdoValue)=="function") {
				 
				 $($(obj).find(".radioQTXZ")).click(
					 function(){			
						 getQTXZRdoValue($(this).val(),$(this).attr("expQTXZNM"));
					 }
				 );
				 var objChk = $(obj).find(".radioQTXZ:checked");
				 if ($(objChk).length==1)
				 {
					 getQTXZRdoValue($(objChk).val(),$(objChk).attr("expQTXZNM"));
				 }
			 };
			
        },
		  success:function(res){
			 $(obj).html(res);
		  },
		  error:function(){
			 $.messager.alert('错误信息','操作失败！','error');
		  }
	});
}