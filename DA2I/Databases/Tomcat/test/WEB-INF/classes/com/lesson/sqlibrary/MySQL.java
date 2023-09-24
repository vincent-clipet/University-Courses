package com.vince.sqlibrary;

public class MySQL extends Database
{

	public MySQL(String user, String pass, String host, String db,	int p)
	{
		super("[MySQL] ", user, pass, host, db, p, "com.mysql.jdbc.Driver");
	}

	@Override
	protected String getUrl()
	{
		return "jdbc:mysql://" + this.hostName + ":" + this.port + "/" + this.dbName;
	}

}