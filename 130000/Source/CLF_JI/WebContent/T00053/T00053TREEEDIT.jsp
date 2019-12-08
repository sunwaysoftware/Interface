<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@taglib prefix="s" uri="/struts-tags"%>
	<!-- 迭代导航条-->
	<p>父节点： <a href="javascript:void(0)"  class="expanded"  expQTXZID="0"><s:property	value="%{getText('app.xtwh.t00053.parentnm')}" /></a>
	<s:iterator value="navList" id="navEntity" status="index">
		<s:if test="#index.first">
	      &gt;&gt;
	    </s:if>
		<s:if test="!#index.last">
			<a href="javascript:void(0)" class="expanded" expQTXZID="<s:property value="qtxzid"/>" > 
				<s:property value="qtxznm" />
			</a> &gt;&gt;
		</s:if>
		<s:if test="#index.last">
			<s:property value="qtxznm" />
		</s:if>
	</s:iterator></p>
	<hr />
	<!-- 迭代树-->
	<s:if test='%{t00053Bean.qtxzid==null}'><img src="../images/opendir.gif" width="16" height="16" title="<s:property	value="%{getText('app.xtwh.t00053.parentnm')}" />" alt="<s:property	value="%{getText('app.xtwh.t00053.parentnm')}" />"/><s:property	value="%{getText('app.xtwh.t00053.parentnm')}" /></s:if>
	<s:iterator value="treeList" id="tabEntity" status="index">
		<s:if test="%{#index.first && t00053Bean.qtxzid!=null}">
			<input type="radio" class="radioQTXZ radio" name="rdoQTXZ" id="rdoQTXZ" value="<s:property value="qtxzid"/>"
				<s:if test="%{qtxzid==t00053Bean.qtxzid}">checked="checked"</s:if> title="<s:property value="qtxznm" />" expQTXZNM="<s:property value="qtxznm" />" />
			<label title="<s:property value="note"/>"><s:property value="qtxznm" /></label>
		</s:if>
		<s:else>
			<ul>
				<li>
					<input type="radio" class="radioQTXZ radio" name="rdoQTXZ" id="rdoQTXZ" value="<s:property value="qtxzid"/>" 
						title="<s:property value="qtxznm" />" <s:if test="%{qtxzid==t00053Bean.qtxzid}">checked="checked"</s:if> expQTXZNM="<s:property value="qtxznm" />" />
                    <a href="javascript:void(0)" title="<s:property value="note"/>" class="expanded" expQTXZID="<s:property value="qtxzid"/>""><s:property value="qtxznm" /></a>
				</li>
			</ul>
		</s:else>
	</s:iterator>