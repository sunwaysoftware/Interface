<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!-- 当编辑状态为删除的时候，所有单选按钮不可以选择 -->
<s:if test='%{ACT=="D"}'>
	<p>父节点： <s:iterator value="navList" id="navEntity" status="index">
		<s:if test="!#index.last">
			<s:property value="infonm" />&gt;&gt;
		</s:if>
		<s:if test="#index.last">
			<s:property value="infonm" />
		</s:if>
	</s:iterator></p>
	<hr />
	<s:iterator value="treeList" id="tabEntity" status="index">
		<s:if test="#index.first">
			<input type="radio" class="radio" name="rdo<s:property value="RDOTYPE"/>" id="rdo<s:property value="RDOTYPE"/>" value="<s:property value="infoid"/>"
				<s:if test="%{infoid==t00001Dao.infoid}">checked="checked"</s:if> disabled="disabled" /><s:property value="infonm" />
		</s:if>
		<s:else>
			<ul>
				<li>
					<input type="radio" class="radio" name="rdo<s:property value="RDOTYPE"/>" id="rdo<s:property value="RDOTYPE"/>" value="<s:property value="infoid"/>" disabled="disabled"	title="<s:property value="infonm" />" <s:if test="%{infoid==t00001Dao.infoid}">checked="checked"</s:if> />
					<s:property value="infonm" />
				</li>
			</ul>
		</s:else>
	</s:iterator>
</s:if>
<s:else>
	<!-- 迭代导航条-->
	<p><s:iterator value="navList" id="navEntity" status="index">
		<s:if test="!#index.last">
			<a href="#" class="expanded" expINFOID="<s:property value="infoid"/>" > 
				<s:property value="infonm" />
			</a> &gt;&gt;
		</s:if>
		<s:if test="#index.last">
			<s:property value="infonm" />
		</s:if>
	</s:iterator></p>
	<hr />
	<!-- 迭代树-->
	<s:iterator value="treeList" id="tabEntity" status="index">
		<s:if test="#index.first">
		<s:if test="%{!isdir}">
			<input type="radio" class="radio<s:property value="RDOTYPE"/> radio" name="rdo<s:property value="RDOTYPE"/>" id="rdo<s:property value="RDOTYPE"/>" value="<s:property value="infoid"/>"
				<s:if test="%{infoid==t00001Dao.infoid}">checked="checked"</s:if> title="<s:property value="infonm" />" expINFONM="<s:property value="infonm" />" />
		</s:if>
        <s:else>
        	<img src="../images/opendir.gif" width="16" height="16" title="目录" alt="目录"/>
        </s:else>
        <span title="<s:property value="note"/>"><s:property value="infonm" /></span>            
		</s:if>
		<s:else>
			<ul>
				<li>
					<s:if test="%{!isdir}">
					<input type="radio" class="radio<s:property value="RDOTYPE"/> radio"  name="rdo<s:property value="RDOTYPE"/>" id="rdo<s:property value="RDOTYPE"/>" value="<s:property value="infoid"/>" 
						title="<s:property value="infonm" />" <s:if test="%{infoid==t00001Dao.infoid}">checked="checked"</s:if> expINFONM="<s:property value="infonm" />" />
					</s:if>
                    <s:else>
                    	<img src="../images/closedir.gif" width="16" height="16" title="目录" alt="目录"/>
                    </s:else>
<!--                    <a href="#" title="<s:property value="note"/>" class="expanded" expINFOID="<s:property value="infoid"/>"><s:property value="infoid"/>:<s:property value="infonm" /></a>-->
                    <a href="#" title="<s:property value="note"/>" class="expanded" expINFOID="<s:property value="infoid"/>"><s:property value="infonm" /></a>
				</li>
			</ul>
		</s:else>
	</s:iterator>
</s:else>