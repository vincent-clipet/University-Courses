<?xml version="1.0" encoding="iso-8859-1"?>
<%@ page contentType="text/xml" %>
<%@ page import="java.sql.*" %>
<%@ page errorPage="error.jsp" %>

<%
	// Init param
	String db_url = application.getInitParameter("db_url");
	String db_driver = application.getInitParameter("db_driver");
	String db_password = application.getInitParameter("db_password");
	String db_user = application.getInitParameter("db_user");
	String search = request.getParameter("search");
	
	if (search == null || (! search.equalsIgnoreCase("asc") && ! search.equalsIgnoreCase("desc")))
		search = "ASC";
	
	// Init DB
	Class.forName(db_driver);
	Connection conn = DriverManager.getConnection(db_url, db_user, db_password);
	Statement st = conn.createStatement();
	
	
	// Request
	String query = "SELECT * FROM personne ORDER BY id "+search+" LIMIT 3";
	ResultSet rs = st.executeQuery(query);
	
	boolean atLeastOneResult = false;
	out.println("<personnes>");
	
	while (rs.next())
	{
		atLeastOneResult = true;
%>

<personne>
	<id><%= rs.getString("id") %></id>
	<login><%= rs.getString("login") %></login>
	<nom><%= rs.getString("nom") %></nom>
	<prenom><%= rs.getString("prenom") %></prenom>
	<datenaiss><%= rs.getString("datenaiss") %></datenaiss>
</personne>

<%
	}
	
	if (! atLeastOneResult)
	{
%>
<personne>
	<id></id>
	<login></login>
	<nom></nom>
	<prenom></prenom>
	<datenaiss></datenaiss>
</personne>
<%
	}
	
	out.println("</personnes>");
	
	conn.close();
%>
