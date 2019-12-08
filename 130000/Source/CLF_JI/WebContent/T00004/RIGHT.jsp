<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="../scripts/T00004/RIGHT.js"></script>
<div style="width:180px;height:200px;overflow:auto;border: 2px inset #FFFFFF;">
<s:if test='%{ACT!="D"}'>
<input type="checkbox" class="rootCheck radio" name="chkAll" id="chkAll" value="1"/>全选/全不选
</s:if>
<s:iterator value="rightList" id="rightEntity" status="index">
	<span class="qtxz">
	 	<input type="checkbox" class="childCheck radio" name="chkRIGHTID" id="chkRIGHTID" value='<s:property value="rightid" />'
	 		 <s:if test="isright">checked="checked"</s:if>
	 		 <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>
	 		 <s:elseif test="%{!isAdmin}">
	 		 	<s:if test="%{rightid.contains('0000038')||rightid.contains('0000039')||rightid.contains('0000041')||rightid.contains('0000042')}">
	 		 	disabled="disabled"
	 		 	</s:if>
	 		 </s:elseif> />
		<span title="<s:property value="rightnm" />"><s:property value="rightnm" /></span>
	</span>
</s:iterator>
</div>