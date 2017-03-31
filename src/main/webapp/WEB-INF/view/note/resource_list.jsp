<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/view/common/commonPage.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="description" content="main page"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>${websiteName}</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <%@include file="/WEB-INF/view/common/commonCss.jsp" %>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <%--header--%>
    <%@include file="/WEB-INF/view/common/headerPart.jsp" %>
    <%--sidebar--%>
    <%@include file="/WEB-INF/view/common/sidebarPart.jsp" %>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h5 class="row-title">
                <i class="icon-flag"> 资源列表</i>
            </h5>
            <h1>
                <span class="label label-blueberry">
                    Remark:
                    <small>博客,笔记,文章日常整理...</small>
                </span>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
                <li class="active">Here</li>
            </ol>
        </section>
        <!-- Main content -->
        <section class="content">
            <table id="resourceList"></table>
        </section>
        <!-- content -->
    </div>
    <!-- content-wrapper -->
    <%@include file="/WEB-INF/view/common/footerPart.jsp" %>
</div>
<%@include file="/WEB-INF/view/common/commonJs.jsp" %>
<script>
    $(function () {
        initTable();
    });

    function initTable() {
        $("#resourceList").bootstrapTable({
            url: "${basePath}/manage/note/resource/getResourceList",
            method: "get", //请求参数
            striped: true,  //表格显示条纹
            pagination: true, //启动分页
            pageSize: 10,  //每页显示的记录数
            pageNumber: 1, //当前第几页
            pageList: [10, 20, 50],  //记录数可选列表
            search: false,  //是否启用查询
            showColumns: true,  //显示下拉框勾选要显示的列
            showRefresh: true,  //显示刷新按钮
            sidePagination: "server", //表示服务端请求
            responseHandler: function (res) {
                return {rows: res.data, total: res.count};
            },
            queryParamsType: "limit", //设置成为limit会发送符合RESTFull类型的参数
            queryParams: function queryParams(params) {   //设置查询参数
                var param = {
                    //这里是在ajax发送请求的时候设置一些参数 params有什么东西，自己看看源码就知道了
                    pageNo: params.offset,
                    pageSize: params.limit
                };
                return param;
            },
            onLoadSuccess: function (data) {  //加载成功时执行
            },
            onLoadError: function () {  //加载失败时执行
                alert("加载数据失败");
            },
            columns: [
                {
                    title: 'ID',
                    field: 'id',
                    align: 'center',
                    valign: 'middle'
                },
                {
                    title: '标题',
                    field: 'title',
                    align: 'center',
                    valign: 'middle'
                }, {
                    title: '简述',
                    field: 'des',
                    align: 'center',
                    valign: 'middle'
                }, {
                    title: '资源路径',
                    field: 'url',
                    align: 'center',
                    valign: 'middle'
                }, {
                    title: '所属类目',
                    field: 'category',
                    align: 'center',
                    valign: 'middle'
                }, {
                    title: '操作时间',
                    field: 'createDate',
                    align: 'center',
                    valign: 'middle'
                }, {
                    title: '操作',
                    field: 'id',
                    align: 'center',
                    formatter: function (value, row, index) {
                        var e = '<a onclick="alert(\'' + row.id + '\')">编辑</a> ';
                        var d = '<a onclick="toDelete(\'' + row.id + '\')">删除</a> ';
                        return e + d;
                    }
                }
            ]
        });
    }

    function toDelete(id) {

    }
</script>
</body>
</html>
