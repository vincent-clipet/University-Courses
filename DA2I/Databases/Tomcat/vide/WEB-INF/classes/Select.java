// Servlet Test.java  de test de la configuration
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/servlet/Select")
public class Select extends HttpServlet
{
  public void doGet( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException
  {
    PrintWriter out = res.getWriter();
    res.setContentType( "text/html" );
    
    out.println(" <head><title>Hello</title><link rel=\"stylesheet\" href=\"./style.css\"></head><body><center> ");
    
    out.println("<table>");
    
    for (int i = 31; i < 100; i++)
    {
    	out.println("<tr class='" + (i%2 + 1) + "'>");
    	out.println("<td>" + i + "</td>");
    	out.println("<td>" + (char)i + "</td>");
    	out.println("</tr>");
    }
    
    out.println("</table>");
    
    out.println(" </body> ");
  }
  
  public void doPost( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException
  {
  	doGet(req, res);
  }
}
