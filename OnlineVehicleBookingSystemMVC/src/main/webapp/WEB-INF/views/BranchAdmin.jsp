<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="mp" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<mp:Master title="Branch Page Design">
	<jsp:attribute name="header"></jsp:attribute>
	<jsp:attribute name="content">
	
<c:out value="${str}"></c:out>

</jsp:attribute>
</mp:Master>