<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/view/common/commonPage.jsp" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title><%=websiteName%>
    </title>
    <meta name="description" content="login page"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <%@include file="/WEB-INF/view/common/commonCss.jsp" %>
    <link rel="stylesheet" href="${resourceUrl}/css/login/login.css"/>
</head>
<!--Head Ends-->
<!--Body-->
<body class="form-bg">
<div class="container">
    <div class="row">
        <div class="col-md-offset-3 col-md-6">
            <form class="form-horizontal">
                <span class="heading">用户登录</span>

                <div class="form-group">
                    <input type="text" class="form-control" id="inputUser" placeholder="用户名">
                    <i class="fa fa-user"></i>
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" id="inputPassword" placeholder="密　码">
                    <i class="fa fa-lock"></i>
                    <!--忘记密码等元素-->
                    <a href="#" class="fa fa-question-circle"></a>
                </div>
                <div class="form-group">
                    <div class="main-checkbox">
                        <input type="checkbox" id="checkbox1" name="check"/>
                        <label for="checkbox1"></label>
                    </div>
                    <span class="text">Remember me</span>
                    <button type="button" class="btn btn-default" onclick="javascript:login();">登录</button>
                </div>
            </form>
        </div>
    </div>
</div>

<%--<%@include file="/WEB-INF/view/common/footerPart.jsp" %>--%>
<%@include file="/WEB-INF/view/common/commonJs.jsp" %>
<script>
    $(function () {

    });

    /**
     * 登录
     */
    function login() {
        var param = {
            username: $("#inputUser").val(),
            password: $("#inputPassword").val()
        };
        ajaxPost("<%=basePath%>/manage/login/toLogin", param, function (data) {
            if (data.isSuccess) {
                //进入
                window.location.href = "<%=basePath%>/manage/login/toHomePage"
            } else {
                alert(data.msg);
            }
        });
    }
</script>
</body>
</html>
