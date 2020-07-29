<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>$Title$</title>
</head>
<body>

<h1>Lista wypożyczalni</h1>

<a href="/addRentalOffice">Add new office</a>
<table>
    <tr>
        <th>Nazwa</th>
        <th>Strona internetowa</th>
        <th>Adres</th>
        <th>Właściciel</th>
        <th>Logotyp</th>
        <th>Lista oddziałów</th>
        <th></th>
        <th></th>
    </tr>

    <c:forEach var="office" items="${officesList}">
        <tr>
            <td>${office.name}</td>
            <td>${office.webPage}</td>
            <td>${office.address}</td>
            <td>${office.owner}</td>
            <td>${office.logotype}</td>
            <td><a href="/getAllBranches?id=${office.id}">Sprawdź</a></td>
            <td><a href="/deleteOffice?id=${office.id}">Usuń</a></td>
            <td><a href="/editOffice?id=${office.id}">Edytuj</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>