<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:set var="score" value="${sessionScope.get('score')}"/>
    <title>Quest</title>
    <link type="image/x-icon" href="${pageContext.request.contextPath}/static/page.jpeg" rel="shortcut icon">
    <style>
        <%@include file="/static/stylepage.css" %>
    </style>
    <style>
        <c:choose>
        <c:when test="${score == 0 || score == 1 || score == 2}">
        body {
            background: url("/static/page.jpeg") no-repeat;
            background-size: cover;
        }

        </c:when>
        </c:choose>
    </style>
</head>
<body>
<form method="post" id="question-form">
    <div class="answers">
        <label>
            <input type="radio" name="answer" value="1">
            <span>
                <c:choose>
                    <c:when test="${score == 0}">
                        Принять вызов НЛО
                    </c:when>
                    <c:when test="${score == 1}">
                        Подняться на мостик
                    </c:when>
                    <c:when test="${score == 2}">
                        Рассказать правду о себе
                    </c:when>
                    <c:otherwise>Все плохо...</c:otherwise>
                </c:choose>
            </span>
        </label>
        <label>
            <input type="radio" name="answer" value="0">
            <span>
                <c:choose>
                    <c:when test="${score == 0}">
                        Отклонить вызов
                    </c:when>
                    <c:when test="${score == 1}">
                        Отказаться подниматься на мостик
                    </c:when>
                    <c:when test="${score == 2}">
                        Солгать о себе
                    </c:when>
                    <c:otherwise>Все плохо...</c:otherwise>
                </c:choose>
            </span>
        </label>
    </div>
    <button type="submit" class="button">Ответить</button>
</form>
<div id="stats">
    <p>Информация: </p>
    <p>Ip address: ${sessionScope.get("address")}</p>
    <p>Name: ${sessionScope.get("name")}</p>
    <p>ID: ${sessionScope.get("id")}</p>
    <p>Curr score: ${sessionScope.get("score")}</p>
</div>
</body>

</html>