<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sw" uri="/sunway" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><s:property value="%{getText('app.global.title')}" /></title>
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<script type="text/javascript" src="../scripts/T00351/VIEWT00351BZFCSN.js"></script>
<script type="text/javascript" src="../scripts/jquery.autocomplete.js"></script>
<link type="text/css" rel="stylesheet" href="../css/jquery.autocomplete.css" />
<link href="../css/screen.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../scripts/T00352/T00352TREEDIV.js"></script>
<script type="text/javascript" src="../scripts/T00001/INFOTREEDIV.js"></script>
<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript" src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../scripts/simpleTips/jquery.simpleTips-1.0.js"></script>
<link rel="stylesheet" type="text/css" href="../scripts/simpleTips/jquery.simpleTips.css" />

<script type="text/javascript" src="../scripts/DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
$(function(){
	$.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
	$.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>' });
    var csyf =$("#txtCSYF").val();
	var ywjg = -1;
	if($("#rdoYWJG0:checked").val()==0)
		ywjg = 0;
	if($("#rdoYWJG1:checked").val()==1)
		ywjg = 1;
	
	$('#test').datagrid({					
		striped: true,
		height: getGirdHeight(),
		url:'../xtwh/FINDT00351BZFCSN.action',
		sortOrder: 'desc',
		onLoadError:function(){
			$.messager.alert('错误信息','请求已发送，服务器无应答！','error');
		},
		queryParams : 
	    {
			ddlSZQYFind : $("#ddlSZQYFind").val(),
			txtXQFind : $("#txtXQFind").val(),
			txtZCDZL : $("#txtXQCX").val(),
			txtCSYF : $("#txtCSYF").val(),
			txtSLIDFind : $("#txtSLIDFind").val(),
			txtMONTHFind : $("#txtMONTHFind").val(),
			txtYWJG : ywjg
		},
	
		frozenColumns:[[
                  {title:'操作',field:'check',width:40,align:'center',formatter:function(value,rec){
                       return "<a href=javascript:Show(\'../xtwh/KBSLT00351.action?SLID=" + rec.slid+"&txtCSYF="+$("#txtCSYF").val()+"\',440,1300,'swid');><img src=\"../images/ico/Edit.gif\" title=\"查看\" alt=\"查看\" width=\"16\" height=\"16\" align=\"absmiddle\" /></a>";
                  }}
       		]],
       		columns:[[
                  {title:'<s:property value="%{getText('app.xtwh.t00351.slid')}" />',field:'slid',width:150,formatter:function(value,rec){
                      return "<a href=javascript:Show(\'../xtwh/DETAILT00351.action?SLID=" + rec.slid + "\',300,420,'swid'); title='点击查看详细信息' >" + rec.slid + "</a>";
                      }},
                  {title:'<s:property value="%{getText('app.xtwh.info.szqy')}" />',field:'szqy',width:120},
                  {title:'<s:property value="%{getText('app.xtwh.t00303.dqmc')}" />',field:'parentnm',width:200},
                  {title:'<s:property value="%{getText('app.xtwh.t00303.xqmc')}" />',field:'xqnm',width:150},
                  //{title:'<s:property value="%{getText('app.xtwh.t00303.zldz')}" />',field:'zcdzl',width:120},
                  {title:'<s:property value="%{getText('app.xtwh.info.fwlx')}" />',field:'fwlx',width:120},
                  {title:'历史基准价格(元)',field:'lsjzjg',width:120,align:'center',formatter:function(value,rec){
   	                 return "<a href=\"javascript:\" style=\"text-decoration:none;\"><span onmouseover=\"MyTip(this,'"+rec.slid+"')\" onmouseout=\"UnTip()\">查看价格</span></a>";
                   }},
                   {title:'<s:property value="%{getText('app.xtwh.t00351.zxpfmjg')}" />(元)',field:'dypfmjg',align:'right',width:120,formatter:function(value,rec){
                       return '￥'+formatNumber(value,'#,##0.00');
                         }},
                   {title:'实例个数',field:'slks',align:'right',width:120},       
                  {title:'<s:property value="%{getText('app.upddate')}" />',field:'upddate',width:150,formatter:function(value,rec){
      				return formatDateTime(value);
      			   }},
                    {title:'<s:property value="%{getText('app.czr')}" />',field:'czr',width:100},
                    {title:'<s:property value="%{getText('app.note')}" />',field:'note',width:100}
                  
	    ]],
		pagination:true,
		rownumbers:true,
		
		toolbar:[{
			text:'查询',
			iconCls:'icon-search',
			handler:function(){
					$('#w').window('open');	
					$("#sxkz").show();
			}
		},{
			text:'导出',
			iconCls:'icon-excel',
			handler:function(){
			var bzfjg = -1;
			 if($("#rdoYWJG0:checked").val()==0)
				 bzfjg = 0;
			 if($("#rdoYWJG1:checked").val()==1)
				 bzfjg = 1;
			 
			 $("#txtCSYFE").val($("#txtCSYF").val());
			 $("#txtSZQYE").val($("#ddlSZQYFind").val());
			 $("#txtXQNME").val($("#txtXQCX").val());
			 $("#txtFWLXE").val($("#txtFWLX").val());
			 $("#txtBZFJG").val(bzfjg);
					$('#findForm').submit();	
			}
		}]
	});
	$('.rootCheck').click(function(){
		$(".childCheck").each(function(){
			$(this)[0].checked=$('.rootCheck')[0].checked;
		});
	});
});


