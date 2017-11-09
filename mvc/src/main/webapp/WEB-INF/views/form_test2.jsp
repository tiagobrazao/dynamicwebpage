<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@include file="pagehead.jsp"%>

<!DOCTYPE html> 
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>New View</title>
	</head>
	<body> 
		
		<!--Form/Create a new Project and save in DB 
			Form tag from Spring and Multipart to upload project image -->	
		
		<form:form 
			action="add_view" 
			method="POST"
			> 
			
			Nome <input type="text"  style="color:#000000" name="name" /> <br /> 		
			
			<!-- SAVE BUTTON -->
			<input type="submit" value="Gravar" style="color:#000000"/>
			
			<br/>			
		</form:form> 
	</body>
</html>

<%@include file="pagebottom.jsp"%>