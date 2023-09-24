<%@ page import="java.sql.*" %>
<%@ page errorPage="error.jsp" %>
<%
	// Init param
	String db_url = application.getInitParameter("db_url");
	String db_driver = application.getInitParameter("db_driver");
	String db_password = application.getInitParameter("db_password");
	String db_user = application.getInitParameter("db_user");
	String search = request.getParameter("search");
	
	// Init DB
	Class.forName(db_driver);
	Connection conn = DriverManager.getConnection(db_url, db_user, db_password);
	Statement st = conn.createStatement();
	
	
	// Request
	String query = "SELECT * FROM personne WHERE nom LIKE '" + search + "%'";
	ResultSet rs = st.executeQuery(query);

	while (rs.next())
	{
		out.println(
			rs.getString("id") + ";" +
			rs.getString("login") + ";" +
			rs.getString("nom") + ";" +
			rs.getString("prenom") + ";" +
			rs.getString("datenaiss") + ";"
		);
			
	}

	conn.close();
%>
