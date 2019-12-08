<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sw" uri="/sunway" %>
<s:if test="%{FINDRTNFLAG}">
	<input type="hidden" name="txtLFID" value='<s:property value="v00303Bean.lfid"/>' />
	<input type="hidden" name="txtJZJG" value='<s:property value="v00303Bean.cd00001Jzjg"/>'/>
	<!--<input type="hidden" name="rdoYWDT" value='<s:property value="v00303Bean.ywdt"/>'/>
	<input type="hidden" name="rdoYWJKC" value='<s:property value="v00303Bean.ywjkc"/>'/>
	--><input type="hidden" name="txtZLC" value='<s:property value="v00303Bean.zlc"/>'/>
	<input type="hidden" name="txtNOTE" value='<s:property value="v00303Bean.note"/>'/>
	<input type="hidden" name="ddlSZQY" value='<s:property value="v00303Bean.cd00001Szqy"/>'/>
</s:if>
<!-- 
<s:if test='{FormA}'>
	<script type="text/javascript">
		getXQ($('#ddlSZQY').val(), '<s:property value="v00303Bean.cd00352Xqdm" />', '#txtXQTIP')
	</script>
</s:if> -->
<input type="hidden" name="FROMCJ" id="FROMCJ" value="<s:property value="FROMCJ"/>" />
<input type="hidden" name="ZCDZL" id="ZCDZL" value="<s:property value="v00303Bean.zcdzl"/>" />
<input type="hidden" name="isPIC" id="isPIC" value="<s:property value="isPIC"/>"/>
<s:property value="message"/>
<table width="100%" border="0" cellspacing="3" cellpadding="0">
<!--       <tr>-->
<!--           <td><label class="labelA"><s:property value="getText('app.xtwh.info.szqy')"/></label>-->
<!--           <s:if test='%{ACT == "D"}'>-->
<!--           		<sw:szqy items="szqyList" name="ddlSZQY" classid="txtfocus" id="ddlSZQY" checked="v00303Bean.cd00001Szqy" disabled="disabled"  />-->
<!--           </s:if>-->
<!--           <s:else>-->
<!--           		<sw:szqy items="szqyList" name="ddlSZQY" classid="txtfocus" id="ddlSZQY" checked="v00303Bean.cd00001Szqy"  /> -->
<!--           </s:else>-->
<!--				-->
<!--           </td>-->
<!--       </tr>       -->
		<tr>
			<td><label class="labelA">
					<s:property value="%{getText('app.xtwh.t00303.xqcx')}" />
				</label>
	  				<input name="txtXQCX"  id="txtXQCX" type="text" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>/>
			</td>
		</tr>
  	<tr>
		<td><label class="labelA">
					 <s:property value="%{getText('app.xtwh.t00303.xqmc')}" />
		 	</label>
		    <span class="txtInfonm txtfocus"><input name="txtXQTIP" id="txtXQTIP"  value="<s:property value="v00303Bean.xqnm"/>" type="text" readonly="readonly" <s:if test='%{ACT == "D"}'>disabled="disabled"</s:if> /><span<s:if test='%{ACT!="D"}'> id="spXQDM"</s:if>></span></span><input type="hidden" id="txtXQDM" name="txtXQDM" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> value="<s:property value="v00303Bean.cd00352Xqdm" />"/>
		      <s:if test='%{ACT != "D"}'><span onclick="ShowXQXX()" ><img src="../images/ico/light.gif" title="图片查询" alt="图片查询" width="16" height="16" align="absmiddle"></span></s:if>
		</td>
	</tr>
	<!-- 采集页面用  -->	
		<tr>
	        <td>
	        <div id="xqcxDIV" style="display:none;">
		        <label class="labelA">
					<s:property value="%{getText('app.xtwh.t00352.xjxqmc')}" />
					</label>
					<input name="txtXJXQMC" class="txtfocus" id="txtXJXQMC" type="text" disabled="disabled"/>
					<input name="hidPARENTDM"  id="hidPARENTDM" type="hidden" />
					<input name="hidXQZT"  id="hidXQZT" type="hidden" />
				</div>
			</td>
	    </tr>
	<tr>
		<td><label class="labelA">
				<s:property value="%{getText('app.xtwh.t00303.zlc')}" />
			</label>
			    <s:if test='%{ACT=="A"}'>
			    <s:property value="v00303Bean.zlc" default="1"/>
			    </s:if>  				
 				<s:else>
			    <input name="txtZLC" class="txtfocus txtNumber" id="txtZLC" type="text" value="<s:property value="v00303Bean.zlc" default="1"/>"  <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>/>
			    </s:else>
		</td>
	</tr>	
		<tr>
		                    	<td><label class="labelA">
		                                <s:property value="getText('app.sjcj.t00302.szlc')"/>
		                            </label>
		                            <input name="txtSZLC" class="txtfocus txtNumber" id="txtSZLC" type="text" value="<s:property value="tBean.szlc" default="0"/>"  <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if>/>
		                        </td>
	                    	</tr>
	                    	<tr>
		                        <td><label class="labelA">
		                                <s:property	value="%{getText('app.xtwh.info.jzjg')}" />
		                            </label>
		                              <span class="txtInfonm txtfocus"><input name="txtJZJGTTIP" id="txtJZJGTTIP" type="text" value="<s:property value="tBean.jzjg" />" readonly="readonly"  <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> /><span<s:if test='%{ACT!="D"}'> id="spJZJG"</s:if>></span></span><input type="hidden" id="txtJZJGT" name="txtJZJGT" <s:if test='%{ACT=="D"}'>disabled="disabled"</s:if> value="<s:property value="tBean.cd00001Jzjg" />"/>
		                         </td>
	                         </tr>    	
</table>
