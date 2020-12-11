<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add toys</title>
</head>
<body>
<div style="min-height: 100vh; padding-top: 100px">
    <form action="${pageContext.request.contextPath}/app/save-test.html" method="post">

        <h3>toy: </h3>
        <div id="toy">
            <div >
                <div style="margin-left: 0">
                    <input id="name-1" name="name-1">
                    <input id="price-1" name="price-1">
                </div>
            </div>
        </div>

        <input type="button" onclick="onAddToy()"
               value="addToy">
        <input type="submit" class="col-12 paper-btn btn-block btn-success-outline" value="save">
    </form>
</div>

<script>
    let toyNumber = 2;
    const toys = document.querySelector("#toys");

    const createToyFormGroup = () => {
        const formGroup = document.createElement("div");
        formGroup.className = "row form-group";
        formGroup.innerHTML =
            `
                <div style="margin-left: 0">
                    <input id="name-` + toyNumber + `" name="toy-` + toyNumber + `>
                    <input id="price-` + toyNumber + `" name="price-` + toyNumber + `>
                </div>

                <div class="col-2">
                    <input class="input-block" type="button" onclick="onRemoveToyGroup(` + toyNumber + `)" value="remove">
                </div>
            `;
        formGroup.setAttribute("data-toy-number", toyNumber);

        toys.appendChild(formGroup);
        toyNumber += 1;
    }

    const onAddToy = () => {
        createToyFormGroup();
    }

    const onRemoveToyGroup = (number) => {
        const nodeToRemove = Array.from(toys.children).find(q => q.dataset.toyNumber === number.toString());
        toys.removeChild(nodeToRemove);
    }
</script>


</body>
</html>
