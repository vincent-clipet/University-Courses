import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.vince.sqlibrary.*;

@WebServlet("/Insert2form")
public class Insert2form extends HttpServlet
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
    
    
    //
    // Req.
    //    
    try
    {
    	DatabaseMetaData meta = db.getDatabaseMetaData();
    	ResultSet tables = meta.getTables(db.getCatalog(), null, "%", null);
    	
    	while(tables.next())
    	{
    		out.println("<form action='/test/Insert2' method='post' >");
    	
    		for(int i=0; i<tables.getMetaData().getColumnCount();i++)
    		{
    			String colName = tables.getMetaData().getColumnName(i+1);
				out.println("	<p> " + colName + ": </p><input type='text' 	size='8' 	name='" + colName + "' >");
   			}
   			
   			out.println("	<input type='submit'>");
   			out.println("</form>");
    	}
    }
    catch (SQLException exc)
    {
    	out.println("erreur requete<br>" + exc.getMessage());
    	out.println(exc.getStackTrace());
    }
    
    out.println("</table></body> ");
  }
  
  public void doPost( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException
  {
  	doGet(req, res);
  }
}
