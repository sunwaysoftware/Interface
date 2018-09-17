$(document).ready(function() {
	//添加
	$("#ddlSSGX").change(function(){		
		$("#flashForm").submit();		
	});	
	
	$('#loginOut').click(function() {
		window.opener = null;
		//window.open('', '_parent');
		//window.close();
		window.self.close();
		top.location.href = 'LOGOUT.action';
    }); 
	
	openPwd();            
    //
    $('#editpass').click(function() {
    	$('#iSetPwd').attr('src','xtwh/VIEWSETTING.action');
        $('#w').window('open');
    });    

	$('#btnCancel').click(function(){closePwd();});     
	
	//分布选择改变事件
	$("#tabs").tabs({		
		onSelect:function(title) {	
		    
			if(title=="工作状态")
			{		
				if(!$("#workStateFrame").attr("src"))
				{
					$("#workStateFrame").attr("src","workState.jsp");
				}
			}
			if(title=="最新公告")
			{	
				if(!$("#versionFrame").attr("src"))
				{
					$("#versionFrame").attr("src","notice.jsp");
				}
			}
    	}	
	});
});

//添加浏览通知人
function addGG(id,divname){
	var url = "xtwh/ADDT003701.action";
	var data = {txtID : id};		
	$.ajax({
		type: "POST",
		url: url,
		cache: false,
		data: data,
		dataType: "html",
		success: function(myMsg){
			if (myMsg!="OK")
				{
				$.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
				}else
					{
					$(divname).window('close');
					}
		},		
		error: function(){
			$.notifyBar({cls:"error", html: '请求已发送，服务器无应答'});
		}
	});
}

//设置登录窗口
function openPwd() {
    $('#w').window({
        title: '个人设置',
        width: 450,
        modal: true,
        shadow: true,
        closed: true,
        height: 250,
        resizable:false
    });
}
//关闭登录窗口
function closePwd() {
    $('#w').window('close');
}        

/**
 * 
 * @return
 */
function showSetting(){
	Show("xtwh/VIEWSETTING.action", 125, 400, "VIEWSETTING");
}