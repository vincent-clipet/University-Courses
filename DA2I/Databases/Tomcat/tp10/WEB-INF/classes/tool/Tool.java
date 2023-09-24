package tool;
import java.sql.*;

public class Tool
{	
	//
	// --- Attributes ----------------------------
	//
	Connection conn;
	
	
	
	//
	// --- Constructors ----------------------------
	//
	public Tool(String url, String user, String password, String driver)
	{
		open(url, user, password, driver);
	}
	
	public Tool()
	{
		this("jdbc:postgresql://psqlserv:5432/da2i",
			"clipetv",
			"moi",
			"org.postgresql.Driver"
		);
	}
	
	
	
	//
	// --- SQL ----------------------------
	//
	public boolean open(String url, String user, String password, String driver)
	{
		boolean initialized = false;
		try
		{
			Class.forName(driver);
			initialized = true;
		}
		catch (ClassNotFoundException e)
		{
			System.out.println("driver class missing: " + e.getMessage());
			return false;
		}
		
		if (! initialized)
			return false;

		try
		{
			this.conn = DriverManager.getConnection(url, user, password);
			return true;
		}
		catch (SQLException e)
		{
			System.out.println("Could not establish a connection, SQLException: " + e.getMessage());
			return false;
		}
	}
	
	public boolean close()
	{
		if (this.conn == null)
			System.out.println("Could not close connection, because connection is null.");

		try
		{
			this.conn.close();
			return true;
		}
		catch (SQLException e)
		{
			System.out.println("Could not close connection: " + e.getMessage());
			return false;
		}
	}
	
	public PreparedStatement prepare(String query)
	{
		PreparedStatement ret = null;

		try
		{
			ret = this.conn.prepareStatement(query);
		}
		catch (SQLException e)
		{
			System.out.println("Could not create PreparedStatement: " + e.getMessage());
		}

		return ret;
	}
	
	public ResultSet query(PreparedStatement ps)
	{
		ResultSet ret = null;

		try
		{
			ret = ps.executeQuery();
		}
		catch (SQLException e)
		{
			System.out.println("Invalid query: " + e.getMessage());
		}

		return ret;
	}
	
	
	


	//
	// --- Methods ----------------------------
	//
	public Personne rechPersonne(String patternNom)
	{
		PreparedStatement ps = prepare("SELECT * FROM annuaire WHERE nom LIKE ?");
		Personne p = null;
		
		try
		{
			ps.setString(1, "%" + patternNom);
		}
		catch (SQLException exc)
		{
			return p;
		}
		
		ResultSet rs = query(ps);

		try
		{
			if (rs != null && rs.next())
			{
				int num = rs.getInt("num");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String sexe = rs.getString("sexe");
				String tel = rs.getString("tel");
				String fonction = rs.getString("fonction");
			
				p = new Personne(num, nom, prenom, sexe, tel, fonction);
			}
		}
		catch (SQLException exc)
		{
			System.out.println("aucun resultat");
		}
		
		return p;
	}
	
	
	
	//
	// --- Get & Set ----------------------------
	//	
	public Connection getConnection()
	{
		return this.conn;
	}
	
	
	
	

	public static void main(String[] args)
	{
		Tool tool = new Tool(
			"jdbc:postgresql://psqlserv:5432/da2i",
			"clipetv",
			"moi",
			"org.postgresql.Driver"
		);
		
		if (tool.getConnection() == null)
			return;
			
		Personne p = tool.rechPersonne("uy");
		System.out.println(p);
		
		tool.close();
	}


}
