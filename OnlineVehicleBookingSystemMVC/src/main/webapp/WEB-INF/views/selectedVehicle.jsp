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
    <form action="/BookingStatus" method="get">
<table>
<tr>  
<td></td>
<td>vehicleId</td>              
<td>Colour</td>
<td>ManufacturerName </td>    
<td>price</td>
</tr>            
<tr>
<td><input type="hidden" name="loginId" value="${str }"></td>
<td><input type="hidden" name="vehicleId" value="${oneVehicle.vehicleId}" name="vehicleId" /> ${oneVehicle.vehicleId}</td>
<td><input type="hidden" name="color" value="${oneVehicle.color}"> ${oneVehicle.color}</td>
<td><input type="hidden" name="manufacturerName" value="${oneVehicle.manufacturerName}"> ${oneVehicle.manufacturerName}</td>
<td><input type="hidden" name="showroomPrice" value="${oneVehicle.showroomPrice}">${oneVehicle.showroomPrice}</td>
</tr>
<tr>
<td></td><td></td><td></td><td> <input type="submit" value="book" /></td>
</tr>
</table>
</form>
</div>
</div>
</jsp:attribute>
</mp:CustomerMaster>