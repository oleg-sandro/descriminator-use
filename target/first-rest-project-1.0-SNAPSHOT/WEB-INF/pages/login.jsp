<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log in</title>
</head>
<body>
<h1>Log in</h1>
<div id="login-error">
    ${error}
</div>
<form action="../../j_spring_security_check" method="post">
    <label>Username:</label>
    <input id="j_username" type="text" name="j_username" required>
    <br><br>
    <label>Password:</label>
    <input id="j_password" type="password" name="j_password" required>
    <br><br>
    <input type="submit" value="login">
    &nbsp;&nbsp;&nbsp;&nbsp;
    <a href="/reg">register</a>
</form>
</body>
</html>