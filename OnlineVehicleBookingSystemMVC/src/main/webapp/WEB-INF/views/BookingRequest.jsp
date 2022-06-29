<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="mp" tagdir="/WEB-INF/tags"%>
<mp:AdminMaster title="Admin Page">
	<jsp:attribute name="header">
	
	</jsp:attribute>
	<jsp:attribute name="content">
	<form action="/newVehicleStatusUpdate" method="post">
	<table>

	<tr>
	<td>Received From </td>
	<td>vehicleId</td>
	<td>manufacturerName</td>
	<td>showroomPrice</td>
	<td>color</td>
	<td>status</td>
	</tr>
	<c:forEach var="r" items="${allvehicle}">
 <tr>
	<td><input type="checkbox" name="vehicleId" value="${r.vehicleId}"> ${r.vehicleId}</td>
<%-- 	<td><input type="hidden" name="vehicleId" value=" ${r.vehicleId}"> ${r.vehicleId}</td> --%>	
	<td><input type="hidden" name="manufacturerName" value="${r.manufacturerName}"> ${r.manufacturerName}</td>
	<td><input type="hidden" name="showroomPrice" value="${r.showroomPrice}"> ${r.showroomPrice}</td>
	<td><input type="hidden" name="color" value=" ${r.color}"> ${r.color}</td>
	<td>
	<select name="status">
		<option value="Select">${r.status}</option>
		<option value="Pending">Pending</option>
		<option value="Approved">Approved</option>
	</select>
	</td>
	
 <td><button>Submit</button></td>
 </tr>
	</c:forEach>
	</table>
	</form>
</jsp:attribute>
</mp:AdminMaster>