<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>
    <div>
        <form action="/logout" method="post">
            <input type="submit" value="Log out" />
        </form>
    </div>
    <div><h2>Hello, user!</h2></div>
    <a href="/index">go to Home page...</a>
</body>
</html>
