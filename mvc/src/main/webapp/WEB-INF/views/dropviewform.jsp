<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@include file="pagehead.jsp"%>

<!-- Import needed (temp) -->
<%@ page import="com.tb.mvc.model.DropLabel" %>

<!DOCTYPE html> 
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>New View</title>
		
		<!-- DYNAMIC FORM SCRIPT -->
		<spring:url value="/resources/js/dynamicform.js" var="dynamicform" />
		<script src="${dynamicform}"></script>
		
		<!-- LAYOUT -->
		<spring:url value="/resources/css/formlayout.css" var="formCss" />
		<link href="${formCss}" rel="stylesheet" type="text/css" media="all"/>
		
	</head>
	
	<body> 
		<!--Form/Create a new Project and save in DB 
			Form tag from Spring and Multipart to upload project image -->	
		<div class="container">  
		
			<div class="row">
				<input type="hidden" name="count" value="1" />
        		<div class="control-group" id="fields">
            	<div class="controls" id="profs"> 
				
				
				<% DropLabel[] drop_labels = {}; %>
                <form:form
                	action="add_view" 
                	class="input-append"
                	id="prettyform" 
                	method="POST"
                	>
                	
                	<h3>Nova DropView</h3>
    				<h4>Insira os detalhes da sua nova DropView</h4> 
					Tag <input 
						type="text" style="color:#000000" name="name"
						placeholder="Ex: Social Networks" /> <br /> 	
                	
                	<div class="input_fields_wrap">
    					<button type="button" class="add_field_button">+</button>
    					<div><input type="text" name="drop_labels[0].name" placeholder="Ex: Facebook" ></div>
    					<div><input type="text" name="drop_labels[0].url" placeholder="www.facebook.com" ></div>
					</div>
					
					   	<br>
                    	<br>
                    	<br>

                    	<!-- SAVE BUTTON -->
                    	<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
						<button type="submit" name="submit"> Save </button> 
                </form:form>
            </div>	
        </div>
	</div>
	</div>
	</body>
</html>

<%@include file="pagebottom.jsp"%>