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
		
		Class.forName("org.postgresql.Driver");
		String url = "jdbc:postgresql://psqlserv/da2i";
		
		Connection conn = DriverManager.getConnection(url, "clipetv", "moi");
		Statement st = con.createStatement();
		String query = "SELECT COUNT(*) AS cpt FROM produits");
		ResultSet rs = st.executeQuery(query);
		
		rs.next();
		out.println(rs.getString("cpt"));
		conn.close();
		
	}
}