function searchDate() {
	var ywjg = -1;
	if($("#rdoYWJG0:checked").val()==0)
		ywjg = 0;
	if($("#rdoYWJG1:checked").val()==1)
		ywjg = 1;
	$('#test').datagrid('options').pageIndex = 1;
	var p = $('#test').datagrid('getPager');
	if (p){
		$(p).pagination({
			pageIndex : 1
		});
	}
	
	
	$('#test').datagrid('options').queryParams = 
    {
		ddlSZQYFind : $("#ddlSZQYFind").val(),
		txtXQFind : $("#txtXQFind").val(),
		txtZCDZL : $("#txtXQCX").val(),
		txtFWLX : $("#txtFWLX").val(),
		txtCSYF : $("#txtCSYF").val(),
		txtSLIDFind : $("#txtSLIDFind").val(),
		txtMONTHFind : $("#txtMONTHFind").val(),
		txtYWJG : ywjg
	};
	$('#test').datagrid('reload');		
};


</script>
</head>
<body>
<table  align="left" cellpadding="0" cellspacing="0" class="table1"   >

  <tr>
    <td align="left" valign="top">
	   	<div class="ui-widget-content">
			<div class="datagrid-title">
				<span class="datagrid-title-text"><s:property value="%{getText('app.xtwh.t00351bzfcsN.title')}"/></span>
			</div>
		
			
				<div id="w" style="width:350px;height:200;padding:5px;background: #fafafa;">
				<div id="sxkz" style="display:none;">
				<form id="findForm" action="EXPT00351N.action" method="post" target="_blank">
				<input type="hidden" id="hidSelect" name="hidSelect"/>
		    	<input type="hidden" name="txtCSYFE" id="txtCSYFE" />
			    <input type="hidden" name="txtBZFJG" id="txtBZFJG" />
			    <input type="hidden" name="txtSZQYE" id="txtSZQYE" />
			    <input type="hidden" name="txtXQNME" id="txtXQNME" />
			    <input type="hidden" name="txtFWLXE" id="txtFWLXE" />
					 <table width="260" border="0" cellspacing="2" cellpadding="0">
        	
						<!--<tr>
							<td><span class="titlespan"><s:property value="getText('app.xtwh.t00351.slid')" /></span>
							<input type="text" name="txtSLIDFind" id="txtSLIDFind" value="<s:property value="txtSLIDFind"/>" /></td>
						</tr>
						--><tr>
							<td><s:property value="getText('app.xtwh.info.szqy')" />		
							<sw:szqy items="szqyList" name="ddlSZQYFind" id="ddlSZQYFind" display="全部" /></td>
						</tr>
						<tr>
							<td>					
									<s:property value="%{getText('app.xtwh.t00303.xqmc')}" />
					  				<input name="txtXQCX"  id="txtXQCX" type="text" />
							</td>
						</tr>
						<tr>
			                <td>
			                    <s:property	value="%{getText('app.xtwh.info.fwlx')}" />
			                    <span class="txtInfonm"><input name="txtFWLXTIP" id="txtFWLXTIP" type="text" value="<s:property value="tBean.fwlxSc" />" class="typeInput"/><span<s:if test='%{ACT!="D"}'> id="spFWLX"</s:if>></span></span><input type="hidden" id="txtFWLX" name="txtFWLX" value="<s:property value="tBean.cd00001Fwlx" />"/>
<!--			                    <span><select id="txtFWLX" name="txtFWLX" class="txtSelect"></select></span>-->
			                </td>
			           	</tr>	
			           	<tr>
			           		<td>
			           			有无价格
			           			<input name="rdoYWJG" id="rdoYWJG2" type="radio" class="radio" value="-1" checked="checked" />全部	
								<input name="rdoYWJG" id="rdoYWJG1" type="radio" class="radio" value="1"  />有
								<input name="rdoYWJG" id="rdoYWJG0" type="radio" class="radio" value="0"  />无			  
			           		</td>
			           	</tr>	
			           	<tr>
			           	    <td>
			           	      	向前月份<input id="txtCSYF" name="txtCSYF" value="12" type="text" class="txtfocus"/> 
			           	   </td>
			           	</tr>	
						<!--<tr>
							<td><span class="titlespan"><s:property value="%{getText('app.xtwh.t00303.zcdzl')}" /></span>
							<input name="txtZCDZL" id="txtZCDZL" type="text" /></td>
						</tr>
						--><!--<tr>
							<td><span class="titlespan"><s:property value="%{getText('app.sjcj.t00302.jysj')}" /></span>
							<input name="txtMONTHFind" id="txtMONTHFind" type="text" onfocus="WdatePicker({dateFmt:'yyyyMM'})"/></td>
						</tr>
						--><!--<tr>
							<td valign="top"><span class="titlespan"><s:property value="getText('app.xtwh.t00303.xqmc')" /></span>
							<div class="infodivbz" id="T00352Tree"></div></td>
						</tr>
					-->
					
						
					</table>
				</form>
				</div>
				</div>
				<table id="test"></table>
			
		</div>
	<!--  	<div class="divbottom">
		 向前月份：<input id="txtCSYF" name="txtCSYF" value="12" type="text" class="txtfocus"/> 
		<input type="hidden" id="hidFlag" name="hidFlag" />
		</div>-->
		
    </td>
  </tr>
  
</table>

<div id="dialog"  title="请选择类型..." icon="icon-ok" style="width:350px;height:350px;padding:5px;background: #fafafa;">
			<div id="infoTreeDIV"></div>
		</div>
</body>
</html>