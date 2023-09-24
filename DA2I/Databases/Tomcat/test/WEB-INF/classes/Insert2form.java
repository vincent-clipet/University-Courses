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
    
    String tableName = req.getParameter("table");
    
    if (tableName != null)
    {
		try
		{
			ResultSet rs = db.query("SELECT * FROM " + tableName + " WHERE 1=2");
			ResultSetMetaData rsmeta = rs.getMetaData();
			int count = rsmeta.getColumnCount();
		
			out.println("<form action='/test/Insert2' method='get' >");
			out.println("Table : " + tableName);
		
			for(int i=1; i <= count; i++)
			{
				String colName = rs.getMetaData().getColumnName(i);
				out.println("	<br> " + colName + ": <input type='text' size='8' name='values' >");
			}
		
			out.println("	<input type='hidden' name='table' value='"+tableName+"' >");
			out.println("	<input type='submit'>");
			out.println("</form><hr>");
		}
		catch (SQLException exc)
		{
			out.println("Table inexistante<br>" + exc.getMessage());
		}
		finally
		{
			db.close();
		}
    }
    else
    {
    	out.println("Table inexistante<br>");
    }
    
    out.println("</table></body> ");
  }
  
  public void doPost( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException
  {
  	doGet(req, res);
  }
}
