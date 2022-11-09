<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Saludo</title>
</head>
<body>
	<%
		String name;
		try {
			name = (String) request.getAttribute("name");
		} catch (Exception e) {
			name = null;
		}

		if (name != null) {
			out.print("<h1>Hola "+name+"</h1>");
		}else{
			out.print("<a href=\"./index.jsp\">Debes usar el formulario de entrada.</a>");
		}
	%>
</body>
</html>