<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><s:property value="%{getText('app.global.title')}" /></title>
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<script type="text/javascript" src="../scripts/MAP/AC_OETags.js"></script>
<script type="text/javascript" src="../scripts/MAP/MainDTDHFrame.js"></script>
<link href="../css/screen.css" rel="stylesheet" type="text/css"/>

</head>
<body>
<div id="tabs" class="ui-widget-content">
    <ul class="ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header">
        <li><a href="#INFO"><span>地图导航</span></a></li>                    
    </ul>
	<div id="INFO" class="divConect">
	<div style="float: right; position: absolute; left: 800px; width: 200px;"></div>
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="800px">
          	<div>
	          <a href="javascript:;" title="放大" onclick="zoomIn();"><img src="../Map/images/zoomin.gif" width="19" height="19" align="middle" />放大</a>
	          <a href="javascript:;" title="缩小" onclick="zoomOut();"><img src="../Map/images/zoomout.gif" width="19" height="19" align="middle" />缩小</a>
	          <a href="javascript:;" title="平移" onclick="pan();"><img src="../Map/images/pan.gif" width="19" height="19" align="middle" />平移</a>
	          <a href="javascript:;" title="前视图" onclick="forward();"><img src="../Map/images/forward.gif" width="19" height="19" align="middle" />前视图</a>
	          <a href="javascript:;" title="后视图" onclick="backward();"><img src="../Map/images/back.gif" width="19" height="19" align="middle" />后视图</a>
	          <a href="javascript:;" title="全图显示" onclick="fullExtent();"><img src="../Map/images/full.gif" width="19" height="19" align="middle" />全图显示</a>
	          <a href="javascript:;" title="矩形选择" onclick="isRectSel();"><img src="../Map/images/rectSel.gif" width="19" height="19" align="middle" />矩形选择</a>
	          <a href="javascript:;" title="多边形选择" onclick="isPolySel();"><img src="../Map/images/polygon.gif" width="19" height="19" align="middle" />多边形选择</a>
	          <a href="javascript:;" title="测距" onclick="isMeasureLength();"><img src="../Map/images/cmj.gif" width="19" height="19" align="middle" />测距</a>
	          <a href="javascript:;" title="查询等级" onclick="CompareTDDJ();"><img src="../Map/images/ALL.GIF" width="19" height="19" align="middle" />查询等级</a>
			</div>
            <div style="background-color: #f1f1f1; border: solid 0px #000; width: 100%;">
		            <script language="JavaScript" type="text/javascript">
					<!--
					//-----------------------------------------------------------------------------
					//Globals
					//Major version of Flash required
					var requiredMajorVersion = 9;
					//Minor version of Flash required
					var requiredMinorVersion = 0;
					//Minor version of Flash required
					var requiredRevision = 124;										
					// Version check for the Flash Player that has the ability to start Player Product Install (6.0r65)
					var hasProductInstall = DetectFlashVer(6, 0, 65);
					
					// Version check based upon the values defined in globals
					var hasRequestedVersion = DetectFlashVer(requiredMajorVersion, requiredMinorVersion, requiredRevision);
					
					if ( hasProductInstall && !hasRequestedVersion ) {
						// DO NOT MODIFY THE FOLLOWING FOUR LINES
						// Location visited after installation is complete if installation is required
						var MMPlayerType = (isIE == true) ? "ActiveX" : "PlugIn";
						var MMredirectURL = window.location;
					    document.title = document.title.slice(0, 47) + " - Flash Player Installation";
					    var MMdoctitle = document.title;
					
						AC_FL_RunContent(
							"src", "../Map/playerProductInstall",
							"FlashVars", "MMredirectURL="+MMredirectURL+'&MMplayerType='+MMPlayerType+'&MMdoctitle='+MMdoctitle+"",
							"width", "800",
							"height", "500",
							"align", "middle",
							"id", "ArcGisMap",
							"quality", "high",
							"bgcolor", "#869ca7",
							"name", "ArcGisMap",
							"allowScriptAccess","sameDomain",
							"type", "application/x-shockwave-flash",
							"pluginspage", "http://www.adobe.com/go/getflashplayer"
						);
					} else if (hasRequestedVersion) {
						// if we've detected an acceptable version
						// embed the Flash Content SWF when all tests are passed
						AC_FL_RunContent(
								"src", "../Map/ArcGisMap",
								"width", "800",
								"height", "500",
								"align", "middle",
								"id", "ArcGisMap",
								"quality", "high",
								"bgcolor", "#869ca7",
								"name", "ArcGisMap",
								"allowScriptAccess","sameDomain",
								"type", "application/x-shockwave-flash",
								"pluginspage", "http://www.adobe.com/go/getflashplayer"
						);
					  } else {  // flash is too old or we can't detect the plugin
					    var alternateContent = 'Alternate HTML content should be placed here. '
					  	+ 'This content requires the Adobe Flash Player. '
					   	+ '<a href=http://www.adobe.com/go/getflash/>Get Flash</a>';
					    document.write(alternateContent);  // insert non-flash content
					  }
					// -->
					</script>
					<noscript>
					  	<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"
								id="ArcGisMap" width="800" height="500"
								codebase="http://fpdownload.macromedia.com/get/flashplayer/current/swflash.cab">
								<param name="movie" value="Map/ArcGisMap.swf" />
								<param name="quality" value="high" />
								<param name="bgcolor" value="#869ca7" />
								<param name="allowScriptAccess" value="always" />
								<embed src="../Map/ArcGisMap.swf" quality="high" bgcolor="#869ca7"
									width="800" height="500" name="ArcGisMap" align="middle"
									play="true"
									loop="false"
									quality="high"
									allowScriptAccess="sameDomain"
									type="application/x-shockwave-flash"
									pluginspage="http://www.adobe.com/go/getflashplayer">
								</embed>
						</object>
					</noscript>
		        </div>		    
            </td>
            <td align="left" valign="top">
            	<table border="0" cellpadding="0" cellspacing="0" width="100px">
		            <tr>
		                <td align="center" bgcolor="#e0e0e0">
		                    	查询的数据结果
		                </td>
		            </tr>
		            <tr>
			            <td>          
		            	<div id="DcxxID" style="width:180px;height:480px;overflow:auto;"></div>
		            	</td>
		      		</tr>
		      		<tr>
			            <td>
		            	<input id="btnTj" type="button" class="button" value="统计的数据结果" />
		            	<input type="hidden" name="hidDCID" id="hidDCID"/>
		            	</td>
		      		</tr>
        		</table>
            </td>
        </tr>
      </table>  
   </div>
</div>     
</body>
</html>
