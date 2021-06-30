<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>New Account</title>
</head>
<body>
<form:form method="POST" action="newAccount" modelAttribute="new-book-form">
    Id:<form:input type="text" path="id" id="id"/>
    Name:<form:input type="text" path="name" id="name"/>
    Balance:<form:input type="text" path="balance" id="balance"/>
    <input type="submit" value="Save"/>
</form:form>

</body>
</html>
