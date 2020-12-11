<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<div style="min-height: 100vh; padding-top: 120px">

    <table>
        <thead>
        <tr>
            <th style="width: 10%">#</th>
            <th style="width: 65%">toyLink</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="toy" items="${toys}" varStatus="loop">
            <tr>
                <td style="vertical-align: baseline">${loop.index + 1}</td>
                <td style="vertical-align: baseline">
                    <a href="${pageContext.request.contextPath}/app/details.html?id=${toy.id}">
                            ${toy.name}
                    </a>
                </td>
                <td style="vertical-align: baseline">
                    <a href="${pageContext.request.contextPath}/app/cart.html?id=${cart.id}">
                        cart
                    </a>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>

</body>
</html>
