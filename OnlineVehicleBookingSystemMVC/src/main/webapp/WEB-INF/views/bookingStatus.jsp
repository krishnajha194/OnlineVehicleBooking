<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="mp" tagdir="/WEB-INF/tags"%>
<mp:CustomerMaster title="profile Page">
	<jsp:attribute name="header"></jsp:attribute>
	<jsp:attribute name="content">
	
<div>
<table>
	<tr>
	<td>loginId</td>
	<td>manufacturerName</td>
	<td>vehicleId</td>
	<td>color</td>
	<td>showroomPrice</td>
	</tr>
	
	<c:forEach var="r" items="${AllBookingStatus}">
	
 <tr>
	<td>${r.loginId}</td>
	<td> ${r.manufacturerName}</td>
	<td> ${r.vehicleId}</td>
	<td>${r.color}</td>
	<td> ${r.showroomPrice}</td>
	
 </tr>
	</c:forEach>
	</table>

</div>
</jsp:attribute>
</mp:CustomerMaster>