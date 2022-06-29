<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="mp" tagdir="/WEB-INF/tags"%>
<mp:CustomerMaster title="profile Page">
	<jsp:attribute name="header"></jsp:attribute>
	<jsp:attribute name="content">
<div style="display: flex;">
    <div>
    <form action="selectedVehicle" method="get">
<table>
<tr>  
<td>vehicleId</td>              
<td>Colour</td>
<td>ManufacturerName </td>    
<td>price</td>
</tr>            
<c:forEach var="u" items="${veh1}">
<tr>
<td> <input type="radio" value="${u.vehicleId}" name="vehicleId" /> ${u.vehicleId}</td>
<td>${u.color}</td>
<td>${u.manufacturerName}</td>
<td>${u.showroomPrice}</td>
</tr>
</c:forEach>
<tr>
<td> <input type="submit" value="book" /></td>
</tr>
</table>
</form>
</div>
</div>
</jsp:attribute>
</mp:CustomerMaster>