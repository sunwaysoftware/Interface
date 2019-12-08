<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sw" uri="/sunway" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><s:property value="%{getText('app.global.title')}" /></title>
<link type="text/css" rel="stylesheet" href="../css/screen.css" />
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<script type="text/javascript" src="../scripts/jquery.autocomplete.js"></script>
<script type="text/javascript" src="../scripts/WS00001/VIEWWS00001.js"></script>
<script type="text/javascript" src="../scripts/WS00001/RESULT.js"></script>
<script type="text/javascript" src="../scripts/T00352/T00352TREEDIV.js"></script>
<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src='scripts/easyui/outlook.js'> </script>
<link type="text/css" rel="stylesheet" href="../css/screen.css" />
<link type="text/css" rel="stylesheet" href="../css/jquery.autocomplete.css" />
<script type="text/javascript">
	$(function() {
		$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
		$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });
		
		$('#test').datagrid({					
			striped: true, 
			height:400,
			url:'../sjcj/FINDRESULT.action',
			sortOrder: 'desc',
			onLoadError:function(){
				$.messager.alert('错误信息','请求已发送，服务器无应答！','error');
			},
			queryParams : 
		    {
				txtZRFSFIDFIND : $("#txtZRFSFIDFIND").val(),
				txtZRFMCFIND : $("#txtZRFMCFIND").val(),
				txtFCSLH : $("#txtFCSLH").val(),
				psSign : $("#psSign").val(),
				txtFCID : $("#txtFCID").val()
			},
			frozenColumns:[[
				{title:'操作',field:'edit',width:50,align:'center',formatter:function(value,rec){
					if (rec.psSign == "Y")
						return "<a href=\"javascript:Show(\'../pg/VIEWT00334.action?ACT=C&txtFCID=" + rec.fcid + "\',350,800,'详细信息');\"><img title=\"已估价\" alt='已估价' src='../images/ico/2.gif'/></a>&nbsp;<a href=\"../pg/EXECT00391.action?FCID="+rec.fcid+"\" target=\"_blank\"><img title=\"存量房交易价格申报评估结果通知单\" alt='打印' src='../images/ico/print.gif'/></a>";
					else
						return "<a href='javascript:showWin(\""+rec.fcid+"\");'><img title=\"未通过\" alt='未通过' src='../images/ico/21.gif'/></a>";
				}}
			]],
			columns:[[	        
	            //{title:'<s:property value="%{getText('app.ws.fcslh')}" />',field:'FCSLH',width:100},
	            {title:'<s:property value="%{getText('app.ws.pgjg')}" />',field:'jyjg',align:'right',width:100,formatter:function(value,rec){
					return '￥'+formatNumber(value,'#,##0.00');
				}},
	            {title:'<s:property value="%{getText('app.ws.xxxx')}" />',field:'fcid',width:150,formatter:function(value,rec){
					return "<a href=javascript:Show(\'../sjcj/DETAILT00302.action?FCID=" + rec.fcid + "\',400,420,'市场法房产详细信息'); title='点击查看详细信息' >" + rec.fcid + "</a>";
				}},
				{title:'<s:property value="%{getText('app.ws.cqr')}" />',field:'ZRFMC',width:100},
				{title:'<s:property value="%{getText('app.ws.zjh')}" />',field:'ZRFSFID',width:100},
				{title:'<s:property value="%{getText('app.ws.zcdzm')}" />',field:'zcdzl',width:250}
		    ]],
			
			rownumbers:true,
			
			toolbar:[
				
			]
		});
	});



    		
    
</script>
</head>
<body>
<table border="0" align="left" cellpadding="0" cellspacing="0" class="table1">
  <tr>
    <td align="left" valign="top">
     <div id="dialog" class="easyui-window" title="请选择类型..." icon="icon-ok" style="width:350px;height:300px;padding:5px;background: #fafafa;">
		<div id="infoTreeDIV"></div>
	</div>
	<div class="ui-widget-content">
	<div class="datagrid-title">
		<span class="datagrid-title-text">				
	          <s:property value="%{getText('app.ws.title')}" />
	    </span>
	</div>
<form id="findForm" action="#" method="post">
  <input type="hidden" name="txtZRFSFIDFIND" id="txtZRFSFIDFIND" value="<s:property value='t00352Bean.ZRFSFID' />" />
  <input type="hidden" name="txtZRFMCFIND"  id="txtZRFMCFIND" value="<s:property value='t00352Bean.ZRFMC' />" />
  <input type="hidden" name="txtFCSLH" id="txtFCSLH" value="<s:property value='t00352Bean.FCSLH' />" />
  <input type="hidden" name="psSign" id="psSign" value="<s:property value='t00352Bean.psSign' />" />
  <input type="hidden" name="ACT" id="ACT" value="<s:property value="ACT" />" />
  <input type="hidden" name="txtFCID" id="txtFCID" value="<s:property value='t00352Bean.fcid' />" />
</form>


<table id="test"></table>
</div>
    </td>
  </tr>
</table>
</body>
</html>
