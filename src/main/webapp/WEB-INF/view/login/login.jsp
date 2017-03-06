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
    <link rel="shortcut icon" href="assets/img/favicon.png" type="image/x-icon">
    <%@include file="/WEB-INF/view/common/header.jsp" %>
    <link rel="stylesheet" href="${resourceUrl}/css/login.css"/>
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
</body>
<%@include file="/WEB-INF/view/common/footer.jsp" %>
<script>
    $(function () {

    });

    /**
     * 登录
     */
    function login() {
        var username = $("#inputUser").val();
        var password = $("#inputPassword").val();
        $.ajax({
            url: "<%=basePath%>/manage/admin/login",
            data: {
                username: username,
                password: password
            },
            type: 'post',
            dataType: 'json',
            success: function (data) {
                alert(data.username);
                alert(data.password);
                if (data.isSuccess) {
                    alert("yes");
                } else {
                    alert('no');
                }
            }
        });
    }
</script>
</html>
