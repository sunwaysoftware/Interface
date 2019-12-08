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
    <script type="text/javascript" src="scripts/jquery.min.js"></script>
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
	        <td align="right"><span style="color:#FFF; "><s:property value="%{getText('app.xtwh.info.ssgx')}" />：</span>
	          <sw:ssgx items="ssgxList" name="ddlSSGX" id="ddlSSGX" checked="SSGX" classid="ssgx"/></td>        
	        <td align="right">&nbsp;&nbsp;<span style="color:#FFF; font-size: 12px;"><img src="images/ico/USER.gif" width="16" height="16" /><a href="javascript:showSetting();" style="color:#FFF; font-size: 12px;" title="<s:property value="%{getText('app.xtwh.t00002.custom')}" />"><s:property value="USER"/></a></span></td>
	        <td align="right">&nbsp;&nbsp;<span style="color:#FFF; font-size: 12px;"><img src="images/help.gif" width="16" height="16" /><a href="help/help.pdf" style="color:#FFF; font-size: 12px;" target="_blank" title="<s:property value="%{getText('app.bzwd.title')}" />"><s:property value="%{getText('app.bzwd.title')}" /></a></span></td>
	        <td width="50" align="right"><a href="LOGOUT.action" style="color:#FFF; font-size: 12px;" target="_parent" title="退出"><img src="images/ico/Exit.gif" title="退出" alt="退出" />退出</a></td>
	      </tr>      
	    </table>
        </form>
        </span>
        <span style="padding-left:10px; font-size: 26px; font-family: Verdana, 微软雅黑,黑体"><img src="images/logo.gif" width="32" height="32" align="absmiddle" /><s:property value="getText('app.global.title')" /></span>
    </div>
    <div region="south" style="height: 25px; background: #D2E0F2; ">
        <div class="footer"><s:property value="getText('app.global.foot')" escape="false" /></div>
    </div>
    <div region="west" split="true" title="导航菜单" style="width:240px;" id="west">
	<div class="easyui-accordion" fit="true" border="false">	
	<s:if test="%{userRole.contains('0000002') || userRole.contains('0000003') || userRole.contains('0000010') || userRole.contains('0000013') || userRole.contains('0000022') || userRole.contains('0000019')}">
		<div title="房产估价" icon="icon-title" style="overflow:auto;padding:2px;">
			<ul class="summenu">
			 <s:if test="%{userRole.contains('0000002') || userRole.contains('0000003')}">	
		       <li><a href="javascript:void(0)" class="rootMenu" title="<s:property value="%{getText('app.menu.SJGL.SJCJ')}" />"><s:property value="%{getText('app.menu.SJGL.SJCJ')}" /></a>
		         <ul>
		            <s:if test="%{userRole.contains('0000002')}">	
		      		<li><div><a href="sjcj/ADDT00302.action?ACT=C" target="mainFrameSJCJ" title="<s:property value="%{getText('app.menu.SJGL.SCSJCJ')}" />"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[<s:property value="%{getText('app.menu.SJGL.SCSJCJ')}" />]</a></div></li>
					</s:if>
<!--		      		<li><div><a href="sjcj/VIEWT003022.action" target="mainFrameSJCJImport" title="数据采集导入"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[采集数据导入]</a></div></li> -->
		      		<s:if test="%{userRole.contains('0000003')}">
		      		<li><div><a href="sjcj/VIEWWS00001.action" target="mainFrameWS" title="<s:property value="%{getText('app.ws.title')}" />" ><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[<s:property value="%{getText('app.ws.title')}" />]</a></div></li>
		         	</s:if>
<!--  				<li><div><a href="sjcj/VIEWT00372.action" target="mainFrameWSCS" title="测试接口" ><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[测试接口]</a></div></li>-->
		            <s:if test="%{userRole.contains('0000002')}">	
		      		<li><div><a href="sjcj/VIEWT00401.action" target="mainFrameTWPG" title="体外评估管理"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[体外评估管理]</a></div></li>
					</s:if>
		         </ul>
		       </li>
		       </s:if>
			 <s:if test="%{userRole.contains('0000010')}">
		      <li><a href="javascript:void(0)" class="rootMenu" title="<s:property value="%{getText('app.menu.FDCPG.SJPG')}" />"><s:property value="%{getText('app.menu.FDCPG.SJPG')}" /></a>
		         <ul>
			       <li><div><a href="pg/VIEWPG30001.action" target="mainFrame30001" title="<s:property value="%{getText('app.sjpg.pg30001.title')}" />"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[<s:property value="%{getText('app.sjpg.pg30001.title')}" />]</a></div></li>
