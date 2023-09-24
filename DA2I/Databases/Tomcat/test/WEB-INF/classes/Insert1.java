import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.vince.sqlibrary.*;
import java.sql.*;

@WebServlet("/Insert1")
public class Insert1 extends HttpServlet
{
  public void doGet( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException
  {
    PrintWriter out = res.getWriter();
    res.setContentType( "text/html" );
    
    String nom = req.getParameter("nom");
    String prenom = req.getParameter("prenom");
    String id = req.getParameter("id");
    
    out.println(" <head><title>Hello</title><link rel=\"stylesheet\" href=\"./style.css\"></head><body> ");
    
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
    
    try
    {
	    int count = db.update("INSERT INTO test(id, nom, prenom) VALUES ("+id+", '"+nom+"', '"+prenom+"')");
	    
		out.println("Valeurs insérées : " + count);
    }
    catch (SQLException exc)
    {
    	out.println("erreur requete<br>" + exc.getMessage());
    	exc.printStackTrace();
    }
    finally
	{
		db.close();
	}
    
    out.println("</table></body> ");
  }
  
  public void doPost( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException
  {
  	doGet(req, res);
  }
}
