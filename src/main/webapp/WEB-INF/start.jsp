<%@ page import="com.javarush.kgurov.constant.Constants" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quest</title>
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

<div id="prolog">
    <h1>Пролог</h1>
    <p><%= Constants.textForProlog%>
    </p>
</div>
<div id="meetup">
    <h1>Знакомство с командой</h1>
    <p><%= Constants.teamMeetUp%>
    </p>
</div>
<form method="post">
    <label>
        <input id="inputName" type="text" alt="Enter your name: " name="name">
    </label>
    <button type="submit" class="submit" id="buttonA">start</button>
</form>
</body>

</html>
