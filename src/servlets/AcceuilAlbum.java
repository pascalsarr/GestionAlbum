package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Accueil
 */
@WebServlet("/AcceuilAlbum")
public class AcceuilAlbum extends HttpServlet {
	private static final long	serialVersionUID	= 1L;
	private static final String	VUE_ACCUEIL_INF			= "/WEB-INF/AcceuilAlbum.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		getServletContext().getRequestDispatcher(VUE_ACCUEIL_INF).forward(request,
				response);
	}

}
