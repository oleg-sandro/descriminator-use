<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h1>Do you want to sign in?</h1>
    <form action="/signin" method="post">
        <div><label> Username: <input type="text" name="username" required></label></div>
        <div><label> Password: <input type="password" name="password" required></label></div>
        <div><input type="submit" value="Sign In"></div>
    </form>
    &nbsp;&nbsp;
    <a href="/index">Back to home page</a>
    &nbsp;&nbsp;
    <a href="/signup">Sign up</a>
</body>
</html>