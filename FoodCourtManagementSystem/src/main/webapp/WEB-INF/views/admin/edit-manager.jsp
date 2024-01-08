<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit Manager</title>
</head>
<body>

<div align='center'>

<h1>Register</h1>

<form:form action="update-manager" modelAttribute="manager">

    <label for="userId">User Id:</label>
    <form:input path="user.id" id="userId" readonly="true"/>
    <form:errors path="user.id"/>

    <br><br>

    <label for="adminId">Admin Id:</label>
    <form:input path="id" id="adminId" readonly="true"/>
    <form:errors path="id"/>

    <br><br>


    <label for="firstName">First Name:</label>
    <form:input path="user.firstName" id="firstName"/>
    <form:errors path="user.firstName"/>

    <br><br>

    <label for="lastName">Last Name:</label>
    <form:input path="user.lastName" id="lastName"/>
    <form:errors path="user.lastName"/>

    <br><br>

    <label for="userName">User Name:</label>
    <form:input path="user.username" id="userName"/>
    <form:errors path="user.username"/>

    <br><br>

    <label for="password">Password:</label>
    <form:input path="user.password" id="password"/>
    <form:errors path="user.password"/>

    <br><br>

    <label for="enabled">Enabled:</label>
    <form:input path="user.enabled" id="enabled"/>
    <form:errors path="user.enabled"/>

    <br><br>

    <label for="createdOn">Created On:</label>
    <form:input path="user.createdOn" id="createdOn"/>
    <form:errors path="user.createdOn"/>

    <br><br>

    <label for="email">Email:</label>
    <form:input type="email" path="user.email" id="email"/>
    <form:errors path="user.email"/>

    <br><br>

    <label for="gender">Gender:</label>
    <form:radiobutton path="user.gender" id="gender" value="MALE"/>MALE
    <form:radiobutton path="user.gender" id="gender" value="FEMALE"/>FEMALE
    <form:errors path="user.gender"/>

    <br><br>

    <label for="nidNo">NID No:</label>
    <form:input type="number" path="nidNo" id="nidNo"/>
    <form:errors path="nidNo"/>

    <br><br>


<input type="submit">

</form:form>
</div>

</body>
</html>