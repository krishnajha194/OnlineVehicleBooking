<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="mp" tagdir="/WEB-INF/tags"%>
<mp:Master title="profile Page">
	<jsp:attribute name="header"></jsp:attribute>
	<jsp:attribute name="content">
<div style="display: flex;">
	<div >
<form action="/addVehicle" method="post">
<table>
<tr><td></td><td><input type="text" name="loginId" value="${str}"></td></tr>
<tr>
<td>Enter vehicleId</td>
							<td><input type="text" name="vehicleId"></td>
</tr>
<tr>
<td>Enter manufacturerName</td>
							<td><input type="text" name="manufacturerName"></td>
</tr>
<tr>
<td>Enter showroomPrice</td>
							<td><input type="text" name="showroomPrice"></td>
</tr>
<tr>
<td>Enter color</td>
							<td><input type="text" name="color"></td>
</tr>
<tr>
<td></td>
							<td><input type="hidden" name="status" value="Pending"></td>
</tr>
<tr>
<td></td>
							<td><button>submit</button></td>
</tr>
</table>
</form>
</div>
<div style="margin-left: 100px;">
<table>
<c:forEach var="listOfVehicle" items="${allvehicle}">

<c:set var="id" value="${str }"></c:set>
<c:set var="loginId" value="${listOfVehicle.loginId}"></c:set>
<c:if test="${id==loginId}">

<tr>
<td>vehicleId</td>
							<td>${listOfVehicle.vehicleId }</td>
</tr>
<tr>
<td>manufacturerName</td>
							<td>${listOfVehicle.manufacturerName }</td>
</tr>
<tr>
<td>showroomPrice</td>
							<td>${listOfVehicle.showroomPrice }</td>
</tr>
<tr>
<td>color</td>
							<td>${listOfVehicle.color }</td>
</tr>
<tr>
<td>status</td>
							<td>${listOfVehicle.status }</td>
</tr>
<tr><td><br><br></td>
</tr>
</c:if>
</c:forEach>
</table>
</div>
</div>


</jsp:attribute>
</mp:Master>