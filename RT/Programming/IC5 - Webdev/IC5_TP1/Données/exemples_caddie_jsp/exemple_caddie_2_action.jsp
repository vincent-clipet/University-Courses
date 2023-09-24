<%@ page
	contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"
	import="java.util.*,java.text.DateFormat,java.sql.*"
%>
<%-- Traitement de la page : ajout d'un client--%>

<%
/* Récupération des informations issues du formulaire */
String prenom=request.getParameter("prenom");
String nom=request.getParameter("nom");
String sexe=request.getParameter("sexe");
int annee = Integer.parseInt(request.getParameter("annee"));
int mois = Integer.parseInt(request.getParameter("mois"));
int jour = Integer.parseInt(request.getParameter("jour"));

/* Affichage des informations saisies pour tests */

%>

<p> Les informations saisies sont : </p>
<ul>
    <li>Nom : <%= nom%></li>
    <li>Prénom : <%= prenom%></li>
    <li>Sexe : <%= sexe%></li>
    <li>Année : <%= annee%></li>
    <li>Mois : <%= mois%></li>
    <li>Jour : <%= jour%></li>
</ul>

<%
String sql="INSERT INTO client (nom,prenom,datenaissance,sexe) VALUES "+
		" ('"+nom+"','"+prenom+"','"+annee+"-"+mois+"-"+jour+"','"+sexe+"')";

out.println("<p> Requête possible d'insertion :"+sql+"</p>");
%>