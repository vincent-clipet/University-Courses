package com.vince.sqlibrary;

import java.sql.*;

public abstract class Database
{

	//
	// ATTRIBUTES
	//
	protected String dbType;
	protected String userName;
	protected String password;
	protected String hostName;
	protected String dbName;
	protected int port;
	protected String driverName;
	protected String url;

	protected CustomLogger log;
	protected Connection connection;



	//
	// CONSTRUCTOR
	//
	public Database(String type, String user, String pass, String host, String db, int p, String driver)
	{
		this.log = new CustomLogger("SQLibrary", type);

		this.dbType = type;
		this.userName = user;
		this.password = pass;
		this.hostName = host;
		this.dbName = db;
		this.port = p;
		this.driverName = driver;

		this.url = getUrl();
	}



	//
	// SQL
	//
	public final boolean initialize()
	{
		try
		{
			Class.forName(this.driverName);
			return true;
		}
		catch (ClassNotFoundException e)
		{
			return log.severe(this.dbType + "driver class missing: " + e.getMessage());
		}
	}

	public final boolean open()
	{
		if (! initialize())
			return false;

		try
		{
			this.connection = DriverManager.getConnection(this.url, this.userName, this.password);
			return true;
		}
		catch (SQLException e)
		{
			return log.severe("Could not establish a " + this.dbType + " connection, SQLException: " + e.getMessage());
		}
	}

	public final boolean close()
	{
		if (this.connection == null)
			return log.severe("Could not close connection, because connection is null.");

		try
		{
			connection.close();
			return true;
		}
		catch (SQLException e)
		{
			return log.severe("Could not close connection, SQLException: " + e.getMessage());
		}
	}

	/*public final boolean isOpen()
	{
		if (this.connection == null)
			return false;

		try
		{
			return this.connection.isValid(1);
		}
		catch (SQLException e)
		{
			return false;
		}
	}*/

	public final ResultSet query(String query) throws SQLException
	{
		ResultSet ret = null;

		try
		{
			Statement statement = this.connection.createStatement();
			ret = statement.executeQuery(query);
		}
		catch (SQLException e)
		{
			this.log.warning(e.getMessage());
			e.printStackTrace();
		}

		return ret;
	}
	
	public final DatabaseMetaData getDatabaseMetaData() throws SQLException
	{
		return this.connection.getMetaData();
	}
	
	public final String getCatalog() throws SQLException
	{
		return this.connection.getCatalog();
	}

	public final ResultSet query(PreparedStatement ps)
	{
		ResultSet ret = null;

		try
		{
			ret = ps.executeQuery();
		}
		catch (SQLException e)
		{
			this.log.warning(e.getMessage());
		}

		return ret;
	}

	public final PreparedStatement prepare(String query) throws SQLException
	{
		return this.connection.prepareStatement(query);
	}

	public final int update(String query) throws SQLException
	{
		Statement statement = this.connection.createStatement();
		return statement.executeUpdate(query);
	}

	public final int update(PreparedStatement ps) throws SQLException
	{
		return ps.executeUpdate();
	}



	//
	// UTILS
	//

	protected abstract String getUrl();

}
