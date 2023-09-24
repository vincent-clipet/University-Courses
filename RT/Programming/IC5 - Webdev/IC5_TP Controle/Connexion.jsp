<%

String user = "login";
String password = "progtr00";
String host = "localhost";
String dbName = "postgres";
String schemaPath = "caddie";

try
{
Class.forName("org.postgresql.Driver");
}
catch (ClassNotFoundException exc)
{
	System.err.println("Driver not found.");
	exc.printStackTrace();
}

Connection c = null;

try
{
	c = DriverManager.getConnection("jdbc:postgresql://"+host+"/"+dbName, user, password);
}
catch (SQLException e)
{
	System.err.println("Impossible to connect to database.");
}


Statement s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY,ResultSet.HOLD_CURSORS_OVER_COMMIT);

s.executeUpdate("SET SEARCH_PATH=" + schemaPath + ",PG_CATALOG");
String req = "SELECT * FROM article;"
// String req = "SELECT *,extract(year from age(datenaissance)) AS age, age(datenaissance) AS \"age precis\" FROM client"; 

ResultSet r = s.executeQuery(req);
ResultSetMetaData m = rs.getMetaData();
int cols = m.getColumnCount();
// m.getColumnName(i)

int id = r.getInt(0);
%>