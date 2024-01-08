<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>All Admins</title>
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
    <c:forEach items="${admins}" var="admin">
        <tr>
            <c:url var="updateLink" value="/admin/edit-admin">
                <c:param name="adminId" value="${admin.id}" />
            </c:url>
            <c:url var="deleteLink" value="/admin/delete-admin">
                <c:param name="adminId" value="${admin.id}" />
            </c:url>
            <td>${admin.id}</td>
            <td>${admin.user.firstName}</td>
            <td>${admin.user.lastName}</td>
            <td>${admin.user.username}</td>
            <td>${admin.user.createdOn}</td>
            <td>${admin.user.email}</td>
            <td>${admin.nidNo}</td>
            <td><a href="${updateLink}">Update</a> | <a href="${deleteLink}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<br><br>

<input type="button" value="Add Admin" onclick="window.location.href='create-admin';return false;">
<input type="button" value="Home" onclick="window.location.href='home';return false;">

</body>
</html>
