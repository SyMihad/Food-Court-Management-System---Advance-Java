<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>All Managers</title>
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
        <th>NID</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${managers}" var="manager">
        <tr>
            <c:url var="updateLink" value="/admin/edit-manager">
                <c:param name="managerId" value="${manager.id}" />
            </c:url>
            <td>${manager.id}</td>
            <td>${manager.user.firstName}</td>
            <td>${manager.user.lastName}</td>
            <td>${manager.user.username}</td>
            <td>${manager.user.createdOn}</td>
            <td>${manager.user.email}</td>
            <td>${manager.nidNo}</td>
            <td><a href="${updateLink}">Update</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<br><br>

<input type="button" value="Add Manager" onclick="window.location.href='create-RestaurantManager';return false;">
<input type="button" value="Home" onclick="window.location.href='home';return false;">

</body>
</html>
