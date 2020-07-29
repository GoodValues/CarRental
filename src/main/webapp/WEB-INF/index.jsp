<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>$Title$</title>
</head>
<body>

<h1> Witaj </h1>
<h2>Data Twoich odwiedzin: ${dateTime}</h2>

<form action="/chooseOffice" method="post">
    <select name="office">
        <c:forEach items="${offices}" var="office">
            <option value="${office.name}">${office.name}</option>
        </c:forEach>
    </select>
    <input type="submit" value="Submit">
</form>

</body>
</html>