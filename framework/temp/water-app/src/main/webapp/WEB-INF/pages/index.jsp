<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE HTML PUBLIC "-//IETF//DTD LEVEL1//EN">
<!DOCTYPE html>
<html lang="en" data-ng-app="app">
<head>
    <meta charset="utf-8"/>
    <title>Temp</title>
    <meta name="description" content=""/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"/>
    <link rel="stylesheet" href="${ctx}/css/app.min.css" type="text/css"/>
</head>
<body ng-controller="AppCtrl">
<input id="_ctx" type="hidden" value="asdfasdf_ctx"/>

<!-- toaster directive -->
<toaster-container toaster-options="{'position-class': 'toast-top-right', 'close-button':true}"></toaster-container>

<div class="app" id="app"
     ui-view>
</div>
<!-- jQuery -->
<script src="${ctx}/js/app.min.js"></script>
<!-- Lazy loading -->
</body>
</html>