<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>$Title$</title>
</head>
<body>

<h1>Lista oddziałów dla wypożyczalni</h1>

<a href="/addBranch">Add new office</a>
<table>
    <tr>
        <th>Adres</th>
        <th>Lista pracowników</th>
        <th></th>
        <th></th>
    </tr>

    <c:forEach var="branch" items="${branchesList}">
        <tr>
            <td>${branch.address}</td>
            <td><a href="/getAllEmployees?id=${branch.id}">Sprawdź</a></td>
            <td><a href="/deleteBranch?id=${branch.id}">Usuń</a></td>
            <td><a href="/editBranch?id=${branch.id}">Edytuj</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>