<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>You win</title>
    <link type="image/x-icon" href="${pageContext.request.contextPath}/static/page.jpeg" rel="shortcut icon">
    <style>
        <%@include file="/static/stylepage.css" %>
    </style>
    <style>
        body {
            background: url("/static/page.jpeg") no-repeat;
            background-size: cover;
        }
    </style>
</head>
<body>
<c:set var="name" value="${sessionScope.get('name')}"/>
<div>
    <h1>Congratulations, <c:out value="${name}"/></h1>
    <h2>You win. Do you want to start again?</h2>
    <form method="post">
        <input class="buttonWin" type="submit" value="restart">
    </form>
</div>
</body>
</html>
