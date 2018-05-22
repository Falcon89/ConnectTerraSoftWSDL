<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>


<c:if test="${product != null}">
    <h3> ${product.name} </h3>
    <h3> ${product.index} </h3>
</c:if>

</body>

</html>