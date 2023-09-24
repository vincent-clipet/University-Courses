package com.vince.sqlibrary;

import java.util.logging.Logger;

public class CustomLogger
{
	Logger log;
	String prefix;

	public CustomLogger(String name, String prefix)
	{
		this.log = Logger.getLogger(name);
		this.prefix = prefix;
	}

	public boolean log(String s)
	{
		this.log.info(this.prefix + s);
		return true;
	}

	public boolean severe(String s)
	{
		this.log.severe(this.prefix + s);
		return false;
	}

	public boolean warning(String s)
	{
		this.log.warning(this.prefix + s);
		return false;
	}
}
