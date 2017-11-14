<!-- @Tiago Brazao 2017 -->

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ page import="com.tb.mvc.model.Project" %>

<!DOCTYPE html>


<html>
	<head>
		<title>Web Model</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, 
					maximum-scale=1.0, user-scalable=no">
					
		<!-- LAYOUT -->
		 
		<spring:url value="/resources/css/framework.css" var="frameworkCss" />
		<spring:url value="/resources/css/fontawesome-4.5.0.min.css" var="fontawesomeCss" />
		<spring:url value="/resources/css/layout.css" var="mainCss" />
		
		<link href="${frameworkCss}" rel="stylesheet" type="text/css" media="all"/>
		<link href="${fontawesomeCss}" rel="stylesheet" type="text/css" media="all"/>
		<link href="${mainCss}" rel="stylesheet" type="text/css" media="all"/>
		
		<!-- URLS -->
		
		<spring:url value="/index/" var="home_url" htmlEscape="true"/>
		<spring:url value="/about/" var="about_url" htmlEscape="true"/>
		<spring:url value="/form_project/" var="add_project_url" htmlEscape="true"/>
		<spring:url value="/form_project2/" var="add_dropview_url" htmlEscape="true"/>
		<spring:url value="/list/" var="admin_url" htmlEscape="true"/>
		<spring:url value="/login/" var="login_url" htmlEscape="true"/>
		<spring:url value="/logout/" var="logout_url" htmlEscape="true"/>
		
		<!-- GAME -->
		<spring:url value="/play/" var="play_url" htmlEscape="true"/>
		
		<!-- HTML VIEW EXAMPLES -->
		<spring:url value="/gallery_view/" var="gallery" />
		
		<!-- BACK TO TOP -->
		<spring:url value="/resources/js/jquery.min.js" var="jqueryJS" />
		<spring:url value="/resources/js/jquery.backtotop.js" var="jqueryBTPJS" />
		
		<script src="${jqueryJS}"></script>
		<script src="${jqueryBTPJS}"></script>

	</head>

	<body id="top_pagehead">
	
	<!-- TOPO 
		Notes: The <div> tag defines a division or a section in an HTML document.
	-->
	
	<!-- HTML5 <object type="text/html" data="pagehead.html"/> </object> -->
	
	<div class="wrapper row0">
  		<div id="topbar" class="hoc clear"> 
  		    	
    		<div class="fl_left">
      			<ul class="nospace">
        			 <li><a href="${home_url}"><i class="fa fa-lg fa-home"></i></a></li>
        			 <li><a href="${about_url}"> Sobre </a></li>
        			 
        			 <!-- Security Module Log in or Log out-->
        			 <c:choose>
  						<c:when test="${loggedinuser} != null">
    						<li> Utilizador: <strong>${loggedinuser}</strong> </li> 
    						<li><a href="${admin_url}"> Admin </a></li>
    						<li><a href="${logout_url}"> Logout </a></li>
  						</c:when>
  					<c:otherwise>
  							<li><a href="${login_url}"> Login </a></li>
  					</c:otherwise>
					</c:choose>

      			</ul> 
    		</div>
    
    		<div class="fl_right">
      			<ul class="nospace">
        			<li><i class="Telemóvel"></i> 93 610 48 35 </li>
        			<li><i class="E-Mail"></i> tiagobrazao@gmail.com</li>
      			</ul>
    		</div>
    		
    	</div>
	</div>

	<!-- CABEÇALHO -->
	<div class="wrapper row1">
  	<header id="header" class="hoc clear"> 
    <div id="logo" class="fl_left">
      <h1>Web Template</h1>
      <p>2017</p>
    </div>
    
    <!-- 
    The <nav> tag defines a set of navigation links.
	Notice that NOT all links of a document should be inside a <nav> element. 
	The <nav> element is intended only for major block of navigation links.
     -->
    <nav id="mainav" class="fl_right">

      <ul class="clear">
        <!-- HOME -->
        <li class="active"><a href="${home_url}">Home</a></li>
        
        <!-- OPTIONS / TEST DROP DOWN-->
        
        <li><a class="drop" href="#">Options</a>
          <ul>
            <li><a href="${add_project_url}"> New Project </a></li>
       		<li><a href="${add_dropview_url}"> New Drop </a></li>
       		<li><a href="${gallery}">Images</a></li>
            
            <!--  
              <ul>
                <li><a href="#">Example 1</a></li>
                <li><a href="#">Example 2</a></li>
              </ul>
            </li> -->           
          </ul>
        </li>
       
       	<!-- PROJECTS NAMES DROPDOWN : DAOUtils.getAll(Project)-->
        <li><a class="drop" href="#">PROJECTOS </a>
        	<ul id ="drow_projects">
        	
        	<!-- projects setted in HomeController -->		  	
		  	<c:forEach items="${projects}" var="project">
      			<li><a href="view_project?id=${project.id}">${project.name}</a></li>
  			</c:forEach>
		
          </ul>
       
        <!-- PHASER GAME -->
        <li><a href="${play_url}">Play</a></li>
        
        <!-- CREATED VIEWS : drop_views in HomeController-->	  	
		<c:forEach items="${dropviews}" var="drop_view">
      		<li>${drop_view.name}</li>
      		<ul id ="drow_labels">
      		<c:forEach items="${dropview.drop_labels}" var="drop_element">
      			<li><a href="${drop_element.name}">${drop_element.name}</a></li>
      		</c:forEach>
      		</ul>
  		</c:forEach>
  		
  		
       
      </ul>      
    </nav>
  	</header>
	</div>
</body>
</html>