<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sw" uri="/sunway" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1">
	<link rel="shortcut icon" href="main.ico" /> 
    <title><s:property value="%{getText('app.global.title')}" /></title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" type="text/css" href="scripts/easyui/themes/default/easyui.css" />
	<link href="css/screen.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="scripts/easyui/themes/icon.css" />
    <script type="text/javascript" src="scripts/easyui/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="scripts/easyui/jquery.easyui.pack.js"></script>
	<script type="text/javascript" src='scripts/easyui/outlook.js'></script>
	<script type="text/javascript" src="scripts/togglemenu.js"></script>
	<script type="text/javascript" src="scripts/MainFrame.js"></script>
	<script type="text/javascript" src="scripts/easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="scripts/common.js"></script>

    <style type="text/css">
	    body{background:#D2E0F2; }
		a{ color:Black; text-decoration:none;}
		a:hover{ color:Red; text-decoration:underline;}
		.textbox03 {border: #878787 1px solid;padding: 4px 3px;font:Verdana, Geneva, sans-serif,宋体;line-height: 14px; background-color: #fff;  height: auto; font-size: 14px;  font-weight: bold; width: 190px; }
		
		.txt01{font:Verdana, Geneva, sans-serif,宋体;padding:3px 2px 2px 2px; border-width:1px; border-color:#ddd;  color:#000;}
		.txt {border: #878787 1px solid;padding: 4px 3px;font:Verdana, Geneva, sans-serif,宋体;line-height: 14px; background-color: #fff;  height: auto; font-size: 14px;}
		.footer{text-align:center;color:#15428B; margin:0px; padding:0px;line-height:23px;}
		
		.head a{color:White;text-decoration:underline;}
    </style>
</head>
<body class="easyui-layout" style="overflow-y: hidden"  scroll="no">
<noscript>
<div style=" position:absolute; z-index:100000; height:2046px;top:0px;left:0px; width:100%; background:white; text-align:center;">
    <img src="images/noscript.gif" alt='抱歉，请开启脚本支持！' />
</div></noscript>
    <div region="north" split="false" border="false" style="overflow: hidden; height: 35px;
        background: url(images/layout-browser-hd-bg.gif) #7f99be repeat-x center 50%;
        line-height: 20px;color: #fff; ">
        <span style="float:right; padding-right:20px;" class="head">
        <form action="FLASHSESSION.action" id="flashForm" method="post">
        <table border="0" cellspacing="0" cellpadding="0">
	      <tr>
	      <td height="35" style="padding-top:7px;" align="right">
	         </td>
	        <td align="right"><a href="javascript:showSetting();" title="<s:property value="USER"/>"><img src="images/ico/USER.gif" /></a></td>
	        <td align="right"><span style="color:#FFF; font-size: 12px;"><a href="help/help.pdf" target="_blank"><img src="images/ico/bzsc.gif" title="帮助" alt="帮助" /></a></span></td>
	        <td width="50" align="right"><a href="LOGOUT.action" id="loginOut" title="注销" target="_blank"><img src="images/ico/Exit.gif" title="注销" alt="注销" /></a></td>
	   </tr> 
	      	         
	    </table>
        </form>
        </span>
        <span style="padding-left:10px; font-size: 20px; font-family: Verdana, 微软雅黑,黑体"><img src="images/logo.gif" width="20" height="20" align="absmiddle" /><s:property value="getText('app.global.title')" /></span>
    </div>
    <div region="south" style="height: 30px; background: #D2E0F2; ">
        <div class="footer"><s:property value="getText('app.global.foot')" escape="false" /></div>
    </div>
    <div region="west" split="true" title="导航菜单" style="width:240px;" id="west">
    
	<div class="easyui-accordion" fit="true" border="false">
	<s:if test="%{QXID==0 || QXID==2 || QXID==1}"> 
		<div title="业务处理" icon="icon-title" style="overflow:auto;padding:2px;">	
			<ul class="summenu">		      
		           <li><div><a href="xtwh/VIEWTFC001.action" target="mainFrameFC001" title="<s:property value="%{getText('app.xtwh.tfc001.title')}" />"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[<s:property value="%{getText('app.xtwh.tfc001.title')}" />]</a></div></li>
				   <li><div><a href="xtwh/VIEWTFC0012.action" target="mainFrameFC0012" title="<s:property value="%{getText('app.xtwh.tfc0012.title')}" />"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[<s:property value="%{getText('app.xtwh.tfc0012.title')}" />]</a></div></li>
				   <s:if test="%{QXID==2 || QXID==1}"> 
				   <li><div><a href="xtwh/VIEWTFC00150.action" target="mainFrameFC00150" title="<s:property value="%{getText('app.xtwh.tfc00150.title')}" />"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[<s:property value="%{getText('app.xtwh.tfc00150.title')}" />]</a></div></li>
				   </s:if>
				   <li><div><a href="xtwh/VIEWTFC0011.action" target="mainFrameFC0011" title="<s:property value="%{getText('app.xtwh.tfc0011.title')}" />"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[<s:property value="%{getText('app.xtwh.tfc0011.title')}" />]</a></div></li>
				   <li><div><a href="xtwh/VIEWTFC0013.action" target="mainFrameFC0013" title="<s:property value="%{getText('app.xtwh.tfc0013.title')}" />"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[<s:property value="%{getText('app.xtwh.tfc0013.title')}" />]</a></div></li>
		      </ul>
		 </div>
		 	<div title="查询统计" icon="icon-title" style="overflow:auto;padding:2px;">
			<ul class="summenu">	
			<li><a href="#" class="rootMenu">查询</a>
				<ul>	      
		           <li><div><a href="xtwh/VIEWTFC0014.action" target="mainFrameFC0014" title="<s:property value="%{getText('app.xtwh.tfc0014.title')}" />"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[<s:property value="%{getText('app.xtwh.tfc0014.title')}" />]</a></div></li>
				   <li><div><a href="xtwh/VIEWTFC0015.action" target="mainFrameFC0015" title="<s:property value="%{getText('app.xtwh.tfc0015.title')}" />"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[<s:property value="%{getText('app.xtwh.tfc0015.title')}" />]</a></div></li>
				   <li><div><a href="xtwh/VIEWTFC0016.action" target="mainFrameFC0016" title="<s:property value="%{getText('app.xtwh.tfc0016.title')}" />"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[<s:property value="%{getText('app.xtwh.tfc0016.title')}" />]</a></div></li>
				   <li><div><a href="xtwh/VIEWTFC0017.action" target="mainFrameFC0017" title="<s:property value="%{getText('app.xtwh.tfc0017.title')}" />"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[<s:property value="%{getText('app.xtwh.tfc0017.title')}" />]</a></div></li>
		       </ul>
		   </li>
		   <li><a href="#" class="rootMenu">统计</a>
				<ul>  
		          
		       </ul>
		   </li>
		      </ul>
		 </div>
		</s:if> 
		<s:if test="%{QXID==1 || ISADMIN==1}"> 
		<div title="系统维护" icon="icon-title" style="overflow:auto;padding:2px;">
			<ul class="summenu">		      
			       <li><div><a href="xtwh/VIEWT00001.action" target="mainFrame00001" title="<s:property value="%{getText('app.xtwh.t00001.title')}" />"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[<s:property value="%{getText('app.xtwh.t00001.title')}" />]</a></div></li>
		           <li><div><a href="xtwh/VIEWT00002.action" target="mainFrame00002" title="<s:property value="%{getText('app.xtwh.t00002.title')}" />"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[<s:property value="%{getText('app.xtwh.t00002.title')}" />]</a></div></li>
		           <li><div><a href="xtwh/VIEWT00003.action" target="mainFrame00003" title="<s:property value="%{getText('app.xtwh.t00003.title')}" />"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[<s:property value="%{getText('app.xtwh.t00003.title')}" />]</a></div></li>
		           <li><div><a href="xtwh/VIEWT00004.action" target="mainFrame00004" title="<s:property value="%{getText('app.xtwh.t00004.title')}" />"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[<s:property value="%{getText('app.xtwh.t00004.title')}" />]</a></div></li>
		     </ul>  
		</div>
		</s:if>
	</div>
    </div>
    <div id="mainPanle" region="center" style="background: #eee; overflow-y:hidden">
        <div id="tabs" class="easyui-tabs"  fit="true" border="false" >
			<div title="欢迎使用" style="padding:20px;overflow:hidden;" id="home">
			<iframe src="main/HOMEMAIN.action" name="bottomFrame" style="width:100%;height:100%;" scrolling="auto" frameborder="0" id="bottomFrame" ></iframe>
			</div>			
		</div>
    </div>   
<!--修改密码窗口-->
    <div id="w" class="easyui-window" title="个人设置" collapsible="false" minimizable="false"
        maximizable="false" icon="icon-save"  style="width: 450px; height: 300px; padding: 0px;
        background: #fafafa;">
        <div class="easyui-layout" fit="true">
            <div region="center" border="false" style="padding: 0px; background: #fff; border: 1px solid #ccc;">
                <iframe id="iSetPwd" name="iSetPwd" scrolling="auto" frameborder="0"  src="" style="width:100%;height:100%;"></iframe>
            </div>            
        </div>
    </div>
	<div id="mm" class="easyui-menu" style="width:150px;">
		<div id="mm-tabclose">关闭</div>
		<div id="mm-tabcloseall">全部关闭</div>
		<div id="mm-tabcloseother">除此之外全部关闭</div>
		<div class="menu-sep"></div>
		<div id="mm-tabcloseright">当前页右侧全部关闭</div>
		<div id="mm-tabcloseleft">当前页左侧全部关闭</div>
		<div class="menu-sep"></div>
		<div id="mm-exit">退出</div>
	</div>
</body>
</html>