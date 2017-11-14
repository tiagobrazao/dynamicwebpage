<!-- @author Tiago Brazão  -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@include file="pagehead.jsp"%>

<!DOCTYPE html>
<HTML>
	
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login</title>
	
		<!-- LAYOUT -->
		<spring:url value="/resources/css/formlayout.css" var="formCss" />
		<link href="${formCss}" rel="stylesheet" type="text/css" media="all"/>
		
	</head>
	
<body>
	<div id="mainWrapper">
                    <form:form 
                    	action= "/login"  
                    	method="post" 
                    	id="prettyform" 
                    	class="form-horizontal">
                    	<c:if test="${param.error != null}">
                                <div class="alert alert-danger">
                                    <p>Invalid username and password.</p>
                                </div>
                            </c:if>
                            <c:if test="${param.logout != null}">
                                <div class="alert alert-success">
                                    <p>You have been logged out successfully.</p>
                                </div>
                            </c:if>
                            <div class="input-group input-sm">
                                <label class="input-group-addon" for="username"><i class="fa fa-user"></i> Utilizador </label>
                                <input type="text" class="form-control" id="username" name="ssoId" required>
                            </div>
                            <div class="input-group input-sm">
                                <label class="input-group-addon" for="password"><i class="fa fa-lock"></i> Password </label> 
                                <input type="password" class="form-control" id="password" name="password" required>
                            </div>

                            <br>
                            <input type="checkbox" id="rememberme" name="remember-me" value="Lembrar?">  

                            <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
                                 
                            <div class="form-actions">
                                <input type="submit"
                                    class="btn btn-block btn-primary btn-default" value="Log in">
                            </div>
                        </form:form>
                    </div>

</body>
</html>

<%@include file="pagebottom.jsp"%>