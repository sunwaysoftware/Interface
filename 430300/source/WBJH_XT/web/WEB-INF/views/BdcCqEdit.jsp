<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- content start -->
<div class="am-cf am-padding am-padding-bottom-0">
    <div class="am-fl am-cf">
        <strong class="am-text-primary am-text-lg">产权信息</strong> /
        <small>国土不动产产权信息管理</small>
    </div>
</div>
<hr>
<form id="editForm" class="am-form am-form-inline">
    <input type="hidden" name="id" id="txtId" value="${vo.id}">
    <div class="am-tabs am-margin" data-am-tabs>
        <ul class="am-tabs-nav am-nav am-nav-tabs">
            <li class="am-active"><a href="#tab1">基本属性</a></li>
            <li><a href="#tab2">权利人</a></li>
        </ul>
        <div class="am-tabs-bd">
            <div class="am-tab-panel am-fade am-in am-active" id="tab1">
                <div class="am-g am-margin-top">
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        业务编号
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.ywh}" required>
                    </div>
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        不动产权证号
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.bdcqzh}">
                    </div>
                </div>
                <div class="am-g am-margin-top">
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        房屋性质
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.dictFwxz.bdcNm}">
                    </div>
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        产权来源
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.dictCqly.bdcNm}">
                    </div>
                </div>
                <div class="am-g am-margin-top">
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        交易价格
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.jyjg}">
                    </div>
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        交易时间
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.jysj}">
                    </div>
                </div>
                <div class="am-g am-margin-top">
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        不动产单元号
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.bdcdyh}">
                    </div>
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        申请登记时间
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.cssj}">
                    </div>
                </div>
                <div class="am-g am-margin-top">
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        业务状态
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.dictYwzt.bdcNm}">
                    </div>
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        合同签订时间
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.htqdsj}">
                    </div>
                </div>
            </div>

            <div class="am-tab-panel am-fade" id="tab2">
                <table id="myTable" class="am-table am-table-striped am-table-hover table-main">
                    <thead>
                    <tr>
                        <th>名称</th>
                        <th>证件类型</th>
                        <th>证件号</th>
                        <th>权利人类型</th>
                        <th>共有方式</th>
                        <th>占有份额</th>
                        <th>交易方标识</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${voQlr}" var="r" varStatus="i">
                        <tr>
                            <td>${r.sname}</td>
                            <td>${r.dictZjlx.bdcNm}</td>
                            <td>${r.scnum}</td>
                            <td>${r.dictQlrxz.bdcNm}</td>
                            <td>${r.dictGyfs.bdcNm}</td>
                            <td>${r.zyfe}</td>
                            <c:choose>
                                <c:when test="${r.jyfbs==0}">
                                    <td>转让方</td>
                                </c:when>
                                <c:otherwise>
                                    <td>承受方</td>
                                </c:otherwise>
                            </c:choose>
                            <td></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</form>
<div class="am-margin">
    <a id="btnBack" class="am-btn am-btn-warning am-btn-xs"><spring:message code="app.page.btn.back"/></a>
</div>
<!-- content end -->
<script>
    $(document).ready(function () {
        // 返回列表
        $("#btnBack").click(function () {
            showPage('/bdc/cq/view');
        });
    });
</script>