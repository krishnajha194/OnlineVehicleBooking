<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="mp" tagdir="/WEB-INF/tags"%>
<mp:CustomerMaster title="profile Page">
	<jsp:attribute name="header"></jsp:attribute>
	<jsp:attribute name="content">


<c:choose>
	<c:when test= "${CustomerObject1.customerName!=null}">
	 <div>
<table>
<tr>
<td>login id         </td>
					<td><c:out value="${CustomerObject1.loginId}"></c:out></td>
</tr>
<tr>
<td>Branch Location </td>
					<td><c:out value="${CustomerObject1.customerName}"></c:out></td>
</tr>
<tr>
<td>Branch Address  </td>
					<td><c:out value="${CustomerObject1.dateOfBirth}"></c:out></td>
</tr>
<tr>
<td>Branch MailId   </td>
					<td><c:out value="${CustomerObject1.address}"></c:out></td>
</tr>
<tr>
<td>Branch Phone No </td>
					<td><c:out value="${CustomerObject1.phoneNumber}"></c:out></td>
</tr>
<tr>
<td>Branch MailId   </td>
					<td><c:out value="${CustomerObject1.mailId}"></c:out></td>
</tr>
<tr>
<td>Branch Phone No </td>
					<td><c:out value="${CustomerObject1.occupation}"></c:out></td>
</tr>
</table>
</div>

 </c:when>

 <c:otherwise>
	<div style="display: flex;">
	

<form action="/AddCustomer" method="get">
<table>
<tr>
<td>loginId :</td>
<td><input type="text" name="loginId" value="${str}"></td>
</tr>
<tr>
<td>customerName :</td>
<td><input type="text" name="customerName"></td>
</tr>
<tr>
<td>dateOfBirth :</td>
<td><input type="date" name="dateOfBirth"></td>
</tr>
<tr>
<td>address :</td>
<td><input type="text" name="address"></td>
</tr>
<tr>
<td>phoneNumber :</td>
<td><input type="text" name="phoneNumber"></td>
</tr>
<tr>
<td>mailId :</td>
<td><input type="text" name="mailId"></td>
</tr>
<tr>
<td>occupation :</td>
<td><input type="text" name="occupation"></td>
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
</mp:CustomerMaster>





