<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>All Customers</title>
</head>
<body>

<table border="1">
    <thead>
    <tr>
        <th>Id</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>User Name</th>
        <th>Created On</th>
        <th>Email</th>
        <th>Phone No</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${customers}" var="customer">
        <tr>
            <td>${customer.id}</td>
            <td>${customer.user.firstName}</td>
            <td>${customer.user.lastName}</td>
            <td>${customer.user.username}</td>
            <td>${customer.user.createdOn}</td>
            <td>${customer.user.email}</td>
            <td>${customer.phoneNo}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<br><br>

<input type="button" value="Home" onclick="window.location.href='home';return false;">

</body>
</html>
