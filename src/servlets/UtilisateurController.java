package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UtilisateurDao;
import entities.Utilisateur;

/**
 * Servlet implementation class ParticipantController
 */
@WebServlet({ "/users/add", "/users/list" ,"/users/update","/users/delete"})
public class UtilisateurController extends HttpServlet {
	private static final long	serialVersionUID	= 1L;
	private static final String	VUE_AJOUT_UTILISATEUR	= "/WEB-INF/ajouterUtilisateur.jsp";
	private static final String	VUE_LIST_UTILISATEUR	= "/WEB-INF/listerUtilisateur.jsp";
	private static final String	VUE_UPDATE_UTILISATEUR	= "/WEB-INF/modifierUtilisateur.jsp";

	

	@EJB
	private UtilisateurDao		dao;
	

	
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
	
		if (requestedUrl.equals("/users/add"))
		{
			getServletContext().getRequestDispatcher(VUE_AJOUT_UTILISATEUR)
					.forward(request, response);
		}
		else if  (requestedUrl.equals("/users/delete"))
		{
			String id = request.getParameter("id");
			dao.supprimer(parseInt(id));
			response.sendRedirect("list");	
		}else if (requestedUrl.equals("/users/update"))
		{
			String id = request.getParameter("id");
			Utilisateur utilisateur = dao.getUserByLogin(parseInt(id));
			if (utilisateur != null)
			{
				request.setAttribute("utilisateur", utilisateur);
			}
			getServletContext().getRequestDispatcher(VUE_UPDATE_UTILISATEUR)
					.forward(request, response);
		}
		
		
		else
		{
			request.setAttribute("utilisateurs", dao.lister());
			getServletContext().getRequestDispatcher(VUE_LIST_UTILISATEUR)
			.forward(request, response);
		}
	}
	



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
	
		
		String requestedUrl = request.getServletPath();		
			if (requestedUrl.equals("/users/add"))
			{
				Utilisateur utilisateur = new Utilisateur(nom,prenom, login,password);
				dao.ajouter(utilisateur);
	        }
			else if (requestedUrl.equals("/users/update"))
			{
				String id = request.getParameter("id");
				dao.supprimer(parseInt(id));
				Utilisateur utilisateur = new Utilisateur(nom,prenom, login,password);
				dao.modifier(utilisateur);
				
			} 

			
			response.sendRedirect(request.getContextPath() + "/users/list");

     }
}
