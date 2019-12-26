<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- content start -->
<div class="am-cf am-padding am-padding-bottom-0">
    <div class="am-fl am-cf">
        <strong class="am-text-primary am-text-lg">宗地属性信息</strong> /
        <small>国土不动产交易宗地属性信息</small>
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
                        宗地代码
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.zddm}">
                    </div>
                </div>

                <div class="am-g am-margin-top">
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        不动产单元号
                    </div>
                    <div class="am-u-sm-8 am-u-md-4 am-u-end col-end">
                        <input type="text" class="am-input-sm" value="${vo.bdcdyh}">
                    </div>
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        宗地面积
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.zdmj}">
                    </div>
                </div>

                <div class="am-g am-margin-top">
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        使用权面积
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.syqmj}">
                    </div>
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        分摊面积
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.ftmj}">
                    </div>
                </div>

                <div class="am-g am-margin-top">
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        独用面积
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.dlmj}">
                    </div>
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        使用期限
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.syqx}">
                    </div>
                </div>

                <div class="am-g am-margin-top">
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        使用权起始时间
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.syqqssj}">
                    </div>
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        使用权结束时间
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.syqjssj}">
                    </div>
                </div>

                <div class="am-g am-margin-top">
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        取得价格
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.qdjg}">
                    </div>
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        建设用地面积
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.jsydmj}">
                    </div>
                </div>

                <div class="am-g am-margin-top">
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        土地用途
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.bdcTdyt.bdcNm}">
                    </div>
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        土地等级
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.dictTddj.bdcNm}">
                    </div>
                </div>

                <div class="am-g am-margin-top">
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        土地坐落
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.tdzl}">
                    </div>
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        宗地号
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.zdh}">
                    </div>
                </div>

                <div class="am-g am-margin-top">
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        地籍号
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.djh}">
                    </div>
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        土地价格
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.tdjg}">
                    </div>
                </div>
            </div>

            <div class="am-tab-panel am-fade" id="tab2">
                <div class="am-g am-margin-top">
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        权属状态
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.qszt}">
                    </div>
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        图幅号
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.tfh}">
                    </div>
                </div>

                <div class="am-g am-margin-top">
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        权利类型
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.dictQllx.bdcNm}">
                    </div>
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        权利性质
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.dictQlxz.bdcNm}">
                    </div>
                </div>

                <div class="am-g am-margin-top">
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        建筑容积率
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.jzrjl}">
                    </div>
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        建筑密度
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.jzmd}">
                    </div>
                </div>

                <div class="am-g am-margin-top">
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        东至
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.dz}">
                    </div>
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        西至
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.xz}">
                    </div>
                </div>

                <div class="am-g am-margin-top">
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        南至
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.nz}">
                    </div>
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">
                        北至
                    </div>
                    <div class="am-u-sm-8 am-u-md-4">
                        <input type="text" class="am-input-sm" value="${vo.bz}">
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
            showPage('/bdc/zd/view');
        });
    });
</script>