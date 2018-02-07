package edu.cvtc.web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.base.Strings;

import edu.cvtc.web.dao.MovieDao;
import edu.cvtc.web.dao.impl.MovieDaoException;
import edu.cvtc.web.dao.impl.MovieDaoImpl;
import edu.cvtc.web.model.Movie;


/**
 * Servlet implementation class AddMovieController
 */
@WebServlet("/AddMovie")
public class AddMovieController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
String target = null;
		
		try {
			
			final String title = request.getParameter("title");
			final String director = request.getParameter("director");
			final String lengthInMinutesString = request.getParameter("lengthInMinutes");
			
			//Validate data
			if(Strings.isNullOrEmpty(title)
					|| Strings.isNullOrEmpty(director)
					|| Strings.isNullOrEmpty(lengthInMinutesString)) {
				
				request.setAttribute("message", "You must complete all fields to submit the form.");
				target = "error.jsp";
				
			} else {
				
				final int lengthInMinutes = Integer.parseInt(lengthInMinutesString);
				final Movie movie = new Movie(title, director, lengthInMinutes);
				
				final MovieDao movieDao = new MovieDaoImpl();
				movieDao.insertMovie(movie);
				
				request.setAttribute("message", "The movie has been added to the database." );
				target = "success.jsp";
			}
			
		} catch(NumberFormatException e) {
			e.printStackTrace();
			request.setAttribute("message", "Error: You must enter a numeric value for lengthInMinutes.");
			target = "error.jsp";
			
		} catch (MovieDaoException e) {
			e.printStackTrace();
			request.setAttribute("message", e.getMessage());
			target = "error.jsp";
		}
		
		request.getRequestDispatcher(target).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
