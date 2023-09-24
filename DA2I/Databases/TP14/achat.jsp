<html>
<head> <%@ page import="java.sql.*" %> </head>
<body>
<%
	String pers = request.getParameter("pers");
	String prod = request.getParameter("prod");
%>

<h1> Achat du produit <%=prod%> par mr <%=pers%> </h1>

<%
	Class.forName("org.postgresql.Driver");
	String url="jdbc:postgresql://localhost/template1";
	Connection con=DriverManager.getConnection(url,"user","password");
	
	Statement st = con.createStatement();
	String r1="select qute from produit where prod=’"+prod+"’";
	ResultSet rs =st.executeQuery(r1);
	rs.next();
	
	if (rs.getInt("qute")>0)
	{
		String r2="update produit set qute=qute-1 where prod=’"+prod+"’";
		st.executeUpdate(r2);
		String r3="update compte set solde=solde+100 where pers=’"+pers+"’";
		st.executeUpdate(r3);
		out.println("<h2>traitement effectué</h2>");
	}
	else
		out.println("<h2>traitement impossible</h2>");
		
	con.close();
%>

</body>
</html>

