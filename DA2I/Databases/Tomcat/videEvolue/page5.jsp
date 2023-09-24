<!-- page4.jsp -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
   <TITLE>Page de test de configuration</TITLE>
   <%@ page 
         contentType="text/html; charset=ISO-8859-15"
         import="java.sql.* , javax.sql.* , javax.naming.*"
         errorPage="erreur.jsp" %>
   <link rel=stylesheet href=style.css type=text/css>		
</HEAD>
<BODY>

<!-- 
Par défaut,quand rien n'est précisé, cette page utilise une
session. On peut le voir en accédant à la page SuiviSession.jsp
-->

<jsp:useBean id="tool" scope="application" class="tools.BDDTools" />

<!-- 
L'usage d'un Bean est ici inutile puisqu'il n'y a dedans que des
méthodes static. On pourrait invoquet ces méthodes directement pour
peu qu'on ait fait un import de la classe au début de la page .
-->


<h1>Page 5 : Utilisation du pool et d'un Bean</h1>


<p>
Page réalisée par <%=getServletContext().getInitParameter("concepteur")%>
<p>
Cette page est privée, accessible uniquement à pierre et à paul.
<p>
Celui qui vient de se connecter est <b><%=request.getRemoteUser()%></b>
dans le role <b><%= (request.isUserInRole("role1")?"role1":"role2") %></b>
<p>

<%    
      Context initCtx = new InitialContext();
      Context envCtx = (Context) initCtx.lookup("java:comp/env");
      DataSource ds = (DataSource) envCtx.lookup("mabase");
      Connection con = ds.getConnection();
      Statement st=con.createStatement();
      ResultSet rs=null;
%>

<%
            rs=st.executeQuery("select * from users");
            out.println(tool.getHTMLSimpleTable(rs,true,true,false));
            con.close();
%>

<a href=menu.html>Retour</a>

<%@ include file="basDePage.html" %>

</BODY>
</HTML>
