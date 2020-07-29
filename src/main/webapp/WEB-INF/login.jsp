<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: Adam--%>
<%--  Date: 09.05.2020--%>
<%--  Time: 14:03--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>$Title$</title>--%>
<%--    &lt;%&ndash;  <%@ include file="WEB-INF/header.jsp"%>&ndash;%&gt;--%>
<%--</head>--%>
<%--<body>--%>

<%--<form action="/login" method="post">--%>
<%--    Login:--%>
<%--    <input type="email" name="email">--%>
<%--    Hasło:--%>
<%--    <input type="password" name="password">--%>
<%--    <input type="submit" value="Zaloguj się">--%>
<%--</form>--%>

<%--&lt;%&ndash;<%@ include file="WEB-INF/footer.jsp"%>&ndash;%&gt;--%>
<%--</body>--%>
<%--</html>--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.0/css/bootstrap.min.css"
          integrity="sha384-PDle/QlgIONtM1aqA2Qemk5gPOE7wFq8+Em+G/hmo5Iq0CCmYZLv3fVRDJ4MMwEA" crossorigin="anonymous">
    <title>Login user</title>
</head>
<body>
<div style="margin: auto; width: 500px; padding-top: 50px">
    <form:form method="post" modelAttribute="user">

        <div class="form-group">
            <label>Firstname</label>
            <form:input path="firstName" placeholder="Firstname" type="text" class="form-control" />
            <form:errors path="firstName" style="color:red" class="form-text text-muted" />
        </div>

        <div class="form-group">
            <label>Lastname</label>
            <form:input path="lastName" placeholder="Lastname" type="text" class="form-control" />
            <form:errors path="lastName" style="color:red" class="form-text text-muted" />
        </div>

        <div class="form-group">
            <label>Password</label>
            <form:input path="password" placeholder="Password" type="password" class="form-control" />
            <form:errors path="password" style="color:red" class="form-text text-muted" />
        </div>
        <form:button type="submit" class="btn btn-primary">Login</form:button>
    </form:form>
</div>
</body>
</html>