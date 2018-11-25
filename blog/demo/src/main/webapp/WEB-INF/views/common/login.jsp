<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>blog</title>
    <%@include file="./common.jsp" %>
    <link rel="stylesheet" href="${ctx}/css/login.css">
    <script>
        var rootPath = "${ctx}";
    </script>
</head>
<body>
<div class="container-fluid" module-name="login">
    <form class="col-md-3" action="javascript:;">
        <div class="form-group">
            <label for="userName">用户名:</label>
            <input type="text" class="form-control" id="userName" name="userName">
        </div>
        <div class="form-group">
            <label for="password">密码:</label>
            <input type="password" class="form-control" id="password" name="password">
        </div>
        <div class="form-check">
            <label class="form-check-label">
                <!-- <input class="form-check-input" type="checkbox"> Remember me -->
            </label>
        </div>
        <button type="button" action-name="submit" class="btn btn-primary col-md-12">登录</button>
    </form>
</div>
<script src="${ctx}/js/login/login.js"></script>
</body>
</html>