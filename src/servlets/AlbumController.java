package servlets;

import java.io.File;
import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.Part;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.AlbumDao;

import entities.Album;


import java.util.Date;



/**
 * Servlet implementation class ParticipantController
 */
@MultipartConfig (
fileSizeThreshold = 1024 * 1024 * 10, 
maxFileSize = 1024 * 1024 * 50, 
maxRequestSize = 1024 * 1024 * 100,
location = "C:/Users/pascal/Desktop/Jeedoc/GestionAlbum/WebContent/uploaded-files/"
		)

@WebServlet({ "/album/add","/album/list","/album/delete","/album/update","/album/view"})
public class AlbumController extends HttpServlet {
	private static final long	serialVersionUID	= 1L;
	private static final String	VUE_AJOUT_ALBUM	= "/WEB-INF/ajouterAlbum.jsp";
	private static final String	VUE_LIST_ALBUM   = "/WEB-INF/ListerAlbum.jsp";
	private static final String	VUE_UPDATE_ALBUM   = "/WEB-INF/ModifierAlbum.jsp";
	private static final String	VUE_GLOBALE   = "/WEB-INF/Global.jsp";
	@EJB
	private AlbumDao dao;
	
   
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	  private int parseInt(String intString) {  
		  try {    
			  return Integer.parseInt(intString);  
			  } catch (NumberFormatException e) { 
				  return 0;    
				  }  
	  }
	  
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
	
		String requestedUrl = request.getServletPath();
	
		if (requestedUrl.equals("/album/add"))
		{
			getServletContext().getRequestDispatcher(VUE_AJOUT_ALBUM)
					.forward(request, response);
		}
		else if  (requestedUrl.equals("/album/delete"))
		{
			String id = request.getParameter("id");
			dao.supprimer(parseInt(id));
			response.sendRedirect("list");
		}else if (requestedUrl.equals("/album/update"))
		{
			String id = request.getParameter("id");
			Album album = dao.getAlbumByid(parseInt(id));
			if (album != null)
			{
				request.setAttribute("album", album);
			}
			getServletContext().getRequestDispatcher(VUE_UPDATE_ALBUM)
					.forward(request, response);
		}else if (requestedUrl.equals("/album/view"))
		    {
			request.setAttribute("album", dao.lister());
			getServletContext().getRequestDispatcher(VUE_GLOBALE)
			.forward(request, response);
		    }
		else {
			request.setAttribute("album", dao.lister());
			getServletContext().getRequestDispatcher(VUE_LIST_ALBUM)
			.forward(request, response);
		}
		
	}
	
    private String extractFilename(Part part)
        {
    	  String contentDisp = part.getHeader("content-disposition"); 
    	  String []items = contentDisp.split(";");
    	     for(String s:items) {
    	    	 if(s.trim().startsWith("filename")) {
    	    		return s.substring(s.indexOf("=") + 2,s.length() - 1); 
    	     }
         }
       return "";
      }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	        {	
		request.setCharacterEncoding("utf-8");
		
		  String titre = request.getParameter("titre");
		  String description = request.getParameter("description");
		  Part part = request.getPart("file");
		  String filename = extractFilename(part);
		  
	      Date datecreation = new Date(System.currentTimeMillis());
		
		  String requestedUrl = request.getServletPath();
		  if (requestedUrl.equals("/album/add"))
		   {
			  
			  Album album = new Album(titre,description,datecreation,filename);
			  dao.ajouter(album);  
		   }
		    else if (requestedUrl.equals("/album/update"))
			{
		    	String id = request.getParameter("id");
				dao.supprimer(parseInt(id));
				Album album = new Album(titre,description,datecreation,filename);
				dao.modifier(album);
			}
		     else if  (requestedUrl.equals("/album/delete"))
			{
				String id = request.getParameter("id");
				dao.supprimer(parseInt(id));
				response.sendRedirect("list");	
			}
			response.sendRedirect(request.getContextPath() + "/album/list");  
		}
		           
     }
    