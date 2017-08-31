<%--
  @author Roma.Hrupskyi
  @date: 31.08.2017
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
          integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <title>memory</title>
</head>
<body>
<div class="container">
    <div class="alert alert-dark " style=" margin-top: 50px; ">
        <h3 style="text-align: center;">Size of heap memory</h3>
        <br/>
        <br/>
        <div >
            <ol>
                <li>
                    <p>heap size: <c:out value="${heapSize/1000000}"/> MB</p>
                </li>

                <li>
                    <p>heap max size: <c:out value="${heaapMaxSize/1000000}"/> MB</p>
                </li>

                <li>
                    <p>heap free size: <c:out value="${heapFreeSize/1000000}"/>MB</p>
                </li>
            </ol>
        </div>
        <br/>
        <br/>
        <a class="btn btn-light" href="<spring:url value='/'/>">Return</a>
    </div>
</div>


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
        integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
        integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
        crossorigin="anonymous"></script>
</body>
</html>
l>
