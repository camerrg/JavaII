package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.InchesFeetConverter;

/**
 * Servlet implementation class getFeetServlet
 */
@WebServlet("/getFeetServlet")
public class getFeetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getFeetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userFeet = request.getParameter("userFeet");
		
		InchesFeetConverter userMeasure = new
		InchesFeetConverter(Integer.parseInt(userFeet));
		
				
		request.setAttribute("userFeetInput", userMeasure);
		
		getServletContext().getRequestDispatcher("/resultFeet.jsp").forward(request, response);
		
		PrintWriter writer = response.getWriter();
		writer.println(userMeasure.tooString());
		writer.close();
		
		
		
	}

}
