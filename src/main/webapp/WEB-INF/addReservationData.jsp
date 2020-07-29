<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>$Title$</title>
</head>
<body>

<h1>
    Choose reservation date:
</h1>

<form action="/addReservationData" modelAttribute="reservation" method="post" >

    <label for="dateFrom">Rental date</label>
    <input type="date" name="dateFrom" id="dateFrom">
    <label for="dateTo">Return date</label>
    <input type="date" name="dateTo" id="dateTo">

    <form:select path="rentalBranch" id="rentalBranches">
        <c:forEach var="branch" items="${branches}">
            <form:option value="${branch.address}">${branch.address}</form:option>
        </c:forEach>
    </form:select>
    <form:select path="returnBranch" id="returnBranches">
        <c:forEach var="branch" items="${branches}">
            <form:option value="${branch.address}">${branch.address}</form:option>
        </c:forEach>
    </form:select>

    <input type="submit" value="Submit">

</form>

</body>
</html>