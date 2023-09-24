<%@ page
language="java"
contentType="text/html; charset=UTF8"
pageEncoding="UTF8"
import="java.util.*,java.sql.*"
%>

<!DOCTYPE html>
<html lang="fr">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8" />
<title> Exemple simple, schéma caddie </title>
<link rel="stylesheet" type="text/css" href ="caddie.css"/>
</head>
<body>
<%
/* Test pour déterminer la présence du pilote */
try {
Class.forName("org.postgresql.Driver");
} catch (ClassNotFoundException cnfe) {
System.err.println("Exception : Probleme d'acces au pilote.");
cnfe.printStackTrace();
}

Connection c = null;

/* Connexion à la base */
try{
/* En local si vous avez installé postgreSQL sur vos machines :*/
/* c = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "postgres", "votremdp");*/
/* à l'IUT : */
c = DriverManager.getConnection("jdbc:postgresql://iut-rt/login","login", "bdrt00");
out.println("<h1> Tests sur le schéma caddie</h1>");
}catch(SQLException e){
System.err.println("Exception : Connexion à la base postgres impossible.");
}

/* Réalisation de requêtes avec resultset "scrollable"*/
/*
Statement stmt = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE
        ,ResultSet.CONCUR_READ_ONLY,ResultSet.HOLD_CURSORS_OVER_COMMIT);
*/

/* Réalisation de requêtes */
Statement stmt = c.createStatement();
stmt.executeUpdate("SET SEARCH_PATH=caddie,PG_CATALOG");
%>

<% ResultSet rs = stmt.executeQuery("SELECT *,extract(year from age(datenaissance)) AS age, age(datenaissance) AS \"age precis\" FROM client"); %>

<table>
<caption> Liste des clients </caption>
<%
ResultSetMetaData rsmd = rs.getMetaData();
out.print("<tr>");
int nbColumns = rsmd.getColumnCount();
for(int i=1;i<=nbColumns;i++)
	out.print("<th>"+rsmd.getColumnName(i)+"</th>");
out.println("</tr>");
while(rs.next()){
	out.print("<tr>");
	for(int i=1;i<=nbColumns;i++)
		out.print("<td>"+rs.getString(i)+"</td>");
	out.println("</tr>");
}
%>
</table>

<% stmt.close(); %>

<% /* Ajout d'un formulaire pour ajouter des clients */ %>

<form method="post" action="exemple_caddie_2_action.jsp">
     <fieldset>
          <legend>Ajout d'un nouveau client</legend>
          <label for="nom">Nom</label> :
          <input type="text"  value="" name="nom" id="nom" />
          <label for="prenom">Prénom</label> :
          <input type="text"  value="" name="prenom" id="prenom" />
          <input type="radio" name="sexe" id="sexe" value="h"/>
          <label for="homme">Homme</label>
          <input type="radio" name="sexe" id="sexe" value="f"/>
          <label for="femme">Femme</label>
          <hr/>
          <label for="datenaissance">Naissance : année </label>
          <select name="annee" id="anneee">
    	  <% 
            int anneeCourante = Calendar.getInstance().get(Calendar.YEAR);
            for (int i=anneeCourante;i>=1850;i--)
                out.println("<option value=\""+i+"\">" + i);
          %>
    	  </select>
          <label for="mois">mois </label>
          <select name="mois" id="mois">
    	  <% for (int i=1;i<=12;i++)
                out.println("<option value=\""+i+"\">" + i);
          %>
    	  </select>
          <label for="jour">jour </label> <select name="jour" id="jour">
          <% for (int i=1;i<=31;i++)
                out.println("<option value=\""+i+"\">" + i);
          %>
    	  </select>
          <input type="submit" name="ajoutclient" id="ajoutclient" value="Ajout Client"/>
     </fieldset>
</form>


</body>
</html>
