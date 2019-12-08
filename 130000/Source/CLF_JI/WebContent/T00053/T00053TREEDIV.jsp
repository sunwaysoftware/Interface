<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<s:if test='%{ACT=="D"}'>
	<p>父节点： <s:property	value="%{getText('app.xtwh.t00053.parentnm')}" />
	<s:iterator value="navList" id="navEntity" status="index">
		<s:if test="#index.first">
	      &gt;&gt;
	    </s:if>
		<s:if test="!#index.last">
			<s:property value="qtxznm" />
			&gt;&gt;
		</s:if>
		<s:if test="#index.last">
			<s:property value="qtxznm" />
		</s:if>
	</s:iterator></p>
	<hr />
	<s:if test='%{t00053Bean.qtxzid==null}'>
	  <span><input type="radio" class="radio" name="rdoQTXZ" id="rdoQTXZ" value="0" <s:if test='%{t00053Bean.parentid=="0"}'>checked="checked"</s:if> disabled="disabled"/><s:property value="%{getText('app.xtwh.t00053.parentnm')}" /></span>
	</s:if>
	<s:iterator value="treeList" id="tabEntity" status="index">
		<s:if test="%{#index.first && t00053Bean.qtxzid!=null}">	
			<input type="radio" class="radio" name="rdoQTXZ" id="rdoQTXZ" value="<s:property value="qtxzid"/>"
				<s:if test="%{qtxzid==t00053Bean.parentid}">checked="checked"</s:if> disabled="disabled" />
			<span title="<s:property value="note"/>"><s:property value="qtxznm" /></span>
		</s:if>
		<s:else>
			<ul>
				<li>
					<input type="radio" class="radio" name="rdoQTXZ" id="rdoQTXZ" value="<s:property value="qtxzid"/>" disabled="disabled"
						title="<s:property value="qtxznm" />" <s:if test="%{qtxzid==t00053Bean.parentid}">checked="checked"</s:if> />
					<span title="<s:property value="note"/>"> <s:property value="qtxznm" /></span>
				</li>
			</ul>
		</s:else>
	</s:iterator>
</s:if>
<s:else>
	<!-- 迭代导航条-->
	<p>父节点：<a href="javascript:void(0)" onclick="getQtxzData('0','<s:property value="t00053Bean.noqtxzid"/>','<s:property value="t00053Bean.parentid" />','<s:property value="ACT"/>')" ><s:property	value="%{getText('app.xtwh.t00053.parentnm')}" /></a>
	<s:iterator value="navList" id="navEntity" status="index">
		<s:if test="#index.first">
	      &gt;&gt;
	    </s:if>
		<s:if test="!#index.last">
			<a href="javascript:void(0)" onclick="getQtxzData('<s:property value="qtxzid"/>','<s:property value="t00053Bean.noqtxzid"/>','<s:property value="t00053Bean.parentid" />','<s:property value="ACT"/>')" >
			<span title="<s:property value="note"/>"><s:property value="qtxznm" /></span></a>
			&gt;&gt;
		</s:if>
		<s:if test="#index.last">
			<span title="<s:property value="note"/>"><s:property value="qtxznm" /></span>
		</s:if>
	</s:iterator></p>
	<hr />
	<!-- 迭代树-->
	<s:if test='%{t00053Bean.qtxzid==null}'>
	  <input type="radio" class="radio" name="rdoQTXZ" id="rdoQTXZ" value="0" <s:if test='%{t00053Bean.parentid=="0"}'>checked="checked"</s:if> /><s:property	value="%{getText('app.xtwh.t00053.parentnm')}" />
	</s:if>
	<s:iterator value="treeList" id="tabEntity" status="index">
		<s:if test="%{#index.first && t00053Bean.qtxzid!=null}">
			<input class="expanded radio" type="radio" name="rdoQTXZ" id="rdoQTXZ" value="<s:property value="qtxzid"/>"
				<s:if test="%{qtxzid==t00053Bean.parentid}">checked="checked"</s:if> />
			<span title="<s:property value="note"/>"><s:property value="qtxznm" /></span>
		</s:if>
		<s:else>
			<ul>
				<li>
					<input type="radio" class="radio" name="rdoQTXZ" id="rdoQTXZ" value="<s:property value="qtxzid"/>" title="<s:property value="qtxznm" />" <s:if test="%{qtxzid==t00053Bean.parentid}">checked="checked"</s:if> />
					<a href="javascript:void(0)" title="<s:property value="note"/>" onclick="getQtxzData('<s:property value="qtxzid"/>','<s:property value="t00053Bean.noqtxzid"/>','<s:property value="t00053Bean.parentid" />','<s:property value="ACT"/>')"><s:property value="qtxznm" /></a>
				</li>
			</ul>
		</s:else>
	</s:iterator>
</s:else>