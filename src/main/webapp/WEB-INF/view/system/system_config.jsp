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
                <i class="icon-flag"> 用户列表</i>
            </h5>
            <h1>
                <span class="label label-blueberry">
                    Remark:
                    <small>用户列表...</small>
                </span>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
                <li class="active">Here</li>
            </ol>
        </section>
        <!-- Main content -->
        <section class="content">

        </section>
        <!-- content -->
    </div>
    <!-- content-wrapper -->
    <%@include file="/WEB-INF/view/common/footerPart.jsp" %>
</div>
<%@include file="/WEB-INF/view/common/commonJs.jsp" %>

</body>
</html>
