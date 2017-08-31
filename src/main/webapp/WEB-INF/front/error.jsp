<%--
  @author Roman.Grupskyi
  @date: 25.08.2017
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Error page</title>
</head>
<body>
<div class="container">
    <div class="alert alert-danger " style="text-align: center; margin-top: 50px; ">
        <h3>EROOR!</h3>
        <br/>
        <p><c:out value="${error}"/></p>
        <br/>
        <br/>
        <p>Click on the button to see error in JSON format .</p>
        <br/>
        <button type="button" class="btn btn-light" data-toggle="collapse" data-target="#demo" onclick="doPostRequest()">JSON
        </button>
        <div id="demo" class="collapse ">
          <c:out value="${error}"/>
        </div>
        <br/>
        <br/>
        <a class="btn btn-light" href="<spring:url value='/'/>">Return</a>
    </div>

</div>
<script>
   function doPostRequest() {

   }
</script>
</body>
</html>
