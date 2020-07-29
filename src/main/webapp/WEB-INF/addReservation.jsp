<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>$Title$</title>
</head>
<body>

<h1>
    Choose reservation date:
</h1>

<form action="/addReservation" method="post">

    <label for="dateFrom">Marka</label>
    <input type="date" name="dateFrom" id="dateFrom" value="${reservation.dateFrom}">
    <label for="dateTo">Marka</label>
    <input type="date" name="dateTo" id="dateTo" value="${reservation.dateTo}">

    <input type="submit" value="Submit">

</form>

</body>
</html>