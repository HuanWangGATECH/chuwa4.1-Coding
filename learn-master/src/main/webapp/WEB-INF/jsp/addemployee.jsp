<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Employee</title>
</head>
<body>

<c:url var="add_employee" value="addEmployee"/>
<form:form action="${add_employee}" method="post" modelAttribute="employee">
    <form:label path="firstName">First Name: </form:label> <form:input type="text" path="firstName"/><br/><br/>
    <form:label path="lastNme">Last Name: </form:label> <form:input type="text" path="lastNme"/><br/><br/>
    <form:label path="email">email: </form:label> <form:input path="email"/><br/><br/>
    <form:label path="password">password: </form:label> <form:input path="password"/><br/><br/>

    <input type="submit" value="submit"/>
</form:form>
</body>
</html>