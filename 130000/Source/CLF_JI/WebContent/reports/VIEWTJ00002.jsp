<%-- 
    Document   : VIEWTJ00002
    Created on : 2015-8-4, 13:50:51
    Author     : Amani
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title><s:property value="%{getText('app.global.title')}" />
        </title>
        <script type="text/javascript"
        src="../scripts/jquery.min.js"></script>
        <script type="text/javascript"
        src="../scripts/easyui/jquery.easyui.min.js"></script>
        <script type="text/javascript" src="../scripts/common.js"></script>
        <script type="text/javascript"
        src="../scripts/DatePicker/WdatePicker.js"></script>
        <script type="text/javascript" src="../scripts/chart/charts.js"></script>
        <script type="text/javascript"
        src="../scripts/chart/modules/exporting.js"></script>
        <script type="text/javascript" src="../scripts/reports/VIEWTJ00002.js"></script>
        <script type="text/javascript" src="../scripts/jquery.validate.js"></script>
        <script type="text/javascript" src="../scripts/messages_cn.js"></script>
        <script type="text/javascript"
        src="../scripts/easyui/locale/easyui-lang-zh_CN.js"></script>
        <link type="text/css" rel="stylesheet" href="../css/screen.css" />
    </head>
    <body>
        <div class="ui-widget-content">
            <div class="datagrid-title">
                <span class="datagrid-title-text"> <s:property
                        value="%{getText('app.cxtj.tj00002.title')}" /> </span>
            </div>
            <span style="background: #efefef;"> </span>
            <div id="bb"
                 style="width: 400px; height: 200px; padding: 5px; background: #fafafa;">
                <div id="sxkz" style="display: none;">
                    <form id="findForm" action="FINDTJ00001.action" method="post">
                        <table width="350" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td><s:property value="getText('app.sjcj.t00302.jysj')" />
                            </td>
                            <td><input type="text" id="txtRDSJMinFind"
                                       name="txtRDSJMinFind"
                                       value="<s:property value="txtRDSJMinFind"/>"
                                       onfocus="WdatePicker()" class="Wdatefocus" />-<input type="text"
                                       id="txtRDSJMaxFind" name="txtRDSJMaxFind"
                                       value="<s:property value="txtRDSJMaxFind"/>"
                                       onfocus="WdatePicker()" class="Wdatefocus" /></td>
                            </tr>
                        </table>
                    </form>
                </div>			
            </div>
            <div class="divtop">
                <span><a id="subA" href="javascript:void(0)" class="easyui-linkbutton"
                         plain="true" iconCls="icon-search">查询</a>
                </span>
            </div>
            <div id="appChart" style="width: 100%; height: 400px; margin: 0 auto;"></div>
        </div>
        <div id="msg"></div>
    </body>
</html>