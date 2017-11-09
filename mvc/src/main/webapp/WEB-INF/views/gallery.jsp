<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@include file="pagehead.jsp"%>

<!DOCTYPE html>
<!--
Template Name: Gallery
Author: Tiago Brazão
-->

<html>
<head>
	<title>Galeria de Imagens</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
	
	<spring:url value="/resources/css/layout.css" var="mainCss" />
	<link href="${mainCss}" rel="stylesheet" type="text/css" media="all"/>

</head>
<body id="top">
	
  <div class="wrapper row3">
  <div class="hoc container clear"> 
      
      <!-- HEAD TITLE -->
      <div class="headtitle">
        <p class="heading"> Images Gallery </p>
      </div>
      
      <!-- Gallery -->
      <div class="content"> 
      
      <div id="gallery">
        <figure>
          <header class="heading"> </header>
          <ul class="nospace clear">
            
            <!-- files setted in HomeController / 4 images in line -->
            <c:set var="count_image" value="0" scope="page" />
		  	<c:forEach items="${files}" var="file">
		  		<li class="one_quarter_first"> 
        		<img src="image/${file.id}" alt=""  /> </li>
		  		
		  		<!--
		  		<c:choose>
   					<c:when test="${count_image =='0'}">
   						<c:set var="count_image" value="${count_image + 1}" scope="page"/>
        				<li class="one_quarter_first"> 
        				<img src="image/${file.id}" alt=""  /> </li>
        			</c:when> 
        			<c:otherwise> 
        				<li class="one_quarter"> 
        				<img src="image/${file.id}" alt=""  /> </li>
        				<c:if test="${count_image =='4'}"> <c:set var="count_image" value="0" scope="page"/></c:if>
        			</c:otherwise>
				</c:choose> 
		  		-->
		  		
  			</c:forEach>
  			
          </ul>
        </figure>
      </div>
      
    </div>
    
    <!-- / main body -->
    <div class="clear"></div>
  </div>
</div>

<%@include file="pagebottom.jsp"%>
