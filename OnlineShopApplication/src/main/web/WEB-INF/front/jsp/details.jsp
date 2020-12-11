<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Details page</title>
</head>
<body>

<c:set var="text">
    ${toy.name}
</c:set>

<div style="min-height: 100vh; padding-top: 120px">
    <ul>
        <c:forEach var="toy" items="${toy.id}" varStatus="loop">
            <li>
                    ${toy.name}
            </li>
        </c:forEach>
    </ul>
</div>

</body>
</html>
