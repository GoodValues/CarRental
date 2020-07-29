<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>$Title$</title>
</head>
<body>

<h1>Lista samochodów</h1>

<a href="/addReservation">Add new reservation</a>
<table>
    <tr>
        <th>Date of Rent</th>
        <th>Client</th>
        <th>Car</th>
        <th>Date from</th>
        <th>Date To</th>
        <th>Rental Branch</th>
        <th>Return Branch</th>
        <th>Total Price</th>
        <th></th>
        <th></th>
    </tr>

    <c:forEach var="reservation" items="${reservations}">
        <tr>
            <td>${reservation.rentalDate}</td>
            <td>${reservation.client.firstName} ${reservation.client.lastName}</td>
            <td>${reservation.car.brand} ${reservation.car.model}</td>
            <td>${reservation.dateFrom} ${reservation.dateTo}</td>
            <td>${reservation.rentalBranch.address} </td>
            <td>${reservation.returnBranch.address} </td>
            <td>${reservation.totalPrice} </td>

            <td><a href="/deleteReservation?id=${reservation.id}">Usuń</a></td>
            <td><a href="/editReservation?id=${reservation.id}">Edytuj</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>