<!--			       <li><div><a href="pg/VIEWPG30002.action" target="mainFrame30002" title="<s:property value="%{getText('app.sjpg.pg30002.title')}" />"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[<s:property value="%{getText('app.sjpg.pg30002.title')}" />]</a></div></li>-->
<!--			       <li><div><a href="psjgjy/VIEWSCPSJGJY.action" target="mainFrameSCPSJGJY" title="估价结果检验"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[估价结果检验]</a></div></li>-->
			     </ul>
			   </li>
			  </s:if>
			  <s:if test="%{userRole.contains('0000013')}">
			   <li><a href="javascript:void(0)" class="rootMenu" title="<s:property value="%{getText('app.menu.FDCPG.SJGPG')}" />"><s:property value="%{getText('app.menu.FDCPG.SJGPG')}" /></a>
		         <ul>
			       <li><div><a href="pg/VIEWPG30001G.action" target="mainFrame30001G" title="<s:property value="%{getText('app.sjpg.pg30000g.title')}" />"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[<s:property value="%{getText('app.sjpg.pg30000g.title')}" />]</a></div></li>
		       	</ul>
		     	 </li> 
		      </s:if>
		      <s:if test="%{userRole.contains('0000022')}"> 
		      <li><a href="javascript:void(0)" class="rootMenu" title="打印通知单">打印通知单</a>
		         <ul>		         
			       <li><div><a href="pg/VIEWT00391.action" target="mainFrame00391" title="<s:property value="%{getText('app.jsrdcl.qstzd.title')}" />"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[<s:property value="%{getText('app.jsrdcl.qstzd.title')}" />]</a></div></li>
		         </ul>      	
		      </li>
		      </s:if>
		       <s:if test="%{userRole.contains('0000019')}">  
		      <li><a href="javascript:void(0)" class="rootMenu" title="<s:property value="%{getText('app.menu.JSRDCL')}" />"><s:property value="%{getText('app.menu.JSRDCL')}" /></a>
		         <ul>		         
			       <s:if test="%{userRole.contains('0000019')}"> 
			       <li><div><a href="pg/VIEWT00392.action" target="mainFrame00392" title="<s:property value="%{getText('app.jsrdcl.rdcl.title')}" />"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[<s:property value="%{getText('app.jsrdcl.rdcl.title')}" />]</a></div></li>
		       	   </s:if>
		       	</ul>      	
		      </li>  
		      </s:if>		      
			</ul>
		</div>
		</s:if>
		<s:if test="%{userRole.contains('0000024') || userRole.contains('0000025') }">
		<div title="查询统计" icon="icon-title" style="overflow:auto;padding:2px;">
			<ul class="summenu">
			    <s:if test="%{userRole.contains('00000241')}">
				<li><a href="javascript:void(0)" class="rootMenu">查询</a>
				<ul>
					<li><div><a href="sjcx/VIEWV003025.action" target="mainFrameSJCX" title="未认定的数据查询"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[未认定的数据查询]</a></div></li>
				   	<li><div><a href="sjcx/VIEWV003025B.action" target="mainFrameYDSJCX" title="已认定的数据查询"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[已认定的数据查询]</a></div></li>
				    <s:if test="%{ssgxid.contains('2430300')}">
				    <li><div><a href="sjcj/VIEWWS000011.action" target="mainFrameWS1" title="<s:property value='%{getText("app.ws1.title")}' />"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[<s:property value='%{getText("app.ws1.title")}' />]</a></div></li>
				    </s:if>
				</ul>
				</li>
				</s:if>
				<s:if test="%{userRole.contains('0000025')}">
				<li><a href="javascript:void(0)" class="rootMenu">统计</a>
				<ul>
					<s:if test="%{userRole.contains('00000256')}">
					<li><div><a href="report/VIEWTJ00001.action" target="mainFrameTJ00001" title="<s:property value="getText('app.cxtj.tj00001.title')" />"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[<s:property value="getText('app.cxtj.tj00001.title')" />]</a></div></li>
					</s:if>				
					<s:if test="%{userRole.contains('00000251')}">
					<li><div><a href="report/VIEWBB00001.action" target="mainFrameBB00001" title="<s:property value="getText('app.cxtj.bb00001.title')" />"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[<s:property value="getText('app.cxtj.bb00001.title')" />]</a></div></li>
					</s:if>
					<s:if test="%{userRole.contains('00000252')}">
					<li><div><a href="report/VIEWBB00002.action" target="mainFrameBB00002" title="<s:property value="getText('app.cxtj.bb00002.title')" />"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[<s:property value="getText('app.cxtj.bb00002.title')" />]</a></div></li>
					</s:if>
					<s:if test="%{userRole.contains('00000253')}">
					<li><div><a href="report/VIEWBB00003.action" target="mainFrameBB00003" title="<s:property value="getText('app.cxtj.bb00003.title')" />"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[<s:property value="getText('app.cxtj.bb00003.title')" />]</a></div></li>
					</s:if>
					<s:if test="%{userRole.contains('00000254')}">
					<li><div><a href="report/VIEWBB00004.action" target="mainFrameBB00004" title="<s:property value="getText('app.cxtj.bb00004.title')" />"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[<s:property value="getText('app.cxtj.bb00004.title')" />]</a></div></li>
					</s:if>
					<s:if test="%{userRole.contains('00000255')}">
					<li><div><a href="report/VIEWBB00005.action" target="mainFrameBB00005" title="<s:property value="getText('app.cxtj.bb00005.title')" />"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[<s:property value="getText('app.cxtj.bb00005.title')" />]</a></div></li>
					</s:if>
                                        <li><div><a href="report/VIEWTJ00002.action" target="mainFrameTJ00002" title="<s:property value="getText('app.cxtj.tj00002.title')" />"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[<s:property value="getText('app.cxtj.tj00002.title')" />]</a></div></li>
				</ul>
				</li>
				</s:if>				
			</ul>
		</div>
		</s:if>
		<s:if test="%{ISADMIN || userRole.contains('0000027') || userRole.contains('0000028') || userRole.contains('0000029') || userRole.contains('0000032') || userRole.contains('0000035') || userRole.contains('0000039') }">
		<div title="系统维护" icon="icon-title" style="overflow:auto;padding:2px;">
			<ul class="summenu">
			<s:if test="%{userRole.contains('0000027')}">
		       <li><a href="javascript:void(0)" class="rootMenu">常规设置</a>
		         <ul>
		           <s:if test="%{userRole.contains('00000271')}">
		           <li><div><a href="xtwh/VIEWT00012.action" target="mainFrame00012" title="<s:property value="%{getText('app.xtwh.t00012.title')}" />"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[<s:property value="%{getText('app.xtwh.t00012.title')}" />]</a></div></li>
		           </s:if>
		           <s:if test="%{userRole.contains('00000272')}">
		           <li><div><a href="xtwh/VIEWT00013.action" target="mainFrame00013" title="<s:property value="%{getText('app.xtwh.t00013.title')}" />"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[<s:property value="%{getText('app.xtwh.t00013.title')}" />]</a></div></li>
		           </s:if>
		           <!--<li><div><a href="xtwh/VIEWT00055.action" target="mainFrame00055" title="<s:property value="%{getText('app.xtwh.t00055.title')}" />"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[<s:property value="%{getText('app.xtwh.t00055.title')}" />]</a></div></li>-->
		         </ul>
		       </li>
		       </s:if>
		       <s:if test="%{ISADMIN || userRole.contains('0000028')|| userRole.contains('00000284')|| userRole.contains('00000285')|| userRole.contains('00000286')}">
		       <li><a href="javascript:void(0)" class="rootMenu">数据输入</a>
		         <ul>
		           <s:if test="%{ISADMIN}">
		           <li><div><a href="xtwh/VIEWT00001.action" target="mainFrame00001" title="<s:property value="%{getText('app.xtwh.t00001.title')}" />"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[<s:property value="%{getText('app.xtwh.t00001.title')}" />]</a></div></li>
		           </s:if>
		           <s:if test="%{ISADMIN}">
		           <li><div><a href="xtwh/ADDT00052.action" target="mainFrame00052" title="<s:property value="%{getText('app.xtwh.t00052.title')}" />"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[<s:property value="%{getText('app.xtwh.t00052.title')}" />]</a></div></li>
		           </s:if>
		           <s:if test="%{userRole.contains('00000283')}">
		           <li><div><a href="xtwh/VIEWT00352.action" target="mainFrame00352" title="<s:property value="%{getText('app.xtwh.t00352.title')}" />"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[<s:property value="%{getText('app.xtwh.t00352.title')}" />]</a></div></li>
		           </s:if>
		           <s:if test="%{userRole.contains('00000284')}">
		           	<li><div><a href="xtwh/VIEWT00306.action?ACT=C" target="mainFrameLFXX" title="<s:property value="%{getText('app.xtwh.t00306.title')}" />"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[<s:property value="%{getText('app.xtwh.t00306.title')}" />]</a></div></li>
		           </s:if>
		           <s:if test="%{userRole.contains('00000285')}">
		           	<li><div><a href="sjcj/VIEWT00320.action?ACT=C" target="mainFrameQMPGIMP" title="<s:property value="%{getText('app.sjcj.t00320.title')}" />"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[<s:property value="%{getText('app.sjcj.t00320.title')}" />]</a></div></li>
		           </s:if>
		           <s:if test="%{userRole.contains('00000286')}">
		           	<li><div><a href="sjcj/VIEWT00320DZ.action?ACT=C" target="mainFrameQMPGDZ" title="<s:property value="%{getText('app.sjcj.t003201.title')}" />"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[<s:property value="%{getText('app.sjcj.t003201.title')}" />]</a></div></li>
		          </s:if>
		         </ul>
		       </li>
		       </s:if>
		        <s:if test="%{userRole.contains('00000291')||userRole.contains('00000292')||userRole.contains('00000293')||userRole.contains('00000294')||userRole.contains('00000295')||userRole.contains('00000296')||userRole.contains('00000297')||userRole.contains('00000298')||userRole.contains('00000299')}">
		       <li><a href="javascript:void(0)" class="rootMenu">估价参数</a>
		         <ul>
		         	<s:if test="%{userRole.contains('00000291')}">
					<li><div><a href="xtwh/VIEWT00359.action" target="mainFrame00359" title="<s:property value="%{getText('app.xtwh.t00359.title')}" />"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[<s:property value="%{getText('app.xtwh.t00359.title')}" />]</a></div></li>
					</s:if>
					<s:if test="%{userRole.contains('00000292')}">
					<li><div><a href="xtwh/VIEWT00353.action" target="VIEWT00353" title="<s:property value="%{getText('app.xtwh.t00353.title')}" />"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[<s:property value="%{getText('app.xtwh.t00353.title')}" />]</a></div></li>
					</s:if>
					<s:if test="%{userRole.contains('00000293')}">
					<li><div><a href="xtwh/VIEWT003840YY.action" target="mainFrame003840YY" title="<s:property value="%{getText('app.sjsh.t00384.gjdb')}" />"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[<s:property value="%{getText('app.sjsh.t00384.gjdb')}" />]</a></div></li>         		
	               	</s:if>
	               	<s:if test="%{userRole.contains('00000294')}">
	               	<li><div><a href="xtwh/VIEWT00355.action" target="mainFrame00355" title="<s:property value="%{getText('app.xtwh.t00355.title')}" />"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[<s:property value="%{getText('app.xtwh.t00355.title')}" />]</a></div></li>
	               	</s:if>
	               	<s:if test="%{userRole.contains('00000295')}">
	               	<li><div><a href="xtwh/VIEWT00356.action" target="mainFrame00356" title="<s:property value="%{getText('app.xtwh.t00356.title')}" />"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[<s:property value="%{getText('app.xtwh.t00356.title')}" />]</a></div></li>
		        	</s:if>
		        	<s:if test="%{userRole.contains('00000297')}">
		        	<li><div><a href="xtwh/VIEWT00360.action" target="mainFrame00360" title="<s:property value="%{getText('app.xtwh.t00360.title')}" />"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[<s:property value="%{getText('app.xtwh.t00360.title')}" />]</a></div></li>
		        	</s:if>				        	
		        	<s:if test="%{userRole.contains('00000297')}">
		        	<li><div><a href="xtwh/VIEWT00361.action" target="mainFrame00361" title="<s:property value="%{getText('app.xtwh.t00361.title')}" />"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[<s:property value="%{getText('app.xtwh.t00361.title')}" />]</a></div></li>
		        	</s:if>		
		        	<s:if test="%{userRole.contains('00000298')}">
		        	<li><div><a href="xtwh/VIEWT00362.action" target="mainFrame00362" title="<s:property value="%{getText('app.xtwh.t00362.title')}" />"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[<s:property value="%{getText('app.xtwh.t00362.title')}" />]</a></div></li>
		        	</s:if>	
		        	<s:if test="%{ISADMIN || userRole.contains('00000296')}">
		        		<li><div><a href="xtwh/VIEWT00364A.action" target="mainFrame00364A" title="<s:property value="%{getText('app.xtwh.t00364.title')}" />"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[<s:property value="%{getText('app.xtwh.t00364.title')}" />]</a></div></li>
		        	</s:if>	
		        	<s:if test="%{userRole.contains('00000299')}">	
		        	<!--<li><div><a href="xtwh/VIEWT00365.action" target="mainFrame00365" title="<s:property value="%{getText('app.xtwh.t00365.title')}" />"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[<s:property value="%{getText('app.xtwh.t00365.title')}" />]</a></div></li>-->		        	
		        	</s:if>		        	
		         </ul>
		       </li>
		        </s:if>
		        <s:if test="%{userRole.contains('0000032')||userRole.contains('00000321')||userRole.contains('00000360')||userRole.contains('00000361')||userRole.contains('00000362')||userRole.contains('00000322')||userRole.contains('00000363')||userRole.contains('00000364')||userRole.contains('00000365')}">
		       <li><a href="javascript:void(0)" class="rootMenu">标准房测算</a>
		           	 <ul>
						<s:if test="%{userRole.contains('00000322')}">
						<li><div><a href="xtwh/VIEWT00351.action" target="mainFrame00351" title="<s:property value="%{getText('app.xtwh.t00351.title')}" />"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[<s:property value="%{getText('app.xtwh.t00351.title')}" />]</a></div></li>
						</s:if>		           	 
		           	 	<s:if test="%{userRole.contains('00000321')}">
						<li><div><a href="xtwh/VIEWT00357.action" target="mainFrame00357" title="<s:property value="%{getText('app.xtwh.t00357.title')}" />"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[<s:property value="%{getText('app.xtwh.t00357.title')}" />]</a></div></li>
						</s:if>
						<s:if test="%{userRole.contains('00000360')}">
						<li><div><a href="xtwh/VIEWT00323.action" target="mainFrame00323" title="中介数据"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[中介数据]</a></div></li>
						</s:if>
						<s:if test="%{userRole.contains('00000361')}">
						<li><div><a href="xtwh/VIEWT00322.action" target="mainFrame00322" title="<s:property value="%{getText('app.xtwh.t00304.title')}" />"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[<s:property value="%{getText('app.xtwh.t00304.title')}" />]</a></div></li>
						</s:if>
						<s:if test="%{userRole.contains('00000362')}">
						<li><div><a href="xtwh/VIEWT00321.action" target="mainFrame00321" title="一手房交易的数据"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[一手房交易的数据]</a></div></li>
						</s:if>						
						<s:if test="%{userRole.contains('00000363')}">
						<li><div><a href="xtwh/VIEWT00351BZFCSY.action" target="mainFrame00351BZFCS1" title="小区标准房[可测算]"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">小区标准房[可测算]</a></div></li>
						</s:if>
						<s:if test="%{userRole.contains('00000364')}">
						<li><div><a href="xtwh/VIEWT00351BZFCSN.action" target="mainFrame00351BZFCS2" title="小区标准房[不可测算]"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">小区标准房[不可测算]</a></div></li>
						</s:if>
						<s:if test="%{userRole.contains('00000365')}">
						<li><div><a href="xtwh/ViewSCBZSLKGXBZ.action" target="mainFrameSCBZSLKGXBZ" title="<s:property value="%{getText('app.xtwh.bzfjgzs.title')}" />"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[<s:property value="%{getText('app.xtwh.bzfjgzs.title')}" />]</a></div></li>
						</s:if>						
		             </ul>
		        </li>
		        </s:if>			
		       	<s:if test="%{ISADMIN || userRole.contains('0000035')}">
		       <li><a href="javascript:void(0)" class="rootMenu">系统人员与权限维护</a>
		         <ul>
		           <s:if test="%{ISADMIN || userRole.contains('00000351')}">
		           <li><div><a href="xtwh/VIEWT00002.action" target="mainFrame00002" title="<s:property value="%{getText('app.xtwh.t00002.title')}" />"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[<s:property value="%{getText('app.xtwh.t00002.title')}" />]</a></div></li>
		           </s:if>
		           <s:if test="%{ISADMIN || userRole.contains('00000352')}">
		           <li><div><a href="xtwh/VIEWT00003.action" target="mainFrame00003" title="<s:property value="%{getText('app.xtwh.t00003.title')}" />"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[<s:property value="%{getText('app.xtwh.t00003.title')}" />]</a></div></li>
		           </s:if>
		           <s:if test="%{ISADMIN || userRole.contains('00000353')}">
		           <li><div><a href="xtwh/VIEWT00004.action" target="mainFrame00004" title="<s:property value="%{getText('app.xtwh.t00004.title')}" />"><img src="images/ico/cur.gif" width="6" height="9" align="absmiddle">[<s:property value="%{getText('app.xtwh.t00004.title')}" />]</a></div></li>
		           </s:if>
		         </ul>
		       </li>
		       </s:if>
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
	<SCRIPT LANGUAGE="JavaScript">
	  <!--
	    //如果不添加这一条的话。菜单没有列表会出错！
	    if ($('.easyui-accordion')[0].children.length==0)
		{
			$('.easyui-accordion')[0].innerHTML="<div style='display:none;'></div>";
		}
	  //-->
	</SCRIPT>
</body>
</html>