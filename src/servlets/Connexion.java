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

import java.io.IOException;
import java.io.PrintWriter;
import dao.AdminDao;
import entities.Administrateur;
/**
 * Servlet implementation class Connexion
 */
@WebServlet({ "/login", "/logout" })
public class Connexion extends HttpServlet {
	private static final long	serialVersionUID	= 1L;
	private static final String	VUE_LOGIN			= "/WEB-INF/LogAdmin.jsp";
	private static final String	VUE_ACCEUIL			= "/WEB-INF/accueil.jsp";

	@EJB
	private AdminDao	dao;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		if (request.getServletPath().equals("/login"))
		{
			getServletContext().getRequestDispatcher(VUE_LOGIN).forward(request,
					response);
		}
		else
		{
			request.getSession().invalidate();
			response.sendRedirect("login");
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
		
		response.setContentType("text/html");  
        PrintWriter out = response.getWriter();
		
		String nomadmin = request.getParameter("nomadmin");
		String password = request.getParameter("password");
		

        HttpSession session = request.getSession(false);
        if(session!=null)
        session.setAttribute("name", nomadmin);
        
		Administrateur administrateur = dao.trouver(nomadmin);
		if (administrateur != null && administrateur.getPassword().equals(password))
		{
		
			
			getServletContext().getRequestDispatcher(VUE_ACCEUIL).forward(request,
					response);
			
		}
		else
		{
			out.print("<p style=\"color:red\">Sorry username or password error</p>"); 
			request.setAttribute("administrateur", administrateur);
			getServletContext().getRequestDispatcher(VUE_LOGIN).forward(request,
					response);
		}
    }
}
       

	
		
