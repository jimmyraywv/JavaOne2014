<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@include file="/WEB-INF/jsp/includes/header.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>CloudBees Hello World</title>
<link type="text/css" rel="stylesheet" href="css/main.css" />

<base href="${baseHref}" />
</head>
<body>
	<div class="bodyContent">
		<h2 class="hBlu">HelloWorld</h2>
		<hr class="hrClass" />
		<a href="headers">Headers</a> <br /> <a href="system.do">System
			Info</a> <br /> <a href="appProps.do">Application Properties</a> <br />
		<a href="echo.do?echo=Test%20the%20echo">Echo</a> <br /> <a
			href="remember.do">Session Memory</a> <br /> <a
			href="rest/responder/asdsadasdasdsad">REST Responder</a> <br /> <a
			href="rest/magic8Ball/ask/Will%20I%20get%20the%20job">REST Magic
			8 Ball</a> <br /> <a href="throw.do">Throw</a><br/>
			<a href="8BallOps">8 Ball Web Socket</a>
	</div>
</body>
</html>