import java.sql.*;

public class TestDB
{

	public static void main(String[] args)
	{
		Connection conn = null;

		final String user = "clipetv";
		final String password = "moi";
		final String driverName = "org.postgresql.Driver";
		final String databaseName = "da2i";
		final String url = "jdbc:postgresql://sqlserv/" + databaseName; 

		SQLManager sql = new SQLManager(user, password, databaseName);
		
		// DRIVER
		if (! sql.loadDriver())
			return;
		
		// CONNECTION
		sql.getConnection();
		
		// CREATE TABLE
		//sql.createTable("test", "id SERIAL, nom TEXT, prenom TEXT, CONSTRAINT pk_test PRIMARY KEY (id)");
		
		// UPDATE
		//sql.update("INSERT INTO test(id, nom, prenom) VALUES ('1', 'test', 'test2');");
		//sql.update("INSERT INTO test(id, nom, prenom) VALUES ('2', 'test4545', 'test5478785');");
		//sql.update("INSERT INTO test(id, nom, prenom) VALUES ('3', 'test4789772', 'test8784');");
		
		// SELECT
		ResultSet rs = sql.query("SELECT * FROM test LIMIT 10");
		try
		{
			while (rs.next())
			{
				System.out.println("id: " + rs.getString("id") + "; nom: " + rs.getString("nom") + "; " + rs.getString("prenom"));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		// COUNT
		System.out.println("Count : " + sql.getLinesNumber("test"));
		
		// STRUCTURE
		sql.printStructure("test");
		
		// CLOSE
		sql.close();
	}

}
