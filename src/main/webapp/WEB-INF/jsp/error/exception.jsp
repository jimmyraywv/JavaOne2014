<!DOCTYPE html>
<%@include file="/WEB-INF/jsp/includes/header.jsp" %>

<html>
<head>
<title>${errorTitle}</title>
<link type="text/css" rel="stylesheet" href="css/main.css" />
<base href="${baseHref}" />
</head>
<body>
	<h3 class="hBlu">
		<img src="img/error_blu.gif">&nbsp;&nbsp;${errorTitle}
	</h3>
	<div class="page-content">
		<p>${errorMsg}</p>
	</div>
	<a href="index">Hello World Home</a>
</body>
</html>