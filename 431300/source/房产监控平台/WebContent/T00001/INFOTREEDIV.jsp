<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<s:if test='%{ACT=="D"}'>
	<p>父节点： <s:iterator value="navList" id="navEntity" status="index">
		<s:if test="!#index.last">
			<s:property value="infonm" />
			&gt;&gt;
		</s:if>
		<s:if test="#index.last">
			<s:property value="infonm" />
		</s:if>
	</s:iterator></p>
	<hr />
	<s:iterator value="treeList" id="tabEntity" status="index">
		<s:if test="#index.first">
			<input type="radio" class="radio" name="rdoPARENT" id="rdoPARENT" value="<s:property value="infoid"/>"
				<s:if test="%{infoid==t00001Dao.infoid}">checked="checked"</s:if> disabled="disabled" />
			<span title="<s:property value="note"/>"><s:property value="infonm" /></span>
		</s:if>
		<s:else>
			<ul>
				<li>
					<input type="radio" class="radio" name="rdoPARENT" id="rdoPARENT" value="<s:property value="infoid"/>" disabled="disabled"
						title="<s:property value="infonm" />" <s:if test="%{infoid==t00001Dao.infoid}">checked="checked"</s:if> />
					<span title="<s:property value="note"/>"> <s:property value="infonm" /></span>
				</li>
			</ul>
		</s:else>
	</s:iterator>
</s:if>
<s:else>
	<!-- 迭代导航条-->
	<p>父节点： <s:iterator value="navList" id="navEntity" status="index">
		<s:if test="!#index.last">
			<a href="#" onclick="getInfoData('<s:property value="rootid"/>','<s:property value="infoid"/>','<s:property value="PARENTID"/>','','')" >
			<span title="<s:property value="note"/>"><s:property value="infonm" /></span></a>
			&gt;&gt;
		</s:if>
		<s:if test="#index.last">
			<span title="<s:property value="note"/>"><s:property value="infonm" /></span>
		</s:if>
	</s:iterator></p>
	<hr />
	<!-- 迭代树-->
	<s:iterator value="treeList" id="tabEntity" status="index">
		<s:if test="#index.first">
			<input type="radio" class="radio" name="rdoPARENT" id="rdoPARENT" value="<s:property value="infoid"/>"
				<s:if test="%{infoid==PARENTID}">checked="checked"</s:if> />
			<span title="<s:property value="note"/>"><s:property value="infonm" /></span>
		</s:if>
		<s:else>
			<ul>
				<li>
					<input type="radio" class="radio" name="rdoPARENT" id="rdoPARENT" value="<s:property value="infoid"/>" 
						title="<s:property value="infonm" />" <s:if test="%{infoid==PARENTID}">checked="checked"</s:if> />
                        <a href="#" title="<s:property value="note"/>" onclick="getInfoData('<s:property value="rootid"/>','<s:property value="infoid"/>','<s:property value="PARENTID"/>','')"><s:property value="infonm" /></a>
				</li>
			</ul>
		</s:else>
	</s:iterator>
</s:else>