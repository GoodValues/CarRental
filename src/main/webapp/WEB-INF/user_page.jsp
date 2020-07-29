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
<title>User Page</title>
</head>
<body>
Witaj ${usr.firstName} <a href="/logout" class="btn btn-warning">Logout</a>

<br>
Wybierz oddzia?, z którego chcesz wypo?yczy? samochód:
<form action="/getCarsForBranch" method="post">
<select name="branch">
	<c:forEach items="${branches}" var="branch">
		<option value="${branch.address}">${branch.address}</option>
	</c:forEach>
</select>
<input type="submit" value="Submit">
</form>
	
</body>
</html>