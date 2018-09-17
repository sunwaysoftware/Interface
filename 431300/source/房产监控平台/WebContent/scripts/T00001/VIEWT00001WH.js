$(document).ready(function(){
	
	//查询
	$("#subA").click(function(){
		$('#w').window('open');	
		$("#sxkz").show();
	});
	//导出
	$("#subB").click(function(){
		$("#findForm").attr("action", "");
		if($("#viewKey").val() == "014")//区域维护
		{
			$("#findForm").attr("action", "EXPT00001QYWH.action");
		}else if($("#viewKey").val() == "003")//税务机关
		{
			$("#findForm").attr("action", "EXPT00001SWJG.action");
		}else if($("#viewKey").val() == "000")//综合修正
		{
			$("#findForm").attr("action", "EXPT00001ZHXZ.action");
		}else
		{
			$("#findForm").attr("action", "EXPT00001.action");
		}
		$("#findForm").submit();
	});
	//对象编号
	$("#txtROOTIDFind").blur(function(){
		$("#ddlROOTIDFind").val($("#txtROOTIDFind").val());
	});
	
	

	getInfoDataHW($("#ddlROOTIDFind").val(),$("#ddlROOTIDFind").val(),null,'C');
	//getMaxInfoId($("#ddlROOTIDFind").val());
});

function getList(rootID,infoID,parentID,noinfoID,ACT,infoNM){
	getInfoDataHW(rootID,infoID,parentID,noinfoID,ACT);
	$("#ddlROOTIDFind").val(rootID);
	/*$("#txtINFONMFind").val(infoNM);
	if(infoID == '014' || infoID == '003' || infoID == '000'){
		$("#txtINFONMFind").val('');
	}*/
	$("#txtINFOID").val(infoID);
	searchDate();
}

/**
 *获取列表数据
 * @param rootID,infoID,noinfoID,ACT
 * @author Lee
 */

function getInfoDataHW(rootID,infoID,parentID,noinfoID,ACT){
	$.ajax({
		  type:'GET',
		  cache: false,
		  url:'TREET00001HW.action',
		  data:'ROOTID=' + rootID + '&INFOID=' + infoID+ '&PARENTID=' + parentID+ '&NOINFOID=' + noinfoID + '&ACT=' + ACT,
		  success:function(res){
				 $('#infoTreeDIV').html(res);
		  },
		  error:function(){
			 alert('操作失败!');
		  }
	});

}

function getMaxInfoId(rootID){
	//取得infoId采番最大值
	$.ajax({
	  type:'GET',
	  cache: false,
	  url:'GETMAXINFOID.action',
	  data:'ROOTID='+ rootID,
	  success:function(res){ 
		 $('#txtINFOID').val(res);
	  },
	  error:function(){
		 alert('意外错误导致申请失败!');
	  }
	});		
}