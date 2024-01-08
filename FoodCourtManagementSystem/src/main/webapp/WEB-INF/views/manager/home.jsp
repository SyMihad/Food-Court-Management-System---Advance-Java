<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Manager Home</title>
</head>
<body>
<div align="center">
<h1>Welcome Manager</h1>
<a href="${pageContext.request.contextPath}/manager/addFoodItem">Add Food Item</a>
<br><br>
<a href="${pageContext.request.contextPath}/manager/foodItemList">Show All Food Item</a>
<br><br>
<a href="${pageContext.request.contextPath}/manager/orderList">Show All Orders</a>
<br><br>
<a href="${pageContext.request.contextPath}/logout">Logout</a>
</div>
</body>
</html>