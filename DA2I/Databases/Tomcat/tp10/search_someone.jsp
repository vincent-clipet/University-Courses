<html>
<body>

<%@ page import="tool.Personne" %> 
<jsp:useBean id="t" class="tool.Tool" scope="application" />
<% tool.Personne p = t.rechPersonne(request.getParameter("nom")); %>
<%= p.getHTML() %>
<% t.close(); %>


</body>
</html>	
