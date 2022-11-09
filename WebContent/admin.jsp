<%@page import="java.util.HashMap"%>
<%@page import="dam2.dii.p11.model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="ISO-8859-1" />
        <link rel="stylesheet" href="./css/reset.css" />
        <link rel="stylesheet" href="./css/styles.css" />
        <title>Acceso administrador</title>
    </head>

    <body>
        <div class="container">
            <form action="<%=request.getContextPath()%>/admin" method="POST">
                <%
                HashMap<String, Usuario> userList;
                
                try {
                  userList = (HashMap<String, Usuario>) request.getAttribute("users");
                } catch (Exception e) {
                  userList = null;
                }
                
                if(userList != null){
                  out.print("<div class=\"form-row title-row\">Seleccione el usuario que quiere desbloquear:</div>");
                  for(Usuario user : userList.values()){
                    if(user.getTrysLeft() <= 0){
                      out.print("<div class=\"form-row\"><input type=\"radio\" id=\"" 
                          + user.getName() + 
                          "\" name=\"user\" value=\""
                          + user.getName() +
                          "\" required><label for=\"html\">"
                          + user.getName() +
                          "</label></div>");
                    }
                  }
                }else{
                  response.sendRedirect("./index.jsp");
                }
                %>               
                <div class="form-row">
                    <input class="button button-submit" type="submit" name="boton" value="Desbloquear" />
                    <a href="./index.jsp" class="button button-back">Volver</a>
                </div>
            </form>
        </div>
    </body>

    </html>