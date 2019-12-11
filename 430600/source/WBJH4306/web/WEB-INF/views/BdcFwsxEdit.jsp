<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- content start -->
<div class="am-cf am-padding am-padding-bottom-0">
    <div class="am-fl am-cf">
        <strong class="am-text-primary am-text-lg">房产属性信息</strong> /
        <small>国土不动产交易房产属性信息</small>
    </div>
</div>
<hr>
<form class="am-form">
    <div class="am-tabs am-margin" data-am-tabs>
        <ul class="am-tabs-nav am-nav am-nav-tabs">
            <li class="am-active"><a href="#tab1">基本属性</a></li>
            <li><a href="#tab2">附加信息</a></li>
            <li><a href="#tab3">权利人</a></li>
        </ul>
        <div class="am-tabs-bd">
            <div class="am-tab-panel am-fade am-in am-active" id="tab1">
                <div class="am-g am-margin-top">
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        业务号
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.ywh}">
                    </div>
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        幢号
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.houseid}">
                    </div>
                </div>

                <div class="am-g am-margin-top">
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        房号
                    </div>
                    <div class="am-u-sm-8 am-u-md-4 am-u-end col-end">
                        <input type="text" class="am-input-sm" value="${vo.roomnum}">
                    </div>
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        坐落
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.bsit}">
                    </div>
                </div>

                <div class="am-g am-margin-top">
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        建筑面积
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.barea}">
                    </div>
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        规划用途
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.dictGhty.bdcNm}">
                    </div>
                </div>

                <div class="am-g am-margin-top">
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        房屋类型
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.dictFwlx.bdcNm}">
                    </div>
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        所在层 / 总层数
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.curflr} / ${vo.ttlflrs}">
                    </div>
                </div>

                <div class="am-g am-margin-top">
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        竣工日期
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.fnshdate}">
                    </div>
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        建筑结构
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.dictJzjg.bdcNm}">
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
                        产生时间
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.cssj}">
                    </div>
                </div>

                <div class="am-g am-margin-top">
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        套内面积
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.tnmj}">
                    </div>
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        交易类型
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.dictJylx.bdcNm}">
                    </div>
                </div>
            </div>

            <div class="am-tab-panel am-fade" id="tab2">
                <div class="am-g am-margin-top">
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        朝向
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.cx}">
                    </div>
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        端房
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.df}">
                    </div>
                </div>

                <div class="am-g am-margin-top">
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        景观
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.jg}">
                    </div>
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        装修情况
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.zxqk}">
                    </div>
                </div>

                <div class="am-g am-margin-top">
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        是否私有房产
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.sfsyfc}">
                    </div>
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        层高
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.cg}">
                    </div>
                </div>

                <div class="am-g am-margin-top">
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        契税完税日期
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.qswsrq}">
                    </div>
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        契税完税基数
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.qswsjs}">
                    </div>
                </div>
            </div>

            <div class="am-tab-panel am-fade" id="tab3">
                <table id="myTable" class="am-table am-table-striped am-table-hover table-main">
                    <thead>
                    <tr>
                        <th>名称</th>
                        <th>证件类型</th>
                        <th>证件号</th>
                        <th>权利人类型</th>
                        <th>共有方式</th>
                        <th>类别</th>
                        <th>占有份额</th>
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
                            <td>${r.dictQlrlb.bdcNm}</td>
                            <td>${r.zyfe}</td>
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
    <a id="btnBack" class="am-btn am-btn-warning am-btn-xs"><span class="am-icon-reply"></span> <spring:message code="app.page.btn.back"/></a>
</div>
<!-- content end -->
<script>
    $(document).ready(function () {
        // 返回列表
        $("#btnBack").click(function () {
            showPage('/bdc/fw/view');
        });
    });
</script>
