<!DOCTYPE HTML>
<html>

<head>
    <title>Employee List</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="./css/style.css" type="text/css" rel="stylesheet" />
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP" crossorigin="anonymous">
</head>

<body>
    <header>
        <a href="Controller?action=disconnect"><i class="fas fa-power-off"></i></a>
        <c:if test="${!empty sessionScope.user}">
            <span>Your session is active</span>
        </c:if>
    </header>
    <div class="warpper">
        <h2>List of Employee</h2>
        <form method="post">
            
            <c:choose>
                <c:when test="${empty employeesList}">
                    <b>The club has no member!</b>
                    <br />
                </c:when>
                <c:otherwise>
                    <table>
                        <tr>
                            <td>Sel</td>
                            <td>Name</td>
                            <td>First name</td>
                            <td>Home phone</td>
                            <td>Mobile phone</td>
                            <td>Work phone</td>
                            <td>Address</td>
                            <td>Postal Code</td>
                            <td>City</td>
                            <td>Email</td>
                        </tr>

                        <c:forEach items="${employeesList}" var= "emp" >
                            <tr>
                                <td><input type="radio" name="selector" value="${emp.id}"/></td>
                                <td><c:out value="${emp.name}"/></td>
                                <td><c:out value="${emp.firstName}"/></td>
                                <td><c:out value="${emp.telephone}"/></td>
                                <td><c:out value="${emp.telMob}"/></td>
                                <td><c:out value="${emp.telPro}"/></td>
                                <td><c:out value="${emp.address}"/></td>
                                <td><c:out value="${emp.postalCode}"/></td>
                                <td><c:out value="${emp.city}"/></td>
                                <td><c:out value="${emp.email}"/></td>
                            </tr>
                        </c:forEach>

                    </table>

                    <input type="submit" value="Delete" name="delete" formaction="Controller?action=listDeleteBtn"/>
                    <input type="submit" value="Details" name="details" formaction="Controller?action=listDetailsBtn"/>
                </c:otherwise>
            </c:choose>

            <input type="submit" value="Add" name="add" formaction="Controller?action=listAddBtn"/>  
        </form>
    </div>
</body>

</html>
