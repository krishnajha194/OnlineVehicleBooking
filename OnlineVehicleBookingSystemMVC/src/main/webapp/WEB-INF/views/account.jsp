<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="mp" tagdir="/WEB-INF/tags"%>
<mp:AdminMaster title="Admin Page">
	<jsp:attribute name="header">
	
	</jsp:attribute>
	<jsp:attribute name="content">
	<form action="/newAccountStatusUpdate" method="post">
	<table>

	<tr>
	<td>USERID</td>
	<td>PASSWORD</td>
	<td>ROLE</td>
	<td>STATUS</td>
	</tr>
	
	<c:forEach var="r" items="${reg}">
 <tr>
	<td><input type="checkbox" name="userId" value="${r.userId}"> ${r.userId}</td>
	<td><input type="hidden" name="password" value=" ${r.password}"> ${r.password}</td>
	<td><input type="hidden" name="role" value="${r.role}"> ${r.role}</td>
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