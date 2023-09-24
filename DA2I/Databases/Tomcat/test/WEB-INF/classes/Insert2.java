import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.vince.sqlibrary.*;

@WebServlet("/Insert2")
public class Insert2 extends HttpServlet
{
  public void doGet( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException
  {
    PrintWriter out = res.getWriter();
    res.setContentType( "text/html" );
    
    
    out.println(" <head><title>Hello</title><link rel=\"stylesheet\" href=\"./style.css\"></head><body> ");
    
    //
    // Connexion
    //
    PostgreSQL db = new PostgreSQL("clipetv", "moi", "sqlserv", "da2i", 5432);
    
    try
    {
    	db.open();
    }
    catch (Exception ex)
    {
    	out.println("erreur de connexion SQL");
    	return;
    }
    
    String tableName = req.getParameter("table");
    
    if (tableName != null)
    {
    	String[] values = req.getParameterValues("values");
		String query = "INSERT INTO " + tableName + " VALUES(";
	
		int i = 0;
		for(String s : values)
		{
			query += "'" + s + "'";
			
			if (i != values.length - 1)
				query += ",";
				
			i++;
		}
		
		query += ")";
		
		//out.println(query);
    
		try
		{
			/*ResultSet rs = db.query("SELECT * FROM " + tableName + " WHERE 1=2");
			ResultSetMetaData rsmeta = rs.getMetaData();
			int count = rsmeta.getColumnCount();*/
			int added = db.update(query);
			out.println("Enregistrement(s) ajouté(s) : " + added);
		}
		catch (SQLException exc)
		{
			out.println("Erreur lors de l'insertion :<br>" + exc.getMessage());
		}
		finally
		{
			db.close();
		}
    }
    else
    {
    	out.println("Erreur lors de l'insertion ... ");
    	db.close();
    }
    
    out.println("</table></body> ");
  }
  
  public void doPost( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException
  {
  	doGet(req, res);
  }
}
