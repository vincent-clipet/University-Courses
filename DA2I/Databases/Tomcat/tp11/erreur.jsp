<!-- erreur.jsp -->
<%@ page isErrorPage="true" %>
<html><head>
<title>page d’affichage d’erreur</title>
</head>
<body>
	<center>
	<h4>Une erreur est survenue !</h3>
	<h3><%= exception.toString() %></h3>
	<% exception.printStackTrace(); %>
	</center>
</body>
</html>

