<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Food Court</title>
</head>
<body>
    <div align = 'center'>
        <h1>Welcome to Food Court Management System</h1>
        <a href="${pageContext.request.contextPath}/home">
            <button type="button" style="font-size:20px;">Login</button>
        </a>
        <p style="color:red">Don't Have an Account?</p><a href="${pageContext.request.contextPath}/signup">Register Here</a>
    </div>
</body>
</html>
