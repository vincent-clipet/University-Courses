<%@ page import="com.vince.sqlibrary.*, java.sql.*, java.util.Date" %>
<%@ page session="true" %>
<!--<%@ page errorPage="erreur.jsp" %> -->



<HTML>
<HEAD>
   <META http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <TITLE>Page de test JSP</TITLE>
</HEAD>
<BODY>



<%!
	Database getDB()
	{
		Database db = new Database(
			getServletContext().getInitParameter("db_name"),
			getServletContext().getInitParameter("db_prefix"),
			getServletContext().getInitParameter("db_user"),
			getServletContext().getInitParameter("db_password"),
			getServletContext().getInitParameter("db_hostname"),
			getServletContext().getInitParameter("db_dbname"),
			getServletContext().getInitParameter("db_port"),
			getServletContext().getInitParameter("db_driver"),
			getServletContext().getInitParameter("db_url")
		);
	
		return db;
	}
%>



<%
	int num = Integer.valueOf(request.getParameter("num"));
	System.out.println("DEBUG: num=" + num);
%>



<%
	// --- Connection ------------------------
	Database db = getDB();
	
	if (db.open())
	{
		// --- Select ------------------------
		String select = "SELECT * FROM annuaire WHERE num=?";
		PreparedStatement ps = db.prepare(select);
		ps.setInt(1, num);
		
		System.out.println("DEBUG: OK");
		
		ResultSet rs = db.query(ps);
		boolean userExists = false;

		if (rs != null)
		{
			rs.next();
			userExists = (rs.getInt(1) == 1);
			System.out.println("DEBUG: userExists = " + userExists);
		}
		
		if (! userExists)
		{
			out.println("<strong>Identifiant inconnu !</strong>" + "<br />");
		}
		else
		{
			String nom = rs.getString("nom");
			String prenom = rs.getString("prenom");
			String sexe = rs.getString("sexe");
			String tel = rs.getString("tel");
			String fonction = rs.getString("fonction");
			
			out.println("<br>ID : " + num);
			out.println("<br>Nom : " + prenom + " " + nom + " (" + sexe.toLowerCase() + ")");
			out.println("<br>Tel. : " + tel);
			out.println("<br>Poste : " + fonction);
		}
		
	}
%>

<%
	// --- Close ------------------------
	db.close();
%>


</BODY>
</HTML>
