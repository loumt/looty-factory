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
            <h1>
                Page Header
                <small>Optional description</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
                <li class="active">Here</li>
            </ol>
        </section>
        <!-- Main content -->
        <section class="content">
            <div>
                <span>标题</span><input type="text" id="title" placeholder="<!--标题-->"/>
            </div>
            <div>
                <span>简述</span><input type="text" id="des" placeholder="<!--简述-->"/>
            </div>
            <div>
                <span>地址</span><input type="url" id="url" placeholder="<!--地址-->"/>
            </div>
            <div>
                <select id="category"></select>
            </div>
            <div>
                <button onclick="toSave();">保存</button>
            </div>
        </section>
        <!-- content -->
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
                alert("OK!!!");
            } else {
                alert(data.msg);
            }
        });
    }
</script>
</body>
</html>
