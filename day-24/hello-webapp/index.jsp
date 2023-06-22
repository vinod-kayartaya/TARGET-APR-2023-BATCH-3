<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hello, JSP!</title>
</head>
<body>
    <h1>Hello, JSP!</h1>
    <hr>
    <h2>This is a java based webapp</h2>
    <%
        String message = "Welcome to Web applications";
        for(int i=0; i<=6; i++){
            out.println("<h%d>%s</h%d>".formatted(i, message, i));
        }
    %>
</body>
</html>