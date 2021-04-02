package servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.UtilisateurDao;
import entities.Utilisateur;

import java.io.PrintWriter;
/**
 * Servlet implementation class UserConnect
 */
@WebServlet("/UserConnect")
public class UserConnect extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String	VUE_IDENT			= "/WEB-INF/LogUser.jsp"; 
	private static final String	VUE_ALBUM			= "/WEB-INF/AcceuilAlbum.jsp"; 
	
	
	@EJB
	private UtilisateurDao	dao;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getServletPath().equals("/UserConnect"))
		{
			getServletContext().getRequestDispatcher(VUE_IDENT).forward(request,
					response);
		}
		else
		{
			request.getSession().invalidate();
			response.sendRedirect("UserConnect");
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
        PrintWriter out = response.getWriter();
		
		
		String login = request.getParameter ("login");  
        String password = request.getParameter ("password"); 
        
        
        
        HttpSession session = request.getSession(false);
        if(session!=null)
        session.setAttribute("name", login);
        
        
		Utilisateur utilisateur = dao.TrouverUser(login);
		if (utilisateur != null && utilisateur.getPassword().equals(password))
		
            {  

			getServletContext().getRequestDispatcher(VUE_ALBUM).forward(request,
					response);
           }  
        else{  
        	out.print("<p style=\"color:red\">Sorry username or password error</p>");  
        	getServletContext().getRequestDispatcher(VUE_IDENT).forward(request,
					response); 
        }
	}

}
