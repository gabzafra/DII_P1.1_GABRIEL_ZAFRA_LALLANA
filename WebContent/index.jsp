<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="ISO-8859-1" />
		<link rel="stylesheet" href="./css/reset.css" />
		<link rel="stylesheet" href="./css/styles.css" />
		<title>Acceso usuarios</title>
	</head>

	<body>
		<div class="container">
			<form action="<%=request.getContextPath()%>/users" method="POST">
			     <%
                 String name;
                 String error;
                 try {
                     error = (String) request.getAttribute("error");
                 } catch (Exception e) {
                     error = null;
                 }
                 try {
                     name = (String) request.getAttribute("name");
                 } catch (Exception e) {
                     name = null;
                 }
			     %>
				<div class="form-row"><label for="user">Nombre de usuario:</label>
					<input type="text" name="user" placeholder="Nombre" value="<%
					if(name != null){
                      out.print(name);
                    }else{
                      out.print("");
                    }
                    %>" />
				</div>
				<%
			    if(error != null){
			      out.print("<div class=\"form-row error\">" + error + "</div>");
			    }
				%>
				<div class="form-row"><label for="pass">Introduzca su clave:</label>
					<input type="password" name="pass" placeholder="Clave" value="" />
				</div>
				<div class="form-row"><label for="pass2">Repita su clave:</label>
					<input type="password" name="pass2" placeholder="Clave" value="" />
				</div>
				
				<div class="form-row">
					<input class="button button-submit" type="submit" name="boton" value="Entrar" />
				</div>
			</form>
		</div>
	</body>

	</html>