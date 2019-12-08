$(document).ready(function() {
	//添加
	$("#ddlSSGX").change(function(){		
		$("#flashForm").submit();		
	});	
	
	openPwd();            
    //
    $('#editpass').click(function() {
    	$('#iSetPwd').attr('src','xtwh/VIEWSETTING.action');
        $('#w').window('open');
    });    

	$('#btnCancel').click(function(){closePwd();});           

    $('#loginOut').click(function() {
        $.messager.confirm('系统提示', '您确定要退出本次登录吗?', function(r) {

            if (r) {
                location.href = 'LOGOUT.action';
            }
        });
    });		
});

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
	Show("xtwh/VIEWSETTING.action", 300, 450, "VIEWSETTING");
}