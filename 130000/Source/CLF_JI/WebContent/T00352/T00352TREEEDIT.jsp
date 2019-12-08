<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@taglib prefix="s" uri="/struts-tags"%>
	<!-- 迭代导航条-->
	<p>父节点： <a href="javascript:void(0)"  class="expanded"  expXQID="0"><s:property value="%{getText('app.xtwh.t00352.parentnm')}" /></a>
	<s:iterator value="navList" id="navEntity" status="index">
		<s:if test="#index.first">
	      &gt;&gt;
	    </s:if>
		<s:if test="!#index.last">
			<a href="javascript:void(0)" class="expanded" expXQID="<s:property value="xqdm"/>" > 
				<s:property value="xqnm" />
			</a> &gt;&gt;
		</s:if>
		<s:if test="#index.last">
			<s:property value="xqnm" />
		</s:if>
	</s:iterator></p>
	<hr />
	<!-- 迭代树-->
	<s:if test='%{t00352Bean.xqdm==null}'><img src="../images/opendir.gif" width="16" height="16" title="目录" alt="目录"/><s:property value="%{getText('app.xtwh.t00352.parentnm')}" /></s:if>
	<s:iterator value="treeList" id="tabEntity" status="index">
		<s:if test="%{#index.first && t00352Bean.xqdm!=null}">
			<input type="radio" class="radioXQ radio" name="rdoXQ" id="rdoXQ" value="<s:property value="xqdm"/>"
				<s:if test="%{xqdm==t00352Bean.xqdm}">checked="checked"</s:if> expXQNM="<s:property value="xqnm" />" />
			<span title="<s:property value="note"/>"><s:property value="xqnm" /></span>
		</s:if>
		<s:else>
			<ul>
				<li>
					<input type="radio" class="radioXQ radio" name="rdoXQ" id="rdoXQ" value="<s:property value="xqdm"/>" 
						title="<s:property value="xqnm" />" <s:if test="%{xqdm==t00352Bean.xqdm}">checked="checked"</s:if> expXQNM="<s:property value="xqnm" />" />
                    <a href="javascript:void(0)" title="<s:property value="note"/>" class="expanded" expXQID="<s:property value="xqdm"/>""><s:property value="xqnm" /></a>
				</li>
			</ul>
		</s:else>
	</s:iterator>