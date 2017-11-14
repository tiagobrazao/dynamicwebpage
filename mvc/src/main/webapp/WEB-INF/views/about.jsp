<!-- ABOUT PAGE / CHANGES MAIN CONTENT -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@include file="pagehead.jsp"%>

<!DOCTYPE html>
<html>
	<head>
		<title> Sobre </title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, 
					maximum-scale=1.0, user-scalable=no">
					
		<spring:url value="/resources/doc/CV-TiagoBrazão.pdf" var="c_doc" />
	</head>

	<body id="top_about">
	

 	<!-- MAIN BACKGROUND -->
	<div class="wrapper bgded overlay" 
		style="background-image:url('images/moon-and-misty-night.png');">
		
  	<div id="pageintro" class="hoc clear"> 
    
    <!--  MAIN ARTICLE
    The <article> tag specifies independent, self-contained content.
	An article should make sense on its own and it should be possible to 
	distribute it independently from the rest of the site.
     -->
    <article>
      <div>
        <p class="heading"> Tiago Brazão @2017 </p>
        <h2 class="heading">JAVA WEB DEVELOPER</h2>
        <p>Licenciado em Engenharia de Informática </p>
        <p>na Faculdade de Ciência e Tecnologia / Universidade Nova de Lisboa</p>
        <p>Web Design / JEE / JDBC</p>
        <p>Design - Lógica de Negócio - Persistência</p>

      </div>
      
      <footer>
        <ul class="nospace inline pushright">
          <li><a class="btn inverse" href="${c_doc}" target="_blank"> Currículo  </a></li>  
        </ul>
      </footer>
    </article>
   </div> 
   </div> 
</body>
</html>

<%@include file="pagebottom.jsp"%>
