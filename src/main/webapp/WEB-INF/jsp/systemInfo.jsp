<%@include file="/WEB-INF/jsp/includes/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>System Info</title>
<link type="text/css" rel="stylesheet" href="css/main.css" />
<%-- <base href="${baseHref}" /> --%>
<SCRIPT src="js/jquery-2.1.0.js" type="text/javascript"></SCRIPT>
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
			<h3 class="hBlu">JVM Arguments</h3>
			<table class="default">
				<tr>
					<th>JVM Arguments</th>
				</tr>
				<c:forEach var="jvmArg" items="${jvmArgs}" varStatus="loop">
					<tr class="${loop.index % 2 == 0 ? 'even' : 'odd'}">
						<td><c:out value="${jvmArg}" /></td>
					</tr>
				</c:forEach>
			</table>

			<hr class="hrClass" />
			<h3 class="hBlu">System Properties</h3>
			<table class="default">
				<tr>
					<th>System Property</th>
					<th>Value</th>
				</tr>
				<c:forEach var="property" items="${systemProperties}"
					varStatus="loop">
					<tr class="${loop.index % 2 == 0 ? 'even' : 'odd'}">
						<td><strong><c:out value="${property.key}" /></strong>:</td>
						<td><div class="cellScroller">
								<c:out value="${property.value}" />
							</div></td>
					</tr>
				</c:forEach>
			</table>

			<hr class="hrClass" />
			<h3 class="hBlu">Other System Properties</h3>
			<table class="default">
				<tr>
					<th>Property</th>
					<th>Value</th>
				</tr>
				<c:forEach var="property" items="${otherProperties}"
					varStatus="loop">
					<tr class="${loop.index % 2 == 0 ? 'even' : 'odd'}">
						<td><strong><c:out value="${property.key}" /></strong>:</td>
						<td><div class="cellScroller">
								<c:out value="${property.value}" />
							</div></td>
					</tr>
				</c:forEach>
			</table>

			<hr class="hrClass" />
			<h3 class="hBlu">Container Properties</h3>
			<table class="default">
				<tr>
					<th>Property</th>
					<th>Value</th>
				</tr>
				<tr class="odd">
				<td><strong>Server Version</strong>:</td>
				<td><%= application.getServerInfo() %></td>
				</tr>
				<tr class="even">
				<td><strong>Servlet Version</strong>:</td>
				<td><%= application.getMajorVersion() %>.<%= application.getMinorVersion() %></td>
				</tr>
				<tr class="even">
				<td><strong>JSP Version</strong>:</td>
				<td><%= JspFactory.getDefaultFactory().getEngineInfo().getSpecificationVersion() %></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>
