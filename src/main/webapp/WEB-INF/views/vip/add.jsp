<%--
  Created by IntelliJ IDEA.
  User: jyx
  Date: 2019/5/30
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>录入VIP客户</title>
</head>
<body>
<main>
    <p>
        <strong>${message}</strong>
    </p>
    <form action="/vip/add.do" method="post">
        <p>
            <label>*手机号：<input name="phone" placeholder="将作为VIP编号" value="${param.phone}"></label>
        </p>
        <p>
            <label>*姓名：<input name="name" value="${param.name}"></label>
        </p>
        <p>
            <label>性别:</label>
            <label>
                <input name="sex" type="radio" value="1" checked> 男
            </label>
            <label>
                <input name="sex" type="radio" value="0" value="${param.sex=='0'?checked:''}"> 女
            </label>
        </p>
        <p>
            <label>年龄：<input name="age" type="number" value="${param.phone}" min="0"></label>
        </p>
        <p>
            <label>QQ：<input name="qq" value="${param.qq}"></label>
        </p>
        <p>
            <label>email：<input name="email" type="email" value="${param.email}"></label>
        </p>
        <p>
            <label>邮编：<input name="zip" value="${param.zip}"></label>
        </p>
        <p>
            <label>邮寄地址：<input name="address" value="${param.address}"></label>
        </p>
        <p>
            <label>备注：<input name="remark" value="${param.remark}"></label>
        </p>
        <p>
            <button type="submit">确认</button>
            <a href="/welcome.do">返回</a>
        </p>
    </form>
</main>
</body>
</html>
