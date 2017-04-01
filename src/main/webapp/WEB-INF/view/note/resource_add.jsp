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
                <i class="icon-flag"> 资源搜集</i>
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
            <div class="col-lg-12 col-sm-12 col-xs-12">
                <div class="widget">
                    <div class="widget-header bordered-bottom bordered-palegreen">
                        <span class="widget-caption">录入</span>
                    </div>
                    <div class="widget-body">
                        <div>
                            <form class="form-horizontal form-bordered">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label no-padding-right">标题</label>

                                    <div class="col-sm-10">
                                        <input class="form-control" id="title" placeholder="请输入标题" type="text">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label no-padding-right">简述</label>

                                    <div class="col-sm-10">
                                        <input class="form-control" id="des" placeholder="请输入简述" type="text">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label no-padding-right">地址</label>

                                    <div class="col-sm-10">
                                        <input class="form-control" id="url" placeholder="请输入地址" type="url">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label no-padding-right">类型</label>

                                    <div class="col-sm-10">
                                        <select class="form-control" id="category"></select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-offset-2 col-sm-10">
                                        <a class="btn btn-blue" onclick="toSave()">保存此资源</a>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>
    <!-- content-wrapper -->
    <%@include file="/WEB-INF/view/common/footerPart.jsp" %>
</div>
<%@include file="/WEB-INF/view/common/commonJs.jsp" %>
<script>
    $(function () {
        initCategory();
    });

    function initCategory() {
        ajaxGet("${basePath}/manage/note/resource/category/list", {}, function (data) {
            var option = "";
            $.each(data, function (k, v) {
                option += "<option value='" + k + "'>" + v + "</option>";
            });
            $("#category").html(option);
        });
    }

    function toSave() {
        var title = $("#title").val();
        var des = $("#des").val();
        var url = $("#url").val();
        var category = $("#category").val();
        ajaxPost("${basePath}/manage/note/resource/add/resource", {
            title: title,
            des: des,
            url: url,
            category: category
        }, function (data) {
            if (data.isSuccess) {
                notifySuccess("添加资源成功");
            } else {
                notifyError("添加资源失败");
            }
        });
    }
</script>
</body>
</html>
