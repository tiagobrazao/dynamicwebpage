<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html> 
<!-- @Tiago Brazao 2017 -->
<!--  -->
<html>
	<head>
		<title> Web Model</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, 
					maximum-scale=1.0, user-scalable=no">
				
		<spring:url value="/resources/js/jquery.min.js" var="jqueryJS" />
		<spring:url value="/resources/js/jquery.backtotop.js" var="jqueryBTPJS" />
		<spring:url value="/resources/js/jquery.mobilemenu.js" var="jquerymobileJS" />
		
		<script src="${jqueryJS}"></script>
		<script src="${jquerymobileJS}"></script>
		<script src="${jqueryJS}"></script>
		
		<spring:url value="/resources/images/moon-and-misty-night.png" var="bkg_image" />
	</head>

	<body id="top_main">

 	<!-- MAIN BACKGROUND -->
	<div class="wrapper bgded overlay" 
		style="background-image:url('${bkg_image}');">
		
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
        <p> JAVA EE/JDBC </p>
      </div>
      
      <footer>
        <ul class="nospace inline pushright">
          <li><a class="btn inverse" href="docs/CV-TiagoBrazÃ£o.pdf">Currículo</a></li>
          <li><a class="btn" href="#">Projectos</a></li>
        </ul>
      </footer>
    </article>
   </div>
   </div> 

<a id="backtotop" href="#top"><i class="fa fa-chevron-up"></i></a>

</body>
</html>