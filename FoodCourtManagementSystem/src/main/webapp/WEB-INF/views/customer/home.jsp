<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Manager Customer</title>
</head>
<body>
<div align="center">
<h1>Welcome Customer</h1>
<a href="${pageContext.request.contextPath}/customer/restaurantList">Place An Order</a>
<br><br>
<a href="${pageContext.request.contextPath}/customer/showProfile">Show Profile</a>
<br><br>
<a href="${pageContext.request.contextPath}/customer/editProfile">Edit Profile</a>
<br><br>
<a href="${pageContext.request.contextPath}/customer/viewOrders">View Orders</a>
<br><br>
<a href="${pageContext.request.contextPath}/logout">Logout</a>
</div>
</body>
</html>