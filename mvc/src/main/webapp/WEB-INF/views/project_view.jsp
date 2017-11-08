<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="utf-8"%>
<%@ page import="com.tb.mvc.model.Project" %>

<%@include file="pagehead.jsp"%>


<!DOCTYPE html>
<!-- @Tiago Brazao 2017 -->
<!--  -->
<html>
	<head>
		<title> Project View </title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, 
					maximum-scale=1.0, user-scalable=no">
					
		<spring:url value="/resources/images/moon-and-misty-night.png" var="bkg_image" />
	</head>

	<body id="top_project_view">

 	<!-- MAIN BACKGROUND -->
	<div class="wrapper bgded overlay" 
		style="background-image:url('${bkg_image}');">
		
  	<div id="pageintro" class="hoc clear"> 
    
    <!--  VIEW PROJECT CONTENT
    		SERVLET SETS PARAM.PROJECT  -->
    <article>
      <div>
        <p class="heading"> Project View </p> 
        <p> Nome: ${project.name} </p>
        <p> Descrição: ${project.description} </p>
        <p> Data de criação: <fmt:formatDate value="${project.entry_date}" pattern="dd/MM/yyyy"/></p>
        <p> Fechado? <input type="checkbox" 
        				name="closed" 
        				value="true" 
        				${project.closed? 'checked' : '' }
        				onclick="close_project(${project.id})" /> 
        </p> 
        <br />  
        
        <form action="remove_project" method="POST">
 			 <button type="submit" style="color:#000000">Apagar</button><br>
 		</form>         
        </div>
       
    </article>
   </div>
   </div> 

<a id="backtotop" href="#top"><i class="fa fa-chevron-up"></i></a>
<!-- JAVASCRIPTS -->
<script src="/resources/css/jquery.min.js"></script>
<script src="/resources/js/jquery.backtotop.js"></script>
<script src="/resources/js/jquery.mobilemenu.js"></script>
</body>
</html>

<%@include file="pagebottom.html"%>