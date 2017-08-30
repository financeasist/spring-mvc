<%--
  @author Roman.Grupskyi
  @date: 25.08.2017
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
          integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <title>Title</title>
</head>
<body>
<div class="container">
    <div class="alert alert-danger " style="text-align: center; margin-top: 50px; ">
        <h3>EROOR!</h3>
        <br/>
        <p><c:out value="${error}"/></p>
    </div>
</div>
</body>
</html>
