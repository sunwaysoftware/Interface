$(document).ready(function() {
/*	$("#delBtn").click(function(){
		if(!window.confirm('是否确定删除该小区全部图片？')) return;
		$("#loading").show();
		$("#delForm").submit();
	});*/
	
	$("#delForm").submit(function(){
		$("#loading").show();
		if(window.confirm('是否确定删除该楼房全部图片？')){
			return true;
		}else{
			$("#loading").hide();
			return false;
		}
	});
	
/*	$("#upBtn").click(function(){
		if(check(".jpg", $("#txtFile").val(), "请选择.jpg格式图片")){
			$("#loading").show();
			$("#editForm").submit();
//			$("#loading").hide();
		}
	});*/
	
	$("#editForm").submit(function(){
		$("#loading").show();
		if(check(".jpg", $("#txtFile").val(), "请选择.jpg格式图片")){
			return true;
		}else{
			$("#loading").hide();
			return false;
		}
	});
	
	//FROM验证信息
	$("#editForm").validate({
		rules: {
			txtFile: {required: true}
		}
	});
	
	$("#rarBtn").click(function(){

		if($("#divUploadByRar").attr("sign") == 0){
			$("#divUploadByRar").show();
			$("#divUploadByRar").attr("sign", 1);
		}else{
			$("#divUploadByRar").hide();
			$("#divUploadByRar").attr("sign", 0);
		}
		
	});
	
/*	$("#rarUpBtn").click(function(){
		if(check(".rar", $("#txtRar").val(), "请选择.rar格式压缩包")){
			$("#loading").show();
			$("#rarUplForm").attr("action","UPLOADPHOTOBYRAR.action?txtXQDMR=" + $("#txtXQDMR").val());
			$("#rarUplForm").submit();
//			$("#loading").hide();
		}
	});*/
	
	$("#rarUplForm").submit(function(){
		$("#loading").show();
		if(check(".rar", $("#txtRar").val(), "请选择.rar格式压缩包")){
			return true;
		}else{
			$("#loading").hide();
			return false;
		}
	});
	
	//FROM验证信息
	$("#rarUplForm").validate({
		rules: {
			txtRar: {required: true}
		}
	});
});
function MyTip(obj,tips)
{ 
	Tip(obj,'图片',tips,100);
	return true;	
}
/**
 * 彈出窗口
 */
function showWin(zpid){
	Show("../sjcj/DETAILT00352F.action?txtXQDM="+$("#txtXQDM").val()+"&txtZPID="+zpid, 400, 800, zpid);
}

/**
 * 判断文件类型 
 * @param ext
 * @param fileName
 * @param msg
 * @return
 */
function check(ext, fileName, msg) {
    var policy = ext;
    var fileName = fileName;
    var displayName = fileName.substring(fileName.lastIndexOf("\\")+1);

    var p = fileName.toLowerCase().lastIndexOf('.');
    var pass = true;
  

    if (p == -1) {
  	    alert(msg);
  	    return false;
    }else {
      var extName = fileName.substring(p).toLowerCase();
      if (policy.indexOf(extName) == -1) {
    	  alert(msg);
    	  return false;
      }
    }
  
    return true;
	  
}

function delPhoto(cd00306Id, Act, cd00352Xqdm, zpid){

	$("#loading").show();
	if(window.confirm('是否确定删除该小区全部图片？')){
		/*$("#delSimplePhotoForm").attr("action", "EDITT00306F.action?CD00306ID="+cd00306Id+"&ACT="+ Act +"&txtXQDM="+ cd00352Xqdm +"&txtZPID=" + zpid + "");
		$("#delSimplePhotoForm").submit();*/
		$.ajax({
			type : 'POST',
			url : 'EDITT00306F.action',
			cache : false,
			data : {
						CD00306ID : cd00306Id,
						ACT : Act,
						txtXQDM : cd00352Xqdm,
						txtZPID : zpid
					},
		    complete : function(){
						$("#loading").hide();
					},
			success : function(msg){
						searchDate();
					},
			error : function(){
						
					}
		});
	}else{
		$("#loading").hide();
		return false;
	}
	
	
}
