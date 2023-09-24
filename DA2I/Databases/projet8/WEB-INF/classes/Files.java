import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.*;
import org.apache.commons.fileupload.servlet.*;

import java.sql.*;
import java.util.*;

@WebServlet("/Files")
public class Files extends HttpServlet
{
	PrintWriter out;
	ServletContext sc;

	public void service( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException
	{
		//
		// INIT
		//
		HttpSession session = req.getSession();
		out = res.getWriter();
		
		// DEBUG
		/*String login = "admin";
		String password = "root";
		String name = "Administrateur";*/
		String login = (String) session.getAttribute("login");
		String password = (String) session.getAttribute("password");
		String name = (String) session.getAttribute("name");
		
		if (login == null || password == null || name == null)
		{
			out.println("<p><strong>Impossible d'acceder a la page : vous n'etes pas connecte !</strong></p>");
			out.println("</body></html> ");
			return;
		}
		
		out = res.getWriter();
		res.setContentType( "text/html" );
		out.println("<HTML><HEAD><META http-equiv=\"Content-Type\" content=\"text/html;charset=UTF-8\"><TITLE>Files</TITLE></HEAD><BODY>");
		
		sc = getServletContext();
		
		
		
		//
		// CREATE USERDIR
		//
		
		File newUserDir = new File(sc.getRealPath("/") + "/users/" + name + "/");
		boolean result = newUserDir.mkdir();
		
		
		
		//
		// UPLOAD
		//
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		
		if (isMultipart)
		{
			// Create a factory for disk-based file items
			DiskFileItemFactory factory = new DiskFileItemFactory();
			File repository = (File) sc.getAttribute("javax.servlet.context.tempdir");
			factory.setRepository(repository);
		
			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);
		
			try
			{
				// Parse the request
				List<FileItem> items = upload.parseRequest(req);
		
				// Process the uploaded items
				Iterator<FileItem> iter = items.iterator();
				while (iter.hasNext())
				{
					FileItem item = iter.next();

					if (! item.isFormField())
					{
						//String fieldName = item.getFieldName();
						String fileName = item.getName();
						//String contentType = item.getContentType();
						//boolean isInMemory = item.isInMemory();
						//long sizeInBytes = item.getSize();
					
						String path = sc.getRealPath("/") + "/users/" + name + "/" + fileName;
				
						File uploadedFile = new File(path);
		   	 			item.write(uploadedFile);
		   	 			
		   	 			out.println("<strong>Fichier recu</strong>");
					}
				}
			}
			catch (Exception ex)
			{
            	out.println("<strong>Erreur pendant l'envoi !</strong>");
            }
		}
		
		
				
		
		
		// ------------------------------
		
		
		File folder = new File(sc.getRealPath("/") + "/users/" + name);
		String path = folder.getPath();
		//out.println(path + "<br />");
		String[] list = folder.list();
		
		out.println("<hr>");
		
		if (list.length == 0)
			out.println("Aucun fichier");
		else
		{
			out.println("<ul>");
		
			for (String s : list)
			{	
				if ((new File(path + "/" + s)).isDirectory())
					out.println("<li><u>" + s + "</u></li>");
				else
					out.println("<li>" + s + "</li>");
			}
			
			out.println("</ul>");
		}
		
		out.println("<p></p><hr><p></p>");
		printForm();
		
		// ------------------------------
		
		
		out.println("</body></html> ");
	}
	
	
	
	
	private void printForm()
	{
		out.println("<form method='post' action='/projet8/Files' enctype='multipart/form-data'>");
		out.println("	<input type='hidden' name='MAX_FILE_SIZE' value='1024' />");
		out.println("	<input type='file' name='filename' /><br />");
		out.println("	<input type='submit' name='Envoyer' />");
		out.println("</form>");
	}
	
}
