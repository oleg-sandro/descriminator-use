<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<h1>Do you want to sign up?</h1>
<form action="/signup" method="post">
    <table>
        <tr><td>Username:</td><td><input type="text" name="username" required></td></tr>
        <tr><td>Password:</td><td><input type="password" name="password" required></td></tr>
        <tr><td>Email:</td><td><input type="text" name="email" required></td></tr>
        <tr><td>&nbsp;</td></tr>
        <tr><td></td><td><input type="submit" value="Sign Up"></td></tr>
    </table>
</form>
&nbsp;&nbsp;
<a href="/index">Back to home page</a>
&nbsp;&nbsp;
<a href="/login">Sign in</a>
</body>
</html>