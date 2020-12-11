<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart</title>
</head>

<%--@elvariable id="test" type="entity.TestEntity"--%>
<c:set var="text">
    ${toy.name}
</c:set>
<body>

<div style="min-height: 100vh; padding-top: 120px">
    <form action="${pageContext.request.contextPath}/app/save-cart.html?id=${toy.id}" method="post">
        <c:forEach var="toy" items="${test.questions}" varStatus="loop">
            <div>
                <label for="toy-${toy.id}">${toy.name}</label>
                <input id="toy-${toy.id}" name="toy-${toy.id}" class="input-block">
            </div>
        </c:forEach>

        <button>ok</button>
    </form>
</div>

</body>
</html>
