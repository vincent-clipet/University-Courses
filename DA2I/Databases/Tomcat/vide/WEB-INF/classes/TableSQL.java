// Servlet Test.java  de test de la configuration
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.sql.*;

@WebServlet("/servlet/TableSQL")
public class TableSQL extends HttpServlet
{
  public void doGet( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException
  {
    PrintWriter out = res.getWriter();
    res.setContentType( "text/html" );
    
    out.println("1");
    
	final String user = "clipetv";
	final String password = "moi";
	final String driverName = "org.postgresql.Driver";
	final String databaseName = "da2i";
	final String url = "jdbc:postgresql://sqlserv/" + databaseName; 
	SQLManager sql = new SQLManager(user, password, databaseName, driverName, url);
	
	out.println("2");
	
	// DRIVER
	if (! sql.loadDriver())
		return;
	
	out.println("3");
	
	// CONNECTION
	sql.getConnection();

	out.println("4");
	
    
    out.println(" <head><title>Hello</title><link rel=\"stylesheet\" href=\"/vide/style.css\"></head><body><center> ");
    
    out.println("<table>");
    
    
    // SELECT
	ResultSet rs = sql.query("SELECT * FROM test LIMIT 10");
	try
	{
		int i = 0;
		while (rs.next())
		{
			i++;
			out.println("<tr class=\"color" + (i%2 + 1) + "\">");
    		out.println("<td>" + rs.getString("id") + "</td>");
	    	out.println("<td>" + rs.getString("nom") + "</td>");
	    	out.println("<td>" + rs.getString("prenom") + "</td>");
	    	out.println("</tr>");
		}
	}
	catch (SQLException e)
	{
		e.printStackTrace();
	}
    
    out.println("</table>");
    out.println(" </body> ");
  }
  
  public void doPost( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException
  {
  	doGet(req, res);
  }
 }
