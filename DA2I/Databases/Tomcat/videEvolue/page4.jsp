<!-- page4.jsp -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
   <TITLE>Page de test de configuration</TITLE>
   <%@ page 
         contentType="text/html; charset=ISO-8859-15"
         import="java.sql.* , javax.sql.* , javax.naming.*"
	 session="false"
         errorPage="erreur.jsp" %>
   <link rel=stylesheet href=style.css type=text/css>		
</HEAD>
<BODY>

<h1>Page 4 : accès direct à une BDD</h1>

<p>
Page réalisée par <%=getServletContext().getInitParameter("concepteur")%>
<p>
Cette page est privée, accessible uniquement à pierre et à paul.
<p>
Celui qui vient de se connecter est <b><%=request.getRemoteUser()%></b>
dans le role <b><%= (request.isUserInRole("role1")?"role1":"role2") %></b>
<p>


<%    
      Class.forName("org.postgresql.Driver");
      String url = "jdbc:postgresql://psqlserv/da2i";
      String nom = "clipetv";
      String mdp = "moi";
      Connection con = DriverManager.getConnection(url,nom,mdp);
      Statement stmt = con.createStatement();
      String query = "select * from users";
      ResultSet rs = stmt.executeQuery(query);
          
%>

<center><table>
<tr><th>Nom</th><th>Password</th></tr>

<%
      while (rs.next()) 
      {
%>
<tr>
<td class="impaire"><%=rs.getString("user_name")%></td>
<td class="impaire"><%=rs.getString("user_pass")%></td>
</tr>

<%
      }
      con.close();
%>

</table></center>

<a href=menu.html>Retour</a>

<%@ include file="basDePage.html" %>

</BODY>
</HTML>
