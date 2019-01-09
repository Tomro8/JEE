<!DOCTYPE HTML>
<html>

<head>
    <title>Login Page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="./css/style.css" type="text/css" rel="stylesheet" />
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP" crossorigin="anonymous">
</head>

<body>
    <header>
        
    </header>
    <p class="error_message"><c:out value="${requestScope.err}" /></p>
    <form class="login_form" method="post" action="Controller?action=login">
        <h2>
            <p>Login</p>
        </h2>
        <input type="text" name="login" placeholder=" Login" /><br />
        <input type="password" name="password" placeholder=" Password" /><br />
        <input type="submit" value="Login" />
    </form>
</body>

</html>
