<%@include file="/WEB-INF/jsp/includes/header.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Echo</title>
<link type="text/css" rel="stylesheet" href="css/main.css" />
<base href="${baseHref}" />
</head>
<body>
	<div id="bodyDiv" class="bodyContent">
		<h2 class="hBlu">HelloWorld</h2>
		<a href="index">Hello World Home</a>
		<hr class="hrClass" />
		<h3 class="hBlu">Echo...</h3>
		${echo}
	</div>
</body>
</html>