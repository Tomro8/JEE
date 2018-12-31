<!DOCTYPE HTML>
<html>

<head>
    <title>Employee Details</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="./css/style.css" type="text/css" rel="stylesheet" />
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP" crossorigin="anonymous">
</head>

<body>
    <header>
        <a href="Controller?action=disconnect"><i class="fas fa-power-off"></i></a>
    </header>
    
    <div class="warpper">
        
    <c:set var="employee" scope="request" value="${requestScope.employee}"/>
    
    <c:choose>
        <%-- button add was pressed: display empty fields --%>
        <c:when test="${empty employee}">
            <form method="post">
                <h2>
                    <p>Details</p>
                </h2>

                <label for="lastName">Last Name</label>
                <input type="text" name="lastName" placeholder=" Last Name"
                       required pattern=".*\S+.*"/><br />

                <label for="firstName">First Name</label>
                <input type="text" name="firstName" placeholder=" First Name"
                       required pattern=".*\S+.*"/><br />

                <label for="homePhone">Home Phone No</label>
                <input type="tel" name="homePhone" placeholder=" Home Phone Number" /><br />

                <label for="mobilePhone">Mobile Phone No</label>
                <input type="tel" name="mobilePhone" placeholder=" Mobile Phone Number"
                       required pattern=".*\S+.*"/><br />

                <label for="proPhone">Professional Phone No</label>
                <input type="tel" name="proPhone" placeholder=" Professional Phone Number"/><br />

                <label for="address">Address</label>
                <input type="text" name="address" placeholder=" Address" 
                       required pattern=".*\S+.*"/><br />

                <label for="zipCode">Zip Code</label>
                <input type="text" name="zipCode" placeholder=" Zip Code" 
                       required pattern=".*\S+.*"/><br />

                <div class="content">

                    <label for="city">City</label>
                    <input type="text" name="city" placeholder=" City" required pattern=".*\S+.*"/>

                    <label for="email">E-mail</label>
                    <input type="text" name="email" placeholder=" E-mail Address" required pattern=".*\S+.*"/><br />

                </div>
                <div class="content">
                    <input type="submit" value="Save" formaction="Controller?action=createEmployee"/>
                    <a href="Controller?action=cancelDetails">
                        <input type="button" value="Cancel"/>
                    </a>
                </div>
            </form>
        </c:when>
        
        <%-- an employee was selected: display it's details --%>
        <c:otherwise>
            <form method="post">
                <h2>
                    <p>Details of employee: <c:out value="${employee.name}"/> <c:out value="${employee.firstName}"/></p>
                </h2>
                
                <input type="hidden" name="id" value="${employee.id}"/>

                <label for="lastName">Last Name</label>
                <input type="text" name="lastName" value="<c:out value="${employee.name}"/>"
                       required pattern=".*\S+.*"/><br />

                <label for="firstName">First Name</label>
                <input type="tel" name="firstName" value="<c:out value="${employee.firstName}"/>"
                       required pattern=".*\S+.*"/><br />

                <label for="homePhone">Home Phone No</label>
                <input type="tel" name="homePhone" value="<c:out value="${employee.telephone}"/>"/><br />

                <label for="mobilePhone">Mobile Phone No</label>
                <input type="tel" name="mobilePhone" value="<c:out value="${employee.telMob}"/>"
                       required pattern=".*\S+.*"/><br />

                <label for="proPhone">Professional Phone No</label>
                <input type="text" name="proPhone" value="<c:out value="${employee.telPro}"/>"/><br />

                <label for="address">Address</label>
                <input type="text" name="address" value="<c:out value="${employee.address}"/>"
                       required pattern=".*\S+.*"/><br />

                <label for="zipCode">Zip Code</label>
                <input type="text" name="zipCode" value="<c:out value="${employee.postalCode}"/>"
                       required pattern=".*\S+.*"/><br />

                <div class="content">

                    <label for="city">City</label>
                    <input type="text" name="city" value="<c:out value="${employee.city}"/>"
                           required pattern=".*\S+.*"/>

                    <label for="email">E-mail</label>
                    <input type="text" name="email" value="<c:out value="${employee.email}"/>" 
                           required pattern=".*\S+.*"/><br />
                    
                </div>
                <div class="content">
                    <input type="submit" value="Save" formaction="Controller?action=saveDetails"/>
                    <a href="Controller?action=cancelDetails">
                        <input type="button" value="Cancel"/>
                    </a>
                </div>
            </form>
            
        </c:otherwise>
    </c:choose>
        
    </div>
</body>

</html>
