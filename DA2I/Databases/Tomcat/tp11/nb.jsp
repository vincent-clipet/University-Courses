<%@ page import="java.sql.*" %>

<%
	Class.forName("org.postgresql.Driver");
	String url = "jdbc:postgresql://psqlserv/da2i";

	Connection conn = DriverManager.getConnection(url, "clipetv", "moi");
	Statement st = conn.createStatement();
	String query = "SELECT COUNT(*) AS cpt FROM produits";
	ResultSet rs = st.executeQuery(query);

	rs.next();
	out.println(rs.getString("cpt"));
	conn.close();
%>
