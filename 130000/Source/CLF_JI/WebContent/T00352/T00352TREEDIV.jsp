<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<s:if test='%{ACT=="D"}'>
	<p>父节点：<s:property value="%{getText('app.xtwh.t00352.parentnm')}" />
	<s:iterator value="navList" id="navEntity" status="index">
		<s:if test="#index.first">
	      &gt;&gt;
	    </s:if>
		<s:if test="!#index.last">
			<s:property value="xqnm" />
			&gt;&gt;
		</s:if>
		<s:if test="#index.last">
			<s:property value="xqnm" />
		</s:if>
	</s:iterator></p>
	<hr />
	<s:if test='%{t00352Bean.xqdm==null}'>
	  <span><input type="radio" class="radio" name="rdoXQ" id="rdoXQ" value="0" <s:if test='%{t00352Bean.parentdm=="0"}'>checked="checked"</s:if> disabled="disabled"/><s:property value="%{getText('app.xtwh.t00352.parentnm')}" /></span>
	</s:if>
	<s:iterator value="treeList" id="tabEntity" status="index">
		<s:if test="%{#index.first && t00352Bean.xqdm!=null}">	
			<input type="radio" class="radio" name="rdoXQ" id="rdoXQ" value="<s:property value="xqdm"/>"
				<s:if test="%{xqdm==t00352Bean.parentdm}">checked="checked"</s:if> disabled="disabled" />
			<span title="<s:property value="note"/>"><s:property value="xqnm" /></span>
		</s:if>
		<s:else>
			<ul>
				<li>
					<input type="radio" class="radio" name="rdoXQ" id="rdoXQ" value="<s:property value="xqdm"/>" disabled="disabled"
						title="<s:property value="xqnm" />" <s:if test="%{xqdm==t00352Bean.parentdm}">checked="checked"</s:if> />
					<span title="<s:property value="note"/>"> <s:property value="xqnm" /></span>
				</li>
			</ul>
		</s:else>
	</s:iterator>
</s:if>
<s:else>
	<!-- 迭代导航条-->
	<p>父节点：<a href="javascript:void(0)" onclick="getXqmcData('0','<s:property value="t00352Bean.noxqdm"/>','<s:property value="t00352Bean.parentdm" />','<s:property value="ACT"/>')" ><s:property value="%{getText('app.xtwh.t00352.parentnm')}" /></a>
	<s:iterator value="navList" id="navEntity" status="index">
		<s:if test="#index.first">
	      &gt;&gt;
	    </s:if>
		<s:if test="!#index.last">
			<a href="javascript:void(0)" onclick="getXqmcData('<s:property value="xqdm"/>','<s:property value="t00352Bean.noxqdm"/>','<s:property value="t00352Bean.parentdm" />','<s:property value="ACT"/>')" >
			<span title="<s:property value="note"/>"><s:property value="xqnm" /></span></a>
			&gt;&gt;
		</s:if>
		<s:if test="#index.last">
			<span title="<s:property value="note"/>"><s:property value="xqnm" /></span>
		</s:if>
	</s:iterator></p>
	<hr />
	<!-- 迭代树-->
	<s:if test='%{t00352Bean.xqdm==null}'>
	  <input type="radio" class="radio" name="rdoXQ" id="rdoXQ" value="0" <s:if test='%{t00352Bean.parentdm=="0"}'>checked="checked"</s:if> /><s:property value="%{getText('app.xtwh.t00352.parentnm')}" />
	</s:if>
	<s:iterator value="treeList" id="tabEntity" status="index">
		<s:if test="%{#index.first && t00352Bean.xqdm!=null}">
			<input class="expanded radio" type="radio" name="rdoXQ" id="rdoXQ" value="<s:property value="xqdm"/>"
				<s:if test="%{xqdm==t00352Bean.parentdm}">checked="checked"</s:if> />
			<span title="<s:property value="note"/>"><s:property value="xqnm" /></span>
		</s:if>
		<s:else>
			<ul>
				<li>
					<input type="radio" class="radio" name="rdoXQ" id="rdoXQ" value="<s:property value="xqdm"/>" title="<s:property value="xqnm" />" <s:if test="%{xqdm==t00352Bean.parentdm}">checked="checked"</s:if> />
					<a href="javascript:void(0)" title="<s:property value="note"/>" onclick="getXqmcData('<s:property value="xqdm"/>','<s:property value="t00352Bean.noxqdm"/>','<s:property value="t00352Bean.parentdm" />','<s:property value="ACT"/>')"><s:property value="xqnm" /></a>
				</li>
			</ul>
		</s:else>
	</s:iterator>
</s:else>