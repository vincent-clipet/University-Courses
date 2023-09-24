package com.vince.sqlibrary;

public class Oracle extends Database
{

	public Oracle(String user, String pass, String host, String db, int p)
	{
		super("[Oracle] ", user, pass, host, db, p, "oracle.jdbc.driver.OracleDriver");
	}

	@Override
	protected String getUrl()
	{
		return "jdbc:oracle:thin:@" + this.hostName + ":" + this.port + ":" + this.dbName;
	}
	
}