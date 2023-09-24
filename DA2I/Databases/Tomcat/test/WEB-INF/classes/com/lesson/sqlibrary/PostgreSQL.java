package com.vince.sqlibrary;

public class PostgreSQL extends Database
{
	
	public PostgreSQL(String user, String pass, String host, String db, int p)
	{
		super("[PosgreSQL] ", user, pass, host, db, p, "org.postgresql.Driver");
	}

	@Override
	protected String getUrl()
	{
		return "jdbc:postgresql://" + this.hostName + ":" + this.port + "/" + this.dbName;
	}

}