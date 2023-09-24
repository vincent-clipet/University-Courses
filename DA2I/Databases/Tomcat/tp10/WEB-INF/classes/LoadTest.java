import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/LoadTest")
public class LoadTest extends HttpServlet
{

	private int i = 0;


	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		HttpSession session = req.getSession(true);
		Integer cpt = (Integer)session.getAttribute("compteur");
		cpt = new Integer(cpt == null ? 1 : cpt.intValue() + 1);
		session.setAttribute("compteur", cpt);
		
		this.i++;
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<html><body>");
		out.println("<h2> User : " + cpt + "</h2>");
		out.println("<h3> Total : " + i + "</h2>");
		out.println("</body></html>");
	}
}
