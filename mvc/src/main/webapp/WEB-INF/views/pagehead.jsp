<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page import="com.tb.mvc.model.Project" %>

<!DOCTYPE html>
<!-- @Tiago Brazao 2017 -->

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
		
		<spring:url value="/index/" var="home_url" htmlEscape="true"/>
		<spring:url value="/about/" var="about_url" htmlEscape="true"/>
		<spring:url value="/form_project/" var="add_project_url" htmlEscape="true"/>
		<spring:url value="/login/" var="login_url" htmlEscape="true"/>

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
        			<li><a href="${login_url}">Login</a></li>
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
        
        <!-- DROP DOWN EXAMPLE -->
        <li><a class="drop" href="#">VIEW MODELS</a>
          <ul>
            <li><a href="gallery.html">Gallery</a></li>
            <li><a href="full-width.html">Full Width</a></li>
            <li><a href="sidebar-left.html">Sidebar Left</a></li>
            <li><a href="sidebar-right.html">Sidebar Right</a></li>
            <li><a href="basic-grid.html">Basic Grid</a></li>
            <li><a class="drop" href="#">Sub Menu</a>
              <ul>
                <li><a href="#">Example 1</a></li>
                <li><a href="#">Example 2</a></li>
              </ul>
            </li>            
          </ul>
        </li>
       
       	<!-- PROJECTS NAMES DROPDOWN : DAOUtils.getAll(Project)-->
        <li><a class="drop" href="#">PROJECTOS </a>
        	<ul id ="drow_projects">
        	
        	<!-- projects setted in HomeServlet -->		  	
		  	<c:forEach items="${projects}" var="project">
      			<li><a href="view_project?id=${project.id}">${project.name}</a></li>
  			</c:forEach>
		
          </ul>
       
       <!-- TEST MODULE LINK -->
       <li><a href="${add_project_url}"> Test </a></li>
        
      </ul>      
    </nav>
  	</header>
	</div>
</body>
</html>