<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
	<title>Page d'erreur</title>
        <%@ page
               contentType="text/html; charset=ISO-8859-15" 
	       isErrorPage="true" %>
	<link rel="stylesheet" href="style.css" type="text/css">
    </head>
<body>

   <h1> Page de gestion d'erreur</h1>
   <h3> Un probleme de type 
"<%
	String m = request.getParameter("message");
	if (m!=null) out.print(m);
	if (exception!=null) out.print(exception.getMessage());
 %>" est survenu.</h3> 


<a href=menu.html>Retour</a>

<%@ include file="basDePage.html" %>

</body>
</html>
