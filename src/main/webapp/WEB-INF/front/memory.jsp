<%--
  @author Roma.Hrupskyi
  @date: 31.08.2017
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>memory</title>
</head>
<body>
<div class="container">
    <div class="alert " role="alert" style=" background-color:rgba(234, 234, 234, 0.93); margin-top: 50px; ">
        <h3 style="text-align: center;">Size of heap memory</h3>
        <br/>
        <br/>
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

        <p>Click on the button to see in JSON format.</p>
        <br/>
        <button type="button" class="btn btn-light btn-small" data-toggle="collapse" data-target="#demo"
                onclick="doPostRequest()">JSON
        </button>
        <br/>
        <div>
            <div id="demo" class="collapse blockquote ">
                <br/>
                <p class="mb-0" id="log"></p>
            </div>
        </div>
        <br/>
        <br/>
        <div>
            <a type="button" class="btn btn-light" href="<spring:url value='/'/>">Return</a>
        </div>
    </div>
</div>
<script>
    function doPostRequest() {
       var cuurentUrl = window.location.pathname;
       var methodType;
        if(window.location.href.indexOf("fill") > -1){
            methodType="POST";
        }else {
            methodType="GET";
        }
        var request = $.ajax({
            url: cuurentUrl,
            method: methodType,
            headers: {'accept': 'application/json'}
        });

        request.done(function (msg) {
            $("#log").html(JSON.stringify(msg));
        });

        request.fail(function (jqXHR, textStatus) {
            alert("Request failed: " + textStatus);
        });
    }
</script>


</body>
</html>

