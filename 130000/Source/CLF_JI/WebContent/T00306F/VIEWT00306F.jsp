<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:property value="%{getText('app.global.title')}" /></title>
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<script type="text/javascript" src="../scripts/T00352F/VIEWT00352F.js"></script>
<link type="text/css" rel="stylesheet" href="../css/screen.css" />
</head>
<body>
<table width="800px" height="500px" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="100px">
        <div style="width:100px; height:500px; overflow:auto;">
    	<table>
            <s:set name="PATH">..</s:set>
            <s:iterator status="index" value="tabList">
                <tr>
                    <td><a href="javascript:void(0)" onClick="showPic('<s:property value="zplj" />')"><img src="../<s:property value="zpljMin" />" /></a></td>
                </tr>
                <s:if test="%{txtZPID==zpid}">
                    <s:set name="PATH"><s:property value="zplj" /></s:set>
                </s:if>
            </s:iterator>
        </table>
        </div>
    </td>
    <td width="700px" valign="top"><div style="width:700px; height:500px; overflow:auto;"><img id="txtIMG" src="..<s:property value="PATH" />" /></div></td>
  </tr>
</table>
</body>
</html>