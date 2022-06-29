<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ attribute name="title" required="true" rtexprvalue="true"%>
<%@ attribute name="header"%>
<%@ attribute name="content" fragment="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${title}</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/styles/MenuBar.css">
</head>
<body style="overflow:hidden;">
	<div
		style="position: absolute; top: 0px; left: 0px; height: 10%; width: 100%">
		<img
			src="${pageContext.request.contextPath}/resources/images/logo.png"
			style="width: 100%; height: 100%;">
	</div>
	<div
		style="position: absolute; top: 80px; left: 0px; height: 10%; width: 100%">
		<ul>
			<li><a href="profile">Profile</a></li>
			<li><a href="vehicle">Vehicle Stock</a></li>
			<li><a href="Booking">Booking</a></li>
			<li style="float: right"><a class="active" href="logout">Log Out</a></li>
		</ul>
	</div>
	<div
		style="position: absolute; top: 25%; left: 20%; width: 100%; height: 100%">
		<jsp:invoke fragment="content"></jsp:invoke>
	</div>
</body>
</html>