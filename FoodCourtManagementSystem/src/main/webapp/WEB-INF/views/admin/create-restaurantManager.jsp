<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Register</title>
</head>
<body>

<div align='center'>

<h1>Register</h1>

<form:form action="store-restaurantManager" modelAttribute="restaurantManagerDto">

    <label for="firstName">First Name:</label>
    <form:input path="firstName" id="firstName"/>
    <form:errors path="firstName"/>

    <br><br>

    <label for="lastName">Last Name:</label>
    <form:input path="lastName" id="lastName"/>
    <form:errors path="lastName"/>

    <br><br>

    <label for="userName">User Name:</label>
    <form:input path="username" id="userName"/>
    <form:errors path="username"/>

    <br><br>

    <label for="email">Email:</label>
    <form:input type="email" path="email" id="email"/>
    <form:errors path="email"/>

    <br><br>

    <label for="gender">Gender:</label>
    <form:radiobutton path="gender" id="gender" value="MALE"/>MALE
    <form:radiobutton path="gender" id="gender" value="FEMALE"/>FEMALE
    <form:errors path="gender"/>

    <br><br>

    <label for="nidNo">NID No:</label>
    <form:input type="number" path="nidNo" id="nidNo"/>
    <form:errors path="nidNo"/>

    <br><br>

    <label for="password">Password:</label>
    <form:input type="password" path="password" id="password"/>
    <form:errors path="password"/>

    <br><br>

    <label for="restaurantName">Restaurant Name:</label>
    <form:input path="restaurantName" id="restaurantName"/>
    <form:errors path="restaurantName"/>

    <br><br>


<input type="submit">

</form:form>
</div>

</body>
</html>