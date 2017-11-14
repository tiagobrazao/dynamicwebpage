<!-- @author Tiago Brazão -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@include file="pagehead.jsp"%>

<!DOCTYPE html>
<html>
<head> 
    <title>HTML5 Puzzle</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, 
					maximum-scale=1.0, user-scalable=no">
					
	<spring:url value="/resources/images/yoda.jpg" var="yoda_image" />
	<spring:url value="/resources/js/puzzlegame.js" var="puzzlegameJS" />
	<script src="${puzzlegameJS}"></script>
	 
</head>
  
<body 
	style="text-align:center;"
	onload="init('${yoda_image}');"
	>
    
    <canvas id="canvas"></canvas>

</body>
 
</html>

<%@include file="pagebottom.jsp"%>