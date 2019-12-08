<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="../css/screen.css" />
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/common.js"></script>
<script type="text/javascript" src="../scripts/jquery.validate.js"></script>
<script type="text/javascript" src="../scripts/messages_cn.js"></script>
<script type="text/javascript"	src="../scripts/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"	src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../scripts/DatePicker/WdatePicker.js"></script>
<style type="text/css">
.text-width{
	width:200px;
}
</style>
<script type="text/javascript">
$(function () {
    $.notifyBar({cls: "success", html: '<s:property value="actionMessages.get(0)"/>'});
    $.notifyBar({cls: "error", html: '<s:property value="actionErrors.get(0)"/>'});
	//FROM验证信息
	$("#editForm").validate({
		rules: {
			txtBDCZH: {required: true},
			txtQLR: {required: true},
			txtGYQK: {required: true, maxlength : 200},
			txtZLDZ: {required: true},
			txtQLLX: {required: true},
			txtQLXZ: {required: true},
			txtGHYT: {required: true},
			txtJZMJ: {required: true},
			txtBDCDYH: {required: true},
			txtSYQX: {required: true},
			txtJYSJ: {required: true},
			txtJZMJ : {
				required : true,
				number : true,
				min : 1,
				maxlength : 14
			},
			txtHTJG : {
				required : true,
				number : true,
				min : 1,
				maxlength : 14
			},
			txtPGJG : {
				required : true,
				number : true,
				min : 1,
				maxlength : 14
			}			
		}
	});
});
</script>
</head>
<body>
<div class="ui-widget-content">
	<div class="datagrid-title">
		<span class="datagrid-title-text"><s:property	value="%{getText('app.sjcj.t00302.title')}" /></span>
	</div>
</div>
	<form  id="editForm" action="../sjcj/CRUDT00401.do" method="post">
		<input type="hidden" id="act" name="act" value="<s:property value="act"/>" />
		<input type="hidden" id="pk" name="pk" value="<s:property value="pk" />" />
		<table style="width: 100%">
			<tr>
				<td>不动产证号</td>
				<td><input type="text" id="txtBDCZH" name="txtBDCZH" class="text-width txtfocus" value="<s:property value="pageBean.bdczh" />" ></td>
				<td>权利人</td>
				<td><input type="text" id="txtQLR" name="txtQLR" class="text-width txtfocus" value="<s:property value="pageBean.qlr" />"></td>
				<td>共有情况</td>
				<td><input type="text" id="txtGYQK" name="txtGYQK" class="text-width txtfocus" value="<s:property value="pageBean.gyqk" />"></td>
			</tr>
			<tr>
				<td>坐落地址</td>
				<td><input type="text" id="txtZLDZ" name="txtZLDZ" class="text-width txtfocus" value="<s:property value="pageBean.zldz" />"></td>
				<td>不动产单元号</td>
				<td><input type="text" id="txtBDCDYH" name="txtBDCDYH" class="text-width txtfocus" value="<s:property value="pageBean.bdcdyh" />"></td>
				<td>权利类型</td>
				<td><input type="text" id="txtQLLX" name="txtQLLX" class="text-width txtfocus" value="<s:property value="pageBean.qllx" />"></td>
			</tr>
			<tr>
				<td>权利性质</td>
				<td><input type="text" id="txtQLXZ" name="txtQLXZ" class="text-width txtfocus" value="<s:property value="pageBean.qlxz" />"></td>
				<td>规划用途</td>
				<td><input type="text" id="txtGHYT" name="txtGHYT" class="text-width txtfocus" value="<s:property value="pageBean.ghyt" />"></td>				
				<td>建筑面积</td>
				<td><input type="text" id="txtJZMJ" name="txtJZMJ" class="text-width txtfocus txtNumber" value="<s:property value="pageBean.jzmj" />"></td>		
			</tr>				
			<tr>
				<td>使用期限</td>
				<td><input type="text" id="txtSYQX" name="txtSYQX" class="text-width txtfocus" value="<s:property value="pageBean.syqx" />"></td>
				<td>其他状况</td>
				<td><input type="text" id="txtQTZK" name="txtQTZK" class="text-width" value="<s:property value="pageBean.qlqtzk" />"></td>			
				<td>所在区域</td>
				<td><input type="text" id="txtSZQY" name="txtSZQY"  class="text-width" value="<s:property value="pageBean.szqy" />"></td>
			</tr>
			<tr>
				<td>所在楼层</td>
				<td><input type="text" id="txtSZLC" name="txtSZLC" class="text-width" value="<s:property value="pageBean.lc" />"></td>
				<td>建成年份</td>
				<td><input type="text" id="txtJCNF" name="txtJCNF" class="text-width" value="<s:property value="pageBean.jcnf" />"></td>
				<td>合同价格</td>
				<td><input type="text" id="txtHTJG" name="txtHTJG" class="text-width txtfocus txtNumber" value="<s:property value="pageBean.htjg" />"></td>				
			</tr>
			<tr>
				<td>建筑结构</td>
				<td><input type="text" id="txtJZJG" name="txtJZJG" class="text-width" value="<s:property value="pageBean.jzjg" />"></td>
				<td>相关特性</td>
				<td><input type="text" id="txtZHXZ" name="txtZHXZ" class="text-width" value="<s:property value="pageBean.zhxz" />"></td>
				<td>评估结果</td>
				<td><input type="text" id="txtPGJG" name="txtPGJG" class="text-width txtfocus txtNumber" value="<s:property value="pageBean.pgjg" />"></td>
			</tr>
			<tr>
				<td>交易时间</td>
				<td><input type="text" name="txtJYSJ" id="txtJYSJ" value="<s:if test="null!=pageBean.jysj"><s:text name="app.global.format.date"><s:param value="pageBean.jysj" /></s:text></s:if>"	onfocus="WdatePicker({dateFmt: 'yyyy-MM-dd'})"  class="Wdatefocus text-width"></input></td>
				<td>备注</td>
				<td colspan="3"><input type="text" id="txtNOTE" name="txtNOTE"  value="<s:property value="pageBean.note" />"  class="text-width"/></td>
			</tr>			
		</table>		
	</form>
	<div class="divbottom">	
        <s:if test='%{act=="U"}'>
          <a href="javascript:AppSubmit();">
            <img src="../images/ico/Edit.gif" width="16" height="16" title="<s:property value="getText('app.button.upd')"/>" alt="<s:property value="getText('app.button.upd')"/>" /><s:property value="getText('app.button.upd')"/></a>
          </s:if> 
        <s:elseif test='%{act=="C"}'>
          <a href="javascript:AppSubmit();">
            <img src="../images/ico/Update.gif" width="16" height="16" title="<s:property value="getText('app.button.save')"/>" alt="<s:property value="getText('app.button.save')"/>" /><s:property value="getText('app.button.save')"/></a>
		</s:elseif><s:elseif test='%{act=="D"}'>
			<a href="javascript:AppSubmit();">
            	<img src="../images/ico/Delete.gif" width="16" height="16" title="<s:property value="getText('app.button.del')"/>" alt="<s:property value="getText('app.button.del')"/>"/><s:property value="getText('app.button.del')" />
            </a>
		</s:elseif>
        <a href="VIEWT00401.do"><img src="../images/ico/Cancel.gif" width="16" height="16" title="<s:property value="getText('app.button.back')"/>" alt="<s:property value="getText('app.button.back')"/>" /><s:property value="getText('app.button.back')"/></a>
    </div>
</body>
</html>