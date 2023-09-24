<%@ page
	contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"
	import="java.util.*,java.text.DateFormat,java.sql.*"
%>
<%-- Traitement de la page : ajout d'un client--%>

<%
/* 1.Récupération des informations issues du formulaire */
String erreur="";

int annee = Integer.parseInt(request.getParameter("annee"));
if(annee==0) erreur="Veuillez préciser une année de naissance";
int mois = Integer.parseInt(request.getParameter("mois"));
if(mois==0) erreur="Veuillez préciser un mois de naissance";
int jour = Integer.parseInt(request.getParameter("jour"));
if(jour==0) erreur="Veuillez préciser un jour de naissance";

String prenom=request.getParameter("prenom");
if(prenom=="") erreur="Veuillez préciser votre prénom";
String nom=request.getParameter("nom");
if(nom=="") erreur="Veuillez préciser votre nom";

String sexe=request.getParameter("sexe");
if(sexe==null) erreur="Êtes vous un homme ou une femme ?";


/* 2.Stockage des informations dans la session */

session.setAttribute("nom",nom);
session.setAttribute("prenom",prenom);
session.setAttribute("sexe",sexe);
session.setAttribute("annee",annee);
session.setAttribute("mois",mois);
session.setAttribute("jour",jour);

if(erreur.compareTo("")==0){
	/* En local si vous avez installé postgreSQL sur vos machines :*/
	/* c = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "postgres", "votremdp");*/
	/* à l'IUT : */
	Connection c = DriverManager.getConnection("jdbc:postgresql://iut-rt/login","login", "bdrt00");
    
	Statement stmt = c.createStatement();
	stmt.executeUpdate("SET SEARCH_PATH=caddie,PG_CATALOG");

	String sql="INSERT INTO client (nom,prenom,datenaissance,sexe) VALUES "+
		" ('"+nom+"','"+prenom+"','"+annee+"-"+mois+"-"+jour+"','"+sexe+"')";
        //out.println(sql);
	stmt.executeUpdate(sql);
	stmt.close();
	session.invalidate();
        %>
	<jsp:forward page="exemple_caddie_3.jsp">
            <jsp:param name="messageNotification" value="Ajout effectué"/>
        </jsp:forward>
        <%
}else{
	%>
	<jsp:forward page="exemple_caddie_3.jsp">
		<jsp:param name="messageErreur" value="<%=erreur%>"/>
	</jsp:forward>
	<%
}
%>