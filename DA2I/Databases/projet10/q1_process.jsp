<%@ page import="java.sql.*" %>
<%@ page errorPage="error.jsp" %>
<%
	// Init param
	String db_url = application.getInitParameter("db_url");
	String db_driver = application.getInitParameter("db_driver");
	String db_password = application.getInitParameter("db_password");
	String db_user = application.getInitParameter("db_user");
	
	// Init DB
	Class.forName(db_driver);
	Connection conn = DriverManager.getConnection(db_url, db_user, db_password);
	Statement st = conn.createStatement();
	
	
	// Request
	String query = "SELECT COUNT(*) AS people FROM personne";
	ResultSet rs = st.executeQuery(query);

	rs.next();
	out.println(rs.getString("people"));
	conn.close();
%>
