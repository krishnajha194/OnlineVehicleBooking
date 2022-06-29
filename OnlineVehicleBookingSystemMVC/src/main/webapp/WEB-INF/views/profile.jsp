<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="mp" tagdir="/WEB-INF/tags"%>
<mp:Master title="profile Page">
	<jsp:attribute name="header"></jsp:attribute>
	<jsp:attribute name="content">

	
	<c:choose>
	<c:when test= "${branchAdminObject1.branchLocation!=null}">
	<div>
<table>
<tr>
<td>login id         </td>
					<td><c:out value="${branchAdminObject1.loginId}"></c:out></td>
</tr>
<tr>
<td>Branch Location </td>
					<td><c:out value="${branchAdminObject1.branchLocation}"></c:out></td>
</tr>
<tr>
<td>Branch Address  </td>
					<td><c:out value="${branchAdminObject1.address}"></c:out></td>
</tr>
<tr>
<td>Branch MailId   </td>
					<td><c:out value="${branchAdminObject1.mailId}"></c:out></td>
</tr>
<tr>
<td>Branch Phone No </td>
					<td><c:out value="${branchAdminObject1.phone}"></c:out></td>
</tr>
</table>
</div>
 </c:when>

 <c:otherwise>
	<div>
	<form action="/addBranchAdmin" method="post">
	<table>
		<tr>
			<td>loginId :</td>
			<td><input type="text" name="loginId" value="${str}"></td>
		</tr>
		<tr>
			<td>branchLocation :</td>
			<td><input type="text" name="branchLocation"></td>
		</tr>
		<tr>
			<td>address :</td>
			<td><input type="text" name="address"></td>
		</tr>
		<tr>
			<td>mailId :</td>
			<td><input type="text" name="mailId"></td>
		</tr>
		<tr>
			<td>phone :</td>
			<td><input type="text" name="phone"></td>
		</tr>
		
		<tr>
			<td> </td>
			<td><button>submit</button></td>
		</tr>
	</table>
	</form>
</div>
 </c:otherwise>

</c:choose>
	
</jsp:attribute>

</mp:Master>