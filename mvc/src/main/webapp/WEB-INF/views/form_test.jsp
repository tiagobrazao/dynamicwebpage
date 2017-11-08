<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@include file="pagehead.jsp"%>

<!DOCTYPE html> 
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>TEST</title>
		
		<!-- JQUERY -->
  		<script src="http://code.jquery.com/jquery-1.9.0.js"></script>
  		<script src="http://code.jquery.com/ui/1.10.0/jquery-ui.js"></script>
  		
		<!-- <%@taglib tagdir="/WEB-INF/tags" prefix="util_tags" %> -->  
		
	</head>
	<body> 
		
		<!--Form/Create a new Project and save in DB 
			Form tag from Spring and Multipart to upload project image -->	
		
		<form:form 
			action="add_project" 
			method="POST"
			enctype="multipart/form-data"> 
			
			Nome <input type="text"  style="color:#000000" name="name" /> <br /> 
			Descrição <input type="text" style="color:#000000" name="description" /><br /> 			
			
			Data <input type="text" style="color:#000000" class= "datepicker" name = "entry_date" />
			<script> 
				$('.datepicker').datepicker({showAnim: "fadeIn", pattern: "dd/MM/yyyy"}); 
			</script>

			<!-- IMAGE PICKER -->
			Imagem <input 
				type="file" 
				accept=".png, .jpg, .jpeg"
				value="Procurar" 
				style="color:#FFFFFF" 
				name='fileUpload' /> <br /> 
				
			<!-- SAVE BUTTON -->
			<input type="submit" value="Gravar" style="color:#000000"/>
			<br/>			
		</form:form> 
		
		<!-- Projects Table View -->
		<table style="color:#000000">
  			<tr>
    			<th>Id</th>
    			<td>Nome</td>
    			<th>Descrição</th>
    			<th>Data de criação</th>
    			<th>Status</th>
    			<th>Remover<th>
  			</tr>
  			
  			<!-- For each project displays properties. ${projects} set in Controller -->
  			<c:forEach items="${projects}" var="project">
    		<tr>
      			<td>${project.id}</td>
      			<td><a href="view_project?id=${project.id}">${project.name}</a></td>
      			<td>${project.description}</td>
      			<td><fmt:formatDate value="${project.entry_date}" pattern="dd/MM/yyyy"/></td>
      			
      			<!-- CLOSED? IF ... -->
      			<c:if test="${project.closed eq false}">
        			<td>Não finalizado</td> </c:if>
      			<c:if test="${project.closed eq true}">
        			<td>Finalizado</td> </c:if>
      			
      			<!-- REMOVE PROJECT -->
      			<td><a href="remove_project?id=${project.id}">Remover</a></td>
      			
      			<!-- CLOSE PROJECT -->
      			<td><a href="#" onclick="close_project(${project.id})">Fechar</a></td>
      		
      		</tr>
  			</c:forEach>
  		</table>
  		
  		<!-- Close Project Script -->
  		<script type="text/javascript">
  			function close_project(id) {
  				//close project in DB with ajax
  				alert("Projecto Encerrado");
    			$.get("close_project?id=" + id);
  				
  				//chagen closed text in table with ajax
    			$("#project_"+id).html("Tarefa finalizada");
  				return true;
 			};
		</script>
		
	</body>
</html>

<%@include file="pagebottom.html"%>