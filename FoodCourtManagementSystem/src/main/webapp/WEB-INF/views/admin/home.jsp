<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Admin Home</title>
</head>
<body>
<div align="center">
<h1>Welcome Admin</h1>
<a href="${pageContext.request.contextPath}/admin/create-admin">Create Admin</a>
<br><br>
<a href="${pageContext.request.contextPath}/admin/create-RestaurantManager">Create A Restaurant with Manager</a>
<br><br>
<a href="${pageContext.request.contextPath}/admin/admin-list">Show All Admin</a>
<br><br>
<a href="${pageContext.request.contextPath}/admin/manager-list">Show All Manager</a>
<br><br>
<a href="${pageContext.request.contextPath}/admin/customer-list">Show All Customer</a>
<br><br>
<a href="${pageContext.request.contextPath}/admin/restaurant-list">Show All Restaurant with Food Items</a>
<br><br>
<a href="${pageContext.request.contextPath}/logout">Logout</a>
</div>
</body>
</html>