<%@ page pageEncoding="UTF-8" %>
<html>
<header>
    <meta charset="utf-8">
    <title>登录</title>
</header>
<script>
    if (window.top !== window.self){
        window.top.location.href = location.href;
    }
</script>
<body>
<strong>${message}</strong>
<form action="/test/testFrom.do" method="post">
    <p>
        <label>Account:<input name="account"></label>
    </p>
    <p>
        <label>Password:<input name="password"></label>
    </p>
    <p>
        <button type="submit">login</button>
    </p>
</form>
<%session.removeAttribute("message");%>
</body>
</html>
