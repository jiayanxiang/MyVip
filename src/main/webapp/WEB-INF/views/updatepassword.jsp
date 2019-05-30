<%--
  Created by IntelliJ IDEA.
  User: jyx
  Date: 2019/5/30
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<strong>${message}</strong>
<form action="/updatepassword.do" method="post">
    <p>
        <label>旧密码:<input name="oldPassword"></label>
    </p>
    <p>
        <label>新密码:<input name="newPassword"></label>
    </p>
    <p>
        <label>新密码确认:<input name="newPasswordConfirm"></label>
    </p>
    <p>
        <button type="submit">确认</button>
        <a href="/welcome.do">返回</a>
    </p>
</form>
</body>
</html>
