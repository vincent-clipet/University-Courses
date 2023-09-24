import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.vince.sqlibrary.*;
import java.sql.*;

@WebServlet("/Login")
public class Login extends HttpServlet
{
	PrintWriter out;
	ServletContext sc;

	public void service( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException
	{
		HttpSession session = req.getSession();
		resetAttributes(session);
		
		out = res.getWriter();
		res.setContentType( "text/html" );
		out.println("<HTML><HEAD><META http-equiv=\"Content-Type\" content=\"text/html;charset=UTF-8\"><TITLE>Login</TITLE></HEAD><BODY>");
		
		
		sc = getServletContext();
		
		// --- Check values ------------------------
		
		String login = (String) req.getParameter("login");
		String password = (String) req.getParameter("password");
		String errorLogin = (String) req.getParameter("errorLogin");
		
		//out.println("<p>DEBUG: login = "+login+"<br />");
		//out.println("DEBUG: password = "+password+"<br />");
		//out.println("DEBUG: errorLogin = "+errorLogin+"</p>");
		
		if (errorLogin == null || errorLogin.equals("")) // first try
		{
			//out.println("<p>DEBUG: 1ere connexion</p>");
			printForm();
		}
		else if (login == null || login.equals("") || password == null || password.equals("")) // Invalid login
		{
			out.println("<p><strong>Login/Password invalide !</strong></p>");
			printForm();
		}
		else // Check login/password
		{
			Database db = getDB();
		
			if (! db.open())
			{
				out.println("Erreur de connexion a la BDD !");
				out.println("</body></html> ");
				return;
			}
			
			String select = "SELECT nom FROM personne WHERE login='"+login+"' AND mdp='"+password+"'";
			ResultSet rs = db.query(select);
			String name = null;

			if (rs != null)
			{
				try
				{
					rs.next();
					name = rs.getString("nom");

				}
				catch (SQLException exc)
				{
					db.getLogger().warning("Error while iterating over ResultSet: " + exc.getMessage());
				}
				finally
				{
					db.close();
				}
			}
			
			boolean loginOk = (name != null);
						
			if (loginOk)
			{
				out.println("<p>DEBUG: user found</p>");
				session.setAttribute("loggedIn", "1");
				session.setAttribute("login", login);
				session.setAttribute("password", password);
				session.setAttribute("name", name);
				//getServletContext().getRequestDispatcher("/Files").forward(req,res);
				res.sendRedirect("/projet8/Files");
			}
			else
			{
				out.println("<p><strong>Erreur de connexion ! Login/Password incorrect !</strong></p>");
				printForm();
			}
		}
		
		out.println("</body></html> ");
	}
	
	
	
	
		
	private void resetAttributes(HttpSession session)
	{
		session.setAttribute("login", null);
		session.setAttribute("password", null);
		session.setAttribute("name", null);
	}
	
	private void printForm()
	{
		out.println("<form method='get' action='/projet8/Login' >");
		out.println("	<input type='text' name='login'> Login <br />");
		out.println("	<input type='text' name='password'> Password <br />");
		out.println("	<input type='hidden' name='errorLogin' value='1'>");
		out.println("	<input type='submit'>");
		out.println("</form>");
	}
	
	private Database getDB()
	{
		Database db = new Database(
			sc.getInitParameter("db_name"),
			sc.getInitParameter("db_prefix"),
			sc.getInitParameter("db_user"),
			sc.getInitParameter("db_password"),
			sc.getInitParameter("db_hostname"),
			sc.getInitParameter("db_dbname"),
			sc.getInitParameter("db_port"),
			sc.getInitParameter("db_driver"),
			sc.getInitParameter("db_url")
		);
		
		return db;
	}
}
