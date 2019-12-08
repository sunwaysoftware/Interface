<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sw" uri="/sunway" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><s:property value="%{getText('app.menu')}" /></title>
<script type="text/javascript" src="scripts/jquery.min.js"></script>
<link href="css/screen.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="scripts/common.js"></script>
<script type="text/javascript" src="scripts/top.js"></script>
<script language="JavaScript"> 
function correctPNG() // correctly handle PNG transparency in Win IE 5.5 & 6. 
{ 
    var arVersion = navigator.appVersion.split("MSIE"); 
    var version = parseFloat(arVersion[1]); 
    if ((version >= 5.5) && (document.body.filters)) 
    { 
       for(var j=0; j<document.images.length; j++) 
       { 
          var img = document.images[j]; 
          var imgName = img.src.toUpperCase(); 
          if (imgName.substring(imgName.length-3, imgName.length) == "PNG") 
          { 
             var imgID = (img.id) ? "id='" + img.id + "' " : "" ;
             var imgClass = (img.className) ? "class='" + img.className + "' " : "" ;
             var imgTitle = (img.title) ? "title='" + img.title + "' " : "title='" + img.alt + "' " ;
             var imgStyle = "display:inline-block;" + img.style.cssText; 
             if (img.align == "left") imgStyle = "float:left;" + imgStyle ;
             if (img.align == "right") imgStyle = "float:right;" + imgStyle ;
             if (img.parentElement.href) imgStyle = "cursor:hand;" + imgStyle; 
             var strNewHTML = "<span " + imgID + imgClass + imgTitle 
             + " style=\"" + "width:" + img.width + "px; height:" + img.height + "px;" + imgStyle + ";" 
             + "filter:progid:DXImageTransform.Microsoft.AlphaImageLoader" 
             + "(src=\'" + img.src + "\', sizingMethod='scale');\"></span>" ;
             img.outerHTML = strNewHTML; 
             j = j-1 ;
          } 
       } 
    }     
} 
window.attachEvent("onload", correctPNG); 
</script>
<style type="text/css">
<!--
.bj1 {
	background-image: url(images/bj02.jpg);
	background-repeat: repeat-x;
}
.bj2 {
	background-image: url(images/bj03.jpg);
	background-repeat: repeat-x;
}
.ssgx {
	width:220px;
}
.bj01 {
	background-image: url(images/bj01.gif);
	background-repeat: repeat-x;
}
a {
	color: #000;
	font-weight: bold;
	text-decoration: none;
}
-->
</style>
</head>
<body>
<form action="FLASHSESSION.action" id="flashForm" method="post">
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="bj1">
  <tr>
    <td height="20" class="bj2"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="300">&nbsp;<span style="color:#FFF; "><s:property value="%{getText('app.xtwh.info.ssgx')}" />：</span>
          <sw:ssgx items="ssgxList" name="ddlSSGX" id="ddlSSGX" checked="SSGX" classid="ssgx"/></td>        
        <td>&nbsp;</td>
        <td width="250" align="right"><span style="color:#FFF; font-size: 12px;"><img src="images/ico/USER.gif" width="16" height="16" /><a href="javascript:showSetting();" style="color:#FFF; font-size: 12px;" title="<s:property value="%{getText('app.xtwh.t00002.custom')}" />"><s:property value="USER"/></a></span></td>
        <td width="50" align="right"><a href="LOGOUT.action" style="color:#FFF; font-size: 12px;" target="_parent" title="退出"><img src="images/ico/Exit.gif" title="退出" alt="退出" />退出</a></td>
        <td width="20" align="right"><img src="images/close.gif" alt=""
			width="16" height="16" align="middle" style="CURSOR: hand"
			title="" onClick="switchBar(this)" /></td>
      </tr>
    </table></td>
    </tr>
  <tr>
    <td>
      <table width="100%" border="0" align="left" cellpadding="0" cellspacing="0">
        <tr>
          <td width="217" height="43">&nbsp;&nbsp;&nbsp;&nbsp;<img src="images/top1.png" width="160" height="43"></td>
          <td width="560"><table width="500" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td align="center"><a href="main/HOMEFrame.action" target="bottomFrame"><img src="images/ico/T00.gif" alt="主页" width="32" height="32" /><br /><span>系统主页</span></a></td>
              <td align="center"><a href="main/SJGLFrame.action" target="bottomFrame"><img src="images/ico/T01.gif" alt="<s:property value="%{getText('app.menu.SJGL')}" />" width="32" height="32" /><br /><span>数据采集</span></a></td>
              <td align="center"><a href="main/FDCPGFrame.action" target="bottomFrame"><img src="images/ico/T02.gif" alt="<s:property value="%{getText('app.menu.FDCPG')}" />" width="32" height="32" /><br /><span>房产估价</span></a></td>
<!--              <td align="center"><a href="main/PSJGCLFrame.action" target="bottomFrame"><img src="images/ico/T04.gif" alt="<s:property value="%{getText('app.menu.PSJGCL')}" />" width="32" height="32" /><br /><span>算税</span></a></td>-->
              <td align="center"><a href="main/SJCXFrame.action" target="bottomFrame"><img src="images/ico/T06.gif" alt="<s:property value="%{getText('app.menu.SJCX')}" />" width="32" height="32" /><br /><span>查询统计</span></a></td>
              <td align="center"><a href="main/XTWHFrame.action" target="bottomFrame"><img src="images/ico/T09.gif" alt="<s:property value="%{getText('app.menu.XTWH')}" />" width="32" height="32" /><br /><span>系统维护</span></a></td>
            </tr>           
          </table>            
            </td>
          </tr>
        <tr class="bj01">
          <td height="7" colspan="2"></td>
          </tr>
      </table></td>
    </tr>
</table>
</form>
<div>	
</div>
</body>
</html>