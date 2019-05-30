<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Title</title>
</head>
<body>
<header>
    <strong>${message}</strong>
    <form action="/vip/qry.do" method="post">
        <p>
            <label>
                VIP:
                <input name="code" autofocuso>
            </label>
            <button type="submit">查询</button>
        </p>
    </form>
</header>
<main>
    <c:if test="${v!=null}">
        <article>
            <p>
                <span>
                    编号：
                    <b>${v.code}</b>
                </span>
                <span>
                    VIP等级：
                    <b>${v.rank}</b>
                </span>
                <span>
                    目前消防金额：
                    <b>${v.amount}</b>
                </span>
            </p>
            <p>
                <span>
                    姓名：
                    <b>${v.name}</b>
                </span>
                <span>
                    性别：
                    <b>${v.sex}</b>
                </span>
                <span>
                    年龄：
                    <b>${v.age}</b>
                </span>
            </p>
            <p>
                <span>
                    QQ：
                    <b>${v.qq}</b>
                </span>
                <span>
                    email：
                    <b>${v.email}</b>
                </span>
            </p>
            <p>
                <span>
                    邮寄地址/邮编：
                    <b>${v.address}/${v.zip}</b>
                </span>
            </p>
        </article>
    </c:if>
</main>
</body>
</html>
