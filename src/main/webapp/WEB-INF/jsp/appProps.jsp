<%@include file="/WEB-INF/jsp/includes/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Application Properties</title>
<link type="text/css" rel="stylesheet" href="css/main.css" />
<%-- <base href="${baseHref}" /> --%>
</head>
<body>
	<div class="bodyContent">
		<h2 class="hBlu">HelloWorld</h2>
		<a href="index">Hello World Home</a>
		<hr class="hrClass" />
		<h3 class="hBlu">Application Properties</h3>

		<table class="default">
			<tr>
				<th>Key</th>
				<th>Value</th>
			</tr>
			<tr class="odd">
				<td><strong>Application Builder</strong>:</td>
				<td><c:out value="${applicationBuilder}" /></td>
			</tr>
			<tr class="even">
				<td><strong>Application Build Date/Time</strong>:</td>
				<td><c:out value="${applicationBuildDateTime}" /></td>
			</tr>
			<tr class="odd">
				<td><strong>Application Version</strong>:</td>
				<td><c:out value="${applicationVersion}" /></td>
			</tr>
		</table>
	</div>
</body>
</html>
