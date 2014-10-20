<%@include file="/WEB-INF/jsp/includes/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Headers</title>
<link type="text/css" rel="stylesheet" href="css/main.css" />
<%-- <base href="${baseHref}" /> --%>
<script src="js/jquery-2.1.0.js" type="text/javascript"></script>
<script language="javascript" type="text/javascript" src="js/main.js"></script>
</head>
<body>
	<div id="bodyDiv" class="bodyContent">
		<div id="ctrls" class="controls">
			<h2 class="hBlu">HelloWorld</h2>
			<a href="index">Hello World Home</a>
			<hr class="hrClass" />
		</div>
		<div class="innerContent">
			<h3 class="hBlu">Headers</h3>
			<table class="default">
				<tr>
					<th>Header</th>
					<th>Value</th>
				</tr>
				<c:forEach var="headItem" items="${header}" varStatus="loop">
					<tr class="${loop.index % 2 == 0 ? 'even' : 'odd'}">
						<td><strong><c:out value="${headItem.key}" /></strong>:</td>
						<td><c:out value="${headItem.value}" /></td>
					</tr>
				</c:forEach>
			</table>

			<hr class="hrClass" />
			<h3 class="hBlu">Properties</h3>
			<table class="default">
				<tr>
					<th>Name</th>
					<th>Value</th>
				</tr>
				<tr class="odd">
					<td>Protocol</td>
					<td><%=request.getProtocol()%></td>
				</tr>
				<tr class="even">
					<td>ContentType</td>
					<td><%=request.getContentType()%></td>
				</tr>
				<tr class="odd">
					<td>RemoteAddr</td>
					<td><%=request.getRemoteAddr()%></td>
				</tr>
				<tr class="even">
					<td>RemoteHost</td>
					<td><%=request.getRemoteHost()%></td>
				</tr>
				<tr class="odd">
					<td>Scheme</td>
					<td><%=request.getScheme()%></td>
				</tr>
				<tr class="even">
					<td>ServerName</td>
					<td><%=request.getServerName()%></td>
				</tr>
				<tr class="odd">
					<td>ServerPort</td>
					<td><%=request.getServerPort()%></td>
				</tr>
			</table>

			<table class="default">
				<tr class="even">
					<th colspan="2">Http request information</th>
				</tr>
				<tr class="odd">
					<th>Name</th>
					<th>Value</th>
				</tr>
				<tr class="even">
					<td>AuthType</td>
					<td><%=request.getAuthType()%></td>
				</tr>
				<tr class="odd">
					<td>ContextPath</td>
					<td><%=request.getContextPath()%></td>
				</tr>
				<tr class="even">
					<td>Method</td>
					<td><%=request.getMethod()%></td>
				</tr>
				<tr class="odd">
					<td>PathInfo</td>
					<td><%=request.getPathInfo()%></td>
				</tr>
				<tr class="even">
					<td>PathTranslated</td>
					<td><%=request.getPathTranslated()%></td>
				</tr>
				<tr class="odd">
					<td>QueryString</td>
					<td><%=request.getQueryString()%></td>
				</tr>
				<tr class="even">
					<td>RemoteUser</td>
					<td><%=request.getRemoteUser()%></td>
				</tr>
				<tr class="odd">
					<td>RequestedSessionId</td>
					<td><%=request.getRequestedSessionId()%></td>
				</tr>
				<tr class="even">
					<td>RequestURI</td>
					<td><%=request.getRequestURI()%></td>
				</tr>
				<tr class="odd">
					<td>RequestURL</td>
					<td><%=request.getRequestURL()%></td>
				</tr>
				<tr class="even">
					<td>ServletPath</td>
					<td><%=request.getServletPath()%></td>
				</tr>
				<tr class="odd">
					<td>ServerName</td>
					<td><%=request.getServerName()%></td>
				</tr>
				<tr class="even">
					<td>ServerPort</td>
					<td><%=request.getServerPort()%></td>
				</tr>
				<tr class="odd">
					<td>ServletPath</td>
					<td><%=request.getServletPath()%></td>
				</tr>
				<tr class="even">
					<td>isRequestedSessionIdFromCookie</td>
					<td><%=request.isRequestedSessionIdFromCookie()%></td>
				</tr>
				<tr class="odd">
					<td>isRequestedSessionIdFromURL</td>
					<td><%=request.isRequestedSessionIdFromURL()%></td>
				</tr>
				<tr class="even">
					<td>isRequestedSessionIdValid</td>
					<td><%=request.isRequestedSessionIdValid()%></td>
				</tr>
				<tr class="odd">
					<td>isSecure</td>
					<td><%=request.isSecure()%></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>
