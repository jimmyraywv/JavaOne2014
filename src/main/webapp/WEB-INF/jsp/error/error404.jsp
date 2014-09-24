<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
<title>404 Error</title>
<link type="text/css" rel="stylesheet" href="css/main.css" />

<c:set var="req" value="${pageContext.request}" />
</head>
<body>
	<h3 class="hBlu">
		<img src="img/error_blu.gif">&nbsp;&nbsp;The requested URL [${req.requestURI}] was not
		found on this server.
	</h3>
</body>
</html>