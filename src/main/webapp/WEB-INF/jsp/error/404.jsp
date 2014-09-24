<!DOCTYPE html>
<%@include file="/WEB-INF/jsp/includes/header.jsp" %>

<html>
<head>
<title>${error404Title}</title>
<link type="text/css" rel="stylesheet" href="css/main.css" />
<base href="${baseHref}" />
</head>
<body>
	<h3 class="hBlu">
		<img src="img/error_blu.gif">&nbsp;&nbsp;${error404Title}
	</h3>
	<div class="page-content">
		<p>${error404Msg}</p>
	</div>
	<a href="index">Hello World Home</a>
</body>
</html>