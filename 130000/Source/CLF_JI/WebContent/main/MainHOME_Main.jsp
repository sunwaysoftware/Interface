<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><s:property value="getText('app.global.title')"/></title>
<link href="../css/screen.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
.bj3 {background-image: url(images/top5.jpg);
	background-repeat: repeat-x;}
-->
</style>
<script type="text/javascript">
<!--
function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}
function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}
function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}
function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}
//-->
</script>

</head>
<body onLoad="MM_preloadImages('images/main/content20.jpg','images/main/content21.jpg','images/main/content25.jpg','images/main/content23.jpg','images/main/content24.jpg','images/main/content26.jpg','images/main/content27.jpg','images/main/content28.jpg','images/main/content18.jpg','images/main/content19.jpg','images/main/content22.jpg','images/main/content11.jpg','images/main/content12.jpg','images/main/content13.jpg','images/main/content17.jpg','images/main/content15.jpg','../images/main/content15.jpg','../images/main/content13.jpg','../images/main/content14.jpg')">
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td align="center"><table width="560" border="0" cellpadding="0" cellspacing="0">
      <tr>
		<td align="center"><table width="100%" border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td height="40">&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td><img src="../images/main/content01.png" width="90" height="81"></td>
                <td><img src="../images/main/content04.png" width="149" height="81"></td>
                <td><a href="javascript:void(0)" <s:if test="%{userRole.contains('0000010')}">onclick="window.parent.addTab('[<s:property value="%{getText('app.sjpg.pg30001.title')}" />]','pg/VIEWPG30001.action','mainFrame30001')"</s:if>><img src="../images/main/content05.png" width="113" height="81"></a></td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td><img src="../images/main/content02.png" width="90" height="68"></td>
                <td>&nbsp;</td>
                <td><img src="../images/main/content06.png" width="113" height="68"></td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td><a href="javascript:void(0)" <s:if test="%{userRole.contains('0000002')}">onclick="window.parent.addTab('[<s:property value="%{getText('app.menu.SJGL.SCSJCJ')}" />]','sjcj/ADDT00302.action?ACT=C','mainFrameSJCJ')"</s:if>><img src="../images/main/content03.png" width="90" height="83"></a></td>
                <td>&nbsp;</td>
                <td><a href="javascript:void(0)" <s:if test="%{userRole.contains('0000022')}">onclick="window.parent.addTab('[<s:property value="%{getText('app.jsrdcl.qstzd.title')}" />]','pg/VIEWT00391.action','mainFrame00391')"</s:if>><img src="../images/main/content07.png" width="113" height="83"></a></td>
                <td><img src="../images/main/content10.png" width="152" height="83"></td>
                <td><a href="javascript:void(0)" <s:if test="%{userRole.contains('0000013')}">onclick="window.parent.addTab('<s:property value="%{getText('app.sjpg.pg30000g.title')}" />','pg/VIEWPG30001G.action','mainFrame30001G')"</s:if>><img src="../images/main/content11.png" width="89" height="83"></a></td>
              </tr>
              <tr>
                <td></td>
                <td>&nbsp;</td>
                <td><img src="../images/main/content08.png" width="113" height="69"></td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td></td>
                <td>&nbsp;</td>
                <td><a href="javascript:void(0)" <s:if test="%{userRole.contains('0000019')}">onclick="window.parent.addTab('<s:property value="%{getText('app.jsrdcl.rdcl.title')}" />','pg/VIEWT00392.action','mainFrame00392')"</s:if>><img src="../images/main/content09.png" width="113" height="80"></a></td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
            </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td class="bj3">&nbsp;</td>
  </tr>
</table>
</body>
</html>