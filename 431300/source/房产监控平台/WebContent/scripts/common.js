//常量定义
//居民身份证
var INFO_ZJLX_01 = "01";
//高层
var INFO_FWLX_03 = "03";
//非住宅
var INFO_FWLX_07 = "07";

function FunParam(value){	
	return value.replace(/\\/g,"\\\\").replace(/'/g,"&acute;").replace(/"/g,"&quot;");
}

function addZHXZ(cd00053Qtxzid,ParentId,Qtxznm,IsDir,IsId){

	var obj = $("#tt1 #ZH"+ ParentId);
	if (obj.length==0)
		{
		obj= $("#tt1");	
		}
	if (IsDir)
		{
		obj.append("<span class=\"labwidth\"><span class=\"spanJG\">" +Qtxznm +"</span><select id='ZH" + cd00053Qtxzid + "' name='ZH" + cd00053Qtxzid + "' class=\"txtfocus txtSelect ZHXZ\"><option value=\"\" parentid=\"\">请选择...</option></select></span>");
		}
	else
		{
		if (IsId)
			{
			obj.append("<option value=\"" + cd00053Qtxzid + "\" parentid=\"" + ParentId + "\" selected=\"selected\">"+Qtxznm+"</option>");
			}
		else
			{
			obj.append("<option value=\"" + cd00053Qtxzid + "\" parentid=\"" + ParentId + "\">"+Qtxznm+"</option>");
			}
		}	
}
////添加综合修正
//function addZHXZ(cd00053Qtxzid,ParentId,Qtxznm,IsDir,IsId){
//
//	var obj = $("#tt1 #"+ ParentId);
//	if (obj.length==0)
//		{
//		obj= $("#tt1");	
//		}
//	if (IsDir)
//		{
//		obj.append("<li><span><b>" +Qtxznm +"</b></span><ul><li id='" + cd00053Qtxzid + "'></li></ul></li>");
//		}
//	else
//		{
//		if (IsId)
//			{
//			obj.append("<span><input class=\"ZHXZ\" parentid=\"" + ParentId + "\" name=\"rdo"+ ParentId +"\" id=\"rdo"+ cd00053Qtxzid +"\" type=\"radio\" style=\"border:none;\" value=\"" + cd00053Qtxzid + "\" checked=\"checked\"/>" +Qtxznm +"</span> ");
//			}
//		else
//			{
//			obj.append("<span><input class=\"ZHXZ\" parentid=\"" + ParentId + "\" name=\"rdo"+ ParentId +"\" id=\"rdo"+ cd00053Qtxzid +"\" type=\"radio\" style=\"border:none;\" value=\"" + cd00053Qtxzid + "\" />" +Qtxznm +"</span> ");
//			}
//		}	
//}

//提交EDIT画面的FORM
function AppSubmit(){
	$("#editForm").submit();
};
//弹出窗体编辑功能
function showpParentWin(title,url,framename){
	var randomnumber=Math.floor(Math.random()*100000);
	window.parent.addTabflash(title,encodeURI(url+ "&rand="+randomnumber),framename);

}
function showpParentWinI(title,url,framename){
	var randomnumber=Math.floor(Math.random()*100000);
	window.parent.parent.addTabflash(title,encodeURI(url+ "&rand="+randomnumber),framename);

}
//检查证件位数
function checkSFZ(SFZtype,value)
{
	if (SFZtype=="01")//身份证
	{	
		if (value.length == 15 || value.length == 18)
			return true;//如果当前域的值等于指定的参数就通过校验				
	}
	else if (SFZtype=="03")//军官证
	{	
		if (value.length==8)
			return true;//如果当前域的值等于指定的参数就通过校验
	}
	else if (SFZtype=="50")//其他
	{	
		if (value.length==18)
			return true;//如果当前域的值等于指定的参数就通过校验
	}
	else if (SFZtype=="15")//护照
	{	
		if (value.length==12)
			return true;//如果当前域的值等于指定的参数就通过校验
	}
	else
	{ 
		return true;
	}
	return false;
}

//返回当前状态
function getPGZT(value){
	if (value == 0) {
		return "<img title=\"未操作\" alt='未操作' src='../images/ico/0.gif'/>";
    } else if (value == 1) {
		return "<img title=\"已通过审核\" alt='已通过审核' src='../images/ico/1.gif'/>";
	} else if (value == 12) {
		return "<img title=\"强制审核\" alt='强制审核' src='../images/ico/12.gif'/>";
	} else if (value == 11) {
		return "<img title=\"审核未通过\" alt='审核未通过' src='../images/ico/11.gif'/>";
	} else if (value == 13) {
		return "<img title=\"科室审核通过\" alt='科室审核通过' src='../images/ico/13.gif'/>";
	} else if (value == 14) {
		return "<img title=\"业务科通过\" alt='业务科通过' src='../images/ico/14.gif'/>";
	} else if (value == 2) {
		return "<img title=\"已通过评税\" alt='已通过评税' src='../images/ico/2.gif'/>";
	} else if (value == 21) {
		return "<img title=\"评税未通过\" alt='评税未通过' src='../images/ico/21.gif'/>";
	}else if (value == 22) {
		return "<img title=\"已个案评税\" alt='已个案评税' src='../images/ico/22.gif'/>";
	}else if (value == 3) {
		return "<img title=\"已算税\" alt='已算税' src='../images/ico/3.gif'/>";
	}else if (value == 31) {
		return "<img title=\"算税未通过\" alt='算税未通过' src='../images/ico/31.gif'/>";
	} else if (value == 4) {
		return "<img title=\"打印完成\" alt='打印完成' src='../images/ico/4.gif'/>";
	}
}

//点击子节点让父节点选择
function selRootNode(obj)
{
	var b = true;
	$(".childCheck").each(function(){         		
		if 	(!$(this)[0].checked) {
			b = false;
		}
	});		
	$('.rootCheck')[0].checked = b;
}

//显示提示信息
jQuery.notifyBar = function(settings) {

	(function($) {

		var notifyBarNS = {};

		if (!settings) {
			settings = {};
		}

		if (!settings.html) {
			return;
		}		
		
		// HTML inside bar
		notifyBarNS.html = settings.html || "Your message here";

		// Set up own class
		notifyBarNS.cls = settings.cls || "";	

		var imgStr = "";
		var timeint = 5000;
		
		switch (notifyBarNS.cls) {
		case "error":
			imgStr = "<img src='../images/msgERROR.gif' height='16' width='16'/>";
			timeint = 0;
			break;
		case "success":
			imgStr = "<img src='../images/msgSUCCESS.gif' height='16' width='16'/>";
			break;
		case "warning":
			imgStr = "<img src='../images/msgWARNING.gif' height='16' width='16'/>";
			break;
		default:
			imgStr = "<img src='../images/msgINFO.gif' height='16' width='16'/>";
		}		
		
		$.messager.show({
			title:imgStr + '&nbsp;提示信息',
			msg:notifyBarNS.html,
			timeout:timeint,
			showType:'slide'
		});

	})(jQuery);
};

//判断是否点击在文本框的最右边
function isClickone(obj,e){
	if (obj==null) return false;
	var iwidth=$(obj).width()-e.originalEvent.offsetX||$(obj).width()-e.originalEvent.layerX||0;//获取当前鼠标相对img的x坐标 
	if (iwidth>0 && iwidth<16)
	{
		return true;		
	}
};

//让框架自动适应大小
function reinitIframe(){	
	var iframe = document.parentWindow;	
	try{
		iframe.frameElement.height = document.body.scrollHeight;	
	}
	catch (ex){};
}
/**  
*  页面加载等待页面  
*  
* @author gxjiang  
* @date 2010/7/24  
*  
*/ 
function setLoading()
{
	var height = window.screen.height-250;   
	 var width = window.screen.width;   
	 var leftW = 300;
	 if(width>1200){
	    leftW = 500;
	 }else if(width>1000){   
	    leftW = 350;   
	 }else {   
	    leftW = 100;   
	 }   
	    
	 var _html = "<div id='loading' style='display:none;position:absolute;left:0;width:100%;height:"+height+"px;top:0;background:#E0ECFF;opacity:0.8;filter:alpha(opacity=80);'><div style='position:absolute;cursor1:wait;left:"+leftW+"px;top:200px;width:auto;height:16px;padding:12px 5px 10px 30px;background:#fff url(../scripts/easyui/themes/default/images/pagination_loading.gif) no-repeat scroll 5px 10px;border:2px solid #ccc;color:#000;'>正在加载数据...</div></div>";
	 
	 document.write(_html); 
}

setLoading();

$(document).ready(function() {	
	$("#butAppSubmitUploadUpload").click(function(){
		AppSubmitUpload();
	});
	//选择文本框自动全部选择
	$(":text").focus(function()
	{ 
		this.select();
	});	
	
	$(document).keydown(function()
	{
		//A时连接不执行tab。
		if(event.keyCode==13 && event.srcElement.nodeName!="A")
		     event.keyCode=9;
	});	
	//查询对话框
	if ($('#w').length>0)
	{
	  $('#w').dialog({
		title: "查询数据",	
        closed: true,
        iconCls:"icon-search",
	       buttons:[{
				text:'查询',
				iconCls:'icon-search',
				handler:function(){
	    	   		searchDate();
				}
			},{
				text:'关闭',
				iconCls:'icon-cancel',
				handler:function(){
					$("#w").dialog('close');
				}
			}]
		});
	};
	//查询对话框
	if ($('#ww').length>0)
	{
	  $('#ww').dialog({
		title: "查询数据",	
        closed: true,
        iconCls:"icon-search",
	       buttons:[{
				text:'详细查询',
				iconCls:'icon-search',
				handler:function(){
	    	   		searchDate();
				}
			},{
				text:'导出',
				iconCls:'icon-excel',
				handler:function(){
					exportDATA();
				}
			}
			/*,{
				text:'全部删除',
				iconCls:'icon-delete',
				handler:function(){
					delAllData();
				}
			}*/
			,{
				text:'关闭',
				iconCls:'icon-cancel',
				handler:function(){
					$("#ww").dialog('close');
				}
			}]
		});
	};
	
	//导出对话框
	if ($('#v').length>0)
	{
	  $('#v').dialog({
		title: "导出数据",	
        closed: true,
        iconCls:"icon-excel",
	       buttons:[{
				text:'导出',
				iconCls:'icon-excel',
				handler:function(){
	    	   		$('#findForm').submit();
				}
			},{
				text:'关闭',
				iconCls:'icon-cancel',
				handler:function(){
					$("#v").dialog('close');
				}
			}]
		});
	};
	
	//报表条件对话框
	if ($('#bb').length>0)
	{
	  $('#bb').dialog({
		title: "查询",	
        closed: true,
        iconCls:"icon-search",
	       buttons:[{
				text:'查询',
				iconCls:'icon-search',
				handler:function(){
	    	   		searchData();
				}
			},{
				text:'关闭',
				iconCls:'icon-cancel',
				handler:function(){
					$("#bb").dialog('close');
				}
			}]
		});
	};
	$("#btnConditions").click(function()
	{ 
		var iOffsetTop = $("#btnConditions").offset().top + $("#btnConditions").height() + 5;
		var iOffsetLeft = $("#btnConditions").offset().left;
		$("#apDiv1").css("top",iOffsetTop);
		$("#apDiv1").css("left",iOffsetLeft);
		if ($("#btnConditions").val()=="↓")
		{
			$("#apDiv1").show();
			$("#btnConditions").val("↑");
			$("#btnConditions").attr("title","隐藏搜索条件");
		}
		else
		{
			$("#apDiv1").hide();
			$("#btnConditions").val("↓");
			$("#btnConditions").attr("title","显示搜索条件");
		}
	});
	//让条件隐藏
	$("#btnSearch").click(function()
	{ 
		$("#apDiv1").hide();
		$("#btnConditions").val("↓");
		$("#btnConditions").attr("title","显示搜索条件");
	});
});
//检查IP地址
function checkIP2(sIPAddress)
{
    var exp=/^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/;
    var reg = sIPAddress.match(exp);
    //var ErrMsg="你输入的是一个非法的IP地址段！\nIP段为：:xxx.xxx.xxx.xxx（xxx为0-255)！"    
    //var Msg="你输入的是一个合法的IP地址段！"    
    if(reg==null)
    {
        return false;
    }
    else
    {
    	return true;
    }
}

/**
 * 彈出窗口
 * @param i_URL 彈出窗口的URL
 * @param i_Height 高度
 * @param i_Width 寬度
 * @param i_Target 窗口名
 */
function Show(i_URL,i_Height,i_Width,i_Target)
{
	var iLeft = (screen.width - i_Width) / 2;
	var iTop = (screen.height - i_Height) / 2;
	var strFeatures = "Top=" + iTop + ",Left=" + iLeft +",Height=" + i_Height + ",Width=" + i_Width + ",status=yes,scrollbars=yes,resizable=yes" ;
	var w1 = window.open(encodeURI(i_URL), i_Target, strFeatures);
	w1.focus();
}
 
 /**  
  * 格式化时间显示方式   
  */ 
 function formatDateTime(dtime){
	 if (dtime == null)
	 {
		 return " ";
	 }
	 else
	 {
		 return dtime.replace('T',' ');
	 }
 }
 
 /**  
  * 格式化时间显示方式   
  */ 
 function formatDate(dtime){
	 if (dtime == null)
	 {
		 return " ";
	 }
	 else
	 {
		 var arr=dtime.split("T");
		 return arr[0];
	 }
 }
  
  /**  
   * 格式化字符显示方式   
   */ 
  function formatString(str){
	  if (str==null || str == 'null')
	  {
		  return "";
	  }
	  else
	  {
		  return str;
	  }
  }  
 
/**  
 * 格式化数字显示方式   
 * 用法  
 * formatNumber(12345.999,'#,##0.00');  
 * formatNumber(12345.999,'#,##0.##');  
 * formatNumber(123,'000000');  
 * @param num  
 * @param pattern  
 */  
function formatNumber(num,pattern){        
  var fmtarr = pattern?pattern.split('.'):[''];  
//先要四舍五入
  var temp=fmtarr.length>1?fmtarr[1]:'';
  if (temp.length>0)
  {
	  num = Math.round(parseFloat(num)*Math.pow(10,temp.length))/(Math.pow(10,temp.length));
  }
  
  var strarr = num?num.toString().split('.'):['0'];
  var retstr='';   
  
  // 整数部分   
  var str = strarr[0];   
  var fmt = fmtarr[0];   
  var i = str.length-1;     
  var comma = false;   
  for(var f=fmt.length-1;f>=0;f--){   
    switch(fmt.substr(f,1)){   
      case '#':   
        if(i>=0 ) retstr = str.substr(i--,1) + retstr;   
        break;   
      case '0':   
        if(i>=0) retstr = str.substr(i--,1) + retstr;   
        else retstr = '0' + retstr;   
        break;   
      case ',':   
        if(i>=0)
		  {
	    	if (str.substr(i,1)!="-")
	  	    {
	    	  comma = true;
	          retstr=','+retstr;  
	  	    }
	  		else
	  		{
	  		  retstr = str.substr(i--,1) + retstr; 
	  		}   
		  }    
        break;   
    }   
  }   
  if(i>=0){   
    if(comma){   
      var l = str.length;   
      for(;i>=0;i--){   
        retstr = str.substr(i,1) + retstr;   
        if(i>0 && ((l-i)%3)==0) retstr = ',' + retstr;    
      }   
    }   
    else retstr = str.substr(0,i+1) + retstr;   
  }   
  
  retstr = retstr+'.';   
  // 处理小数部分   
  str=strarr.length>1?strarr[1]:'';   
  fmt=fmtarr.length>1?fmtarr[1]:'';   
  i=0;   
  for(var f=0;f<fmt.length;f++){   
    switch(fmt.substr(f,1)){   
      case '#':   
        if(i<str.length) retstr+=str.substr(i++,1);   
        break;   
      case '0':   
        if(i<str.length) retstr+= str.substr(i++,1);   
        else retstr+='0';   
        break;   
    }   
  }   
  return retstr.replace(/^,+/,'').replace(/\.$/,'');   
}

function preloadImg(src)
{
	var img=new Image();
	img.src=src;
}

/*
校验字符串是否为整型
返回值：
如果为空，定义校验通过，      返回true
如果字串全部为数字，校验通过，返回true
如果校验不通过，              返回false
参考提示信息：输入域必须为数字！
*/
function checkIsInteger(str){
   //如果为空，则通过校验
   if(str == "")
       return true;
   if(/^\d+$/.test(str))
       return true;
   else
       return false;
}

/*
校验字符串是否为整型或小数
返回值：
如果为空，定义校验通过，      返回true
如果为0，    返回false
如果字串全部为数字或小数，校验通过，返回true
如果校验不通过，              返回false
参考提示信息：输入域必须为数字！
*/
function checkIsNumeric(str){
	   //如果为空，则通过校验
	   if(str == "")
	       return true;
	   if(str == 0)
		   return false;
	   if(/^\d+$/.test(str))
	       return true;
	   else if(/^\d+(\.\d+)+$/.test(str))
	       return true;
	   else
	       return false;
}

/*
 * 检查所在层数的格式是否正确
校验字符串是否-1,4-5格式
返回值：

*/
function checkSzcs(str){
	   //如果为空，则通过校验
	   if(str == "")
	       return true;	   
	   if(/^([-]?[0-9]+[,]?)+$/.test(str))
		   return true;	  
	   else
	       return false;
}

/*
去除多余空格函数
trim:去除两边空格 lTrim:去除左空格 rTrim: 去除右空格
用法：
    var str = "  hello ";
    str = str.trim();
*/
String.prototype.trim = function()
{
   return this.replace(/(^[\\s]*)|([\\s]*$)/g, "");
}
String.prototype.lTrim = function()
{
   return this.replace(/(^[\\s]*)/g, "");
}
String.prototype.rTrim = function()
{
   return this.replace(/([\\s]*$)/g, "");
}
/*
校验字符串是否为空
返回值：
如果不为空，定义校验通过，返回true
如果为空，校验不通过，返回false
参考提示信息：输入域不能为空！
*/
function checkIsNotEmpty(str)
{
	if(str == null || str.trim() == "" || str.trim() == "null")
	   return false;    
    else
       return true;
}

/*
得到空字符串

*/
function strIsEmpty(str)
{
   if(str == null || str == "null")
       return "";
   else
       return str;
}
function getGirdHeight()
{
	var iheight = $(document).height()-50;
	//鍒犻櫎鍒楄〃閲屼笉璁＄畻鐨勬帶浠堕珮搴�
	$(".noView").each(function(){     
		iheight= iheight -$(this).height();		
	});	
	$(".divbottom").each(function(){     
		iheight= iheight -$(this).height();		
	});	
	$(".divtop").each(function(){     
		iheight= iheight -$(this).height();		
	});	
	if (iheight<400)
		iheight=400;
	return iheight;
}