<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@include file="pagehead.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Login</title>
</head>
<body>
	<p>Login<p>
    
    <form action="doLogin" method="post">
      Login: <input type="text" name="login_name" /> <br /> 
      Senha: <input type="password" name="password" /> <br />
      <input type="submit" value="Login" /> 
    </form>
</body>
</html>

<%@include file="pagebottom.jsp"%>