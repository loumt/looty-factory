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
    <style>
        .span-blank-space {
            display: block;
            height: 30px;
        }
    </style>
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
                    <small>添加笔记资源</small>
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
                        <span class="widget-caption">笔记</span>
                    </div>
                    <div class="widget-body">
                        <input class="form-control" placeholder="主题" type="text" id="theme">
                        <span class="span-blank-space"></span>
                        <textarea id="content" class="form-control" rows="18"
                                  placeholder="Main Note Here!!!!!"></textarea>
                        <span class="span-blank-space"></span>
                        <button onclick="save()" class="btn btn-blue btn-block">上传</button>
                        <button onclick="update()" class="btn btn-blue btn-block" id="update-btn" disabled="disabled">
                            修改上一篇
                        </button>
                    </div>
                </div>
            </div>
        </section>
        <!-- content -->
        <input type="hidden" id="noteId"/>
    </div>
    <!-- content-wrapper -->
    <%@include file="/WEB-INF/view/common/footerPart.jsp" %>
</div>
<%@include file="/WEB-INF/view/common/commonJs.jsp" %>
<script>
    $(function () {

    });

    function save() {
        var theme = $("#theme").val();
        var content = $("#content").val();
        if (theme == "" || content == "") {
            notifyError("请确认内容!!");
            return;
        }
        ajaxPost("${basePath}/manage/note/noteResource/saveNoteResource", {
            theme: theme,
            content: content
        }, function (data) {
            if (data.isSuccess) {
                notifySuccess("上传成功!!!");
                $('#noteId').val(data.data);
                reBuildButton();
            } else {
                $('#noteId').val("");
                notifyError(data.msg);
            }
        });
    }

    function update() {
        var theme = $("#theme").val();
        var content = $("#content").val();
        if (theme == "" || content == "") {
            notifyError("请确认内容!!");
            return;
        }
        ajaxPost("${basePath}/manage/note/noteResource/updateNoteResource", {
            id: $('#noteId').val(),
            theme: theme,
            content: content
        }, function (data) {
            if (data.isSuccess) {
                notifySuccess("修改成功!!!");
            } else {
                notifyError(data.msg);
            }
        });
    }

    function reBuildButton() {
        if ($("#noteId").val()) {
            $('#update-btn').removeAttr("disabled");
        } else {
            $('#update-btn').attr("disabled", "disabled");
        }
    }
</script>
</body>
</html>
