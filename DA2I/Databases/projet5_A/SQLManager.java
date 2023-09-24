import java.sql.*;

public class SQLManager {

	private Connection conn = null;
	private String user;
	private String password;
	private String driverName = "org.postgresql.Driver";
	private String databaseName;
	private String url;



	public SQLManager(String user, String pass, String dbName)
	{
		this.user = user;
		this.password = pass;
		this.databaseName = dbName;
		this.url = "jdbc:postgresql://sqlserv/" + databaseName;
	}

	public SQLManager(String user, String pass, String dbName, String driver, String url)
	{
		this(user, pass, dbName);
		this.driverName = driver;
		this.url = url;
	}



	// ========================
	// MANAGING
	// ========================

	public boolean loadDriver()
	{
		try
		{
			Class.forName(this.driverName);
			return true;
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public Connection getConnection()
	{
		if (this.conn != null)
			return this.conn;

		try
		{
			this.conn = DriverManager.getConnection(this.url, this.user, this.password);
			System.out.println("Connexion établie.");
			return this.conn;
		}
		catch (SQLException e1)
		{
			e1.printStackTrace();
			return null;
		}
	}

	public boolean close()
	{
		if (getConnection() == null)
			return false;

		try
		{
			conn.close();
			System.out.println("Connexion fermée.");
			return true;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}
		catch (NullPointerException e)
		{
			e.printStackTrace();
			return false;
		}	
	}



	// ========================
	// REQUESTS
	// ========================

	public int createTable(String table, String columns)
	{
		Connection conn = getConnection();

		if (conn == null)
			return -1;

		int ret = -1;
		Statement st = null;

		try	{
			st = conn.createStatement();
		}
		catch (SQLException e) {
			e.printStackTrace();
			return ret;
		}

		try	{
			ret = st.executeUpdate("CREATE TABLE " + table + " (" + columns + ");");
			System.out.println("Table '" + table + "' créée.");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		return ret;
	}

	public int update(String req)
	{
		Connection conn = getConnection();

		if (conn == null)
			return -1;

		int ret = -1;
		Statement st = null;

		try	{
			st = conn.createStatement();
		}
		catch (SQLException e) {
			e.printStackTrace();
			return ret;
		}

		try	{
			ret = st.executeUpdate(req);
			System.out.println("Update effectué.");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		return ret;
	}

	public ResultSet query(String req)
	{
		Connection conn = getConnection();

		if (conn == null)
			return null;

		ResultSet ret = null;
		Statement st = null;

		try	{
			st = conn.createStatement();
		}
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		try	{
			ret = st.executeQuery(req);
			System.out.println("Select effectué.");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		return ret;
	}

	public ResultSetMetaData getTableMetaData(String table)
	{
		Connection conn = getConnection();

		if (conn == null)
			return null;

		ResultSetMetaData ret = null;
		Statement st = null;

		try	{
			st = conn.createStatement();
		}
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		try	{
			ResultSet rs = st.executeQuery("SELECT * FROM " + table + " WHERE 1 = 2;");
			ret = rs.getMetaData();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		return ret;
	}

	public int getLinesNumber(String table)
	{
		Connection conn = getConnection();

		if (conn == null)
			return -1;

		ResultSet rs = null;
		Statement st = null;
		int ret = -1;

		try	{
			st = conn.createStatement();
		}
		catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}

		try	{
			rs = st.executeQuery("SELECT COUNT(*) FROM " + table + ";");
			System.out.println("Count effectué.");
			rs.next();
			ret = rs.getInt(1);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		return ret;
	}



	// ========================
	// UTIL
	// ========================

	public void printStructure(String table)
	{
		ResultSetMetaData meta = getTableMetaData(table);

		if (meta == null)
			return;

		try
		{
			System.out.println("========== " + table + " ==========");
			int count = meta.getColumnCount();
			System.out.println("Colonnes : " + count);

			for (int i = 1; i <= count; i++)
				System.out.println(meta.getColumnName(i) + " (" + meta.getColumnTypeName(i) + ")");

			System.out.println("========== " + table + " ==========");
		}
		catch (SQLException exc)
		{
			exc.printStackTrace();
		}

	}

}